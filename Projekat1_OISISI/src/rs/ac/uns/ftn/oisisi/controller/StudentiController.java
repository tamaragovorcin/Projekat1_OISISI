package rs.ac.uns.ftn.oisisi.controller;

import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Student;
import rs.ac.uns.ftn.oisisi.view.IzmenaPredmetaDialog;
import rs.ac.uns.ftn.oisisi.view.IzmenaStudentaDialog;
import rs.ac.uns.ftn.oisisi.view.Main_Frame;

public class StudentiController {
private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private StudentiController() {}
	
	public void dodajStudenta() {
		
		Main_Frame.getInstance().azurirajPrikazStudenta("DODAT", -1);
	}
	
    public void izbrisiStudeta(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela
    	Student student = BazaStudenta.getInstance().getRow(rowSelectedIndex);
    	BazaStudenta.getInstance().izbrisiStudenta(student.getBrojIndeksa());
		// azuriranje prikaza
		//Main_Frame.getInstance().azurirajPrikazStudenta("UKLONJEN", rowSelectedIndex);
    }
	
	public void izmeniStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		IzmenaStudentaDialog dialog = new IzmenaStudentaDialog(Main_Frame.getInstance(), "Izmena studenta", true,
				rowSelectedIndex);
		dialog.setVisible(true);
		// TODO: izmena dodatnih polja modela tabele
		
}//aj sad mi nadji dijalog
}

