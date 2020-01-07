package rs.ac.uns.ftn.oisisi.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;

public class AbstractTableListaProfesoriNaPredmetu extends AbstractTableModel {

	private static final long serialVersionUID = -3093131892473243L;

	@Override
	public int getRowCount() {
		if(BazaPredmeta.getInstance().getPretraga().size()==0) {
			int selektovan = PredmetiTablePanel.getSelektovan_red();
			return BazaPredmeta.getInstance().getPredmete().get(selektovan).getProfesori_predavaci().size();
		}
		else {
			int selektovan = PredmetiTablePanel.getSelektovan_red();
			return BazaPredmeta.getInstance().getPretraga().get(selektovan).getProfesori_predavaci().size();
		}
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selektovan =  PredmetiTablePanel.getSelektovan_red();
		if (selektovan != -1) {
			Predmet p = BazaPredmeta.getInstance().getPredmete().get(selektovan);
			return p.getProfesori_predavaci().get(rowIndex).getBroj_licne_karte();
		} else {
			return 0;
		}
	}

	public String getColumnName(int column) {
		return "Broj licne karte";
	}

}
