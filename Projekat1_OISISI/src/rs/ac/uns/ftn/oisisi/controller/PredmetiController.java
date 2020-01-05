package rs.ac.uns.ftn.oisisi.controller;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Profesor;
import rs.ac.uns.ftn.oisisi.model.Student;
import rs.ac.uns.ftn.oisisi.view.DialogDodajProfesoraNaPredmet;
import rs.ac.uns.ftn.oisisi.view.DodavanjeStudentaNaPredmetDialog;
import rs.ac.uns.ftn.oisisi.view.IzmenaPredmetaDialog;
import rs.ac.uns.ftn.oisisi.view.Main_Frame;
import rs.ac.uns.ftn.oisisi.view.PredmetiJTable;
import rs.ac.uns.ftn.oisisi.view.PredmetiTablePanel;
import rs.ac.uns.ftn.oisisi.view.TabelaListaStudenata;
import rs.ac.uns.ftn.oisisi.view.Toolbar;

public class PredmetiController {

	private static PredmetiController instance = null;

	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}

	private PredmetiController() {
	}

	public void dodajPredmet() {

		//BazaPredmeta.getInstance().dodajPredmet();
	}

	public void izbrisiPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifra_predmeta());

		
	}

	public void izmeniPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		IzmenaPredmetaDialog dialog = new IzmenaPredmetaDialog(Main_Frame.getInstance(), "Izmena predmeta", true,
				rowSelectedIndex);
		dialog.setVisible(true);
	}

	public void pretraziPredmet() {

		JTextField tekst = Toolbar.getInstance().getSearchField();
		String a = tekst.getText();

		BazaPredmeta.getInstance().pretragaPredmeta(a);

	}

	public void sacuvajPredmeteTXT() throws IOException {
		BazaPredmeta.getInstance().sacuvajPredmeteTXT();
	}

	public void ucitajPredmeteTXT() throws IOException {
		BazaPredmeta.getInstance().ucitajPredmeteTXT();
	}

	public void dodavanjeProfesoraNaPredmet() {
		int red = PredmetiJTable.getInstance().getSelectedRow();
		if(red>=0 && red<BazaPredmeta.getInstance().getBroj_predmeta()) {
			DialogDodajProfesoraNaPredmet dialog = new DialogDodajProfesoraNaPredmet(null, "Dodavanje profesora na predmet", true);
			dialog.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Predmet nije selektovan");
		}
	}
	public void dodajProfesora(Profesor prof, Predmet pred, int i) {
		BazaPredmeta.getInstance().dodajProfesoraNaPredmet(prof, pred, i);
	}
	
	public Predmet getPredmetPoProfesoru(int red) {
		Predmet p;
		p = BazaPredmeta.getInstance().getPredmetPoProfesoru(red);
		return p;
	}

	public boolean PostojiProfesorNaPredmetu(int red, String licna) {
		boolean izlaz = false;
		
		if(BazaPredmeta.getInstance().PostojiProfesorNaPredmetu(red, licna)) {
			izlaz = true;
		}
		return izlaz;
		
	}
	
	
	
	public void dodavanjeStudentaNaPredmet() {
		int red = PredmetiJTable.getInstance().getSelectedRow();
		if(red>=0 && red<BazaPredmeta.getInstance().getBroj_predmeta()) {
			DodavanjeStudentaNaPredmetDialog dialog = new DodavanjeStudentaNaPredmetDialog(null, "Dodavanje studenta na predmet", true);
			dialog.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Predmet nije selektovan");
		}
	}
	public void dodajStudenta(Student stud, Predmet pred, int i) {
		BazaPredmeta.getInstance().dodajStudentaNaPredmet(stud, pred, i);
	}
	
	public Predmet getPredmetPoStudentu(int red) {
		Predmet p;
		p = BazaPredmeta.getInstance().getPredmetPoStudentu(red);
		return p;
	}

	public boolean PostojiStudentNaPredmetu(int red, String licna) {
		boolean izlaz = false;
		
		if(BazaPredmeta.getInstance().PostojiStudentNaPredmetu(red, licna)) {
			izlaz = true;
		}
		return izlaz;
		
	}

	public void obrisiProfesoraSaPredmeta(int predmet, int profesor) {
		BazaPredmeta.getInstance().obrisiProfesorasaPredmeta(predmet,profesor);
		
	}

	
}