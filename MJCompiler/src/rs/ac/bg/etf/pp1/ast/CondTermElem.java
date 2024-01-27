// generated with ast extension for cup
// version 0.8
// 27/0/2024 21:36:19


package rs.ac.bg.etf.pp1.ast;

public class CondTermElem implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private PatchAnd PatchAnd;
    private CondTerm CondTerm;

    public CondTermElem (PatchAnd PatchAnd, CondTerm CondTerm) {
        this.PatchAnd=PatchAnd;
        if(PatchAnd!=null) PatchAnd.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public PatchAnd getPatchAnd() {
        return PatchAnd;
    }

    public void setPatchAnd(PatchAnd PatchAnd) {
        this.PatchAnd=PatchAnd;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
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
        if(PatchAnd!=null) PatchAnd.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PatchAnd!=null) PatchAnd.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PatchAnd!=null) PatchAnd.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermElem(\n");

        if(PatchAnd!=null)
            buffer.append(PatchAnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermElem]");
        return buffer.toString();
    }
}
