// generated with ast extension for cup
// version 0.8
// 24/0/2024 23:47:6


package rs.ac.bg.etf.pp1.ast;

public class DesignatorIndexing extends Designator {

    private ArrayDesignatorDecl ArrayDesignatorDecl;
    private Expr Expr;

    public DesignatorIndexing (ArrayDesignatorDecl ArrayDesignatorDecl, Expr Expr) {
        this.ArrayDesignatorDecl=ArrayDesignatorDecl;
        if(ArrayDesignatorDecl!=null) ArrayDesignatorDecl.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ArrayDesignatorDecl getArrayDesignatorDecl() {
        return ArrayDesignatorDecl;
    }

    public void setArrayDesignatorDecl(ArrayDesignatorDecl ArrayDesignatorDecl) {
        this.ArrayDesignatorDecl=ArrayDesignatorDecl;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayDesignatorDecl!=null) ArrayDesignatorDecl.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayDesignatorDecl!=null) ArrayDesignatorDecl.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayDesignatorDecl!=null) ArrayDesignatorDecl.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorIndexing(\n");

        if(ArrayDesignatorDecl!=null)
            buffer.append(ArrayDesignatorDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorIndexing]");
        return buffer.toString();
    }
}
