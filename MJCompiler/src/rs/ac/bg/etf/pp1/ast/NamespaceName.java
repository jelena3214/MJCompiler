// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class NamespaceName implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private String N1;
    private String namespaceName;

    public NamespaceName (String N1, String namespaceName) {
        this.N1=N1;
        this.namespaceName=namespaceName;
    }

    public String getN1() {
        return N1;
    }

    public void setN1(String N1) {
        this.N1=N1;
    }

    public String getNamespaceName() {
        return namespaceName;
    }

    public void setNamespaceName(String namespaceName) {
        this.namespaceName=namespaceName;
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
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NamespaceName(\n");

        buffer.append(" "+tab+N1);
        buffer.append("\n");

        buffer.append(" "+tab+namespaceName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespaceName]");
        return buffer.toString();
    }
}
