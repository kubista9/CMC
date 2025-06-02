package asteval;

public class ASTOperatorExpression extends ASTExpression {
	public static final int ERROR = 0;
	public static final int PLUS = 1;
	public static final int MINUS = 2;
	public static final int MULTIPLY = 3;
	public static final int DIVIDE = 4;
	
	public static final String[] opname = {"@", "+", "-", "*", "/"};
	
	ASTOperatorExpression(ASTExpression left, 
			ASTExpression right,
			int operator) {
		_left = left;
		_right = right;
		_operator = operator;
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
	
	double eval() {
		double lvalue, rvalue, result;
		lvalue = _left.eval();
		rvalue = _right.eval();
				
		if (_operator == PLUS)
			result = lvalue + rvalue;
		else if (_operator == MINUS)
			result = lvalue - rvalue;
		else if (_operator == MULTIPLY)
			result = lvalue * rvalue;
		else if (_operator == DIVIDE)
			result = lvalue / rvalue;
		else {
			result = 0.0;
		}
		return result;
	}
	
	void print(int indent_level) {
		// Print indentation for this operator
		for (int i = 0; i < indent_level; i++) {
			System.out.print("      "); // 6 spaces for each indentation level
		}
		
		// Print the operator
		System.out.println(opname[_operator]);
		
		// Print left child with "|__ " prefix and increased indentation
		for (int i = 0; i < indent_level; i++) {
			System.out.print("      "); // Same base indentation
		}
		System.out.print("|__ ");
		_left.print(indent_level + 1);
		
		// Print right child with "|__ " prefix and increased indentation  
		for (int i = 0; i < indent_level; i++) {
			System.out.print("      "); // Same base indentation
		}
		System.out.print("|__ ");
		_right.print(indent_level + 1);
	}
	
	int get_operator() {
		return _operator;
	}
	
	ASTExpression left() {
		return _left;
	}
	
	ASTExpression right() {
		return _right;
	}
	
	private int _operator;
	private ASTExpression _left;
	private ASTExpression _right;
}