package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  

import dialogue.DialogueJeu;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class JFrameMenuAlchimiste extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private DialogueJeu dialogueJeu;
	private JTextField textFieldChoixMenu;
	private JLabel lblNewLabelErrorChoixMenu;
	private JLabel lblNewLabelArgent;
	/**
	 * Create the frame.
	 */
	public JFrameMenuAlchimiste() {
		setResizable(false);
		setTitle("Alchimiste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(228, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Veuillez choisir un nombre entre 0 et 4 ou 5 pour quitter le Menu :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTravailler = new JLabel("0 - Potion Kilo good ( type = potion | prix = 100 )");
		lblTravailler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTravailler_1 = new JLabel("1 - Potion Mega good ( type = potion | prix = 200 )");
		lblTravailler_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTravailler_2 = new JLabel("2 - Potion Giga good ( type = potion | prix = 400 )");
		lblTravailler_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblAller_1 = new JLabel("3 - Potion Tera good ( type = potion | prix = 800 )");
		lblAller_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblAller = new JLabel("4 - Potion Peta good ( type = potion | prix = 1600 )");
		lblAller.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblQuitter = new JLabel("5 - Quitter le Menu");
		lblQuitter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textFieldChoixMenu = new JTextField();
		textFieldChoixMenu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre choisie :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblNewLabelErrorChoixMenu = new JLabel("");
		lblNewLabelErrorChoixMenu.setForeground(new Color(255, 0, 0));
		lblNewLabelErrorChoixMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Argent poss\u00E9d\u00E9 :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelArgent = new JLabel("");
		lblNewLabelArgent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 821, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAller, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblQuitter, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
									.addGap(6)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1)
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(textFieldChoixMenu, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
													.addGap(70)
													.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(87)
											.addComponent(lblNewLabelErrorChoixMenu, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))))
								.addComponent(lblAller_1, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblTravailler, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblTravailler_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
										.addComponent(lblTravailler_2, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE))
									.addGap(148)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabelArgent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))))
					.addGap(51))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblTravailler)
							.addGap(13)
							.addComponent(lblTravailler_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTravailler_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAller_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabelArgent, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblAller)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblQuitter))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabelErrorChoixMenu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldChoixMenu, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
				
		
	}
	
	public void resetPresentation() {
		textFieldChoixMenu.setText("");
		lblNewLabelErrorChoixMenu.setText("");
	}
	
	public void setPresentationChoixMenuErreur() {
		lblNewLabelErrorChoixMenu.setText("Chiffre entre 0 et 5");
		textFieldChoixMenu.setText("");
	}
	public void setPresentationArgent(int argent) {
		lblNewLabelArgent.setText(Integer.toString(argent));
	}
	
//Record reference to Dialogue
	
	public void setDialogue(DialogueJeu dialogueJeu) {
		this.dialogueJeu = dialogueJeu;
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		dialogueJeu.eventChoixActionMenuAlchimiste(Integer.parseInt(textFieldChoixMenu.getText()));
	}
}
