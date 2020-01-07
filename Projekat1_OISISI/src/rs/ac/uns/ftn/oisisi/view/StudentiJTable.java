package rs.ac.uns.ftn.oisisi.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentiJTable extends JTable {

	private static final long serialVersionUID = 4206039227512091130L;

	private static StudentiJTable instance = null;
	
	static public StudentiJTable getInstance() {
		if(instance == null) {
			instance = new StudentiJTable();
		}
		return instance;
	}
	
	private StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
		new ButtonColumnStudent_Predmet(this, 10);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);

		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			if(row%2 ==0) {
				c.setBackground(new Color(204, 227, 249));
			}
			else {
			c.setBackground(Color.WHITE);
			}
		}
		return c;
	}
	
	public void refresTabelu() {
		AbstractTableModelStudenti arp = (AbstractTableModelStudenti) this.getModel();
		arp.fireTableDataChanged();
		validate();
		
	}
}
