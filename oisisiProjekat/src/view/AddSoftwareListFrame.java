package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Software;
import model.SoftwareLogic;

public class AddSoftwareListFrame extends JDialog {

	private static final long serialVersionUID = -3315128639685663235L;

	public AddSoftwareListFrame(boolean isEdit) {
		
		setTitle("Dodavanje predmeta");
		setSize(300, 500);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		new BorderLayout();

		DefaultListModel<String> lista = new DefaultListModel<String>();
		ArrayList<Software> allSoftwares = new ArrayList<Software>();
		for(Software s: SoftwareLogic.getInstance().getSoftwares()) {
			allSoftwares.add(s);
		}
		
		//provera da li se poziva prozor za dodavanje ili edit
		if(!isEdit) {
			allSoftwares.removeAll(AddStaffFrame.softwares);
			for(Software s: allSoftwares) {
				lista.addElement(s.getName());
			}
		}else {
			allSoftwares.removeAll(EditStaffFrame.softwares);
			for(Software s: allSoftwares) {
				lista.addElement(s.getName());
			}
		}

		
		JList<String> jList = new JList<String>(lista);
		jList.setPreferredSize(new Dimension(200,300));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jList);
		scrollPane.createVerticalScrollBar();
		
		
		JPanel lowerPanel = new JPanel();
		JButton addSoftware = new JButton("Dodaj");
		JButton cancel = new JButton("Odustani");
		
		addSoftware.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jList.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Oznacite softver koji zelite da dodate!","",JOptionPane.ERROR_MESSAGE);
				}else {
					int option = JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Dodavanje ",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						for(Software software: SoftwareLogic.getInstance().getSoftwares()) {
							if(software.getName().equals(jList.getSelectedValue())){
								if(!isEdit) {
									AddStaffFrame.softwares.add(software);
									AddStaffFrame.lista.addElement(software.getName());
									setVisible(false);
								}else {
									EditStaffFrame.softwares.add(software);
									EditStaffFrame.lista.addElement(software.getName());
									setVisible(false);
								}				
							}
						}
					}					
				}	
			}	
		});

		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}	
		});
		lowerPanel.add(addSoftware);
		lowerPanel.add(cancel);
		
		add(scrollPane, BorderLayout.CENTER);
		add(lowerPanel, BorderLayout.SOUTH);
	}
}
