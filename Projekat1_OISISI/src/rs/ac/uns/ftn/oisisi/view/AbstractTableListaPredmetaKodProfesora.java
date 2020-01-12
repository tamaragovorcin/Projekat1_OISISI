package rs.ac.uns.ftn.oisisi.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaProfesora;
import rs.ac.uns.ftn.oisisi.model.Profesor;

public class AbstractTableListaPredmetaKodProfesora extends AbstractTableModel {

	private static final long serialVersionUID = -6180134115071255846L;

	@Override
	public int getRowCount() {
		if (BazaProfesora.getInstance().getPretraga().size() == 0) {
			int selektovan = ProfesoriTablePanel.getSelektovan_red();
			return BazaProfesora.getInstance().getProfesore().get(selektovan).getSpisak_predmeta().size();
		} else {
			int selektovan = ProfesoriTablePanel.getSelektovan_red();
			return BazaProfesora.getInstance().getPretraga().get(selektovan).getSpisak_predmeta().size();
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
		int selektovan = ProfesoriTablePanel.getSelektovan_red();
		Profesor p = BazaProfesora.getInstance().getProfesore().get(selektovan);
		return p.getSpisak_predmeta().get(rowIndex).getSifra_predmeta();
	}

}
