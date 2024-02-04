// generated with ast extension for cup
// version 0.8
// 4/1/2024 12:17:16


package rs.ac.bg.etf.pp1.ast;

public class NoDesignatorCommaList extends DesignatorCommaList {

    private DesignatorCommaElem DesignatorCommaElem;

    public NoDesignatorCommaList (DesignatorCommaElem DesignatorCommaElem) {
        this.DesignatorCommaElem=DesignatorCommaElem;
        if(DesignatorCommaElem!=null) DesignatorCommaElem.setParent(this);
    }

    public DesignatorCommaElem getDesignatorCommaElem() {
        return DesignatorCommaElem;
    }

    public void setDesignatorCommaElem(DesignatorCommaElem DesignatorCommaElem) {
        this.DesignatorCommaElem=DesignatorCommaElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorCommaElem!=null) DesignatorCommaElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorCommaElem!=null) DesignatorCommaElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorCommaElem!=null) DesignatorCommaElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoDesignatorCommaList(\n");

        if(DesignatorCommaElem!=null)
            buffer.append(DesignatorCommaElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoDesignatorCommaList]");
        return buffer.toString();
    }
}
