// generated with ast extension for cup
// version 0.8
// 28/11/2023 12:50:31


package rs.ac.bg.etf.pp1.ast;

public class DesignatorIdentTwo extends Designator {

    private String I1;
    private Designator2Stmt Designator2Stmt;

    public DesignatorIdentTwo (String I1, Designator2Stmt Designator2Stmt) {
        this.I1=I1;
        this.Designator2Stmt=Designator2Stmt;
        if(Designator2Stmt!=null) Designator2Stmt.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Designator2Stmt getDesignator2Stmt() {
        return Designator2Stmt;
    }

    public void setDesignator2Stmt(Designator2Stmt Designator2Stmt) {
        this.Designator2Stmt=Designator2Stmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator2Stmt!=null) Designator2Stmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator2Stmt!=null) Designator2Stmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator2Stmt!=null) Designator2Stmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorIdentTwo(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Designator2Stmt!=null)
            buffer.append(Designator2Stmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorIdentTwo]");
        return buffer.toString();
    }
}
