package rs.ac.uns.ftn.oisisi.model;

import java.util.ArrayList;

public class Profesor extends Osoba {

	private String adresa_kancelarije;
	private String broj_licne_karte;
	private String titula;
	private String zvanje;
	private ArrayList<Predmet>spisak_predmeta;
	
	
	
	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String email,
			String kontakt_telefon, String adresa_kancelarije, String broj_licne_karte, String titula, String zvanje) {
		super(ime, prezime, datumRodjenja, adresaStanovanja, email, kontakt_telefon);
		this.adresa_kancelarije = adresa_kancelarije;
		this.broj_licne_karte = broj_licne_karte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.spisak_predmeta = new ArrayList<Predmet>();
	}
	
	public String getAdresa_kancelarije() {
		return adresa_kancelarije;
	}
	public void setAdresa_kancelarije(String adresa_kancelarije) {
		this.adresa_kancelarije = adresa_kancelarije;
	}
	public String getBroj_licne_karte() {
		return broj_licne_karte;
	}
	public void setBroj_licne_karte(String broj_licne_karte) {
		this.broj_licne_karte = broj_licne_karte;
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public ArrayList<Predmet> getSpisak_predmeta() {
		return spisak_predmeta;
	}
	public void setSpisak_predmeta(ArrayList<Predmet> spisak_predmeta) {
		this.spisak_predmeta = spisak_predmeta;
	}
	
	
}