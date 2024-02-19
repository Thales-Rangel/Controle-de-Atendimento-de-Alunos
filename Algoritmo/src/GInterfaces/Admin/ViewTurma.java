package GInterfaces.Admin;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import Models.Student;
import Sistem.Database;
import Sistem.Turma;

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

public class ViewTurma extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable studentsTable;
	private JTable dicisplanesTable;
	private JTable profTable;

	/**
	 * Create the panel.
	 */
	public ViewTurma(Turma t, JPanel jPanel) {
		setSize(689, 555);
		
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel studentsPanel = new JPanel();
		studentsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JScrollPane scrollPaneStudents = new JScrollPane();
		
		JScrollPane scrollPaneDisciplanes = new JScrollPane();
		
		JButton deleteButton = new JButton("Excluir Turma");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.turmas.remove(t);
				
				for(int i = 0; i < t.getLengthStudents(); i++) {
					if(t.getStudent(i) != null) {
						Database.students.remove(t.getStudent(i));
					}
				}
				
				for(int i = 0; i < t.getSizeDisciplanes(); i++) {
					t.getDisciplane(i).remove(t);
				}
				
				JOptionPane.showMessageDialog(null, "Turma Apagada!");
				
				setVisible(false);
			}
		});
		deleteButton.setForeground(new Color(255, 255, 255));
		deleteButton.setBackground(new Color(255, 72, 72));
		deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JScrollPane scrollPaneProf = new JScrollPane();
		
		JButton addDisciplaneButton = new JButton("Desiguinar Disciplina");
		addDisciplaneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPanel.removeAll();
				jPanel.setVisible(false);
				jPanel.setVisible(true);
				jPanel.add(new DesignarDisciplane(t, jPanel));
			}
		});
		addDisciplaneButton.setForeground(Color.BLACK);
		addDisciplaneButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addDisciplaneButton.setBackground(Color.WHITE);
		
		JButton btnRetirarDisciplina = new JButton("Retirar Disciplina");
		btnRetirarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPanel.removeAll();
				jPanel.setVisible(false);
				jPanel.setVisible(true);
				jPanel.add(new RemoveDisciplane(t, jPanel));
			}
		});
		btnRetirarDisciplina.setForeground(Color.BLACK);
		btnRetirarDisciplina.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRetirarDisciplina.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(namePanel, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addComponent(studentsPanel, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneStudents, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(scrollPaneDisciplanes, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPaneProf, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(addDisciplaneButton, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(deleteButton)
							.addGap(18)
							.addComponent(btnRetirarDisciplina, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(namePanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(studentsPanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPaneDisciplanes, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPaneStudents, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPaneProf, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(deleteButton)
						.addComponent(addDisciplaneButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRetirarDisciplina, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		DefaultTableModel tableModelP = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Professores: "
				}
			);
		
		for(int i = 0; i < t.getSizeDisciplanes(); i++) {
			for(int o = 0; o < t.getDisciplane(i).getLengthProfessors(); o++) {
				if(t.getDisciplane(i).getProfessor(o) != null)
					tableModelP.addRow(new Object[] {t.getDisciplane(i).getProfessor(o).getName()});
			}
		}
		
		profTable = new JTable();
		profTable.setModel(tableModelP);
		profTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPaneProf.setViewportView(profTable);
		
		DefaultTableModel tableModelD = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Disciplinas:"
				}
			);
		
		for(int i = 0; i < t.getSizeDisciplanes(); i++) {
			tableModelD.addRow(new Object[] {t.getDisciplane(i).getName()});
		}
		
		dicisplanesTable = new JTable();
		dicisplanesTable.setModel(tableModelD);
		dicisplanesTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dicisplanesTable.setEnabled(false);
		scrollPaneDisciplanes.setViewportView(dicisplanesTable);
		
		DefaultTableModel tableModelS = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Estudantes:"
				}
			);
		
		for(int i = 0; i < t.getLengthStudents(); i++) {
			if(t.getStudent(i) != null) {
				tableModelS.addRow(new Object[] {t.getStudent(i).getName()});
			}
		}
		
		studentsTable = new JTable();
		studentsTable.setEnabled(false);
		studentsTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		studentsTable.setModel(tableModelS);
		scrollPaneStudents.setViewportView(studentsTable);
		
		JLabel studentsLabel = new JLabel(t.getSizeStudents()+" Estudantes cadastrados - "+ t.getLengthStudents()+" Max. Estudantes");
		studentsLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_studentsPanel = new GroupLayout(studentsPanel);
		gl_studentsPanel.setHorizontalGroup(
			gl_studentsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_studentsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(studentsLabel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_studentsPanel.setVerticalGroup(
			gl_studentsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(studentsLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		studentsPanel.setLayout(gl_studentsPanel);
		
		JLabel nameLabel = new JLabel(t.getName());
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
