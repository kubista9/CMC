package astvisitor;

public class EvalTree implements ASTVisitor {

	@Override
	public Object visitDoubleLiteral(ASTDoubleLiteral literal) {
		return literal.get_value();
	}

	@Override
	public Object visitOperatorExpression(ASTOperatorExpression opexp) {
		Object left, right, result;
		left = opexp.left().accept(this);
		right = opexp.right().accept(this);
		
		double lvalue = ((Double) left).doubleValue();
		double rvalue = ((Double) right).doubleValue();
		
		if (opexp.get_operator() == ASTOperatorExpression.PLUS)
			result = lvalue + rvalue;
		else if (opexp.get_operator() == ASTOperatorExpression.MINUS)
			result = lvalue - rvalue;
		else if (opexp.get_operator() == ASTOperatorExpression.MULTIPLY)
			result = lvalue * rvalue;
		else if (opexp.get_operator() == ASTOperatorExpression.DIVIDE)
			result = lvalue / rvalue;
		else {
			result = -99.0;
			System.exit(0);
		}
		return result;
	}
}
