package GInterfaces.Professor;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.LineBorder;

import Sistem.Solicitation;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetterResp extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public SetterResp(Solicitation s, JPanel jPanel) {
		setSize(689, 555);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		
		JEditorPane writeResp = new JEditorPane();
		writeResp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(writeResp, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(writeResp, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
		);
		
		JLabel lblWriteResp = new JLabel("Escreva sua resposta:");
		lblWriteResp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(lblWriteResp);
		
		JScrollPane scrollPaneQuestion = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneQuestion, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPaneQuestion, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		
		JButton btnSetResp = new JButton("Cadastrar Resposta");
		btnSetResp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resp = writeResp.getText().trim();
				
				s.setResp(resp);
				
				JOptionPane.showMessageDialog(null, "Resposta enviada com suscesso!!");
				
				jPanel.removeAll();
				jPanel.setVisible(false);
				jPanel.setVisible(true);
			}
		});
		btnSetResp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(btnSetResp);
		
		JTextArea textAreaQuestion = new JTextArea();
		textAreaQuestion.setText(s.getQuestion());
		textAreaQuestion.setEditable(false);
		textAreaQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textAreaQuestion.setWrapStyleWord(true);
		textAreaQuestion.setLineWrap(true);
		scrollPaneQuestion.setViewportView(textAreaQuestion);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
