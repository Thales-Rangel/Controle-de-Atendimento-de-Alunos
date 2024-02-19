package GInterfaces.Student;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Models.Student;
import Sistem.Database;
import Sistem.Turma;

public class StudentMenuInterface extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Database.exemplos();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMenuInterface frame = new StudentMenuInterface(Database.students.get(0));
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
	public StudentMenuInterface(Student s) {
		setTitle("Estudante: "+ s.getName());
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\thale\\OneDrive\\Pictures\\IF Logo - Remove.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 653);
		setLocationRelativeTo(null);

		setContentPane(new StudentInterface(s, this));
	}

}
