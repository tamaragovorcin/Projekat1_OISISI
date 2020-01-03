package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Profesor;
import rs.ac.uns.ftn.oisisi.model.Student;

public class IzmenaProfesoraDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 8377505010808280172L;

	private int mode = 1;
	public static final int ODUSTANAK = 0; 
	public static final int POTVRDA = 1;

	JTextField txtIme = new JTextField();
	JTextField txtPrezime = new JTextField();
	JTextField txtDatumRodjenja = new JTextField();
	JTextField txtAdresa=new JTextField();
	JTextField txtTelefon=new JTextField();
	JTextField txtEmail =new JTextField();
	JTextField txtAdresaKancelarije=new JTextField();
	JTextField txtBrojLicneKarte=new JTextField();
	JTextField txtTitula=new JTextField();
	JTextField txtZvanje=new JTextField();
	
	
	List<Profesor> profesori = BazaProfesora.getInstance().getProfesore();
	
	
	private int red;
	private Profesor profesor;
	public IzmenaProfesoraDialog(Main_Frame instance, String string, boolean b,int row) {
		
		super(instance, string, b);
		
		
		Profesor profesor = profesori.get(row);
		red = row;
		
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Izmena profesora");

		Dimension dim = new Dimension(120, 20);

		JPanel pan_odgovor = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("ODUSTANAK");
		odustanak.addActionListener(this);
		JButton potvrda = new JButton("POTVRDA");
		potvrda.addActionListener(this);

		pan_odgovor.add(odustanak);
		pan_odgovor.add(potvrda);

		JPanel pan_centar = new JPanel();
		pan_centar.setBackground(Color.white);
		pan_centar.setLayout(new GridBagLayout());
		pan_centar.setBackground(new Color(204, 227, 249));
		

		
		


		JLabel labelaIme = new JLabel("Ime*:");
		labelaIme.setPreferredSize(dim);

		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		txtIme.setBackground(Color.CYAN);
		txtIme.addKeyListener(new KeyListener() {

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
	
	
		JLabel labelaPrezime = new JLabel("Prezime*:");
		labelaIme.setPreferredSize(dim);

		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		txtPrezime.setBackground(Color.CYAN);
		txtPrezime.addKeyListener(new KeyListener() {

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
	
		
		
	
		
		JLabel labelaDatum = new JLabel("Datum rodjenja*:");
		labelaDatum.setPreferredSize(dim);

		txtDatumRodjenja.setPreferredSize(dim);
		txtDatumRodjenja.setName("txtDatumRodjenja");
		txtDatumRodjenja.setBackground(Color.CYAN);
		txtDatumRodjenja.addKeyListener(new KeyListener() {

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
		
	
		
		
		JLabel labelaAdresa = new JLabel("Adresa*:");
		labelaAdresa.setPreferredSize(dim);

		txtAdresa.setPreferredSize(dim);
		txtAdresa.setName("txtDatumRodjenja");
		txtAdresa.setBackground(Color.CYAN);
		txtAdresa.addKeyListener(new KeyListener() {

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
		
		
		
		JLabel labelaTelefon = new JLabel("Broj telefona*:");
		labelaTelefon.setPreferredSize(dim);

		txtTelefon.setPreferredSize(dim);
		txtTelefon.setName("txtTelefon");
		txtTelefon.setBackground(Color.CYAN);
		txtTelefon.addKeyListener(new KeyListener() {

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
		
		
		
		JLabel labelaEmail = new JLabel("Email*:");
		labelaEmail.setPreferredSize(dim);

		txtEmail.setPreferredSize(dim);
		txtEmail.setName("txtEmail");
		txtEmail.setBackground(Color.CYAN);
		txtEmail.addKeyListener(new KeyListener() {

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
	
		
		
		JLabel labelaAdresaKancelarije = new JLabel("Adresa kancelarije*:");
		labelaAdresaKancelarije.setPreferredSize(dim);

		txtAdresaKancelarije.setPreferredSize(dim);
		txtAdresaKancelarije.setName("txtAdresaKancelarije");
		txtAdresaKancelarije.setBackground(Color.CYAN);
		txtAdresaKancelarije.addKeyListener(new KeyListener() {

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
	
		
		
		JLabel labelaBrojLicneKarte = new JLabel("Broj licne karte*:");
		labelaBrojLicneKarte.setPreferredSize(dim);

		txtBrojLicneKarte.setPreferredSize(dim);
		txtBrojLicneKarte.setName("txtBrojLicneKarte");
		txtBrojLicneKarte.setBackground(Color.CYAN);
		txtBrojLicneKarte.addKeyListener(new KeyListener() {

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
		
		JLabel labelaTitula = new JLabel("Titula*:");
		labelaBrojLicneKarte.setPreferredSize(dim);

		txtTitula.setPreferredSize(dim);
		txtTitula.setName("txtTitula");
		txtTitula.setBackground(Color.CYAN);
		txtTitula.addKeyListener(new KeyListener() {

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
	
		
		JLabel labelaZvanje = new JLabel("Zvanje*:");
		labelaBrojLicneKarte.setPreferredSize(dim);

		txtZvanje.setPreferredSize(dim);
		txtZvanje.setName("txtZvanje");
		txtZvanje.setBackground(Color.CYAN);
		txtZvanje.addKeyListener(new KeyListener() {

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
		
		
		
		GridBagConstraints gbcIme = new GridBagConstraints();
		gbcIme.gridx = 0;
		gbcIme.gridy = 0;
		gbcIme.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaIme, gbcIme);

		GridBagConstraints gbcPrezime = new GridBagConstraints();
		gbcPrezime .gridx = 0;
		gbcPrezime .gridy = 1;
		gbcPrezime .insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaPrezime , gbcPrezime );
		
		GridBagConstraints gbcDatumRodjenja = new GridBagConstraints();
		gbcDatumRodjenja .gridx = 0;
		gbcDatumRodjenja .gridy = 2;
		gbcDatumRodjenja .insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaDatum , gbcDatumRodjenja );
		
		GridBagConstraints gbcAdresa = new GridBagConstraints();
		gbcAdresa  .gridx = 0;
		gbcAdresa  .gridy = 3;
		gbcAdresa  .insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaAdresa  , gbcAdresa  );
		
		GridBagConstraints gbcTelefon = new GridBagConstraints();
		gbcTelefon .gridx = 0;
		gbcTelefon.gridy = 4;
		gbcTelefon .insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaTelefon , gbcTelefon );
		
		GridBagConstraints gbcEmail = new GridBagConstraints();
		gbcEmail .gridx = 0;
		gbcEmail.gridy = 5;
		gbcEmail .insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaEmail , gbcEmail );
		
		GridBagConstraints gbcAdresaKancelarije = new GridBagConstraints();
		gbcAdresaKancelarije .gridx = 0;
		gbcAdresaKancelarije .gridy = 6;
		gbcAdresaKancelarije .insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaAdresaKancelarije , gbcAdresaKancelarije );
		
		GridBagConstraints gbcBrojLicneKarte = new GridBagConstraints();
		gbcBrojLicneKarte  .gridx = 0;
		gbcBrojLicneKarte  .gridy = 7;
		gbcBrojLicneKarte  .insets =new Insets(20, 20, 0, 0);
		pan_centar.add(labelaBrojLicneKarte  , gbcBrojLicneKarte  );
		
		
		GridBagConstraints gbcTitula = new GridBagConstraints();
		gbcTitula  .gridx = 0;
		gbcTitula   .gridy = 8;
		gbcTitula  .insets =new Insets(20, 20, 0, 0);
		pan_centar.add(labelaTitula   , gbcTitula  );
		
		GridBagConstraints gbcZvanje = new GridBagConstraints();
		gbcZvanje.gridx = 0;
		gbcZvanje.gridy = 9;
		gbcZvanje.insets =new Insets(20, 20, 0, 0);
		pan_centar.add(labelaZvanje   , gbcZvanje  );
		
		
		
		GridBagConstraints gbcTekstIme = new GridBagConstraints();
		gbcTekstIme .gridx = 1;
		gbcTekstIme .gridy = 0;
		gbcTekstIme .weightx = 200;
		gbcTekstIme .fill = GridBagConstraints.HORIZONTAL;
		gbcTekstIme .insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtIme , gbcTekstIme );

	
		GridBagConstraints gbcTekstPrezime = new GridBagConstraints();
		gbcTekstPrezime .gridx = 1;
		gbcTekstPrezime .gridy = 1;
		gbcTekstPrezime.weightx = 200;
		gbcTekstPrezime .fill = GridBagConstraints.HORIZONTAL;
		gbcTekstPrezime .insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtPrezime , gbcTekstPrezime );
		
		
		GridBagConstraints gbcTekstDatumRodjenja = new GridBagConstraints();
		gbcTekstDatumRodjenja .gridx = 1;
		gbcTekstDatumRodjenja .gridy = 2;
		gbcTekstDatumRodjenja .weightx = 200;
		gbcTekstDatumRodjenja .fill = GridBagConstraints.HORIZONTAL;
		gbcTekstDatumRodjenja.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtDatumRodjenja, gbcTekstDatumRodjenja );
		
		
		GridBagConstraints gbcTekstAdresa = new GridBagConstraints();
		gbcTekstAdresa .gridx = 1;
		gbcTekstAdresa .gridy = 3;
		gbcTekstAdresa .weightx = 200;
		gbcTekstAdresa .fill = GridBagConstraints.HORIZONTAL;
		gbcTekstAdresa .insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtAdresa , gbcTekstAdresa );
		
		
		GridBagConstraints gbcTekstTelefon = new GridBagConstraints();
		gbcTekstTelefon .gridx = 1;
		gbcTekstTelefon .gridy = 4;
		gbcTekstTelefon .weightx = 200;
		gbcTekstTelefon .fill = GridBagConstraints.HORIZONTAL;
		gbcTekstTelefon .insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtTelefon , gbcTekstTelefon );
		
		
		GridBagConstraints gbcTekstEmail = new GridBagConstraints();
		gbcTekstEmail .gridx = 1;
		gbcTekstEmail.gridy = 5;
		gbcTekstEmail .weightx = 200;
		gbcTekstEmail .fill = GridBagConstraints.HORIZONTAL;
		gbcTekstEmail.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtEmail , gbcTekstEmail );
		
		
		
		GridBagConstraints gbcTekstAdresaKancelarije= new GridBagConstraints();
		gbcTekstAdresaKancelarije .gridx = 1;
		gbcTekstAdresaKancelarije .gridy = 6;
		gbcTekstAdresaKancelarije .weightx = 200;
		gbcTekstAdresaKancelarije .fill = GridBagConstraints.HORIZONTAL;
		gbcTekstAdresaKancelarije .insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtAdresaKancelarije , gbcTekstAdresaKancelarije );
		
		
		
		GridBagConstraints gbcTekstBrojLicneKarte = new GridBagConstraints();
		gbcTekstBrojLicneKarte .gridx = 1;
		gbcTekstBrojLicneKarte.gridy = 7;
		gbcTekstBrojLicneKarte .weightx = 200;
		gbcTekstBrojLicneKarte .fill = GridBagConstraints.HORIZONTAL;
		gbcTekstBrojLicneKarte .insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtBrojLicneKarte , gbcTekstBrojLicneKarte );
		

		GridBagConstraints gbcTekstTitula= new GridBagConstraints();
		gbcTekstTitula .gridx = 1;
		gbcTekstTitula.gridy = 8;
		gbcTekstTitula .weightx = 200;
		gbcTekstTitula .fill = GridBagConstraints.HORIZONTAL;
		gbcTekstTitula .insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtTitula , gbcTekstTitula );

		GridBagConstraints gbcTekstZvanje = new GridBagConstraints();
		gbcTekstZvanje .gridx = 1;
		gbcTekstZvanje.gridy = 9;
		gbcTekstZvanje .weightx = 200;
		gbcTekstZvanje.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstZvanje .insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtZvanje , gbcTekstZvanje );
		
		add(pan_centar, BorderLayout.CENTER);
		add(pan_odgovor, BorderLayout.SOUTH);

		setResizable(false);
		



		Set();
		setResizable(false);	
		
		
	}

	public String[] pokupiUnetiTekst() {
		String tekst[] = new String[10];
		for (int i = 0; i < tekst.length; i++) {
			tekst[i] = new String();
		}
		tekst[0] = txtIme.getText().toString();
		tekst[1] = txtPrezime.getText().toString();
		tekst[2]=txtDatumRodjenja.getText().toString();
		tekst[3]=txtAdresa.getText().toString();
		tekst[4]=txtTelefon.getText().toString();
		tekst[5]=txtEmail.getText().toString();
		tekst[6]=txtAdresaKancelarije.getText().toString();
		tekst[7]=txtBrojLicneKarte.getText().toString();
		tekst[8] = txtTitula.getText().toString();
		tekst[9]=txtZvanje.getText().toString();
		return tekst;
	}

	protected boolean provera() {
		String tekst[] = pokupiUnetiTekst();
		boolean izlaz = true;

		if (!Pattern.matches("[a-zA-Z0-9_]*", tekst[0])) {
			txtIme.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[1])) {
			txtPrezime.setBackground(Color.RED);
			return false;
		}
		if (tekst[2].length() != 0) {
			if (!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}$", tekst[2])) {
				txtDatumRodjenja.setBackground(Color.RED);
				return false;
			}
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[3])) {
			txtAdresa.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("^[0-9]*", tekst[4])) {
			txtTelefon.setBackground(Color.RED);
			return false;	
		}
		if (tekst[5].length() != 0) {
			if (!Pattern.matches("^(.+)@(.+)$", tekst[5])) {
				txtEmail.setBackground(Color.RED);
				return false;
			}
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[6])) {
			txtAdresaKancelarije.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[7])) {
			txtBrojLicneKarte.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[8])) {
			txtTitula.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[9])) {
			txtZvanje.setBackground(Color.RED);
			return false;
		}

		
		
		for (String t : tekst) {
			if ((t = t.trim()).length() == 0) {
				txtIme.setBackground(Color.WHITE);
				txtPrezime.setBackground(Color.WHITE);
				txtDatumRodjenja.setBackground(Color.WHITE);
				txtAdresa.setBackground(Color.WHITE);
				txtTelefon.setBackground(Color.WHITE);
				txtEmail.setBackground(Color.WHITE);
				txtAdresaKancelarije.setBackground(Color.WHITE);
				txtBrojLicneKarte.setBackground(Color.WHITE);
				txtTitula.setBackground(Color.WHITE);
				txtZvanje.setBackground(Color.WHITE);
				izlaz = false;
			}
		}
		txtIme.setBackground(Color.WHITE);
		txtPrezime.setBackground(Color.WHITE);
		txtDatumRodjenja.setBackground(Color.WHITE);
		txtAdresa.setBackground(Color.WHITE);
		txtTelefon.setBackground(Color.WHITE);
		txtEmail.setBackground(Color.WHITE);
		txtAdresaKancelarije.setBackground(Color.WHITE);
		txtBrojLicneKarte.setBackground(Color.WHITE);
		txtTitula.setBackground(Color.WHITE);
		txtZvanje.setBackground(Color.WHITE);

		return izlaz;
	}

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String tekst[] = pokupiUnetiTekst();
	
		if (e.getActionCommand().equals("ODUSTANAK")) {
			mode = IzmenaStudentaDialog.ODUSTANAK;
			//dispose();
		} else {
			mode = IzmenaProfesoraDialog.POTVRDA;  	
			if(!profesor.getBroj_licne_karte().equals(tekst[7])) { 
				for(Profesor p:profesori) {
					if(tekst[7].equals(p.getBroj_licne_karte())) {
						JOptionPane.showMessageDialog((Component) e.getSource(), "Izmenjeni  broj licne karte vec postoji!");
						return;
					}
					
				}
				
				profesor.setIme(tekst[0]);
				profesor.setPrezime(tekst[1]);
				profesor.setDatumRodjenja(tekst[2]);
				profesor.setAdresaStanovanja(tekst[3]);
				profesor.setKontakt_telefon(tekst[4]);
				profesor.setEmail(tekst[5]);
				profesor.setAdresa_kancelarije(tekst[6]);
				profesor.setBroj_licne_karte(tekst[7]);
				profesor.setTitula(tekst[8]);
				profesor.setZvanje(tekst[9]);
				ProfesoriJTable.getInstance().refresTabelu();
			}
			else {
				
				profesor.setIme(tekst[0]);
				profesor.setPrezime(tekst[1]);
				profesor.setDatumRodjenja(tekst[2]);
				profesor.setAdresaStanovanja(tekst[3]);
				profesor.setKontakt_telefon(tekst[4]);
				profesor.setEmail(tekst[5]);
				profesor.setAdresa_kancelarije(tekst[6]);
				//profesor.setBroj_licne_karte(tekst[7]);
				profesor.setTitula(tekst[8]);
				profesor.setZvanje(tekst[9]);
				
				
				JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesna izmena!");
				ProfesoriJTable.getInstance().refresTabelu();
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


	public void  Set() {
		
		profesor= BazaProfesora.getInstance().getProfesore().get(red);
		txtIme.setText(profesor.getIme());
		txtPrezime.setText(profesor.getPrezime());
		txtDatumRodjenja.setText(profesor.getDatumRodjenja());
		txtAdresa.setText(profesor.getAdresaStanovanja());
		txtTelefon.setText(profesor.getKontakt_telefon());
		txtEmail.setText(profesor.getEmail());
		txtAdresaKancelarije.setText(profesor.getAdresa_kancelarije());
		txtBrojLicneKarte.setText(profesor.getBroj_licne_karte());
		txtTitula.setText(profesor.getTitula());
		txtZvanje.setText(profesor.getZvanje());
		
		
	
}
}