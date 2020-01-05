package rs.ac.uns.ftn.oisisi.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;

public class AbstractTableListaStudenataNaPredmetu extends AbstractTableModel {
	private static final long serialVersionUID = -3093131892473243L;

	@Override
	public int getRowCount() {
		int selektovan = PredmetiJTable.getInstance().getSelectedRow();

		return BazaPredmeta.getInstance().getPredmete().get(selektovan).getStudenti_na_predmetu().size();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selektovan = PredmetiJTable.getInstance().getSelectedRow();
		if (selektovan != -1) {
			Predmet p = BazaPredmeta.getInstance().getPredmete().get(selektovan);
			return p.getStudenti_na_predmetu().get(rowIndex).getBrojIndeksa();
		} else {
			return 0;
		}
	}

	public String getColumnName(int column) {

		return "Broj indeksa";
	}


}
