package view;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPane extends JTabbedPane  {
	
	private static final long serialVersionUID = -999382837272623090L;
	private static TabbedPane instance = null;
	
	public static TabbedPane getInstance() {
		if (instance == null) {
			instance = new TabbedPane();
		}
		return instance;
	}
	
	public static int state = 0;
	
	public TabbedPane() {
		
		JLabel label = new JLabel("tabela zaposlenih");
		JLabel label2 = new JLabel("tabela softvera");
		
		JScrollPane staffScroll = new JScrollPane(label);
		JScrollPane softwareScroll = new JScrollPane(label2);

		//TODO promeniti slike
		ImageIcon staffIcon = new ImageIcon( "images" + File.separator + "about1.png");
		ImageIcon softwareIcon = new ImageIcon( "images" + File.separator + "about1.png");
		
		
		addTab("Studenti", staffIcon , staffScroll);
		addTab("Profesori", softwareIcon , softwareScroll);
		
		addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {

				state = getSelectedIndex();
				//ovde se sve azurira
			}
		});
		}
	
	public static int getState() {
		return state;
	}
}
