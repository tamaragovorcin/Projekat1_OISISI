package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DialogListPredmetiKodProfesora extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 641427397276372778L;

	private JPanel dole;
	protected JButton odustani;
	private JTable listaSifriPredmeta;
	
	public DialogListPredmetiKodProfesora(Main_Frame instance, String string, boolean b) {
		super(instance, string, b);

		setLayout(new BorderLayout());
		setSize(300,400);
		setLocationRelativeTo(instance);
	//	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		 PrikazTabele();
	}

	private void PrikazTabele() {
		listaSifriPredmeta =  TabelaListaPredmetaKodProfesora.getInstance();
		
		JScrollPane scrol =  new JScrollPane(listaSifriPredmeta);
		add(scrol, BorderLayout.CENTER);
		TabelaListaPredmetaKodProfesora.getInstance().refresujTabelu();
		
	}

}
