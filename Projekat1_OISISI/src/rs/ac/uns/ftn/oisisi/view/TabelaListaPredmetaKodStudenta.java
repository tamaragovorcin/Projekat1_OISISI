package rs.ac.uns.ftn.oisisi.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaListaPredmetaKodStudenta extends JTable{
	
	private static final long serialVersionUID = -5247479565785686953L;
	
	private static TabelaListaPredmetaKodStudenta instance = null;
	
	public static TabelaListaPredmetaKodStudenta getInstance() {
		if(instance==null) {
			instance=new TabelaListaPredmetaKodStudenta();
		}
		return instance;
	}
	
	private TabelaListaPredmetaKodStudenta() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableListaPredmetaKodStudenta());
		this.setRowHeight(20);
	}
	
	public void refresujTabelu () {
		AbstractTableListaPredmetaKodStudenta apt = (AbstractTableListaPredmetaKodStudenta) this.getModel();
		apt.fireTableDataChanged();
		validate();
	}
}
