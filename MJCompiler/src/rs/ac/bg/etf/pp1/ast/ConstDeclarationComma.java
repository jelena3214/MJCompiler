// generated with ast extension for cup
// version 0.8
// 21/0/2024 21:47:4


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationComma extends ConstDeclComma {

    private ConstDeclTmp ConstDeclTmp;

    public ConstDeclarationComma (ConstDeclTmp ConstDeclTmp) {
        this.ConstDeclTmp=ConstDeclTmp;
        if(ConstDeclTmp!=null) ConstDeclTmp.setParent(this);
    }

    public ConstDeclTmp getConstDeclTmp() {
        return ConstDeclTmp;
    }

    public void setConstDeclTmp(ConstDeclTmp ConstDeclTmp) {
        this.ConstDeclTmp=ConstDeclTmp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclTmp!=null) ConstDeclTmp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclTmp!=null) ConstDeclTmp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclTmp!=null) ConstDeclTmp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationComma(\n");

        if(ConstDeclTmp!=null)
            buffer.append(ConstDeclTmp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationComma]");
        return buffer.toString();
    }
}
