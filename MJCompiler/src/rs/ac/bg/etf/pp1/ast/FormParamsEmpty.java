// generated with ast extension for cup
// version 0.8
// 4/1/2024 12:17:16


package rs.ac.bg.etf.pp1.ast;

public class FormParamsEmpty extends FormPars {

    public FormParamsEmpty () {
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
        buffer.append("FormParamsEmpty(\n");

        buffer.append(tab);
        buffer.append(") [FormParamsEmpty]");
        return buffer.toString();
    }
}
