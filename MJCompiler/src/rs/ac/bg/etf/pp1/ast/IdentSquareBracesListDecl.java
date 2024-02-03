// generated with ast extension for cup
// version 0.8
// 28/11/2023 12:50:31


package rs.ac.bg.etf.pp1.ast;

public class IdentSquareBracesListDecl extends IdentSquareBracesList {

    private IdentSquareBracesList IdentSquareBracesList;
    private IdentSquareBracesElem IdentSquareBracesElem;

    public IdentSquareBracesListDecl (IdentSquareBracesList IdentSquareBracesList, IdentSquareBracesElem IdentSquareBracesElem) {
        this.IdentSquareBracesList=IdentSquareBracesList;
        if(IdentSquareBracesList!=null) IdentSquareBracesList.setParent(this);
        this.IdentSquareBracesElem=IdentSquareBracesElem;
        if(IdentSquareBracesElem!=null) IdentSquareBracesElem.setParent(this);
    }

    public IdentSquareBracesList getIdentSquareBracesList() {
        return IdentSquareBracesList;
    }

    public void setIdentSquareBracesList(IdentSquareBracesList IdentSquareBracesList) {
        this.IdentSquareBracesList=IdentSquareBracesList;
    }

    public IdentSquareBracesElem getIdentSquareBracesElem() {
        return IdentSquareBracesElem;
    }

    public void setIdentSquareBracesElem(IdentSquareBracesElem IdentSquareBracesElem) {
        this.IdentSquareBracesElem=IdentSquareBracesElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentSquareBracesList!=null) IdentSquareBracesList.accept(visitor);
        if(IdentSquareBracesElem!=null) IdentSquareBracesElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentSquareBracesList!=null) IdentSquareBracesList.traverseTopDown(visitor);
        if(IdentSquareBracesElem!=null) IdentSquareBracesElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentSquareBracesList!=null) IdentSquareBracesList.traverseBottomUp(visitor);
        if(IdentSquareBracesElem!=null) IdentSquareBracesElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentSquareBracesListDecl(\n");

        if(IdentSquareBracesList!=null)
            buffer.append(IdentSquareBracesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentSquareBracesElem!=null)
            buffer.append(IdentSquareBracesElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentSquareBracesListDecl]");
        return buffer.toString();
    }
}
