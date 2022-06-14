package view;

import java.io.File;

import javax.swing.ImageIcon;
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
	public static StaffJTable staffJTable;
	public static SoftwareJTable softwareJTable;
	
	public TabbedPane() {
		
		staffJTable = StaffJTable.getInstance();
		softwareJTable = SoftwareJTable.getInstance();
		JScrollPane staffScroll = new JScrollPane(staffJTable);
		JScrollPane softwareScroll = new JScrollPane(softwareJTable);

		//TODO promeniti slike
		ImageIcon staffIcon = new ImageIcon( "images" + File.separator + "about1.png");
		ImageIcon softwareIcon = new ImageIcon( "images" + File.separator + "about1.png");
		
		
		addTab("Zaposleni", staffIcon , staffScroll);
		addTab("Softveri", softwareIcon , softwareScroll);
		
		addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {

				state = getSelectedIndex();
				updateStaffTable();
			}
		});
		}
	
	public static int getState() {
		return state;
	}
	
	public void updateStaffTable() {
		AbstractTableStaff model = (AbstractTableStaff)staffJTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	
}
