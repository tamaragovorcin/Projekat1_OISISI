package rs.ac.uns.ftn.oisisi.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rs.ac.uns.ftn.oisisi.view.MenuBar;
import rs.ac.uns.ftn.oisisi.view.TabbedPane;
import rs.ac.uns.ftn.oisisi.view.Toolbar;

public class TabbedPaneListener implements ChangeListener {

	@SuppressWarnings("static-access")
	@Override
	public void stateChanged(ChangeEvent e) {
		TabbedPane tabbed_pane = (TabbedPane) e.getSource();
		Toolbar tool = Toolbar.getInstance();
		tabbed_pane.setPritisnutTab(tabbed_pane.getSelectedIndex());
		tool.promena(tool.getDugme(tabbed_pane.getSelectedIndex()));
		MenuBar.getInstance().PromenaDugmica(tabbed_pane.getSelectedIndex());
	}

}
