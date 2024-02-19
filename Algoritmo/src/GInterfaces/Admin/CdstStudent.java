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
import Models.Student;
import Sistem.Database;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CdstStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameTextField;
	private JTextField matriculationTextField;
	private JTextField passwordTextField;
	private JTextField indexTextField;
	private JTable table;
	private JTextField adressTextField;

	/**
	 * Create the panel.
	 */
	public CdstStudent(JPanel jPanel) {
		setSize(689, 475);
		
		JPanel panel = new JPanel();
		
		JPanel cdstrStudent = new JPanel();
		cdstrStudent.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel cdstrStudent_1 = new JPanel();
		cdstrStudent_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
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
								.addComponent(cdstrStudent_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cdstrStudent, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
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
							.addComponent(cdstrStudent, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cdstrStudent_1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
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
		GroupLayout gl_cdstrStudent_1 = new GroupLayout(cdstrStudent_1);
		gl_cdstrStudent_1.setHorizontalGroup(
			gl_cdstrStudent_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_cdstrStudent_1.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
				.addGroup(gl_cdstrStudent_1.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_cdstrStudent_1.setVerticalGroup(
			gl_cdstrStudent_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cdstrStudent_1.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cdstrStudent_1.createParallelGroup(Alignment.LEADING)
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
					"", "Turma", "Estudantes Cdstr", "Max. Estudantes"
				}
			);
		
		for(int i = 0; i < Database.turmas.size(); i++) {
			tableModel.addRow(new Object[] {i+1, Database.turmas.get(i).getName(), Database.turmas.get(i).getSizeStudents(),
					Database.turmas.get(i).getLengthStudents()});
		}
		
		table = new JTable();
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Designar Turma:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		cdstrStudent_1.setLayout(gl_cdstrStudent_1);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		nameTextField.setColumns(10);
		
		JLabel lblMatriculation = new JLabel("Matrícula:");
		lblMatriculation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatriculation.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		matriculationTextField = new JTextField();
		matriculationTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		matriculationTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		passwordTextField.setColumns(10);
		
		adressTextField = new JTextField();
		adressTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		adressTextField.setColumns(10);
		
		JLabel lblAdress = new JLabel("Endereço:");
		lblAdress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdress.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GroupLayout gl_cdstrStudent = new GroupLayout(cdstrStudent);
		gl_cdstrStudent.setHorizontalGroup(
			gl_cdstrStudent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cdstrStudent.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cdstrStudent.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_cdstrStudent.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cdstrStudent.createSequentialGroup()
							.addComponent(lblMatriculation, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(matriculationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cdstrStudent.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cdstrStudent.createSequentialGroup()
							.addComponent(lblAdress, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(adressTextField, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_cdstrStudent.setVerticalGroup(
			gl_cdstrStudent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cdstrStudent.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_cdstrStudent.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_cdstrStudent.createParallelGroup(Alignment.BASELINE)
						.addComponent(matriculationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatriculation))
					.addGap(11)
					.addGroup(gl_cdstrStudent.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cdstrStudent.createParallelGroup(Alignment.LEADING)
						.addComponent(adressTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdress, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
		);
		cdstrStudent.setLayout(gl_cdstrStudent);
		
		JLabel lblNewLabel = new JLabel("Cadastrar novo Estudante:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		panel.add(lblNewLabel);
		setLayout(groupLayout);
		
		JButton btnNewButton = new JButton("Cadastrar Estudante");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name;
				int matriculation;
				String password;
				String adress;
				int index;
				
				try {
					name = nameTextField.getText().trim();
					matriculation = Integer.parseInt(matriculationTextField.getText().trim());
					password = passwordTextField.getText().trim();
					adress = adressTextField.getText().trim();
						
					if(!indexTextField.getText().equals("")) {
						
						try {
							index = Integer.parseInt(indexTextField.getText().trim());
							
							if(index < 0 || index > Database.turmas.size()) {
								JOptionPane.showMessageDialog(null, "Indíce inválido!", "Error", 0, null);
							}else {
								index--;
								
								if(Database.turmas.get(index).getIfHasLimit()) {
									Database.turmas.get(index).addStudent(new Student(name, matriculation, password, adress, Database.turmas.get(index)));
									
									JOptionPane.showMessageDialog(null, "Estudante Cadastrado!");
									
									jPanel.removeAll();
									jPanel.setVisible(false);
									jPanel.setVisible(true);
								}else {
									JOptionPane.showMessageDialog(null, "Essa turma já está com o máximo de"+"\n"+"estudantes cadastrados", "Limite excedido!", 0, null);
								}
							}
						}catch(Exception o) {
								JOptionPane.showMessageDialog(null, "Erro ao tentar pegar o indíce", "Error", 0, null);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Por favor \n Adicione uma turma para esse estudante", "Erro", 0);
					}
				}catch(Exception i) {
					JOptionPane.showMessageDialog(null, "Matrícula Inválida", "Error", 0, null);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_3.add(btnNewButton);
		panel_2.setLayout(gl_panel_2);
		

	}
}
