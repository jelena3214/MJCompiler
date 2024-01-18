// generated with ast extension for cup
// version 0.8
// 17/0/2024 20:36:30


package rs.ac.bg.etf.pp1.ast;

public class FormalParamsBasic extends FormParsBasic {

    private Type Type;
    private String varName;
    private SquareBracesList SquareBracesList;

    public FormalParamsBasic (Type Type, String varName, SquareBracesList SquareBracesList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.varName=varName;
        this.SquareBracesList=SquareBracesList;
        if(SquareBracesList!=null) SquareBracesList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public SquareBracesList getSquareBracesList() {
        return SquareBracesList;
    }

    public void setSquareBracesList(SquareBracesList SquareBracesList) {
        this.SquareBracesList=SquareBracesList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(SquareBracesList!=null) SquareBracesList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(SquareBracesList!=null) SquareBracesList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(SquareBracesList!=null) SquareBracesList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParamsBasic(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(SquareBracesList!=null)
            buffer.append(SquareBracesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParamsBasic]");
        return buffer.toString();
    }
}
