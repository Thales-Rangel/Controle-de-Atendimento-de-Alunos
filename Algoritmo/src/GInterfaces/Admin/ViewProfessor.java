package GInterfaces.Admin;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import Models.Professor;
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
import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewProfessor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable disciplanesTable;
	private JTable turmasTable;

	/**
	 * Create the panel.
	 */
	public ViewProfessor(Professor p, JPanel jPanel) {
		setSize(689, 555);
		
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel matriculationPanel = new JPanel();
		matriculationPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JScrollPane scrollPaneDisciplane = new JScrollPane();
		
		JScrollPane scrollPaneTurmas = new JScrollPane();
		
		JButton deleteButton = new JButton("Excluir Professor");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.professors.remove(p);
				
				for(int i = 0; i < Database.disciplanes.size(); i++) {
					Database.disciplanes.get(i).remove(p);
				}
				
				JOptionPane.showMessageDialog(null, "Professor Apagado!");
				
				setVisible(false);
			}
		});
		deleteButton.setForeground(new Color(255, 255, 255));
		deleteButton.setBackground(new Color(255, 72, 72));
		deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton addDisciplaneButton = new JButton("Desiguinar Disciplina");
		addDisciplaneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPanel.removeAll();
				jPanel.setVisible(false);
				jPanel.setVisible(true);
				jPanel.add(new DesignarDisciplane(p, jPanel));
			}
		});
		addDisciplaneButton.setForeground(new Color(0, 0, 0));
		addDisciplaneButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addDisciplaneButton.setBackground(new Color(255, 255, 255));
		
		JButton btnRetirarDisciplina = new JButton("Retirar Disciplina");
		btnRetirarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPanel.removeAll();
				jPanel.setVisible(false);
				jPanel.setVisible(true);
				jPanel.add(new RemoveDisciplane(p, jPanel));
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
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(namePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(matriculationPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneDisciplane, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPaneTurmas, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(addDisciplaneButton)
							.addGap(27)
							.addComponent(deleteButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRetirarDisciplina, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(namePanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(matriculationPanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPaneTurmas, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPaneDisciplane, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(addDisciplaneButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRetirarDisciplina, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(deleteButton))
							.addContainerGap())))
		);
		
		DefaultTableModel tableModelT = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Turmas:"
				}
			);
		
		for(int i = 0; i < p.getSizeDisciplanes(); i++) {
			for(int o = 0; o < p.getDisciplane(i).getSizeTurmas(); o++) {
				tableModelT.addRow(new Object[] {p.getDisciplane(i).getTurma(o).getName()});
			}
		}
		
		turmasTable = new JTable();
		turmasTable.setModel(tableModelT);
		turmasTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		turmasTable.setEnabled(false);
		scrollPaneTurmas.setViewportView(turmasTable);
		
		DefaultTableModel tableModelD = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Disciplinas:"
				}
			);
		
		for(int i = 0; i < p.getSizeDisciplanes(); i++) {
			tableModelD.addRow(new Object[] {p.getDisciplane(i).getName()});
		}
		
		disciplanesTable = new JTable();
		disciplanesTable.setEnabled(false);
		disciplanesTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		disciplanesTable.setModel(tableModelD);
		scrollPaneDisciplane.setViewportView(disciplanesTable);
		
		JLabel matriculationLabel = new JLabel(p.getMatriculation()+"");
		matriculationLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		GroupLayout gl_matriculationPanel = new GroupLayout(matriculationPanel);
		gl_matriculationPanel.setHorizontalGroup(
			gl_matriculationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_matriculationPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(matriculationLabel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_matriculationPanel.setVerticalGroup(
			gl_matriculationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_matriculationPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(matriculationLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		matriculationPanel.setLayout(gl_matriculationPanel);
		
		JLabel nameLabel = new JLabel(p.getName());
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
