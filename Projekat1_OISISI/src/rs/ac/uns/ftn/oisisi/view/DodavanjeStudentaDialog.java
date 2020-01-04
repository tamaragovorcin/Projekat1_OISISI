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
import javax.swing.text.TabExpander;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Predmet;
import rs.ac.uns.ftn.oisisi.model.Student;

public class DodavanjeStudentaDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = -720118426910400743L;

	private int mode = 1;
	public static final int ODUSTANAK = 0;
	public static final int POTVRDA = 1;

	JTextField txtIme = new JTextField();
	JTextField txtPrezime = new JTextField();
	JTextField txtDatumRodjenja = new JTextField();
	JTextField txtAdresa = new JTextField();
	JTextField txtTelefon = new JTextField();
	JTextField txtEmail = new JTextField();
	JTextField txtIndeks = new JTextField();
	JTextField txtDatumUpisa = new JTextField();
	JComboBox<String> godinaComboBox;
	JRadioButton budzet = new JRadioButton("Budzet", true);
	JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
	ButtonGroup btnGroup1 = new ButtonGroup();

	public DodavanjeStudentaDialog(Main_Frame instance, String string, boolean b) {
		super(instance, string, b);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Dodavanje studenta");

		Dimension dim = new Dimension(120, 20);

		JPanel pan_odogovr = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("ODUSTANAK");
		odustanak.addActionListener(this);
		JButton potvrda = new JButton("POTVRDA");
		potvrda.addActionListener(this);

		pan_odogovr.add(odustanak);
		pan_odogovr.add(potvrda);

		// JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JPanel pan_centar = new JPanel();
		pan_centar.setBackground(Color.white);
		pan_centar.setLayout(new GridBagLayout());
		pan_centar.setBackground(new Color(204, 227, 249));

		JLabel labelaIme = new JLabel("Ime*:");
		labelaIme.setPreferredSize(dim);

		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		txtIme.setBackground(Color.GRAY);
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
		txtPrezime.setBackground(Color.GRAY);
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
		txtDatumRodjenja.setBackground(Color.GRAY);
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
		txtAdresa.setBackground(Color.GRAY);
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
		txtTelefon.setBackground(Color.GRAY);
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
		txtEmail.setBackground(Color.GRAY);
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

		JLabel labelaIndeks = new JLabel("Indeks*:");
		labelaIndeks.setPreferredSize(dim);

		txtIndeks.setPreferredSize(dim);
		txtIndeks.setName("txtIndeks");
		txtIndeks.setBackground(Color.GRAY);
		txtIndeks.addKeyListener(new KeyListener() {

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

		JLabel labelaDatumUpisa = new JLabel("Datum upisa*:");
		labelaIndeks.setPreferredSize(dim);

		txtDatumUpisa.setPreferredSize(dim);
		txtDatumUpisa.setName("txtDatumUpisa");
		txtDatumUpisa.setBackground(Color.GRAY);
		txtDatumUpisa.addKeyListener(new KeyListener() {

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

		budzet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					potvrda.setEnabled(true);
				} else {
					potvrda.setEnabled(false);
				}
			}
		});

		samofinansiranje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					potvrda.setEnabled(true);
				} else {
					potvrda.setEnabled(false);
				}
			}
		});

		btnGroup1.add(budzet);
		btnGroup1.add(samofinansiranje);

		GridBagConstraints gbcIme = new GridBagConstraints();
		gbcIme.gridx = 0;
		gbcIme.gridy = 0;
		gbcIme.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaIme, gbcIme);

		GridBagConstraints gbcPrezime = new GridBagConstraints();
		gbcPrezime.gridx = 0;
		gbcPrezime.gridy = 1;
		gbcPrezime.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaPrezime, gbcPrezime);

		GridBagConstraints gbcDatumRodjenja = new GridBagConstraints();
		gbcDatumRodjenja.gridx = 0;
		gbcDatumRodjenja.gridy = 2;
		gbcDatumRodjenja.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaDatum, gbcDatumRodjenja);

		GridBagConstraints gbcAdresa = new GridBagConstraints();
		gbcAdresa.gridx = 0;
		gbcAdresa.gridy = 3;
		gbcAdresa.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaAdresa, gbcAdresa);

		GridBagConstraints gbcTelefon = new GridBagConstraints();
		gbcTelefon.gridx = 0;
		gbcTelefon.gridy = 4;
		gbcTelefon.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaTelefon, gbcTelefon);

		GridBagConstraints gbcEmail = new GridBagConstraints();
		gbcEmail.gridx = 0;
		gbcEmail.gridy = 5;
		gbcEmail.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaEmail, gbcEmail);

		GridBagConstraints gbcBrojIndexa = new GridBagConstraints();
		gbcBrojIndexa.gridx = 0;
		gbcBrojIndexa.gridy = 6;
		gbcBrojIndexa.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaIndeks, gbcBrojIndexa);

		GridBagConstraints gbcDatumUpisa = new GridBagConstraints();
		gbcDatumUpisa.gridx = 0;
		gbcDatumUpisa.gridy = 7;
		gbcDatumUpisa.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(labelaDatumUpisa, gbcDatumUpisa);

		GridBagConstraints gbcTekstIme = new GridBagConstraints();
		gbcTekstIme.gridx = 1;
		gbcTekstIme.gridy = 0;
		gbcTekstIme.weightx = 200;
		gbcTekstIme.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstIme.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtIme, gbcTekstIme);

		GridBagConstraints gbcTekstPrezime = new GridBagConstraints();
		gbcTekstPrezime.gridx = 1;
		gbcTekstPrezime.gridy = 1;
		gbcTekstPrezime.weightx = 200;
		gbcTekstPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstPrezime.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtPrezime, gbcTekstPrezime);

		GridBagConstraints gbcTekstDatumRodjenja = new GridBagConstraints();
		gbcTekstDatumRodjenja.gridx = 1;
		gbcTekstDatumRodjenja.gridy = 2;
		gbcTekstDatumRodjenja.weightx = 200;
		gbcTekstDatumRodjenja.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstDatumRodjenja.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtDatumRodjenja, gbcTekstDatumRodjenja);

		GridBagConstraints gbcTekstAdresa = new GridBagConstraints();
		gbcTekstAdresa.gridx = 1;
		gbcTekstAdresa.gridy = 3;
		gbcTekstAdresa.weightx = 200;
		gbcTekstAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstAdresa.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtAdresa, gbcTekstAdresa);

		GridBagConstraints gbcTekstTelefon = new GridBagConstraints();
		gbcTekstTelefon.gridx = 1;
		gbcTekstTelefon.gridy = 4;
		gbcTekstTelefon.weightx = 200;
		gbcTekstTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstTelefon.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtTelefon, gbcTekstTelefon);

		GridBagConstraints gbcTekstEmail = new GridBagConstraints();
		gbcTekstEmail.gridx = 1;
		gbcTekstEmail.gridy = 5;
		gbcTekstEmail.weightx = 200;
		gbcTekstEmail.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstEmail.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtEmail, gbcTekstEmail);

		GridBagConstraints gbcTekstBrojIndeksa = new GridBagConstraints();
		gbcTekstBrojIndeksa.gridx = 1;
		gbcTekstBrojIndeksa.gridy = 6;
		gbcTekstBrojIndeksa.weightx = 200;
		gbcTekstBrojIndeksa.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstBrojIndeksa.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtIndeks, gbcTekstBrojIndeksa);

		GridBagConstraints gbcTekstDatumUpisa = new GridBagConstraints();
		gbcTekstDatumUpisa.gridx = 1;
		gbcTekstDatumUpisa.gridy = 7;
		gbcTekstDatumUpisa.weightx = 200;
		gbcTekstDatumUpisa.fill = GridBagConstraints.HORIZONTAL;
		gbcTekstDatumUpisa.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(txtDatumUpisa, gbcTekstDatumUpisa);

		GridBagConstraints gbcGodina = new GridBagConstraints();
		gbcGodina.gridx = 0;
		gbcGodina.gridy = 8;
		gbcGodina.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(lblGodina, gbcGodina);

		GridBagConstraints gbcComboBoxGodina = new GridBagConstraints();
		gbcComboBoxGodina.gridx = 1;
		gbcComboBoxGodina.gridy = 8;
		gbcComboBoxGodina.weightx = 10;
		gbcComboBoxGodina.insets = new Insets(20, 20, 0, 20);
		pan_centar.add(godinaComboBox, gbcComboBoxGodina);

		budzet.setOpaque(false);

		GridBagConstraints gbcButtonGroup = new GridBagConstraints();
		gbcButtonGroup.gridx = 0;
		gbcButtonGroup.gridy = 9;
		gbcButtonGroup.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(budzet, gbcButtonGroup);

		samofinansiranje.setOpaque(false);

		GridBagConstraints gbcButtonGroup1 = new GridBagConstraints();
		gbcButtonGroup1.gridx = 1;
		gbcButtonGroup1.gridy = 9;
		gbcButtonGroup1.insets = new Insets(20, 20, 0, 0);
		pan_centar.add(samofinansiranje, gbcButtonGroup1);

		add(pan_centar, BorderLayout.CENTER);
		add(pan_odogovr, BorderLayout.SOUTH);

		setResizable(false);

	}

	public String[] pokupiUnetiTekst() {
		String tekst[] = new String[10];
		for (int i = 0; i < tekst.length; i++) {
			tekst[i] = new String();
		}
		tekst[0] = txtIme.getText().toString();
		tekst[1] = txtPrezime.getText().toString();
		tekst[2] = txtDatumRodjenja.getText().toString();
		tekst[3] = txtAdresa.getText().toString();
		tekst[4] = txtTelefon.getText().toString();
		tekst[5] = txtEmail.getText().toString();
		tekst[6] = txtIndeks.getText().toString();
		tekst[7] = txtDatumUpisa.getText().toString();
		tekst[8] = godinaComboBox.getSelectedItem().toString();
		if (samofinansiranje.isSelected()) {
			tekst[9] = "S";
		} else {
			tekst[9] = "B";
		}

		return tekst;
	}

	protected boolean provera() {
		String tekst[] = pokupiUnetiTekst();
		boolean izlaz = true;

		if (!Pattern.matches("[a-zA-Z0-9]*", tekst[0])) {
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
		}else if(tekst[4].length() >16) {
			txtTelefon.setBackground(Color.RED);
			return false;	
		}
		if (tekst[5].length() != 0) {
			if (!Pattern.matches("^(.+)@(.+)$", tekst[5])) {
				txtEmail.setBackground(Color.RED);
				return false;
			}
		}
		if (tekst[6].length() != 0) {

			if (!Pattern.matches("[A-Z]{2,3}/[0-9]{1,3}/[0-9]{4}", tekst[6])) {
				txtIndeks.setBackground(Color.RED);
				return false;
			}
		}
		if (tekst[7].length() != 0) {
			if (!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}$", tekst[7])) {
				txtDatumUpisa.setBackground(Color.RED);
				return false;
			}
		}

		for (String t : tekst) {
			if ((t = t.trim()).length() == 0) {
				txtIme.setBackground(Color.WHITE);
				txtPrezime.setBackground(Color.WHITE);
				txtDatumRodjenja.setBackground(Color.WHITE);
				txtAdresa.setBackground(Color.WHITE);
				txtTelefon.setBackground(Color.WHITE);
				txtEmail.setBackground(Color.WHITE);
				txtIndeks.setBackground(Color.WHITE);
				txtDatumUpisa.setBackground(Color.WHITE);
				izlaz = false;
			}
		}
		txtIme.setBackground(Color.WHITE);
		txtPrezime.setBackground(Color.WHITE);
		txtDatumRodjenja.setBackground(Color.WHITE);
		txtAdresa.setBackground(Color.WHITE);
		txtTelefon.setBackground(Color.WHITE);
		txtEmail.setBackground(Color.WHITE);
		txtIndeks.setBackground(Color.WHITE);
		txtDatumUpisa.setBackground(Color.WHITE);

		return izlaz;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tekst[] = pokupiUnetiTekst();

		if (e.getActionCommand().equals("ODUSTANAK")) {
			mode = DodavanjeStudentaDialog.ODUSTANAK;
		} else {
			mode = DodavanjeStudentaDialog.POTVRDA;
			if (BazaStudenta.getInstance().getStudente().size() == 0) {
				BazaStudenta.getInstance().initStudenti(tekst[0], tekst[1], tekst[2], tekst[3], tekst[4], tekst[5],
						tekst[6], tekst[7], tekst[8], tekst[9]);
				// StudentiJTable.getInstance().refresTabelu();
			} else {
				int nesto = 0;
				for (Student p : BazaStudenta.getInstance().getStudente()) {
					if (p.getBrojIndeksa().equals(tekst[6])) {
						// JOptionPane.showMessageDialog(null, "Uneta sifra predmeta vec postoji!");
						nesto = 1;
					}
				}
				if (nesto == 0) {
					setVisible(true);
					BazaStudenta.getInstance().initStudenti(tekst[0], tekst[1], tekst[2], tekst[3], tekst[4], tekst[5],
							tekst[6], tekst[7], tekst[8], tekst[9]);
					// StudentiJTable.getInstance().refresTabelu();
				} else if (nesto == 1) {
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Student sa istim brojem indeksa vec postoji!");
					setVisible(true);
				}
			}
		}
		// StudentiJTable.getInstance().refresTabelu();
		setVisible(false);
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

}
