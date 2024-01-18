// generated with ast extension for cup
// version 0.8
// 17/0/2024 20:36:30


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private DesignatorDecl DesignatorDecl;
    private DesignatorOrList DesignatorOrList;

    public Designator (DesignatorDecl DesignatorDecl, DesignatorOrList DesignatorOrList) {
        this.DesignatorDecl=DesignatorDecl;
        if(DesignatorDecl!=null) DesignatorDecl.setParent(this);
        this.DesignatorOrList=DesignatorOrList;
        if(DesignatorOrList!=null) DesignatorOrList.setParent(this);
    }

    public DesignatorDecl getDesignatorDecl() {
        return DesignatorDecl;
    }

    public void setDesignatorDecl(DesignatorDecl DesignatorDecl) {
        this.DesignatorDecl=DesignatorDecl;
    }

    public DesignatorOrList getDesignatorOrList() {
        return DesignatorOrList;
    }

    public void setDesignatorOrList(DesignatorOrList DesignatorOrList) {
        this.DesignatorOrList=DesignatorOrList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorDecl!=null) DesignatorDecl.accept(visitor);
        if(DesignatorOrList!=null) DesignatorOrList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorDecl!=null) DesignatorDecl.traverseTopDown(visitor);
        if(DesignatorOrList!=null) DesignatorOrList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorDecl!=null) DesignatorDecl.traverseBottomUp(visitor);
        if(DesignatorOrList!=null) DesignatorOrList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        if(DesignatorDecl!=null)
            buffer.append(DesignatorDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorOrList!=null)
            buffer.append(DesignatorOrList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
