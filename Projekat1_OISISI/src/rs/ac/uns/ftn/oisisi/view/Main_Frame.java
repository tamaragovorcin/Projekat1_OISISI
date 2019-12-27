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
	
	private Main_Frame() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
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
        tabbedPane.setVisible(true);
        
        //ovo je poslednje obavezno!!!!!
        setVisible(true);
        
        
	}
	
	public static Main_Frame getInstance() {
		if(instance==null) {
			instance = new Main_Frame();
		}
		return instance;
	}

	public void azurirajPrikaz(Object object, int i) {
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
}
