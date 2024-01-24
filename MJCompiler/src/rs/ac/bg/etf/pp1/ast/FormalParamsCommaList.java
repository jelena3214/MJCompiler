// generated with ast extension for cup
// version 0.8
// 24/0/2024 23:47:6


package rs.ac.bg.etf.pp1.ast;

public class FormalParamsCommaList extends FormParsCommaList {

    private FormParsComma FormParsComma;
    private FormParsCommaList FormParsCommaList;

    public FormalParamsCommaList (FormParsComma FormParsComma, FormParsCommaList FormParsCommaList) {
        this.FormParsComma=FormParsComma;
        if(FormParsComma!=null) FormParsComma.setParent(this);
        this.FormParsCommaList=FormParsCommaList;
        if(FormParsCommaList!=null) FormParsCommaList.setParent(this);
    }

    public FormParsComma getFormParsComma() {
        return FormParsComma;
    }

    public void setFormParsComma(FormParsComma FormParsComma) {
        this.FormParsComma=FormParsComma;
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
        if(FormParsComma!=null) FormParsComma.accept(visitor);
        if(FormParsCommaList!=null) FormParsCommaList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsComma!=null) FormParsComma.traverseTopDown(visitor);
        if(FormParsCommaList!=null) FormParsCommaList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsComma!=null) FormParsComma.traverseBottomUp(visitor);
        if(FormParsCommaList!=null) FormParsCommaList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParamsCommaList(\n");

        if(FormParsComma!=null)
            buffer.append(FormParsComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsCommaList!=null)
            buffer.append(FormParsCommaList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParamsCommaList]");
        return buffer.toString();
    }
}
