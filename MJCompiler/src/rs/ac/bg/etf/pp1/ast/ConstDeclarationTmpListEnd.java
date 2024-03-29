// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationTmpListEnd extends ConstDeclTmpList {

    private ConstDeclSemi ConstDeclSemi;

    public ConstDeclarationTmpListEnd (ConstDeclSemi ConstDeclSemi) {
        this.ConstDeclSemi=ConstDeclSemi;
        if(ConstDeclSemi!=null) ConstDeclSemi.setParent(this);
    }

    public ConstDeclSemi getConstDeclSemi() {
        return ConstDeclSemi;
    }

    public void setConstDeclSemi(ConstDeclSemi ConstDeclSemi) {
        this.ConstDeclSemi=ConstDeclSemi;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclSemi!=null) ConstDeclSemi.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclSemi!=null) ConstDeclSemi.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclSemi!=null) ConstDeclSemi.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationTmpListEnd(\n");

        if(ConstDeclSemi!=null)
            buffer.append(ConstDeclSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationTmpListEnd]");
        return buffer.toString();
    }
}
