package rs.ac.uns.ftn.oisisi.view;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {

	private static final long serialVersionUID = -3010935269356037536L;
	
	private JToggleButton addButton;
	
	private JToggleButton changeButton;
	
	private JToggleButton deleteButton;
	
	private JButton searchButton;
	
	private JTextField searchField;
	
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
		
		changeButton = new JToggleButton();
		changeButton.setToolTipText("Izmena");
		changeButton.setIcon(new ImageIcon("images2/pencil.png"));
	
		deleteButton = new JToggleButton();
		deleteButton.setToolTipText("Brisanje");
		deleteButton.setIcon(new ImageIcon("images2/delete.png"));
		
		searchButton = new JButton();
		searchButton.setToolTipText("Pretrazivanje");
		searchButton.setIcon(new ImageIcon("images2/magnifying-glass.png"));
		
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
		
		}
	


}
