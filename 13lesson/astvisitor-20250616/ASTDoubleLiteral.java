package astvisitor;

public class ASTDoubleLiteral extends ASTExpression {

	ASTDoubleLiteral(double value) {
		_value = value;
	}
	
	ASTDoubleLiteral(String str) {
		_value = Double.parseDouble(str);
	}
	
	public Object accept(ASTVisitor visitor) {
		return visitor.visitDoubleLiteral(this);
	}
	
//	void print(int indent) {
//		printIndentation(indent);
//		
//		System.out.print(_value);
//		System.out.println();
//	}
		
	double get_value() {
		return _value;
	}
	void set_value(double value) {
		_value = value;
	}
	
	private double _value;
}
