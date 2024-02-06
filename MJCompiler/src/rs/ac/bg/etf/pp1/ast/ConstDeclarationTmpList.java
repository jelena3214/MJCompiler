// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationTmpList extends ConstDeclTmpList {

    private ConstDeclComma ConstDeclComma;
    private ConstDeclTmpList ConstDeclTmpList;

    public ConstDeclarationTmpList (ConstDeclComma ConstDeclComma, ConstDeclTmpList ConstDeclTmpList) {
        this.ConstDeclComma=ConstDeclComma;
        if(ConstDeclComma!=null) ConstDeclComma.setParent(this);
        this.ConstDeclTmpList=ConstDeclTmpList;
        if(ConstDeclTmpList!=null) ConstDeclTmpList.setParent(this);
    }

    public ConstDeclComma getConstDeclComma() {
        return ConstDeclComma;
    }

    public void setConstDeclComma(ConstDeclComma ConstDeclComma) {
        this.ConstDeclComma=ConstDeclComma;
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
        if(ConstDeclComma!=null) ConstDeclComma.accept(visitor);
        if(ConstDeclTmpList!=null) ConstDeclTmpList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclComma!=null) ConstDeclComma.traverseTopDown(visitor);
        if(ConstDeclTmpList!=null) ConstDeclTmpList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclComma!=null) ConstDeclComma.traverseBottomUp(visitor);
        if(ConstDeclTmpList!=null) ConstDeclTmpList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationTmpList(\n");

        if(ConstDeclComma!=null)
            buffer.append(ConstDeclComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclTmpList!=null)
            buffer.append(ConstDeclTmpList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationTmpList]");
        return buffer.toString();
    }
}
