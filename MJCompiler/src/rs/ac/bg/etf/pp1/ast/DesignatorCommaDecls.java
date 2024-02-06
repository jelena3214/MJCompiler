// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class DesignatorCommaDecls extends DesignatorCommaList {

    private DesignatorCommaList DesignatorCommaList;
    private DesignatorCommaElem DesignatorCommaElem;

    public DesignatorCommaDecls (DesignatorCommaList DesignatorCommaList, DesignatorCommaElem DesignatorCommaElem) {
        this.DesignatorCommaList=DesignatorCommaList;
        if(DesignatorCommaList!=null) DesignatorCommaList.setParent(this);
        this.DesignatorCommaElem=DesignatorCommaElem;
        if(DesignatorCommaElem!=null) DesignatorCommaElem.setParent(this);
    }

    public DesignatorCommaList getDesignatorCommaList() {
        return DesignatorCommaList;
    }

    public void setDesignatorCommaList(DesignatorCommaList DesignatorCommaList) {
        this.DesignatorCommaList=DesignatorCommaList;
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
        if(DesignatorCommaList!=null) DesignatorCommaList.accept(visitor);
        if(DesignatorCommaElem!=null) DesignatorCommaElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorCommaList!=null) DesignatorCommaList.traverseTopDown(visitor);
        if(DesignatorCommaElem!=null) DesignatorCommaElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorCommaList!=null) DesignatorCommaList.traverseBottomUp(visitor);
        if(DesignatorCommaElem!=null) DesignatorCommaElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorCommaDecls(\n");

        if(DesignatorCommaList!=null)
            buffer.append(DesignatorCommaList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorCommaElem!=null)
            buffer.append(DesignatorCommaElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorCommaDecls]");
        return buffer.toString();
    }
}
