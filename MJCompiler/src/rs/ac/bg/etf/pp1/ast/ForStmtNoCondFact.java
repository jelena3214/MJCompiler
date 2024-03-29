// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class ForStmtNoCondFact extends Statement {

    private ForStmtBegin ForStmtBegin;
    private DesignatorStmtList DesignatorStmtList;
    private BeforeForUpdate BeforeForUpdate;
    private DesignatorStmtList DesignatorStmtList1;
    private BeforeForBody BeforeForBody;
    private Statement Statement;

    public ForStmtNoCondFact (ForStmtBegin ForStmtBegin, DesignatorStmtList DesignatorStmtList, BeforeForUpdate BeforeForUpdate, DesignatorStmtList DesignatorStmtList1, BeforeForBody BeforeForBody, Statement Statement) {
        this.ForStmtBegin=ForStmtBegin;
        if(ForStmtBegin!=null) ForStmtBegin.setParent(this);
        this.DesignatorStmtList=DesignatorStmtList;
        if(DesignatorStmtList!=null) DesignatorStmtList.setParent(this);
        this.BeforeForUpdate=BeforeForUpdate;
        if(BeforeForUpdate!=null) BeforeForUpdate.setParent(this);
        this.DesignatorStmtList1=DesignatorStmtList1;
        if(DesignatorStmtList1!=null) DesignatorStmtList1.setParent(this);
        this.BeforeForBody=BeforeForBody;
        if(BeforeForBody!=null) BeforeForBody.setParent(this);
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

    public BeforeForUpdate getBeforeForUpdate() {
        return BeforeForUpdate;
    }

    public void setBeforeForUpdate(BeforeForUpdate BeforeForUpdate) {
        this.BeforeForUpdate=BeforeForUpdate;
    }

    public DesignatorStmtList getDesignatorStmtList1() {
        return DesignatorStmtList1;
    }

    public void setDesignatorStmtList1(DesignatorStmtList DesignatorStmtList1) {
        this.DesignatorStmtList1=DesignatorStmtList1;
    }

    public BeforeForBody getBeforeForBody() {
        return BeforeForBody;
    }

    public void setBeforeForBody(BeforeForBody BeforeForBody) {
        this.BeforeForBody=BeforeForBody;
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
        if(BeforeForUpdate!=null) BeforeForUpdate.accept(visitor);
        if(DesignatorStmtList1!=null) DesignatorStmtList1.accept(visitor);
        if(BeforeForBody!=null) BeforeForBody.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForStmtBegin!=null) ForStmtBegin.traverseTopDown(visitor);
        if(DesignatorStmtList!=null) DesignatorStmtList.traverseTopDown(visitor);
        if(BeforeForUpdate!=null) BeforeForUpdate.traverseTopDown(visitor);
        if(DesignatorStmtList1!=null) DesignatorStmtList1.traverseTopDown(visitor);
        if(BeforeForBody!=null) BeforeForBody.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForStmtBegin!=null) ForStmtBegin.traverseBottomUp(visitor);
        if(DesignatorStmtList!=null) DesignatorStmtList.traverseBottomUp(visitor);
        if(BeforeForUpdate!=null) BeforeForUpdate.traverseBottomUp(visitor);
        if(DesignatorStmtList1!=null) DesignatorStmtList1.traverseBottomUp(visitor);
        if(BeforeForBody!=null) BeforeForBody.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForStmtNoCondFact(\n");

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

        if(BeforeForUpdate!=null)
            buffer.append(BeforeForUpdate.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStmtList1!=null)
            buffer.append(DesignatorStmtList1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BeforeForBody!=null)
            buffer.append(BeforeForBody.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForStmtNoCondFact]");
        return buffer.toString();
    }
}
