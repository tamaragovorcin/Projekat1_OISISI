package rs.ac.uns.ftn.oisisi.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {

	private static final long serialVersionUID = -3010935269356037536L;
	
	enum Dugme {
		STUDENT,PREDMET,PROFESOR;
		static Dugme getDugme(int i) {
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
	}
	
	private JToggleButton addButton;
	
	private JToggleButton changeButton;
	
	private JToggleButton deleteButton;
	
	private JButton searchButton;
	
	private JTextField searchField;
	
	private JToggleButton dodajStudentButton;
	private JToggleButton dodajPredmetButton;
	private JToggleButton dodajProfesoraButton;
	
	private  static Toolbar instance =null;
	
	public static Toolbar getInstance() {
		if(instance == null) {
			instance = new Toolbar();
		}
		return instance;
	}
	
	
	private Toolbar() {
		super(SwingConstants.HORIZONTAL);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		addButton = new JToggleButton();
		addButton.setToolTipText("Dodavanje nove osobe");
		addButton.setIcon(new ImageIcon("images2/add.png"));
		addButton.setMnemonic(KeyEvent.VK_0);

		
		
		changeButton = new JToggleButton();
		changeButton.setToolTipText("Izmena");
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

		
		add(addButton);
		addSeparator();
		add(changeButton);
		addSeparator();
		add(deleteButton);
	
		add(Box.createHorizontalStrut(Main_Frame.screenWidth/70*32));
		
		add(searchField);
		addSeparator();
		add(searchButton);
		
		setFloatable(false);
		
		}
	
	void promena(Dugme d) {
		removeAll();
		if(d == Dugme.STUDENT) {
			dodajStudentButton = new JToggleButton();
			dodajStudentButton.setToolTipText("Dodavanje novog studenta");
			dodajStudentButton.setIcon(new ImageIcon("images2/student.png"));
			add(dodajStudentButton,FlowLayout.LEFT);
		}
		else if(d == Dugme.PREDMET)  {
			dodajPredmetButton = new JToggleButton();
			dodajPredmetButton.setToolTipText("Dodavanje novog predmeta");
			dodajPredmetButton.setIcon(new ImageIcon("images2/book2.png"));
			add(dodajPredmetButton,FlowLayout.LEFT);
		}
		else if(d==Dugme.PROFESOR) {
			dodajProfesoraButton = new JToggleButton();
			dodajProfesoraButton.setToolTipText("Dodavanje novog profesora");
			dodajProfesoraButton.setIcon(new ImageIcon("images2/teacher.png"));
			add(dodajProfesoraButton,FlowLayout.LEFT);
		}
		
		
		
		
		
		
		
		
	}

}
