package rs.ac.uns.ftn.oisisi.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	private static final long serialVersionUID = -5798037111446621009L;

	private List<Boolean> koJeOtkacen;

	public AbstractTableModelPredmeti() {
		this.koJeOtkacen = new ArrayList<>();
		for (int i = 0; i < BazaPredmeta.getInstance().getPredmete().size(); i++) {
			koJeOtkacen.add(false);
		}
	}

	@Override
	public int getRowCount() {
		if (BazaPredmeta.getInstance().getPretraga().size() == 0) {
			return BazaPredmeta.getInstance().getPredmete().size();
		} else {
			return BazaPredmeta.getInstance().getPretraga().size();
		}
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 4)
			return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 4) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 4;
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
			return JButton.class;
		case 5:
			return String.class;
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}

	public void predmetDodat() {
		this.koJeOtkacen.add(false);
	}

	public void predmetUklonjen(int rowIndex) {
		this.koJeOtkacen.remove(rowIndex);
	}

}
