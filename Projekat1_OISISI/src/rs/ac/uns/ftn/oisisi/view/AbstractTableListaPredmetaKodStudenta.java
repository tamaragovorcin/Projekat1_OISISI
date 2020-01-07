package rs.ac.uns.ftn.oisisi.view;

import javax.swing.table.AbstractTableModel;
import rs.ac.uns.ftn.oisisi.model.BazaStudenta;
import rs.ac.uns.ftn.oisisi.model.Student;

public class AbstractTableListaPredmetaKodStudenta extends AbstractTableModel {

	private static final long serialVersionUID = -6180134115071255846L;

	@Override
	public int getRowCount() {
		if(BazaStudenta.getInstance().getPretraga().size()==0) {
			int selektovan = StudentiTablePanel.getSelektovan_red();	
			return  BazaStudenta.getInstance().getStudente().get(selektovan).getPredmeti().size();
		}
		else {
			int selektovan = StudentiTablePanel.getSelektovan_red();
			return BazaStudenta.getInstance().getPretraga().get(selektovan).getPredmeti().size();
		}
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
		int selektovan = StudentiTablePanel.getSelektovan_red();
		Student s = BazaStudenta.getInstance().getStudente().get(selektovan);
		return s.getPredmeti().get(rowIndex).getSifra_predmeta();
	}

}
