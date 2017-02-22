package provaState;

public class Clock extends Thread {

	mainFrame f;
	int h, m, s;
	int alH, alM;
	provaState.State state;

	Clock(mainFrame mainFrame) {

		state = new NormalState();
		f = mainFrame;
		alH = 12;
		alM = 1;
		h = 12;
		m = 0;
		s = 58;
	}

	@Override
	public void run() {
		while (true) {
			f.repaint();
			if (h == alH && m == alM && !(state instanceof Alarmed))
				state = new Alarmed(this);
			state.play();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setS(getS() + 1);
		}

	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getM() {
		return m;
	}

	void setAlarm(int h, int m) {
		this.h = this.m;
	}

	public void setM(int m) {
		if (this.m + 1 == 61) {
			this.m = 0;
			setH(getH() + 1);
			return;
		}
		this.m = m;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		if (this.s + 1 == 60) {
			this.s = 0;
			setM(getM() + 1);
			return;
		}
		this.s = s;
	}

	void snooze() {
		state.snooze();
	}

	@Override
	public String toString() {
		return (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":" + (s < 10 ? "0" + s : s);
	}

}
