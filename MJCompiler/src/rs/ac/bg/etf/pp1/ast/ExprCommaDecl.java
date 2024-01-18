// generated with ast extension for cup
// version 0.8
// 17/0/2024 20:36:30


package rs.ac.bg.etf.pp1.ast;

public class ExprCommaDecl extends ExprCommaList {

    private ExprCommaList ExprCommaList;
    private ExprCommaElem ExprCommaElem;

    public ExprCommaDecl (ExprCommaList ExprCommaList, ExprCommaElem ExprCommaElem) {
        this.ExprCommaList=ExprCommaList;
        if(ExprCommaList!=null) ExprCommaList.setParent(this);
        this.ExprCommaElem=ExprCommaElem;
        if(ExprCommaElem!=null) ExprCommaElem.setParent(this);
    }

    public ExprCommaList getExprCommaList() {
        return ExprCommaList;
    }

    public void setExprCommaList(ExprCommaList ExprCommaList) {
        this.ExprCommaList=ExprCommaList;
    }

    public ExprCommaElem getExprCommaElem() {
        return ExprCommaElem;
    }

    public void setExprCommaElem(ExprCommaElem ExprCommaElem) {
        this.ExprCommaElem=ExprCommaElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprCommaList!=null) ExprCommaList.accept(visitor);
        if(ExprCommaElem!=null) ExprCommaElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprCommaList!=null) ExprCommaList.traverseTopDown(visitor);
        if(ExprCommaElem!=null) ExprCommaElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprCommaList!=null) ExprCommaList.traverseBottomUp(visitor);
        if(ExprCommaElem!=null) ExprCommaElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprCommaDecl(\n");

        if(ExprCommaList!=null)
            buffer.append(ExprCommaList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprCommaElem!=null)
            buffer.append(ExprCommaElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprCommaDecl]");
        return buffer.toString();
    }
}
