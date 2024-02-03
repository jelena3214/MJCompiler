// generated with ast extension for cup
// version 0.8
// 28/11/2023 12:50:31


package rs.ac.bg.etf.pp1.ast;

public class NoTypeIdents extends TypeIdentList {

    public NoTypeIdents () {
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
        buffer.append("NoTypeIdents(\n");

        buffer.append(tab);
        buffer.append(") [NoTypeIdents]");
        return buffer.toString();
    }
}
