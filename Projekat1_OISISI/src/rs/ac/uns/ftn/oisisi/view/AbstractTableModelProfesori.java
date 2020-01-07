package rs.ac.uns.ftn.oisisi.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel{

	private static final long serialVersionUID = 2995603907983526790L;
	
	private List<Boolean> koJeOtkacen;
	
	public AbstractTableModelProfesori() {
		this.koJeOtkacen = new ArrayList<>();
		for (int i = 0; i < BazaProfesora.getInstance().getProfesore().size(); i++) {
			koJeOtkacen.add(false);
		}
	}

	public int getRowCount() {
		if(BazaProfesora.getInstance().getPretraga().size()==0) {
			return BazaProfesora.getInstance().getProfesore().size();
		}
		else {
			return BazaProfesora.getInstance().getProfesore().size();
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		case 8:
			return String.class;
		case 9:
			return String.class;
		case 10:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex>=10;
	}
	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 10)
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 10) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		} 
		return null;
	}

	public void profesorDodat() {
		this.koJeOtkacen.add(false);
	}
	
	public void profesorUklonjen(int rowIndex) {
		this.koJeOtkacen.remove(rowIndex);
	}
	

}
