package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.StaffController;
import controller.UtilityController;
import model.Address;
import model.Software;
import model.SoftwareLogic;
import model.Staff;
import model.StaffLogic;

public class EditStaffFrame extends JDialog {

	private static final long serialVersionUID = 5409168880063233233L;
	
	public static DefaultListModel<String> lista = new DefaultListModel<String>();
	public static JList<String> jList = new JList<String>(lista);
	private static int currentRow;
	public static List<Software> softwares = new ArrayList<Software>();
	public static Staff helperStaff; // pomaze pri refresofanju liste u AddSoftwareListFrame
	
	public EditStaffFrame() {
		
		//selektovani zaposleni
		currentRow = StaffJTable.getInstance().getSelectedRow();
		Staff selectedStaff = StaffController.getInstance().findStaff((String)StaffJTable.getInstance().getValueAt(currentRow, 2));
		helperStaff = selectedStaff;
		
		setTitle("Izmena podataka zaposlenog");
		setSize(400, 500);
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(MainWindow.getInstance());
		new BorderLayout();
		Dimension dimension  = new Dimension(150,20);
		
		JPanel panelName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelName = new JLabel("Ime*: ");
		labelName.setPreferredSize(dimension);
		JTextField textName = new JTextField();
		textName.setPreferredSize(dimension);
		textName.setName("ime");
		textName.setToolTipText("npr. Nikola");		
		panelName.add(labelName);
		panelName.add(textName);
		
		
		
		JPanel panelSurname = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelSurname = new JLabel("Prezime*: ");
		labelSurname.setPreferredSize(dimension);
		JTextField textSurname = new JTextField();
		textSurname.setPreferredSize(dimension);
		textSurname.setName("prezime");
		textSurname.setToolTipText("npr. Tesla");		
		panelSurname.add(labelSurname);
		panelSurname.add(textSurname);
		
		JPanel panelJmbg = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelJmbg = new JLabel("Jmbg*: ");
		labelJmbg.setPreferredSize(dimension);
		JTextField textJmbg = new JTextField();
		textJmbg.setPreferredSize(dimension);
		textJmbg.setName("tekst");
		textJmbg.setToolTipText("npr. 021123456");		
		panelJmbg.add(labelJmbg);
		panelJmbg.add(textJmbg);
		
		
		JPanel panelDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelDate = new JLabel("Datum rodjenja*: ");
		labelDate.setPreferredSize(dimension);
		JTextField textDate = new JTextField();
		textDate.setPreferredSize(dimension);
		textDate.setName("tekst");
		textDate.setToolTipText("npr. 10.07.1856.");		
		panelDate.add(labelDate);
		panelDate.add(textDate);
		
		JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelEmail = new JLabel("Email*: ");
		labelEmail.setPreferredSize(dimension);
		JTextField textEmail = new JTextField();
		textEmail.setPreferredSize(dimension);
		textEmail.setName("tekst");
		textEmail.setToolTipText("npr. NikolaTesla@gmail.com");
		panelEmail.add(labelEmail);
		panelEmail.add(textEmail);
		
		
		JPanel panelAddressNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelAddressNumber = new JLabel("Broj kuce*: ");
		labelAddressNumber.setPreferredSize(dimension);
		JTextField textAddressNumber = new JTextField();
		textAddressNumber.setPreferredSize(dimension);
		textAddressNumber.setName("tekst");
		textAddressNumber.setToolTipText("npr. 10");
		panelAddressNumber.add(labelAddressNumber);
		panelAddressNumber.add(textAddressNumber);
		
		
		JPanel panelAddressStreet = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelAddressStreet = new JLabel("Grad*: ");
		labelAddressStreet.setPreferredSize(dimension);
		JTextField textAddressStreet = new JTextField();
		textAddressStreet.setPreferredSize(dimension);
		textAddressStreet.setName("tekst");
		textAddressStreet.setToolTipText("npr. Narodnog fronta");
		panelAddressStreet.add(labelAddressStreet);
		panelAddressStreet.add(textAddressStreet);
		
		
		JPanel panelAddressCity = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelAddressCity = new JLabel("Ulica*: ");
		labelAddressCity.setPreferredSize(dimension);
		JTextField textAddressCity = new JTextField();
		textAddressCity.setPreferredSize(dimension);
		textAddressCity.setName("tekst");
		textAddressCity.setToolTipText("npr. Novi Sad");
		panelAddressCity.add(labelAddressCity);
		panelAddressCity.add(textAddressCity);
		
		
		//punjenje podacima text inpute
		DateTimeFormatter formatted = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		textName.setText(selectedStaff.getName());
	    textSurname.setText(selectedStaff.getSurname());
	    textJmbg.setText(selectedStaff.getJmbg());
	    textDate.setText(formatted.format(selectedStaff.getDateOfBirth()));
	    textAddressNumber.setText(String.valueOf(selectedStaff.getAddress().getNumber()));
	    textAddressCity.setText(selectedStaff.getAddress().getCity());
	    textAddressStreet.setText(selectedStaff.getAddress().getStreet());
	    textEmail.setText(selectedStaff.getEmail());
				
		
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
				for(Staff staff : StaffLogic.getInstance().getStaffs()) {
					if(staff.getJmbg().equals(textJmbg.getText().trim()) && !staff.getJmbg().equals(selectedStaff.getJmbg())) {
						exists = true;
					}
				}
				
				
				if(textName.getText().equals("") || textSurname.getText().equals("") || textDate.getText().equals("") || textAddressStreet.getText().equals("") || 
						textJmbg.getText().equals("") || textEmail.getText().equals("") || textAddressCity.getText().equals("") || textAddressNumber.getText().equals(""))  {
					JOptionPane.showMessageDialog(null, "Niste popunili sva polja!", "",JOptionPane.ERROR_MESSAGE);
				}else if(textName.getText().matches("[A-�][a-�]+") == false) {
						JOptionPane.showMessageDialog(null, "Ime nije dobro uneto","",JOptionPane.ERROR_MESSAGE);
				}else if(textSurname.getText().matches("[A-�][a-�]+") == false) {
					JOptionPane.showMessageDialog(null, "Prezime nije dobro uneto","",JOptionPane.ERROR_MESSAGE);	
				}else if(UtilityController.getInstance().validateDate(textDate.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Datum nije dobro unet","",JOptionPane.ERROR_MESSAGE);	
				//}else if(textAddressStreet.getText().matches("[A-�][a-�]+") == false) {
					//JOptionPane.showMessageDialog(null, "Ulica nije dobro uneto","",JOptionPane.ERROR_MESSAGE);	
				}else if(UtilityController.getInstance().isNumber(textAddressNumber.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Broj kuce nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(UtilityController.getInstance().isNumber(textJmbg.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Jmbg nije dobro unet","",JOptionPane.ERROR_MESSAGE);
				}else if(textEmail.getText().matches("[a-�A-�0-9.]+@[a-�A-�0-9.]+") == false) {
					JOptionPane.showMessageDialog(null, "Email nije dobro unet","",JOptionPane.ERROR_MESSAGE);
				//}else if(textAddressCity.getText().matches("[A-�][a-�]+") == false) {
					//JOptionPane.showMessageDialog(null, "Grad nije dobro uneto","",JOptionPane.ERROR_MESSAGE);	
				}else if(exists){
					JOptionPane.showMessageDialog(null, "Vec postoji zaposleni sa istim jmbg","",JOptionPane.ERROR_MESSAGE);
				}else {
					DateTimeFormatter formatted = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
					Address address = new Address(Integer.parseInt(textAddressNumber.getText()), textAddressStreet.getText(), textAddressCity.getText());
					Staff staff = new Staff(textName.getText(), textSurname.getText(), textJmbg.getText(), LocalDate.parse(textDate.getText(), formatted), textEmail.getText(), address);
					staff.setSoftwares(softwares);
					StaffController.getInstance().editStaff(staff, selectedStaff.getJmbg());	//saljemo i stari jmbg kako bi mogli da pronajdemo tog usera i da ga izmenimo
					setVisible(false);
				}
			}
		});
		
		lowerPanel.add(accept);
		lowerPanel.add(cancel);
		
		
		Box boxStaff = Box.createVerticalBox();
		boxStaff.add(Box.createVerticalStrut(20));
		boxStaff.add(panelName);
		boxStaff.add(panelSurname);
		boxStaff.add(panelJmbg);
		boxStaff.add(panelDate);
		boxStaff.add(panelEmail);
		boxStaff.add(panelAddressNumber);
		boxStaff.add(panelAddressStreet);
		boxStaff.add(panelAddressCity);
		boxStaff.add(Box.createGlue());
		
		JPanel staffTab = new JPanel();
		staffTab.add(boxStaff, BorderLayout.CENTER);
		staffTab.add(lowerPanel, BorderLayout.SOUTH);
		
		
		//###############TAB SOFTVERA##############	
		
		JPanel softwarePanel = new JPanel();
		softwarePanel.setPreferredSize(new Dimension(370,50));
		softwarePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton addSoftware = new JButton("Dodaj softver");
		JButton removeSoftware = new JButton("Ukloni softver");
		
		
		softwares = new ArrayList<Software>();
		softwares = selectedStaff.getSoftwares();
		//Ukoliko taj softver vise ne postoji, radnik ne sme da ga sadrzi
		ArrayList<Software> temporarySoftwares = new ArrayList<Software>(softwares);
		for(Software s : temporarySoftwares) {
			if(SoftwareLogic.getInstance().softwareExist(s.getName()) == false) {
				softwares.remove(s);
			}
		}
		lista = new DefaultListModel<String>();
		for(Software s: softwares) {
			lista.addElement(s.getName());
		}
		jList = new JList<String>(lista);
		jList.setPreferredSize(new Dimension(200,300));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jList);
		scrollPane.createVerticalScrollBar();
		
		removeSoftware.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jList.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Oznacite softver koji zelite da obrisete!","",JOptionPane.ERROR_MESSAGE);
				}else {
					int option = JOptionPane.showConfirmDialog(null,"Da li ste sigurni?","Dodavanje ",JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						softwares = selectedStaff.getSoftwares();
						for(Software software: softwares) {
							if(software.getName().equals(jList.getSelectedValue())){
									softwares.remove(software);
									lista.removeElement(software.getName());
									break;
							}
						}
					}					
				}	
			}

		});
		
		
		addSoftware.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//softwares = selectedStaff.getSoftwares();
				AddSoftwareListFrame addSoftwareListFrame = new AddSoftwareListFrame(true);
				addSoftwareListFrame.setVisible(true);
			}
		});
		
		softwarePanel.add(addSoftware);
		softwarePanel.add(removeSoftware);
		
		JPanel softwareTab = new JPanel();
		softwareTab.add(softwarePanel, BorderLayout.NORTH);
		softwareTab.add(jList, BorderLayout.CENTER);
		
		//#####################################################
		
		JTabbedPane jTabbedPane = new JTabbedPane();
		jTabbedPane.add("Informacije", staffTab);
		jTabbedPane.add("Softveri", softwareTab);
		add(jTabbedPane, BorderLayout.CENTER);
		
	}
	
}
