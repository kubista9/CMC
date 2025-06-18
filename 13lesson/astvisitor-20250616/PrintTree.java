package astvisitor;

public class PrintTree implements ASTVisitor {
	 
	private int indent;
	
	public PrintTree() {
	        this.indent = 0;
	    }

	 public PrintTree(int indent) {
	        this.indent = indent;
	    }

	@Override
	public Object visitDoubleLiteral(ASTDoubleLiteral literal) {
		literal.printIndentation(indent);
		
		System.out.print(literal.get_value());
		System.out.println();

		return null;
	}

	@Override
	public Object visitOperatorExpression(ASTOperatorExpression opexp) {
		opexp.printIndentation(indent);
		
		System.out.println(opexp.opname[opexp.get_operator()]);
		opexp.left().accept(new PrintTree(indent+1));
		opexp.right().accept(new PrintTree(indent+1));
		
		return null;
	}
}