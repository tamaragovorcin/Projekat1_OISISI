package rs.ac.uns.ftn.oisisi.view;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuBar extends JMenuBar{

	
	private static final long serialVersionUID = -7863806568418316202L;

	public MenuBar() {

		JMenu file = new JMenu("File");
		Icon icon = new ImageIcon("images/blue-plus-icon-icons-and-png-backgrounds-22.png");
		JMenuItem miNew=new JMenuItem("New", icon);
		
		
		JMenuItem miClose = new JMenuItem("Close");
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		file.addSeparator();

		JMenu edit = new JMenu("Edit");
		JMenuItem editEdit = new JMenuItem("Edit");
		JMenuItem editDelete = new JMenuItem("Delete");
		edit.add(editEdit);
		edit.addSeparator();
		edit.add(editDelete);
		edit.addSeparator();
		
		JMenu help = new JMenu("Help");
		JMenuItem helpHelp=new JMenuItem("Help");
		JMenuItem helpAbout=new JMenuItem("About");
		help.add(helpHelp);
		help.addSeparator();
		help.add(helpAbout);
		help.addSeparator();
		

		add(file);
		add(edit);
		add(help);

	}
}

