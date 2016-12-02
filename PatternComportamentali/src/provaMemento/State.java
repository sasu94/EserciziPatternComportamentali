package provaMemento;

import java.awt.Image;
import java.util.HashMap;

public class State {
	private HashMap<String, Image> state;

	void setMemento(HashMap<String, Image> s) {
		HashMap<String, Image> m = new HashMap<>();
		m.putAll(s);
		state = m;
	}

	HashMap<String, Image> getMemento() {
		return state;
	}
}
