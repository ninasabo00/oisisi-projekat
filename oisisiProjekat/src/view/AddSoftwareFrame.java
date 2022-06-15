package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Render;
import model.SoftwareLogic;

public class AddSoftwareFrame extends JDialog {
	
	public AddSoftwareFrame() {
		setTitle("Dodavanje softvera");
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
		String[] formatOptions = {".format1", ".format2", ".format2"};
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
		
//		String[] renderOptions = {".format1", ".format2", ".format2"};
		JComboBox<String> renderComboBox = new JComboBox<String>(renderOptions);
		renderComboBox.setPreferredSize(dimension);
		panelRender.add(labelRender);
		panelRender.add(renderComboBox);
		
		Box boxSoftware = Box.createVerticalBox();
		boxSoftware.add(Box.createVerticalStrut(20));
		boxSoftware.add(panelName);
		boxSoftware.add(panelFormat);
		boxSoftware.add(panelAnimationTools);
		boxSoftware.add(panelRender);
		boxSoftware.add(Box.createGlue());

		JPanel mainPanel = new JPanel();
		mainPanel.add(boxSoftware, BorderLayout.CENTER);
		add(mainPanel);
	}
}
