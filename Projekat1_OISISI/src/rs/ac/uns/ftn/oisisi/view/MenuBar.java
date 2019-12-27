package rs.ac.uns.ftn.oisisi.view;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class MenuBar extends JMenuBar {

	
	private static final long serialVersionUID = -7863806568418316202L;
	
private static MenuBar instance=null; //singleton 
private JMenu file;
private JMenu edit;
private JMenu help;
private JMenuItem miClose;
private JMenuItem miNew;
private JMenuItem editEdit;
private JMenuItem editDelete;
private JMenuItem helpHelp;
private JMenuItem helpAbout;


public static MenuBar getInstance() {
	
		if(instance==null) {
			
			instance=new MenuBar();
			
		}
		return instance;
		
}
	private MenuBar() {

file = new JMenu("File");
		miClose = new JMenuItem("Close");
		miNew=new JMenuItem("New");
		
		
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.setIcon(new ImageIcon("images2/buttonplus.png"));
		file.add(miNew);
		file.addSeparator();
		
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.setIcon(new ImageIcon("images2/close.png"));
		file.add(miClose);
		file.addSeparator();

edit = new JMenu("Edit");
		editEdit = new JMenuItem("Edit");
		editDelete = new JMenuItem("Delete");
		editEdit.setMnemonic(KeyEvent.VK_E);
		editEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editEdit.setIcon(new ImageIcon("images2/edit.png"));
			
		edit.add(editEdit);
		edit.addSeparator();
		
		editDelete.setMnemonic(KeyEvent.VK_D);
		editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		editDelete.setIcon(new ImageIcon("images2/garbage.png"));
		
		edit.add(editDelete);
		edit.addSeparator();
		
	    help = new JMenu("Help");
		helpHelp=new JMenuItem("Help");
		helpAbout=new JMenuItem("About");
		helpHelp.setMnemonic(KeyEvent.VK_H);
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		helpHelp.setIcon(new ImageIcon("images2/information.png"));
		help.add(helpHelp);
		help.addSeparator();
		
		helpAbout.setMnemonic(KeyEvent.VK_A);
		helpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		helpAbout.setIcon(new ImageIcon("images2/about.png"));
		help.add(helpAbout);
		help.addSeparator();
		

		file.setMnemonic(KeyEvent.VK_1);
		edit.setMnemonic(KeyEvent.VK_2);
		help.setMnemonic(KeyEvent.VK_3);
		
		add(file);
		add(edit);
		add(help);

	}
}


