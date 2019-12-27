package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PredmetiTablePanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 6551445060786191977L;

	private PredmetiJTable predmetiTable;
	private JScrollPane scrollPane;
	
	
	
	public PredmetiTablePanel() {
		setLayout(new BorderLayout());
		setOpaque(false);
		KreiranjeTabalePredmet();
		
	}
	
	private void KreiranjeTabalePredmet() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screensize = kit.getScreenSize();
		int sirina = screensize.width;
		int visina = screensize.height;
		
		JPanel gore = new JPanel();
		JPanel dole = new JPanel();
		JPanel levo = new JPanel();
		JPanel desno = new JPanel();
		
		
		gore.setOpaque(false);
		dole.setOpaque(false);
		levo.setOpaque(false);
		desno.setOpaque(false);
		
		gore.setPreferredSize(new Dimension(sirina,visina/10));
		dole.setPreferredSize(new Dimension(sirina,visina/10));
		
		add(gore,BorderLayout.NORTH);
		add(dole,BorderLayout.SOUTH);
		add(levo,BorderLayout.WEST);
		add(desno,BorderLayout.EAST);
		
		predmetiTable = PredmetiJTable.getInstance();
		scrollPane = new JScrollPane(predmetiTable);
		
		add(scrollPane,BorderLayout.CENTER);
		
		
	}
	



	
}
