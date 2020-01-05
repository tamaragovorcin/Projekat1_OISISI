package rs.ac.uns.ftn.oisisi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.uns.ftn.oisisi.view.StudentiJTable;
import rs.ac.uns.ftn.oisisi.view.Toolbar;

public class DodavanjeStudentaNaPredmet implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		
		PredmetiController.getInstance().dodavanjeStudentaNaPredmet();
		StudentiJTable.getInstance().refresTabelu();
		Toolbar.getInstance().A();
	}

}
