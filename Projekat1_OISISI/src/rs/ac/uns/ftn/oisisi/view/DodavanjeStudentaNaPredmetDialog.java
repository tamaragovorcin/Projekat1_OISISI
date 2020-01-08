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
import rs.ac.uns.ftn.oisisi.controller.StudentiController;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Student;

public class DodavanjeStudentaNaPredmetDialog extends JDialog{
	
	private static final long serialVersionUID = 3086370650016308061L;
	
	JTextField txtBrojIndeksa = new JTextField();

	public DodavanjeStudentaNaPredmetDialog(Main_Frame instance, String string, boolean b) {
		super(instance, string, b);
		setSize(300,150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Dodavanje studenta na predmet");

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
				String indeks = pokupiUnetiTekst();
				
				Predmet predmet = PredmetiController.getInstance().getPredmetPoStudentu(red);
				
				Student stud = StudentiController.getInstance().getStudentaPoPredmetu(indeks);
				
				boolean postojiStudent =StudentiController.getInstance().PostojiBrojIndeksa(indeks);
				
				boolean postojiStudentNaPredmetu = PredmetiController.getInstance().PostojiStudentNaPredmetu(red,indeks);
				
				boolean odgovarajucaGod=false;
				
				if(postojiStudent== true && postojiStudentNaPredmetu==false ) {
					dispose();
					PredmetiController.getInstance().dodajStudenta(stud, red);
					StudentiController.getInstance().dodajPredmetStuddentu(predmet,indeks);
					JOptionPane.showMessageDialog(null, "Student je uspesno dodat na predmet!");
				}
				else {
					if(!postojiStudent) {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Ne postoji student sa tim brojem indeksa.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
						setVisible(true);
					}
					else if(postojiStudentNaPredmetu) {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Student postoji vec na listi tog predmeta.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
						setVisible(true);
					}
					else if(!odgovarajucaGod) {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Student i predmet ne pripadaju istoj godini studija.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
						setVisible(true);
					}
					else {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Nije moguce dodati studenta na predmet.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
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
		JLabel labelaIndeks = new JLabel("Broj indeksa*:");
		labelaIndeks.setPreferredSize(dim);
		
		txtBrojIndeksa.setPreferredSize(dim);
		txtBrojIndeksa.setName("BrojIndeksa");
		txtBrojIndeksa.setBackground(Color.GRAY);
		txtBrojIndeksa.addKeyListener(new KeyListener() {
			
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
		GridBagConstraints gbcIndeks = new GridBagConstraints();
		gbcIndeks.gridx = 0;
		gbcIndeks.gridy = 0;
		gbcIndeks.insets = new Insets(10, 20, 0, 0);
		pan_centar.add(labelaIndeks, gbcIndeks);
		
		GridBagConstraints gbcTXTIndeks = new GridBagConstraints();
		gbcTXTIndeks.gridx = 1;
		gbcTXTIndeks.gridy = 0;
		gbcTXTIndeks.weightx = 100;
		gbcTXTIndeks.fill = GridBagConstraints.HORIZONTAL;
		gbcTXTIndeks.insets = new Insets(10, 20, 0, 20);
		pan_centar.add(txtBrojIndeksa, gbcTXTIndeks);
		
		add(pan_centar, BorderLayout.CENTER);
		add(pan_odogovr, BorderLayout.SOUTH);

		setResizable(false);
	}

	public boolean provera() {
		String tekst = pokupiUnetiTekst();
		boolean izlaz = true;
		if (!Pattern.matches("[A-Z]{2,3}/[0-9]{1,3}/[0-9]{4}", tekst)) {
			txtBrojIndeksa.setBackground(Color.RED);
			izlaz= false;
		}
		
		if(tekst.trim().length()==0 ) {
			txtBrojIndeksa.setBackground(Color.WHITE);
			izlaz = false;
		}
		txtBrojIndeksa.setBackground(Color.WHITE);
		return izlaz;
	}

	private String pokupiUnetiTekst() {
		String tekst = new String();
		tekst =txtBrojIndeksa.getText().toString(); 
		return tekst;
	}
}
