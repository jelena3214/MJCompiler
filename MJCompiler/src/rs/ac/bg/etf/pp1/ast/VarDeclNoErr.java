// generated with ast extension for cup
// version 0.8
// 17/0/2024 20:36:30


package rs.ac.bg.etf.pp1.ast;

public class VarDeclNoErr extends VarDecl {

    private VarDeclType VarDeclType;
    private VarDeclTmpList VarDeclTmpList;

    public VarDeclNoErr (VarDeclType VarDeclType, VarDeclTmpList VarDeclTmpList) {
        this.VarDeclType=VarDeclType;
        if(VarDeclType!=null) VarDeclType.setParent(this);
        this.VarDeclTmpList=VarDeclTmpList;
        if(VarDeclTmpList!=null) VarDeclTmpList.setParent(this);
    }

    public VarDeclType getVarDeclType() {
        return VarDeclType;
    }

    public void setVarDeclType(VarDeclType VarDeclType) {
        this.VarDeclType=VarDeclType;
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
        if(VarDeclType!=null) VarDeclType.accept(visitor);
        if(VarDeclTmpList!=null) VarDeclTmpList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclType!=null) VarDeclType.traverseTopDown(visitor);
        if(VarDeclTmpList!=null) VarDeclTmpList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclType!=null) VarDeclType.traverseBottomUp(visitor);
        if(VarDeclTmpList!=null) VarDeclTmpList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclNoErr(\n");

        if(VarDeclType!=null)
            buffer.append(VarDeclType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclTmpList!=null)
            buffer.append(VarDeclTmpList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclNoErr]");
        return buffer.toString();
    }
}
