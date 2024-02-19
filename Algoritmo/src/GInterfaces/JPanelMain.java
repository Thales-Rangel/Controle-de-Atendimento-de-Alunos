package GInterfaces;

import javax.swing.JPanel;

import Sistem.Database;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelMain extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPanelMain(Main m) {
		m.setSize(500, 300);
		m.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		
		JButton adminButton = new JButton("Admin");
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				JPanelLoginAdmin newJPanelA = new JPanelLoginAdmin(Database.admins, m);
				
				m.setSize(500, 350);
				m.setLocationRelativeTo(null);
				m.setContentPane(newJPanelA);
			}
		});
		adminButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_1.add(adminButton);
		
		JButton professorButton = new JButton("Professor");
		professorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				JPanelLoginProfessor newJPanelP = new JPanelLoginProfessor(Database.professors, m);
				
				m.setSize(500, 350);
				m.setLocationRelativeTo(null);
				m.setContentPane(newJPanelP);
			}
		});
		professorButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_1.add(professorButton);
		
		JButton studentButton = new JButton("Estudante");
		studentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				JPanelLoginStudent newJPanelS = new JPanelLoginStudent(Database.students, m);
				
				m.setSize(500, 350);
				m.setLocationRelativeTo(null);
				m.setContentPane(newJPanelS);
			}
		});
		studentButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_1.add(studentButton);
		
		JLabel title = new JLabel("Quem está tentando entrar?");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setLabelFor(title);
		panel.add(title);
		setLayout(groupLayout);
		
		setVisible(true);

	}
}
