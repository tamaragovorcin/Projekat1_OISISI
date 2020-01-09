package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;
import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Profesor;

public class DialogDodajProfesoraNaPredmet extends JDialog{

	private static final long serialVersionUID = 3086370650016308061L;
	JTextField txtLicnaKarta = new JTextField();

	
	public DialogDodajProfesoraNaPredmet(Main_Frame instance, String string, boolean b) {
		super(instance, string, b);
		setSize(300,150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Dodavanje profesora na predmet");

		JPanel pan_odogovr = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("ODUSTANAK");
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		JButton potvrda = new JButton("POTVRDA");
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int red = PredmetiTablePanel.getSelektovan_red();
				String licna = pokupiUnetiTekst();
				
				Predmet predmet = PredmetiController.getInstance().getPredmetPoProfesoru(red);
				
				Profesor profesor = ProfesoriController.getInstance().getProfesoraPoPredmetu(licna);
				
				boolean postojiProfesor = ProfesoriController.getInstance().PostojiLicnaKarta(licna);
				
				boolean postojiProfesorNaPredmetu = PredmetiController.getInstance().PostojiProfesorNaPredmetu(red,licna);
				
				int broj = 	BazaPredmeta.getInstance().getPredmete().get(red).getProfesori_predavaci().size();
				
				if(postojiProfesor== true && postojiProfesorNaPredmetu==false && broj==0) {
					dispose();
					PredmetiController.getInstance().dodajProfesora(profesor, red);
					ProfesoriController.getInstance().dodajPredmetProfesoru(predmet,licna);
					JOptionPane.showMessageDialog(null, "Profesor je uspesno dodat na predmet!");
				}
				else {
					if(!postojiProfesor) {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Ne postoji profesor sa tim brojem licne karte.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
						setVisible(true);
					}
					else if(postojiProfesorNaPredmetu) {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Profesor vec postoji na listi tog predmeta kao predavac.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
						setVisible(true);
					}
					else {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Nije moguce dodati profesora na predmet.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
						setVisible(true);
					}
				}	
			}
		
		});
		
		pan_odogovr.add(odustanak);
		pan_odogovr.add(potvrda);
		
		JPanel pan_centar = new JPanel();
		pan_centar.setBackground(Color.white);
		pan_centar.setLayout(new GridBagLayout());
		
		Dimension dim = new Dimension(120, 20);
		JLabel labelaLicnaKarta = new JLabel("Broj licne karte*:");
		labelaLicnaKarta.setPreferredSize(dim);
		
		txtLicnaKarta.setPreferredSize(dim);
		txtLicnaKarta.setName("BrojLicneKarte");
		txtLicnaKarta.setBackground(Color.GRAY);
		txtLicnaKarta.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (provera()) {
					potvrda.setEnabled(true);
				} else {
					potvrda.setEnabled(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		GridBagConstraints gbcLicnaKarta = new GridBagConstraints();
		gbcLicnaKarta.gridx = 0;
		gbcLicnaKarta.gridy = 0;
		gbcLicnaKarta.insets = new Insets(10, 20, 0, 0);
		pan_centar.add(labelaLicnaKarta, gbcLicnaKarta);
		
		GridBagConstraints gbcTXTLicnaKarta = new GridBagConstraints();
		gbcTXTLicnaKarta.gridx = 1;
		gbcTXTLicnaKarta.gridy = 0;
		gbcTXTLicnaKarta.weightx = 100;
		gbcTXTLicnaKarta.fill = GridBagConstraints.HORIZONTAL;
		gbcTXTLicnaKarta.insets = new Insets(10, 20, 0, 20);
		pan_centar.add(txtLicnaKarta, gbcTXTLicnaKarta);
		
		add(pan_centar, BorderLayout.CENTER);
		add(pan_odogovr, BorderLayout.SOUTH);

		setResizable(false);
	}

	public boolean provera() {
		String tekst = pokupiUnetiTekst();
		boolean izlaz = true;
		if (!Pattern.matches("[\"a-zA-Z0-9_ ]*", tekst)) {
			txtLicnaKarta.setBackground(Color.RED);
			izlaz= false;
		}
		
		if(tekst.trim().length()==0 ) {
			txtLicnaKarta.setBackground(Color.WHITE);
			izlaz = false;
		}
		txtLicnaKarta.setBackground(Color.WHITE);
		return izlaz;
	}
	
	private String pokupiUnetiTekst() {
		String tekst = new String();
		tekst =txtLicnaKarta.getText().toString(); 
		return tekst;
	}
	
}
