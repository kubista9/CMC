package astvisitor;

public interface ASTVisitor {
	public Object visitDoubleLiteral(ASTDoubleLiteral literal);
	public Object visitOperatorExpression(ASTOperatorExpression opexp);
}