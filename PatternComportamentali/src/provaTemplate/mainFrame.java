package provaTemplate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4157321772701762363L;
	JPanel p;
	public Map<Integer, Color> colors = new HashMap<>();
	Stack<Integer> s = new Stack<>();

	public mainFrame() {
		p = new JPanel();
		p.setPreferredSize(new Dimension(500, 400));
		p.setLayout(null);
		setContentPane(p);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		mainFrame f = new mainFrame();

	}

	private static void extracted(mainFrame f) {
		Map<Integer, List<Integer>> l = new HashMap<>();

		List<Integer> temp = new ArrayList<Integer>();
		int[] temp1 = { 2, 3 };
		for (int i = 0; i < temp1.length; i++)
			temp.add(temp1[i]);
		l.put(1, temp);
		temp = new ArrayList<Integer>();
		int[] temp2 = { 1, 3, 4 };
		for (int i = 0; i < temp2.length; i++)
			temp.add(temp2[i]);
		l.put(2, temp);
		temp = new ArrayList<Integer>();
		int[] temp3 = { 1, 2, 5 };
		for (int i = 0; i < temp3.length; i++)
			temp.add(temp3[i]);
		l.put(3, temp);
		temp = new ArrayList<Integer>();
		int[] temp4 = { 2, 5, 6 };
		for (int i = 0; i < temp4.length; i++)
			temp.add(temp4[i]);
		l.put(4, temp);
		temp = new ArrayList<Integer>();
		int[] temp5 = { 3, 4, 6 };
		for (int i = 0; i < temp5.length; i++)
			temp.add(temp5[i]);
		l.put(5, temp);
		temp = new ArrayList<Integer>();
		int[] temp6 = { 4, 5 };
		for (int i = 0; i < temp6.length; i++)
			temp.add(temp6[i]);
		l.put(6, temp);

		NColor c = new NColor(l);
		c.solve(f.s);
		f.colors.put(1, Color.red);
		f.colors.put(2, Color.blue);
		f.colors.put(3, Color.green);
	}

	@Override
	public void paint(Graphics g) {
		extracted(this);
		int i = 0;
		g.setColor(colors.get(s.get(i++)));
		g.fillOval(200, 50, 50, 50);
		g.setColor(colors.get(s.get(i++)));
		g.fillOval(145, 115, 50, 50);
		g.setColor(colors.get(s.get(i++)));
		g.fillOval(255, 115, 50, 50);
		g.setColor(colors.get(s.get(i++)));
		g.fillOval(145, 180, 50, 50);
		g.setColor(colors.get(s.get(i++)));
		g.fillOval(255, 180, 50, 50);
		g.setColor(colors.get(s.get(i++)));
		g.fillOval(200, 245, 50, 50);

		g.setColor(Color.black);
		g.drawLine(200, 75, 170, 115);
		g.drawLine(250, 75, 280, 115);
		g.drawLine(195, 140, 255, 140);
		g.drawLine(170, 165, 170, 180);
		g.drawLine(280, 165, 280, 180);
		g.drawLine(195, 205, 255, 205);
		g.drawLine(280, 230, 250, 270);
		g.drawLine(170, 230, 200, 270);
	}

}
