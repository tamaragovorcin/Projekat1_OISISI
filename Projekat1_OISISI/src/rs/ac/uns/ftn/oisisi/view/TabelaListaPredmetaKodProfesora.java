package rs.ac.uns.ftn.oisisi.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaListaPredmetaKodProfesora extends JTable {
	
	private static final long serialVersionUID = -5247479565785686953L;
	
	private static TabelaListaPredmetaKodProfesora instance = null;
	
	public static TabelaListaPredmetaKodProfesora getInstance() {
		if(instance==null) {
			instance=new TabelaListaPredmetaKodProfesora();
		}
		return instance;
	}
	
	private TabelaListaPredmetaKodProfesora() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableListaPredmetaKodProfesora());
		this.setRowHeight(20);
	}
	
	public void refresujTabelu () {
		AbstractTableListaPredmetaKodProfesora apt = (AbstractTableListaPredmetaKodProfesora) this.getModel();
		apt.fireTableDataChanged();
		validate();
	}
	
}
