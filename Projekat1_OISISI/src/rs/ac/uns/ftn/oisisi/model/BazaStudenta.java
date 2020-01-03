package rs.ac.uns.ftn.oisisi.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.view.PredmetiJTable;
import rs.ac.uns.ftn.oisisi.view.StudentiJTable;

public class BazaStudenta {
	
	private static BazaStudenta instance=null;
	
	public static BazaStudenta getInstance(){
		
		if(instance==null) {
			instance=new BazaStudenta();
		}
		
			return instance;
		
		
	}
	
	
	private static int broj_studenata=0;
	private List<String>kolone;
	private List<Student> studenti;
	private List<Student> pretraga;

	private static int brojStudentaPretrage = 0;
	private static int broj_studenta = 0;
	File nazivTXT = new File("studenti.txt");
	private BazaStudenta() {
		
		
		
		this.kolone=new ArrayList<String>();
		this.studenti = new ArrayList<Student>();
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
		this.kolone.add("SPISAK PREDMETA");
		
		initi();
		//initStudenti("Ana","Petrovic","14.02.1999.","Pavla Simica 2","0652610775","anapetrovic@gmail.com","RA47-2017","1.10.2017.","III","B");
	}

	public void initStudenti(String ime, String prezime, String datumRodjenja, String adresaStanovanja,
		String kontakt_telefon, String email, String brojIndeksa,String datumUpisa, String godinaStudija, String status) {

		this.studenti.add(new Student(ime,prezime,datumRodjenja,adresaStanovanja,kontakt_telefon,email,brojIndeksa,datumUpisa,godinaStudija,status));
		broj_studenata++;
	}/*	
		//this.studenti.add(new Student("Ana","Petrovic","14.02.1999.","Pavla Simica 2","0652610775","anapetrovic@gmail.com","RA47-2017","1.10.2017.",3,"B",8.12));
		//this.studenti.add(new Student("Jovan","Simic","20.08.1997.","Zeleznicka 18","0694566123","jovansimic5@gmail.com","RA5-2015","1.10.2015",4,"B",9.7));
		//this.studenti.add(new Student("Nadja","Jovic","05.05.1998.","Vase Stajica 3","0654599255","nadjajovic@gmail.com","RA89-2017","1.10.2017",3,"S",7.0));
		
		
	//}*/
	public void initi() {
		this.studenti.add(new Student("Ana","Petrovic","14.02.1999","Pavla Simica 2","065264102","anapetrovic@gmail.com","RA/47/2017","01.10.2017","III","B"));
		broj_studenata++;
	}

	public List<Student> getStudente() {
		return studenti;
	}
	
	public void setStudente(List<Student> studenti) {
		this.studenti=studenti;
	}
	
	public int getColumnCount() {
		return 11;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		
		List<Student> temp;
		if (pretraga.size() == 0) {
			temp = studenti;
		} else {
			temp = pretraga;
		}
		if(row<temp.size()) {
			Student student= temp.get(row);
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
			String kontakt_telefon, String indeks, String datumUpisa,String godinaStudija,String status) {
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
	public void pretragaStudenata(String ulaz) {
		if (ulaz.trim().length() == 0) {
			pretraga.clear();
			brojStudentaPretrage = 0;
			return;
		}

		pretraga.clear();
		brojStudentaPretrage = 0;

		String podelaTeksta[] = ulaz.split(";");
		String celina = podelaTeksta[0];
		String[] deo = celina.split(":");

		// String a = deo[0].toLowerCase().trim();
		// String b = deo[1].trim().toLowerCase();

		if (deo.length != 2 || deo[1].trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite studenta!");
			return;
		}

		if (deo[0].toLowerCase().equals("ime")) {
			for (Student s:studenti) {
				if (s.getIme().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}

			}
		} else if (deo[0].toLowerCase().equals("prezime")) {
			for (Student s:studenti) {
				if (s.getPrezime().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}

			}
		} else if (deo[0].toLowerCase().equals("datumrodjenja")) {
			for (Student s:studenti) {
				if (s.getDatumRodjenja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}

			}
		} else if (deo[0].toLowerCase().equals("adresa")) {
			for (Student s:studenti) {
				if (s.getAdresaStanovanja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}

			}
		}else if (deo[0].toLowerCase().equals("telefon")) {
			for (Student s:studenti) {
				if (s.getKontakt_telefon().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}

			}
		}else if (deo[0].toLowerCase().equals("email")) {
				for (Student s:studenti) {
					if (s.getEmail().toLowerCase().equals(deo[1].trim().toLowerCase())) {
						pretraga.add(s);
					}

				}
		}
		else if (deo[0].toLowerCase().equals("brojindeksa")) {
					for (Student s:studenti) {
						if (s.getBrojIndeksa().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(s);
						}

					}
		}
		else if (deo[0].toLowerCase().equals("datumupisa")) {
						for (Student s:studenti) {
							if (s.getDatumUpisa().toLowerCase().equals(deo[1].trim().toLowerCase())) {
								pretraga.add(s);
							}

						}
		}else if (deo[0].toLowerCase().equals("godinastudija")) {
							for (Student s:studenti) {
								if (s.getGodinaStudija().toLowerCase().equals(deo[1].trim().toLowerCase())) {
									pretraga.add(s);
								}

							}
		}else if (deo[0].toLowerCase().equals("status")) {
			for (Student s:studenti) {
				if (s.getStatus().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}

			}
}else {
			JOptionPane.showMessageDialog(null,
					"Unete vrednosti nisu dobre! Moguce opcije su: ime, prezime, datum rodjenja, adresa, telefon, email, broj indeksa, datum upisa, godina studija i status");
			return;
		}
		if (podelaTeksta.length > 1) {
			for (int i = 1; i < podelaTeksta.length; i++) {
				
				celina = podelaTeksta[i];
				deo = celina.split(":");
				
				if (deo.length != 2 || deo[1].trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite studenta!");
					return;
				}

				
				if (deo.length != 2 || deo[1].trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite studenta!");
					return;
				}

				if (deo[0].toLowerCase().equals("ime")) {
					for (Student s:studenti) {
						if (s.getIme().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(s);
						}

					}
				} else if (deo[0].toLowerCase().equals("prezime")) {
					for (Student s:studenti) {
						if (s.getPrezime().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(s);
						}

					}
				} else if (deo[0].toLowerCase().equals("datumrodjenja")) {
					for (Student s:studenti) {
						if (s.getDatumRodjenja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(s);
						}

					}
				} else if (deo[0].toLowerCase().equals("adresa")) {
					for (Student s:studenti) {
						if (s.getAdresaStanovanja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(s);
						}

					}
				}else if (deo[0].toLowerCase().equals("telefon")) {
					for (Student s:studenti) {
						if (s.getKontakt_telefon().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(s);
						}

					}
				}else if (deo[0].toLowerCase().equals("email")) {
						for (Student s:studenti) {
							if (s.getEmail().toLowerCase().equals(deo[1].trim().toLowerCase())) {
								pretraga.add(s);
							}

						}
				}
				else if (deo[0].toLowerCase().equals("brojindeksa")) {
							for (Student s:studenti) {
								if (s.getBrojIndeksa().toLowerCase().equals(deo[1].trim().toLowerCase())) {
									pretraga.add(s);
								}

							}
				}
				else if (deo[0].toLowerCase().equals("datumupisa")) {
								for (Student s:studenti) {
									if (s.getDatumUpisa().toLowerCase().equals(deo[1].trim().toLowerCase())) {
										pretraga.add(s);
									}

								}
				}else if (deo[0].toLowerCase().equals("godinastudija")) {
									for (Student s:studenti) {
										if (s.getGodinaStudija().toLowerCase().equals(deo[1].trim().toLowerCase())) {
											pretraga.add(s);
										}

									}
				}else if (deo[0].toLowerCase().equals("status")) {
					for (Student s:studenti) {
						if (s.getStatus().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(s);
						}

					}
		}else {
					JOptionPane.showMessageDialog(null,
							"Unete vrednosti nisu dobre! Moguce opcije su: ime, prezime, datum rodjenja, adresa, telefon, email, broj indeksa, datum upisa, godina studija i status");
					return;
				
			}
			}
		}
		
		brojStudentaPretrage = pretraga.size();

		if (pretraga.size() == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoji student sa unetim vrednostima.");
		}
	}
	

		
	
	
	public void sacuvajStudenteTXT() throws IOException {
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nazivTXT))); 
			for(int i = 0; i<studenti.size();i++) {
				Student p = studenti.get(i);
				String a = p.toString();
				br.write(a);
			}
			br.close();
	}
	
	public void ucitajStudenteTXT() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nazivTXT)));
		
		String ulaz = new String();
		
		while((ulaz=br.readLine())!=null) {
			String deo[] = ulaz.split("-");
			String delovi[] =  new String[deo.length];
			for(int i = 0; i <deo.length;i++) {
				delovi[i] = deo[i].trim();
			}
			dodajstudenta(delovi);
		}
		StudentiJTable.getInstance().refresTabelu();
		
	}

	private boolean dodajstudenta(String[] delovi) {
		
		String a = delovi[0];
		if(studentNePostoji(a)) {
			
			Student novi = new Student(delovi[0],delovi[1],delovi[2],delovi[3],delovi[4],delovi[5],delovi[6],delovi[7],delovi[8],delovi[9]);
			studenti.add(novi);
			broj_studenata++;
			return true;
		}
		return false;
		
	}

	private boolean studentNePostoji(String a) {
		for(Student s:studenti) {
			if(a.equals(s.getBrojIndeksa())) {
				return false;
			}
		}
		return true;
	}

}
