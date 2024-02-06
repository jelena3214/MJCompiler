// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmtDecl extends DesignatorStmtList {

    private DesignatorStatement DesignatorStatement;
    private DesignatorStatementCommaList DesignatorStatementCommaList;

    public DesignatorStmtDecl (DesignatorStatement DesignatorStatement, DesignatorStatementCommaList DesignatorStatementCommaList) {
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
        this.DesignatorStatementCommaList=DesignatorStatementCommaList;
        if(DesignatorStatementCommaList!=null) DesignatorStatementCommaList.setParent(this);
    }

    public DesignatorStatement getDesignatorStatement() {
        return DesignatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement DesignatorStatement) {
        this.DesignatorStatement=DesignatorStatement;
    }

    public DesignatorStatementCommaList getDesignatorStatementCommaList() {
        return DesignatorStatementCommaList;
    }

    public void setDesignatorStatementCommaList(DesignatorStatementCommaList DesignatorStatementCommaList) {
        this.DesignatorStatementCommaList=DesignatorStatementCommaList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
        if(DesignatorStatementCommaList!=null) DesignatorStatementCommaList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
        if(DesignatorStatementCommaList!=null) DesignatorStatementCommaList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        if(DesignatorStatementCommaList!=null) DesignatorStatementCommaList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmtDecl(\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementCommaList!=null)
            buffer.append(DesignatorStatementCommaList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmtDecl]");
        return buffer.toString();
    }
}
