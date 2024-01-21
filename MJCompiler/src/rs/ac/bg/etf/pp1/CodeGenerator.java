package rs.ac.bg.etf.pp1;

import javax.print.attribute.standard.PrinterState;

import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.AddopMinus;
import rs.ac.bg.etf.pp1.ast.AddopPlus;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementAssign;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementDec;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementInc;
import rs.ac.bg.etf.pp1.ast.Mulop;
import rs.ac.bg.etf.pp1.ast.MulopDiv;
import rs.ac.bg.etf.pp1.ast.MulopMod;
import rs.ac.bg.etf.pp1.ast.MulopMultiply;
import rs.ac.bg.etf.pp1.ast.PrintStmtNoWidth;
import rs.ac.bg.etf.pp1.ast.PrintStmtWidth;
import rs.ac.bg.etf.pp1.ast.ReadStmt;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

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
		int width = print.getN1();
		
		Code.loadConst(width);
	}
	
	public void visit(PrintStmtNoWidth print) {
		Struct exprType = print.getExpr().struct;
    	
    	if (exprType == Tab.charType) {
    		Code.loadConst(1); 
    	}
    	else {
    		Code.loadConst(5); 
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
}
