package provaCoR;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Salt extends JButton {

	mainFrame f;

	public Salt(int i, int j, mainFrame f) {
		try {
			setIcon(new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("salt.png"))
					.getScaledInstance(80, 100, 0)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setBounds(i, j, 80, 100);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.ing.setBorderPainted(false);
				f.ingrediente = Ingrediente.Sale;
				Salt s = (Salt) e.getSource();
				s.setBorderPainted(true);
				s.setBorder(new LineBorder(Color.blue, 3));
				f.ing = s;
			}
		});

		this.f = f;
	}

}
