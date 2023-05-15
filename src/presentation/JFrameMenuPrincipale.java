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


public class JFrameMenuPrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private DialogueJeu dialogueJeu;
	private JTextField textFieldChoixMenu;
	private JLabel lblNewLabelErrorChoixMenu;
	private JLabel lblNewLabelPointDeVie;
	private JLabel lblNewLabelArgent;
	private JLabel lblNewLabelAttaque;

	/**
	 * Create the frame.
	 */
	public JFrameMenuPrincipale() {
		setResizable(false);
		setTitle("Jeu Gentil Vs Mechant");
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
		
		JLabel lblNewLabel = new JLabel("Veuillez choisir un nombre entre 0 et 5 pour effectuer une action ou 6 pour quitter le jeu :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTravailler = new JLabel("0 - Travailler");
		lblTravailler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTravailler_1 = new JLabel("1 - Affronter un ennemie");
		lblTravailler_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTravailler_2 = new JLabel("2 - Aller a la taverne");
		lblTravailler_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblAller_1 = new JLabel("3 - Aller chez l'alchimiste");
		lblAller_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblAller = new JLabel("4 - Aller a l'armurerie");
		lblAller.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblUtiliser = new JLabel("5 - Utiliser un article du sac a dos");
		lblUtiliser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblQuitter = new JLabel("6 - Quitter le jeu");
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
		
		JLabel lblNewLabel_2 = new JLabel("Point de vie :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelPointDeVie = new JLabel("");
		lblNewLabelPointDeVie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("Argent :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelArgent = new JLabel("");
		lblNewLabelArgent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_3 = new JLabel("Attaque :");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelAttaque = new JLabel("");
		lblNewLabelAttaque.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblTravailler_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTravailler_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAller_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
								.addComponent(lblAller, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUtiliser, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuitter, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTravailler, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
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
									.addComponent(lblNewLabelErrorChoixMenu, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(98)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
									.addGap(30)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabelAttaque, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelArgent, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelPointDeVie, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTravailler)
										.addComponent(lblNewLabel_2)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(11)
									.addComponent(lblNewLabelPointDeVie, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
							.addGap(13)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblTravailler_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblTravailler_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblAller_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblAller)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblUtiliser))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelAttaque, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
									.addGap(73)
									.addComponent(lblNewLabelErrorChoixMenu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuitter)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldChoixMenu, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(119)
							.addComponent(lblNewLabelArgent, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
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
		lblNewLabelErrorChoixMenu.setText("Chiffre entre 0 et 6");
		textFieldChoixMenu.setText("");
	}
	public void setPresentationPointDeVie(int nbArticle) {
		lblNewLabelPointDeVie.setText(Integer.toString(nbArticle));
	}
	public void setPresentationArgent(int nbArticle) {
		lblNewLabelArgent.setText(Integer.toString(nbArticle));
	}
	public void setPresentationAttaque(int nbArticle) {
		lblNewLabelAttaque.setText(Integer.toString(nbArticle));
	}
	
//Record reference to Dialogue
	
	public void setDialogue(DialogueJeu dialogueJeu) {
		this.dialogueJeu = dialogueJeu;
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		dialogueJeu.eventChoixActionMenuPrincipale(Integer.parseInt(textFieldChoixMenu.getText()));
	}
}
