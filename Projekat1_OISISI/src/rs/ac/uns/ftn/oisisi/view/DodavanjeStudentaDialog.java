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
	JTextField txtAdresa=new JTextField();
	JTextField txtTelefon=new JTextField();
	JTextField txtEmail =new JTextField();
	JTextField txtIndeks=new JTextField();
	JTextField txtDatumUpisa=new JTextField();
	JComboBox<String> godinaComboBox;
	JRadioButton budzet = new JRadioButton("Budzet",true);
	JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
	ButtonGroup btnGroup1 = new ButtonGroup();
	

	public DodavanjeStudentaDialog(Main_Frame instance, String string, boolean b) {
		super(instance, string, b);
		setSize(400, 400);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Dodavanje studenta");

		Dimension dim = new Dimension(120, 20);

		JPanel pan_odogovr = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("ODUSTANAK");
		odustanak.addActionListener(this);
		JButton potvrda = new JButton("POTVRDA");
		potvrda.setEnabled(false);
		potvrda.addActionListener(this);

		pan_odogovr.add(odustanak);
		pan_odogovr.add(potvrda);

		JPanel pan_centar = new JPanel();

		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));

		
		
		
		
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
		panIme.add(labelaIme);
		panIme.add(txtIme);
	
		
		
		
		
	JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));//new FlowLayout(FlowLayout.LEFT)

		
		
		
		
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
		panPrezime.add(labelaPrezime);
		panPrezime.add(txtPrezime);
	
		
		
		
	JPanel panDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));//new FlowLayout(FlowLayout.LEFT)

		
		
		
		
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
		panDatumRodjenja.add(labelaDatum);
		panDatumRodjenja.add(txtDatumRodjenja);
		
		
		
	JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));//new FlowLayout(FlowLayout.LEFT)

		
		
		
		
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
		panAdresa.add(labelaAdresa);
		panAdresa.add(txtAdresa);
		
		
		
		
		
		
	JPanel panTelefon = new JPanel(new FlowLayout(FlowLayout.LEFT));//new FlowLayout(FlowLayout.LEFT)

		
		
		
		
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
		panTelefon.add(labelaTelefon);
		panTelefon.add(txtTelefon);
		
JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));

		
		
		
		
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
		panEmail.add(labelaEmail);
		panEmail.add(txtEmail);
	
	JPanel panIndeks = new JPanel(new FlowLayout(FlowLayout.LEFT));//new FlowLayout(FlowLayout.LEFT)

		
		
		
		
		JLabel labelaIndeks = new JLabel("Indeks*:");
		labelaIndeks.setPreferredSize(dim);

		txtIndeks.setPreferredSize(dim);
		txtIndeks.setName("txtIndeks");
		txtIndeks.setBackground(Color.CYAN);
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
		panIndeks.add(labelaIndeks);
		panIndeks.add(txtIndeks);
		
		
JPanel panDatumUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));//new FlowLayout(FlowLayout.LEFT)

		
		
		
		
		JLabel labelaDatumUpisa = new JLabel("Datum upisa*:");
		labelaIndeks.setPreferredSize(dim);

		txtDatumUpisa.setPreferredSize(dim);
		txtDatumUpisa.setName("txtDatumUpisa");
		txtDatumUpisa.setBackground(Color.CYAN);
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
		panDatumUpisa.add(labelaDatumUpisa);
		panDatumUpisa.add(txtDatumUpisa);
		
		
		
		
	

		JPanel panGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
		

		panGodina.add(lblGodina);
		panGodina.add(godinaComboBox);

		
		JPanel panBudzet = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
		
		//panBudzet.add(btnGroup1);
	  panBudzet.add(budzet);
	  panBudzet.add(samofinansiranje);
		

		btnGroup1.add(budzet);
		btnGroup1.add(samofinansiranje);
		

		
		
		pan_centar.add(panIme);
		pan_centar.add(panPrezime);
		pan_centar.add(panDatumRodjenja);
		pan_centar.add(panAdresa);
		pan_centar.add(panTelefon);
		pan_centar.add(panEmail);
		pan_centar.add(panIndeks);
		pan_centar.add(panDatumUpisa);
		pan_centar.add(panGodina);
		//pan_centar.add(panBudzet);
		pan_centar.add(budzet);
		pan_centar.add(samofinansiranje);

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
		tekst[2]=txtDatumRodjenja.getText().toString();
		tekst[3]=txtAdresa.getText().toString();
		tekst[4]=txtTelefon.getText().toString();
		tekst[5]=txtEmail.getText().toString();
		tekst[6]=txtIndeks.getText().toString();
		tekst[7]=txtDatumUpisa.getText().toString();
		tekst[8] = godinaComboBox.getSelectedItem().toString();
		if(samofinansiranje.isSelected()) {
			tekst[9]="S";}
		else {
			tekst[9]="B";}
		
	
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
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[1])) {
			txtDatumRodjenja.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[1])) {
			txtAdresa.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[1])) {
			txtTelefon.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[1])) {
			txtEmail.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[1])) {
			txtIndeks.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", tekst[1])) {
			txtDatumUpisa.setBackground(Color.RED);
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
			if(BazaStudenta.getInstance().getStudente().size()==0) {
				BazaStudenta.getInstance().initStudenti(tekst[0], tekst[1], tekst[2], tekst[3], tekst[4],tekst[5],tekst[6],tekst[7],tekst[8], tekst[9]);
				StudentiJTable.getInstance().refresTabelu();
			}
			else {
				int nesto=0;
				for(Student p: BazaStudenta.getInstance().getStudente()) {
					if(p.getBrojIndeksa().equals(tekst[6])) {
						JOptionPane.showMessageDialog(null, "Uneta sifra predmeta vec postoji!");
						nesto =1;
					}
				}
				if(nesto==0) {
					BazaStudenta.getInstance().initStudenti(tekst[0], tekst[1], tekst[2], tekst[3], tekst[4],tekst[5],tekst[6],tekst[7],tekst[8], tekst[9]);
					StudentiJTable.getInstance().refresTabelu();
				} 
				else if(nesto ==1) {
						
				}
			}
	}
		StudentiJTable.getInstance().refresTabelu();
		setVisible(false);
		}
		
	
	

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

}
