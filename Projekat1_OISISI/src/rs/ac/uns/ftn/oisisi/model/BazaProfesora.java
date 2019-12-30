package rs.ac.uns.ftn.oisisi.model;

import java.util.ArrayList;
import java.util.List;

public class BazaProfesora {

private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance==null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private int broj_profesora = 0;
	private List<String>kolone;
	private List<Profesor>profesori;
	
	private BazaProfesora() {
		
		
		initProfesori();
		
		this.kolone=new ArrayList<String>();
		this.profesori=new ArrayList<Profesor>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("DATUM RODJENJA");
		this.kolone.add("ADRESA STANOVANJA");
		this.kolone.add("TELEFON");
		this.kolone.add("E-MAIL");
		this.kolone.add("ADRESA KANCELARIJE");
		this.kolone.add("BROJ LICNE KARTE");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
		this.kolone.add("SPISAK PREDMETA");
		
	}

	private void initProfesori() {
		this.profesori=new ArrayList<Profesor>();
		
		this.profesori.add(new Profesor("Pera","Peric","20.05.1965.","Masarikova 15","0644569456","peraperic@gmail.com","Radnicka 55","0264589","Redovni profesor","Doktor nauka"));
		this.profesori.add(new Profesor("Jovan","Jovanovic","20.08.1970.","Sfarikova 15","0694566123","jovanjovanovic@gmail.com","Radnicka 55","4569872","Redovni profesor","Doktor nauka"));
		this.profesori.add(new Profesor("Natalija","Jokic","05.05.1975.","Puskinova 9","0654599255","natalijajokic@gmail.com","Radnicka 55","0321236","Redovni profesor","Doktor nauka"));
		
		
	}

	public List<Profesor>getProfesore() {
		return profesori;
	}
	
	public void setProfesore(List<Profesor> profesori) {
		this.profesori=profesori;
	}
	
	public int getColumnCount() {
		return 11;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		if(row<broj_profesora) {
			Profesor profesor = this.profesori.get(row);
			switch (column) {
			case 0:
				return profesor.getIme();
			case 1:
				return profesor.getPrezime();
			case 2:
				return profesor.getDatumRodjenja();
			case 3:
				return profesor.getAdresaStanovanja();
			case 4:
				return profesor.getKontakt_telefon();
			case 5:
				return profesor.getEmail();
			case 6:
				return profesor.getAdresa_kancelarije();
			case 7:
				return profesor.getBroj_licne_karte();
			case 8:
				return profesor.getTitula();
			case 9:
				return profesor.getZvanje();
			case 10:
				return "Spisak predmeta";
			default:
				return null;
			}
		}
		else {
			return null;
		}
	}

	public void dodajProfesora(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String email,
			String kontakt_telefon, String adresa_kancelarije, String broj_licne_karte, String titula, String zvanje) {
		this.profesori.add(new Profesor(ime,prezime,datumRodjenja,adresaStanovanja,email,kontakt_telefon,adresa_kancelarije,broj_licne_karte,titula,zvanje));
		broj_profesora++;
	}

	public void izbrisiProfesora(String sifra) {
		for (Profesor i : profesori) {
			if (i.getBroj_licne_karte().equals(sifra)) {
				profesori.remove(i);
				break;
			}
		}
	}

	public void izmeniProfesora(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String email,
			String kontakt_telefon, String adresa_kancelarije, String broj_licne_karte, String titula, String zvanje) {
		for (Profesor i : profesori) {
			if (i.getBroj_licne_karte().equals(broj_licne_karte)) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatumRodjenja(datumRodjenja);
				i.setAdresaStanovanja(adresaStanovanja);
				i.setEmail(email);
				i.setKontakt_telefon(kontakt_telefon);
				i.setAdresa_kancelarije(adresa_kancelarije);
				i.setTitula(titula);
				i.setZvanje(zvanje);
			}
		}
	}

	public int getBroj_profesora() {
		return broj_profesora;
	}

	public void setBroj_profesora(int broj_profesora) {
		this.broj_profesora = broj_profesora;
	}
}
