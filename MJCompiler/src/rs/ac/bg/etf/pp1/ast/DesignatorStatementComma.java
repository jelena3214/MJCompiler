// generated with ast extension for cup
// version 0.8
// 24/0/2024 23:47:6


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementComma extends DesignatorStatementCommaList {

    private DesignatorStatementCommaElem DesignatorStatementCommaElem;
    private DesignatorStatementCommaList DesignatorStatementCommaList;

    public DesignatorStatementComma (DesignatorStatementCommaElem DesignatorStatementCommaElem, DesignatorStatementCommaList DesignatorStatementCommaList) {
        this.DesignatorStatementCommaElem=DesignatorStatementCommaElem;
        if(DesignatorStatementCommaElem!=null) DesignatorStatementCommaElem.setParent(this);
        this.DesignatorStatementCommaList=DesignatorStatementCommaList;
        if(DesignatorStatementCommaList!=null) DesignatorStatementCommaList.setParent(this);
    }

    public DesignatorStatementCommaElem getDesignatorStatementCommaElem() {
        return DesignatorStatementCommaElem;
    }

    public void setDesignatorStatementCommaElem(DesignatorStatementCommaElem DesignatorStatementCommaElem) {
        this.DesignatorStatementCommaElem=DesignatorStatementCommaElem;
    }

    public DesignatorStatementCommaList getDesignatorStatementCommaList() {
        return DesignatorStatementCommaList;
    }

    public void setDesignatorStatementCommaList(DesignatorStatementCommaList DesignatorStatementCommaList) {
        this.DesignatorStatementCommaList=DesignatorStatementCommaList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementCommaElem!=null) DesignatorStatementCommaElem.accept(visitor);
        if(DesignatorStatementCommaList!=null) DesignatorStatementCommaList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementCommaElem!=null) DesignatorStatementCommaElem.traverseTopDown(visitor);
        if(DesignatorStatementCommaList!=null) DesignatorStatementCommaList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementCommaElem!=null) DesignatorStatementCommaElem.traverseBottomUp(visitor);
        if(DesignatorStatementCommaList!=null) DesignatorStatementCommaList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementComma(\n");

        if(DesignatorStatementCommaElem!=null)
            buffer.append(DesignatorStatementCommaElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementCommaList!=null)
            buffer.append(DesignatorStatementCommaList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementComma]");
        return buffer.toString();
    }
}
