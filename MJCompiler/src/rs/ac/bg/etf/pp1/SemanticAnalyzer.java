package rs.ac.bg.etf.pp1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = null;
	Obj currentNamespace = null;
	Obj currDesignator = null;
	boolean returnFound = false;
	boolean errorDetected = false;
	boolean mainDeclared = false;
	// Da li je u pitanju niz
	boolean isCurrVarArray = false;
	int nVars;
	// Trenutni tip promenljive koji se parsira
	Struct currType = null;
	int forLoopCount = 0;
	Struct firstDesignatorElem = null;
	Obj calledMethod = null;
	
	//mapa ime metode i mapa indeks parametra i tip
	Map<String, Map<Integer, Integer>> methodParams = new HashMap<>();
	Map<Integer, Integer> currMethodMap;
	int currParamInd, calledParamInd;
	Set<String> currentMethodParamNames;
	
	//red pozvanih metoda
	Stack<Obj> calledMethodStack = new Stack<>();
	
	// ------------------- ERROR LOGGING --------------------------------------------
	
	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	// ----------------------- VARIABLE DECLARATION ------------------------------
	
	public void visit(VarDeclType varDeclType) {
		currType = varDeclType.getType().struct;
	}
	
	public void visit(VarDeclTmp varDecl){
		varDeclCount++;
		String namespacePart = "";
		
		if(currentNamespace != null) {
			namespacePart = currentNamespace.getName() + "::";
		}
		
		Obj varNode = Tab.find(namespacePart + varDecl.getVarName());
		
		// Okej je da ne postoji ili da postoji globalna promenljiva ali mi definisemo lokalnu
		if(varNode == Tab.noObj || (varNode.getLevel() == 0 && currentMethod != null)) {
			if(currentMethod == null) {
				String message = "Deklarisana globalna promenljiva "+ varDecl.getVarName();
				if(currentNamespace != null) {
					message += " iz namespace-a " + currentNamespace.getName();
				}
				report_info(message, varDecl);
			}else {
				// VEC POKRIVENO PRVIM IFOM
				// TODO Provera da li se neki parametar u funkciji vec zove tako
//				if(currentMethodParamNames != null && currentMethodParamNames.contains(varNode.getName())) {
//					report_error("Ime lokalne promenljive se poklapa sa imenom formalnog parametra.", varDecl);
//				}
				report_info("Deklarisana lokalna promenljiva "+ varDecl.getVarName() + " u metodi " + currentMethod.getName(), varDecl);
			}
			Struct type = currType;
			if(isCurrVarArray) {
				type = new Struct(Struct.Array, currType);
				isCurrVarArray = false;
			}
		
			Obj n = Tab.insert(Obj.Var, namespacePart + varDecl.getVarName(), type);
			
			//lokalna promenljiva
			if(currentMethod != null) {
				n.setLevel(1);
			}else {
				n.setLevel(0);
			}
		}else {
			report_error("Promeljiva " + varDecl.getVarName() + " se opet deklarise", varDecl);
		}
		
	}
	
	
	public void visit(SquareBraces sq) {
		isCurrVarArray = true;
	}
	
	// ---------------------- CONST VARIABLE DECLARATION ---------------------------
	
    public void visit(ConstDeclType constType) {
    	currType = constType.getType().struct;
    }
	
    
	public void visit(ConstDeclTmp constDecl){
		String namespacePart = "";
		if(currentNamespace != null) {
			namespacePart = currentNamespace.getName() + "::";
		}
		
		varDeclCount++;
		if(!constDecl.getConstType().struct.equals(currType)) {
			report_error("Konstanta " + constDecl.getTypeName() + " nije istog tipa kao dodeljena vrednost", constDecl);
		}
		
		Obj constNode = Tab.find(namespacePart + constDecl.getTypeName());
		// Ako ne postoji jer moze biti samo globalna
		if(constNode == Tab.noObj || constNode.getLevel() != 0) {
			String message = "Deklarisana globalna konstanta "+ constDecl.getTypeName();
			if(currentNamespace != null) {
				message += " iz namespace-a " + currentNamespace.getName();
			}
			report_info(message, constDecl);
			
			Obj con = Tab.insert(Obj.Con, namespacePart + constDecl.getTypeName(), currType);
			
			// Postavljanje vrednosti konstante u adr polje
			ConstType t = constDecl.getConstType();
			if(t instanceof NumConstType) {
				NumConstType nt = (NumConstType)t;
				con.setAdr(nt.getN1());
			}else if(t instanceof CharConstType) {
				CharConstType nt = (CharConstType)t;
				con.setAdr(nt.getC1());
			}else {
				BoolConstType nt = (BoolConstType)t;
				con.setAdr(nt.getB1()==true?1:0);
			}
			
		}else {
			report_error("Konstanta " + constDecl.getTypeName() + " se opet deklarise", constDecl);
		}
		
	}
	
	// ----------------------------- METHOD DECLARATION ---------------------------------------------
	
	// Helper function
	private Obj methodDeclarationVisit(Struct methType, String methName) {
		String namespacePart = "";
		if(currentNamespace != null) {
			namespacePart = currentNamespace.getName() + "::";
		}
		
		Obj ob = Tab.find(namespacePart + methName);
		
		// Ako metoda sa istim imenom ili promenljiva vec ne postoji
		if(ob == Tab.noObj) {
			currentMethod = Tab.insert(Obj.Meth, namespacePart + methName, methType);
			Tab.openScope();
			currParamInd = 0;
			currMethodMap = new HashMap<>();
			currentMethodParamNames = new HashSet<>();
			return currentMethod;
		}else {
			report_error("Metoda ili promenljiva sa imenom " + namespacePart + methName + " je vec deklarisana u istom opsegu!", null);
			return null;
		}
	}
	
	public void visit(MethodTypeDecl methodTypeName){
		if(methodTypeName.getMethodName().equals("main")) {
			report_error("Main metoda mora biti void tipa!", methodTypeName);
		}
    	methodTypeName.obj = methodDeclarationVisit(methodTypeName.getType().struct, methodTypeName.getMethodName());
		report_info("Obradjuje se funkcija " + methodTypeName.getMethodName(), methodTypeName);
    }
	
	public void visit(MethodTypeVoid methodTypeName){
		if(methodTypeName.getMethodName().equals("main")) {
			mainDeclared = true;
		}
    	methodTypeName.obj = methodDeclarationVisit(Tab.noType, methodTypeName.getMethodName());
		report_info("Obradjuje se funkcija " + methodTypeName.getMethodName(), methodTypeName);
    }
    
    public void visit(MethodDecl methodDecl){
    	if(currentMethod == null)return;
    	
    	if(!returnFound && currentMethod.getType() != Tab.noType){
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", methodDecl);
    	}
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	// Nema formalne parametre
    	if(currParamInd == 0) currMethodMap = null;
    	methodParams.put(currentMethod.getName(), currMethodMap);
    	
    	currentMethod.setLevel(currParamInd);
    	methodDecl.obj = currentMethod;
    	
    	returnFound = false;
    	currentMethod = null;
    	currParamInd = 0;
    	currMethodMap = null;
    	currentMethodParamNames = null;
    }
    
    
    // ----------------------------- NAMESPACE ---------------------------------------------
    
	
	//TODO kog tipa da bude namespace?
	public void visit(NamespaceName namespaceName) {
		Obj namespaceObj = Tab.find("namespace");
		currentNamespace = Tab.insert(namespaceObj.getKind(), namespaceName.getNamespaceName(), namespaceObj.getType());
		//Tab.openScope();
		
		report_info("Obradjuje se namespace " + namespaceName.getNamespaceName(), namespaceName);
	}
	
	public void visit(NamespaceDecl namespaceDecl) {
		//Tab.chainLocalSymbols(currentNamespace);
    	//Tab.closeScope();
    	currentNamespace = null;
	}
	
	// --------------------------------- PROGRAM --------------------------------------------
	
	public void visit(ProgName progName){
//    	Struct arrayStruct = new Struct(Struct.Array);
//    	Struct noneStruct = new Struct(Struct.None);
//    	arrayStruct.setElementType(noneStruct);
    	
    	//Tab.insert(Obj.Type, "null", noneStruct);
    	Tab.insert(Obj.Type, "bool", new Struct(Struct.Bool));
    	Tab.insert(Obj.Type, "namespace", new Struct(Struct.Interface)); // za namespace
    	
    	// Pre declared methods
    	Map<Integer, Integer> ordMethodMap = new HashMap<>();
    	ordMethodMap.put(0, 2);
    	methodParams.put("ord", ordMethodMap);
    	
    	Map<Integer, Integer> chrMethodMap = new HashMap<>();
    	chrMethodMap.put(0, 1);
    	methodParams.put("chr", chrMethodMap);
    	
    	Map<Integer, Integer> lenMethodMap = new HashMap<>();
    	lenMethodMap.put(0, 16);
    	methodParams.put("len", lenMethodMap);
    	
    	
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program){
    	if(!mainDeclared) {
    		report_error("Main funkcija nije pronadjena!", null);
    	}
    	
    	nVars += Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
    
    // ------------------------------------ CONST TYPES ---------------------------------------------------
    
    public void visit(NumConstType numConst) {
    	report_info("Simbolicka konstanta  " + numConst.getN1(), numConst);
    	numConst.struct = Tab.intType;
    }
    
    public void visit(CharConstType charConst) {
    	report_info("Simbolicka konstanta " + charConst.getC1(), charConst);
    	charConst.struct = Tab.charType;
    }
    
    public void visit(BoolConstType boolConst) {
    	report_info("Simbolicka konstanta " + boolConst.getB1(), boolConst);
    	boolConst.struct = Tab.find("bool").getType();
    }
    
    
    // ------------------------------------- METHOD FORMAL PARAMS -------------------------------------------
    
    //TODO proveri za level
    public void visit(FormalParamsBasic form) {
    	if(currentMethodParamNames == null)return;
    	
    	String namespacePart = "";
    	// Proveravamo da nije vec definisan parametar funkcije sa istim imenom
		if(!currentMethodParamNames.contains(form.getVarName())) {
			currentMethodParamNames.add(form.getVarName());
			Struct type = form.getType().struct;
			int kind = type.getKind();
			if(isCurrVarArray) {
				type = new Struct(Struct.Array, type);
				kind += 10;
				isCurrVarArray = false;
			}
			
			if(currentNamespace != null) {
				namespacePart = currentNamespace.getName() + "::";
			}
			
			Obj ob = Tab.insert(Obj.Var, namespacePart + form.getVarName(), type);
			
			ob.setLevel(1);
			
			currMethodMap.put(currParamInd, kind);
		}else {
			report_error("Parametar " + form.getVarName() + " se opet deklarise u funkciji " + currentMethod.getName(), form);
			currMethodMap.put(currParamInd, Obj.NO_VALUE);
		}
		currParamInd++;
    }
    
    
    // ----------------------------------- TYPE ----------------------------------------
    
    public void visit(TypeIdent type){
    	Obj typeNode = Tab.find(type.getTypeName());
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", type);
    		type.struct = Tab.noType;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			type.struct = typeNode.getType();
    			report_info("Pronadjen tip "+ typeNode.getName(), type);
    		}else{
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
    		}
    	}
    }
    
    public void visit(TypeNamespaceIdent type){
    	String fullName = type.getNamespaceName() + "::" + type.getTypeName();
    	Obj typeNode = Tab.find(fullName);
    	if(typeNode == Tab.noObj){
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", type);
    		type.struct = Tab.noType;
    	}else{
    		if(Obj.Type == typeNode.getKind()){
    			type.struct = typeNode.getType();
    			report_info("Pronadjen tip "+ typeNode.getName(), type);
    		}else{
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
    		}
    	}
    }
    
    
    // ---------------------------------- STATEMENTS --------------------------------------------
    
    public void visit(BreakStmt br) {
    	if(forLoopCount == 0) {
    		report_error("Break se nalazi izvan for petlje!", br);
    	}
    }
    
    public void visit(ContinueStmt con) {
    	if(forLoopCount == 0) {
    		report_error("Continue se nalazi izvan for petlje!", con);
    	}
    }
    
    public void visit(ReturnStmtExpr returnExpr){
    	if(currentMethod == null) {
    		report_error("Greska na liniji " + returnExpr.getLine() + " : " + "return izraz se nalazi izvan opsega bilo koje funkcije", returnExpr);
    		return;
    	}
    	
    	returnFound = true;
    	Struct currMethType = currentMethod.getType();
    	if(!currMethType.compatibleWith(returnExpr.getExpr().struct)){
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), returnExpr);
    	}
    }
    
    public void visit(ReturnStmt returnExpr){
    	if(currentMethod == null) {
    		report_error("Greska na liniji " + returnExpr.getLine() + " : " + "return izraz se nalazi izvan opsega bilo koje funkcije", returnExpr);
    	}
    }
    
    public void visit(ReadStmt read) {
    	boolean elem = read.getDesignator().obj.getKind() == Obj.Elem;
    	
    	// Provera da li je samo niz u pitanju
    	boolean array = read.getDesignator().obj.getType().getKind() == Struct.Array &&
    			read.getDesignator().obj.getKind() == Obj.Var;
    	
    	if(!elem && read.getDesignator().obj.getKind() != Obj.Var || array) {
    		report_error("Izraz u read funkciji mora budu element niza ili promenljiva!", read);
    		return;
    	}
    	
    	int kind = read.getDesignator().obj.getType().getKind();
    	if(read.getDesignator().obj.getType().getKind() == Struct.Array) {
    		kind = read.getDesignator().obj.getType().getElemType().getKind();
    	}
    	
    	if(kind != Struct.Bool && kind != Struct.Char && kind != Struct.Int) {
    		report_error("Promenljiva u read funkciji mora biti int, char ili bool tipa!", read);
    		return;
    	}
    }
    
    public void visit(PrintStmtNoWidth print) {
    	printCallCount++;
    	int kind = print.getExpr().struct.getKind();
    	if(kind != Struct.Bool && kind != Struct.Char && kind != Struct.Int) {
    		report_error("Izraz u print funkciji mora biti tipa int, char ili bool", print);
    		return;
    	}
    }
    
    public void visit(PrintStmtWidth print) {
    	printCallCount++;
    	int kind = print.getExpr().struct.getKind();
    	if(kind != Struct.Bool && kind != Struct.Char && kind != Struct.Int) {
    		report_error("Izraz u print funkciji mora biti tipa int, char ili bool", print);
    		return;
    	}
    }
    
    public void visit(ForStmtBegin forst) {
    	forLoopCount++;
    }
    
    public void visit(ForStmtCondFact fr) {
    	forLoopCount--;
    }
    
    public void visit(ForStmtNoCondFact fr) {
    	forLoopCount--;
    }
    
    // ------------------------------ DESIGNATOR STATEMENT ----------------------------------
    
    public void visit(DesignatorStatementInc des) {
    	Obj desObj = des.getDesignator().obj;
    	if(desObj.getKind() != Obj.Var && desObj.getKind() != Obj.Elem && desObj.getType().getKind() != Struct.Array) {
    		report_error("Promenljiva nije odgovarajuceg tipa za operator ++", des);
    		return;
    	}
    	
    	if((desObj.getType().getKind() == Struct.Array && desObj.getType().getElemType().getKind() != Struct.Int)
    			|| (desObj.getType().getKind() != Struct.Array && desObj.getType().getKind() != Struct.Int)) {
    		report_error("Promenljiva nije odgovarajuceg tipa za operator ++", des);
    		return;
    	}
    }
    
    public void visit(DesignatorStatementDec des) {
    	Obj desObj = des.getDesignator().obj;
    	if(desObj.getKind() != Obj.Var && desObj.getKind() != Obj.Elem && desObj.getType().getKind() != Struct.Array) {
    		report_error("Promenljiva nije odgovarajuceg tipa za operator --", des);
    		return;
    	}
    	
    	if((desObj.getType().getKind() == Struct.Array && desObj.getType().getElemType().getKind() != Struct.Int)
    			|| (desObj.getType().getKind() != Struct.Array && desObj.getType().getKind() != Struct.Int)) {
    		report_error("Promenljiva nije odgovarajuceg tipa za operator --", des);
    		return;
    	}
    }
    
    
    public void visit(DesignatorStatementAct des) {
    	// U slucaju neke prethodne greske
    	if(calledMethod == null)return;
    	
    	if(des.getDesignator().obj.getKind() != Obj.Meth) {
    		report_error("Metoda mora biti globalna funkcija", des);
    		return;
    	}
    	
    	int numOfParams = 0;
    	
    	if(methodParams.get(calledMethod.getName()) != null && methodParams.get(calledMethod.getName()) != des) {
    		numOfParams = methodParams.get(calledMethod.getName()).size();
    	}
    	
    	if(numOfParams != calledParamInd) {
    		report_error("Nisu navedeni svi parametri funkcije " + calledMethod.getName(), des);
    	}
    	
    	calledMethodStack.pop();
    	
    	if(calledMethodStack.isEmpty()) {
    		calledMethod = null;
    	}else {
    		calledMethod = calledMethodStack.peek();
    	}
    	
    	calledParamInd = 0;
    	
    	report_info("Poziv globalne funkcije " + des.getDesignator().obj.getName(), des);
    }
    
    
    public void visit(DesignatorStatementAssign designator) {
    	Obj desObj = designator.getDesignator().obj;
    	if(desObj.getKind() != Obj.Elem && desObj.getKind() != Obj.Var) {
    		report_error("Leva strana dodele nije odgovarajuceg tipa", designator);
    		return;
    	}
    	
    	if(!designator.getExpr().struct.assignableTo(desObj.getType()))
    	{
    		report_error("Tipovi nisu kompatibilni pri dodeli", designator);
    		return;
    	}
    }
    
    public void visit(DesignatorStatementExpr1 des) {
    	if(des.getDesignator1().obj.getType().getKind() != Struct.Array) {
    		report_error("Promenljiva sa desne strane znaka = mora biti niz", des);
    		return;
    	}
    	
    	if(des.getDesignator().obj.getType().getKind() != Struct.Array) {
    		report_error("Promenljiva posle znaka * mora biti niz", des);
    		return;
    	}
    	
    	if(des.getDesignator().obj.getType().getElemType() != des.getDesignator1().obj.getType().getElemType()) {
    		report_error("Promenljiva posle znaka * mora imati isti tip elementa kao niz sa desne strane =", des);
    		return;
    	}
    	
    	if(!des.getDesignator().obj.getType().getElemType().assignableTo(des.getDesignator1().obj.getType().getElemType())) {
    		report_error("Niz posle znaka * mora imati tip elementa koji je kompatibilan sa elementima niz sa desne strane =", des);
    		return;
    	}
    }
    
    public void visit(DesignatorStatementExpr des) {
    	if(des.getDesignator1().obj.getType().getKind() != Struct.Array) {
    		report_error("Promenljiva sa desne strane znaka = mora biti niz", des);
    		return;
    	}
    	
    	if(des.getDesignator().obj.getType().getKind() != Struct.Array) {
    		report_error("Promenljiva posle znaka * mora biti niz", des);
    		return;
    	}
    	
    	if(!des.getDesignator().obj.getType().getElemType().assignableTo(des.getDesignator1().obj.getType().getElemType())) {
    		report_error("Niz posle znaka * mora imati tip elementa koji je kompatibilan sa elementima niz sa desne strane =", des);
    		return;
    	}
    }
    
    
    public void visit(DesignatorCommaElem1 des) {
    	//promenljiva ili el niza
		if(des.getDesignator().obj.getKind() != Obj.Var && des.getDesignator().obj.getKind() != Obj.Elem) {
			report_error("Designator u listi mora biti promenljiva ili element niza!", des);
			return;
		}
		
    	if(firstDesignatorElem == null) {
    		firstDesignatorElem = des.getDesignator().obj.getType();
    	}else {
    		if(des.getDesignator().obj.getType().getKind() != firstDesignatorElem.getKind()) {
    			report_error("Svi Designatori moraju biti istog tipa", des);
    			return;
    		}
    	}
    }
    
    
    // ------------------------- ACTUAL METHOD PARAMETERS --------------------------
    
    public void visit(FormParamsList form) {
    	if(currentMethod != null && currentMethod.getName().equals("main")) {
    		report_error("Main metoda ne sme imati parametre", form);
    	}
    }
    
    public String getType(int t) {
    	switch(t) {
    	case 1: return "int";
    	case 2: return "char";
    	case 5: return "bool";
    	case 11: return "int[]";
    	case 12: return "char[]";
    	case 15:return "bool[]";
    	default: return "NA";
    	}
    }
    
    //int - 1, char - 2, bool - 5, int[] - 11, char[] - 12, bool[] - 15, 16 BILO KOJI NIZ(int ili char)
    public boolean checkTypeForParam(int mapType, Struct type) {
    	if(mapType == 16 && type.getKind() == Struct.Array && type.getElemType().getKind() != Struct.Bool) {
    		return true;
    	}
    	if(mapType < 10 && type.getKind() == Struct.Array) {
    		return false;
    	}else if(mapType > 10 && type.getKind() != Struct.Array) {
    		return false;
    	}else {
    		if(type.getKind() == Struct.Array) {
    			return getType(mapType-10).equals(getType(type.getElemType().getKind()));
    		}else {
    			return getType(mapType).equals(getType(type.getKind()));
    		}
    	}
    }
    
    public void visit(ActParsDecl act) {
    	if(calledMethod == null)return;
    	
    	Map<Integer, Integer> methMap = methodParams.get(calledMethod.getName());
    	
    	if(methMap == null) {
    		report_error("Funkcija nema formalne parametre!", act);
    		return;
    	}
    	
    	if(methMap.size() <= calledParamInd) {
    		report_error("Navedeno je vise parametara nego sto je potrebno za funkciju " + calledMethod.getName(), act);
    		return;
    	}
    	
    	if(!checkTypeForParam(methMap.get(0), act.getExpr().struct)) {
    		report_error("Tip formalnog i realnog parametra funkcije se ne poklapa!", act);
    	}
    	calledParamInd++;
    }
    
    public void visit(ExprCommaElem elem) {
    	Map<Integer, Integer> methMap = methodParams.get(calledMethod.getName());
    	
    	if(methMap == null) {
    		report_error("Funkcija nema formalne parametre!", elem);
    		return;
    	}
    	calledParamInd++;
    	if(methMap.size() < calledParamInd) {
    		report_error("Navedeno je vise parametara nego sto je potrebno za funkciju " + calledMethod.getName(), elem);
    		return;
    	}
    	
    	if(!checkTypeForParam(methMap.get(calledParamInd), elem.getExpr().struct)) {
    		report_error("Tip formalnog i realnog parametra funkcije se ne poklapa!", elem);
    	}
    	
    }
    
    //Poziv metode bez parametra
    public void visit(NoActPars act) {
    	if(methodParams.get(currentMethod.getName()) != null){
    		report_error("Metoda nema parametre po pozivu!", act);
    	}
    }
   
    // ---------------------------------- CONDITION, EXPR, TERM... ------------------------------------
    
    public void visit(ExprDash expr) {
    	if(expr.getTerm().struct != Tab.intType) {
    		report_error("Greska tip nakon - mora biti tipa int", expr);
    	}
    	expr.struct = expr.getTerm().struct;
    }
    
    public void visit(ExprTermBasic expr) {
    	expr.struct = expr.getTerm().struct;
    }
    
    public void visit(ExprAddopTerm expr) {
    	if(expr.getTerm().struct != Tab.intType) {
			report_error("Greska tip mora biti tipa int", expr);
		}
    	expr.struct = expr.getTerm().struct;
    }
    
    public void visit(TermMulopFactorDecl term) {
    	if(term.getFactor().struct != Tab.intType || term.getTerm().struct != Tab.intType) {
    		report_error("Greska tip mora biti int", term);
    	}
    	term.struct = term.getFactor().struct;
    }
    
    public void visit(TermFactor term) {
		term.struct = term.getFactor().struct;
	}
   
    
    public void visit(FactorNumConst fact) {
    	report_info("Simbolicka konstanta " + fact.getN1(), fact);
    	fact.struct = Tab.intType;
    }
    
    public void visit(FactorCharConst fact) {
    	report_info("Simbolicka konstanta " + fact.getC1(), fact);
    	fact.struct = Tab.charType;
    }
    
    public void visit(FactorBoolConst fact) {
    	report_info("Simbolicka konstanta " + fact.getB1(), fact);
    	fact.struct = Tab.find("bool").getType();
    }
    
    public void visit(FactorExpr fact) {
    	fact.struct = fact.getExpr().struct;
    }
    
    public void visit(FactorNew fact) {
    	//niz
    	if(fact.getExprOrActPars() instanceof ExprOrActParsExpr) {
    		fact.struct = new Struct(Struct.Array, fact.getType().struct);
    	}else {
    		// nije niz nego tip
    		fact.struct = fact.getType().struct;
    	}
    }
    
    
    public void visit(ExprOrActParsExpr expr) {
    	if(expr.getExpr().struct != Tab.intType) {
    		report_error("Greska tip mora biti int", expr);
    	}
    }
   
    public void visit(FactorDesignator designator) {
    	int kind = designator.getDesignator().obj.getKind();
    	if(kind != Obj.Var && kind != Obj.Con && kind != Obj.Elem) {
    		report_error("Nije u pitanju promenljiva " + designator.getDesignator().obj.getName(), designator);
    		return;
    	}
    	
    	designator.struct = designator.getDesignator().obj.getType();
    }
    
    public void visit(FactorDesignatorMethod des) {
    	if(des.getDesignator().obj.getKind() != Obj.Meth) {
    		report_error("Metoda mora biti globalna funkcija", des);
    		return;
    	}
    	des.struct = des.getDesignator().obj.getType();
    	report_info("Poziv globalne funkcije " + des.getDesignator().obj.getName(), des);
    	
    	// Nisu navedeni svi parametri
    	if(methodParams.get(calledMethod.getName()) != null && methodParams.get(calledMethod.getName()).size() > calledParamInd + 1) {
    		report_error("Nisu navedeni svi parametri funkcije " + calledMethod.getName(), des);
    	}
    	
    	calledMethodStack.pop();
    	
    	if(calledMethodStack.isEmpty()) {
    		calledMethod = null;
    	}else {
    		calledMethod = calledMethodStack.peek();
    	}
    	
    	calledParamInd = 0;
    }
    
    public void visit(CondFactExpr cond) {
    	if(cond.getExpr().struct.getKind() != Struct.Bool) {
    		report_error("Kondiciona promenljiva mora biti bool tipa!", cond);
    		cond.struct = Tab.find("null").getType();
    		return;
    	}
    	cond.struct = Tab.find("bool").getType();
    }
    
    public void visit(CondFactExprRelop cond) {
    	if(cond.getExpr().struct.getKind() == Struct.Array && cond.getExpr1().struct.getKind() != Struct.Array) {
    		if(!cond.getExpr1().struct.compatibleWith(cond.getExpr().struct.getElemType())) {
        		report_error("Tipovi nisu kompatibilni pri poredjenju!", cond);
        		cond.struct = Tab.find("null").getType();
        		return;
        	}
    	}else if(cond.getExpr().struct.getKind() != Struct.Array && cond.getExpr1().struct.getKind() == Struct.Array) {
    		if(!cond.getExpr().struct.compatibleWith(cond.getExpr1().struct.getElemType())) {
        		report_error("Tipovi nisu kompatibilni pri poredjenju!", cond);
        		cond.struct = Tab.find("null").getType();
        		return;
        	}
    	}else {
    		if(!cond.getExpr().struct.compatibleWith(cond.getExpr1().struct)) {
        		report_error("Tipovi nisu kompatibilni pri poredjenju!", cond);
        		cond.struct = Tab.find("null").getType();
        		return;
        	}
    	}
    	
    	
    	if(cond.getExpr().struct.getKind() == Struct.Array
    			&& cond.getExpr1().struct.getKind() == Struct.Array
    			&& (!(cond.getRelop() instanceof RelopTwoEqual) && !(cond.getRelop() instanceof RelopNoEqual))){
    		report_error("Za poredjenje nizova se moze koristiti samo == ili !=!", cond);
    		cond.struct = Tab.find("null").getType();
    		return;
    	}
    	
    	cond.struct = Tab.find("bool").getType();
    }
    
    
    public void visit(CondFactElem cond) {
    	if(cond.getCondFact().struct.getKind() != Struct.Bool) {
    		report_error("Izraz mora biti bool tipa u CondFactElem", cond);
    	}
    	cond.struct = Tab.find("bool").getType();
    }
    
    public void visit(CondTermElem cond) {
    	if(cond.getCondTerm().struct.getKind() != Struct.Bool) {
    		report_error("Izraz mora biti bool tipa u CondTermElem", cond);
    	}
    	
    	cond.struct = Tab.find("bool").getType();
    }
    
    public void visit(Condition cond) {
    	if(cond.getCondTerm().struct.getKind() != Struct.Bool) {
    		report_error("Izraz mora biti bool tipa u Condition", cond);
    	}
    	
    	cond.struct = Tab.find("bool").getType();
    }
    
    public void visit(CondTerm cond) {
    	if(cond.getCondFact().struct.getKind() != Struct.Bool) {
    		report_error("Izraz mora biti bool tipa u CondTerm", cond);
    	}
    	
    	cond.struct = Tab.find("bool").getType();
    }
   
    
    // ----------------------------------- DESIGNATOR ---------------------------------
    
    // Zato sto pre namespace nema globalnih promenljivih vec samo ono sto je vec u tabeli simbola
    public void visit(DesignatorDeclBasic designatorType) {
    	String namespacePart = "";
    	// Ako smo u namespaceu onda se pozivaju bez imena namespacea
    	if(currentNamespace != null && !designatorType.getVarName().equals("null") && !designatorType.getVarName().equals("len")
    			&& !designatorType.getVarName().equals("ord") && !designatorType.getVarName().equals("chr")) {
    		namespacePart = currentNamespace.getName() + "::";
    	}
    	Obj node = Tab.find(namespacePart + designatorType.getVarName());
    	currDesignator = node;
    	if(node == Tab.noObj) {
    		report_error("Greska: Ime " + designatorType.getVarName() + " nije deklarisano!", designatorType);
			designatorType.obj = Tab.noObj;
			return;
    	} 
    	designatorType.obj = node;
    	
    	//act pars for method
    	
    	if(currentMethod != null) {
    		if(currentMethodParamNames.contains(designatorType.getVarName())) {
    			report_info("Koriscenje parametra " + designatorType.getVarName() + " funkcije " + currentMethod.getName(), designatorType);
    		}
    	}
    }
    
    public void visit(DesignatorDeclNamespace desingatorType) {
    	Obj namespaceNode = Tab.find(desingatorType.getNamespaceName());
		if(namespaceNode == Tab.noObj ||  namespaceNode.getType().getKind() != Struct.Interface) {
			report_error("Nije pronadjen namespace " + desingatorType.getNamespaceName() + " u tabeli simbola! ", desingatorType);
			desingatorType.obj = Tab.noObj;
			return;
		}
		
		String fullName = desingatorType.getNamespaceName() + "::" + desingatorType.getVarName();
		Obj typeNode = Tab.find(fullName);
		
		if(typeNode == Tab.noObj) {
			report_error("Nije pronadjena promenljiva " + typeNode.getName() + " u tom namespace-u! ", desingatorType);
			desingatorType.obj = Tab.noObj;
			return;
		}
		
		//TODO dodati i za tip
		if(typeNode.getKind() != Obj.Meth && typeNode.getKind() != Obj.Var && typeNode.getKind() != Obj.Con) {
			report_error("Promenljiva nije odgovarajuceg tipa " + typeNode.getName(), desingatorType);
			desingatorType.obj = Tab.noObj;
			return;
		}
		
		desingatorType.obj = typeNode;
		currDesignator = typeNode;
    }
    
    
    //TODO PROVERI!!!
    public void visit(DesignatorIndexing designator) {
    	Obj des = designator.getArrayDesignatorDecl().getDesignator().obj;
    	if(designator.getExpr().struct != Tab.intType) {
    		report_error("Promenljiva za indeksiranje niza nije odgovarajuceg tipa " + designator.getExpr(), designator);
    		return;
    	}
    	if(des.getType().getKind() != Struct.Array) {
    		report_error("Promenljiva " + des.getName() + " nije tipa niza", designator);
    		return;
    	}

    	Obj arrayElem = new Obj(Obj.Elem, des.getName(), des.getType().getElemType());
    	designator.obj = arrayElem;
    	
    	report_info("Pristup elementu niza "+ des.getName(), designator);
    }

    
    public void visit(DesignatorBasicDecl designator) {
    	designator.obj = designator.getDesignatorDecl().obj;
    	if(designator.obj.getKind() == Obj.Meth) {
    		calledMethodStack.push(designator.obj);
    		calledMethod = calledMethodStack.peek();
    	}else if(calledMethod != null){
    		report_info("Koriscenje promenljive " + designator.obj.getName(), designator);
    	}
    }
    
 
    public boolean passed(){
    	return !errorDetected;
    }
    
}
