// generated with ast extension for cup
// version 0.8
// 17/0/2024 20:36:30


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmt extends Statement {

    private DesignatorStatementSemi DesignatorStatementSemi;

    public DesignatorStmt (DesignatorStatementSemi DesignatorStatementSemi) {
        this.DesignatorStatementSemi=DesignatorStatementSemi;
        if(DesignatorStatementSemi!=null) DesignatorStatementSemi.setParent(this);
    }

    public DesignatorStatementSemi getDesignatorStatementSemi() {
        return DesignatorStatementSemi;
    }

    public void setDesignatorStatementSemi(DesignatorStatementSemi DesignatorStatementSemi) {
        this.DesignatorStatementSemi=DesignatorStatementSemi;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementSemi!=null) DesignatorStatementSemi.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementSemi!=null) DesignatorStatementSemi.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementSemi!=null) DesignatorStatementSemi.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmt(\n");

        if(DesignatorStatementSemi!=null)
            buffer.append(DesignatorStatementSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmt]");
        return buffer.toString();
    }
}
