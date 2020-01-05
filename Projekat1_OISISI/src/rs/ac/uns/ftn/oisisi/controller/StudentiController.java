package rs.ac.uns.ftn.oisisi.controller;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Profesor;
import rs.ac.uns.ftn.oisisi.model.Student;
import rs.ac.uns.ftn.oisisi.view.DialogDodajProfesoraNaPredmet;
import rs.ac.uns.ftn.oisisi.view.DodavanjeStudentaNaPredmetDialog;
import rs.ac.uns.ftn.oisisi.view.IzmenaPredmetaDialog;
import rs.ac.uns.ftn.oisisi.view.IzmenaStudentaDialog;
import rs.ac.uns.ftn.oisisi.view.Main_Frame;
import rs.ac.uns.ftn.oisisi.view.PredmetiJTable;
import rs.ac.uns.ftn.oisisi.view.Toolbar;

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
    	Student student = BazaStudenta.getInstance().getRow(rowSelectedIndex);
    	BazaStudenta.getInstance().izbrisiStudenta(student.getBrojIndeksa());
    }
	
	public void izmeniStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		IzmenaStudentaDialog dialog = new IzmenaStudentaDialog(Main_Frame.getInstance(), "Izmena studenta", true,
				rowSelectedIndex);
		dialog.setVisible(true);		
}
	
	public void sacuvajStudenteTXT() throws IOException {
		BazaStudenta.getInstance().sacuvajStudenteTXT();
	}

	public void ucitajStudenteTXT() throws IOException {
		BazaStudenta.getInstance().ucitajStudenteTXT();
	}
	
	public void pretraziStudenta() {

		JTextField tekst = Toolbar.getInstance().getSearchField();
		String a = tekst.getText();

		BazaStudenta.getInstance().pretragaStudenta(a);

	}
	public Student getStudentaPoPredmetu(String licna) {
		Student p;
		p = BazaStudenta.getInstance().getStudentaPoPredmetu(licna);
		return p;
	}

	public boolean PostojiBrojIndeksa(String licna) {
		boolean izlaz=false;
		if(BazaStudenta.getInstance().postojiBrojIndeksa(licna)) {
			izlaz = true;
		}
		
		return izlaz;
	}

	public void dodajPredmetStuddentu(Predmet predmet, String indeks) {
		BazaStudenta.getInstance().dodajPredmetStudentu(predmet,indeks);
		
	}
	
}

