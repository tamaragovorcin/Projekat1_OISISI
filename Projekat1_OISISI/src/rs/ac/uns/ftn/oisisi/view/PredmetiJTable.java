package rs.ac.uns.ftn.oisisi.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;

public class PredmetiJTable extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7818780852556687386L;

	
	public PredmetiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		this.setRowHeight(20);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.DARK_GRAY);
		} else {
			if(row%2 ==0) {
				c.setBackground(Color.LIGHT_GRAY);
			}
			else {
			c.setBackground(Color.WHITE);
			}
		}
			
		return c;
	}
}
