// generated with ast extension for cup
// version 0.8
// 28/11/2023 12:50:31


package rs.ac.bg.etf.pp1.ast;

public class Designator2StmtIdent extends Designator2Stmt {

    private DesignatorOrList DesignatorOrList;

    public Designator2StmtIdent (DesignatorOrList DesignatorOrList) {
        this.DesignatorOrList=DesignatorOrList;
        if(DesignatorOrList!=null) DesignatorOrList.setParent(this);
    }

    public DesignatorOrList getDesignatorOrList() {
        return DesignatorOrList;
    }

    public void setDesignatorOrList(DesignatorOrList DesignatorOrList) {
        this.DesignatorOrList=DesignatorOrList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorOrList!=null) DesignatorOrList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorOrList!=null) DesignatorOrList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorOrList!=null) DesignatorOrList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator2StmtIdent(\n");

        if(DesignatorOrList!=null)
            buffer.append(DesignatorOrList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator2StmtIdent]");
        return buffer.toString();
    }
}
