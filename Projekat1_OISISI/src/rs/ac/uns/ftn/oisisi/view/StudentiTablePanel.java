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

import rs.ac.uns.ftn.oisisi.controller.PredmetiController;
import rs.ac.uns.ftn.oisisi.controller.StudentiController;

public class StudentiTablePanel extends JPanel{
	private static final long serialVersionUID = 632955195529615254L;

	private StudentiJTable studentiJTable;
	private JScrollPane scrollPane;
	public static int selektovan_red = -1;
	public StudentiTablePanel() {
		setLayout(new BorderLayout());
		setOpaque(false);
		 KreiranjeTabaleStudent();
	}
	
	private void KreiranjeTabaleStudent() {
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
			StudentiController.getInstance().ucitajStudenteTXT();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		studentiJTable = StudentiJTable.getInstance();
		scrollPane = new JScrollPane(studentiJTable);
		
		TableRowSorter<TableModel>sortiranje = new TableRowSorter<TableModel>(studentiJTable.getModel());
		studentiJTable.setRowSorter(sortiranje);
		studentiJTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				StudentiJTable tabela = (StudentiJTable) e.getComponent();
				selektovan_red=tabela.convertRowIndexToModel(tabela.getSelectedRow());
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
}
