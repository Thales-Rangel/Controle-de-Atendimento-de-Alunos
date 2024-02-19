package GInterfaces.Student;

import javax.swing.JPanel;

import Models.Student;
import Sistem.Solicitation;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CdstrSolicitation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField indexSelectD;
	private JTable table;
	private JTextField indexSelectP;
	private JTable tableP;

	/**
	 * Create the panel.
	 */
	public CdstrSolicitation(Student s, JPanel jPanel) {
		setSize(689, 555);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(panel_3, 0, 0, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)))
		);
		
		JPanel panel_2_1 = new JPanel();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2_1, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		indexSelectP = new JTextField();
		indexSelectP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2_1.add(indexSelectP);
		indexSelectP.setColumns(3);
		
		JLabel lblSelectIndexP = new JLabel("Selecione o professor");
		lblSelectIndexP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2_1.add(lblSelectIndexP);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1_1 = new JPanel();
		
		JEditorPane questionArea = new JEditorPane();
		questionArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
				.addComponent(questionArea, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(questionArea, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
		);
		
		JLabel lblQuestion = new JLabel("Escreva sua dúvida aqui:");
		lblQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1_1.add(lblQuestion);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_4 = new JPanel();
		
		JLabel meme = new JLabel("");
		meme.setSize(200, 200);
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("Meme para Aluno PEOOProject.jpg"));
		} catch(IOException e){
			e.printStackTrace();
		}
		
		Image imgI = img.getScaledInstance(meme.getWidth(), meme.getHeight(), Image.SCALE_SMOOTH);
		meme.setIcon(new ImageIcon(imgI));
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(53)
							.addComponent(meme, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(meme, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnCdstrSolicitation = new JButton("Cadastrar Solicitação");
		btnCdstrSolicitation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexD;
				int indexP;
				String quest;
				
				try {
					indexD = Integer.parseInt(indexSelectD.getText().trim());
					
					if(indexD < 1 || indexD > s.getIdentClass().getSizeDisciplanes()) {
						JOptionPane.showMessageDialog(null, "Indíce da disciplina inválido!", "Error", 0, null);
					}else {
						indexD--;
						
						try {
							indexP = Integer.parseInt(indexSelectP.getText().trim());
							
							if(indexP < 1 || indexP > s.getIdentClass().getDisciplane(indexD).getSizeProfessors()) {
								JOptionPane.showMessageDialog(null, "Indíce do professor inválido!", "Error", 0, null);
							}else {
								indexP--;
								
								quest = questionArea.getText().trim();
								
								new Solicitation(s, s.getIdentClass().getDisciplane(indexD).getProfessor(indexP), quest);
								
								JOptionPane.showMessageDialog(null, "Solicitação cadastrada para o professor:\n"+ s.getIdentClass().getDisciplane(indexD).getProfessor(indexP).getName());
								
								jPanel.removeAll();
								jPanel.setVisible(false);
								jPanel.setVisible(true);
							}
						}catch(Exception i) {
							JOptionPane.showMessageDialog(null, "Erro ao pegar o indíce do professor!", "Error", 0, null);
						}
					}
				}catch(Exception i) {
					JOptionPane.showMessageDialog(null, "Erro ao pegar o indíce da disciplina!", "Error", 0, null);
				}
			}
		});
		btnCdstrSolicitation.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_4.add(btnCdstrSolicitation);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_0_1 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_0_1, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_0_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		
		DefaultTableModel tableModelD = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Disciplina", "Professores"
				}
			);
		
		for(int i = 0; i < s.getIdentClass().getSizeDisciplanes(); i++) {
			tableModelD.addRow(new Object[] {i+1, s.getIdentClass().getDisciplane(i).getName(),
					s.getIdentClass().getDisciplane(i).getSizeProfessors()});
		}
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(tableModelD);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		scrollPane.setViewportView(table);
		
		indexSelectD = new JTextField();
		indexSelectD.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		panel_0_1.add(indexSelectD);
		indexSelectD.setColumns(3);
		
		JButton btnSelectD = new JButton("Selecionar Disciplina");
		btnSelectD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int indexD;
				
				try {
					indexD = Integer.parseInt(indexSelectD.getText().trim());
					
					if(indexD < 1 || indexD > s.getIdentClass().getSizeDisciplanes()) {
						JOptionPane.showMessageDialog(null, "Indíce inválido!", "Error", 0, null);
					}else {
						indexD--;
						
						DefaultTableModel tableModelP = new DefaultTableModel(
								new Object[][] {
								},
								new String[] {
									"", "Professor", "Matr\u00EDcula"
								}
							);
						
						for(int i = 0; i < s.getIdentClass().getDisciplane(indexD).getLengthProfessors(); i++) {
							if(s.getIdentClass().getDisciplane(indexD).getProfessor(i) != null) {
								tableModelP.addRow(new Object[] {i+1, s.getIdentClass().getDisciplane(indexD).getProfessor(i).getName(),
										s.getIdentClass().getDisciplane(indexD).getProfessor(i).getMatriculation()});
							}
						}
						
						tableP = new JTable();
						tableP.setEnabled(false);
						tableP.setModel(tableModelP);
						tableP.getColumnModel().getColumn(0).setPreferredWidth(25);
						tableP.getColumnModel().getColumn(1).setPreferredWidth(250);
						tableP.getColumnModel().getColumn(2).setPreferredWidth(250);
						scrollPane_1.setViewportView(tableP);
					}
				}catch(Exception i) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar pegar o indíce!", "Error", 0, null);
				}
			}
		});
		btnSelectD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		panel_0_1.add(btnSelectD);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
