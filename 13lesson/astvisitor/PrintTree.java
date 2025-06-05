package astvisitor;

public class PrintTree implements ASTVisitor {

	@Override
	public Object visitDoubleLiteral(ASTDoubleLiteral literal) {
		literal.print(0);
		return null;
	}

	@Override
	public Object visitOperatorExpression(ASTOperatorExpression opexp) {
		opexp.print(0);
		return null;
	}

	public static void main(String[] args) {
		ASTDoubleLiteral num1 = new ASTDoubleLiteral(5.0);
		ASTDoubleLiteral num2 = new ASTDoubleLiteral(3.0);
		ASTOperatorExpression expr = new ASTOperatorExpression(num1, num2, "+");
		
		PrintTree printer = new PrintTree();
		System.out.println("Using PrintTree visitor:");
		expr.accept(printer);
	}
}