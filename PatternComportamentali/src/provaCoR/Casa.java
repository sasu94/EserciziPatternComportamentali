package provaCoR;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Casa extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9167837013244402214L;
	private Casa c;
	HashSet<Ingrediente> lista = new HashSet<>();
	mainFrame f;

	public Casa(int i, int j, mainFrame f) {
		this.f = f;
		try {
			setIcon(new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("casa.png"))
					.getScaledInstance(100, 100, 0)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setBounds(i, j, 100, 100);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e))
					if (f.temp != null) {
						setCasa(f.temp);
						f.getGraphics().drawLine(getX() + 100, getY() + 50, f.temp.getX() + 100, f.temp.getY() + 50);
						f.temp = null;
					} else
						f.temp = (Casa) e.getSource();
				else if (SwingUtilities.isLeftMouseButton(e))
					if (f.ingrediente != null)
						haIngrediente(f.ingrediente);
			}
		});

	}

	void setIngrediente(Ingrediente i) {
		lista.add(i);
	}

	void setCasa(Casa c) {
		this.c = c;
	}

	public void haIngrediente(Ingrediente i) {
		if (lista.contains(i)) {
			colora(Color.green);

		} else {
			colora(Color.red);
			if (c != null)
				c.haIngrediente(i);
		}

	}

	private void colora(Color c) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				setBorderPainted(true);
				setBorder(new LineBorder(c));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setBorderPainted(false);
			}
		}).start();
	}

}
