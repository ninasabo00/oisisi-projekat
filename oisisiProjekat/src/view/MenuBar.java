package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = -111659266189879540L;

	public MenuBar() {
		
		//File
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem fileNew = new JMenuItem("New", KeyEvent.VK_N); 	// fileNew.setMnemonic(KeyEvent.VK_N);
		fileNew.setIcon(new ImageIcon("images" + File.separator + "add.jpg"));
		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		fileNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("fileNew");		
			}	
		});
		file.add(fileNew);
		
		JMenuItem fileExit = new JMenuItem("Exit" , KeyEvent.VK_X);
		fileExit.setIcon(new ImageIcon("images" + File.separator + "close.jpg"));
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
		editEdit.setIcon(new ImageIcon("images" + File.separator + "edit.jpg"));
		editEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("editEdit");		
			}	
		});
		edit.add(editEdit);
		
		JMenuItem editDelete = new JMenuItem("Delete", KeyEvent.VK_D);
		editDelete.setIcon(new ImageIcon("images" + File.separator + "delete1.jpg"));
		editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		editDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("editDelete");		
			}	
		});
		edit.add(editDelete);
		
		//Help
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem helpHelp = new JMenuItem("Help", KeyEvent.VK_H);
		helpHelp.setIcon(new ImageIcon("images" + File.separator + "help1.png"));
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		helpHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpFrame helpFrame = new HelpFrame();
				helpFrame.setVisible(true);		
			}	
		});
		
		JMenuItem helpAbout = new JMenuItem("About", KeyEvent.VK_A);
		helpAbout.setIcon(new ImageIcon("images" + File.separator + "about1.png"));
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
