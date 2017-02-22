package provaState;

import java.awt.Toolkit;

public class Alarmed implements State {
	Clock c;
	private boolean active;

	Alarmed(Clock c) {
		this.c = c;
	}

	@Override
	public void snooze() {
		active = false;
		c.state = new NormalState();
		c.alH = 0;
		c.alM = 0;

	}

	@Override
	public void play() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (!active) {
					active = true;
					while (active && (c.h == c.alH && c.m == c.alM)) {
						Toolkit.getDefaultToolkit().beep();
						try {
							System.out.println("beep");
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else
					return;
				active = false;
				c.state = new NormalState();
			}
		}).start();

	}

}
