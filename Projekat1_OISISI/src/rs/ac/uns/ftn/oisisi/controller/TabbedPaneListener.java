package rs.ac.uns.ftn.oisisi.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rs.ac.uns.ftn.oisisi.view.TabbedPane;
import rs.ac.uns.ftn.oisisi.view.Toolbar;

public class TabbedPaneListener implements ChangeListener {
	
	@Override
	public void stateChanged(ChangeEvent e) {
		TabbedPane tabbed_pane = (TabbedPane) e.getSource();
		Toolbar tool = Toolbar.getInstance();
		tool.promena(tool.getDugme(tabbed_pane.getSelectedIndex()));
	}

}
