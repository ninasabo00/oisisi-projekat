package view;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 7661406785264865341L;
	
	private static MainWindow instance = null;
    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }
        return instance;
    }
    
    public MainWindow() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3/4, screenHeight * 3/4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Animacija");
		
		MenuBar menu = new MenuBar();
		setJMenuBar(menu);
		
		TabbedPane tabbedpane = TabbedPane.getInstance();
		add(tabbedpane, BorderLayout.CENTER);
		
		StatusBar statusBar = new StatusBar();		
		add(statusBar, BorderLayout.SOUTH);
		
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
	
	}
}
