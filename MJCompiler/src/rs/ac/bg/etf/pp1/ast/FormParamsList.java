// generated with ast extension for cup
// version 0.8
// 21/0/2024 21:47:4


package rs.ac.bg.etf.pp1.ast;

public class FormParamsList extends FormPars {

    private FormParsCommaList FormParsCommaList;

    public FormParamsList (FormParsCommaList FormParsCommaList) {
        this.FormParsCommaList=FormParsCommaList;
        if(FormParsCommaList!=null) FormParsCommaList.setParent(this);
    }

    public FormParsCommaList getFormParsCommaList() {
        return FormParsCommaList;
    }

    public void setFormParsCommaList(FormParsCommaList FormParsCommaList) {
        this.FormParsCommaList=FormParsCommaList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsCommaList!=null) FormParsCommaList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsCommaList!=null) FormParsCommaList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsCommaList!=null) FormParsCommaList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParamsList(\n");

        if(FormParsCommaList!=null)
            buffer.append(FormParsCommaList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParamsList]");
        return buffer.toString();
    }
}
