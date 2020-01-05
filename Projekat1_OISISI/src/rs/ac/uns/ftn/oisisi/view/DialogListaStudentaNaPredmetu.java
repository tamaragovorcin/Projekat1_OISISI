package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Student;

public class DialogListaStudentaNaPredmetu extends JDialog implements ActionListener{
private static final long serialVersionUID = -1986048344792559710L;
	private int mode = 1;
	public static final int NAZAD = 0;
	public static final int OBRISI = 1;
		
	private JPanel dole;
	protected JButton odustani;
	private JTable listaIndeksa;
  
	
	public DialogListaStudentaNaPredmetu(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(300,400);
		setLocationRelativeTo(parent);
	//	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		JPanel pan_odgovor = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton obrisi = new JButton("OBRISI");
		obrisi.addActionListener(this);
		JButton nazad = new JButton("NAZAD");
		nazad.addActionListener(this);
		
		pan_odgovor.add(nazad);
		pan_odgovor.add(obrisi);
		
		add(pan_odgovor, BorderLayout.SOUTH);

		setResizable(false);
		 PrikazTabele();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int predmet = PredmetiJTable.getInstance().getSelectedRow();
		int row = TabelaListaStudenata.getInstance().getSelectedRow();
		
		if (e.getActionCommand().equals("NAZAD")) {
			mode = DialogListaStudentaNaPredmetu.NAZAD;
		} else {
			mode = DialogListaStudentaNaPredmetu.OBRISI;
	
			if(row>=0 && row<BazaPredmeta.getInstance().getBroj_studenta_na_predmetu()) {
			
				BazaPredmeta.getInstance().obrisiStudentaSaPredmeta(predmet,row);
				TabelaListaStudenata.getInstance().refresujTabelu();
			}
			else {
				JOptionPane.showMessageDialog(null, "Predmet nije selektovan");
			}
			}
		setVisible(false);
	}
	
	
		
		
	private void PrikazTabele() {
		listaIndeksa =  TabelaListaStudenata.getInstance();
		
		JScrollPane scrol =  new JScrollPane(listaIndeksa);
		add(scrol, BorderLayout.CENTER);
		TabelaListaStudenata.getInstance().refresujTabelu();
		
		
	}
	

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
}
