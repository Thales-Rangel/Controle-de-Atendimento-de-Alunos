package GInterfaces.Admin;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import Models.Student;
import Sistem.Database;

import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable disciplanesTable;
	private JTable professorsTable;

	/**
	 * Create the panel.
	 */
	public ViewStudent(Student s) {
		setSize(689, 555);
		
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel turmaPanel = new JPanel();
		turmaPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel adressPanel = new JPanel();
		adressPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel turmaLabel_1 = new JLabel((String) null);
		turmaLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		JLabel adressLabel = new JLabel(s.getAddress());
		adressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GroupLayout gl_adressPanel = new GroupLayout(adressPanel);
		gl_adressPanel.setHorizontalGroup(
			gl_adressPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_adressPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(adressLabel, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(turmaLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_adressPanel.setVerticalGroup(
			gl_adressPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_adressPanel.createSequentialGroup()
					.addGroup(gl_adressPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_adressPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(turmaLabel_1))
						.addGroup(gl_adressPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(adressLabel)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		adressPanel.setLayout(gl_adressPanel);
		
		JScrollPane scrollPaneDisciplane = new JScrollPane();
		
		JScrollPane scrollPaneProf = new JScrollPane();
		
		JButton deleteButton = new JButton("Excluir Estudante");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.students.remove(s);
				
				for(int i = 0; i < Database.turmas.size(); i++) {
					Database.turmas.get(i).removeStudent(s);
				}
				
				JOptionPane.showMessageDialog(null, "Estudante Apagado!");
				
				setVisible(false);
			}
		});
		deleteButton.setForeground(new Color(255, 255, 255));
		deleteButton.setBackground(new Color(255, 72, 72));
		deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(namePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(turmaPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
						.addComponent(adressPanel, GroupLayout.PREFERRED_SIZE, 683, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneDisciplane, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPaneProf, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(256)
							.addComponent(deleteButton)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(namePanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(turmaPanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(adressPanel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPaneDisciplane, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPaneProf, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(deleteButton)
					.addContainerGap())
		);
		
		DefaultTableModel tableModelP = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Professores:"
				}
			);
		
		for(int i = 0; i < s.getIdentClass().getSizeDisciplanes(); i++) {
			for(int o = 0; o < s.getIdentClass().getDisciplane(i).getLengthProfessors(); o++) {
				if(s.getIdentClass().getDisciplane(i).getProfessor(o) != null) {
					tableModelP.addRow(new Object[] {s.getIdentClass().getDisciplane(i).getProfessor(o).getName()});
				}
			}
		}
		
		professorsTable = new JTable();
		professorsTable.setModel(tableModelP);
		professorsTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		professorsTable.setEnabled(false);
		scrollPaneProf.setViewportView(professorsTable);
		
		DefaultTableModel tableModelD = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Disciplinas:"
				}
			);
		
		for(int i = 0; i < s.getIdentClass().getSizeDisciplanes(); i++) {
			tableModelD.addRow(new Object[] {s.getIdentClass().getDisciplane(i).getName()});
		}
		
		disciplanesTable = new JTable();
		disciplanesTable.setEnabled(false);
		disciplanesTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		disciplanesTable.setModel(tableModelD);
		scrollPaneDisciplane.setViewportView(disciplanesTable);
		
		JLabel turmaLabel = new JLabel(s.getIdentClass().getName());
		turmaLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		GroupLayout gl_turmaPanel = new GroupLayout(turmaPanel);
		gl_turmaPanel.setHorizontalGroup(
			gl_turmaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_turmaPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(turmaLabel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_turmaPanel.setVerticalGroup(
			gl_turmaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_turmaPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(turmaLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		turmaPanel.setLayout(gl_turmaPanel);
		
		JLabel nameLabel = new JLabel(s.getName() +" - "+ s.getMatriculation());
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		GroupLayout gl_namePanel = new GroupLayout(namePanel);
		gl_namePanel.setHorizontalGroup(
			gl_namePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_namePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_namePanel.setVerticalGroup(
			gl_namePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_namePanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(nameLabel)
					.addGap(4))
		);
		namePanel.setLayout(gl_namePanel);
		setLayout(groupLayout);

	}
}
