package view;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{
	public Toolbar() {
		JButton buttonNew = new JButton();
		buttonNew.setToolTipText("New");
		buttonNew.setIcon(new ImageIcon("images" + File.separator + "add.jpg"));
		
		JButton buttonEdit = new JButton();
		buttonEdit.setToolTipText("Edit");
		buttonEdit.setIcon(new ImageIcon("images" + File.separator + "edit.jpg"));

		JButton buttonDelete = new JButton();
		buttonDelete.setToolTipText("Delete");
		buttonDelete.setIcon(new ImageIcon("images" + File.separator + "delete1.jpg"));

		
		add(buttonNew);
		add(buttonEdit);
		add(buttonDelete);

	}
}
