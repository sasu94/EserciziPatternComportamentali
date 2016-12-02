package provaMemento;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ChristmasBall extends Graphic {
	ImageIcon i;

	public ChristmasBall() {
		try {
			i = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("ball.png"))
					.getScaledInstance(50, 50, 0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ImageIcon getImage() {
		return i;
	}

}
