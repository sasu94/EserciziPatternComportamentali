package provaInterpreter;

public class Variabile extends EspressioneAlgebrica {
	char x;

	public Variabile(char x) {
		this.x = x;
	}

	@Override
	public void add(EspressioneAlgebrica e) {
		// TODO Auto-generated method stub

	}

	@Override
	public int calcola(int context) {
		return context;
	}

}
