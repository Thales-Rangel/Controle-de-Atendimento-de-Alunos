package GInterfaces.Admin;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import Models.Student;
import Sistem.Database;
import Sistem.Disciplane;

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

public class ViewDisciplane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable disciplanesTable;
	private JTable professorsTable;

	/**
	 * Create the panel.
	 */
	public ViewDisciplane(Disciplane d) {
		setSize(689, 555);
		
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JScrollPane scrollPaneTurmas = new JScrollPane();
		
		JScrollPane scrollPaneProf = new JScrollPane();
		
		JButton deleteButton = new JButton("Excluir Disciplina");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.disciplanes.remove(d);
				
				for(int i = 0; i < Database.turmas.size(); i++) {
					Database.turmas.get(i).removeDisciplane(d);
				}
				
				for(int i = 0; i < Database.professors.size(); i++) {
					Database.professors.get(i).removeDisciplane(d);
				}
				
				JOptionPane.showMessageDialog(null, "Disciplina Apagada!");
				
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
						.addComponent(namePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneTurmas, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPaneProf)
						.addComponent(scrollPaneTurmas, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
		
		for(int i = 0; i < d.getLengthProfessors(); i++) {
			if(d.getProfessor(i) != null) {
				tableModelP.addRow(new Object[] { d.getProfessor(i).getName()});
			}
		}
		
		professorsTable = new JTable();
		professorsTable.setModel(tableModelP);
		professorsTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		professorsTable.setEnabled(false);
		scrollPaneProf.setViewportView(professorsTable);
		
		DefaultTableModel tableModelT = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Turmas"
				}
			);
		
		for(int i = 0; i < d.getSizeTurmas(); i++) {
			tableModelT.addRow(new Object[] {d.getTurma(i).getName()});
		}
		
		disciplanesTable = new JTable();
		disciplanesTable.setEnabled(false);
		disciplanesTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		disciplanesTable.setModel(tableModelT);
		scrollPaneTurmas.setViewportView(disciplanesTable);
		
		JLabel nameLabel = new JLabel(d.getName());
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
