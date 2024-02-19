package GInterfaces.Admin;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import Sistem.Database;

public class ViewTurmasList extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private JFormattedTextField indexSelect;

	/**
	 * Create the panel.
	 */
	public ViewTurmasList(JPanel jPanel) {
		setSize(725, 484);

		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panelLabel_1 = new JPanel();
		
		JPanel acessPanel = new JPanel();
		
		JPanel panelLabel_2 = new JPanel();
		
		JLabel deleteLabel = new JLabel("Excluir Turma:");
		deleteLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panelLabel_2.add(deleteLabel);
		
		JPanel deletePanel = new JPanel();
		
		JLabel selectIndexLabel_1 = new JLabel("Selecione o índice");
		selectIndexLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		deletePanel.add(selectIndexLabel_1);
		
		JFormattedTextField indexSelect_1 = new JFormattedTextField();
		indexSelect_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		indexSelect_1.setColumns(3);
		deletePanel.add(indexSelect_1);
		
		JButton deleteButton = new JButton("Excluir o índice");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index;
				
				try {
					index = Integer.parseInt(indexSelect_1.getText());
					
					if(index < 1 || index > Database.turmas.size()) {
						JOptionPane.showMessageDialog(null, "Indíce inválido", "Error", 0, null);
					}else {
						index--;
						
						for(int i = 0; i < Database.turmas.get(index).getLengthStudents(); i ++) {
							if(Database.turmas.get(index).getStudent(i) != null)
								Database.students.remove(Database.turmas.get(index).getStudent(i));
						}
						
						for(int i = 0; i < Database.turmas.get(index).getSizeDisciplanes(); i++) {
							Database.turmas.get(index).getDisciplane(i).remove(Database.turmas.get(index));
						}
						
						Database.turmas.remove(index);
						
						jPanel.removeAll();
						jPanel.setVisible(false);
						jPanel.setVisible(true);
						jPanel.add(new ViewTurmasList(jPanel));
					}
					
				}catch(NumberFormatException i) {
					JOptionPane.showMessageDialog(null, "Erro ao procurar o indíce", "Error", 0, null);
				}
			}
		});
		deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		deletePanel.add(deleteButton);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelLabel_1, GroupLayout.PREFERRED_SIZE, 152, Short.MAX_VALUE)
						.addComponent(acessPanel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelLabel_2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(deletePanel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(104)
					.addComponent(panelLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(acessPanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelLabel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(deletePanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(84))
		);
		
		JLabel selectIndexLabel = new JLabel("Selecione o índice");
		selectIndexLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		acessPanel.add(selectIndexLabel);
		
		indexSelect = new JFormattedTextField();
		indexSelect.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		indexSelect.setColumns(3);
		acessPanel.add(indexSelect);
		
		JButton acessButton = new JButton("Acessar o índice");
		acessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index;
				
				try {
					index = Integer.parseInt(indexSelect.getText().trim());
					
					if(index < 1 || index > Database.turmas.size()) {
						JOptionPane.showMessageDialog(null, "Indíce Inválido", "Error", 0);
					}else {
						index--;
						jPanel.removeAll();
						jPanel.setVisible(false);
						jPanel.setVisible(true);
						jPanel.add(new ViewTurma(Database.turmas.get(index), jPanel));
					}
				}catch(NumberFormatException i) {
					JOptionPane.showMessageDialog(null, "Erro ao procurar o indíce", "Error", 0);
				}
		
			}
		});
		acessButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		acessPanel.add(acessButton);
		
		JLabel viewInfoLabel = new JLabel("Ver mais informações:");
		viewInfoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panelLabel_1.add(viewInfoLabel);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Turma", "Estudantes", "Max. Estudantes", "Disciplinas"
				}
			);
		
		for(int i = 0; i < Database.turmas.size(); i++) {
			tableModel.addRow(new Object[] {i+1, Database.turmas.get(i).getName(), Database.turmas.get(i).getSizeStudents(),
					Database.turmas.get(i).getLengthStudents(), Database.turmas.get(i).getSizeDisciplanes()
			});
		}
		
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		setLayout(groupLayout);
	}
}
