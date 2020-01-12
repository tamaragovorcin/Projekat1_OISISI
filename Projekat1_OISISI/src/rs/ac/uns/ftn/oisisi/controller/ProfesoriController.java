package rs.ac.uns.ftn.oisisi.controller;

import javax.swing.JTextField;

import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Profesor;
import rs.ac.uns.ftn.oisisi.view.IzmenaProfesoraDialog;
import rs.ac.uns.ftn.oisisi.view.Main_Frame;
import rs.ac.uns.ftn.oisisi.view.Toolbar;

public class ProfesoriController {
	private static ProfesoriController instance = null;

	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}

	private ProfesoriController() {
	}

	public void dodajProfesora() {
		BazaProfesora.getInstance().dodajProfesora("Ana", "Petrovic", "15.02.1956.", "Fruskogorska 8",
				"anapetrovic@gmail.com", "0645899164", "Radnicka 64", "4569793", "Redovni profesor", "Doktor nauka");
	}

	public void izbrisiProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		if (BazaProfesora.getInstance().getPretraga().size() == 0) {
			Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
			BazaProfesora.getInstance().izbrisiProfesora(profesor.getBroj_licne_karte());
		} else {
			Profesor profesor = BazaProfesora.getInstance().getPretraga().get(rowSelectedIndex);
			BazaProfesora.getInstance().izbrisiProfesora(profesor.getBroj_licne_karte());
			BazaProfesora.getInstance().getPretraga().remove(rowSelectedIndex);
		}
	}

	public void izmeniProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		IzmenaProfesoraDialog dialog = new IzmenaProfesoraDialog(Main_Frame.getInstance(), "Izmena profesora", true,
				rowSelectedIndex);
		dialog.setVisible(true);
	}

	public void pretraziProfesora() {
		JTextField tekst = Toolbar.getInstance().getSearchField();
		String a = tekst.getText();

		BazaProfesora.getInstance().pretragaProfesora(a);
	}

	public Profesor getProfesoraPoPredmetu(String licna) {
		Profesor p;
		p = BazaProfesora.getInstance().getProfesorPoPredmetu(licna);
		return p;
	}

	public boolean PostojiLicnaKarta(String licna) {
		boolean izlaz = false;
		if (BazaProfesora.getInstance().postojiLicnaKarta(licna)) {
			izlaz = true;
		}
		return izlaz;
	}

	public void dodajPredmetProfesoru(Predmet predmet, String licna) {
		BazaProfesora.getInstance().dodajPredmetProfesu(predmet, licna);
	}

	public void obrisiPredmetKodProfesora(Predmet pred, String licna) {
		BazaProfesora.getInstance().obrisiPredmetKodProfesora(pred, licna);
	}

}
