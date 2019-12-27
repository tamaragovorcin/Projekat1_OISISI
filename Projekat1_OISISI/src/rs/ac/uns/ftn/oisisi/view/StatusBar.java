package rs.ac.uns.ftn.oisisi.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel implements Runnable{

	private static final long serialVersionUID = -7863806568418316202L;

	
		private JLabel vreme;
		private Thread th;
		
		@Override
		public void run() {
			try {
				do {
					DateFormat data=new SimpleDateFormat("HH:mm dd-MM-yyyy             ");
					Calendar kalendar=Calendar.getInstance();
					vreme.setText(data.format(kalendar.getTime()));
					Thread.sleep(1000);
				}while(th.isAlive());
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		StatusBar(){
			setPreferredSize(new Dimension(100,20));
			setLayout(new BorderLayout());
			
			JLabel leva=new JLabel("             Studentska sluzba");
			add(leva,BorderLayout.WEST);
			vreme=new JLabel();
			
			
			add(vreme,BorderLayout.EAST);
			th=new Thread(this);
			th.start();
		}

}
