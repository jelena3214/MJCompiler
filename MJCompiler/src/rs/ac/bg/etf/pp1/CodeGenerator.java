package rs.ac.bg.etf.pp1;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.AddopMinus;
import rs.ac.bg.etf.pp1.ast.AddopPlus;
import rs.ac.bg.etf.pp1.ast.ArrayDesignatorDecl;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementExpr1;
import rs.ac.bg.etf.pp1.ast.BeforeForBody;
import rs.ac.bg.etf.pp1.ast.BeforeForCond;
import rs.ac.bg.etf.pp1.ast.BeforeForUpdate;
import rs.ac.bg.etf.pp1.ast.BreakStmt;
import rs.ac.bg.etf.pp1.ast.CondFact;
import rs.ac.bg.etf.pp1.ast.CondFactExprRelop;
import rs.ac.bg.etf.pp1.ast.ContinueStmt;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.CondFactExpr;
import rs.ac.bg.etf.pp1.ast.DesignatorBasicDecl;
import rs.ac.bg.etf.pp1.ast.DesignatorCommaElem1;
import rs.ac.bg.etf.pp1.ast.DesignatorCommaElem2;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementAct;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementAssign;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementDec;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementInc;
import rs.ac.bg.etf.pp1.ast.ElseStatement;
import rs.ac.bg.etf.pp1.ast.ExprAddopTerm;
import rs.ac.bg.etf.pp1.ast.ExprDash;
import rs.ac.bg.etf.pp1.ast.FactorBoolConst;
import rs.ac.bg.etf.pp1.ast.FactorCharConst;
import rs.ac.bg.etf.pp1.ast.FactorDesignator;
import rs.ac.bg.etf.pp1.ast.FactorDesignatorMethod;
import rs.ac.bg.etf.pp1.ast.FactorNew;
import rs.ac.bg.etf.pp1.ast.FactorNumConst;
import rs.ac.bg.etf.pp1.ast.ForStmtBegin;
import rs.ac.bg.etf.pp1.ast.IfNoErr;
import rs.ac.bg.etf.pp1.ast.IfStmt;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodTypeDecl;
import rs.ac.bg.etf.pp1.ast.MethodTypeVoid;
import rs.ac.bg.etf.pp1.ast.Mulop;
import rs.ac.bg.etf.pp1.ast.MulopDiv;
import rs.ac.bg.etf.pp1.ast.MulopMod;
import rs.ac.bg.etf.pp1.ast.MulopMultiply;
import rs.ac.bg.etf.pp1.ast.NoElseStatement;
import rs.ac.bg.etf.pp1.ast.PatchAnd;
import rs.ac.bg.etf.pp1.ast.PatchOr;
import rs.ac.bg.etf.pp1.ast.PatchToElse;
import rs.ac.bg.etf.pp1.ast.PrintStmtNoWidth;
import rs.ac.bg.etf.pp1.ast.PrintStmtWidth;
import rs.ac.bg.etf.pp1.ast.ReadStmt;
import rs.ac.bg.etf.pp1.ast.Relop;
import rs.ac.bg.etf.pp1.ast.RelopGreater;
import rs.ac.bg.etf.pp1.ast.RelopGreaterEqual;
import rs.ac.bg.etf.pp1.ast.RelopLess;
import rs.ac.bg.etf.pp1.ast.RelopLessEqual;
import rs.ac.bg.etf.pp1.ast.RelopNoEqual;
import rs.ac.bg.etf.pp1.ast.RelopTwoEqual;
import rs.ac.bg.etf.pp1.ast.ReturnStmt;
import rs.ac.bg.etf.pp1.ast.ReturnStmtExpr;
import rs.ac.bg.etf.pp1.ast.StartIf;
import rs.ac.bg.etf.pp1.ast.ForStmtCondFact;
import rs.ac.bg.etf.pp1.ast.ForStmtNoCondFact;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.TermMulopFactorDecl;
import rs.ac.bg.etf.pp1.ast.VarDeclTmp;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private boolean returnFound = false;
	
	private int mainPc = -1;
	private int skipCnt = 0;
	private int varCnt = 0;
	
	private static Stack<List<Integer>> patchOrStack = new Stack<>();
    private static Stack<List<Integer>> patchAndStack = new Stack<>();
    private static Stack<List<Integer>> patchElseStack = new Stack<>();
    // za cuvanje adrese ako uslov nije ispunjen
    private static Stack<List<Integer>> patchForExit = new Stack<>();
    // za cuvanje adrese uslova i adrese azuriranja promenljive
    private static Stack<List<Integer>> patchForJumps = new Stack<>();
    private static Stack<List<Integer>> patchForStatement = new Stack<>();
    private static List<Obj> specDesignatorList = new ArrayList<>();
    
    private boolean forStart = false;
	
	public int getMainPc(){
		return mainPc;
	}
	
	public void visit(DesignatorStatementAssign desi) {
		Code.store(desi.getDesignator().obj);
	}
	
	public void visit(DesignatorStatementInc desi) {
		Obj designatorNode = desi.getDesignator().obj;
		
		if(designatorNode.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		
		Code.load(designatorNode);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(designatorNode);
	}
	
	public void visit(DesignatorStatementDec desi) {
		Obj designatorNode = desi.getDesignator().obj;
		
		if(designatorNode.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		
		Code.load(designatorNode);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(designatorNode);
	}
	
	public void visit(ReadStmt read) {
    	Obj node = read.getDesignator().obj;
    	
    	if(node.getType() == Tab.charType) {
    		Code.put(Code.bread);			
    	}
		else {
			Code.put(Code.read);		
		}

		Code.store(node);
    }
	
	public void visit(PrintStmtWidth print) {
		Struct exprType = print.getExpr().struct;
		int width = print.getN1();
		
		Code.loadConst(width);
		
		if (exprType == Tab.charType) {
    		Code.put(Code.bprint);
    	}
    	else {
    		Code.put(Code.print);
    	}
	}
	
	public void visit(PrintStmtNoWidth print) {
		Struct exprType = print.getExpr().struct;
    	
    	if (exprType == Tab.charType) {
    		Code.loadConst(1);
    		Code.put(Code.bprint);
    	}
    	else {
    		Code.loadConst(5);
    		Code.put(Code.print);
    	}
	}
	
	public void visit(Addop addop) {
		if(addop instanceof AddopPlus)Code.put(Code.add);
		if(addop instanceof AddopMinus)Code.put(Code.sub);
	}
	
	public void visit(Mulop mulop) {
		if(mulop instanceof MulopMultiply)Code.put(Code.mul);
		if(mulop instanceof MulopDiv)Code.put(Code.div);
		if(mulop instanceof MulopMod)Code.put(Code.rem);
	}
	
	public void visit(FactorNumConst fact) {
    	int constant = fact.getN1();
    	Code.loadConst(constant);
    }
    
    public void visit(FactorCharConst fact) {
    	char constValue = fact.getC1();
    	int constant = constValue;
    	Code.loadConst(constant);
    }
    
    public void visit(FactorBoolConst fact) {
    	boolean constValue = fact.getB1();
    	
    	if (constValue == true) {
    		Code.loadConst(1);
    	}
    	else {
    		Code.loadConst(0);
    	}
    }
    
    public void visit(FactorDesignator fact) {
    	Obj ob = fact.getDesignator().obj;
    	Code.load(ob);
    }
    
    public void visit(FactorNew fact) {
    	Struct type = fact.struct;
    	
    	Code.put(Code.newarray);
    	if(type == Tab.charType) {
    		Code.put(0);
    	}else {
    		Code.put(1);
    	}
    }
    
    public void visit(ExprDash expr) {
    	Code.put(Code.neg);
    }
    
    public void visit(ExprAddopTerm node) {
    	Addop operation = node.getAddop();
    	if (operation instanceof AddopPlus) {
    		Code.put(Code.add);
    	}
    	else if (operation instanceof AddopMinus) {
    		Code.put(Code.sub);
    	}
    }
    
    public void visit(TermMulopFactorDecl term) {
    	Mulop operation = term.getMulop();
    	if (operation instanceof MulopMultiply) {
    		Code.put(Code.mul);
    	}else if (operation instanceof MulopDiv) {
    		Code.put(Code.div);
    	}else if (operation instanceof MulopMod) {
    		Code.put(Code.rem);
    	}
    }
    
    public void visit(MethodTypeDecl meth) {
		Obj func = meth.obj;
		String funcName = func.getName();
		
		func.setAdr(Code.pc);
		
		if ("main".equals(funcName)) {
			mainPc = Code.pc;
		}
		
		int argCnt = func.getLevel();
		int localAndArgCnt = func.getLocalSymbols().size();
		
		Code.put(Code.enter);
		Code.put(argCnt);
		Code.put(localAndArgCnt);
    }
    
    public void visit(MethodTypeVoid meth) {
		Obj func = meth.obj;
		String funcName = func.getName();
		
		func.setAdr(Code.pc);
		
		if ("main".equals(funcName)) {
			mainPc = Code.pc;
		}
		
		int argCnt = func.getLevel();
		int localAndArgCnt = func.getLocalSymbols().size();
		
		Code.put(Code.enter);
		Code.put(argCnt);
		Code.put(localAndArgCnt);
    }
    
	public void visit(MethodDecl methodDecl){
		Struct methStruct = methodDecl.obj.getType();
		
		// fali return
		if (methStruct != Tab.noType && !returnFound) {
			Code.put(Code.trap);
			Code.put(1);
		}
		else if (methStruct == Tab.noType && !returnFound) {
			Code.put(Code.exit);
			Code.put(Code.return_);
		}
		
		returnFound = false;
	}
	
	public void visit(ReturnStmtExpr returnExpr){
		returnFound = true;
		Code.put(Code.exit);
		Code.put(Code.return_);
		
	}
	
	public void visit(ReturnStmt returnNoExpr){
		returnFound = true;
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	//TODO check
	public void visit(DesignatorBasicDecl designator){
//		Code.load(designator.obj);
//		SyntaxNode parent = designator.getParent();
//		
//		if(Assignment.class != parent.getClass() && FuncCall.class != parent.getClass() && ProcCall.class != parent.getClass()){
//			
//		}
	}
	
	public void visit(ArrayDesignatorDecl arr) {
		Code.load(arr.getDesignator().obj);
	}

	public void visit(DesignatorStatementAct meth) {
		Obj des = meth.getDesignator().obj;
		String funcName = des.getName();
		int adr = des.getAdr();
		int offset = adr - Code.pc;
		
		if(funcName.equals("len")) {
			Code.put(Code.arraylength);
			return;
		}else if(funcName.equals("ord") || funcName.equals("chr")) {
			return;
		}
		
		
		Code.put(Code.call);
		Code.put2(offset);
		
		// clean the stack after if needed
		if(des.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
	}
	
	public void visit(FactorDesignatorMethod meth) {
		Obj des = meth.getDesignator().obj;
		
		String funcName = des.getName();
		int adr = des.getAdr();
		int offset = adr - Code.pc;
		
		if(funcName.equals("len")) {
			Code.put(Code.arraylength);
			return;
		}else if(funcName.equals("ord") || funcName.equals("chr")) {
			return;
		}
		
		
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	public void visit(CondFactExprRelop cond) {
		if(!forStart)patchAndStack.peek().add(Code.pc + 1);
		else patchForExit.peek().add(Code.pc + 1);
		
		Relop relop = cond.getRelop();
		int operCode = -1;
		
		if(relop instanceof RelopTwoEqual) operCode = Code.eq;
		if(relop instanceof RelopNoEqual) operCode = Code.ne;
		if(relop instanceof RelopGreater) operCode = Code.gt;
		if(relop instanceof RelopGreaterEqual) operCode = Code.ge;
		if(relop instanceof RelopLess) operCode = Code.lt;
		if(relop instanceof RelopLessEqual) operCode = Code.le;
		
		Code.putFalseJump(operCode, 0);
		
		if(forStart) {
	    	forStart = false;
		}
	}
	
	public void visit(CondFactExpr cond) {
		// mora da bude bool, andujemo sa 1
		Code.loadConst(1);
		patchAndStack.peek().add(Code.pc + 1);
		Code.putFalseJump(Code.eq, 0);
	}
	
	public void visit(PatchAnd node) {
		// ct pre ovog OR je bio TRUE ispunjen uslov idemo na then
		patchOrStack.peek().add(Code.pc + 1);
		Code.putJump(0);
	
		// (cf and cf and cf ...) pre OR je false ide na sledeci deo
		while(!patchAndStack.peek().isEmpty()) {
			Code.fixup(patchAndStack.peek().remove(0));
		}
	}
	
	public void visit(PatchOr node) {
    	// (cf and cf and ..) or (cf and ..) ako je bilo koji TRUE idemo na then
    	
    	while(!patchOrStack.peek().isEmpty()) {
    		Code.fixup(patchOrStack.peek().remove(0));
    	}
    }
	
	public void visit(PatchToElse node) {
		// jmp na liniju nakon else 
    	patchElseStack.peek().add(Code.pc + 1); // jmp = 1 byte
    	Code.putJump(0);
    	
    	// ako ni jedan (cg and cf ...) nije bio ispunjen ovde ide na else
    	while(!patchAndStack.peek().isEmpty()) {
    		Code.fixup(patchAndStack.peek().remove(0));
    	}
    }
	
	public void visit(StartIf ifstmt) {
		patchOrStack.push(new ArrayList<>());
    	patchAndStack.push(new ArrayList<>());
    	patchElseStack.push(new ArrayList<>());
	}
	
	public void visit(IfNoErr node) {
    	
    	if(node.getElseStatementList() instanceof NoElseStatement) {
    		// ako nije ispunjen popunjavamo da vode na posle ifa
    		while(!patchAndStack.peek().isEmpty()) {
        		Code.fixup(patchAndStack.peek().remove(0));
        	}
    		
    		// kraj ovog ifa
    		patchOrStack.pop();
        	patchAndStack.pop();
        	patchElseStack.pop();
    	}
    	
    }
    
    public void visit(ElseStatement node) {
    	while(!patchElseStack.peek().isEmpty()) {
    		Code.fixup(patchElseStack.peek().remove(0));
    	}
    	
    	// kraj ovog ifa
    	patchOrStack.pop();
    	patchAndStack.pop();
    	patchElseStack.pop();
    }
    
    
	public void visit(ForStmtBegin forstmt) {
		forStart = true;
		patchForExit.add(new ArrayList<>());
		patchForJumps.add(new ArrayList<>());
		patchForStatement.add(new ArrayList<>());
	}
    
    
    public void visit(BeforeForCond bf) {
    	// pamtimo adresu uslova
    	patchForJumps.peek().add(Code.pc);
    }
    
    public void visit(BeforeForUpdate bfu) {
    	// da skocimo na telo fora
    	patchForStatement.peek().add(Code.pc + 1); // jmp = 1 byte
    	Code.putJump(0);
    	patchForJumps.peek().add(Code.pc);
    }
    
    public void visit(BeforeForBody bfb) {
    	// jer tada imamo uslov zapravo, ako je samo 1 element tu  to je adresa update dela
    	if(patchForJumps.peek().size() > 1)Code.putJump(patchForJumps.peek().get(0));
    	while(!patchForStatement.peek().isEmpty()) {
    		Code.fixup(patchForStatement.peek().remove(0));
    	}
    }
    
    public void visit(ForStmtCondFact forCond) {
    	// skacemo na uslov deo
    	Code.putJump(patchForJumps.peek().get(1));
    	
    	while(!patchForExit.peek().isEmpty()) {
    		Code.fixup(patchForExit.peek().remove(0));
    	}
    	
    	patchForExit.pop();
    	patchForJumps.pop();
    	patchForStatement.pop();
    	
    }
    
    public void visit(ForStmtNoCondFact forCond) {
    	// skacemo na update deo
    	Code.putJump(patchForJumps.peek().get(0));
    	
    	while(!patchForExit.peek().isEmpty()) {
    		Code.fixup(patchForExit.peek().remove(0));
    	}
    	
    	patchForStatement.pop();
    	patchForExit.pop();
    	patchForJumps.pop();
    }
    
    public void visit(BreakStmt breakSt) {
    	patchForExit.peek().add(Code.pc + 1);
    	Code.putJump(0);
    }
    
    public void visit(ContinueStmt continueSt) {
    	// vracamo se na update deo
    	Code.putJump(patchForJumps.peek().get(1));
    }
    
    // Bez onih pre
    public void visit(DesignatorStatementExpr des) {
    	Obj arr1 = des.getDesignator().obj;
    	Obj arr2 = des.getDesignator1().obj;
    	
    	// len(arr1)
    	Code.load(arr1);
    	Code.put(Code.arraylength);
    	
    	// len(arr2)
    	Code.load(arr2);
    	Code.put(Code.arraylength);
    	
    	Code.put(Code.jcc + Code.ge); 	// 3 bytes
    	Code.put2(5); 					// skip trap (3 + 2)
    	
    	// arr1 < arr2
    	Code.put(Code.trap); 			// 2 bytes
    	Code.put(2);
    	
    	// TODO prebacivanje iz niza u niz
    	
    	Code.loadConst(0);
    	
    	int adrJump = Code.pc;
    	Code.put(Code.dup);
    	Code.put(Code.dup);
    	Code.load(arr1);
    	Code.put(Code.dup_x2);
    	Code.put(Code.pop);
    	Code.load(arr2);
    	Code.put(Code.dup_x1);
    	Code.put(Code.pop);
    	Code.put(Code.aload);
    	Code.put(Code.astore);
    	
    	Code.loadConst(1);
    	Code.put(Code.add);
    	Code.put(Code.dup);
    	
    	Code.load(arr2);
    	Code.put(Code.arraylength);
    	   	
    	Code.put(Code.jcc + Code.ne);
    	Code.put2(adrJump-Code.pc + 1);
    	
    	Code.put(Code.pop);
    }
    
    public void visit(DesignatorStatementExpr1 des) {
    	Obj arr1 = des.getDesignator().obj;
    	Obj arr2 = des.getDesignator1().obj;
    	int num = specDesignatorList.size();
    	
    	// len(arr2)
    	Code.load(arr2);
    	Code.put(Code.arraylength);
    	Code.loadConst(num);
		
		Code.put(Code.jcc + Code.gt); 	// 3 bytes
    	Code.put2(5); 					// skip trap (3 + 2)
    	
    	// len(arr2) <= broj promenljivih
    	Code.put(Code.trap); 			// 2 bytes
    	Code.put(8);
    	
    	// len(arr1)
    	Code.load(arr1);
    	Code.put(Code.arraylength);
    	
    	// len(arr2)
    	Code.load(arr2);
    	Code.put(Code.arraylength);
    	Code.loadConst(num);
		Code.put(Code.sub);
    	
    	Code.put(Code.jcc + Code.ge); 	// 3 bytes
    	Code.put2(5); 					// skip trap (3 + 2)
    	
    	// arr1 < arr2 - br promenljivih
    	Code.put(Code.trap); 			// 2 bytes
    	Code.put(7);
    	
    	// prvo promenljive popunjavamo u obrnutom redosledu zbog elemenata niza
    	
    	for(int i = num-1; i >= 0; i--) {
    		int lastElem = specDesignatorList.size() - 1;
    		Obj nextObj = specDesignatorList.remove(lastElem);
    		if(nextObj.getName().equals("skip")) {
    			continue;
    		}
    		Code.load(arr2);
    		Code.loadConst(i);
    		Code.put(Code.aload);
    		
    		Code.store(nextObj);
    	}
    	
    	// TODO prebacivanje iz niza u niz
    	
    	Code.loadConst(0);
    	Code.loadConst(num);
    	
    	int adrJump = Code.pc;
    	Code.put(Code.dup2);
    	Code.load(arr1);
    	Code.put(Code.dup_x2);
    	Code.put(Code.pop);
    	Code.load(arr2);
    	Code.put(Code.dup_x1);
    	Code.put(Code.pop);
    	Code.put(Code.aload);
    	Code.put(Code.astore);
    	
    	Code.loadConst(1);
    	Code.put(Code.add);
    	Code.put(Code.dup_x1);
    	Code.put(Code.pop);
    	Code.loadConst(1);
    	Code.put(Code.add);
    	Code.put(Code.dup_x1);
    	Code.put(Code.pop);
    	Code.put(Code.dup);
    	
    	Code.load(arr2);
    	Code.put(Code.arraylength);
    	   	
    	Code.put(Code.jcc + Code.ne);
    	Code.put2(adrJump-Code.pc + 1);
    	Code.put(Code.pop);
    	Code.put(Code.pop);
    	skipCnt = 0;
    }
    
    public void visit(DesignatorCommaElem1 el) {
    	specDesignatorList.add(el.getDesignator().obj);
    }
    
    // skip elem, jer moze [a,b,,*y] = x;
    public void visit(DesignatorCommaElem2 el) {
    	skipCnt++;
    	specDesignatorList.add(new Obj(0,"skip", new Struct(Struct.None)));
    }

}
