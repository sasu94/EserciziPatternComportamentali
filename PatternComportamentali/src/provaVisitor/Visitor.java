package provaVisitor;

public interface Visitor {
	void visitAnd(And a);

	void visitOR(Or o);

	void visitNot(Not n);
}
