package rs.ac.uns.ftn.oisisi.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BazaStudenta {

	private static BazaStudenta instance = null;

	public static BazaStudenta getInstance() {
		if (instance == null) {
			instance = new BazaStudenta();
		}
		return instance;
	}

	public static int broj_studenata = 0;
	private List<String> kolone;
	protected List<Student> studenti;
	private List<Student> pretraga;
	Student student;

	private BazaStudenta() {

		this.kolone = new ArrayList<String>();
		this.studenti = new ArrayList<Student>();
		this.pretraga = new ArrayList<Student>();
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

	}

	public void initStudenti(String ime, String prezime, String datumRodjenja, String adresaStanovanja,
			String kontakt_telefon, String email, String brojIndeksa, String datumUpisa, String godinaStudija,
			String status) {

		this.studenti.add(new Student(ime, prezime, datumRodjenja, adresaStanovanja, kontakt_telefon, email,
				brojIndeksa, datumUpisa, godinaStudija, status));
		broj_studenata++;
	}

	public List<Student> getStudente() {
		return studenti;
	}

	public void setStudente(List<Student> studenti) {
		this.studenti = studenti;
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
		if (row < temp.size()) {
			Student student = temp.get(row);
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
		} else {
			return null;
		}
	}

	public void izbrisiStudenta(String sifra) {
		for (Student i : studenti) {
			if (i.getBrojIndeksa().equals(sifra)) {
				String broj = i.getBrojIndeksa();
				studenti.remove(i);

				for (Predmet p : BazaPredmeta.getInstance().getPredmete()) {
					if (p.getStudenti_na_predmetu().contains(i)) {
						for (Student stud : p.getStudenti_na_predmetu()) {
							if (stud.getBrojIndeksa().equals(broj)) {
								p.getStudenti_na_predmetu().remove(stud);
								break;
							}
						}
					}
				}
				break;
			}

		}
	}

	public void izmeniStudent(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String email,
			String kontakt_telefon, String indeks, String datumUpisa, String godinaStudija, String status) {
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
		BazaStudenta.broj_studenata = broj_studenata;
	}

	public void pretragaStudenta(String ulaz) {

		if (ulaz.trim().length() == 0) {
			pretraga.clear();
			return;
		}

		pretraga.clear();

		String podelaTeksta[] = ulaz.split(";");
		String celina = podelaTeksta[0];
		String[] deo = celina.split(":");

		if (deo.length != 2 || deo[1].trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite studenta.", "Upozorenje!",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (deo[0].toLowerCase().equals("ime")) {
			for (Student s : studenti) {
				if (s.getIme().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}

			}
		} else if (deo[0].toLowerCase().equals("prezime")) {
			for (Student s : studenti) {
				if (s.getPrezime().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}

			}
		} else if (deo[0].toLowerCase().equals("datum_rodjenja")) {
			for (Student s : studenti) {
				if (s.getDatumRodjenja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}

			}
		} else if (deo[0].toLowerCase().equals("adresa_stanovanja")) {
			for (Student s : studenti) {
				if (s.getAdresaStanovanja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}
			}
		} else if (deo[0].toLowerCase().equals("telefon")) {
			for (Student s : studenti) {
				if (s.getKontakt_telefon().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}
			}
		} else if (deo[0].toLowerCase().equals("email")) {
			for (Student s : studenti) {
				if (s.getEmail().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}
			}
		} else if (deo[0].toLowerCase().equals("broj_indeksa")) {
			for (Student s : studenti) {
				if (s.getBrojIndeksa().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}
			}
		} else if (deo[0].toLowerCase().equals("datum_upisa")) {
			for (Student s : studenti) {
				if (s.getDatumUpisa().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}
			}
		} else if (deo[0].toLowerCase().equals("godina_studija")) {
			for (Student s : studenti) {
				if (s.getGodinaStudija().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}
			}
		} else if (deo[0].toLowerCase().equals("status")) {
			for (Student s : studenti) {
				if (s.getStatus().toLowerCase().equals(deo[1].trim().toLowerCase())) {
					pretraga.add(s);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Unete vrednosti nisu dobre! Moguce opcije su: "
							+ "ime, prezime, datum_rodjenja, adresa_stanovanja, telefon, email, broj indeksa "
							+ "datum upisa, godina_studija i status.",
					"Upozorenje!", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (podelaTeksta.length > 1) {
			for (int i = 1; i < podelaTeksta.length; i++) {

				celina = podelaTeksta[i];
				deo = celina.split(":");

				if (deo.length != 2 || deo[1].trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Pokusajte ponovo da pretrazite studenta.", "Upozorenje!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (deo[0].toLowerCase().equals("ime")) {
					for (Student s : studenti) {
						if (!s.getIme().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}

					}
				} else if (deo[0].toLowerCase().equals("prezime")) {
					for (Student s : studenti) {
						if (!s.getPrezime().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}

					}
				} else if (deo[0].toLowerCase().equals("datum_rodjenja")) {
					for (Student s : studenti) {
						if (!s.getDatumRodjenja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}

					}
				} else if (deo[0].toLowerCase().equals("adresa_stanovanja")) {
					for (Student s : studenti) {
						if (!s.getAdresaStanovanja().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}
					}
				} else if (deo[0].toLowerCase().equals("telefon")) {
					for (Student s : studenti) {
						if (!s.getKontakt_telefon().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}
					}
				} else if (deo[0].toLowerCase().equals("email")) {
					for (Student s : studenti) {
						if (!s.getEmail().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}
					}
				} else if (deo[0].toLowerCase().equals("broj_indeksa")) {
					for (Student s : studenti) {
						if (!s.getBrojIndeksa().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}
					}
				} else if (deo[0].toLowerCase().equals("datum_upisa")) {
					for (Student s : studenti) {
						if (!s.getDatumUpisa().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}
					}
				} else if (deo[0].toLowerCase().equals("godina_studija")) {
					for (Student s : studenti) {
						if (!s.getGodinaStudija().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}
					}
				} else if (deo[0].toLowerCase().equals("status")) {
					for (Student s : studenti) {
						if (!s.getStatus().toLowerCase().equals(deo[1].trim().toLowerCase())) {
							pretraga.remove(s);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Unete vrednosti nisu dobre! Moguce opcije su: "
									+ "ime, prezime, datum_rodjenja, adresa_stanovanja, telefon, email, broj indeksa "
									+ "datum upisa, godina_studija i status.",
							"Upozorenje!", JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		}

		if (pretraga.size() == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoji student sa unetim vrednostima.");
		}
	}

	public Student getStudentaPoPredmetu(String indeks) {
		Student p = null;
		for (Student stud : studenti) {
			if (stud.getBrojIndeksa().equals(indeks)) {
				p = stud;
			}
		}
		return p;
	}

	public boolean postojiBrojIndeksa(String indeks) {
		boolean izlaz = false;

		for (Student stud : studenti) {
			if (stud.getBrojIndeksa().equals(indeks)) {
				izlaz = true;
			}
		}
		return izlaz;
	}

	public void dodajPredmetStudentu(Predmet predmet2, String indeks) {
		for (Student stud : studenti) {
			if (stud.getBrojIndeksa().equals(indeks)) {
				stud.getPredmeti().add(predmet2);
			}
		}
	}

	public void obrisiPredmetKodStudenta(Predmet pred, String indeks) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equals(indeks)) {
				for (int i = 0; i < s.getPredmeti().size(); i++) {
					if (s.getPredmeti().get(i).getSifra_predmeta().equals(pred.getSifra_predmeta())) {
						s.getPredmeti().remove(i);
					}
				}
			}
		}

	}

	public List<Student> getPretraga() {
		return pretraga;
	}

	public void setPretraga(List<Student> pretraga) {
		this.pretraga = pretraga;
	}
}
