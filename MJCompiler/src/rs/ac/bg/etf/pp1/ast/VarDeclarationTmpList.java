// generated with ast extension for cup
// version 0.8
// 17/0/2024 20:36:30


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationTmpList extends VarDeclTmpList {

    private VarDeclComma VarDeclComma;
    private VarDeclTmpList VarDeclTmpList;

    public VarDeclarationTmpList (VarDeclComma VarDeclComma, VarDeclTmpList VarDeclTmpList) {
        this.VarDeclComma=VarDeclComma;
        if(VarDeclComma!=null) VarDeclComma.setParent(this);
        this.VarDeclTmpList=VarDeclTmpList;
        if(VarDeclTmpList!=null) VarDeclTmpList.setParent(this);
    }

    public VarDeclComma getVarDeclComma() {
        return VarDeclComma;
    }

    public void setVarDeclComma(VarDeclComma VarDeclComma) {
        this.VarDeclComma=VarDeclComma;
    }

    public VarDeclTmpList getVarDeclTmpList() {
        return VarDeclTmpList;
    }

    public void setVarDeclTmpList(VarDeclTmpList VarDeclTmpList) {
        this.VarDeclTmpList=VarDeclTmpList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclComma!=null) VarDeclComma.accept(visitor);
        if(VarDeclTmpList!=null) VarDeclTmpList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclComma!=null) VarDeclComma.traverseTopDown(visitor);
        if(VarDeclTmpList!=null) VarDeclTmpList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclComma!=null) VarDeclComma.traverseBottomUp(visitor);
        if(VarDeclTmpList!=null) VarDeclTmpList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationTmpList(\n");

        if(VarDeclComma!=null)
            buffer.append(VarDeclComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclTmpList!=null)
            buffer.append(VarDeclTmpList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationTmpList]");
        return buffer.toString();
    }
}
