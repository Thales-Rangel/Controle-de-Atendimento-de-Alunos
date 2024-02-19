package GInterfaces.Admin;

import javax.swing.JPanel;

import Models.Professor;
import Sistem.Database;
import Sistem.Turma;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Interfaces.RecebemDisciplinas;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DesignarDisciplane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField selectIndex;

	/**
	 * Create the panel.
	 */
	public DesignarDisciplane(RecebemDisciplinas rd, JPanel jPanel) {
		setSize(689, 555);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 199, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JLabel selectIndexLabel = new JLabel("Selecione o Indíce");
		selectIndexLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(selectIndexLabel);
		
		selectIndex = new JTextField();
		selectIndex.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(selectIndex);
		selectIndex.setColumns(4);
		
		JButton designeDisciplaneButton = new JButton("Designar Disciplna");
		designeDisciplaneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index;
				
				try {
					index = Integer.parseInt(selectIndex.getText());
					
					if(index < 1 || index > Database.disciplanes.size()) {
						JOptionPane.showMessageDialog(null, "Indíce inválido", "Error", 0, null);
					}else {
						index--;
						
						if(rd.getClass().equals(new Turma("hjm",7).getClass())) {
							if(rd.hasDisciplane(Database.disciplanes.get(index))) {
								JOptionPane.showMessageDialog(null, "Essa disciplina já está designada a essa turma!", "Disciplina já designada", 0, null);
							}else {
								rd.addDisciplane(Database.disciplanes.get(index));
								
								JOptionPane.showMessageDialog(null, "Disciplina designada!");
								
								jPanel.removeAll();
								jPanel.setVisible(false);
								jPanel.setVisible(true);
							}
						}
						
						if(rd.getClass().equals(new Professor("hbjk", 456,"jhnk").getClass())) {
							
							if(Database.disciplanes.get(index).thereIsALimit()) {
								if(rd.hasDisciplane(Database.disciplanes.get(index))) {
									JOptionPane.showMessageDialog(null, "Essa disciplina já está designada a esse professor!", "Disciplina já designada", 0, null);
								}else {
									rd.addDisciplane(Database.disciplanes.get(index));
									
									JOptionPane.showMessageDialog(null, "Disciplina designada!");
									
									jPanel.removeAll();
									jPanel.setVisible(false);
									jPanel.setVisible(true);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Essa disciplina já está com o máximo de"+"\n"+"professores cadastrados", "Limite excedido!", 0, null);
							}
						}
					}
				}catch(Exception i){
					JOptionPane.showMessageDialog(null, "Erro ao procurar o indíce", "Error", 0, null);
				}
			}
		});
		designeDisciplaneButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(designeDisciplaneButton);
		
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Disciplinas", "Turmas", "Professores Cadastrados", "Max. Professores"
				}
			);
		
		for(int i = 0; i < Database.disciplanes.size(); i++) {
			tableModel.addRow(new Object[] {i+1, Database.disciplanes.get(i).getName(), Database.disciplanes.get(i).getSizeTurmas(), 
					Database.disciplanes.get(i).getSizeProfessors(), Database.disciplanes.get(i).getLengthProfessors()
			});
		}
		
		table = new JTable();
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JLabel questionLabel = new JLabel("Qual disciplina você quer designar?");
		questionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel.add(questionLabel);
		setLayout(groupLayout);

	}
}
