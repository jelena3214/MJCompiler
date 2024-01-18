// generated with ast extension for cup
// version 0.8
// 17/0/2024 20:36:30


package rs.ac.bg.etf.pp1.ast;

public class TypeNamespaceIdent extends Type {

    private String namespaceName;
    private String typeName;

    public TypeNamespaceIdent (String namespaceName, String typeName) {
        this.namespaceName=namespaceName;
        this.typeName=typeName;
    }

    public String getNamespaceName() {
        return namespaceName;
    }

    public void setNamespaceName(String namespaceName) {
        this.namespaceName=namespaceName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName=typeName;
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
        buffer.append("TypeNamespaceIdent(\n");

        buffer.append(" "+tab+namespaceName);
        buffer.append("\n");

        buffer.append(" "+tab+typeName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeNamespaceIdent]");
        return buffer.toString();
    }
}
