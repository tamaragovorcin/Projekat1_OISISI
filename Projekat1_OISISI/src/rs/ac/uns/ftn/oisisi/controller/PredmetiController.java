package rs.ac.uns.ftn.oisisi.controller;



import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.view.IzmenaPredmetaDialog;
import rs.ac.uns.ftn.oisisi.view.Main_Frame;

public class PredmetiController {

	private static PredmetiController instance = null;

public static PredmetiController getInstance() {
	if (instance == null) {
		instance = new PredmetiController();
	}
	return instance;
}

private PredmetiController() {}

public void dodajPredmet() {

	//BazaPredmeta.getInstance().dodajPredmet("123","Hemija","zimski","druga");

	Main_Frame.getInstance().azurirajPrikazPredmeta("DODAT", -1);
}

public void izbrisiPredmet(int rowSelectedIndex) {
	if (rowSelectedIndex < 0) {
		return;
	}

	Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
	BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifra_predmeta());
	
	Main_Frame.getInstance().azurirajPrikazPredmeta("UKLONJEN", rowSelectedIndex);
}

public void izmeniPredmet(int rowSelectedIndex) {
	if (rowSelectedIndex < 0) {
		return;
	}
	// izmena modela
	Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
	BazaPredmeta.getInstance().izmeniPredmet(predmet.getSifra_predmeta(), predmet.getNaziv_predmeta(), predmet.getSemestar(), predmet.getGodina_studija_izvodjenja());

	IzmenaPredmetaDialog dialog = new IzmenaPredmetaDialog(Main_Frame.getInstance(), "Izmena predmeta", true, rowSelectedIndex);
	dialog.setVisible(true);
	// TODO: izmena dodatnih polja modela tabele
	
	// azuriranje prikaza
	Main_Frame.getInstance().azurirajPrikazPredmeta(null, -1);
}

}