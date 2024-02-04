// generated with ast extension for cup
// version 0.8
// 4/1/2024 12:17:16


package rs.ac.bg.etf.pp1.ast;

public class IfErr extends IfStatement {

    private StartIf StartIf;
    private Statement Statement;
    private ElseStatementList ElseStatementList;

    public IfErr (StartIf StartIf, Statement Statement, ElseStatementList ElseStatementList) {
        this.StartIf=StartIf;
        if(StartIf!=null) StartIf.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ElseStatementList=ElseStatementList;
        if(ElseStatementList!=null) ElseStatementList.setParent(this);
    }

    public StartIf getStartIf() {
        return StartIf;
    }

    public void setStartIf(StartIf StartIf) {
        this.StartIf=StartIf;
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
        if(StartIf!=null) StartIf.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(ElseStatementList!=null) ElseStatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StartIf!=null) StartIf.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ElseStatementList!=null) ElseStatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StartIf!=null) StartIf.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ElseStatementList!=null) ElseStatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfErr(\n");

        if(StartIf!=null)
            buffer.append(StartIf.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
