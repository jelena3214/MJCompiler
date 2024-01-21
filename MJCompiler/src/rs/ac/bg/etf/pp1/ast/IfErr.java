// generated with ast extension for cup
// version 0.8
// 21/0/2024 21:47:4


package rs.ac.bg.etf.pp1.ast;

public class IfErr extends IfStatement {

    private Statement Statement;
    private ElseStatementList ElseStatementList;

    public IfErr (Statement Statement, ElseStatementList ElseStatementList) {
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ElseStatementList=ElseStatementList;
        if(ElseStatementList!=null) ElseStatementList.setParent(this);
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ElseStatementList getElseStatementList() {
        return ElseStatementList;
    }

    public void setElseStatementList(ElseStatementList ElseStatementList) {
        this.ElseStatementList=ElseStatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Statement!=null) Statement.accept(visitor);
        if(ElseStatementList!=null) ElseStatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ElseStatementList!=null) ElseStatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ElseStatementList!=null) ElseStatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfErr(\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElseStatementList!=null)
            buffer.append(ElseStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfErr]");
        return buffer.toString();
    }
}
