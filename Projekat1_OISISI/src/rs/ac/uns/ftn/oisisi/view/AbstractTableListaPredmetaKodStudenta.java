package rs.ac.uns.ftn.oisisi.view;

import javax.swing.table.AbstractTableModel;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Student;

public class AbstractTableListaPredmetaKodStudenta extends AbstractTableModel {

	private static final long serialVersionUID = -6180134115071255846L;

	@Override
	public int getRowCount() {
		int selektovan = StudentiJTable.getInstance().getSelectedRow(); 
		return  BazaStudenta.getInstance().getStudente().get(selektovan).getPredmeti().size();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return "Sifra predmeta";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selektovan = StudentiJTable.getInstance().getSelectedRow();
		Student s = BazaStudenta.getInstance().getStudente().get(selektovan);
		return s.getPredmeti().get(rowIndex).getSifra_predmeta();
	}

}
