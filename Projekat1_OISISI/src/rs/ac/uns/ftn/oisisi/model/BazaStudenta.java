package rs.ac.uns.ftn.oisisi.model;

import java.util.ArrayList;
import java.util.List;

public class BazaStudenta {
	
	private static BazaStudenta instance=null;
	
	public static BazaStudenta getInstance(){
		
		if(instance==null) {
			instance=new BazaStudenta();
		}
		
			return instance;
		
		
	}
	
	
	private int broj_studenata=0;
	private List<String>kolone;
	private List<Student> studenti;
	
	private BazaStudenta() {
		
		
		
		this.kolone=new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("DATUM RODJENJA");
		this.kolone.add("ADRESA STANOVANJA");
		this.kolone.add("TELEFON");
		this.kolone.add("E-MAIL");
		this.kolone.add("BROJ INDEKSA");
		this.kolone.add("DATUM UPISA");
		this.kolone.add("TRENUTNA GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSECNA OCENA");
		this.kolone.add("SPISAK PREDMETA");
		
	}

	public void initStudenti(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String email,
			String kontakt_telefon, String indeks, String datumUpisa, String godinaStudija,String status) {
		this.studenti.add(new Student(ime,prezime,datumRodjenja,adresaStanovanja,email,kontakt_telefon,indeks,datumUpisa,godinaStudija,status));
		
		//this.studenti.add(new Student("Ana","Petrovic","14.02.1999.","Pavla Simica 2","0652610775","anapetrovic@gmail.com","RA47-2017","1.10.2017.",3,"B",8.12));
		//this.studenti.add(new Student("Jovan","Simic","20.08.1997.","Zeleznicka 18","0694566123","jovansimic5@gmail.com","RA5-2015","1.10.2015",4,"B",9.7));
		//this.studenti.add(new Student("Nadja","Jovic","05.05.1998.","Vase Stajica 3","0654599255","nadjajovic@gmail.com","RA89-2017","1.10.2017",3,"S",7.0));
		broj_studenata++;
		
	}

	public List<Student> getStudente() {
		return studenti;
	}
	
	public void setStudente(List<Student> studenti) {
		this.studenti=studenti;
	}
	
	public int getColumnCount() {
		return 12;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		if(row<broj_studenata) {
			Student student= this.studenti.get(row);
			switch (column) {
			case 0:
				return student.getIme();
			case 1:
				return student.getPrezime();
			case 2:
				return student.getDatumRodjenja();
			case 3:
				return student.getAdresaStanovanja();
			case 4:
				return student.getKontakt_telefon();
			case 5:
				return student.getEmail();
			case 6:
				return student.getBrojIndeksa();
			case 7:
				return student.getDatumUpisa();
			case 8:
				return student.getGodinaStudija();
			case 9:
				return student.getStatus();
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

	/*public void dodajStudenta(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String email,
			String kontakt_telefon, String indeks, String datumUpisa, String godinaStudija,String status,String prosecnaOcena) {
		this.studenti.add(new Student(ime,prezime,datumRodjenja,adresaStanovanja,email,kontakt_telefon,indeks,datumUpisa,godinaStudija,status,prosecnaOcena));
		broj_studenata++;
	}
*/
	public void izbrisiStudenta(String sifra) {
		for (Student i : studenti) {
			if (i.getBrojIndeksa().equals(sifra)) {
				studenti.remove(i);
				break;
			}
		}
	}

	public void izmeniStudent(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String email,
			String kontakt_telefon, String indeks, String datumUpisa,String godinaStudija,String status,String prosecnaOcena) {
		for (Student i : studenti) {
			if (i.getBrojIndeksa().equals(indeks)) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatumRodjenja(datumRodjenja);
				i.setAdresaStanovanja(adresaStanovanja);
				i.setEmail(email);
				i.setKontakt_telefon(kontakt_telefon);
				i.setDatumUpisa(datumUpisa);
				i.setGodinaStudija(godinaStudija);
				i.setStatus(status);
			}
		}
	}

	public int getBroj_studenata() {
		return broj_studenata;
	}

	public void setBroj_studenata(int broj_studenata) {
		this.broj_studenata=broj_studenata;
	}
}
