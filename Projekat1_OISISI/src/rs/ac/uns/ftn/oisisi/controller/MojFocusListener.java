package rs.ac.uns.ftn.oisisi.controller;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class MojFocusListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.GRAY);

	
		if (txt.getName().equals("txtSifra")) {

			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite sifru...")) {
				txt.setText("Unesite sifru...");
				txt.requestFocus();
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
		else if(txt.getName().equals("txtNaziv")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite naziv...")) {
				txt.setText("Unesite naziv...");
				txt.requestFocus();
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}

		
	}

}
