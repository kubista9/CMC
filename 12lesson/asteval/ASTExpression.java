package asteval;

public abstract class ASTExpression {
	double eval() { return -100.00; }
	
	void print(int indent) {
	/*
		1+2*(2-10);
		
		+
		|__	1
		|__	*
		    |__	2
		    |__	-
		        |___2
		        |___10
	 */
	}
}
