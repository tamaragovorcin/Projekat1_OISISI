package rs.ac.uns.ftn.oisisi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;
import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -7863806568418316202L;
	
	private static MenuBar instance=null; 
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
	
	public static MenuBar getInstance() {
		if(instance==null) {		
			instance=new MenuBar();	
		}
		return instance;	
	}
	private MenuBar() {
	
		file = new JMenu("File");
		miClose = new JMenuItem("Close");
		miNew=new JMenu("New");
		novistudent =new JMenuItem("New Student");
		noviprofesor=new JMenuItem("New Profesor");
		novipredmet= new JMenuItem("New Predmet");
		noviprofstud=new JMenu("New Student/Profesor");
		novipredstud=new JMenuItem("New Student");
		novipredprof=new JMenuItem("New Profesor");
			
		novistudent.setMnemonic(KeyEvent.VK_N);
		novistudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		novistudent.setIcon(new ImageIcon("images2/buttonplus.png"));
		novistudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeStudentaDialog dialog = new DodavanjeStudentaDialog(Main_Frame.getInstance(), "Dodavanje novog studenta", true);
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
				DodavanjeProfesoraDialog dialog = new DodavanjeProfesoraDialog(Main_Frame.getInstance(), "Dodavanje novog profesora", true);
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
				DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog(Main_Frame.getInstance(), "Dodavanje novog predmeta", true);
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
				DodavanjeStudentaNaPredmetDialog dialog = new DodavanjeStudentaNaPredmetDialog(Main_Frame.getInstance(), "Dodavanje studenta na predmet", true);
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
				DialogDodajProfesoraNaPredmet dialog = new DialogDodajProfesoraNaPredmet(Main_Frame.getInstance(), "Dodavanje profesora na predmet", true);
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
		miClose.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int odabir = JOptionPane.showConfirmDialog(Main_Frame.getInstance(), "Da li ste sigurni da zelite da zatvorite aplikaciju?","Zatvaranje aplikacije",JOptionPane.YES_NO_OPTION);
				
				if(odabir==JOptionPane.YES_OPTION) {
					try {
						PredmetiController.getInstance().sacuvajPredmeteTXT();
						StudentiController.getInstance().sacuvajStudenteTXT();
						ProfesoriController.getInstance().sacuvajProfesoreTXT();
						System.exit(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	
		file.add(miClose);
		
		edit = new JMenu("Edit");
		editEdit = new JMenu("Edit");
		editDelete = new JMenu("Delete");
		editstudent =new JMenuItem("Edit Student");
		editprofesor=new JMenuItem("Edit Profesor");
		editpredmet= new JMenuItem("Edit Predmet");
		
		editstudent.setMnemonic(KeyEvent.VK_E);
		editstudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editstudent.setIcon(new ImageIcon("images2/edit.png"));
		editstudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = StudentiTablePanel.getSelektovan_red();
				if(row>=0 && row<BazaStudenta.getInstance().getBroj_studenata()) {
					StudentiController.getInstance().izmeniStudenta(row);
				}
				else {
					JOptionPane.showMessageDialog(null, "Student nije selektovan.");
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
				if(row>=0 && row<BazaProfesora.getInstance().getBroj_profesora()) {
					ProfesoriController.getInstance().izmeniProfesora(row);
				}
				else {
					JOptionPane.showMessageDialog(null, "Profesor nije selektovan.");
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
				if(row>=0 && row<BazaPredmeta.getInstance().getBroj_predmeta() ) {
					PredmetiController.getInstance().izmeniPredmet(row);
				}
				else {
					JOptionPane.showMessageDialog(null, "Predmet nije selektovan.");
				}
				PredmetiJTable.getInstance().refresTabelu();  
				editpredmet.setSelected(false);
			}
		});
		editEdit.add(editpredmet);

		editEdit.setIcon(new ImageIcon("images2/edit.png"));	
		edit.add(editEdit);
		edit.addSeparator();

		delstudent =new JMenuItem("Delete Student");
		delprofesor=new JMenuItem("Delete Profesor");
		delpredmet= new JMenuItem("Delete Predmet");
			
		delstudent.setMnemonic(KeyEvent.VK_D);
		delstudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		delstudent.setIcon(new ImageIcon("images2/garbage.png"));
		
		delstudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = StudentiTablePanel.getSelektovan_red();
				if(row>=0 && row<BazaStudenta.getInstance().getBroj_studenata() ) {
					int izbor = JOptionPane.showConfirmDialog(null,
							"Da li ste sigurni da zelite da obrisete stduenta?","Brisanje studenta",JOptionPane.YES_NO_OPTION);
					if (izbor == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Student je obrisan!");
						StudentiController.getInstance().izbrisiStudeta(row);
					}
					else {
						JOptionPane.showMessageDialog(null, "Student nije obrisan.");
					}
				}else {
						JOptionPane.showMessageDialog(null, "Student nije selektovan.");
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
				if(row>=0 && row<BazaProfesora.getInstance().getBroj_profesora() ) {
					int izbor = JOptionPane.showConfirmDialog(null,
							"Da li ste sigurni da zelite da obrisete profesora?","Brisanje predmeta",JOptionPane.YES_NO_OPTION);
					if (izbor == JOptionPane.YES_OPTION) {
						ProfesoriController.getInstance().izbrisiProfesora(row);
						JOptionPane.showMessageDialog(null, "Profesor je obrisan!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Profesor nije obrisan.");
					}
				}else {
						JOptionPane.showMessageDialog(null, "Profesor nije selektovan.");
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
				if(row>=0 && row<BazaPredmeta.getInstance().getBroj_predmeta() ) {
					int izbor = JOptionPane.showConfirmDialog(null,
							"Da li ste sigurni da zelite da obrisete predmet?","Brisanje predmeta",JOptionPane.YES_NO_OPTION);
					if (izbor == JOptionPane.YES_OPTION) {
						PredmetiController.getInstance().izbrisiPredmet(row);
						JOptionPane.showMessageDialog(null, "Predmet je obrisan!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Predmet nije obrisan.");
					}
				}else {
						JOptionPane.showMessageDialog(null, "Predmet nije selektovan.");
					}
					PredmetiJTable.getInstance().refresTabelu();
					delpredmet.setSelected(false);
			}
		});
		editDelete.add(delpredmet);
	
		editDelete.setIcon(new ImageIcon("images2/garbage.png"));
		edit.add(editDelete);
	
		
	    help = new JMenu("Help");
		helpHelp=new JMenuItem("Help");
		helpHelp.setMnemonic(KeyEvent.VK_H);
		helpHelp.setIcon(new ImageIcon("images2/information.png"));
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		helpHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Pomoc");
			}
		});
		help.add(helpHelp);
		help.addSeparator();
		
		helpAbout=new JMenu("About");
		aboutstud1 =new JMenuItem("About Luna Zivkovic");
		aboutstud2=new JMenuItem("About Tamara Govorcin");
		aboutapp= new JMenuItem("About App");
		
		aboutstud1.setMnemonic(KeyEvent.VK_L);
		aboutstud1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		aboutstud1.setIcon(new ImageIcon("images2/about.png"));
		aboutstud1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Nesto o Luni Zivkovic RA47/2017");
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
				
					JOptionPane.showMessageDialog(null, "Nesto o Tamari Govorcin");
				
			}
		});
		helpAbout.add(aboutstud2);
		helpAbout.addSeparator();
		
		aboutapp.setMnemonic(KeyEvent.VK_Q);
		aboutapp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		aboutapp.setIcon(new ImageIcon("images2/about.png"));
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
	}
}


