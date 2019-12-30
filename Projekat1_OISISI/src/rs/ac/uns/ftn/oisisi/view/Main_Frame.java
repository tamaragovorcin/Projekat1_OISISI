package rs.ac.uns.ftn.oisisi.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTable;







public class Main_Frame extends JFrame{


	private static final long serialVersionUID = 6925220640504028152L;
	private static Main_Frame instance = null;
	
	public static int screenHight = 0;
	public static int screenWidth = 0;
	private Toolbar toolbar; 
	private TabbedPane tabbedPane;
	private MenuBar menu;
	private StatusBar statusBar;
	
	private Main_Frame() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();//taj sto sam zatvorila je sa casa ako na to mislis aaaaa aj gledam sta je to
		Dimension screenSize = kit.getScreenSize();
		screenHight = screenSize.height;
		screenWidth = screenSize.width;
		setSize(screenWidth*3/4,screenHight*3/4);
		setTitle("Studentska sluzba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        
        
        toolbar = Toolbar.getInstance();
        add(toolbar,BorderLayout.NORTH);
        toolbar.setVisible(true);
        
        
        tabbedPane = new TabbedPane();
        add(tabbedPane,BorderLayout.CENTER);
        tabbedPane.addChangeListener(new TabbedPaneListener());
        tabbedPane.setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		menu = MenuBar.getInstance();
        menu.setVisible(true);
		this.setJMenuBar(menu);

		statusBar= new StatusBar();
		 add(statusBar,BorderLayout.SOUTH);
		statusBar.setVisible(true);
		
        setVisible(true);
        
        
	}
	
	public static Main_Frame getInstance() {
		if(instance==null) {
			instance = new Main_Frame();
		}
		return instance;
	}
	
	private JTable tabelaPredmeta;

	public void azurirajPrikazPredmeta(String a, int i) {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) tabelaPredmeta.getModel();
		if (a != null) {
			if (a.toUpperCase().trim().equals("DODAT")) {
				model.predmetDodat();
			} else if (a.toUpperCase().trim().equals("UKLONJEN")) {
				model.predmetUklonjen(i);
			}
		}
		model.fireTableDataChanged();
		validate();
	}
	
	
	private JTable tabelaStudenta;

	public void azurirajPrikazStudenta(String a, int i) {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaPredmeta.getModel();
		if (a != null) {
			if (a.toUpperCase().trim().equals("DODAT")) {
				model.studentDodat();
			} else if (a.toUpperCase().trim().equals("UKLONJEN")) {
				model.studentUklonjen(i);
			}
		}
		model.fireTableDataChanged();
		validate();
	}

	
	
	
	
	
	
	
	
	
}
