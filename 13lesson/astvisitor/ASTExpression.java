package astvisitor;

public abstract class ASTExpression {
	public void print() {
		print(0);
	}
	
	public abstract Object accept(ASTVisitor visitor);
	
	// Aux method 
	void print(int indent) {}
	
	void printIndentation(int indent) {
		final String indentation = "|___";
		final String empty       = "    ";
		
		for (int i = 0; i < indent-1; i++)
			System.out.print(empty);
		
		System.out.print(indentation);
	}
}
