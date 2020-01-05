package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.sun.jdi.connect.Connector.SelectedArgument;

import rs.ac.uns.ftn.oisisi.controller.PredmetiController;


public class PredmetiTablePanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 6551445060786191977L;

	private PredmetiJTable predmetiTable;
	private JScrollPane scrollPane;
	
	public static int selektovan_red = -1;
	
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
		
		try {
			PredmetiController.getInstance().ucitajPredmeteTXT();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		predmetiTable = PredmetiJTable.getInstance();
		scrollPane = new JScrollPane(predmetiTable);
		
		TableRowSorter<TableModel>sortiranje = new TableRowSorter<TableModel>(predmetiTable.getModel());
		predmetiTable.setRowSorter(sortiranje);
		predmetiTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				PredmetiJTable tabela = (PredmetiJTable) e.getComponent();
				setSelektovan_red(tabela.convertRowIndexToModel(tabela.getSelectedRow()));
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				PredmetiJTable tabela = (PredmetiJTable) e.getComponent();
				setSelektovan_red(tabela.convertRowIndexToModel(tabela.getSelectedRow()));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		add(scrollPane,BorderLayout.CENTER);
		
		
	}
	
	public static int getSelektovan_red() {
		return selektovan_red;
	}

	public static void setSelektovan_red(int selektovan_red) {
		PredmetiTablePanel.selektovan_red = selektovan_red;
	}



	
}
