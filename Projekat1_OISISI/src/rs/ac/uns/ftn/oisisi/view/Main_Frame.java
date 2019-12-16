package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main_Frame extends JFrame{


	private static final long serialVersionUID = 6925220640504028152L;
	private static Main_Frame instance = null;
	
	
	private Main_Frame() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth*3/4,screenHight*3/4);
		setTitle("Studentska sluzba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        
        setVisible(true);
	}
	
	public static Main_Frame getInstance() {
		if(instance==null) {
			instance = new Main_Frame();
		}
		return instance;
	}
	
	
	
	
	
	
	
	
	
}
