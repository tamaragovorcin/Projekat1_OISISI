package rs.ac.uns.ftn.oisisi.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;


import rs.ac.uns.ftn.oisisi.model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2995603907983526790L;
	public static String kolonaDugme = "DUGME";
	public static String kolonaCheck = "CHECK";
	
	private List<Boolean> koJeOtkacen;
	
	public AbstractTableModelProfesori() {
		this.koJeOtkacen = new ArrayList<>();
		for (int i = 0; i < BazaProfesora.getInstance().getProfesore().size(); i++) {
			koJeOtkacen.add(false);
		}
	}


	public int getRowCount() {
	//	BazaProfesora.getInstance().getProfesore().size();
		return 10;
	}

	@Override
	public int getColumnCount() {
		//return BazaProfesora.getInstance().getColumnCount() +2;
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		if (column >= BazaProfesora.getInstance().getColumnCount()) {
			return column == 11 ? kolonaDugme : kolonaCheck;
		}
			return BazaProfesora.getInstance().getColumnName(column);
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		
	}

	

}
