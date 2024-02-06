// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class VarDeclTmp implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String varName;
    private SquareBracesList SquareBracesList;

    public VarDeclTmp (String varName, SquareBracesList SquareBracesList) {
        this.varName=varName;
        this.SquareBracesList=SquareBracesList;
        if(SquareBracesList!=null) SquareBracesList.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
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
        buffer.append("VarDeclTmp(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(SquareBracesList!=null)
            buffer.append(SquareBracesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclTmp]");
        return buffer.toString();
    }
}
