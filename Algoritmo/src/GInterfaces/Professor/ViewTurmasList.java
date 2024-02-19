package GInterfaces.Professor;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.Professor;
import Sistem.Turma;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewTurmasList extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ViewTurmasList(Professor p, JPanel jPanel) {
		setSize(725, 484);
		
		JPanel acessPanel = new JPanel();
		
		JLabel selectIndexLabel = new JLabel("Selecione o índice");
		selectIndexLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		acessPanel.add(selectIndexLabel);
		
		JFormattedTextField indexSelect = new JFormattedTextField();
		indexSelect.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		indexSelect.setColumns(3);
		acessPanel.add(indexSelect);
		
		JButton acessButton = new JButton("Acessar o índice");
		acessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index;
				
				ArrayList<Turma> allTurmasP = new ArrayList<Turma>();
				
				for(int i = 0; i < p.getSizeDisciplanes(); i++) {
					for(int o = 0; o < p.getDisciplane(i).getSizeTurmas(); o++) {
						allTurmasP.add(p.getDisciplane(i).getTurma(o));
					}
				}
				
				try {
					index = Integer.parseInt(indexSelect.getText().trim());
					
					if(index < 1 || index > allTurmasP.size()) {
						JOptionPane.showMessageDialog(null, "Indíce inválido!", "Error", 0, null);
					}else {
						index--;
						
						jPanel.removeAll();
						jPanel.setVisible(false);
						jPanel.setVisible(true);
						jPanel.add(new ViewTurma(p, allTurmasP.get(index)));
					}
				}catch(Exception i) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar pegar o indíce!", "Error", 0, null);
				}
			}
		});
		acessButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		acessPanel.add(acessButton);
		
		JPanel panelLabel_1 = new JPanel();
		
		JLabel viewInfoLabel = new JLabel("Ver mais informações:");
		viewInfoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panelLabel_1.add(viewInfoLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelLabel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(acessPanel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(173)
					.addComponent(panelLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(acessPanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
		);
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Turma", "Total de estudantes", "Disciplina"
				}
			);
		
		int index = 0;
		for(int i = 0; i < p.getSizeDisciplanes(); i++) {
			for(int o = 0; o < p.getDisciplane(i).getSizeTurmas(); o++) {
				index++;
				tableModel.addRow(new Object[] {index, p.getDisciplane(i).getTurma(o).getName(), p.getDisciplane(i).getTurma(o).getSizeStudents(),
						p.getDisciplane(i).getName()});
			}
		}
		
		table = new JTable();
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}
