package rs.ac.uns.ftn.oisisi.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;

public class AbstractTableModelStudenti  extends AbstractTableModel {
	
	private static final long serialVersionUID = 2995603907983526790L;
	public static String kolonaDugme = "DUGME";
	public static String kolonaCheck = "CHECK";
	
	
	
	private List<Boolean> koJeOtkacen;
	
	public AbstractTableModelStudenti() {
		this.koJeOtkacen = new ArrayList<>();
		for (int i = 0; i <BazaStudenta.getInstance().getStudente().size() ; i++) {
			koJeOtkacen.add(false);
		}
	}


	public int getRowCount() {
	//return BazaStudenta.getInstance().getStudente().size();
		return 20;
	}

	@Override
	public int getColumnCount() {
		//return BazaProfesora.getInstance().getColumnCount() +2;
		return BazaStudenta.getInstance().getColumnCount();
	}
	
	
	@Override
	public String getColumnName(int column) {
		if (column >= BazaStudenta.getInstance().getColumnCount()) {
			return column == 11 ? kolonaDugme : kolonaCheck;
		}
			return BazaStudenta.getInstance().getColumnName(column);
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
			return BazaStudenta.getInstance().getValueAt(rowIndex, columnIndex);
		
	}
	public void studentDodat() {
		this.koJeOtkacen.add(false);
	}
	
	public void studentUklonjen(int rowIndex) {
		this.koJeOtkacen.remove(rowIndex);
	}
	
	
}
