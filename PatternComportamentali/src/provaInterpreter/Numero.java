package provaInterpreter;

public class Numero extends EspressioneAlgebrica {
	int n;

	public Numero(int n) {
		this.n = n;
	}

	@Override
	public void add(EspressioneAlgebrica e) {

	}

	@Override
	public int calcola(int contesto) {
		return n;
	}

}
