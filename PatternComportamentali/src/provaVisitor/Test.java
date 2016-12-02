package provaVisitor;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;

public class Test extends JFrame {
	JPanel p;
	JList palette, drop;
	JScrollBar scrPal, scrDrop;
	JEditorPane e;
	Component c;
	Composite comp;
	JButton plsCreate, plsAdd, calculate;
	DefaultListModel<Component> adder, list;

	public Test() {
		p = new JPanel();
		p.setPreferredSize(new Dimension(390, 250));
		p.setLayout(null);
		setContentPane(p);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		list = new DefaultListModel<Component>();
		list.addElement(new And());
		list.addElement(new Or());
		list.addElement(new Not());

		comp = new Composite();

		palette = new JList<>(list);
		palette.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		palette.setLayoutOrientation(JList.VERTICAL);
		palette.setVisibleRowCount(-1);
		palette.setBounds(10, 10, 100, 200);
		p.add(palette);

		adder = new DefaultListModel<>();
		drop = new JList<>(adder);
		drop.setDropMode(DropMode.INSERT);
		drop.setBounds(120, 10, 100, 200);
		p.add(drop);

		plsAdd = new JButton("Aggiungi Comp");
		plsAdd.setBounds(230, 40, 150, 20);
		plsAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component c = (Component) palette.getSelectedValue();
				comp.aggiungi(c);
				adder.addElement(c);
			}
		});
		p.add(plsAdd);

		plsCreate = new JButton("Salva Componente");
		plsCreate.setBounds(230, 10, 150, 20);
		plsCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list.addElement(comp);
				comp = new Composite();
				adder.removeAllElements();
			}
		});
		p.add(plsCreate);

		calculate = new JButton("Calcola prezzo");
		calculate.setBounds(230, 70, 150, 20);
		calculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CountVisitor v = new CountVisitor();
				for (int i = 0; i < list.getSize(); i++)
					list.get(i).accept(v);
				JOptionPane.showMessageDialog(null, "Prezzo And: " + v.getPrezzoA() + "\nPrezzo Or " + v.getPrezzoO()
						+ "\nPrezzo Not " + v.getPrezzoN());

			}
		});
		p.add(calculate);

		p.repaint();

	}

	public static void main(String[] args) {
		Test t = new Test();
	}
}
