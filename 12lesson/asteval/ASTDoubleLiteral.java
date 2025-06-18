package asteval;

public class ASTDoubleLiteral extends ASTExpression {

	ASTDoubleLiteral(double value) {
		_value = value;
	}
	
	ASTDoubleLiteral(String str) {
		_value = Double.parseDouble(str);
	}
	
	double eval() {
		return _value;
	}
	
	void print(int indent_level) {
		for (int i = 0; i < indent_level; i++) {
			System.out.print(" ");
		}
		if (_value == (int)_value) {
			System.out.println((int)_value);
		} else {
			System.out.println(_value);
		}
	}
		
	double get_value() {
		return _value;
	}
	void set_value(double value) {
		_value = value;
	}
	
	private double _value;
}