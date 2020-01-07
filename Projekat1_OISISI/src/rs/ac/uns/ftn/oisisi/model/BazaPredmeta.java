package rs.ac.uns.ftn.oisisi.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	private static int broj_predmeta = 0;
	private static int broj_profesora_na_predmetu = 0;
	private static int broj_studenta_na_predmetu = 0;

	private BazaPredmeta() {

		this.kolone = new ArrayList<String>();
		this.predmeti = new ArrayList<Predmet>();
		this.pretraga = new ArrayList<Predmet>();
		this.kolone.add("SIFRA");
		this.kolone.add("NAZIV");
		this.kolone.add("SEMESTAR");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("SPISAK PROFESORA");
		this.kolone.add("SPISAK STUDENATA");
	}

	public void initPredmete(String sifra, String naziv, String semestar, String godina) {
		this.predmeti.add(new Predmet(sifra, naziv, semestar, godina));
		broj_predmeta++;
	}

	public List<Predmet> getPredmete() {
		return predmeti;
	}

	public void setPredmete(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 6;
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
		BazaPredmeta.broj_predmeta = broj_predmeta;
	}

	public void pretragaPredmeta(String ulaz) {
		if (ulaz.trim().length() == 0) {
			pretraga.clear();
			return;
		}

		pretraga.clear();

		String podelaTeksta[] = ulaz.split(";");
		String celina = podelaTeksta[0];
		String[] deo = celina.split(":");

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
					"Unete vrednosti nisu dobre! Moguce opcije su: sifra, naziv, semestar i godina.");
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
							"Unete vrednosti nisu dobre! Moguce opcije su: sifra, naziv, semestar i godina.");
					return;
				}
			}
		}
		if (pretraga.size() == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoji predmet sa unetim vrednostima.");
		}

	}

	public void sacuvajPredmeteTXT() throws IOException{
		 ObjectOutputStream out=null;
		 
		 try {
			 out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("predmeti.raw")));
			 for(Predmet p:predmeti) {
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
	
	public void ucitajPredmeteTXT() throws IOException {
		ObjectInputStream in =null;
		Predmet p=null;
		
		try {
			in=new ObjectInputStream(new BufferedInputStream(new FileInputStream("predmeti.raw")));
			while(true) {
				p=(Predmet) in.readObject();
				dodajpredmeta2(p);
			}
		}catch(Exception e) {
			
	    }finally {
			 if(in!=null) {
				 try {
					 in.close();
				 }catch(Exception e2) {
					 
				 }
			 }
		 } 
	 }
		 
	private void dodajpredmeta2(Predmet p) {
		broj_predmeta++;
		predmeti.add(p);
	}

	public void dodajProfesoraNaPredmet(Profesor prof, Predmet pred, int i) {
		predmeti.get(i).getProfesori_predavaci().add(prof);
		broj_profesora_na_predmetu++;
	}
	
	public static int getBroj_profesora_na_predmetu() {
		return broj_profesora_na_predmetu;
	}

	public static void setBroj_profesora_na_predmetu(int broj_profesora_na_predmetu) {
		BazaPredmeta.broj_profesora_na_predmetu = broj_profesora_na_predmetu;
	}

	public Predmet getPredmetPoProfesoru(int red) {
		Predmet p;
		p = predmeti.get(red);
		return p;
	}
	
	public boolean PostojiProfesorNaPredmetu(int red, String licna) {
		boolean izlaz = false;
		for( Profesor prof:predmeti.get(red).getProfesori_predavaci()) {
			if(prof.getBroj_licne_karte().equals(licna)) {
				izlaz= true;
			}
		}
		return izlaz;
	}

	public void dodajStudentaNaPredmet(Student student, Predmet pred, int i) {
		
		predmeti.get(i).getStudenti_na_predmetu().add(student);
		broj_studenta_na_predmetu++;
	}

	public static int getBroj_studenta_na_predmetu() {
		return broj_studenta_na_predmetu;
	}

	public static void setBroj_studenta_na_predmetu(int broj_studenta_na_predmetu) {
		BazaPredmeta.broj_studenta_na_predmetu = broj_studenta_na_predmetu;
	}

	public Predmet getPredmetPoStudentu(int red) {
		Predmet p;
		p = predmeti.get(red);
		return p;
	}
	
	public boolean PostojiStudentNaPredmetu(int red, String indeks) {
		boolean izlaz = false;
		for( Student stud:predmeti.get(red).getStudenti_na_predmetu()) {
			if(stud.getBrojIndeksa().equals(indeks)) {
				izlaz= true;
			}
		}
		return izlaz;
	}
	
	
	
	public void obrisiStudentaSaPredmeta(int a,int i) {
		predmeti.get(a).getStudenti_na_predmetu().remove(i);
		broj_studenta_na_predmetu--;
	}
	
	public void obrisiProfesorasaPredmeta(int predmet,int profesor) {
		predmeti.get(predmet).getProfesori_predavaci().remove(profesor);
		broj_profesora_na_predmetu--;	
	}

	public void obrisiStudentasaPredmeta(int predmet,int student) {
		predmeti.get(predmet).getStudenti_na_predmetu().remove(student);
		broj_studenta_na_predmetu--;
	}

	public List<Predmet> getPretraga() {
		return pretraga;
	}

	public void setPretraga(List<Predmet> pretraga) {
		this.pretraga = pretraga;
	}

}
