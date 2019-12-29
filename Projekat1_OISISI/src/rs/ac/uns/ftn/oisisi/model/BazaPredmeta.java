package rs.ac.uns.ftn.oisisi.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private List<String> kolone;
	private List<Predmet> predmeti;

	private List<Predmet> pretraga;

	private static int brojPredmetaPretrage = 0;
	private static int broj_predmeta = 0;

	private BazaPredmeta() {
		String sifra = "";
		String naziv = "";
		String semestar = "";
		String godina = "";

		this.kolone = new ArrayList<String>();
		this.predmeti = new ArrayList<Predmet>();
		this.pretraga = new ArrayList<Predmet>();
		this.kolone.add("SIFRA");
		this.kolone.add("NAZIV");
		this.kolone.add("SEMESTAR");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("SPISAK PROFESORA");
		this.kolone.add("SPISAK STUDENATA");
		// dodajPredmet();
		// initPredmete( sifra, naziv, semestar, godina);
		// dodajPredmet( sifra, naziv, semestar, godina);
	}

	public void initPredmete(String sifra, String naziv, String semestar, String godina) {

		this.predmeti.add(new Predmet(sifra, naziv, semestar, godina));
		// this.predmeti.add(new Predmet("1","Algebra","prvi","prva godina"));
		// this.predmeti.add(new Predmet("2","Fizika","drugi","prva godina"));
		// this.predmeti.add(new Predmet("3","Objektno programiranje","treci","druga
		// godina"));

		broj_predmeta++;

	}

	public List<Predmet> getPredmete() {
		return predmeti;
	}

	public void setPredmete(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		List<Predmet> temp;
		if (pretraga.size() == 0) {
			temp = predmeti;
		} else {
			temp = pretraga;
		}

		if (row < temp.size()) {
			Predmet predmet = temp.get(row);
			switch (column) {
			case 0:
				return predmet.getSifra_predmeta();
			case 1:
				return predmet.getNaziv_predmeta();
			case 2:
				return predmet.getSemestar();
			case 3:
				return predmet.getGodina_studija_izvodjenja();
			case 4:
				return "Spisak prefosora";
			case 5:
				return "Spisak studenata";
			default:
				return null;
			}
		} else {
			return null;
		}
	}

	// public void dodajPredmet(String sifra, String naziv, String semestar, String
	// godina) {
	// this.predmeti.add(new Predmet("5","Analiza 2","treci","druga godina"));
	// this.predmeti.add(new Predmet(sifra,naziv,semestar,godina));
	// broj_predmeta++;
	// }
	/*
	 * public void dodajPredmet() { this.predmeti.add(new
	 * Predmet("5","Analiza 2","treci","druga godina"));
	 * 
	 * broj_predmeta++; }
	 */

	public void izbrisiPredmet(String sifra) {
		for (Predmet i : predmeti) {
			if (i.getSifra_predmeta().equals(sifra)) {
				predmeti.remove(i);
				break;
			}
		}
	}

	public void izmeniPredmet(String sifra, String naziv, String semestar, String godina) {
		for (Predmet i : predmeti) {
			if (i.getSifra_predmeta().equals(sifra)) {
				i.setNaziv_predmeta(naziv);
				i.setSemestar(semestar);
				i.setGodina_studija_izvodjenja(godina);
			}
		}
	}

	public int getBroj_predmeta() {
		return broj_predmeta;
	}

	public void setBroj_predmeta(int broj_predmeta) {
		this.broj_predmeta = broj_predmeta;
	}

	public void pretragaPredmeta(String ulaz) {
		if (ulaz.trim().length() == 0) {
			pretraga.clear();
			brojPredmetaPretrage = 0;
			return;
		}

		pretraga.clear();
		brojPredmetaPretrage = 0;

		String podelaTeksta[] = ulaz.split(";");
		String celina = podelaTeksta[0];
		String[] deo = celina.split(":");

		// String a = deo[0].toLowerCase().trim();
		// String b = deo[1].trim().toLowerCase();

		if (deo.length != 2 || deo[1].trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite predmet!");
			return;
		}

		if (deo[0].toLowerCase().equals("sifra")) {
			for (Predmet p : predmeti) {
				if (p.getSifra_predmeta().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(p);
				}

			}
		} else if (deo[0].toLowerCase().equals("naziv")) {
			for (Predmet p : predmeti) {
				if (p.getNaziv_predmeta().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(p);
				}

			}
		} else if (deo[0].toLowerCase().equals("semestar")) {
			for (Predmet p : predmeti) {
				if (p.getSemestar().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(p);
				}

			}
		} else if (deo[0].toLowerCase().equals("godina")) {
			for (Predmet p : predmeti) {
				if (p.getGodina_studija_izvodjenja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(p);
				}

			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Unete vrednosti nisu dobre! Moguce opcije su: sifra, naziv, semestar, godina.");
			return;
		}
		if (podelaTeksta.length > 1) {
			for (int i = 1; i < podelaTeksta.length; i++) {
				
				celina = podelaTeksta[i];
				deo = celina.split(":");
				
				if (deo.length != 2 || deo[1].trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite predmet!");
					return;
				}

				
				
				if (deo[0].toLowerCase().equals("sifra")) {
					for (Predmet p : predmeti) {
						if (!p.getSifra_predmeta().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(p);
						}

					}
				} else if (deo[0].toLowerCase().equals("naziv")) {
					for (Predmet p : predmeti) {
						if (!p.getNaziv_predmeta().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(p);
						}

					}
				} else if (deo[0].toLowerCase().equals("semestar")) {
					for (Predmet p : predmeti) {
						if (!p.getSemestar().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(p);
						}

					}
				} else if (deo[0].toLowerCase().equals("godina")) {
					for (Predmet p : predmeti) {
						if (!p.getGodina_studija_izvodjenja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(p);
						}

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Unete vrednosti nisu dobre! Moguce opcije su: sifra, naziv, semestar, godina.");
					return;
				}
			}
		}
		brojPredmetaPretrage = pretraga.size();

		if (pretraga.size() == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoji predmet sa unetim vrednostima.");
		}

	}

}
