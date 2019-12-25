package rs.ac.uns.ftn.oisisi.view;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	
	private static final long serialVersionUID = -3879401383396843796L;
	
	private ProfesoriTablePanel profesoriTable = new ProfesoriTablePanel();	
	private PredmetiTablePanel predmetiTable = new PredmetiTablePanel();
	public TabbedPane() {
		addTab("Studenti", new ImageIcon("images2/study.png"),null,"");
		addTab("Predmeti", new ImageIcon("images2/book.png"),profesoriTable,"Tabela predmeta");
		addTab("Profesori", new ImageIcon("images2/teacher.png"),predmetiTable,"TabelaProfesora");
	}
}
