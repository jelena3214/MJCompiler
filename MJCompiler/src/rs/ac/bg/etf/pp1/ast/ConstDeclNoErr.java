// generated with ast extension for cup
// version 0.8
// 17/0/2024 20:36:30


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclNoErr extends ConstDecl {

    private ConstDeclType ConstDeclType;
    private ConstDeclTmpList ConstDeclTmpList;

    public ConstDeclNoErr (ConstDeclType ConstDeclType, ConstDeclTmpList ConstDeclTmpList) {
        this.ConstDeclType=ConstDeclType;
        if(ConstDeclType!=null) ConstDeclType.setParent(this);
        this.ConstDeclTmpList=ConstDeclTmpList;
        if(ConstDeclTmpList!=null) ConstDeclTmpList.setParent(this);
    }

    public ConstDeclType getConstDeclType() {
        return ConstDeclType;
    }

    public void setConstDeclType(ConstDeclType ConstDeclType) {
        this.ConstDeclType=ConstDeclType;
    }

    public ConstDeclTmpList getConstDeclTmpList() {
        return ConstDeclTmpList;
    }

    public void setConstDeclTmpList(ConstDeclTmpList ConstDeclTmpList) {
        this.ConstDeclTmpList=ConstDeclTmpList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclType!=null) ConstDeclType.accept(visitor);
        if(ConstDeclTmpList!=null) ConstDeclTmpList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclType!=null) ConstDeclType.traverseTopDown(visitor);
        if(ConstDeclTmpList!=null) ConstDeclTmpList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclType!=null) ConstDeclType.traverseBottomUp(visitor);
        if(ConstDeclTmpList!=null) ConstDeclTmpList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclNoErr(\n");

        if(ConstDeclType!=null)
            buffer.append(ConstDeclType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclTmpList!=null)
            buffer.append(ConstDeclTmpList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclNoErr]");
        return buffer.toString();
    }
}
