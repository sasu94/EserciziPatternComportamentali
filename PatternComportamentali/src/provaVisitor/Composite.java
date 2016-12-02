package provaVisitor;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
	List<Component> l = new ArrayList<Component>();

	@Override
	public int prezzo() {
		int p = 0;
		for (Component c : l)
			p += c.prezzo();
		return p;
	}

	@Override
	public void aggiungi(Component c) {
		l.add(c);
	}

	@Override
	public void rimuovi(Component c) {
		l.remove(c);
	}

	@Override
	public String toString() {
		return "Elemento Composto";
	}

	@Override
	public void accept(Visitor v) {
		for (Component c : l)
			c.accept(v);

	}

}
