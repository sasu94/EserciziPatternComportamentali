package provaObserver;

import java.util.ArrayList;
import java.util.List;

public class DataTaker {
	int w, l, d;

	List<Grafici> list;

	public DataTaker(int w, int l, int d) {
		list = new ArrayList<Grafici>();
		this.w = w;
		this.l = l;
		this.d = d;
	}

	void setGrafico(Grafici g) {
		list.add(g);
	}

	public void notifica() {
		for (Grafici g : list)
			g.update();
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

}
