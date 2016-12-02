package provaCommand;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Copia implements Comando {

	@Override
	public void esegui(String s) {
		StringSelection stringSelection = new StringSelection(s);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
	}

}
