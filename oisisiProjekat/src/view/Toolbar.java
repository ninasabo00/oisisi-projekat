package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.SoftwareController;
import controller.StaffController;
import model.Software;

public class Toolbar extends JToolBar{

	private static final long serialVersionUID = -6204353317907193077L;

	public Toolbar() {
		JButton buttonNew = new JButton();
		buttonNew.setToolTipText("New");
		buttonNew.setIcon(new ImageIcon("images" + File.separator + "add.png"));
		buttonNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.getState() == 0) {
					AddStaffFrame addStaffFrame = new AddStaffFrame();
					addStaffFrame.setVisible(true);
				}else if(TabbedPane.getState() == 1) {
					AddSoftwareFrame addSoftwareFrame = new AddSoftwareFrame();
					addSoftwareFrame.setVisible(true);
				}		
			}	
		});
		
		JButton buttonEdit = new JButton();
		buttonEdit.setToolTipText("Edit");
		buttonEdit.setIcon(new ImageIcon("images" + File.separator + "edit.png"));
		buttonEdit.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access") //brise warning
			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.getState() == 0) {
					if(StaffJTable.getInstance().getSelectedRow() == -1) {
					    JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan zaposleni","",JOptionPane.ERROR_MESSAGE);
					}else {
						EditStaffFrame editStaffFrame = new EditStaffFrame();
						editStaffFrame.softwares = new ArrayList<Software>(); // prazni listu prilikom ucitavanja prozora kako ne bi svim zaposlenima dodao softver
						editStaffFrame.setVisible(true);
					}
					
				}else if(TabbedPane.getState() == 1) {
					if(SoftwareJTable.getInstance().getSelectedRow() == -1) {
					    JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan softver","",JOptionPane.ERROR_MESSAGE);
					}else {
						EditSoftwareFrame editSoftwareFrame = new EditSoftwareFrame();
						editSoftwareFrame.setVisible(true);
					}
				}		
			}	
		});

		JButton buttonDelete = new JButton();
		buttonDelete.setToolTipText("Delete");
		buttonDelete.setIcon(new ImageIcon("images" + File.separator + "bin.png"));
		buttonDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.getState() == 0) {
					try {
						int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete?","Brisanje zaposlenog?",JOptionPane.YES_NO_OPTION);
						if(option == JOptionPane.YES_OPTION) {
						
							int currentRow = StaffJTable.getInstance().getSelectedRow();
							String selectedJmbg = (String)StaffJTable.getInstance().getValueAt(currentRow, 2);
							StaffController.getInstance().deleteStaffMember(selectedJmbg);
						}
					}catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "Morate selektovati nekog zaposlenog!","",JOptionPane.ERROR_MESSAGE);
						System.out.println(exception.getMessage());	
					}	

				}else if(TabbedPane.getState() == 1) {
					try {
						int option =JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete?","Brisanje zaposlenog?",JOptionPane.YES_NO_OPTION);
						if(option == JOptionPane.YES_OPTION) {
						
							int currentRow = SoftwareJTable.getInstance().getSelectedRow();
							String selectedSoftwareName = (String)SoftwareJTable.getInstance().getValueAt(currentRow, 0);
							SoftwareController.getInstance().deleteSoftware(selectedSoftwareName);
						}
					}catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "Morate selektovati neki softver!","",JOptionPane.ERROR_MESSAGE);
						System.out.println(exception.getMessage());	
					}	
				}
				
			}	
				
		});
		
		add(buttonNew);
		add(buttonEdit);
		add(buttonDelete);
		
		addSeparator();
		add(Box.createHorizontalGlue());	// stavlja search bar desno
		JLabel jLabel = new JLabel("");
		jLabel.setIcon(new ImageIcon("images" + File.separator + "loupe.png"));
		JTextField searchArea = new JTextField(20);
		searchArea.setToolTipText("npr. 'marko' + Enter");
		searchArea.setPreferredSize(new Dimension(200,25));
		searchArea.setMaximumSize(searchArea.getPreferredSize());
		searchArea.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.getState() == 0) {
					StaffController.getInstance().searchStaff(searchArea.getText());
					
				}else if(TabbedPane.getState() == 1) {

				}
			}			
		});
		add(searchArea);	
		add(jLabel);
		addSeparator();

	}
}
