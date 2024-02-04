// generated with ast extension for cup
// version 0.8
// 4/1/2024 12:17:16


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ConstDeclComma ConstDeclComma);
    public void visit(FormPars FormPars);
    public void visit(VarDeclComma VarDeclComma);
    public void visit(Factor Factor);
    public void visit(Statement Statement);
    public void visit(DesignatorDecl DesignatorDecl);
    public void visit(DesignatorStmtList DesignatorStmtList);
    public void visit(Relop Relop);
    public void visit(DeclList DeclList);
    public void visit(FormParsComma FormParsComma);
    public void visit(CondFactList CondFactList);
    public void visit(VarDeclSemi VarDeclSemi);
    public void visit(Expr Expr);
    public void visit(VarDecl VarDecl);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(DeclListElem DeclListElem);
    public void visit(ConstType ConstType);
    public void visit(ConstDeclSemi ConstDeclSemi);
    public void visit(FormParsBasic FormParsBasic);
    public void visit(DesignatorCommaList DesignatorCommaList);
    public void visit(FormParsCommaList FormParsCommaList);
    public void visit(DesignatorCommaElem DesignatorCommaElem);
    public void visit(Mulop Mulop);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(DesignatorStatementSemi DesignatorStatementSemi);
    public void visit(VarDeclTmpList VarDeclTmpList);
    public void visit(NamespaceList NamespaceList);
    public void visit(Addop Addop);
    public void visit(StatementList StatementList);
    public void visit(ConstDecl ConstDecl);
    public void visit(ExprCommaList ExprCommaList);
    public void visit(Type Type);
    public void visit(ElseStatementList ElseStatementList);
    public void visit(CondTermList CondTermList);
    public void visit(IfStatement IfStatement);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(ConstDeclTmpList ConstDeclTmpList);
    public void visit(SquareBracesList SquareBracesList);
    public void visit(ActPars ActPars);
    public void visit(Designator Designator);
    public void visit(VarDeclList VarDeclList);
    public void visit(CondFact CondFact);
    public void visit(DesignatorStatementCommaList DesignatorStatementCommaList);
    public void visit(ExprOrActPars ExprOrActPars);
    public void visit(Term Term);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMultiply MulopMultiply);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(RelopLessEqual RelopLessEqual);
    public void visit(RelopLess RelopLess);
    public void visit(RelopGreaterEqual RelopGreaterEqual);
    public void visit(RelopGreater RelopGreater);
    public void visit(RelopNoEqual RelopNoEqual);
    public void visit(RelopTwoEqual RelopTwoEqual);
    public void visit(Assignop Assignop);
    public void visit(Label Label);
    public void visit(ExprOrActParsActPars ExprOrActParsActPars);
    public void visit(ExprOrActParsExpr ExprOrActParsExpr);
    public void visit(DesignatorDeclBasic DesignatorDeclBasic);
    public void visit(DesignatorDeclNamespace DesignatorDeclNamespace);
    public void visit(ArrayDesignatorDecl ArrayDesignatorDecl);
    public void visit(DesignatorIndexing DesignatorIndexing);
    public void visit(DesignatorObjectField DesignatorObjectField);
    public void visit(DesignatorBasicDecl DesignatorBasicDecl);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNew FactorNew);
    public void visit(FactorBoolConst FactorBoolConst);
    public void visit(FactorCharConst FactorCharConst);
    public void visit(FactorNumConst FactorNumConst);
    public void visit(FactorDesignatorMethod FactorDesignatorMethod);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(TermMulopFactorDecl TermMulopFactorDecl);
    public void visit(TermFactor TermFactor);
    public void visit(ExprAddopTerm ExprAddopTerm);
    public void visit(ExprDash ExprDash);
    public void visit(ExprTermBasic ExprTermBasic);
    public void visit(CondFactExprRelop CondFactExprRelop);
    public void visit(CondFactExpr CondFactExpr);
    public void visit(CondFactElem CondFactElem);
    public void visit(PatchOr PatchOr);
    public void visit(PatchAnd PatchAnd);
    public void visit(NoCondFactList NoCondFactList);
    public void visit(CondFactDecl CondFactDecl);
    public void visit(CondTerm CondTerm);
    public void visit(CondTermElem CondTermElem);
    public void visit(NoCondTermList NoCondTermList);
    public void visit(CondTermDecl CondTermDecl);
    public void visit(Condition Condition);
    public void visit(ExprCommaElem ExprCommaElem);
    public void visit(NoExprCommaList NoExprCommaList);
    public void visit(ExprCommaDecl ExprCommaDecl);
    public void visit(NoActPars NoActPars);
    public void visit(ActParsDecl ActParsDecl);
    public void visit(DesignatorCommaElem2 DesignatorCommaElem2);
    public void visit(DesignatorCommaElem1 DesignatorCommaElem1);
    public void visit(NoDesignatorCommaList NoDesignatorCommaList);
    public void visit(DesignatorCommaDecls DesignatorCommaDecls);
    public void visit(ErrorStatement ErrorStatement);
    public void visit(DesignatorStatementSemicolin DesignatorStatementSemicolin);
    public void visit(DesignatorStatementAssign DesignatorStatementAssign);
    public void visit(DesignatorStatementExpr1 DesignatorStatementExpr1);
    public void visit(DesignatorStatementExpr DesignatorStatementExpr);
    public void visit(DesignatorStatementDec DesignatorStatementDec);
    public void visit(DesignatorStatementInc DesignatorStatementInc);
    public void visit(DesignatorStatementAct DesignatorStatementAct);
    public void visit(DesignatorStatementCommaElem DesignatorStatementCommaElem);
    public void visit(NoDesignatorStatementCommaList NoDesignatorStatementCommaList);
    public void visit(DesignatorStatementComma DesignatorStatementComma);
    public void visit(NoDesignatorStmtList NoDesignatorStmtList);
    public void visit(DesignatorStmtDecl DesignatorStmtDecl);
    public void visit(PatchToElse PatchToElse);
    public void visit(NoElseStatement NoElseStatement);
    public void visit(ElseStatement ElseStatement);
    public void visit(IfErr IfErr);
    public void visit(IfNoErr IfNoErr);
    public void visit(StartIf StartIf);
    public void visit(BeforeForBody BeforeForBody);
    public void visit(BeforeForUpdate BeforeForUpdate);
    public void visit(BeforeForCond BeforeForCond);
    public void visit(ForStmtBegin ForStmtBegin);
    public void visit(Stmt Stmt);
    public void visit(EmptyStmt EmptyStmt);
    public void visit(ForStmtNoCondFact ForStmtNoCondFact);
    public void visit(ForStmtCondFact ForStmtCondFact);
    public void visit(PrintStmtWidth PrintStmtWidth);
    public void visit(PrintStmtNoWidth PrintStmtNoWidth);
    public void visit(ReadStmt ReadStmt);
    public void visit(ReturnStmt ReturnStmt);
    public void visit(ReturnStmtExpr ReturnStmtExpr);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(DesignatorStmt DesignatorStmt);
    public void visit(IfStmt IfStmt);
    public void visit(NoStatements NoStatements);
    public void visit(Statements Statements);
    public void visit(TypeIdent TypeIdent);
    public void visit(TypeNamespaceIdent TypeNamespaceIdent);
    public void visit(ErrorFormalParamsBasicComma ErrorFormalParamsBasicComma);
    public void visit(FormalParamsBasicComma FormalParamsBasicComma);
    public void visit(ErrorFormParamsCommaListRightParen ErrorFormParamsCommaListRightParen);
    public void visit(FormParsCommaListRightParen FormParsCommaListRightParen);
    public void visit(FormalParamsCommaList FormalParamsCommaList);
    public void visit(FormalParamsBasic FormalParamsBasic);
    public void visit(FormParamsEmpty FormParamsEmpty);
    public void visit(FormParamsList FormParamsList);
    public void visit(NoVarDeclList NoVarDeclList);
    public void visit(VarDecls VarDecls);
    public void visit(NoMethodDecls NoMethodDecls);
    public void visit(MethodDecls MethodDecls);
    public void visit(MethodTypeVoid MethodTypeVoid);
    public void visit(MethodTypeDecl MethodTypeDecl);
    public void visit(MethodDecl MethodDecl);
    public void visit(StaticInitializer StaticInitializer);
    public void visit(NoSquareBraces NoSquareBraces);
    public void visit(SquareBraces SquareBraces);
    public void visit(VarDeclType VarDeclType);
    public void visit(VarDeclErr VarDeclErr);
    public void visit(VarDeclNoErr VarDeclNoErr);
    public void visit(ErrorVarDeclarationSemi ErrorVarDeclarationSemi);
    public void visit(VarDeclarationSemi VarDeclarationSemi);
    public void visit(ErrorVarDeclarationComma ErrorVarDeclarationComma);
    public void visit(VarDeclarationComma VarDeclarationComma);
    public void visit(VarDeclarationTmpListEnd VarDeclarationTmpListEnd);
    public void visit(VarDeclarationTmpList VarDeclarationTmpList);
    public void visit(VarDeclTmp VarDeclTmp);
    public void visit(BoolConstType BoolConstType);
    public void visit(CharConstType CharConstType);
    public void visit(NumConstType NumConstType);
    public void visit(ErrorConstDeclarationSemi ErrorConstDeclarationSemi);
    public void visit(ConstDeclarationSemi ConstDeclarationSemi);
    public void visit(ErrorConstDeclarationComma ErrorConstDeclarationComma);
    public void visit(ConstDeclarationComma ConstDeclarationComma);
    public void visit(ConstDeclarationTmpListEnd ConstDeclarationTmpListEnd);
    public void visit(ConstDeclarationTmpList ConstDeclarationTmpList);
    public void visit(ConstDeclTmp ConstDeclTmp);
    public void visit(ConstDeclType ConstDeclType);
    public void visit(ConstDeclErr ConstDeclErr);
    public void visit(ConstDeclNoErr ConstDeclNoErr);
    public void visit(VarElemDeclaration VarElemDeclaration);
    public void visit(ConstElemDeclaration ConstElemDeclaration);
    public void visit(NoDeclarationList NoDeclarationList);
    public void visit(DeclarationList DeclarationList);
    public void visit(NamespaceName NamespaceName);
    public void visit(NamespaceDecl NamespaceDecl);
    public void visit(NoNamespacesDecl NoNamespacesDecl);
    public void visit(NamespacesDecl NamespacesDecl);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
