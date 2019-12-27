package rs.ac.uns.ftn.oisisi.controller;
import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.Profesor;
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
		BazaProfesora.getInstance().dodajProfesora("Ana","Petrovic","15.02.1956.","Fruskogorska 8","anapetrovic@gmail.com","0645899164","Radnicka 64","4569793","Redovni profesor","Doktor nauka");
		// azuriranje prikaza
		Main_Frame.getInstance().azurirajPrikaz("DODAT", -1);
	}
	
    public void izbrisiProfesora(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela
    	Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
    	BazaProfesora.getInstance().izbrisiProfesora(profesor.getBroj_licne_karte());
		// azuriranje prikaza
		Main_Frame.getInstance().azurirajPrikaz("UKLONJEN", rowSelectedIndex);
    }
	
	public void izmeniProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().izmeniProfesora("Anja","Sibul","15.02.1970.","Fruskogorska 50","anjasibul@gmail.com","0645845664","Radnicka 64",profesor.getBroj_licne_karte(),"Redovni profesor","Doktor nauka");
		// TODO: izmena dodatnih polja modela tabele
		
		// azuriranje prikaza
		Main_Frame.getInstance().azurirajPrikaz(null, -1);
	}
	
}
