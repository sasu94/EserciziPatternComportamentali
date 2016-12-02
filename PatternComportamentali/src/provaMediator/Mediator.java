package provaMediator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Mediator {
	private JComboBox<String> arrivo, partenza;
	JTextField dataPartenza, dataArrivo;
	private JButton cercaVoli;
	HashMap<String, List<String>> aereoportiCollegati;

	public Mediator() {
		aereoportiCollegati = new HashMap<>();
		aereoportiCollegati.put("Lamezia", Arrays.asList("Londra", "Milano"));
		aereoportiCollegati.put("Roma", Arrays.asList("Lamezia", "Londra", "Milano"));
		aereoportiCollegati.put("Milano", Arrays.asList("Roma", "Lamezia"));
		aereoportiCollegati.put("Londra", Arrays.asList("Lamezia", "Roma", "Milano"));

	}

	public void hasChanged(String s) {
		if (s.equals("partenza")) {
			arrivo.setModel(new DefaultComboBoxModel<String>(
					(String[]) aereoportiCollegati.get(partenza.getSelectedItem()).toArray()));
		} else if (s.equals("dataPartenza")) {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date date = f.parse(dataPartenza.getText());
				if (!date.after(Calendar.getInstance().getTime())) {
					JOptionPane.showMessageDialog(null, "la data inserita deve essere successiva alla data di oggi");
					resetText(dataPartenza);
				}
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "La data inserita non è corretta");
				resetText(dataPartenza);
			}
		} else if (s.equals("dataArrivo")) {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date start = f.parse(dataPartenza.getText());
				Date end = f.parse(dataArrivo.getText());
				if (!end.after(start)) {
					JOptionPane.showMessageDialog(null,
							"la data inserita deve essere successiva alla data della partenza");
					resetText(dataArrivo);
				}

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "La data inserita non è corretta");
				resetText(dataArrivo);
			}
		} else if (s.equals("cerca"))
			JOptionPane.showMessageDialog(null, "trovati " + ((int) (Math.random() * 10)) + " voli");

		if (!dataPartenza.getText().equals("") && !dataArrivo.getText().equals("")
				&& !arrivo.getSelectedItem().equals("") && !partenza.getSelectedItem().equals("")) {
			cercaVoli.setEnabled(true);

		}
	}

	private void resetText(JTextField t) {
		t.setText("");
		t.requestFocus();
	}

	public JComboBox<String> getArrivo() {
		return arrivo;
	}

	public void setArrivo(JComboBox<String> arrivo) {
		this.arrivo = arrivo;
	}

	public JComboBox<String> getPartenza() {
		return partenza;
	}

	public void setPartenza(JComboBox<String> partenza) {
		this.partenza = partenza;
	}

	public void setDataPartenza(JTextField dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public void setDataArrivo(JTextField dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public JButton getCercaVoli() {
		return cercaVoli;
	}

	public void setCercaVoli(JButton cercaVoli) {
		this.cercaVoli = cercaVoli;
		cercaVoli.setEnabled(false);
	}
}
