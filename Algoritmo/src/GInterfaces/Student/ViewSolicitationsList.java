package GInterfaces.Student;

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

import Models.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSolicitationsList extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ViewSolicitationsList(Student s, JPanel jPanel) {
		setSize(725, 484);
		
		JPanel panelLabel_1 = new JPanel();
		
		JLabel viewInfoLabel = new JLabel("Ver mais informações:");
		viewInfoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panelLabel_1.add(viewInfoLabel);
		
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
				
				try {
					index = Integer.parseInt(indexSelect.getText().trim());
					
					if(index < 1 || index > s.solicitations.size()) {
						JOptionPane.showMessageDialog(null, "Indíce inválido!", "Error", 0, null);
					}else {
						index--;
						
						jPanel.removeAll();
						jPanel.setVisible(false);
						jPanel.setVisible(true);
						jPanel.add(new ViewSolicitation(s.solicitations.get(index)));
					}
				}catch(Exception i) {
					JOptionPane.showMessageDialog(null, "Erro ao peger o indíce!", "Error: "+i, 0, null);
				}
			}
		});
		acessButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		acessPanel.add(acessButton);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelLabel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(acessPanel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(245)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(panelLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(acessPanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(172, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE))))
		);
		
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Professor", "Quest\u00E3o", "Situação"
				}
			);
		
		for(int i = 0; i < s.solicitations.size(); i++) {
			if(s.solicitations.get(i).isAnswered()) {
				tableModel.addRow(new Object[] {i+1, s.solicitations.get(i).getRequested().getName(), s.solicitations.get(i).getQuestion(), "Atendida"});
			}else {
				tableModel.addRow(new Object[] {i+1, s.solicitations.get(i).getRequested().getName(), s.solicitations.get(i).getQuestion(), "Pendente"});
			}
		}
		
		table = new JTable();
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		scrollPane.setViewportView(table);
		
		JLabel lblMySolicitations = new JLabel("Minhas Solicitações");
		lblMySolicitations.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblMySolicitations);
		setLayout(groupLayout);

	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public ViewSolicitationsList(Student s, JPanel jPanel, boolean resp) {
		setSize(725, 484);
		
		JPanel panelLabel_1 = new JPanel();
		
		JLabel viewInfoLabel = new JLabel("Ver mais informações:");
		viewInfoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panelLabel_1.add(viewInfoLabel);
		
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
				
				try {
					index = Integer.parseInt(indexSelect.getText().trim());
					
					if(resp == true) {
						if(index < 1 || index > s.respSolicitations.size()) {
							JOptionPane.showMessageDialog(null, "Indíce inválido!", "Error", 0, null);
						}else {
							index--;
							
							jPanel.removeAll();
							jPanel.setVisible(false);
							jPanel.setVisible(true);
							jPanel.add(new ViewSolicitation(s.respSolicitations.get(index)));
						}
					}else {
						if(index < 1 || index > s.notRespSolicitations.size()) {
							JOptionPane.showMessageDialog(null, "Indíce inválido!", "Error", 0, null);
						}else {
							index--;
							
							jPanel.removeAll();
							jPanel.setVisible(false);
							jPanel.setVisible(true);
							jPanel.add(new ViewSolicitation(s.notRespSolicitations.get(index)));
						}
					}
				}catch(Exception i) {
					JOptionPane.showMessageDialog(null, "Erro ao peger o indíce!", "Error: "+i, 0, null);
				}
			}
		});
		acessButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		acessPanel.add(acessButton);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelLabel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(acessPanel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(245)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(panelLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(acessPanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(172, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE))))
		);
		
		DefaultTableModel tableModel;
		
		if(resp == true) {
			tableModel = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"", "Professor", "Quest\u00E3o", "Resposta"
					}
				);
			
			for(int i = 0; i < s.respSolicitations.size(); i++) {
				tableModel.addRow(new Object[] {i+1, s.respSolicitations.get(i).getRequested().getName(),
						s.respSolicitations.get(i).getQuestion(), s.respSolicitations.get(i).getResp()});
			}
		}else {
			tableModel = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"", "Professor", "Quest\u00E3o"
					}
				);
			
			for(int i = 0; i < s.notRespSolicitations.size(); i++) {
				tableModel.addRow(new Object[] {i+1, s.notRespSolicitations.get(i).getRequested().getName(),
						s.notRespSolicitations.get(i).getQuestion()});
			}
		}
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(tableModel);
		
		if(table.getColumnCount() == 4) {
			table.getColumnModel().getColumn(0).setPreferredWidth(25);
			table.getColumnModel().getColumn(1).setPreferredWidth(250);
			table.getColumnModel().getColumn(2).setPreferredWidth(250);
			table.getColumnModel().getColumn(3).setPreferredWidth(250);
		}else {
			table.getColumnModel().getColumn(0).setPreferredWidth(25);
			table.getColumnModel().getColumn(1).setPreferredWidth(250);
			table.getColumnModel().getColumn(2).setPreferredWidth(250);
		}
		scrollPane.setViewportView(table);
		
		JLabel lblMySolicitations = new JLabel();
		if(resp == true) {
			lblMySolicitations.setText("Minhas Solicitações Atendidas");
		}else {
			lblMySolicitations.setText("Minhas Solicitações Pendentes");
		}
		lblMySolicitations.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel.add(lblMySolicitations);
		setLayout(groupLayout);
	}
}
