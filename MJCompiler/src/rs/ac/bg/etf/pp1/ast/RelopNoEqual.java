// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class RelopNoEqual extends Relop {

    public RelopNoEqual () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RelopNoEqual(\n");

        buffer.append(tab);
        buffer.append(") [RelopNoEqual]");
        return buffer.toString();
    }
}
