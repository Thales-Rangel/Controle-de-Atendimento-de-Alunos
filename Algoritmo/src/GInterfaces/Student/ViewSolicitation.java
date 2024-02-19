package GInterfaces.Student;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import Sistem.Solicitation;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewSolicitation extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ViewSolicitation(Solicitation s) {
		setSize(689, 555);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setSize(panel_1.getWidth(), panel_1.getHeight()+10);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JScrollPane scrollPaneQuestion = new JScrollPane();
		
		JScrollPane scrollPaneResp = new JScrollPane();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
						.addComponent(scrollPaneQuestion, Alignment.LEADING))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPaneResp, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 47, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPaneQuestion, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
						.addComponent(scrollPaneResp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)))
		);
		
		JLabel lblResp = new JLabel("Resposta:");
		lblResp.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_1_1.add(lblResp);
		
		JLabel lblQuestion = new JLabel("Dúvida:");
		lblQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_2.add(lblQuestion);
		
		JTextArea txtrResp = new JTextArea();
		txtrResp.setToolTipText("");
		txtrResp.setWrapStyleWord(true);
		if(s.isAnswered()) {
			txtrResp.setText(s.getResp());
		}else {
			txtrResp.setText("pendente.");
		}
		
		txtrResp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtrResp.setLineWrap(true);
		txtrResp.setEditable(false);
		scrollPaneResp.setViewportView(txtrResp);
		
		JTextArea textAreaQuestion = new JTextArea();
		textAreaQuestion.setWrapStyleWord(true);
		textAreaQuestion.setEditable(false);
		textAreaQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textAreaQuestion.setText(s.getQuestion());
		textAreaQuestion.setLineWrap(true);
		scrollPaneQuestion.setViewportView(textAreaQuestion);
		
		JLabel lblNameProfessor = new JLabel(s.getRequested().getName());
		lblNameProfessor.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_1.add(lblNameProfessor);
		
		JLabel lblNameStudent = new JLabel(s.getRequest().getName());
		lblNameStudent.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(lblNameStudent);
		setLayout(groupLayout);
	}
}
