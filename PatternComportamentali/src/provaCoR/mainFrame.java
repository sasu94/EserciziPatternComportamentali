package provaCoR;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame {
	Set<Casa> c = new HashSet<>();
	JPanel p = new JPanel();
	public Casa temp;
	protected Ingrediente ingrediente;
	JButton ing = new JButton();

	public mainFrame() {
		p.setPreferredSize(new Dimension(550, 475));
		p.setLayout(null);
		setContentPane(p);

		creaCasa(10, 60, Arrays.asList(Ingrediente.Sale, Ingrediente.Olio));
		creaCasa(140, 10, Arrays.asList(Ingrediente.Sale));
		creaCasa(270, 60, Arrays.asList(Ingrediente.Olio));
		creaCasa(10, 180, Arrays.asList(Ingrediente.Zucchero));
		creaCasa(270, 180, Arrays.asList(Ingrediente.Olio, Ingrediente.Zucchero));
		creaCasa(140, 220, Arrays.asList());

		p.add(new Salt(450, 10, this));
		p.add(new Oil(450, 110, this));
		p.add(new Sugar(450, 220, this));

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private Casa creaCasa(int x, int y, List<Ingrediente> l) {
		Casa casa = new Casa(x, y, this);
		for (Ingrediente i : l)
			casa.setIngrediente(i);
		c.add(casa);
		p.add(casa);
		return casa;
	}

	public static void main(String[] args) {
		mainFrame f = new mainFrame();
	}

}
