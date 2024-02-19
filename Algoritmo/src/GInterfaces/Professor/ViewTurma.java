package GInterfaces.Professor;

import javax.swing.JPanel;

import Sistem.Turma;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.Professor;

import javax.swing.JTextArea;
import javax.swing.UIManager;

public class ViewTurma extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ViewTurma(Professor p, Turma t) {
		setSize(689, 555);
		
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel nameLabel = new JLabel(t.getName());
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		GroupLayout gl_namePanel = new GroupLayout(namePanel);
		gl_namePanel.setHorizontalGroup(
			gl_namePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 679, Short.MAX_VALUE)
				.addGroup(gl_namePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_namePanel.setVerticalGroup(
			gl_namePanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 64, Short.MAX_VALUE)
				.addGroup(gl_namePanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(nameLabel)
					.addGap(4))
		);
		namePanel.setLayout(gl_namePanel);
		
		JPanel studentsPanel = new JPanel();
		studentsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel studentsLabel = new JLabel(t.getSizeStudents()+" Estudantes cadastrados - "+t.getLengthStudents()+" Max. Estudantes");
		studentsLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_studentsPanel = new GroupLayout(studentsPanel);
		gl_studentsPanel.setHorizontalGroup(
			gl_studentsPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 679, Short.MAX_VALUE)
				.addGroup(gl_studentsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(studentsLabel, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_studentsPanel.setVerticalGroup(
			gl_studentsPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 64, Short.MAX_VALUE)
				.addGroup(gl_studentsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(studentsLabel)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		studentsPanel.setLayout(gl_studentsPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(namePanel, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
				.addComponent(studentsPanel, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(namePanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(studentsPanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
		);
		
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Estudante", "Matr\u00EDcula", "Endereço", "Solicita\u00E7\u00F5es"
				}
			);
		
		for(int i = 0; i < t.getLengthStudents(); i++) {
			if(t.getStudent(i) != null) {
				int solicitationsCont = 0;
				
				for(int o = 0; o < t.getStudent(i).solicitations.size(); o++) {
					if(t.getStudent(i).solicitations.get(o).getRequested() == p) {
						solicitationsCont++;
					}
				}
				tableModel.addRow(new Object[] {i+1, t.getStudent(i).getName(), t.getStudent(i).getMatriculation(),
						t.getStudent(i).getAddress(), solicitationsCont});
			}
		}
		
		table = new JTable();
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}
