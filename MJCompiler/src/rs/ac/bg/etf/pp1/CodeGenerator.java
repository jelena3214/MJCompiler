package rs.ac.bg.etf.pp1;


import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.AddopMinus;
import rs.ac.bg.etf.pp1.ast.AddopPlus;
import rs.ac.bg.etf.pp1.ast.ArrayDesignatorDecl;
import rs.ac.bg.etf.pp1.ast.DesignatorBasicDecl;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementAct;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementAssign;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementDec;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementInc;
import rs.ac.bg.etf.pp1.ast.ExprAddopTerm;
import rs.ac.bg.etf.pp1.ast.ExprDash;
import rs.ac.bg.etf.pp1.ast.FactorBoolConst;
import rs.ac.bg.etf.pp1.ast.FactorCharConst;
import rs.ac.bg.etf.pp1.ast.FactorDesignator;
import rs.ac.bg.etf.pp1.ast.FactorDesignatorMethod;
import rs.ac.bg.etf.pp1.ast.FactorNew;
import rs.ac.bg.etf.pp1.ast.FactorNumConst;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodTypeDecl;
import rs.ac.bg.etf.pp1.ast.MethodTypeVoid;
import rs.ac.bg.etf.pp1.ast.Mulop;
import rs.ac.bg.etf.pp1.ast.MulopDiv;
import rs.ac.bg.etf.pp1.ast.MulopMod;
import rs.ac.bg.etf.pp1.ast.MulopMultiply;
import rs.ac.bg.etf.pp1.ast.PrintStmtNoWidth;
import rs.ac.bg.etf.pp1.ast.PrintStmtWidth;
import rs.ac.bg.etf.pp1.ast.ReadStmt;
import rs.ac.bg.etf.pp1.ast.ReturnStmt;
import rs.ac.bg.etf.pp1.ast.ReturnStmtExpr;
import rs.ac.bg.etf.pp1.ast.TermMulopFactorDecl;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private boolean returnFound = false;
	
	private int mainPc = -1;
	
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
}
