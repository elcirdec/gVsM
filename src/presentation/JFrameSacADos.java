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


public class JFrameSacADos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private DialogueJeu dialogueJeu;
	private JTextField textFieldChoixMenu;
	private JLabel lblNewLabelErrorChoixMenu;
	private JLabel lblNewLabelNbArticle;
	private JLabel lblNewLabelNbArticlePlusUn;
	
	private JLabel lblNewLabelNom1;
	private JLabel lblNewLabelNom2;
	private JLabel lblNewLabelNom3;
	private JLabel lblNewLabelNom4;
	private JLabel lblNewLabelNom5;
	private JLabel lblNewLabelNom6;
	private JLabel lblNewLabelNom7;
	private JLabel lblNewLabelNom8;
	private JLabel lblNewLabelNom9;
	private JLabel lblNewLabelNom10;
	
	private JLabel lblNewLabelEtat1;
	private JLabel lblNewLabelEtat2;
	private JLabel lblNewLabelEtat3;
	private JLabel lblNewLabelEtat4;
	private JLabel lblNewLabelEtat5;
	private JLabel lblNewLabelEtat6;
	private JLabel lblNewLabelEtat7;
	private JLabel lblNewLabelEtat8;
	private JLabel lblNewLabelEtat9;
	private JLabel lblNewLabelEtat10;
	/**
	 * Create the frame.
	 */
	public JFrameSacADos() {
		setResizable(false);
		setTitle("Sac a Dos");
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
		
		JLabel lblNewLabel = new JLabel("Veuillez choisir un nombre entre 0 et");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textFieldChoixMenu = new JTextField();
		textFieldChoixMenu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de l'article a utilis\u00E9 :");
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
		
		JLabel lblNewLabel_3 = new JLabel("ou");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3_1 = new JLabel("pour quitter le Menu :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNbArticle = new JLabel("");
		lblNewLabelNbArticle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNbArticlePlusUn = new JLabel("");
		lblNewLabelNbArticlePlusUn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom10 = new JLabel("");
		lblNewLabelNom10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom1 = new JLabel("");
		lblNewLabelNom1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom2 = new JLabel("");
		lblNewLabelNom2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom3 = new JLabel("");
		lblNewLabelNom3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom4 = new JLabel("");
		lblNewLabelNom4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom5 = new JLabel("");
		lblNewLabelNom5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom6 = new JLabel("");
		lblNewLabelNom6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom7 = new JLabel("");
		lblNewLabelNom7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom8 = new JLabel("");
		lblNewLabelNom8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelNom9 = new JLabel("");
		lblNewLabelNom9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_10 = new JLabel("Utilis\u00E9 :");
		lblNewLabel_2_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelEtat1 = new JLabel("");
		lblNewLabelEtat1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelEtat2 = new JLabel("");
		lblNewLabelEtat2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelEtat3 = new JLabel("");
		lblNewLabelEtat3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelEtat4 = new JLabel("");
		lblNewLabelEtat4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelEtat5 = new JLabel("");
		lblNewLabelEtat5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelEtat6 = new JLabel("");
		lblNewLabelEtat6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelEtat7 = new JLabel("");
		lblNewLabelEtat7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelEtat8 = new JLabel("");
		lblNewLabelEtat8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabelEtat9 = new JLabel("");
		lblNewLabelEtat9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabelEtat10 = new JLabel("");
		lblNewLabelEtat10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabelNbArticle, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addGap(22)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabelNbArticlePlusUn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_3_1))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabelNom1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNom2, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNom3, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNom4, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNom5, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNom6, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNom7, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNom8, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNom9, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNom10, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
									.addGap(84)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabelEtat10, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelEtat9, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelEtat8, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabelEtat3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabelEtat4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabelEtat5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabelEtat6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabelEtat7, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
											.addGap(169)
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
										.addComponent(lblNewLabelEtat2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelEtat1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(242)
							.addComponent(lblNewLabel_2_10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(25)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(36)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabelNbArticlePlusUn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2_10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabelNom1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabelEtat1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabelNom2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(30)
											.addComponent(lblNewLabelErrorChoixMenu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(textFieldChoixMenu, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabelNom3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabelNom4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabelNom5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabelNom6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabelNom7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabelEtat2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabelEtat3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabelEtat4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabelEtat5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabelEtat6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabelEtat7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(36)
							.addComponent(lblNewLabelNbArticle, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabelNom8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabelNom9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabelNom10))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabelEtat8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabelEtat9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabelEtat10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
				
		
	}
	
	public void resetPresentation() {
		textFieldChoixMenu.setText("");
		lblNewLabelErrorChoixMenu.setText("");
	}
	
	public void setPresentationChoixMenuErreur(int nbArticle) {
		lblNewLabelErrorChoixMenu.setText("Chiffre entre 0 et "+ (nbArticle-1));
		textFieldChoixMenu.setText("");
	}
	public void setPresentationNbArticle(int nbArticle) {
		lblNewLabelNbArticle.setText(Integer.toString(nbArticle));
	}
	public void setPresentationNbArticlePlusUn(int nbArticle) {
		lblNewLabelNbArticlePlusUn.setText(Integer.toString(nbArticle));
	}
	public void setPresentationNomArticle(String[] nomArticle,int nbArticle) {
		JLabel[] tabJlabel = {lblNewLabelNom1,lblNewLabelNom2,lblNewLabelNom3,lblNewLabelNom4,lblNewLabelNom5,lblNewLabelNom6,lblNewLabelNom7,lblNewLabelNom8,lblNewLabelNom9,lblNewLabelNom10};
		for(int i=0;i<nbArticle;i++) {
			tabJlabel[i].setText(nomArticle[i]);
		}
	}
	public void setPresentationEtatArticle(boolean[] etatArticle,int nbArticle) {
		JLabel[] tabJlabel = {lblNewLabelEtat1,lblNewLabelEtat2,lblNewLabelEtat3,lblNewLabelEtat4,lblNewLabelEtat5,lblNewLabelEtat6,lblNewLabelEtat7,lblNewLabelEtat8,lblNewLabelEtat9,lblNewLabelEtat10};
		for(int i=0;i<nbArticle;i++) {
			tabJlabel[i].setText(Boolean.toString(etatArticle[i]));
		}
	}
//Record reference to Dialogue
	
	public void setDialogue(DialogueJeu dialogueJeu) {
		this.dialogueJeu = dialogueJeu;
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		dialogueJeu.eventChoixActionMenuSacADos(Integer.parseInt(textFieldChoixMenu.getText()));
	}
}
