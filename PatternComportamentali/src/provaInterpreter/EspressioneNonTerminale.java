package provaInterpreter;

import java.util.ArrayList;
import java.util.List;

public class EspressioneNonTerminale extends EspressioneAlgebrica {
	List<EspressioneAlgebrica> l = new ArrayList<>();

	@Override
	public void add(EspressioneAlgebrica e) {
		l.add(e);
	}

	@Override
	public int calcola(int contesto) {
		int s = 0;
		for (EspressioneAlgebrica e : l)
			s += e.calcola(contesto);
		return s;
	}

}
