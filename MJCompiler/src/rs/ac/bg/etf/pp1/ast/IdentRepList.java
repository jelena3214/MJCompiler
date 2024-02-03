// generated with ast extension for cup
// version 0.8
// 28/11/2023 12:50:31


package rs.ac.bg.etf.pp1.ast;

public class IdentRepList extends IdentRep {

    private IdentRep IdentRep;
    private IdentRepElem IdentRepElem;

    public IdentRepList (IdentRep IdentRep, IdentRepElem IdentRepElem) {
        this.IdentRep=IdentRep;
        if(IdentRep!=null) IdentRep.setParent(this);
        this.IdentRepElem=IdentRepElem;
        if(IdentRepElem!=null) IdentRepElem.setParent(this);
    }

    public IdentRep getIdentRep() {
        return IdentRep;
    }

    public void setIdentRep(IdentRep IdentRep) {
        this.IdentRep=IdentRep;
    }

    public IdentRepElem getIdentRepElem() {
        return IdentRepElem;
    }

    public void setIdentRepElem(IdentRepElem IdentRepElem) {
        this.IdentRepElem=IdentRepElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentRep!=null) IdentRep.accept(visitor);
        if(IdentRepElem!=null) IdentRepElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentRep!=null) IdentRep.traverseTopDown(visitor);
        if(IdentRepElem!=null) IdentRepElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentRep!=null) IdentRep.traverseBottomUp(visitor);
        if(IdentRepElem!=null) IdentRepElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentRepList(\n");

        if(IdentRep!=null)
            buffer.append(IdentRep.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentRepElem!=null)
            buffer.append(IdentRepElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentRepList]");
        return buffer.toString();
    }
}
