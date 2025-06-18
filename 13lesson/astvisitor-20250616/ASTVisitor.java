package astvisitor;

public interface ASTVisitor {
	public Object visitDoubleLiteral(ASTDoubleLiteral l);
	public Object visitOperatorExpression(ASTOperatorExpression o);
}
