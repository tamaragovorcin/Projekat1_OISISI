package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import javax.swing.SwingConstants;

import rs.ac.uns.ftn.oisisi.controller.DodavanjeProfesoraNaPredmet;
import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;
import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;





public class Toolbar extends JToolBar {

	private static final long serialVersionUID = -3010935269356037536L;
	
	enum Dugme {
		STUDENT,PREDMET,PROFESOR;
	
		
		
	};
	
	private JToggleButton addButton;
	
	private JToggleButton changeButton;
	private JToggleButton changestudentButton;
	private JToggleButton changeprofesorButton;
	private JToggleButton deleteButton;
	private JToggleButton deletestudentButton;
	
	private JButton searchButton;
	private JButton searchstudentButton;
	private JButton searchProfesorButton;
	private JTextField searchField;
	private JTextField searchstudentField;
	private JTextField searchProfesorField;
	
	private JToggleButton dodajStudentButton;
	private JToggleButton dodajPredmetButton;
	private JToggleButton dodajProfesoraButton;
	
	private JToggleButton dodajStudentaNaPredmet;
	private JToggleButton dodajProfesoraNaPredmet;

	private JTextField polje;
	
	private JPanel levo;
	private JPanel desno;

	private  static Toolbar instance =null;
	
	public static Toolbar getInstance() {
		if(instance == null) {
			instance = new Toolbar(Dugme.STUDENT);
		}
		return instance;
	}
	
	
	private Toolbar(Dugme d) {
		super(SwingConstants.HORIZONTAL);
		setLayout(new BorderLayout());
		levo = new JPanel();
		desno = new JPanel();
		levo.setLayout(new FlowLayout(FlowLayout.LEFT));
		desno.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		addButton = new JToggleButton();
		addButton.setToolTipText("Dodavanje nove osobe");
		addButton.setIcon(new ImageIcon("images2/add.png"));
		addButton.setMnemonic(KeyEvent.VK_0);
		

		dodajStudentButton = new JToggleButton();
		dodajStudentButton.setToolTipText("Dodaj novog studenta");
		dodajStudentButton.setIcon(new ImageIcon("images2/student.png"));
		
		dodajPredmetButton = new JToggleButton();
		dodajPredmetButton.setToolTipText("Dodavanje novog predmeta");
		dodajPredmetButton.setIcon(new ImageIcon("images2/book2.png"));
		
		dodajProfesoraButton = new JToggleButton();
		dodajProfesoraButton.setToolTipText("Dodavanje novog profesora");
		dodajProfesoraButton.setIcon(new ImageIcon("images2/teacher.png"));
		
		dodajStudentaNaPredmet = new JToggleButton();
		dodajStudentaNaPredmet.setToolTipText("Dodavanje studenta na predmet");
		dodajStudentaNaPredmet.setIcon(new ImageIcon("images2/student.png"));
		
		dodajProfesoraNaPredmet = new JToggleButton();
		dodajProfesoraNaPredmet.setToolTipText("Dodavanje profesora na predmet");
		dodajProfesoraNaPredmet.setIcon(new ImageIcon("images2/teacher.png"));
		
		changeButton = new JToggleButton();
		changeButton.setToolTipText("Izmena predmeta");
		changeButton.setIcon(new ImageIcon("images2/pencil.png"));
		changeButton.setMnemonic(KeyEvent.VK_1);
		
		
		changestudentButton = new JToggleButton();
		changestudentButton.setToolTipText("Izmena studenta");
		changestudentButton.setIcon(new ImageIcon("images2/pencil.png"));
		changestudentButton.setMnemonic(KeyEvent.VK_1);
		
		
		changeprofesorButton = new JToggleButton();
		changeprofesorButton.setToolTipText("Izmena studenta");
		changeprofesorButton.setIcon(new ImageIcon("images2/pencil.png"));
		changeprofesorButton.setMnemonic(KeyEvent.VK_1);
		
		
		deleteButton = new JToggleButton();
		deleteButton.setToolTipText("Brisanje");
		deleteButton.setIcon(new ImageIcon("images2/delete.png"));
		deleteButton.setMnemonic(KeyEvent.VK_2);
	
		deletestudentButton = new JToggleButton();
		deletestudentButton.setToolTipText("Brisanje");
		deletestudentButton.setIcon(new ImageIcon("images2/delete.png"));
		deletestudentButton.setMnemonic(KeyEvent.VK_2);
		
		searchButton = new JButton();
		searchButton.setToolTipText("Pretrazivanje");
		searchButton.setIcon(new ImageIcon("images2/magnifying-glass.png"));
		searchButton.setMnemonic(KeyEvent.VK_4);
	
	
		searchField = new JTextField(20);
		searchField.setToolTipText("Upis za pretragu");

		
		promena(Dugme.STUDENT);
		
		setFloatable(false);
	
		
		}
	
	public void promena(Dugme d) {
		removeAll();
		levo.removeAll();
		desno.removeAll();
		
		if(d == Dugme.STUDENT) {
			dodajStudentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DodavanjeStudentaDialog dialog = new DodavanjeStudentaDialog(Main_Frame.getInstance(), "Dodavanje novog studenta", true);
					dialog.setVisible(true);
				StudentiJTable.getInstance().refresTabelu();
				dodajStudentButton.setSelected(false);
				
				}
			});
			levo.add(dodajStudentButton,FlowLayout.LEFT);
			
			
			
			
		}
		else if(d == Dugme.PREDMET)  {

			dodajPredmetButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog(Main_Frame.getInstance(), "Dodavanje novog predmeta", true);
					dialog.setVisible(true);
					PredmetiJTable.getInstance().refresTabelu();

				}
			});
			levo.add(dodajPredmetButton,FlowLayout.LEFT);
		}
		else if(d==Dugme.PROFESOR) {
			dodajProfesoraButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DodavanjeProfesoraDialog dialog = new DodavanjeProfesoraDialog(Main_Frame.getInstance(), "Dodavanje novog profesora", true);
					dialog.setVisible(true);

				ProfesoriJTable.getInstance().refresTabelu();
				}
			});
			levo.add(dodajProfesoraButton,FlowLayout.LEFT);
		}
		addSeparator();
		
		
		
		
		
		
		
		
		if(d == Dugme.STUDENT) {
			changestudentButton.setToolTipText("Izmena studenta");
			changestudentButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = StudentiJTable.getInstance().getSelectedRow();
					if(row>=0 && row<BazaStudenta.getInstance().getBroj_studenata()) {
						StudentiController.getInstance().izmeniStudenta(row);
					}
					else {
						JOptionPane.showMessageDialog(null, "Student nije selektovan.");
					}
					StudentiJTable.getInstance().refresTabelu();  
				}
			});
			
			
			deletestudentButton.setToolTipText("Brisanje studenta");
			deletestudentButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
			
					int row = StudentiJTable.getInstance().getSelectedRow();
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
					
				}
			});
			
			searchButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				StudentiController.getInstance().pretraziStudenta();
				StudentiJTable.getInstance().refresTabelu();
				}
			});
			
		
			
			
			levo.add(changestudentButton);
			addSeparator();
			levo.add(deletestudentButton);
			addSeparator();
			//add(dodajStudentaNaPredmet);
			//add(dodajProfesoraNaPredmet);
			
			desno.add(searchField);
			addSeparator();
			desno.add(searchButton);
			
			add(levo,BorderLayout.WEST);
			add(desno, BorderLayout.EAST);
				
			}
		else if(d == Dugme.PREDMET)  {
			changeButton.setToolTipText("Izmena predmeta");
			changeButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = PredmetiJTable.getInstance().getSelectedRow();
					if(row>=0 && row<BazaPredmeta.getInstance().getBroj_predmeta() ) {
						PredmetiController.getInstance().izmeniPredmet(row);
					}
					else {
						JOptionPane.showMessageDialog(null, "Predmet nije selektovan.");
					}
					PredmetiJTable.getInstance().refresTabelu();  
				}
			});
			
			
			deleteButton.setToolTipText("Brisanje predmeta");
			deleteButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
			
					int row = PredmetiJTable.getInstance().getSelectedRow();
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
				}
			});
			
			
			searchButton.addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					PredmetiController.getInstance().pretraziPredmet();
					PredmetiJTable.getInstance().refresTabelu();
				}
			});
			
			dodajProfesoraNaPredmet.addActionListener(new DodavanjeProfesoraNaPredmet());
			
			levo.add(changeButton);
			addSeparator();
			levo.add(deleteButton);
			addSeparator();
			levo.add(dodajStudentaNaPredmet);
			levo.add(dodajProfesoraNaPredmet);
			
			desno.add(searchField);
			addSeparator();
			desno.add(searchButton);
			
			add(levo,BorderLayout.WEST);
			add(desno, BorderLayout.EAST);
		}
		else if(d==Dugme.PROFESOR) {
			changeprofesorButton.setToolTipText("Izmena profesora");
			changeprofesorButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int row =ProfesoriJTable.getInstance().getSelectedRow();
					if(row>=0 && row<BazaProfesora.getInstance().getBroj_profesora()) {
						ProfesoriController.getInstance().izmeniProfesora(row);
					}
					else {
						JOptionPane.showMessageDialog(null, "Profesor nije selektovan.");
					}
					ProfesoriJTable.getInstance().refresTabelu();  
				}
			});
			deleteButton.setToolTipText("Brisanje profesora");
			deleteButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
			
					int row = ProfesoriJTable.getInstance().getSelectedRow();
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
					
				}
			});
			
			searchButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ProfesoriController.getInstance().pretraziProfesora();
					ProfesoriJTable.getInstance().refresTabelu();
				}
			});
			
			levo.add(changeprofesorButton);
			addSeparator();
			levo.add(deleteButton);
		
			desno.add(searchField);
			addSeparator();
			desno.add(searchButton);
			
			
			
			add(levo,BorderLayout.WEST);
			add(desno, BorderLayout.EAST);
		}
	}
		
		public Dugme getDugme(int i) {
			Dugme d = null;
			if(i==0) {
				d = Dugme.STUDENT;
			}
			else if(i==1) {
				d = Dugme.PREDMET;
			}
			else if(i==2) {
				d=Dugme.PROFESOR;
			}
			return d;
		}


	public JTextField getPolje() {
		return polje;
	}


	public void setPolje(JTextField polje) {
		this.polje = polje;
	}
	
	public JTextField getTekst() {
		return searchField;
	}

	
	
	
	
}
