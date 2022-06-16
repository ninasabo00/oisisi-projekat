package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Brush;
import model.SoftwareLogic;

public class AddBrushListFrame extends JDialog {
	public AddBrushListFrame(boolean isEdit) {
		setTitle("Dodavanje cetkica");
		setSize(300, 500);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		new BorderLayout();
		
		DefaultListModel<String> lista = new DefaultListModel<String>();
		List<Brush> selectedBrushes;
		if(isEdit == false) {
			selectedBrushes = AddSoftwareFrame.brushes;	
		}else {
			selectedBrushes = EditSoftwareFrame.brushes;			
		}
		List<Brush> brushesList = SoftwareLogic.getInstance().getBrushes();
		List<Brush> allBrushes = new ArrayList<Brush>(brushesList);

		for(Brush brush : selectedBrushes) {
			for(Brush brushTmp : allBrushes) {
				if(brush.getName().equals(brushTmp.getName())) {
					allBrushes.remove(brushTmp);
					break;
				}
			}
		}
		for(Brush b : allBrushes) {
			lista.addElement(b.getName());
		}
		
		JList<String> jList = new JList<String>(lista);
		jList.setPreferredSize(new Dimension(200,300));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jList);
		scrollPane.createVerticalScrollBar();
		
		JPanel lowerPanel = new JPanel();
		JButton addBrush = new JButton("Dodaj");
		JButton cancel = new JButton("Odustani");
		
		addBrush.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jList.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Oznacite cetkicu koju zelite da dodate!","",JOptionPane.ERROR_MESSAGE);
				}else {
					int option = JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Dodavanje ",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						for(Brush brush: SoftwareLogic.getInstance().getBrushes()) {
							if(brush.getName().equals(jList.getSelectedValue())){
								if(isEdit==false) {
									AddSoftwareFrame.brushes.add(brush);
									AddSoftwareFrame.brushesString.addElement(brush.getName());									
								}else {
									EditSoftwareFrame.brushes.add(brush);
									EditSoftwareFrame.brushesString.addElement(brush.getName());	
								}
								setVisible(false);
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
		lowerPanel.add(addBrush);
		lowerPanel.add(cancel);

		add(scrollPane, BorderLayout.CENTER);
		add(lowerPanel, BorderLayout.SOUTH);
	}
}
