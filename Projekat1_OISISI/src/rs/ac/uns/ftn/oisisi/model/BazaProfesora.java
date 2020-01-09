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
	
	private BazaProfesora() {
		
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
				for(Predmet p: BazaPredmeta.getInstance().getPredmete()) {
					if(p.getProfesori_predavaci().contains(i)) {
						p.getProfesori_predavaci().clear();
					}
				}
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
		BazaProfesora.broj_profesora = broj_profesora;
	}
	
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
		broj_profesora++;
		profesori.add(p);
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
				JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite profesora.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "Unete vrednosti nisu dobre! Moguce opcije su: " + 
						"ime, prezime, datum_rodjenja, adresa_stanovanja, telefon, email, adresa_kancelarije," + 
						"licna_karta, titula i zvanje.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (podelaTeksta.length > 1) {
				for (int i = 1; i < podelaTeksta.length; i++) {
					
					celina = podelaTeksta[i];
					deo = celina.split(":");
					
					if (deo.length != 2 || deo[1].trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite profesora.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
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
						JOptionPane.showMessageDialog(null, "Unete vrednosti nisu dobre! Moguce opcije su: " + 
								"ime, prezime, datum_rodjenja, adresa_stanovanja, telefon, email, adresa_kancelarije," + 
								"licna_karta, titula i zvanje.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
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

	public void obrisiPredmetKodProfesora(Predmet pred, String licna) {
		for(Profesor p : profesori) {
			if(p.getBroj_licne_karte().equals(licna)) {
				for (int i = 0; i < p.getSpisak_predmeta().size(); i++) {
					if(p.getSpisak_predmeta().get(i).getSifra_predmeta().equals(pred.getSifra_predmeta())) {
							p.getSpisak_predmeta().remove(i);
					}
				}
			}
		}	
	}
	public List<Profesor> getPretraga() {
		return pretraga;
	}

	public void setPretraga(List<Profesor> pretraga) {
		this.pretraga = pretraga;
	}
}
