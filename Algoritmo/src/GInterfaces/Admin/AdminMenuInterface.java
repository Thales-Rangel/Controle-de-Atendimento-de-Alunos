package GInterfaces.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

public class AdminMenuInterface extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenuInterface frame = new AdminMenuInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMenuInterface() {
		setTitle("Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\thale\\OneDrive\\Pictures\\IF Logo - Remove.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 653);
		setLocationRelativeTo(null);

		setContentPane(new AdminInterface(this));
	}

}
