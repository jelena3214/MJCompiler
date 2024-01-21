// generated with ast extension for cup
// version 0.8
// 21/0/2024 21:47:4


package rs.ac.bg.etf.pp1.ast;

public class AddopTermDecl extends AddopTermList {

    private AddopTermList AddopTermList;
    private AddopTermElem AddopTermElem;

    public AddopTermDecl (AddopTermList AddopTermList, AddopTermElem AddopTermElem) {
        this.AddopTermList=AddopTermList;
        if(AddopTermList!=null) AddopTermList.setParent(this);
        this.AddopTermElem=AddopTermElem;
        if(AddopTermElem!=null) AddopTermElem.setParent(this);
    }

    public AddopTermList getAddopTermList() {
        return AddopTermList;
    }

    public void setAddopTermList(AddopTermList AddopTermList) {
        this.AddopTermList=AddopTermList;
    }

    public AddopTermElem getAddopTermElem() {
        return AddopTermElem;
    }

    public void setAddopTermElem(AddopTermElem AddopTermElem) {
        this.AddopTermElem=AddopTermElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddopTermList!=null) AddopTermList.accept(visitor);
        if(AddopTermElem!=null) AddopTermElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddopTermList!=null) AddopTermList.traverseTopDown(visitor);
        if(AddopTermElem!=null) AddopTermElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddopTermList!=null) AddopTermList.traverseBottomUp(visitor);
        if(AddopTermElem!=null) AddopTermElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddopTermDecl(\n");

        if(AddopTermList!=null)
            buffer.append(AddopTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopTermElem!=null)
            buffer.append(AddopTermElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddopTermDecl]");
        return buffer.toString();
    }
}
