package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

public class StatusBar  extends JPanel {

	private static final long serialVersionUID = -8008135208076960055L;

	public StatusBar() {
		setLayout(new BorderLayout());
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JLabel label = new JLabel("OISISI ");
		DateFormat dateFormat = new SimpleDateFormat(" HH:mm dd.MM.yyyy. ");
		
		String formattedTime = dateFormat.format(Calendar.getInstance().getTime());
		JLabel timeLabel = new JLabel(formattedTime);
		
		ActionListener timerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date(System.currentTimeMillis());
				String time = dateFormat.format(date);
				timeLabel.setText(time);
			}	
		};
		
		Timer timer = new Timer(0, timerListener);
		timer.setInitialDelay(0);
		timer.start();
		
		add(label, BorderLayout.WEST);
		add(timeLabel, BorderLayout.EAST);
				
	}
}
