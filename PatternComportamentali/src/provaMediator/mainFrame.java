package provaMediator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class mainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6325021160398636443L;
	JLabel lblpart, lblarri;
	JPanel p;
	JComboBox<String> partenza, arrivo;
	JTextField dataPartenza, dataArrivo;
	JButton cercaVoli;
	Mediator m;

	public mainFrame() {
		p = new JPanel();
		p.setPreferredSize(new Dimension(500, 200));
		p.setLayout(null);
		setContentPane(p);

		m = new Mediator();

		lblpart = new JLabel("Partenza");
		lblpart.setBounds(40, 40, 80, 25);
		p.add(lblpart);

		partenza = new JComboBox<>();
		partenza.addItem("Lamezia");
		partenza.addItem("Londra");
		partenza.addItem("Roma");
		partenza.addItem("Milano");
		partenza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m.hasChanged("partenza");
			}
		});
		partenza.setBounds(100, 40, 100, 25);
		p.add(partenza);
		m.setPartenza(partenza);

		dataPartenza = new JTextField();
		dataPartenza.setBounds(100, 75, 100, 25);
		dataPartenza.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				m.hasChanged("dataPartenza");
			}
		});
		p.add(dataPartenza);
		m.setDataPartenza(dataPartenza);

		lblarri = new JLabel("Arrivo");
		lblarri.setBounds(280, 40, 80, 25);
		p.add(lblarri);

		arrivo = new JComboBox<String>();
		arrivo.setBounds(320, 40, 100, 25);
		p.add(arrivo);
		m.setArrivo(arrivo);

		dataArrivo = new JTextField();
		dataArrivo.setBounds(320, 75, 100, 25);
		dataArrivo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				m.hasChanged("dataArrivo");
			}
		});
		p.add(dataArrivo);
		m.setDataArrivo(dataArrivo);

		cercaVoli = new JButton("Cerca Voli");
		cercaVoli.setBounds(320, 110, 100, 25);
		cercaVoli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m.hasChanged("cerca");
			}
		});
		m.setCercaVoli(cercaVoli);
		p.add(cercaVoli);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		mainFrame f = new mainFrame();
	}

}
