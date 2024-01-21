// generated with ast extension for cup
// version 0.8
// 21/0/2024 21:47:4


package rs.ac.bg.etf.pp1.ast;

public class MulopFactorDecl extends MulopFactorList {

    private MulopFactorList MulopFactorList;
    private MulopFactorElem MulopFactorElem;

    public MulopFactorDecl (MulopFactorList MulopFactorList, MulopFactorElem MulopFactorElem) {
        this.MulopFactorList=MulopFactorList;
        if(MulopFactorList!=null) MulopFactorList.setParent(this);
        this.MulopFactorElem=MulopFactorElem;
        if(MulopFactorElem!=null) MulopFactorElem.setParent(this);
    }

    public MulopFactorList getMulopFactorList() {
        return MulopFactorList;
    }

    public void setMulopFactorList(MulopFactorList MulopFactorList) {
        this.MulopFactorList=MulopFactorList;
    }

    public MulopFactorElem getMulopFactorElem() {
        return MulopFactorElem;
    }

    public void setMulopFactorElem(MulopFactorElem MulopFactorElem) {
        this.MulopFactorElem=MulopFactorElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulopFactorList!=null) MulopFactorList.accept(visitor);
        if(MulopFactorElem!=null) MulopFactorElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulopFactorList!=null) MulopFactorList.traverseTopDown(visitor);
        if(MulopFactorElem!=null) MulopFactorElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulopFactorList!=null) MulopFactorList.traverseBottomUp(visitor);
        if(MulopFactorElem!=null) MulopFactorElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopFactorDecl(\n");

        if(MulopFactorList!=null)
            buffer.append(MulopFactorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MulopFactorElem!=null)
            buffer.append(MulopFactorElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopFactorDecl]");
        return buffer.toString();
    }
}
