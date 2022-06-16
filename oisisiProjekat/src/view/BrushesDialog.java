package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import controller.SoftwareController;
import model.Brush;
import model.Software;

public class BrushesDialog extends JDialog{
	public BrushesDialog(int selectedRow) {
		setTitle("Podaci o cetkicama");
		setSize(400, 500);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(MainWindow.getInstance());
		
		String selectedSoftwareName = (String)SoftwareJTable.getInstance().getValueAt(selectedRow, 0);
		Software software = SoftwareController.getInstance().findSoftware(selectedSoftwareName);
		
		List<Brush> brushes = software.getBrushes();

		String[] columnNames = {"Naziv", "Namena", "Boja"};
		
		String data[][] = new String[brushes.size()][3];
		int i = 0;
		for(Brush b : brushes) {
			data[i][0] = b.getName();
			data[i][1] = b.getPurpose();
			data[i][2] = b.getColor();
			i++;
		}
		
		JTable table = new JTable(data, columnNames) {
			@Override
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
		        Component comp = super.prepareRenderer(renderer, row, col);
		        Object value = getModel().getValueAt(row, 2);
		        if(col == 2) {
		        	comp.setBackground(Color.decode(value.toString()));
		        	return comp;
		        }
	        	comp.setBackground(Color.WHITE);

		        return comp;
		    }	
		};
	    JScrollPane scrollPane=new JScrollPane(table);    
	    add(scrollPane);
		
	}
}
