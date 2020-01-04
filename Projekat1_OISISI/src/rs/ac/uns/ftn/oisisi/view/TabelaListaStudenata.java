package rs.ac.uns.ftn.oisisi.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaListaStudenata extends JTable  {
	private static final long serialVersionUID = -3950006387990901019L;
	private static TabelaListaStudenata instance = null;
	
	public static TabelaListaStudenata getInstance() {
		if(instance==null) {
			instance=new TabelaListaStudenata();
		}
		return instance;
	}
	
	private TabelaListaStudenata() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableListaStudenataNaPredmetu());
		
		this.setRowHeight(20);
	}
	
	public void refresujTabelu () {
		AbstractTableListaStudenataNaPredmetu apt = (AbstractTableListaStudenataNaPredmetu) this.getModel();
		apt.fireTableDataChanged();
		validate();
	}
}
