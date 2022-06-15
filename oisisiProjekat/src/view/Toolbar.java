package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import controller.StaffController;
import model.Software;

public class Toolbar extends JToolBar{

	private static final long serialVersionUID = -6204353317907193077L;

	public Toolbar() {
		JButton buttonNew = new JButton();
		buttonNew.setToolTipText("New");
		buttonNew.setIcon(new ImageIcon("images" + File.separator + "add.jpg"));
		buttonNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.getState() == 0) {
					AddStaffFrame addStaffFrame = new AddStaffFrame();
					addStaffFrame.setVisible(true);
				}else if(TabbedPane.getState() == 1) {

				}		
			}	
		});
		
		JButton buttonEdit = new JButton();
		buttonEdit.setToolTipText("Edit");
		buttonEdit.setIcon(new ImageIcon("images" + File.separator + "edit.jpg"));
		buttonEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.getState() == 0) {
					if(StaffJTable.getInstance().getSelectedRow() == -1) {
					    JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan zaposleni","",JOptionPane.ERROR_MESSAGE);
						}else {
							EditStaffFrame editStaffFrame = new EditStaffFrame();
							editStaffFrame.softwares = new ArrayList<Software>();
							editStaffFrame.setVisible(true);
						}
					
				}else if(TabbedPane.getState() == 1) {
					
				}		
			}	
		});

		JButton buttonDelete = new JButton();
		buttonDelete.setToolTipText("Delete");
		buttonDelete.setIcon(new ImageIcon("images" + File.separator + "delete1.jpg"));
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
					System.out.println("Nema jos ovog brisanja");
				}
				
			}	
				
		});
		
		add(buttonNew);
		add(buttonEdit);
		add(buttonDelete);

	}
}
