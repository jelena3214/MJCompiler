// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationComma extends VarDeclComma {

    private VarDeclTmp VarDeclTmp;

    public VarDeclarationComma (VarDeclTmp VarDeclTmp) {
        this.VarDeclTmp=VarDeclTmp;
        if(VarDeclTmp!=null) VarDeclTmp.setParent(this);
    }

    public VarDeclTmp getVarDeclTmp() {
        return VarDeclTmp;
    }

    public void setVarDeclTmp(VarDeclTmp VarDeclTmp) {
        this.VarDeclTmp=VarDeclTmp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclTmp!=null) VarDeclTmp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclTmp!=null) VarDeclTmp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclTmp!=null) VarDeclTmp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationComma(\n");

        if(VarDeclTmp!=null)
            buffer.append(VarDeclTmp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationComma]");
        return buffer.toString();
    }
}
