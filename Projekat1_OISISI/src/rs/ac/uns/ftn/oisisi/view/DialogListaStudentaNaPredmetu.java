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
import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;
import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;


public class DialogListaStudentaNaPredmetu extends JDialog implements ActionListener{

	private static final long serialVersionUID = -1986048344792559710L;
	
	public static final int NAZAD = 0;
	public static final int OBRISI = 1;
		
	protected JButton odustani;
	private JTable listaIndeksa;
 
	public DialogListaStudentaNaPredmetu(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(900,200);
		setLocationRelativeTo(parent);

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
		if (e.getActionCommand().equals("NAZAD")) {
			dispose();
		} else if(e.getActionCommand().equals("OBRISI")) {
			if(TabelaListaStudenata.getInstance().getSelectedRow()!=-1)  {
				int predmet =  PredmetiTablePanel.getSelektovan_red();
				int student = TabelaListaStudenata.getInstance().getSelectedRow();
				
				Predmet pred = BazaPredmeta.getInstance().getPredmete().get(predmet);
				String indeks = pred.getStudenti_na_predmetu().get(student).getBrojIndeksa();
			    
				if(student>=0 && student<BazaPredmeta.getInstance().getPredmete().get(predmet).getStudenti_na_predmetu().size()) {
					PredmetiController.getInstance().obrisiStudentaSaPredmeta(predmet,student);
					StudentiController.getInstance().obrisiPredmetKodStudenta(pred,indeks);
					
					JOptionPane.showMessageDialog(null, "Uspesno je obrisan student sa predmeta.");
					TabelaListaStudenata.getInstance().refresujTabelu();
				}
			}
			else {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Student nije selektovan.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
				setVisible(true);
			}
		}
	}
	
	private void PrikazTabele() {
		listaIndeksa =  TabelaListaStudenata.getInstance();
		JScrollPane scrol =  new JScrollPane(listaIndeksa);
		add(scrol, BorderLayout.CENTER);
		TabelaListaStudenata.getInstance().refresujTabelu();	
	}
}
