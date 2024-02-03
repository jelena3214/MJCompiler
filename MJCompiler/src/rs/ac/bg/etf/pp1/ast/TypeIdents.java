// generated with ast extension for cup
// version 0.8
// 28/11/2023 12:50:31


package rs.ac.bg.etf.pp1.ast;

public class TypeIdents extends TypeIdentList {

    private TypeIdentList TypeIdentList;
    private TypeIdentElem TypeIdentElem;

    public TypeIdents (TypeIdentList TypeIdentList, TypeIdentElem TypeIdentElem) {
        this.TypeIdentList=TypeIdentList;
        if(TypeIdentList!=null) TypeIdentList.setParent(this);
        this.TypeIdentElem=TypeIdentElem;
        if(TypeIdentElem!=null) TypeIdentElem.setParent(this);
    }

    public TypeIdentList getTypeIdentList() {
        return TypeIdentList;
    }

    public void setTypeIdentList(TypeIdentList TypeIdentList) {
        this.TypeIdentList=TypeIdentList;
    }

    public TypeIdentElem getTypeIdentElem() {
        return TypeIdentElem;
    }

    public void setTypeIdentElem(TypeIdentElem TypeIdentElem) {
        this.TypeIdentElem=TypeIdentElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.accept(visitor);
        if(TypeIdentElem!=null) TypeIdentElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeIdentList!=null) TypeIdentList.traverseTopDown(visitor);
        if(TypeIdentElem!=null) TypeIdentElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.traverseBottomUp(visitor);
        if(TypeIdentElem!=null) TypeIdentElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TypeIdents(\n");

        if(TypeIdentList!=null)
            buffer.append(TypeIdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TypeIdentElem!=null)
            buffer.append(TypeIdentElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeIdents]");
        return buffer.toString();
    }
}
