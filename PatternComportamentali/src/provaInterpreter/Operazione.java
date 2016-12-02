package provaInterpreter;

public class Operazione extends EspressioneAlgebrica {
	EspressioneAlgebrica e1, e2;
	private char o;

	public Operazione(EspressioneAlgebrica e1, EspressioneAlgebrica e2, char operand) {
		this.e1 = e1;
		this.e2 = e2;
		this.o = operand;
	}

	@Override
	public void add(EspressioneAlgebrica e1) {
		// TODO Auto-generated method stub

	}

	@Override
	public int calcola(int contesto) {
		switch (o) {
		case '+':
			return e1.calcola(contesto) + e2.calcola(contesto);
		case '-':
			return e1.calcola(contesto) - e2.calcola(contesto);
		}
		return contesto;
	}

}
