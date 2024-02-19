package GInterfaces.Admin;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.Professor;
import Sistem.Database;
import Sistem.Turma;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CdstTurma extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameTextField;
	private JTextField numTextField;
	private JTextField indexTextField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CdstTurma(JPanel jPanel) {
		setSize(689, 475);
		
		JPanel panel = new JPanel();
		
		JPanel cdstrTurma_1 = new JPanel();
		cdstrTurma_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel cdstrTurma_2 = new JPanel();
		cdstrTurma_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cdstrTurma_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cdstrTurma_1, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 293, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cdstrTurma_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cdstrTurma_2, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(6)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
					.addGap(6))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(172)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		
		JPanel panel_1 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1_1 = new JPanel();
		
		JLabel selectIndexLabel = new JLabel("Selecione o Indíce");
		selectIndexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectIndexLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		indexTextField = new JTextField();
		indexTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		indexTextField.setColumns(4);
		GroupLayout gl_cdstrTurma_2 = new GroupLayout(cdstrTurma_2);
		gl_cdstrTurma_2.setHorizontalGroup(
			gl_cdstrTurma_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_cdstrTurma_2.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
				.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
		);
		gl_cdstrTurma_2.setVerticalGroup(
			gl_cdstrTurma_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cdstrTurma_2.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cdstrTurma_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
		);
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addComponent(selectIndexLabel, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(56)
					.addComponent(indexTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(62)
					.addComponent(selectIndexLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(indexTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Disciplane", "Profs Cdstr", "Max. Profs"
				}
			);
		
		for(int i = 0; i < Database.disciplanes.size(); i++) {
			tableModel.addRow(new Object[] {i+1, Database.disciplanes.get(i).getName(), Database.disciplanes.get(i).getSizeProfessors(),
					Database.disciplanes.get(i).getLengthProfessors()});
		}
		
		table = new JTable();
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Designar Disciplina Previamente:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		cdstrTurma_2.setLayout(gl_cdstrTurma_2);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		nameTextField.setColumns(10);
		
		JLabel lblMaxNumber = new JLabel("Max. Estudantes:");
		lblMaxNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaxNumber.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		numTextField = new JTextField();
		numTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		numTextField.setColumns(10);
		GroupLayout gl_cdstrTurma_1 = new GroupLayout(cdstrTurma_1);
		gl_cdstrTurma_1.setHorizontalGroup(
			gl_cdstrTurma_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cdstrTurma_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cdstrTurma_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_cdstrTurma_1.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cdstrTurma_1.createSequentialGroup()
							.addComponent(lblMaxNumber, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_cdstrTurma_1.setVerticalGroup(
			gl_cdstrTurma_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cdstrTurma_1.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_cdstrTurma_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_cdstrTurma_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(numTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaxNumber))
					.addGap(3))
		);
		cdstrTurma_1.setLayout(gl_cdstrTurma_1);
		
		JLabel lblNewLabel = new JLabel("Cadastrar nova Turma:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		panel.add(lblNewLabel);
		setLayout(groupLayout);
		
		JButton btnNewButton = new JButton("Cadastrar Turma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name;
				int numMax;
				
				int index;
				try {
					name = nameTextField.getText().trim();
					numMax = Integer.parseInt(numTextField.getText().trim());
					
					Database.turmas.add(new Turma(name, numMax));
						
					if(!indexTextField.getText().equals("")) {
						
						try {
							index = Integer.parseInt(indexTextField.getText().trim());
							
							if(index < 0 || index > Database.disciplanes.size()) {
								JOptionPane.showMessageDialog(null, "Indíce inválido!", "Error", 0, null);
							}else {
								index--;
								
								Database.turmas.get(Database.turmas.size()-1).addDisciplane(Database.disciplanes.get(index));
							}
						}catch(Exception o) {
								JOptionPane.showMessageDialog(null, "Erro ao tentar pegar o indíce", "Error", 0, null);
						}
					}
					
					JOptionPane.showMessageDialog(null, "Turma Cadastrada!");
					
					jPanel.removeAll();
					jPanel.setVisible(false);
					jPanel.setVisible(true);
				}catch(Exception i) {
					JOptionPane.showMessageDialog(null, "Número de estudantes inválido", "Error", 0, null);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_3.add(btnNewButton);
		panel_2.setLayout(gl_panel_2);
		

	}
}
