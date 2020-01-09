package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DialogListPredmetiKodStudenta  extends JDialog{
	
	private static final long serialVersionUID = 641427397276372778L;

	protected JButton odustani;
	private JTable listaSifriPredmeta;
	
	public DialogListPredmetiKodStudenta(Main_Frame instance, String string, boolean b) {
		super(instance, string, b);
		setLayout(new BorderLayout());
		setSize(300,200);
		setLocationRelativeTo(instance);
		PrikazTabele();
	}

	private void PrikazTabele() {
		listaSifriPredmeta =  TabelaListaPredmetaKodStudenta.getInstance();
		JScrollPane scrol =  new JScrollPane(listaSifriPredmeta);
		add(scrol, BorderLayout.CENTER);
		TabelaListaPredmetaKodStudenta.getInstance().refresujTabelu();
		
	}

}
