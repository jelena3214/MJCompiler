// generated with ast extension for cup
// version 0.8
// 21/0/2024 21:47:4


package rs.ac.bg.etf.pp1.ast;

public class ForStmtCondFact extends Statement {

    private ForStmtBegin ForStmtBegin;
    private DesignatorStmtList DesignatorStmtList;
    private CondFact CondFact;
    private DesignatorStmtList DesignatorStmtList1;
    private Statement Statement;

    public ForStmtCondFact (ForStmtBegin ForStmtBegin, DesignatorStmtList DesignatorStmtList, CondFact CondFact, DesignatorStmtList DesignatorStmtList1, Statement Statement) {
        this.ForStmtBegin=ForStmtBegin;
        if(ForStmtBegin!=null) ForStmtBegin.setParent(this);
        this.DesignatorStmtList=DesignatorStmtList;
        if(DesignatorStmtList!=null) DesignatorStmtList.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
        this.DesignatorStmtList1=DesignatorStmtList1;
        if(DesignatorStmtList1!=null) DesignatorStmtList1.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ForStmtBegin getForStmtBegin() {
        return ForStmtBegin;
    }

    public void setForStmtBegin(ForStmtBegin ForStmtBegin) {
        this.ForStmtBegin=ForStmtBegin;
    }

    public DesignatorStmtList getDesignatorStmtList() {
        return DesignatorStmtList;
    }

    public void setDesignatorStmtList(DesignatorStmtList DesignatorStmtList) {
        this.DesignatorStmtList=DesignatorStmtList;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public DesignatorStmtList getDesignatorStmtList1() {
        return DesignatorStmtList1;
    }

    public void setDesignatorStmtList1(DesignatorStmtList DesignatorStmtList1) {
        this.DesignatorStmtList1=DesignatorStmtList1;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ForStmtBegin!=null) ForStmtBegin.accept(visitor);
        if(DesignatorStmtList!=null) DesignatorStmtList.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
        if(DesignatorStmtList1!=null) DesignatorStmtList1.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForStmtBegin!=null) ForStmtBegin.traverseTopDown(visitor);
        if(DesignatorStmtList!=null) DesignatorStmtList.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
        if(DesignatorStmtList1!=null) DesignatorStmtList1.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForStmtBegin!=null) ForStmtBegin.traverseBottomUp(visitor);
        if(DesignatorStmtList!=null) DesignatorStmtList.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        if(DesignatorStmtList1!=null) DesignatorStmtList1.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForStmtCondFact(\n");

        if(ForStmtBegin!=null)
            buffer.append(ForStmtBegin.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStmtList!=null)
            buffer.append(DesignatorStmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStmtList1!=null)
            buffer.append(DesignatorStmtList1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForStmtCondFact]");
        return buffer.toString();
    }
}
