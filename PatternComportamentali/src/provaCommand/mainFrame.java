package provaCommand;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class mainFrame extends JFrame {
	JPanel p;
	JTextArea t;
	JMenuBar bar;
	Comando c;
	JButton copy;
	JTextField paste;

	public mainFrame() {
		p = new JPanel();
		p.setPreferredSize(new Dimension(520, 500));
		p.setLayout(null);
		setContentPane(p);

		Comando c = new Copia();

		t = new JTextArea();
		t.setBounds(10, 10, 500, 400);
		p.add(t);

		bar = new JMenuBar();

		JMenu menu = new JMenu("Edit");
		bar.add(menu);

		JMenuItem menuItem = new JMenuItem("Copia");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.esegui(t.getSelectedText());

			}
		});
		menu.add(menuItem);

		copy = new JButton("copia");
		copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.esegui(t.getSelectedText());
			}
		});
		copy.setBounds(420, 420, 80, 20);
		p.add(copy);

		paste = new JTextField();
		paste.setBounds(10, 420, 100, 20);
		p.add(paste);

		setJMenuBar(bar);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		mainFrame m = new mainFrame();
	}

}
