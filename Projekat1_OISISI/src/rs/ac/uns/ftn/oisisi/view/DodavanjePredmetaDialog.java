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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;

public class DodavanjePredmetaDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -720118426910400743L;

	private int mode = 1;
	public static final int ODUSTANAK = 0;
	public static final int POTVRDA = 1;

	JTextField txtSifra = new JTextField();
	JTextField txtNaziv = new JTextField();
	JComboBox<String> semestarComboBox;
	JComboBox<String> godinaComboBox;

	public DodavanjePredmetaDialog(Main_Frame instance, String string, boolean b) {
		super(instance, string, b);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Dodavanje predmeta");

		Dimension dim = new Dimension(120, 20);

		JPanel pan_odogovr = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("ODUSTANAK");
		odustanak.addActionListener(this);
		JButton potvrda = new JButton("POTVRDA");
		potvrda.addActionListener(this);

		pan_odogovr.add(odustanak);
		pan_odogovr.add(potvrda);

		JPanel pan_centar = new JPanel();
		pan_centar.setBackground(Color.white);
		pan_centar.setLayout(new GridBagLayout());
		pan_centar.setBackground(new Color(204, 227, 249));

		

		JLabel labelaSifra = new JLabel("Sifra predmeta*:");
		labelaSifra.setPreferredSize(dim);

		txtSifra.setPreferredSize(dim);
		txtSifra.setName("txtSifra");
		txtSifra.setBackground(Color.GRAY);
		txtSifra.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
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
		});
	
		JLabel lblNaziv = new JLabel("Naziv predmeta*:");
		lblNaziv.setPreferredSize(dim);

		txtNaziv.setPreferredSize(dim);
		txtNaziv.setName("txtNaziv");
		txtNaziv.setBackground(Color.GRAY);
		txtNaziv.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
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
		});

	
		JLabel lblsemestar = new JLabel("Semestar*:");
		lblsemestar.setPreferredSize(dim);
		String semestar[] = { "    ", "zimski", "letnji" };

		semestarComboBox = new JComboBox<String>(semestar);
		semestarComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (provera()) {
					potvrda.setEnabled(true);
				} else {
					potvrda.setEnabled(false);
				}
			}
		});

		JLabel lblGodina = new JLabel("Godina*:");
		lblGodina.setPreferredSize(dim);
		String godina[] = { "     ", "I", "II", "III", "IV", "V" };
		godinaComboBox = new JComboBox<String>(godina);
		godinaComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (provera()) {
					potvrda.setEnabled(true);
				} else {
					potvrda.setEnabled(false);
				}

			}
		});
		GridBagConstraints gbcSifra = new GridBagConstraints();
		gbcSifra.gridx = 0;
		gbcSifra.gridy = 0;
		gbcSifra.insets = new Insets(10, 20, 0, 0);
		pan_centar.add(labelaSifra, gbcSifra);

		GridBagConstraints gbcNaziv = new GridBagConstraints();
		gbcNaziv.gridx = 0;
		gbcNaziv.gridy = 1;
		gbcNaziv.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(lblNaziv, gbcNaziv);

		GridBagConstraints gbcTekstSifra = new GridBagConstraints();
		gbcTekstSifra.gridx = 1;
		gbcTekstSifra.gridy = 0;
		gbcTekstSifra.weightx = 100;
		gbcTekstSifra.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstSifra.insets = new Insets(10, 20, 0, 20);
		pan_centar.add(txtSifra, gbcTekstSifra);

		GridBagConstraints gbcTekstNaziv = new GridBagConstraints();
		gbcTekstNaziv.gridx = 1;
		gbcTekstNaziv.gridy = 1;
		gbcTekstNaziv.weightx = 200;
		gbcTekstNaziv.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstNaziv.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtNaziv, gbcTekstNaziv);

		GridBagConstraints gbcSemestar = new GridBagConstraints();
		gbcSemestar.gridx = 0;
		gbcSemestar.gridy = 2;
		gbcSemestar.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(lblsemestar, gbcSemestar);

		GridBagConstraints gbcGodina = new GridBagConstraints();
		gbcGodina.gridx = 0;
		gbcGodina.gridy = 3;
		gbcGodina.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(lblGodina, gbcGodina);

		GridBagConstraints gbcComboBoxSemestar = new GridBagConstraints();
		gbcComboBoxSemestar.gridx = 1;
		gbcComboBoxSemestar.gridy = 2;
		gbcComboBoxSemestar.weightx = 10;
		gbcComboBoxSemestar.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(semestarComboBox, gbcComboBoxSemestar);

		GridBagConstraints gbcComboBoxGodina = new GridBagConstraints();
		gbcComboBoxGodina.gridx = 1;
		gbcComboBoxGodina.gridy = 3;
		gbcComboBoxGodina.weightx = 10;
		gbcComboBoxGodina.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(godinaComboBox, gbcComboBoxGodina);


		add(pan_centar, BorderLayout.CENTER);
		add(pan_odogovr, BorderLayout.SOUTH);

		setResizable(false);
	}

	public String[] pokupiUnetiTekst() {
		String tekst[] = new String[4];
		for (int i = 0; i < tekst.length; i++) {
			tekst[i] = new String();
		}
		tekst[0] = txtSifra.getText().toString();
		tekst[1] = txtNaziv.getText().toString();
		tekst[2] = semestarComboBox.getSelectedItem().toString();
		tekst[3] = godinaComboBox.getSelectedItem().toString();

		return tekst;
	}

	protected boolean provera() {
		String tekst[] = pokupiUnetiTekst();
		boolean izlaz = true;

		if (!Pattern.matches("[a-zA-Z0-9]*", tekst[0])) {
			txtSifra.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[1])) {
			txtNaziv.setBackground(Color.RED);
			return false;
		}
		for (String t : tekst) {
			if ((t = t.trim()).length() == 0) {
				txtSifra.setBackground(Color.WHITE);
				txtNaziv.setBackground(Color.WHITE);
				izlaz = false;
			}
		}
		txtSifra.setBackground(Color.WHITE);
		txtNaziv.setBackground(Color.WHITE);

		return izlaz;
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String tekst[] = pokupiUnetiTekst();
		
		if (e.getActionCommand().equals("ODUSTANAK")) {
			mode = DodavanjePredmetaDialog.ODUSTANAK;
		
		} else {
			
			mode = DodavanjePredmetaDialog.POTVRDA;
			if(BazaPredmeta.getInstance().getPredmete().size()==0) {
				BazaPredmeta.getInstance().initPredmete(tekst[0], tekst[1], tekst[2], tekst[3]);
			}
			else {
				int nesto=0;
				for(Predmet p: BazaPredmeta.getInstance().getPredmete()) {
					if(p.getSifra_predmeta().equals(tekst[0])) {
						
						nesto =1;
					}
				}
				if(nesto==0) {
					setVisible(true);
					BazaPredmeta.getInstance().initPredmete(tekst[0], tekst[1], tekst[2], tekst[3]);
				} 
				else if(nesto ==1) {
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Uneta sifra predmeta vec postoji!");
					setVisible(true);
				}
			}
			
			}
		setVisible(false);
		}
		

	

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

}
