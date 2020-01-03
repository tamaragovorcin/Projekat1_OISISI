package rs.ac.uns.ftn.oisisi.controller;
import java.io.IOException;

import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Profesor;
import rs.ac.uns.ftn.oisisi.view.IzmenaProfesoraDialog;
import rs.ac.uns.ftn.oisisi.view.IzmenaStudentaDialog;
import rs.ac.uns.ftn.oisisi.view.Main_Frame;

public class ProfesoriController {
private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora() {
		// izmena modela
		//BazaProfesora.getInstance().dodajProfesora("Ana","Petrovic","15.02.1956.","Fruskogorska 8","anapetrovic@gmail.com","0645899164","Radnicka 64","4569793","Redovni profesor","Doktor nauka");
		// azuriranje prikaza
		Main_Frame.getInstance().azurirajPrikazProfesora("DODAT", -1);
	}
	
    public void izbrisiProfesora(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	
    	Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
    	BazaProfesora.getInstance().izbrisiProfesora(profesor.getBroj_licne_karte());
		
    }
    public void izmeniProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		IzmenaProfesoraDialog dialog = new IzmenaProfesoraDialog(Main_Frame.getInstance(), "Izmena profesora", true,
				rowSelectedIndex);
		dialog.setVisible(true);
		// TODO: izmena dodatnih polja modela tabele
		
}
    
    public void sacuvajProfesoreTXT() throws IOException {
		BazaProfesora.getInstance().sacuvajProfesoreTXT();
	}

	public void ucitajProfesoreTXT() throws IOException {
		BazaProfesora.getInstance().ucitajProfesoreTXT();
	}

}
