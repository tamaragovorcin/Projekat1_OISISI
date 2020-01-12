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
import rs.ac.uns.ftn.oisisi.controller.ProfesoriController;
import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;

public class DialogListaProfesoraNaPredmetu extends JDialog implements ActionListener {

	private static final long serialVersionUID = -1986048344792559710L;

	public static final int NAZAD = 0;
	public static final int OBRISI = 1;

	protected JButton odustani;
	private JTable listaLicnihKarti;
	JButton obrisi;

	public DialogListaProfesoraNaPredmetu(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(900, 150);
		setLocationRelativeTo(parent);

		JPanel pan_odgovor = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		obrisi = new JButton("OBRISI");
		obrisi.addActionListener(this);
		JButton nazad = new JButton("NAZAD");
		nazad.addActionListener(this);

		pan_odgovor.add(nazad);
		pan_odgovor.add(obrisi);
		add(pan_odgovor, BorderLayout.SOUTH);

		setResizable(false);
		PrikazTabele();
	}

	private void PrikazTabele() {
		listaLicnihKarti = TabelaListaProfesora.getInstance();
		JScrollPane scrol = new JScrollPane(listaLicnihKarti);
		add(scrol, BorderLayout.CENTER);
		TabelaListaProfesora.getInstance().refresujTabelu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("NAZAD")) {
			dispose();
		} else if (e.getActionCommand().equals("OBRISI")) {
			if (TabelaListaProfesora.getInstance().getSelectedRow() != -1) {
				int predmet = PredmetiTablePanel.getSelektovan_red();
				int profesor = TabelaListaProfesora.getInstance().getSelectedRow();

				Predmet pred = BazaPredmeta.getInstance().getPredmete().get(predmet);
				String licna = pred.getProfesori_predavaci().get(profesor).getBroj_licne_karte();

				if (profesor >= 0 && profesor < BazaPredmeta.getInstance().getPredmete().get(predmet)
						.getProfesori_predavaci().size()) {
					PredmetiController.getInstance().obrisiProfesoraSaPredmeta(predmet, profesor);
					ProfesoriController.getInstance().obrisiPredmetKodProfesora(pred, licna);

					JOptionPane.showMessageDialog(null, "Uspesno je obrisan profesor sa liste predavaca na predmetu.");
					TabelaListaProfesora.getInstance().refresujTabelu();
				}
			} else {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Profesor nije selektovan.", "Upozorenje!",
						JOptionPane.ERROR_MESSAGE);
				setVisible(true);
			}
		}
	}
}
