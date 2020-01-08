package rs.ac.uns.ftn.oisisi.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;
import rs.ac.uns.ftn.oisisi.controller.TabbedPaneListener;

public class Main_Frame extends JFrame{

	private static final long serialVersionUID = 6925220640504028152L;
	
	private static Main_Frame instance = null;
	
	public static int screenHight = 0;
	public static int screenWidth = 0;
	private Toolbar toolbar; 
	private TabbedPane tabbedPane;
	private MenuBar menu;
	private StatusBar statusBar;
	
	public static Main_Frame getInstance() {
		if(instance==null) {
			instance = new Main_Frame();
		}
		return instance;
	}
	
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
    	setResizable(true);
        
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
		
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				JFrame frame = (JFrame) e.getComponent();
				int izbor = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da zatvorite aplikaciju?","Pitanje",JOptionPane.YES_NO_OPTION);
				if(izbor ==JOptionPane.YES_OPTION) {
					
					try {
						PredmetiController.getInstance().sacuvajPredmeteTXT();
						StudentiController.getInstance().sacuvajStudenteTXT();
						ProfesoriController.getInstance().sacuvajProfesoreTXT();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				}
				else {
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
        setVisible(true);
	}
}
