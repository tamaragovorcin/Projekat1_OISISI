package rs.ac.uns.ftn.oisisi.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;

public class AbstractTableListaProfesoriNaPredmetu extends AbstractTableModel {

	private static final long serialVersionUID = -3093131892473243L;

	@Override
	public int getRowCount() {
		if (BazaPredmeta.getInstance().getPretraga().size() == 0) {
			int selektovan = PredmetiTablePanel.getSelektovan_red();
			return BazaPredmeta.getInstance().getPredmete().get(selektovan).getProfesori_predavaci().size();
		} else {
			int selektovan = PredmetiTablePanel.getSelektovan_red();
			return BazaPredmeta.getInstance().getPretraga().get(selektovan).getProfesori_predavaci().size();
		}
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selektovan = PredmetiTablePanel.getSelektovan_red();
		if (selektovan != -1) {
			if (BazaPredmeta.getInstance().getPretraga().size() == 0) {
				Predmet predmet = BazaPredmeta.getInstance().getPredmete().get(selektovan);
				if (rowIndex < predmet.getProfesori_predavaci().size()) {
					switch (columnIndex) {
					case 0:
						return predmet.getProfesori_predavaci().get(rowIndex).getBroj_licne_karte();
					case 1:
						return predmet.getProfesori_predavaci().get(rowIndex).getIme();
					case 2:
						return predmet.getProfesori_predavaci().get(rowIndex).getPrezime();
					default:
						break;
					}
				}
			} else {
				Predmet predmet = BazaPredmeta.getInstance().getPretraga().get(selektovan);
				if (rowIndex < predmet.getProfesori_predavaci().size()) {
					switch (columnIndex) {
					case 0:
						return predmet.getProfesori_predavaci().get(selektovan).getBroj_licne_karte();
					case 1:
						return predmet.getProfesori_predavaci().get(rowIndex).getIme();
					case 2:
						return predmet.getProfesori_predavaci().get(rowIndex).getPrezime();
					default:
						break;
					}
				}
			}
		} else {
			return 0;
		}
		return null;
	}

	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Broj licne karte";
		case 1:
			return "Ime";
		case 2:
			return "Prezime";
		default:
			return null;
		}
	}

}
