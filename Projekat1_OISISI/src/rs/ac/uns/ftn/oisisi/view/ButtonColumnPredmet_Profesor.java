package rs.ac.uns.ftn.oisisi.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonColumnPredmet_Profesor extends AbstractCellEditor
		implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = 517310325975137614L;

	private JButton renderButton;

	private JButton editorButton;

	private JTable tabela;
	private boolean isEditorActive = false;

	public ButtonColumnPredmet_Profesor(JTable tabela, int kolona) {
		this.tabela = tabela;

		this.tabela.getColumnModel().getColumn(kolona).setCellRenderer(this);

		this.tabela.getColumnModel().getColumn(kolona).setCellEditor(this);

		this.renderButton = new JButton("Profesor");
		this.editorButton = new JButton("Profesor");

		this.editorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DialogListaProfesoraNaPredmetu dialog = new DialogListaProfesoraNaPredmetu(Main_Frame.getInstance(),
						"Lista profesora", true);
				dialog.setVisible(true);
			}
		});
		this.isEditorActive = false;
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return editorButton;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return renderButton;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (tabela.isEditing() && tabela.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (isEditorActive && tabela.isEditing()) {
			tabela.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
