package provaState;

public class Alarmed implements State {
	Clock c;

	Alarmed(Clock c) {
		this.c = c;
	}

	@Override
	public void snooze() {
		c.active = false;
		c.alH = 0;
		c.alM = 0;

	}

}
