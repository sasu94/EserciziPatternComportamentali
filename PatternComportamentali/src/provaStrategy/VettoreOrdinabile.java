package provaStrategy;

public class VettoreOrdinabile {
	int n = 0;
	Integer[] v = new Integer[n + 1];
	Strategy s;

	public VettoreOrdinabile(Strategy s) {
		this.s = s;
	}

	void sort() {
		s.sort(v);
	}

	@Override
	public String toString() {
		for (int i : v)
			System.out.print(i + " ");
		return "\n";
	}

	void add(int x) {
		if (n == v.length) {
			Integer[] temp = new Integer[n + 1];
			for (int i = 0; i < v.length; i++)
				temp[i] = v[i];
			temp[n++] = x;
			v = temp;
		} else {
			v[n++] = x;
		}
	}

}
