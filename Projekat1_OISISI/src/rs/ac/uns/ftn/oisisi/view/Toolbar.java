package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import javax.swing.SwingConstants;

import rs.ac.uns.ftn.oisisi.controller.DodavanjeProfesoraNaPredmet;
import rs.ac.uns.ftn.oisisi.controller.DodavanjeStudentaNaPredmet;
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
	
	private JToggleButton changePredmetButton;
	private JToggleButton changestudentButton;
	private JToggleButton changeprofesorButton;

	private JToggleButton deletestudentButton;
	private JToggleButton deleteProfesorButton;
	private JToggleButton deletePredmetButton;
	
	private JButton searchstudentButton;
	private JButton searchProfesorButton;
	private JButton searchPredmetButton;
	
	private JTextField searchField;
	
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
		levo.setOpaque(false);
		desno = new JPanel();
		desno.setOpaque(false);
		levo.setLayout(new FlowLayout(FlowLayout.LEFT));
		desno.setLayout(new FlowLayout(FlowLayout.RIGHT));
				
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
		
		changePredmetButton = new JToggleButton();
		changePredmetButton.setToolTipText("Izmena predmeta");
		changePredmetButton.setIcon(new ImageIcon("images2/pencil.png"));
		changePredmetButton.setMnemonic(KeyEvent.VK_1);
		
		changestudentButton = new JToggleButton();
		changestudentButton.setIcon(new ImageIcon("images2/pencil.png"));
		changestudentButton.setToolTipText("Izmena studenta");
		changestudentButton.setMnemonic(KeyEvent.VK_1);
		
		changeprofesorButton = new JToggleButton();
		changeprofesorButton.setIcon(new ImageIcon("images2/pencil.png"));
		changeprofesorButton.setToolTipText("Izmena profesora");
		changeprofesorButton.setMnemonic(KeyEvent.VK_1);
		
		deletestudentButton = new JToggleButton();
		deletestudentButton.setIcon(new ImageIcon("images2/delete.png"));
		deletestudentButton.setToolTipText("Brisanje studenta");
		deletestudentButton.setMnemonic(KeyEvent.VK_2);
		
		deleteProfesorButton = new JToggleButton();
		deleteProfesorButton.setIcon(new ImageIcon("images2/delete.png"));
		deleteProfesorButton.setToolTipText("Brisanje profesora");
		deleteProfesorButton.setMnemonic(KeyEvent.VK_2);
		
		deletePredmetButton = new JToggleButton();
		deletePredmetButton.setToolTipText("Brisanje");
		deletePredmetButton.setIcon(new ImageIcon("images2/delete.png"));
		deletePredmetButton.setToolTipText("Brisanje predmeta");
		deletePredmetButton.setMnemonic(KeyEvent.VK_2);
		
		searchPredmetButton = new JButton();
		searchPredmetButton.setToolTipText("Pretrazivanje predmeta");
		searchPredmetButton.setIcon(new ImageIcon("images2/magnifying-glass.png"));
		searchPredmetButton.setMnemonic(KeyEvent.VK_4);
		
		searchstudentButton = new JButton();
		searchstudentButton.setToolTipText("Pretrazivanje studenta");
		searchstudentButton.setIcon(new ImageIcon("images2/magnifying-glass.png"));
		searchstudentButton.setMnemonic(KeyEvent.VK_4);
		
		searchProfesorButton = new JButton();
		searchProfesorButton.setToolTipText("Pretrazivanje profesora");
		searchProfesorButton.setIcon(new ImageIcon("images2/magnifying-glass.png"));
		searchProfesorButton.setMnemonic(KeyEvent.VK_4);
	
		searchField = new JTextField(20);
		searchField.setToolTipText("Upis za pretragu");
	
		dodajStudentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeStudentaDialog dialog = new DodavanjeStudentaDialog(Main_Frame.getInstance(), "Dodavanje novog studenta", true);
				dialog.setVisible(true);
			StudentiJTable.getInstance().refresTabelu();
			dodajStudentButton.setSelected(false);
			
			}
		});
		
		dodajPredmetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog(Main_Frame.getInstance(), "Dodavanje novog predmeta", true);
				dialog.setVisible(true);
				PredmetiJTable.getInstance().refresTabelu();
				dodajPredmetButton.setSelected(false);
			}
		});
		
		dodajProfesoraButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeProfesoraDialog dialog = new DodavanjeProfesoraDialog(Main_Frame.getInstance(), "Dodavanje novog profesora", true);
				dialog.setVisible(true);
				ProfesoriJTable.getInstance().refresTabelu();
				dodajProfesoraButton.setSelected(false);
			}
		});
		
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
				changestudentButton.setSelected(false);
			}
		});
		
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
					deletestudentButton.setSelected(false);
			}
		});
		
		searchstudentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			StudentiController.getInstance().pretraziStudenta();
			StudentiJTable.getInstance().refresTabelu();
			searchstudentButton.setSelected(false);
			}
		});
		
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
				changeprofesorButton.setSelected(false);
			}
		});
		
		deleteProfesorButton.addActionListener(new ActionListener() {
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
					deleteProfesorButton.setSelected(false);
			}
		});
		
		searchProfesorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfesoriController.getInstance().pretraziProfesora();
				ProfesoriJTable.getInstance().refresTabelu();
				searchProfesorButton.setSelected(false);
			}
		});
		
		deletePredmetButton.addActionListener(new ActionListener() {
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
					deletePredmetButton.setSelected(false);
			}
		});
		
		changePredmetButton.addActionListener(new ActionListener() {
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
				changePredmetButton.setSelected(false);
			}
		});
		
		searchPredmetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetiController.getInstance().pretraziPredmet();
				PredmetiJTable.getInstance().refresTabelu();
				searchPredmetButton.setSelected(false);
			}
		});
		
		dodajProfesoraNaPredmet.addActionListener(new DodavanjeProfesoraNaPredmet());
		
		dodajStudentaNaPredmet.addActionListener(new DodavanjeStudentaNaPredmet());
		
		promena(Dugme.STUDENT);
		
		setFloatable(false);
	
	}
	
	public void promena(Dugme d) {
		removeAll();
		levo.removeAll();
		desno.removeAll();
		
		searchField.setText("");
		if(d == Dugme.STUDENT) {
			levo.add(dodajStudentButton,FlowLayout.LEFT);
		}
		else if(d == Dugme.PREDMET)  {
			levo.add(dodajPredmetButton,FlowLayout.LEFT);
		}
		else if(d==Dugme.PROFESOR) {
			levo.add(dodajProfesoraButton,FlowLayout.LEFT);
		}
	
		addSeparator();

		if(d == Dugme.STUDENT) {
			
			levo.add(changestudentButton);
			addSeparator();
			levo.add(deletestudentButton);
		
			desno.add(searchField);
			addSeparator();
			desno.add(searchstudentButton);
			
			add(levo,BorderLayout.WEST);
			add(desno, BorderLayout.EAST);
			}
		else if(d == Dugme.PREDMET)  {
		
			levo.add(changePredmetButton);
			addSeparator();
			levo.add(deletePredmetButton);
			addSeparator();
			levo.add(dodajStudentaNaPredmet);
			addSeparator();
			levo.add(dodajProfesoraNaPredmet);
			
			desno.add(searchField);
			addSeparator();
			desno.add(searchPredmetButton);
			
			add(levo,BorderLayout.WEST);
			add(desno, BorderLayout.EAST);
		}
		else if(d==Dugme.PROFESOR) { 
			
			levo.add(changeprofesorButton);
			addSeparator();
			levo.add(deleteProfesorButton);
			
			desno.add(searchField);
			addSeparator();
			desno.add(searchProfesorButton);
			
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
	
	public JTextField getSearchField() {
		return searchField;
	}

	public void setSearchField(JTextField searchField) {
		this.searchField = searchField;
	}

	public void A() {
		dodajStudentaNaPredmet.setSelected(false);
		dodajProfesoraNaPredmet.setSelected(false);
	}
	
}
