package GInterfaces.Student;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.Student;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewColegasList extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ViewColegasList(Student s, JPanel jPanel) {
		setSize(725, 484);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblMeme = new JLabel("Todos aqui na mesma situação:");
		lblMeme.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		JLabel meme = new JLabel("");
		meme.setSize(215, 180);
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("Meme aluno PEOOProject.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
		
		Image imgI = img.getScaledInstance(meme.getWidth(), meme.getHeight(), Image.SCALE_SMOOTH);
		meme.setIcon(new ImageIcon(imgI));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(meme, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
						.addComponent(lblMeme, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(lblMeme, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(meme, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Colega", "Matr\u00EDcula", "Endereço"
				}
			);
		
		for(int i = 0; i < s.getIdentClass().getLengthStudents(); i++) {
			if(s.getIdentClass().getStudent(i) != null && s.getIdentClass().getStudent(i+1) != null) {
				if(i >= s.getIdentClass().getIndex(s)) {
					tableModel.addRow(new Object[] {i+1, s.getIdentClass().getStudent(i+1).getName(), s.getIdentClass().getStudent(i+1).getMatriculation(), s.getIdentClass().getStudent(i+1).getAddress()});
				}else {
					tableModel.addRow(new Object[] {i+1, s.getIdentClass().getStudent(i).getName(), s.getIdentClass().getStudent(i).getMatriculation()});
				}
			}
		}
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}
