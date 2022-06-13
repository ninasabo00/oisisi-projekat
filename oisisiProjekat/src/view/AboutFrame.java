package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AboutFrame  extends JFrame{

	
	private static final long serialVersionUID = -4673231271643728041L;

	public AboutFrame() {
		setLocationRelativeTo(null);
		setTitle("O projektu");
		
		
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBackground(Color.DARK_GRAY);
		panel.setPreferredSize(new Dimension(100,20));
		
		TextArea text = new TextArea();
		text.setText("Ovde ce pisati neki tekst.");
		text.setEditable(false);
		
		JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				
			}
		});
		
		panelButton.add(cancel);
		
		Box paneli = Box.createVerticalBox();
		paneli.add(panelButton);
		paneli.add(panel);
		paneli.setPreferredSize(new Dimension(40,40));
		this.add(text,BorderLayout.CENTER);
		this.add(paneli,BorderLayout.SOUTH);
		setSize(800, 400);
		setLocationRelativeTo(null);

	}
}
