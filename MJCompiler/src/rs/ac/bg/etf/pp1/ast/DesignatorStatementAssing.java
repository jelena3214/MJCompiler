// generated with ast extension for cup
// version 0.8
// 28/11/2023 12:50:31


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementAssing extends DesignatorStatement {

    private Designator Designator;
    private DesignatorStatementOr DesignatorStatementOr;

    public DesignatorStatementAssing (Designator Designator, DesignatorStatementOr DesignatorStatementOr) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DesignatorStatementOr=DesignatorStatementOr;
        if(DesignatorStatementOr!=null) DesignatorStatementOr.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DesignatorStatementOr getDesignatorStatementOr() {
        return DesignatorStatementOr;
    }

    public void setDesignatorStatementOr(DesignatorStatementOr DesignatorStatementOr) {
        this.DesignatorStatementOr=DesignatorStatementOr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DesignatorStatementOr!=null) DesignatorStatementOr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DesignatorStatementOr!=null) DesignatorStatementOr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DesignatorStatementOr!=null) DesignatorStatementOr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementAssing(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementOr!=null)
            buffer.append(DesignatorStatementOr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementAssing]");
        return buffer.toString();
    }
}
