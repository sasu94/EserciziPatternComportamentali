package provaObserver;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class mainFrame extends JFrame {
	JPanel p;
	DataTaker t;
	Grafici torta, barre;

	public mainFrame() {
		p = new JPanel();
		p.setPreferredSize(new Dimension(640, 360));
		p.setLayout(null);
		setContentPane(p);

		t = new DataTaker(50, 30, 20);
		barre = new GraficoBarre(t);
		torta = new GraficoTorta(t);
		t.setGrafico(barre);
		t.setGrafico(torta);

		JTextField txtW = new JTextField();
		txtW.setBounds(10, 10, 100, 20);
		p.add(txtW);
		JTextField txtL = new JTextField();
		txtL.setBounds(120, 10, 100, 20);
		p.add(txtL);
		JTextField txtD = new JTextField();
		txtD.setBounds(230, 10, 100, 20);
		p.add(txtD);

		JButton plsChange = new JButton("cambia");
		plsChange.setBounds(340, 10, 100, 20);
		plsChange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (torta.getChart() != null && barre.getChart() != null) {
					p.remove(torta.getChart());
					p.remove(barre.getChart());
				}
				t.setD(Integer.parseInt(txtD.getText()));
				t.setW(Integer.parseInt(txtW.getText()));
				t.setL(Integer.parseInt(txtL.getText()));
				t.notifica();
				p.add(torta.getChart());
				p.add(barre.getChart());
				repaint();

			}
		});
		p.add(plsChange);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		mainFrame f = new mainFrame();
	}
}