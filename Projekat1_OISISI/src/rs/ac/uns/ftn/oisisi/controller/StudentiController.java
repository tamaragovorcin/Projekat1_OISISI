package rs.ac.uns.ftn.oisisi.controller;

import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Profesor;
import rs.ac.uns.ftn.oisisi.model.Student;
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
		// izmena modela
		BazaStudenta.getInstance().initStudenti("Ana","Petrovic","14.02.1999.","Pavla Simica 2","0652610775","anapetrovic@gmail.com","RA47-2017","1.10.2017.","3","B","8.12");
		// azuriranje prikaza
		Main_Frame.getInstance().azurirajPrikaz("DODAT", -1);
	}
	
    public void izbrisiStudeta(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela
    	Student student = BazaStudenta.getInstance().getRow(rowSelectedIndex);
    	BazaStudenta.getInstance().izbrisiStudenta(student.getBrojIndeksa());
		// azuriranje prikaza
		Main_Frame.getInstance().azurirajPrikaz("UKLONJEN", rowSelectedIndex);
    }
	
	public void izmeniStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Student student = BazaStudenta.getInstance().getRow(rowSelectedIndex);
		BazaStudenta.getInstance().izmeniStudent("Ana","Petrovic","14.02.1999.","Pavla Simica 2","0652610775","anapetrovic@gmail.com",student.getBrojIndeksa(),"1.10.2017.","3","B","8.12");
		// TODO: izmena dodatnih polja modela tabele
		
		// azuriranje prikaza
		Main_Frame.getInstance().azurirajPrikaz(null, -1);
	}
}
