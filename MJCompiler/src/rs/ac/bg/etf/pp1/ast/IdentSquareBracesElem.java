// generated with ast extension for cup
// version 0.8
// 28/11/2023 12:50:31


package rs.ac.bg.etf.pp1.ast;

public class IdentSquareBracesElem implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private SquareBracesList SquareBracesList;

    public IdentSquareBracesElem (String I1, SquareBracesList SquareBracesList) {
        this.I1=I1;
        this.SquareBracesList=SquareBracesList;
        if(SquareBracesList!=null) SquareBracesList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public SquareBracesList getSquareBracesList() {
        return SquareBracesList;
    }

    public void setSquareBracesList(SquareBracesList SquareBracesList) {
        this.SquareBracesList=SquareBracesList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SquareBracesList!=null) SquareBracesList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SquareBracesList!=null) SquareBracesList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SquareBracesList!=null) SquareBracesList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentSquareBracesElem(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(SquareBracesList!=null)
            buffer.append(SquareBracesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentSquareBracesElem]");
        return buffer.toString();
    }
}
