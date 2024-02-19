package GInterfaces.Admin;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import GInterfaces.Main;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class AdminInterface extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AdminInterface(JFrame jf) {
		setSize(689, 475);
		
		JPanel optionsSpace = new JPanel();
		optionsSpace.setBackground(new Color(0, 128, 0));
		JPanel menuPanel = new JPanel();
		
		JPanel viewPanel = new JPanel();
		viewPanel.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(viewPanel, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
						.addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(optionsSpace, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(viewPanel, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
				.addComponent(optionsSpace, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
		);
		
		JMenuBar menuBar = new JMenuBar();
		
		
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(310, Short.MAX_VALUE))
		);
		
		JMenu studentsMenuList = new JMenu("Estudantes");
		studentsMenuList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(studentsMenuList);
		
		JMenuItem viewStudentList = new JMenuItem("Ver Estudantes");
		viewStudentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				
				viewPanel.removeAll();
				
				viewPanel.add(new ViewStudentsList(viewPanel));
				
			}
		});
		viewStudentList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		studentsMenuList.add(viewStudentList);
		
		JMenuItem cdstrStudentMenuItem = new JMenuItem("Cadastrar Estudante");
		cdstrStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new CdstStudent(viewPanel));
			}
		});
		cdstrStudentMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		studentsMenuList.add(cdstrStudentMenuItem);
		
		JMenu professorsMenuList = new JMenu("Professores");
		professorsMenuList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(professorsMenuList);
		
		JMenuItem viewProfessorsList = new JMenuItem("Ver Professores");
		viewProfessorsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				
				viewPanel.removeAll();
				
				viewPanel.add(new ViewProfessorsList(viewPanel));
			}
		});
		viewProfessorsList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		professorsMenuList.add(viewProfessorsList);
		
		JMenuItem cdstrProfessorMenuItem = new JMenuItem("Cadastrar Professor");
		cdstrProfessorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new CdstProfessor(viewPanel));
			}
		});
		cdstrProfessorMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		professorsMenuList.add(cdstrProfessorMenuItem);
		
		JMenu turmasMenuList = new JMenu("Turmas");
		turmasMenuList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(turmasMenuList);
		
		JMenuItem viewTurmasList = new JMenuItem("Ver Turmas");
		viewTurmasList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				
				viewPanel.removeAll();
				
				viewPanel.add(new ViewTurmasList(viewPanel));
			}
		});
		viewTurmasList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		turmasMenuList.add(viewTurmasList);
		
		JMenuItem cdstrTurmaMenuItem = new JMenuItem("Cadastrar Turma");
		cdstrTurmaMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new CdstTurma(viewPanel));
			}
		});
		cdstrTurmaMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		turmasMenuList.add(cdstrTurmaMenuItem);
		
		JMenu diciplanesMenuList = new JMenu("Disciplinas");
		diciplanesMenuList.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(diciplanesMenuList);
		
		JMenuItem viewDisciplanesList = new JMenuItem("Ver Disciplinas");
		viewDisciplanesList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				
				viewPanel.removeAll();
				
				viewPanel.add(new ViewDisciplanesList(viewPanel));
			}
		});
		viewDisciplanesList.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		diciplanesMenuList.add(viewDisciplanesList);
		
		JMenuItem cdstrDisciplaneMenuItem = new JMenuItem("Cadastrar Disciplina");
		cdstrDisciplaneMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new CdstDisciplane(viewPanel));
			}
		});
		cdstrDisciplaneMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		diciplanesMenuList.add(cdstrDisciplaneMenuItem);
		menuPanel.setLayout(gl_menuPanel);
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(0, 128, 0));
		
		JPanel panelButton_1 = new JPanel();
		panelButton_1.setBackground(new Color(0, 128, 0));
		
		JPanel panelButton_2 = new JPanel();
		panelButton_2.setBackground(new Color(0, 128, 0));
		
		JPanel panelButton_3 = new JPanel();
		panelButton_3.setBackground(new Color(0, 128, 0));
		
		JButton cdstrTurma = new JButton("Cadastrar Turma");
		cdstrTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new CdstTurma(viewPanel));
			}
		});
		cdstrTurma.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelButton_3.add(cdstrTurma);
		
		JPanel panelButton_4 = new JPanel();
		panelButton_4.setBackground(new Color(0, 128, 0));
		
		JButton cdstrDisciplane = new JButton("Cadastrar Disciplina");
		cdstrDisciplane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new CdstDisciplane(viewPanel));
			}
		});
		cdstrDisciplane.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelButton_4.add(cdstrDisciplane);
		
		JButton exitButton = new JButton("Sair");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				Main reset = new Main();
				reset.setVisible(true);
			}
		});
		exitButton.setSize(new Dimension(255, 255));
		exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel ifLogo = new JLabel("");
		ifLogo.setSize(180, 180);
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("images-removebg-preview.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
		
		Image imgI = img.getScaledInstance(ifLogo.getWidth(), ifLogo.getHeight(), Image.SCALE_SMOOTH);
		ifLogo.setIcon(new ImageIcon(imgI));
		
		GroupLayout gl_optionsSpace = new GroupLayout(optionsSpace);
		gl_optionsSpace.setHorizontalGroup(
			gl_optionsSpace.createParallelGroup(Alignment.LEADING)
				.addComponent(exitButton, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
				.addGroup(gl_optionsSpace.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_optionsSpace.createParallelGroup(Alignment.TRAILING)
						.addComponent(optionsPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(panelButton_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(panelButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(panelButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(panelButton_1, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(Alignment.TRAILING, gl_optionsSpace.createSequentialGroup()
					.addContainerGap()
					.addComponent(ifLogo, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_optionsSpace.setVerticalGroup(
			gl_optionsSpace.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_optionsSpace.createSequentialGroup()
					.addContainerGap()
					.addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelButton_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelButton_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelButton_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelButton_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ifLogo, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton cdstrProfessor = new JButton("Cadastrar Professor");
		cdstrProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new CdstProfessor(viewPanel));
			}
		});
		cdstrProfessor.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelButton_2.add(cdstrProfessor);
		
		JButton cdstrStudent = new JButton("Cadastrar Estudante");
		cdstrStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new CdstStudent(viewPanel));
			}
		});
		cdstrStudent.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelButton_1.add(cdstrStudent);
		
		JLabel options = new JLabel("Opções de admin:");
		options.setFont(new Font("Times New Roman", Font.BOLD, 20));
		optionsPanel.add(options);
		optionsSpace.setLayout(gl_optionsSpace);
		setLayout(groupLayout);

	}
}
