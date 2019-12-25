package rs.ac.uns.ftn.oisisi.model;

import java.util.ArrayList;
import java.util.List;



public class BazaPredmeta {
	
	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance==null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	

	private List<String>kolone;
	private List<Predmet>predmeti;
	private int broj_predmeta =0;
	
	private BazaPredmeta() {
		
		
		initPredmete();
		
		this.kolone=new ArrayList<String>();
		this.kolone.add("SIFRA");
		this.kolone.add("NAZIV");
		this.kolone.add("SEMESTAR");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("SPISAK PROFESORA");
		this.kolone.add("SPISAK STUDENATA");
		dodajPredmet();
		
	}

	private void initPredmete() {
		this.predmeti=new ArrayList<Predmet>();
		
		this.predmeti.add(new Predmet("1","Algebra","prvi","prva godina"));
		this.predmeti.add(new Predmet("2","Fizika","drugi","prva godina"));
		this.predmeti.add(new Predmet("3","Objektno programiranje","treci","druga godina"));
		
		
	}

	public List<Predmet>getPredmete() {
		return predmeti;
	}
	
	public void setPredmete(List<Predmet> predmeti) {
		this.predmeti=predmeti;
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
		if(row<broj_predmeta) {
			Predmet predmet = this.predmeti.get(row);
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
	
	

/*	public void dodajPredmet(String sifra, String naziv, String semestar, String godina) {
	//	this.predmeti.add(new Predmet("5","Analiza 2","treci","druga godina"));
		this.predmeti.add(new Predmet(sifra,naziv,semestar,godina));
		broj_predmeta++;
	}*/
	public void dodajPredmet() {
			this.predmeti.add(new Predmet("5","Analiza 2","treci","druga godina"));
			
			broj_predmeta++;
		}

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
		this.broj_predmeta= broj_predmeta;
	}
	
	
	
} 
