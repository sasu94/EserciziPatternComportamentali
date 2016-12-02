package provaState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame {
	JPanel p = new JPanel();
	public Clock c;
	Image clock;

	public mainFrame() {
		c = new Clock(this);
		c.start();
		p = new JPanel();
		p.setPreferredSize(new Dimension(920, 466));
		p.setLayout(null);
		setContentPane(p);

		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((e.getX() > 213 && e.getX() < 728) && (e.getY() > 28 && e.getY() < 55))
					c.snooze();
			}
		});

		try {
			clock = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("clock.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		mainFrame f = new mainFrame();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(clock, 30, 0, null);
		g.setColor(Color.red);
		g.setFont(new Font("Arial", Font.BOLD, 60));
		g.drawString(c.toString(), 350, 300);
	}
}
