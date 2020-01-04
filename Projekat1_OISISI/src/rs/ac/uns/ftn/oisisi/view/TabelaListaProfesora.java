package rs.ac.uns.ftn.oisisi.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaListaProfesora extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3950006387990901019L;
	private static TabelaListaProfesora instance = null;
	
	public static TabelaListaProfesora getInstance() {
		if(instance==null) {
			instance=new TabelaListaProfesora();
		}
		return instance;
	}
	
	private TabelaListaProfesora() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableListaProfesoriNaPredmetu());
		
		this.setRowHeight(20);
	}
	
	public void refresujTabelu () {
		AbstractTableListaProfesoriNaPredmetu apt = (AbstractTableListaProfesoriNaPredmetu) this.getModel();
		apt.fireTableDataChanged();
		validate();
	}
	
}
