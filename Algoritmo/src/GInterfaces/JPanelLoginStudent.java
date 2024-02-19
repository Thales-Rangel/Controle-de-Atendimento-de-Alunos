package GInterfaces;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import GInterfaces.Student.StudentMenuInterface;
import Interfaces.Authenticable;
import Models.Professor;
import Models.Student;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelLoginStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField matriculation;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public JPanelLoginStudent(ArrayList<Student> ars, Main m) {
		
		JPanel panelLogin = new JPanel();
		
		JPanel panelMatriculation = new JPanel();
		
		JPanel panelPassword = new JPanel();
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelPassword, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(panelMatriculation, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
						.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(panelMatriculation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		JLabel passwordLabel = new JLabel("Senha:");
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelPassword.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		panelPassword.add(passwordField);
		
		JLabel matriculationLabel = new JLabel("Matrícula:");
		matriculationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelMatriculation.add(matriculationLabel);
		
		matriculation = new JTextField();
		matriculation.setFont(new Font("Arial", Font.PLAIN, 20));
		panelMatriculation.add(matriculation);
		matriculation.setColumns(10);
		
		JLabel title = new JLabel("Entre com sua matrícula e senha:");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panelLogin.add(title);
		setLayout(groupLayout);
		
		JButton enterButton = new JButton("Entrar");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int matriculationInteger;
				String passwordInterger = passwordField.getText();
				
				try {
					matriculationInteger = Integer.parseInt(matriculation.getText());
					
					int cont = 0;
					for(int i = 0; i < ars.size(); i++) {
						if(ars.get(i).authencate(matriculationInteger, passwordInterger)) {
							setVisible(false);
							
							StudentMenuInterface studentInterface = new StudentMenuInterface(ars.get(i));
							studentInterface.setVisible(true);
							
							m.setVisible(false);
							break;
						} else {
							cont++;
						}
					}
					
					if(cont == ars.size()) {
						JOptionPane.showMessageDialog(null,"Não encontrado"+ "\n"+ "Verifique se os dados estão corretos");
					}
				
				}catch(NumberFormatException i) {
					JOptionPane.showMessageDialog(null, "Matrícula inválida"+ "\n"+ "Verifique se a matrícula está correta", "Erro", 0);
				}
			}
		});
		enterButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(enterButton);
		
		JButton rerturnButton = new JButton("Voltar");
		rerturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				m.setContentPane(new JPanelMain(m));
			}
		});
		rerturnButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(rerturnButton);

	}
}
