package rs.ac.uns.ftn.oisisi.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable{
	private String sifra_predmeta;
	private String naziv_predmeta;
	private String semestar;
	private String godina_studija_izvodjenja;
	private ArrayList<Profesor> profesori_predavaci;
	private ArrayList<Student>studenti_na_predmetu;
	

	public Predmet(String sifra_predmeta, String naziv_predmeta, String semestar, String godina_studija_izvodjenja) {
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv_predmeta = naziv_predmeta;
		this.semestar = semestar;
		this.godina_studija_izvodjenja = godina_studija_izvodjenja;
		this.profesori_predavaci = new ArrayList<Profesor>();
		this.studenti_na_predmetu = new ArrayList<Student>();
	}
	public String getSifra_predmeta() {
		return sifra_predmeta;
	}
	public void setSifra_predmeta(String sifra_predmeta) {
		this.sifra_predmeta = sifra_predmeta;
	}
	public String getNaziv_predmeta() {
		return naziv_predmeta;
	}
	public void setNaziv_predmeta(String naziv_predmeta) {
		this.naziv_predmeta = naziv_predmeta;
	}
	public String getSemestar() {
		return semestar;
	}
	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}
	public String getGodina_studija_izvodjenja() {
		return godina_studija_izvodjenja;
	}
	public void setGodina_studija_izvodjenja(String godina_studija_izvodjenja) {
		this.godina_studija_izvodjenja = godina_studija_izvodjenja;
	}
	public ArrayList<Profesor> getProfesori_predavaci() {
		return profesori_predavaci;
	}
	public void setProfesori_predavaci(ArrayList<Profesor> profesori_predavaci) {
		this.profesori_predavaci = profesori_predavaci;
	}
	public ArrayList<Student> getStudenti_na_predmetu() {
		return studenti_na_predmetu;
	}
	
	public void setStudenti_na_predmetu(ArrayList<Student> studenti_na_predmetu) {
		this.studenti_na_predmetu = studenti_na_predmetu;
	}
	

	@Override
	public String toString() {
		return sifra_predmeta+ " - " + naziv_predmeta + " - " + semestar + " - " + godina_studija_izvodjenja + " - " + profesori_predavaci+ "\n";
	}
	
}
