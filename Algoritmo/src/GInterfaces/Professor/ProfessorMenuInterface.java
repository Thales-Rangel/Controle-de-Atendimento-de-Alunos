package GInterfaces.Professor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Professor;
import Sistem.Database;
import java.awt.Toolkit;

public class ProfessorMenuInterface extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Database.exemplos();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorMenuInterface frame = new ProfessorMenuInterface(Database.professors.get(0));
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
	public ProfessorMenuInterface(Professor p) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\thale\\OneDrive\\Pictures\\IF Logo - Remove.png"));
		setTitle("Professor: "+ p.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 653);
		setLocationRelativeTo(null);

		setContentPane(new ProfessorInterface(p, this));
	}

}
