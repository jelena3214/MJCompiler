// generated with ast extension for cup
// version 0.8
// 17/0/2024 20:36:30


package rs.ac.bg.etf.pp1.ast;

public class DesignatorOrListDecl extends DesignatorOrList {

    private DesignatorOrList DesignatorOrList;
    private DesignatorOr DesignatorOr;

    public DesignatorOrListDecl (DesignatorOrList DesignatorOrList, DesignatorOr DesignatorOr) {
        this.DesignatorOrList=DesignatorOrList;
        if(DesignatorOrList!=null) DesignatorOrList.setParent(this);
        this.DesignatorOr=DesignatorOr;
        if(DesignatorOr!=null) DesignatorOr.setParent(this);
    }

    public DesignatorOrList getDesignatorOrList() {
        return DesignatorOrList;
    }

    public void setDesignatorOrList(DesignatorOrList DesignatorOrList) {
        this.DesignatorOrList=DesignatorOrList;
    }

    public DesignatorOr getDesignatorOr() {
        return DesignatorOr;
    }

    public void setDesignatorOr(DesignatorOr DesignatorOr) {
        this.DesignatorOr=DesignatorOr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorOrList!=null) DesignatorOrList.accept(visitor);
        if(DesignatorOr!=null) DesignatorOr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorOrList!=null) DesignatorOrList.traverseTopDown(visitor);
        if(DesignatorOr!=null) DesignatorOr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorOrList!=null) DesignatorOrList.traverseBottomUp(visitor);
        if(DesignatorOr!=null) DesignatorOr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorOrListDecl(\n");

        if(DesignatorOrList!=null)
            buffer.append(DesignatorOrList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorOr!=null)
            buffer.append(DesignatorOr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorOrListDecl]");
        return buffer.toString();
    }
}
