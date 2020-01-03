package rs.ac.uns.ftn.oisisi.model;

public abstract class Osoba {
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String email;
	private String kontakt_telefon;
	
	public Osoba(String ime, String prezime, String datumRodjenja, String adresaStanovanja, 
			String kontakt_telefon,String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontakt_telefon = kontakt_telefon;
		this.email = email;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKontakt_telefon() {
		return kontakt_telefon;
	}
	public void setKontakt_telefon(String kontakt_telefon) {
		this.kontakt_telefon = kontakt_telefon;
	}
	
	
	
}
