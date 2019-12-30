package rs.ac.uns.ftn.oisisi.model;


import java.util.ArrayList;

public class Student extends Osoba{

	private String brojIndeksa;
	private String datumUpisa;
	private String godinaStudija;
    private	String Status;
	private ArrayList<Predmet> predmeti;
	
	
	public Student(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String email,
			String kontakt_telefon, String brojIndeksa,String datumUpisa, String godinaStudija, String status) {
		super(ime, prezime, datumRodjenja, adresaStanovanja, email, kontakt_telefon);
		this.brojIndeksa = brojIndeksa;
		this.datumUpisa = datumUpisa;
		this.godinaStudija = godinaStudija;
		Status = status;
		this.predmeti = predmeti;
	}


	public String getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}


	public String getDatumUpisa() {
		return datumUpisa;
	}


	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = datumUpisa;
	}


	public String getGodinaStudija() {
		return godinaStudija;
	}


	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}




	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}


	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	

	
}
