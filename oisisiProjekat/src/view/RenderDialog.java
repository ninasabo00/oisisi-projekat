package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.SoftwareController;
import model.Render;
import model.Software;

public class RenderDialog extends JDialog{
	public RenderDialog(int selectedRow) {
		setSize(400, 500);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(MainWindow.getInstance());
		
		String selectedSoftwareName = (String)SoftwareJTable.getInstance().getValueAt(selectedRow, 0);
		Software software = SoftwareController.getInstance().findSoftware(selectedSoftwareName);
		
		Render render = software.getRender();
		setTitle(render.getName());

		Dimension dimension = new Dimension(300, 80);
		
		JLabel materialsLabel = new JLabel("Materijali:");
		TextArea materials = new TextArea(render.getMaterials());
		JPanel materialsPanel = new JPanel();
		materials.setEditable(false);
		materials.setPreferredSize(dimension);
		materialsPanel.add(materialsLabel);
		materialsPanel.add(materials);
		
		JLabel camerasLabel = new JLabel("Kamere:");
		TextArea cameras = new TextArea(render.getCameras());
		JPanel camerasPanel = new JPanel();
		cameras.setEditable(false);
		cameras.setPreferredSize(dimension);
		camerasPanel.add(camerasLabel);
		camerasPanel.add(cameras);
		
		JLabel objectsLabel = new JLabel("Objekti:");
		TextArea objects = new TextArea(render.getObjects());
		JPanel objectsPanel = new JPanel();
		objects.setEditable(false);
		objects.setPreferredSize(dimension);
		objectsPanel.add(objectsLabel);
		objectsPanel.add(objects);
		
		
		Box boxRender = Box.createVerticalBox();
		boxRender.add(materialsPanel);
		boxRender.add(camerasPanel);
		boxRender.add(objectsPanel);
		boxRender.add(Box.createGlue());
		
		add(boxRender);
	}
}
