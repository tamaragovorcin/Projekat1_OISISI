package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
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
import rs.ac.uns.ftn.oisisi.model.Student;

public class IzmenaPredmetaDialog extends JDialog implements ActionListener{

	private static final long serialVersionUID = 8377505010808280172L;

	public static final int ODUSTANAK = 0; 
	public static final int POTVRDA = 1;

	JTextField txtSifra = new JTextField();
	JTextField txtNaziv = new JTextField();
	JComboBox<String> semestarComboBox;
	JComboBox<String> godinaComboBox;
	
	String godina;
	
	List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmete();
	
	private int br=0;
	private int br2 = 0;
	private int red;
	private Predmet predmet;
	public IzmenaPredmetaDialog(Main_Frame instance, String string, boolean b,int row) {
		
		super(instance, string, b);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Izmena predmeta");
		
		Predmet predmet = predmeti.get(row);
		red = row;
		
		Dimension dim = new Dimension(120, 20);
		
		JPanel pan_odogovor = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("ODUSTANAK");
		odustanak.addActionListener(this);
		JButton potvrda = new JButton("POTVRDA"); 
		potvrda.addActionListener(this);

		pan_odogovor.add(odustanak);
		pan_odogovor.add(potvrda);
		
		JPanel pan_centar = new JPanel();

		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JLabel labelaSifra = new JLabel("Sifra predmeta*:");
		labelaSifra.setPreferredSize(dim);

		txtSifra.setPreferredSize(dim);
		txtSifra.setName("txtSifra");
		txtSifra.setBackground(Color.GRAY);
		txtSifra.setText(predmet.getSifra_predmeta());
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
				if (provera()) {
					potvrda.setEnabled(true);
				} else {
					potvrda.setEnabled(false);
				}
			}
		});

		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);

		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblsemestar = new JLabel("Semestar*:");
		lblsemestar.setPreferredSize(dim);
		String semestar[] = { "    ", "1", "2","3","4","5","6","7","8"};

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

		panSemestar.add(lblsemestar);
		panSemestar.add(semestarComboBox);

		JPanel panGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodina = new JLabel("Godina*:");
		lblGodina.setPreferredSize(dim);
		String godina[] = { "     ", "1", "2", "3", "4"  };
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

		pan_centar.add(panSifra);
		pan_centar.add(panNaziv);
		pan_centar.add(panSemestar);
		pan_centar.add(panGodina);

		add(pan_centar, BorderLayout.CENTER);
		add(pan_odogovor, BorderLayout.SOUTH);
		
		Set();
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
		if (!Pattern.matches("[a-zA-Z0-9_ čČćĆžŽšŠđĐ]*", tekst[1])) {
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
			dispose();
		} else {	
			if(!predmet.getSifra_predmeta().equals(tekst[0])) { 
				for(Predmet p: predmeti) {
					if(tekst[0].equals(p.getSifra_predmeta())) {
						JOptionPane.showMessageDialog(null, "Upisan broj sifre vec postoji.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				predmet.setSifra_predmeta(tekst[0]);
				predmet.setNaziv_predmeta(tekst[1]);
				predmet.setSemestar(tekst[2]);
				predmet.setGodina_studija_izvodjenja(tekst[3]);
				PredmetiJTable.getInstance().refresTabelu();
				
				if(!godina.equals(tekst[3])) {
					predmet.getStudenti_na_predmetu().clear();
				}
			}
			else {
				predmet.setNaziv_predmeta(tekst[1]);
				predmet.setSemestar(tekst[2]);
				predmet.setGodina_studija_izvodjenja(tekst[3]);
				
				dispose();
				JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesna izmena!");
				PredmetiJTable.getInstance().refresTabelu();
				
				if(!godina.equals(tekst[3])) {
					predmet.getStudenti_na_predmetu().clear();
				}
			}
		}
		setVisible(false);
	}

	public void  Set() {
		if(BazaPredmeta.getInstance().getPretraga().size()==0) {
			predmet = BazaPredmeta.getInstance().getPredmete().get(red);
		}
		else {
			predmet = BazaPredmeta.getInstance().getPretraga().get(red);
		}
		txtSifra.setText(predmet.getSifra_predmeta());
		txtNaziv.setText(predmet.getNaziv_predmeta());	
		String a = predmet.getSemestar();
		switch(a){
			case "1":
				 br=1;
				 break;
			case "2":
				br=2;
				break;
			case "3":
				br=3;
				break;
			case "4":
				br=4;
				break;
			case "5":
				br=5;
				break;
			case "6":
				br=6;
				break;
			case "7":
				br=7;
				break;
			case "8":
				br=8;
				break;
				
			default: 
				br= 0;
		}
		semestarComboBox.setSelectedIndex(br); 
		String godina2 = predmet.getGodina_studija_izvodjenja();
		
		switch(godina2){
			case "1":
				 br2=1;
				 break;
			case "2":
				br2=2;
				break;
			case "3":
				 br2=3;
				 break;
			case "4":
				br2=4;
			
				break;
			default:
				br2 =0;
		}
		
		godinaComboBox.setSelectedIndex(br2);
		
		godina=predmet.getGodina_studija_izvodjenja();		
		
		
	
	}
	
	
}
