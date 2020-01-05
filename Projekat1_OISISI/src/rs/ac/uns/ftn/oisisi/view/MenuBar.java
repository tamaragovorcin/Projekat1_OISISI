package rs.ac.uns.ftn.oisisi.view;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;


public class MenuBar extends JMenuBar {

	
	private static final long serialVersionUID = -7863806568418316202L;
	
private static MenuBar instance=null; //singleton 
private JMenu file;
private JMenu edit;
private JMenu help;
private JMenuItem miClose;
private JMenu miNew;
private JMenu editEdit;
private JMenu editDelete;
private JMenuItem helpHelp;
private JMenu helpAbout;
private JMenuItem novistudent;
private JMenuItem noviprofesor;
private JMenuItem novipredmet;
private JMenu noviprofstud;
private JMenuItem novipredstud;
private JMenuItem novipredprof;

private JMenuItem editstudent;
private JMenuItem editprofesor;
private JMenuItem editpredmet;
private JMenu editprofstud;
private JMenuItem editpredstud;
private JMenuItem editpredprof;

private JMenuItem delstudent;
private JMenuItem delprofesor;
private JMenuItem delpredmet;
private JMenu delprofstud;
private JMenuItem delpredstud;
private JMenuItem delpredprof;

private JMenuItem aboutstud1;
private JMenuItem aboutstud2;
private JMenuItem aboutapp;

public static MenuBar getInstance() {
	
		if(instance==null) {
			
			instance=new MenuBar();
			
		}
		return instance;
		
}
	private MenuBar() {

file = new JMenu("File");
		miClose = new JMenuItem("Close");
		miNew=new JMenu("New");
		novistudent =new JMenuItem("New Student");
		noviprofesor=new JMenuItem("New Profesor");
		novipredmet= new JMenuItem("New Predmet");
		noviprofstud=new JMenu("New Student/Profesor");
		novipredstud=new JMenuItem("New Student");
		novipredprof=new JMenuItem("New Profesor");
		
		
		
					novistudent.setMnemonic(KeyEvent.VK_N);
					novistudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
					novistudent.setIcon(new ImageIcon("images2/plus.png"));
					novistudent.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							DodavanjeStudentaDialog dialog = new DodavanjeStudentaDialog(Main_Frame.getInstance(), "Dodavanje novog studenta", true);
							dialog.setVisible(true);
						StudentiJTable.getInstance().refresTabelu();

						}
					});

					miNew.add(novistudent);
					miNew.addSeparator();
					
					noviprofesor.setMnemonic(KeyEvent.VK_N);
					noviprofesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
					noviprofesor.setIcon(new ImageIcon("images2/plus.png"));
					
					noviprofesor.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							DodavanjeProfesoraDialog dialog = new DodavanjeProfesoraDialog(Main_Frame.getInstance(), "Dodavanje novog profesora", true);
							dialog.setVisible(true);
						ProfesoriJTable.getInstance().refresTabelu();

						}
					});
					miNew.add(noviprofesor);
					miNew.addSeparator();
					
					novipredmet.setMnemonic(KeyEvent.VK_N);
					novipredmet.setIcon(new ImageIcon("images2/plus.png"));
					novipredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
					novipredmet.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog(Main_Frame.getInstance(), "Dodavanje novog predmeta", true);
							dialog.setVisible(true);
						PredmetiJTable.getInstance().refresTabelu();

						}
					});
					miNew.add(novipredmet);
					
					
					novipredstud.setMnemonic(KeyEvent.VK_N);
					novipredstud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
					novipredstud.setIcon(new ImageIcon("images2/plus.png"));
					noviprofstud.add(novipredstud);
					noviprofstud.addSeparator();
					
					novipredprof.setMnemonic(KeyEvent.VK_N);
					novipredprof.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
					novipredprof.setIcon(new ImageIcon("images2/plus.png"));
					noviprofstud.add(novipredprof);
					
					
					
					noviprofstud.setIcon(new ImageIcon("images2/plus.png"));
					miNew.add(noviprofstud);
					miNew.addSeparator();
					

	    miNew.setIcon(new ImageIcon("images2/plus.png"));
	    file.add(miNew);
	    file.addSeparator();
		
	    
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.setIcon(new ImageIcon("images2/minus.png"));
		miClose.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int odabir = JOptionPane.showConfirmDialog(Main_Frame.getInstance(), "Da li ste sigurni da zelite da zatvorite aplikaciju?","Zatvaranje aplikacije",JOptionPane.YES_NO_OPTION);
				
				if(odabir==JOptionPane.YES_OPTION) {
					try {
						PredmetiController.getInstance().sacuvajPredmeteTXT();
						StudentiController.getInstance().sacuvajStudenteTXT();
						ProfesoriController.getInstance().sacuvajProfesoreTXT();
						System.exit(0);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
	
		file.add(miClose);
		
		

edit = new JMenu("Edit");
		editEdit = new JMenu("Edit");
		editDelete = new JMenu("Delete");
		editstudent =new JMenuItem("Edit Student");
		editprofesor=new JMenuItem("Edit Profesor");
		editpredmet= new JMenuItem("Edit Predmet");
		editprofstud=new JMenu("Edit Student/Profesor");
		editpredstud=new JMenuItem("Edit Student");
		editpredprof=new JMenuItem("Edit Profesor");
		
		editstudent.setMnemonic(KeyEvent.VK_E);
		editstudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editstudent.setIcon(new ImageIcon("images2/close.png"));
		editEdit.add(editstudent);
		editEdit.addSeparator();
		
		editprofesor.setMnemonic(KeyEvent.VK_E);
		editprofesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editprofesor.setIcon(new ImageIcon("images2/close.png"));
		editEdit.add(editprofesor);
		editEdit.addSeparator();
		
		editpredmet.setMnemonic(KeyEvent.VK_E);
		editpredmet.setIcon(new ImageIcon("images2/close.png"));
		editpredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editEdit.add(editpredmet);
		
		
		editpredstud.setMnemonic(KeyEvent.VK_E);
		editpredstud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editpredstud.setIcon(new ImageIcon("images2/close.png"));
		editprofstud.add(editpredstud);
		editprofstud.addSeparator();
		
		editpredprof.setMnemonic(KeyEvent.VK_E);
		editpredprof.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editpredprof.setIcon(new ImageIcon("images2/close.png"));
		editprofstud.add(editpredprof);
		
		
		
		editprofstud.setIcon(new ImageIcon("images2/close.png"));
		editEdit.add(editprofstud);
		editEdit.addSeparator();
		
		editEdit.setIcon(new ImageIcon("images2/edit.png"));	
		edit.add(editEdit);
		edit.addSeparator();
		
		
		
		
		
		
		delstudent =new JMenuItem("Delete Student");
		delprofesor=new JMenuItem("Delete Profesor");
		delpredmet= new JMenuItem("Delete Predmet");
		delprofstud=new JMenu("Delete Student/Profesor");
		delpredstud=new JMenuItem("Delete Student");
		delpredprof=new JMenuItem("Delete Profesor");
		
		
		delstudent.setMnemonic(KeyEvent.VK_D);
		delstudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		delstudent.setIcon(new ImageIcon("images2/close.png"));
		editDelete.add(delstudent);
		editDelete.addSeparator();
		
		delprofesor.setMnemonic(KeyEvent.VK_D);
		delprofesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		delprofesor.setIcon(new ImageIcon("images2/close.png"));
		editDelete.add(delprofesor);
		editDelete.addSeparator();
		
		delpredmet.setMnemonic(KeyEvent.VK_D);
		delpredmet.setIcon(new ImageIcon("images2/close.png"));
		delpredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		editDelete.add(delpredmet);
		
		
		delpredstud.setMnemonic(KeyEvent.VK_D);
		delpredstud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		delpredstud.setIcon(new ImageIcon("images2/close.png"));
		delprofstud.add(delpredstud);
		delprofstud.addSeparator();
		
		delpredprof.setMnemonic(KeyEvent.VK_D);
		delpredprof.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		delpredprof.setIcon(new ImageIcon("images2/close.png"));
		delprofstud.add(delpredprof);
		
		
		
		delprofstud.setIcon(new ImageIcon("images2/close.png"));
		editDelete.add(delprofstud);
		editDelete.addSeparator();
		
		
		editDelete.setIcon(new ImageIcon("images2/garbage.png"));
		edit.add(editDelete);
	
		
	    help = new JMenu("Help");
		helpHelp=new JMenuItem("Help");
		helpHelp.setMnemonic(KeyEvent.VK_H);
		helpHelp.setIcon(new ImageIcon("images2/information.png"));
		help.add(helpHelp);
		help.addSeparator();
		
		
		helpAbout=new JMenu("About");
		aboutstud1 =new JMenuItem("About Luna Zivkovic");
		aboutstud2=new JMenuItem("About Tamara Govorcin");
		aboutapp= new JMenuItem("About App");
		
		aboutstud1.setMnemonic(KeyEvent.VK_A);
		aboutstud1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		aboutstud1.setIcon(new ImageIcon("images2/close.png"));
		helpAbout.add(aboutstud1);
		helpAbout.addSeparator();
		
		aboutstud2.setMnemonic(KeyEvent.VK_A);
		aboutstud2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		aboutstud2.setIcon(new ImageIcon("images2/close.png"));
		helpAbout.add(aboutstud2);
		helpAbout.addSeparator();
		
		aboutapp.setMnemonic(KeyEvent.VK_A);
		aboutapp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		aboutapp.setIcon(new ImageIcon("images2/close.png"));
		helpAbout.add(aboutapp);
		helpAbout.addSeparator();
		
		helpAbout.setIcon(new ImageIcon("images2/about.png"));
		help.add(helpAbout);
		
		

		file.setMnemonic(KeyEvent.VK_1);
		edit.setMnemonic(KeyEvent.VK_2);
		help.setMnemonic(KeyEvent.VK_3);
		
		add(file);
		add(edit);
		add(help);

	}
}


