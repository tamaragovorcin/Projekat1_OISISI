package rs.ac.uns.ftn.oisisi.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;


import rs.ac.uns.ftn.oisisi.controller.PredmetiController;





public class Toolbar extends JToolBar {

	private static final long serialVersionUID = -3010935269356037536L;
	
	enum Dugme {
		STUDENT,PREDMET,PROFESOR;
	
		
		
	};
	
	private JToggleButton addButton;
	
	private JToggleButton changeButton;
	
	private JToggleButton deleteButton;
	
	private JButton searchButton;
	
	private JTextField searchField;
	
	private JToggleButton dodajStudentButton;
	private JToggleButton dodajPredmetButton;
	private JToggleButton dodajProfesoraButton;
	
	private JToggleButton dodajStudentaNaPredmet;
	private JToggleButton dodajProfesoraNaPredmet;

	private JTextField polje;
	
	private  static Toolbar instance =null;
	
	public static Toolbar getInstance() {
		if(instance == null) {
			instance = new Toolbar(Dugme.STUDENT);
		}
		return instance;
	}
	
	
	private Toolbar(Dugme d) {
		super(SwingConstants.HORIZONTAL);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
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
		changeButton.setToolTipText("Izmena studenta");
		changeButton.setIcon(new ImageIcon("images2/pencil.png"));
		changeButton.setMnemonic(KeyEvent.VK_1);
	
		
		deleteButton = new JToggleButton();
		deleteButton.setToolTipText("Brisanje");
		deleteButton.setIcon(new ImageIcon("images2/delete.png"));
		deleteButton.setMnemonic(KeyEvent.VK_2);
	
		
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
		if(d == Dugme.STUDENT) {
	

			add(dodajStudentButton,FlowLayout.LEFT);
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
			add(dodajPredmetButton,FlowLayout.LEFT);
		}
		else if(d==Dugme.PROFESOR) {
		
			add(dodajProfesoraButton,FlowLayout.LEFT);
		}
		addSeparator();
		
		if(d == Dugme.STUDENT) {
			changeButton.setToolTipText("Izmena studenta");
			deleteButton.setToolTipText("Brisanje studenta");
			deleteButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				//	PredmetiController.getInstance().izbrisiPredmet((PredmetiJTable.getInstance().getSelectedRow()));
					int row = PredmetiJTable.getInstance().getSelectedRow();
					
					int izbor = JOptionPane.showConfirmDialog(null,
							"Da li ste sigurni da zelite da obrisete predmet?","Brisanje predmeta",JOptionPane.YES_NO_OPTION);
					if (izbor == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Predmet je obrisan!");
						PredmetiController.getInstance().izbrisiPredmet(row);
					} else {
						JOptionPane.showMessageDialog(null, "Predmet nije obrisan.");
					}
					
					PredmetiJTable.getInstance().refresTabelu();
				}
			});
			
			add(changeButton);
			addSeparator();
			add(deleteButton);
			
			add(Box.createHorizontalStrut(Main_Frame.screenWidth/70*32));
			add(searchField);
			addSeparator();
			add(searchButton);
				
			}
		else if(d == Dugme.PREDMET)  {
			changeButton.setToolTipText("Izmena predmeta");
			deleteButton.setToolTipText("Brisanje predmeta");
			
			add(changeButton);
			addSeparator();
			add(deleteButton);
			addSeparator();
			add(dodajStudentaNaPredmet);
			add(dodajProfesoraNaPredmet);
			add(Box.createHorizontalStrut(Main_Frame.screenWidth/70*28));
			add(searchField);
			addSeparator();
			add(searchButton);
		}
		else if(d==Dugme.PROFESOR) {
			changeButton.setToolTipText("Izmena profesora");
			deleteButton.setToolTipText("Brisanje profesora");
			
			add(changeButton);
			addSeparator();
			add(deleteButton);
			add(Box.createHorizontalStrut(Main_Frame.screenWidth/70*32));
			add(searchField);
			addSeparator();
			add(searchButton);
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


}
