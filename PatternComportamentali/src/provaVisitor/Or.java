package provaVisitor;

public class Or implements Component {

	@Override
	public int prezzo() {
		return 2;
	}

	@Override
	public void aggiungi(Component c) {

	}

	@Override
	public void rimuovi(Component c) {
	}

	@Override
	public String toString() {
		return "Or";
	}

	@Override
	public void accept(Visitor v) {
		v.visitOR(this);

	}

}
