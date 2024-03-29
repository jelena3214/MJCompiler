// generated with ast extension for cup
// version 0.8
// 5/1/2024 22:1:49


package rs.ac.bg.etf.pp1.ast;

public class FormalParamsBasicComma extends FormParsComma {

    private FormParsBasic FormParsBasic;

    public FormalParamsBasicComma (FormParsBasic FormParsBasic) {
        this.FormParsBasic=FormParsBasic;
        if(FormParsBasic!=null) FormParsBasic.setParent(this);
    }

    public FormParsBasic getFormParsBasic() {
        return FormParsBasic;
    }

    public void setFormParsBasic(FormParsBasic FormParsBasic) {
        this.FormParsBasic=FormParsBasic;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsBasic!=null) FormParsBasic.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsBasic!=null) FormParsBasic.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsBasic!=null) FormParsBasic.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParamsBasicComma(\n");

        if(FormParsBasic!=null)
            buffer.append(FormParsBasic.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParamsBasicComma]");
        return buffer.toString();
    }
}
