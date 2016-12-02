package provaMemento;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Star extends Graphic {
	ImageIcon i;

	public Star() {
		try {
			i = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("star.png"))
					.getScaledInstance(50, 50, 0));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ImageIcon getImage() {
		return i;
	}

}
