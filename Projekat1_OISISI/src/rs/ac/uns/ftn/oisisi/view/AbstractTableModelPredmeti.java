package rs.ac.uns.ftn.oisisi.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;


import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;


public class AbstractTableModelPredmeti extends AbstractTableModel {


	private static final long serialVersionUID = -5798037111446621009L;
	public static String kolonaDugme = "DUGME";
	public static String kolonaCheck = "CHECK";
	
	private List<Boolean> koJeOtkacen;
	
	public AbstractTableModelPredmeti() {
		this.koJeOtkacen = new ArrayList<>();
		for (int i = 0; i < BazaPredmeta.getInstance().getPredmete().size(); i++) {
			koJeOtkacen.add(false);
		}
	}


	@Override
	public int getRowCount() {
		//return BazaPredmeta.getInstance().getPredmete().size();
		return 10;
	}

	@Override
	public int getColumnCount() {
		//return BazaPredmeta.getInstance().getColumnCount() +2;
		return BazaPredmeta.getInstance().getColumnCount();
		 
	}

	public Object getValueAt(int rowIndex, int columnIndex){
		
			return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
		
	}

	@Override
	public String getColumnName(int column) {
		if (column >= BazaPredmeta.getInstance().getColumnCount()) {
			return column == 11 ? kolonaDugme : kolonaCheck;
		}
		return BazaPredmeta.getInstance().getColumnName(column);
		
	}

	public void predmetDodat() {
		this.koJeOtkacen.add(false);
	}
	
	public void predmetUklonjen(int rowIndex) {
		this.koJeOtkacen.remove(rowIndex);
	}
	

}
