// generated with ast extension for cup
// version 0.8
// 21/0/2024 21:47:4


package rs.ac.bg.etf.pp1.ast;

public class CondFactDecl extends CondFactList {

    private CondFactList CondFactList;
    private CondFactElem CondFactElem;

    public CondFactDecl (CondFactList CondFactList, CondFactElem CondFactElem) {
        this.CondFactList=CondFactList;
        if(CondFactList!=null) CondFactList.setParent(this);
        this.CondFactElem=CondFactElem;
        if(CondFactElem!=null) CondFactElem.setParent(this);
    }

    public CondFactList getCondFactList() {
        return CondFactList;
    }

    public void setCondFactList(CondFactList CondFactList) {
        this.CondFactList=CondFactList;
    }

    public CondFactElem getCondFactElem() {
        return CondFactElem;
    }

    public void setCondFactElem(CondFactElem CondFactElem) {
        this.CondFactElem=CondFactElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFactList!=null) CondFactList.accept(visitor);
        if(CondFactElem!=null) CondFactElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactList!=null) CondFactList.traverseTopDown(visitor);
        if(CondFactElem!=null) CondFactElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactList!=null) CondFactList.traverseBottomUp(visitor);
        if(CondFactElem!=null) CondFactElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactDecl(\n");

        if(CondFactList!=null)
            buffer.append(CondFactList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFactElem!=null)
            buffer.append(CondFactElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactDecl]");
        return buffer.toString();
    }
}
