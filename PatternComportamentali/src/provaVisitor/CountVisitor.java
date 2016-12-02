package provaVisitor;

public class CountVisitor implements Visitor {

	private int prezzoA;
	private int prezzoO;
	private int prezzoN;

	@Override
	public void visitAnd(And a) {
		setPrezzoA(getPrezzoA() + a.prezzo());
	}

	@Override
	public void visitOR(Or o) {
		setPrezzoO(getPrezzoO() + o.prezzo());

	}

	@Override
	public void visitNot(Not n) {
		setPrezzoN(getPrezzoN() + n.prezzo());

	}

	public int getPrezzoA() {
		return prezzoA;
	}

	public void setPrezzoA(int prezzoA) {
		this.prezzoA = prezzoA;
	}

	public int getPrezzoO() {
		return prezzoO;
	}

	public void setPrezzoO(int prezzoO) {
		this.prezzoO = prezzoO;
	}

	public int getPrezzoN() {
		return prezzoN;
	}

	public void setPrezzoN(int prezzoN) {
		this.prezzoN = prezzoN;
	}

}
