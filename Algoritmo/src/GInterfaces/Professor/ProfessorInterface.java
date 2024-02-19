package GInterfaces.Professor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Models.Professor;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import GInterfaces.Main;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class ProfessorInterface extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProfessorInterface(Professor p, JFrame jf) {
		setSize(689, 475);
		
		JPanel optionsSpace = new JPanel();
		optionsSpace.setBackground(new Color(0, 128, 0));
		
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
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(0, 128, 0));
		
		JLabel options = new JLabel("Olá "+ p.getName()+".");
		options.setFont(new Font("Times New Roman", Font.BOLD, 20));
		optionsPanel.add(options);
		
		JPanel panelButton_3 = new JPanel();
		panelButton_3.setBackground(new Color(0, 128, 0));
		
		JButton changePassword = new JButton("Alterar senha");
		changePassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelButton_3.add(changePassword);
		
		JPanel panelButton_2 = new JPanel();
		panelButton_2.setBackground(new Color(0, 128, 0));
		
		JButton changePersonalData = new JButton("Alterar dados pessoais");
		changePersonalData.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelButton_2.add(changePersonalData);
		
		JPanel panelButton_1 = new JPanel();
		panelButton_1.setBackground(new Color(0, 128, 0));
		
		JButton viewPesonalData = new JButton("Ver dados pessoais");
		viewPesonalData.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelButton_1.add(viewPesonalData);
		
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
			gl_optionsSpace.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 205, Short.MAX_VALUE)
				.addComponent(exitButton, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
				.addGroup(gl_optionsSpace.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_optionsSpace.createParallelGroup(Alignment.TRAILING)
						.addComponent(optionsPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(panelButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(panelButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(panelButton_1, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(gl_optionsSpace.createSequentialGroup()
					.addContainerGap()
					.addComponent(ifLogo, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_optionsSpace.setVerticalGroup(
			gl_optionsSpace.createParallelGroup(Alignment.LEADING)
				.addGap(0, 475, Short.MAX_VALUE)
				.addGroup(gl_optionsSpace.createSequentialGroup()
					.addContainerGap()
					.addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelButton_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelButton_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelButton_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(ifLogo, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
		);
		optionsSpace.setLayout(gl_optionsSpace);
		
		JPanel menuPanel = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 478, Short.MAX_VALUE)
				.addGap(0, 478, Short.MAX_VALUE)
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 28, Short.MAX_VALUE)
				.addGap(0, 28, Short.MAX_VALUE)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JMenu mnDisciplane = new JMenu("Minhas disciplinas");
		mnDisciplane.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		menuBar.add(mnDisciplane);

		JPanel viewPanel = new JPanel();
		
		JMenu mnSolicitations = new JMenu("Solicitações recebidas");
		mnSolicitations.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		menuBar.add(mnSolicitations);
		
		JMenuItem mntmNotRespSolicitations = new JMenuItem("Não respondidas");
		mntmNotRespSolicitations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new ViewSolicitationsList(p, viewPanel, false));
			}
		});
		mntmNotRespSolicitations.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnSolicitations.add(mntmNotRespSolicitations);
		
		JMenuItem mntmRespSolicitations = new JMenuItem("Respondidas");
		mntmRespSolicitations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new ViewSolicitationsList(p, viewPanel, true));
			}
		});
		mntmRespSolicitations.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnSolicitations.add(mntmRespSolicitations);
		
		JMenuItem mntmAllSolicitations = new JMenuItem("Todas as Solicitações");
		mntmAllSolicitations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new ViewSolicitationsList(p, viewPanel));
			}
		});
		mntmAllSolicitations.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnSolicitations.add(mntmAllSolicitations);
		menuPanel.setLayout(gl_menuPanel);
		
		
		JMenuItem mntmTurmas = new JMenuItem("Minhas Turmas");
		mntmTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.removeAll();
				viewPanel.setVisible(false);
				viewPanel.setVisible(true);
				viewPanel.add(new ViewTurmasList(p, viewPanel));
			}
		});
		mntmTurmas.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnDisciplane.add(mntmTurmas);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(viewPanel, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
						.addComponent(menuPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(optionsSpace, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(optionsSpace, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(viewPanel, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
