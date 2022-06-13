package View;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	public MenuBar() {
		
		//File
		JMenu file = new JMenu("File");
		JMenuItem fileNew = new JMenuItem("New");
		file.add(fileNew);
		JMenuItem fileClose = new JMenuItem("Close");
		file.add(fileClose);

		//Edit
		JMenu edit = new JMenu("Edit");
		JMenuItem editEdit = new JMenuItem("Edit");
		edit.add(editEdit);
		JMenuItem fileDelete = new JMenuItem("Delete");
		edit.add(fileDelete);
		
		//Help
		JMenu help = new JMenu("Help");

		
		add(file);
		add(edit);
		add(help);
	}
}
