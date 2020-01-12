package rs.ac.uns.ftn.oisisi.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisisi.model.BazaPredmeta;
import rs.ac.uns.ftn.oisisi.model.Predmet;

public class AbstractTableListaStudenataNaPredmetu extends AbstractTableModel {
	private static final long serialVersionUID = -3093131892473243L;

	@Override
	public int getRowCount() {
		if (BazaPredmeta.getInstance().getPretraga().size() == 0) {
			int selektovan = PredmetiTablePanel.getSelektovan_red();
			return BazaPredmeta.getInstance().getPredmete().get(selektovan).getStudenti_na_predmetu().size();
		} else {
			int selektovan = PredmetiTablePanel.getSelektovan_red();
			return BazaPredmeta.getInstance().getPretraga().get(selektovan).getStudenti_na_predmetu().size();
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
				if (rowIndex < predmet.getStudenti_na_predmetu().size()) {
					switch (columnIndex) {
					case 0:
						return predmet.getStudenti_na_predmetu().get(rowIndex).getBrojIndeksa();
					case 1:
						return predmet.getStudenti_na_predmetu().get(rowIndex).getIme();
					case 2:
						return predmet.getStudenti_na_predmetu().get(rowIndex).getPrezime();
					default:
						break;
					}
				}
			} else {
				Predmet predmet = BazaPredmeta.getInstance().getPretraga().get(selektovan);
				if (rowIndex < predmet.getStudenti_na_predmetu().size()) {
					switch (columnIndex) {
					case 0:
						return predmet.getStudenti_na_predmetu().get(selektovan).getBrojIndeksa();
					case 1:
						return predmet.getStudenti_na_predmetu().get(rowIndex).getIme();
					case 2:
						return predmet.getStudenti_na_predmetu().get(rowIndex).getPrezime();
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
			return "Broj indeksa";
		case 1:
			return "Ime";
		case 2:
			return "Prezime";
		default:
			return null;
		}
	}

}
