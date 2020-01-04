package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DialogListaStudentaNaPredmetu extends JDialog{
private static final long serialVersionUID = -1986048344792559710L;
	
	
	private JPanel dole;
	protected JButton odustani;
	private JTable listaIndeksa;
  
	
	public DialogListaStudentaNaPredmetu(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(300,400);
		setLocationRelativeTo(parent);
	//	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		 PrikazTabele();
	}
	
	
	private void PrikazTabele() {
		listaIndeksa =  TabelaListaStudenata.getInstance();
		
		JScrollPane scrol =  new JScrollPane(listaIndeksa);
		add(scrol, BorderLayout.CENTER);
		TabelaListaStudenata.getInstance().refresujTabelu();
	}
}
