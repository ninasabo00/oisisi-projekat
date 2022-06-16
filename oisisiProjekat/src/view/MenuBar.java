package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import controller.SoftwareController;
import controller.StaffController;
import model.Software;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = -111659266189879540L;

	public MenuBar() {
		
		//File
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem fileNew = new JMenuItem("New", KeyEvent.VK_N); 	// fileNew.setMnemonic(KeyEvent.VK_N);
		fileNew.setIcon(new ImageIcon("images" + File.separator + "add.png"));
		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		fileNew.addActionListener(new ActionListener() {

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
		file.add(fileNew);
		
		JMenuItem fileExit = new JMenuItem("Exit" , KeyEvent.VK_X);
		fileExit.setIcon(new ImageIcon("images" + File.separator + "cancel.png"));
		fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		fileExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}	
		});
		file.add(fileExit);

		//Edit
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenuItem editEdit = new JMenuItem("Edit", KeyEvent.VK_E);
		editEdit.setIcon(new ImageIcon("images" + File.separator + "edit.png"));
		editEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editEdit.addActionListener(new ActionListener() {

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
				}				}	
		});
		edit.add(editEdit);
		
		JMenuItem editDelete = new JMenuItem("Delete", KeyEvent.VK_D);
		editDelete.setIcon(new ImageIcon("images" + File.separator + "bin.png"));
		editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		editDelete.addActionListener(new ActionListener() {

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
		edit.add(editDelete);
		
		//Help
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem helpHelp = new JMenuItem("Help", KeyEvent.VK_H);
		helpHelp.setIcon(new ImageIcon("images" + File.separator + "help.png"));
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		helpHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpFrame helpFrame = new HelpFrame();
				helpFrame.setVisible(true);		
			}	
		});
		
		JMenuItem helpAbout = new JMenuItem("About", KeyEvent.VK_A);
		helpAbout.setIcon(new ImageIcon("images" + File.separator + "about.png"));
		helpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		helpAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AboutFrame aboutFrame = new AboutFrame();
				aboutFrame.setVisible(true);		
			}	
		});
		
		help.add(helpHelp);
		help.addSeparator();
		help.add(helpAbout);

		
		add(file);
		add(edit);
		add(help);
	}
}
