package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.SoftwareController;
import model.Brush;
import model.Render;
import model.Software;
import model.SoftwareLogic;

public class EditSoftwareFrame extends JDialog {
	public static List<Brush> brushes;
	public static DefaultListModel<String> brushesString;
	public static JList<String> jList;
	private static int currentRow;

	public EditSoftwareFrame() {
		currentRow = SoftwareJTable.getInstance().getSelectedRow();
		Software selectedSoftware = SoftwareController.getInstance().findSoftware((String)SoftwareJTable.getInstance().getValueAt(currentRow, 0));
		//za potrebe poredjenja naziva softvera (da li softver sa istim nazivom postoji)
		Software softwareHelper = selectedSoftware;
		brushes = new ArrayList<Brush>();
		brushesString = new DefaultListModel<String>();
		
		setTitle("Izmena podataka softvera");
		setSize(400, 500);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(MainWindow.getInstance());
		
		new BorderLayout();
		Dimension dimension  = new Dimension(150,20);
		
		JPanel panelName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelName = new JLabel("Naziv: ");
		labelName.setPreferredSize(dimension);
		JTextField textName = new JTextField();
		textName.setPreferredSize(dimension);
		textName.setName("naziv");
		panelName.add(labelName);
		panelName.add(textName);
		
		JPanel panelFormat = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelFormat = new JLabel("Format: ");
		labelFormat.setPreferredSize(dimension);
		String[] formatOptions = {".format1", ".format2", ".format3"};
		JComboBox<String> formatComboBox = new JComboBox<String>(formatOptions);
		formatComboBox.setPreferredSize(dimension);
		panelFormat.add(labelFormat);
		panelFormat.add(formatComboBox);
		
		JPanel panelAnimationTools = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelAnimationTools = new JLabel("Alati za animaciju: ");
		labelAnimationTools.setPreferredSize(dimension);
		JTextField textAnimationTools = new JTextField();
		textAnimationTools.setPreferredSize(dimension);
		textAnimationTools.setName("alati");
		panelAnimationTools.add(labelAnimationTools);
		panelAnimationTools.add(textAnimationTools);
		
		JPanel panelRender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelRender = new JLabel("Format: ");
		labelRender.setPreferredSize(dimension);
		List<Render> renders = SoftwareLogic.getInstance().getRenders();
		String[] renderOptions = new String[renders.size()];
		int i = 0;
		for(Render r : renders) {
			renderOptions[i] = r.getName();
			i++;
		}
		JComboBox<String> renderComboBox = new JComboBox<String>(renderOptions);
		renderComboBox.setPreferredSize(dimension);
		panelRender.add(labelRender);
		panelRender.add(renderComboBox);
		
		JPanel brushPanel = new JPanel();
		brushPanel.setPreferredSize(new Dimension(370,50));
		brushPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addBrush = new JButton("Dodaj cetkicu");
		JButton removeBrush = new JButton("Ukloni cetkicu");
		brushPanel.add(addBrush);
		brushPanel.add(removeBrush);
		
		addBrush.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddBrushListFrame addBrushListFrame = new AddBrushListFrame(true);
				addBrushListFrame.setVisible(true);
			}
		});
		
		removeBrush.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jList.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Oznacite cetkicu koji zelite da obrisete!","",JOptionPane.ERROR_MESSAGE);
				}else {
					int option = JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Dodavanje ",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {

						for(Brush brush: brushes) {
							if(brush.getName().equals(jList.getSelectedValue())){
									brushes.remove(brush);
									brushesString.removeElement(brush.getName());
									break;
							}
						}
					}					
				}	
			}

		});
		
		//popunjavanje inputa podacima
		textName.setText(selectedSoftware.getName());
		formatComboBox.setSelectedItem(selectedSoftware.getFileFormat());
		textAnimationTools.setText(selectedSoftware.getAnimationTools());
		renderComboBox.setSelectedItem(selectedSoftware.getRender().getName());
		brushes = selectedSoftware.getBrushes();
		
		for(Brush b : brushes) {
			brushesString.addElement(b.getName());
		}
 		jList = new JList<String>(brushesString);
		jList.setPreferredSize(new Dimension(200,200));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jList);
		scrollPane.createVerticalScrollBar();
		
		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton accept = new JButton("Potvrdi");
		JButton cancel = new JButton("Odustani");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}	
		});
		
		accept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean exists = false;
				for(Software software : SoftwareLogic.getInstance().getSoftwares()) {
					//postoji softver sa tim imenom i to ime nije ime od softvera kojeg pokusavamo da editujemo
					if(software.getName().equals(textName.getText().trim()) && !software.getName().equals(softwareHelper.getName())) {
						exists = true;
					}
				}
				if(textName.getText().equals("") || textAnimationTools.getText().equals("") || brushes.size()==0) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva polja!","",JOptionPane.ERROR_MESSAGE);
				}else if(exists == true) {
					JOptionPane.showMessageDialog(null, "Vec postoji softver sa istim nazivom","",JOptionPane.ERROR_MESSAGE);					
				}else {
					Render render = new Render();
					for(Render r : SoftwareLogic.getInstance().getRenders()) {
						if(r.getName().equals((String)renderComboBox.getSelectedItem())) {
							render = r;
							break;
						}
					}
					Software soft = new Software(textName.getText(), brushes,(String)formatComboBox.getSelectedItem(), textAnimationTools.getText(), render);
					SoftwareController.getInstance().editSoftware(soft, softwareHelper.getName());
					setVisible(false);
				}
			}
		});
		
		lowerPanel.add(accept);
		lowerPanel.add(cancel);
		
		Box boxSoftware = Box.createVerticalBox();
		boxSoftware.add(Box.createVerticalStrut(20));
		boxSoftware.add(panelName);
		boxSoftware.add(panelFormat);
		boxSoftware.add(panelAnimationTools);
		boxSoftware.add(panelRender);
		boxSoftware.add(brushPanel);
		boxSoftware.add(scrollPane);
		boxSoftware.add(Box.createGlue());

		JPanel mainPanel = new JPanel();
		mainPanel.add(boxSoftware, BorderLayout.CENTER);
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);
		add(mainPanel);
	}
}
