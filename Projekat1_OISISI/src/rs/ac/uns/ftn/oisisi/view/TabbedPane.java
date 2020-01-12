package rs.ac.uns.ftn.oisisi.view;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = -3879401383396843796L;

	private static TabbedPane instance = null;
	public static int pritisnutTab = 0;

	public static TabbedPane getInstance() {
		if (instance == null) {
			instance = new TabbedPane();
		}
		return instance;
	}

	private ProfesoriTablePanel profesoriTable = new ProfesoriTablePanel();
	private PredmetiTablePanel predmetiTable = new PredmetiTablePanel();
	private StudentiTablePanel studentiTable = new StudentiTablePanel();

	public TabbedPane() {
		addTab("Studenti", new ImageIcon("images2/student.png"), studentiTable, "Tabela studenata");
		addTab("Predmeti", new ImageIcon("images2/subject.png"), predmetiTable, "Tabela predmeta");
		addTab("Profesori", new ImageIcon("images2/profesor.png"), profesoriTable, "Tabela profesora");
	}

	public static int getPritisnutTab() {
		return pritisnutTab;
	}

	public static void setPritisnutTab(int pritisnutTab) {
		TabbedPane.pritisnutTab = pritisnutTab;
	}

}
