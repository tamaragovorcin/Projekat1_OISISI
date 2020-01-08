package rs.ac.uns.ftn.oisisi.controller;

import java.io.IOException;
import javax.swing.JTextField;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Student;
import rs.ac.uns.ftn.oisisi.view.IzmenaStudentaDialog;
import rs.ac.uns.ftn.oisisi.view.Main_Frame;
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
	
	public void dodajStudenta() {}
	
    public void izbrisiStudeta(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	if (BazaStudenta.getInstance().getPretraga().size() == 0) {
			Student student = BazaStudenta.getInstance().getRow(rowSelectedIndex);
			BazaStudenta.getInstance().izbrisiStudenta(student.getBrojIndeksa());
		} else {
			Student student = BazaStudenta.getInstance().getPretraga().get(rowSelectedIndex);
			BazaStudenta.getInstance().izbrisiStudenta(student.getBrojIndeksa());
			BazaStudenta.getInstance().getPretraga().remove(rowSelectedIndex);
		}
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
	
	public void obrisiPredmetKodStudenta(Predmet pred, String indeks) {
		BazaStudenta.getInstance().obrisiPredmetKodStudenta(pred,indeks);	
	}
}

