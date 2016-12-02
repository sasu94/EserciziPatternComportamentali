package provaMemento;

import java.util.HashMap;

public class ImagePool {
	HashMap<String, Graphic> pool = new HashMap<>();

	public Graphic getGraphic(String s) {
		if (!pool.containsKey(s))
			if (s.equals("ball"))
				pool.put(s, new ChristmasBall());
			else if (s.equals("star"))
				pool.put(s, new Star());
		return pool.get(s);
	}

}
