package rs.ac.uns.ftn.oisisi.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.view.ProfesoriJTable;


public class BazaProfesora {

private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance==null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	


	private static int broj_profesora = 0;
	private List<String>kolone;
	private List<Profesor>profesori;
	private List<Profesor>pretraga;
	Predmet predmet;
	

	File nazivTXT = new File("profesori.txt");
	private BazaProfesora() {
		
		
		//initProfesori();
		
		this.kolone=new ArrayList<String>();
		this.profesori=new ArrayList<Profesor>();
		this.pretraga= new ArrayList<Profesor>();
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
		//initProfesori();
		
	}

	private void initProfesori() {
		this.profesori=new ArrayList<Profesor>();
		this.profesori.add(new Profesor("Pera","Peric","20.05.1965.","Masarikova 15","111","peraperic@gmail.com","Radnicka 55","111","Redovni profesor","Doktor nauka"));
		this.profesori.add(new Profesor("Jovan","Jovanovic","20.08.1970.","Sfarikova 15","0694566123","jovanjovanovic@gmail.com","Radnicka 55","222","Redovni profesor","Doktor nauka"));
		this.profesori.add(new Profesor("Natalija","Jokic","05.05.1975.","Puskinova 9","0654599255","natalijajokic@gmail.com","Radnicka 55","333","Redovni profesor","Doktor nauka"));
		
		++broj_profesora;
		
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
		List<Profesor> temp;
		if(pretraga.size()==0) {
			temp = profesori;
		}
		else {
			temp=pretraga;
		}
		if(row<temp.size()) {
			Profesor profesor = temp.get(row);
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

	public void dodajProfesora(String ime, String prezime, String datumRodjenja, String adresaStanovanja,
			String kontakt_telefon, String email, String adresa_kancelarije, String broj_licne_karte, String titula, String zvanje) {
		this.profesori.add(new Profesor(ime,prezime,datumRodjenja,adresaStanovanja,kontakt_telefon,email,adresa_kancelarije,broj_licne_karte,titula,zvanje));
		++broj_profesora;
	}

	public void izbrisiProfesora(String sifra) {
		for (Profesor i : profesori) {
			if (i.getBroj_licne_karte().equals(sifra)) {
				profesori.remove(i);
				break;
			}
		}
	}

	public void izmeniProfesora(String ime, String prezime, String datumRodjenja, String adresaStanovanja,
			String kontakt_telefon, String email,String adresa_kancelarije, String broj_licne_karte, String titula, String zvanje) {
		for (Profesor i : profesori) {
			if (i.getBroj_licne_karte().equals(broj_licne_karte)) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setDatumRodjenja(datumRodjenja);
				i.setAdresaStanovanja(adresaStanovanja);
				i.setKontakt_telefon(kontakt_telefon);
				i.setEmail(email);
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
	
/*	public void sacuvajProfesoreTXT() throws IOException {
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nazivTXT))); 
			for(int i = 0; i<profesori.size();i++) {
				Profesor p = profesori.get(i);
				String a = p.toString();
				br.write(a);
			}
			br.close();
	}*/
	
	 public void sacuvajProfesoreTXT() throws IOException{
		 ObjectOutputStream out=null;
		 
		 try {
			 out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("profesori.raw")));
			 for(Profesor p:profesori) {
				 out.writeObject(p);
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 if(out!=null) {
				 try {
					 out.close();
				 }catch(Exception e2) {
					 
				 }
			 }
		 }
	 }
	
/*	public void ucitajProfesoreTXT() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nazivTXT)));
		
		String ulaz = new String();
		
		while((ulaz=br.readLine())!=null) {
			String deo[] = ulaz.split("-");
			String delovi[] =  new String[deo.length];
			for(int i = 0; i <deo.length;i++) {
				delovi[i] = deo[i].trim();
			}
			dodajprofesora(delovi);
		}
		ProfesoriJTable.getInstance().refresTabelu();
		
	}*/
	 
	 public void ucitajProfesoreTXT() throws IOException {
			ObjectInputStream in =null;
			Profesor p=null;
			
			try {
				in=new ObjectInputStream(new BufferedInputStream(new FileInputStream("profesori.raw")));
				while(true) {
					p=(Profesor) in.readObject();
					dodajprofesora2(p);
				}
			}catch(Exception e) {
				// e.printStackTrace();
			 }finally {
				 if(in!=null) {
					 try {
						 in.close();
					 }catch(Exception e2) {
						 
					 }
				 }
			 }
				 
			 
			 }
			 

			private void dodajprofesora2(Profesor p) {
				// TODO Auto-generated method stub
				broj_profesora++;
				profesori.add(p);
			}

	private boolean dodajprofesora(String[] delovi) {
		
		String a = delovi[0];
		if(profesorNePostoji(a)) {
			
			Profesor novi = new Profesor(delovi[0],delovi[1],delovi[2],delovi[3],delovi[4],delovi[5],delovi[6],delovi[7],delovi[8],delovi[9]);
			profesori.add(novi);
			broj_profesora++;
			return true;
		}
		return false;
		
	}

	private boolean profesorNePostoji(String a) {
		for(Profesor p: profesori) {
			if(a.equals(p.getBroj_licne_karte())) {
				return false;
			}
		}
		return true;
		
	}

	 public void pretragaProfesora(String ulaz) {
			if (ulaz.trim().length() == 0) {
				pretraga.clear();
				return;
			}

			pretraga.clear();

			String podelaTeksta[] = ulaz.split(";");
			String celina = podelaTeksta[0];
			String[] deo = celina.split(":");
		
			if (deo.length != 2 || deo[1].trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite profesora!");
				return;
			}
			
			if (deo[0].toLowerCase().equals("ime")) {
				for (Profesor p : profesori) {
					if (p.getIme().toLowerCase().equals(deo[1].trim().toLowerCase())) {
						pretraga.add(p);
					}

				}
			} else if (deo[0].toLowerCase().equals("prezime")) {
				for (Profesor p : profesori) {
					if (p.getPrezime().toLowerCase().equals(deo[1].trim().toLowerCase())) {
						pretraga.add(p);
					}

				}
			} else if (deo[0].toLowerCase().equals("datum_rodjenja")) {
				for (Profesor p : profesori) {
					if (p.getDatumRodjenja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
						pretraga.add(p);
					}

				}
			} else if (deo[0].toLowerCase().equals("adresa_stanovanja")) {
				for (Profesor p : profesori) {
					if (p.getAdresaStanovanja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
						pretraga.add(p);
					}
				}
			}  else if (deo[0].toLowerCase().equals("telefon")) {
					for (Profesor p : profesori) {
						if (p.getKontakt_telefon().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(p);
						}
					}
			}  else if (deo[0].toLowerCase().equals("email")) {
					for (Profesor p : profesori) {
						if (p.getEmail().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(p);
						}
					}
			} else if (deo[0].toLowerCase().equals("adresa_kancelarije")) {
					for (Profesor p : profesori) {
						if (p.getAdresa_kancelarije().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(p);
						}
					}
			} else if (deo[0].toLowerCase().equals("licna_karta")) {
					for (Profesor p : profesori) {
						if (p.getBroj_licne_karte().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(p);
							}
					}
			} else if (deo[0].toLowerCase().equals("titula")) {
					for (Profesor p : profesori) {
						if (p.getTitula().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(p);
						}
					}
			} else if (deo[0].toLowerCase().equals("zvanje")) {
					for (Profesor p : profesori) {
						if (p.getZvanje().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.add(p);
							}
					}
			} else {
				JOptionPane.showMessageDialog(null,
						"Unete vrednosti nisu dobre! Moguce opcije su: "
						+ "ime, prezime, datum_rodjenja, adresa_stanovanja, telefon, email, adresa_kancelarije, "
						+ "licna_karta, titula i zvanje.");
				return;
			}
			
			if (podelaTeksta.length > 1) {
				for (int i = 1; i < podelaTeksta.length; i++) {
					
					celina = podelaTeksta[i];
					deo = celina.split(":");
					
					if (deo.length != 2 || deo[1].trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite profesora!");
						return;
					}
					
					if (deo[0].toLowerCase().equals("ime")) {
						for (Profesor p : profesori) {
							if (!p.getIme().toLowerCase().equals(deo[1].trim().toLowerCase())) {
								pretraga.remove(p);
							}

						}
					} else if (deo[0].toLowerCase().equals("prezime")) {
						for (Profesor p : profesori) {
							if (!p.getPrezime().toLowerCase().equals(deo[1].trim().toLowerCase())) {
								pretraga.remove(p);
							}

						}
					} else if (deo[0].toLowerCase().equals("datum_rodjenja")) {
						for (Profesor p : profesori) {
							if (!p.getDatumRodjenja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
								pretraga.remove(p);
							}

						}
					} else if (deo[0].toLowerCase().equals("adresa_stanovanja")) {
						for (Profesor p : profesori) {
							if (!p.getAdresaStanovanja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
								pretraga.remove(p);
							}
						}
					}  else if (deo[0].toLowerCase().equals("telefon")) {
							for (Profesor p : profesori) {
								if (!p.getKontakt_telefon().toLowerCase().equals(deo[1].trim().toLowerCase())) {
									pretraga.remove(p);
								}
							}
					}  else if (deo[0].toLowerCase().equals("email")) {
							for (Profesor p : profesori) {
								if (!p.getEmail().toLowerCase().equals(deo[1].trim().toLowerCase())) {
									pretraga.remove(p);
								}
							}
					} else if (deo[0].toLowerCase().equals("adresa_kancelarije")) {
							for (Profesor p : profesori) {
								if (!p.getAdresa_kancelarije().toLowerCase().equals(deo[1].trim().toLowerCase())) {
									pretraga.remove(p);
								}
							}
					} else if (deo[0].toLowerCase().equals("licna_karta")) {
							for (Profesor p : profesori) {
								if (!p.getBroj_licne_karte().toLowerCase().equals(deo[1].trim().toLowerCase())) {
									pretraga.remove(p);
									}
							}
					} else if (deo[0].toLowerCase().equals("titula")) {
							for (Profesor p : profesori) {
								if (!p.getTitula().toLowerCase().equals(deo[1].trim().toLowerCase())) {
									pretraga.remove(p);
								}
							}
					} else if (deo[0].toLowerCase().equals("zvanje")) {
							for (Profesor p : profesori) {
								if (!p.getZvanje().toLowerCase().equals(deo[1].trim().toLowerCase())) {
									pretraga.remove(p);
									}
							}
					} else {
						JOptionPane.showMessageDialog(null,
								"Unete vrednosti nisu dobre! Moguce opcije su: "
								+ "ime, prezime, datum_rodjenja, adresa_stanovanja, telefon, email, adresa_kancelarije, "
								+ "licna_karta, titula i zvanje.");
						return;
					}
				
				}
			}

			if (pretraga.size() == 0) {
				JOptionPane.showMessageDialog(null, "Ne postoji profesor sa unetim vrednostima.");
			}
			
			
	}

	public Profesor getProfesorPoPredmetu(String licna) {
		Profesor p=null;
		for(Profesor prof: profesori) {
			if(prof.getBroj_licne_karte().equals(licna)) {
				p = prof;
			}
		}
		return p;
	}

	public boolean postojiLicnaKarta(String licna) {
		boolean izlaz=false;
		
		for(Profesor prof: profesori) {
			if(prof.getBroj_licne_karte().equals(licna)) {
				izlaz = true;
			}
		}
		return izlaz;
	}

	public void dodajPredmetProfesu(Predmet predmet2, String licna) {
		for(Profesor prof : profesori) {
			if(prof.getBroj_licne_karte().equals(licna)) {
				prof.getSpisak_predmeta().add(predmet2);
			}
		}
	}
}
