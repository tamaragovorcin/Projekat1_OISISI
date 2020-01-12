package rs.ac.uns.ftn.oisisi.view;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;
import rs.ac.uns.ftn.oisisi.model.BazaPodaci;
import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -7863806568418316202L;

	private static MenuBar instance = null;
	private JMenu file;
	private JMenu edit;
	private JMenu help;
	private JMenuItem miClose;
	private JMenu miNew;
	private JMenu editEdit;
	private JMenu editDelete;
	private JMenuItem helpHelp;
	private JMenu helpAbout;
	private JMenuItem novistudent;
	private JMenuItem noviprofesor;
	private JMenuItem novipredmet;
	private JMenu noviprofstud;
	private JMenuItem novipredstud;
	private JMenuItem novipredprof;

	private JMenuItem editstudent;
	private JMenuItem editprofesor;
	private JMenuItem editpredmet;

	private JMenuItem delstudent;
	private JMenuItem delprofesor;
	private JMenuItem delpredmet;

	private JMenuItem aboutstud1;
	private JMenuItem aboutstud2;
	private JMenuItem aboutapp;

	private JScrollPane scrollPane;
	JTextArea ta;
	TextField textField = new TextField();

	public static MenuBar getInstance() {
		if (instance == null) {
			instance = new MenuBar();
		}
		return instance;
	}

	private MenuBar() {
		BazaPodaci bp = new BazaPodaci();
		file = new JMenu("File");
		miClose = new JMenuItem("Close");
		miNew = new JMenu("New");
		novistudent = new JMenuItem("New Student");
		noviprofesor = new JMenuItem("New Profesor");
		novipredmet = new JMenuItem("New Predmet");
		noviprofstud = new JMenu("New Student/Profesor");
		novipredstud = new JMenuItem("New Student");
		novipredprof = new JMenuItem("New Profesor");

		novistudent.setMnemonic(KeyEvent.VK_N);
		novistudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		novistudent.setIcon(new ImageIcon("images2/buttonplus.png"));
		novistudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeStudentaDialog dialog = new DodavanjeStudentaDialog(Main_Frame.getInstance(),
						"Dodavanje novog studenta", true);
				dialog.setVisible(true);
				StudentiJTable.getInstance().refresTabelu();
			}
		});

		miNew.add(novistudent);
		miNew.addSeparator();

		noviprofesor.setMnemonic(KeyEvent.VK_P);
		noviprofesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		noviprofesor.setIcon(new ImageIcon("images2/buttonplus.png"));

		noviprofesor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeProfesoraDialog dialog = new DodavanjeProfesoraDialog(Main_Frame.getInstance(),
						"Dodavanje novog profesora", true);
				dialog.setVisible(true);
				ProfesoriJTable.getInstance().refresTabelu();
			}
		});
		miNew.add(noviprofesor);
		miNew.addSeparator();

		novipredmet.setMnemonic(KeyEvent.VK_R);
		novipredmet.setIcon(new ImageIcon("images2/buttonplus.png"));
		novipredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		novipredmet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog(Main_Frame.getInstance(),
						"Dodavanje novog predmeta", true);
				dialog.setVisible(true);
				PredmetiJTable.getInstance().refresTabelu();
			}
		});
		miNew.add(novipredmet);

		novipredstud.setMnemonic(KeyEvent.VK_T);
		novipredstud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		novipredstud.setIcon(new ImageIcon("images2/buttonplus.png"));
		novipredstud.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeStudentaNaPredmetDialog dialog = new DodavanjeStudentaNaPredmetDialog(Main_Frame.getInstance(),
						"Dodavanje studenta na predmet", true);
				dialog.setVisible(true);
				PredmetiJTable.getInstance().refresTabelu();
			}
		});
		noviprofstud.add(novipredstud);
		noviprofstud.addSeparator();

		novipredprof.setMnemonic(KeyEvent.VK_F);
		novipredprof.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		novipredprof.setIcon(new ImageIcon("images2/buttonplus.png"));
		novipredprof.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DialogDodajProfesoraNaPredmet dialog = new DialogDodajProfesoraNaPredmet(Main_Frame.getInstance(),
						"Dodavanje profesora na predmet", true);
				dialog.setVisible(true);
				PredmetiJTable.getInstance().refresTabelu();
			}
		});
		noviprofstud.add(novipredprof);

		noviprofstud.setIcon(new ImageIcon("images2/buttonplus.png"));
		miNew.add(noviprofstud);
		miNew.addSeparator();

		miNew.setIcon(new ImageIcon("images2/buttonplus.png"));
		file.add(miNew);
		file.addSeparator();

		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.setIcon(new ImageIcon("images2/close.png"));
		miClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int odabir = JOptionPane.showConfirmDialog(Main_Frame.getInstance(),
						"Da li ste sigurni da zelite da zatvorite aplikaciju?", "Zatvaranje aplikacije",
						JOptionPane.YES_NO_OPTION);

				if (odabir == JOptionPane.YES_OPTION) {
					try {
						bp.cuvanje();

					} catch (Exception t) {

					}
					System.exit(0);
				}
			}
		});

		file.add(miClose);

		edit = new JMenu("Edit");
		editEdit = new JMenu("Edit");
		editDelete = new JMenu("Delete");
		editstudent = new JMenuItem("Edit Student");
		editprofesor = new JMenuItem("Edit Profesor");
		editpredmet = new JMenuItem("Edit Predmet");

		editstudent.setMnemonic(KeyEvent.VK_E);
		editstudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editstudent.setIcon(new ImageIcon("images2/edit.png"));
		editstudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = StudentiTablePanel.getSelektovan_red();
				if (row >= 0 && row < BazaStudenta.getInstance().getBroj_studenata()) {
					StudentiController.getInstance().izmeniStudenta(row);
				} else {
					JOptionPane.showMessageDialog(null, "Student nije selektovan.", "Upozorenje!",
							JOptionPane.ERROR_MESSAGE);
				}
				StudentiJTable.getInstance().refresTabelu();
				editstudent.setSelected(false);
			}
		});
		editEdit.add(editstudent);
		editEdit.addSeparator();

		editprofesor.setMnemonic(KeyEvent.VK_A);
		editprofesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		editprofesor.setIcon(new ImageIcon("images2/edit.png"));
		editprofesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = ProfesoriTablePanel.getSelektovan_red();
				if (row >= 0 && row < BazaProfesora.getInstance().getBroj_profesora()) {
					ProfesoriController.getInstance().izmeniProfesora(row);
				} else {
					JOptionPane.showMessageDialog(null, "Profesor nije selektovan.", "Upozorenje!",
							JOptionPane.ERROR_MESSAGE);
				}
				ProfesoriJTable.getInstance().refresTabelu();
				editprofesor.setSelected(false);
			}
		});
		editEdit.add(editprofesor);
		editEdit.addSeparator();

		editpredmet.setMnemonic(KeyEvent.VK_B);
		editpredmet.setIcon(new ImageIcon("images2/edit.png"));
		editpredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		editpredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = PredmetiTablePanel.getSelektovan_red();
				if (row >= 0 && row < BazaPredmeta.getInstance().getBroj_predmeta()) {
					PredmetiController.getInstance().izmeniPredmet(row);
				} else {
					JOptionPane.showMessageDialog(null, "Predmet nije selektovan.", "Upozorenje!",
							JOptionPane.ERROR_MESSAGE);
				}
				PredmetiJTable.getInstance().refresTabelu();
				editpredmet.setSelected(false);
			}
		});
		editEdit.add(editpredmet);

		editEdit.setIcon(new ImageIcon("images2/edit.png"));
		edit.add(editEdit);
		edit.addSeparator();

		delstudent = new JMenuItem("Delete Student");
		delprofesor = new JMenuItem("Delete Profesor");
		delpredmet = new JMenuItem("Delete Predmet");

		delstudent.setMnemonic(KeyEvent.VK_D);
		delstudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		delstudent.setIcon(new ImageIcon("images2/garbage.png"));

		delstudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = StudentiTablePanel.getSelektovan_red();
				if (row >= 0 && row < BazaStudenta.getInstance().getBroj_studenata()) {
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete stduenta?",
							"Brisanje studenta", JOptionPane.YES_NO_OPTION);
					if (izbor == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Student je obrisan!");
						StudentiController.getInstance().izbrisiStudeta(row);
					} else {
						JOptionPane.showMessageDialog(null, "Student nije obrisan.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Student nije selektovan.", "Upozorenje!",
							JOptionPane.ERROR_MESSAGE);
				}
				StudentiJTable.getInstance().refresTabelu();
				delstudent.setSelected(false);
			}
		});
		editDelete.add(delstudent);
		editDelete.addSeparator();

		delprofesor.setMnemonic(KeyEvent.VK_V);
		delprofesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		delprofesor.setIcon(new ImageIcon("images2/garbage.png"));
		delprofesor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = ProfesoriTablePanel.getSelektovan_red();
				if (row >= 0 && row < BazaProfesora.getInstance().getBroj_profesora()) {
					int izbor = JOptionPane.showConfirmDialog(null,
							"Da li ste sigurni da zelite da obrisete profesora?", "Brisanje predmeta",
							JOptionPane.YES_NO_OPTION);
					if (izbor == JOptionPane.YES_OPTION) {
						ProfesoriController.getInstance().izbrisiProfesora(row);
						JOptionPane.showMessageDialog(null, "Profesor je obrisan!");
					} else {
						JOptionPane.showMessageDialog(null, "Profesor nije obrisan.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Profesor nije selektovan.", "Upozorenje!",
							JOptionPane.ERROR_MESSAGE);
				}
				ProfesoriJTable.getInstance().refresTabelu();
				delprofesor.setSelected(false);
			}
		});
		editDelete.add(delprofesor);
		editDelete.addSeparator();

		delpredmet.setMnemonic(KeyEvent.VK_M);
		delpredmet.setIcon(new ImageIcon("images2/garbage.png"));
		delpredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		delpredmet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = PredmetiTablePanel.getSelektovan_red();
				if (row >= 0 && row < BazaPredmeta.getInstance().getBroj_predmeta()) {
					int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete predmet?",
							"Brisanje predmeta", JOptionPane.YES_NO_OPTION);
					if (izbor == JOptionPane.YES_OPTION) {
						PredmetiController.getInstance().izbrisiPredmet(row);
						JOptionPane.showMessageDialog(null, "Predmet je obrisan!");
					} else {
						JOptionPane.showMessageDialog(null, "Predmet nije obrisan.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Predmet nije selektovan.", "Upozorenje!",
							JOptionPane.ERROR_MESSAGE);
				}
				PredmetiJTable.getInstance().refresTabelu();
				delpredmet.setSelected(false);
			}
		});
		editDelete.add(delpredmet);

		editDelete.setIcon(new ImageIcon("images2/garbage.png"));
		edit.add(editDelete);

		help = new JMenu("Help");
		helpHelp = new JMenuItem("Help");
		helpHelp.setMnemonic(KeyEvent.VK_H);
		helpHelp.setIcon(new ImageIcon("images2/information.png"));
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		helpHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ta = new JTextArea("\t\t\t NAČIN KORIŠĆENJA APLIKACIJE \n\n" + "TABELA STUDENATA\n"
						+ "1.	Dodavanje studenta je moguće pomoću dugmeta u tabeli ili preko File -> New -> New Student\n"
						+ "2.	Izmena studenta moguća je iz pomoću dugmeta u tabeli ili preko Edit->Edit-> Edit Student\n"
						+ "3.	Brisanje studenta moguće je pomoću dugmeta u tabeli ili preko Edit -> Delete ->Delete Student\n"
						+ "Validacija unosa:\n" + "Datum je u formatu - 00.00.0000.\n"
						+ "Broj telefona može sadržati bilo koju cifru i znakove / i -.\n"
						+ "Indeks je u formatu XX(X) 00(0)/0000 (minimalno prva dva velika slova, maksimlano 3).\n"
						+ "Email – bilo_šta@bilo_šta.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate studenta\n\n\n"
						+ "TABELA PREDMETA\n"
						+ "1.	Dodavanje predmeta moguće je pomoću dugmeta u tabeli ili preko File->New->New Predmet\n"
						+ "2.	Izmena predmeta moguće je pomoću dugmeta u tabeli ili preko Edit->Edit-> Edit Predmet\n"
						+ "3.	Brisanje predmeta moguće je pomoću dugmeta u tabeli ili preko Edit->Delete-> Delete Predmet\n"
						+ "4.	Dodavanje studenta na predmet moguće je pomoću dugmeta u tabeli ili preko File->New->New Student/Profesor-> New Student\n"
						+ "5.	Dodavanje profesora na predmet moguće je pomoću dugmeta u tabeli ili preko File->New->New Student/Profesor-> New Profesor\n"
						+ "Validacija unosa:/n"
						+ "Indeks koji unosite pri dodavanju studenta na predmet mora biti u formatu XX(X) 00(0)/0000.\n"
						+ "Broj licne karte koju unosite pri dodavanju profesora na predmet mora biti u formatu \"000...00\".\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate predmet\n\n\n"
						+ "TABELA PROFESORA\n"
						+ "1.	Dodavanja profesora na predmet moguće je pomoću dugmeta u tabeli ili preko File-> New-> New Profesor\n"
						+ "2.	Izmena profesora na predmet moguće je pomoću dugmeta u tabeli ili preko Edit->Edit-> Edit Profesor\n"
						+ "3.	Brisanje profesora na predmet moguće je pomoću dugmeta u tabeli ili preko Edit->Delete-> Delete Profesor\n"
						+ "Validacija unosa: Broj lične karte - 9 cifara sa navodnicima na pocetku i kraju\n"
						+ "Datum u formatu – 00.00.0000.\n"
						+ "Sva polja u dialogu moraju biti popunjena da bi mogli da dodate profesora\n\n\n"
						+ "Prečice:\n" + "ctrl + N – New Student\n" + "ctrl + R– New Predmet\n"
						+ "ctrl + P – New Profesor\n" + "ctrl + T – New Student (na predmetu)\n"
						+ "ctrl + F – New Profesor (na predmetu)\n" + "ctrl + E – Edit Student\n"
						+ "ctrl + B – Edit Predmet\n" + "ctrl + A – Edit Profesor\n" + "ctrl + D – Delete Student\n"
						+ "ctrl + M – Delete Predmet\n" + "ctrl + V – Delete Profesor  \n" + "ctrl + H – Help\n"
						+ "ctrl + L - About Luna Živković\n" + "ctrl + T - About Tamara Govorčin\n"
						+ "ctrl + Q - About App\n" + "", 20, 70);

				scrollPane = new JScrollPane(ta);
				JOptionPane.showMessageDialog(null, scrollPane);
			}
		});
		help.add(helpHelp);
		help.addSeparator();

		helpAbout = new JMenu("About");
		aboutstud1 = new JMenuItem("About Luna Zivkovic");
		aboutstud2 = new JMenuItem("About Tamara Govorcin");
		aboutapp = new JMenuItem("About App");

		aboutstud1.setMnemonic(KeyEvent.VK_L);
		aboutstud1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		aboutstud1.setIcon(new ImageIcon("images2/about.png"));
		aboutstud1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Student 1: Luna Živković, rodjena 14.02.1999. u Novom Sadu.\n"
						+ "Student treće godine računarstva i automatike. Broj indeksa: RA 47/2017");
			}
		});
		helpAbout.add(aboutstud1);
		helpAbout.addSeparator();

		aboutstud2.setMnemonic(KeyEvent.VK_T);
		aboutstud2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		aboutstud2.setIcon(new ImageIcon("images2/about.png"));
		aboutstud2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Student 2: Tamara Govorčin, rodjena 17.04.1999. u Novom Sadu.\n"
						+ "Student treće godine računarstva i automatike. Broj indeksa: RA 63/2017");

			}
		});
		helpAbout.add(aboutstud2);
		helpAbout.addSeparator();

		aboutapp.setMnemonic(KeyEvent.VK_Q);
		aboutapp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		aboutapp.setIcon(new ImageIcon("images2/about.png"));
		aboutapp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"Java Aplikaciija Studentska Sluzba verzija 1.0 omogucava rad sa studentima, profesorima i predmetima.\n\n"
								+ "Kratak opis korišćenja aplikacije:\n"
								+ "1.	Tabela student ima mogućnost dodavanja, brisanja, izmene, prikaza predmeta koje slusa student i pretragu studenata.\n"
								+ "2.	Tabela predmet ima mogućnosti dodavanja, brisanja, izmenu, pretragu predmeta, mogućnost dodavanja studenta na predmet, brisanje studenta sa predmeta,\n"
								+ " dodavanje profesora na predmet, brisanje profesora sa predmeta, listu profesora i studenta na predmetu.\n"
								+ "3.	 Tabela profesor ima mogćnost dodavanja, brisanja, izmenu profesora i prikaz predmeta na kojima predaje profesor");

			}
		});
		helpAbout.add(aboutapp);
		helpAbout.addSeparator();

		helpAbout.setIcon(new ImageIcon("images2/about.png"));
		help.add(helpAbout);

		file.setMnemonic(KeyEvent.VK_1);
		edit.setMnemonic(KeyEvent.VK_2);
		help.setMnemonic(KeyEvent.VK_3);

		add(file);
		add(edit);
		add(help);

		novistudent.setEnabled(true);
		novipredmet.setEnabled(false);
		noviprofesor.setEnabled(false);
		noviprofstud.setEnabled(false);

		editstudent.setEnabled(true);
		editprofesor.setEnabled(false);
		editpredmet.setEnabled(false);

		delstudent.setEnabled(true);
		delpredmet.setEnabled(false);
		delprofesor.setEnabled(false);
	}

	public void PromenaDugmica(int a) {
		if (a == 0) {
			novistudent.setEnabled(true);
			novipredmet.setEnabled(false);
			noviprofesor.setEnabled(false);
			noviprofstud.setEnabled(false);

			editstudent.setEnabled(true);
			editprofesor.setEnabled(false);
			editpredmet.setEnabled(false);

			delstudent.setEnabled(true);
			delpredmet.setEnabled(false);
			delprofesor.setEnabled(false);
		}
		if (a == 1) {
			novistudent.setEnabled(false);
			novipredmet.setEnabled(true);
			noviprofesor.setEnabled(false);
			noviprofstud.setEnabled(true);

			editstudent.setEnabled(false);
			editprofesor.setEnabled(false);
			editpredmet.setEnabled(true);

			delstudent.setEnabled(false);
			delpredmet.setEnabled(true);
			delprofesor.setEnabled(false);
		}
		if (a == 2) {
			novistudent.setEnabled(false);
			novipredmet.setEnabled(false);
			noviprofesor.setEnabled(true);
			noviprofstud.setEnabled(false);

			editstudent.setEnabled(false);
			editprofesor.setEnabled(true);
			editpredmet.setEnabled(false);

			delstudent.setEnabled(false);
			delpredmet.setEnabled(false);
			delprofesor.setEnabled(true);
		}
	}

}
