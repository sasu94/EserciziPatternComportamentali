package provaVisitor;

public interface Component {

	int prezzo();

	void aggiungi(Component c);

	void rimuovi(Component c);

	void accept(Visitor v);

}
