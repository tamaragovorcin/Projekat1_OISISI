package rs.ac.uns.ftn.oisisi.controller;



import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;
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

public void dodajIgraca() {

	BazaPredmeta.getInstance().dodajPredmet();

	Main_Frame.getInstance().azurirajPrikaz("DODAT", -1);
}

public void izbrisiPredmet(int rowSelectedIndex) {
	if (rowSelectedIndex < 0) {
		return;
	}

	Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
	BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifra_predmeta());
	
	Main_Frame.getInstance().azurirajPrikaz("UKLONJEN", rowSelectedIndex);
}

public void izmeniPredmet(int rowSelectedIndex) {
	if (rowSelectedIndex < 0) {
		return;
	}
	// izmena modela
	Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
	BazaPredmeta.getInstance().izmeniPredmet(predmet.getSifra_predmeta(), "OET1", "drugi", "prva godina");
	// TODO: izmena dodatnih polja modela tabele
	
	// azuriranje prikaza
	Main_Frame.getInstance().azurirajPrikaz(null, -1);
}

}