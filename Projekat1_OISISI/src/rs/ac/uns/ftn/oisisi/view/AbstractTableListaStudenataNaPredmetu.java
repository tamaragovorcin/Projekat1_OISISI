package rs.ac.uns.ftn.oisisi.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;

public class AbstractTableListaStudenataNaPredmetu extends AbstractTableModel {
	private static final long serialVersionUID = -3093131892473243L;

	@Override
	public int getRowCount() {
		int selektovan = PredmetiJTable.getInstance().getSelectedRow(); // treba da se izmeni sa onim gde ti je sort
					
		return  BazaPredmeta.getInstance().getPredmete().get(selektovan).getStudenti_na_predmetu().size();
	}

	@Override
	public int getColumnCount() { 
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selektovan = PredmetiJTable.getInstance().getSelectedRow();
		Predmet p = BazaPredmeta.getInstance().getPredmete().get(selektovan);
		return p.getStudenti_na_predmetu().get(rowIndex).getBrojIndeksa();
	}
	
	public String getColumnName(int column) {

		return "Broj indeksa";
	}

}
