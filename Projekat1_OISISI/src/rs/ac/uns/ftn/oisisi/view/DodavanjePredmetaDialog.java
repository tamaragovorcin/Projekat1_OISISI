package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.regex.Pattern;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;



import rs.ac.uns.ftn.oisisi.controller.MojFocusListener;




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
		super(instance,string,b);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Dodavanje predmeta");
		
		Dimension dim = new Dimension(120, 20);
	//	MojFocusListener MojFocus = new MojFocusListener();
		
		JPanel pan_odogovr = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("ODUSTANAK");
		odustanak.addActionListener(this);
		JButton potvrda = new JButton("POTVRDA");
		potvrda.addActionListener(this);

		pan_odogovr.add(odustanak);
		pan_odogovr.add(potvrda);
		
		
		JPanel pan_centar = new JPanel();
	
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
		
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
				if(provera()) {
					potvrda.setEnabled(true);
				} else {
					potvrda.setEnabled(false);
				}
				
			}
		});
		panSifra.add(labelaSifra);
		panSifra.add(txtSifra);
		
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));

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
				if(provera()) {
					potvrda.setEnabled(true);
				} else {
					potvrda.setEnabled(false);
				}
				
			}
		});

		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);
		
	
		
		JPanel panSemestar =new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblsemestar = new JLabel("Semestar*:");
		lblsemestar.setPreferredSize(dim);
		String semestar[] = {"    ","zimski","letnji"};

		semestarComboBox = new JComboBox<String>(semestar);
		semestarComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValid()) {
					potvrda.setEnabled(true);
				}
				else {
					potvrda.setEnabled(false);
				}
			}
		});
	
		panSemestar.add(lblsemestar);
		panSemestar.add(semestarComboBox);
		
		JPanel panGodina =new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodina = new JLabel("Godina*:");
		lblGodina.setPreferredSize(dim);
		String godina[] = { "             ", "I", "II", "III", "IV", "V"};
		godinaComboBox = new JComboBox<String>(godina);
		godinaComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValid()) {
					potvrda.setEnabled(true);
				} else {
					potvrda.setEnabled(false);
				}
				
			}
		});
	
		panGodina.add(lblGodina);
		panGodina.add(godinaComboBox);
		
		
		pan_centar.add(panSifra);
		pan_centar.add(panNaziv);
		pan_centar.add(panSemestar);
		pan_centar.add(panGodina);
	
		add(pan_centar,BorderLayout.CENTER);
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
		String tekst [] = pokupiUnetiTekst();
		boolean izlaz = true;
		
		if (!Pattern.matches("[a-zA-Z0-9]*", tekst[0])) {
			txtSifra.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[1])) {
			txtNaziv.setBackground(Color.RED);
			return false;
		}
		for(String t: tekst) {
			if((t = t.trim()).length() == 0) {
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
		if (e.getActionCommand().equals("ODUSTANAK")) {
			mode = DodavanjePredmetaDialog.ODUSTANAK;
		} else {
			mode =  DodavanjePredmetaDialog.POTVRDA;
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
