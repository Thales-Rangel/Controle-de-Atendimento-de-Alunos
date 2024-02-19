package GInterfaces.Student;

import javax.swing.JPanel;

import Sistem.Disciplane;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.Student;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewDisciplane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ViewDisciplane(Student s, Disciplane d, JPanel jPanel) {
		setSize(689, 555);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel nameLabel = new JLabel(d.getName());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		GroupLayout gl_namePanel = new GroupLayout(namePanel);
		gl_namePanel.setHorizontalGroup(
			gl_namePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 683, Short.MAX_VALUE)
				.addGroup(gl_namePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
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
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
						.addComponent(namePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(namePanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(196)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		
		JButton btnCdstrSolicitation = new JButton("Fazer uma solicitação?");
		btnCdstrSolicitation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPanel.removeAll();
				jPanel.setVisible(false);
				jPanel.setVisible(true);
				jPanel.add(new CdstrSolicitation(s, jPanel));
			}
		});
		btnCdstrSolicitation.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_1.add(btnCdstrSolicitation);
		
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Professores", "Matricula", "Solicita\u00E7\u00F5es"
				}
			);
		
		for(int i = 0; i < d.getLengthProfessors(); i++) {
			if(d.getProfessor(i) != null) {
				int cont = 0;
				for(cont = 0; cont < d.getProfessor(i).solicitations.size(); cont++) {
				}
				tableModel.addRow(new Object[] {i+1, d.getProfessor(i).getName(), d.getProfessor(i).getMatriculation(), cont});
			}
		}
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		

	}
}
