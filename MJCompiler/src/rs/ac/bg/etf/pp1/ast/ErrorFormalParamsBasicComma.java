// generated with ast extension for cup
// version 0.8
// 24/0/2024 23:47:6


package rs.ac.bg.etf.pp1.ast;

public class ErrorFormalParamsBasicComma extends FormParsComma {

    public ErrorFormalParamsBasicComma () {
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
        buffer.append("ErrorFormalParamsBasicComma(\n");

        buffer.append(tab);
        buffer.append(") [ErrorFormalParamsBasicComma]");
        return buffer.toString();
    }
}
