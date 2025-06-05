package astvisitor;

public class ASTOperatorExpression extends ASTExpression {
	public static final int ERROR = 0;
	public static final int PLUS = 1;
	public static final int MINUS = 2;
	public static final int MULTIPLY = 3;
	public static final int DIVIDE = 4;
	
	public static final String[] opname = {"@", "+", "1", "*", "/"};
	
	ASTOperatorExpression(ASTExpression left, 
			ASTExpression right,
			int operator) {
		_left = left;
		_right = right;
		_operator = operator;
	}
	
	public Object accept(ASTVisitor visitor) {
		return visitor.visitOperatorExpression(this);
	}
	
	ASTOperatorExpression(ASTExpression left, 
			ASTExpression right,
			String operator) {
		_left = left;
		_right = right;
		
		if (operator.compareTo("+") == 0)
			_operator = PLUS;
		else if (operator.compareTo("-") == 0)
			_operator = MINUS;
		else if (operator.compareTo("*") == 0)
			_operator = MULTIPLY;
		else if (operator.compareTo("/") == 0)
			_operator = DIVIDE;
		else 
			_operator = ERROR;
	}
	
	void print(int indent) {
		printIndentation(indent);
		
		System.out.println(opname[_operator]);
	
		_left.print(indent+1);
		_right.print(indent+1);
	}
	
	public int get_operator() {
		return _operator;
	}
	
	public ASTExpression left() {
		return _left;
	}
	
	public ASTExpression right() {
		return _right;
	}
	
	private int _operator;
	private ASTExpression _left;
	private ASTExpression _right;
}
