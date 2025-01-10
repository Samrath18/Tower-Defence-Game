package groupProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

public class debug extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					debug frame = new debug();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public debug() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEBUG MENU");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(169, 11, 95, 50);
		contentPane.add(lblNewLabel);
		
		JLabel difficultyText = new JLabel("Difficulty: Easy");
		difficultyText.setForeground(Color.WHITE);
		difficultyText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		difficultyText.setBounds(171, 181, 117, 14);
		contentPane.add(difficultyText);
		
		JButton btnNewButton = new JButton("AI Spawn Troop");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AICore.AISpawnTroop();
			}
		});
		btnNewButton.setBounds(147, 206, 140, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Easy");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AICore.aiSetting = 0;
				difficultyText.setText("Difficulty: Easy") ;
			}
		});
		btnNewButton_1.setBounds(171, 72, 91, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Medium");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AICore.aiSetting = 1;
				difficultyText.setText("Difficulty: Medium") ;
			}
		});
		btnNewButton_1_1.setBounds(171, 106, 91, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Hard");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AICore.aiSetting = 2;
				difficultyText.setText("Difficulty: Hard") ;
			}
		});
		btnNewButton_1_2.setBounds(171, 140, 91, 23);
		contentPane.add(btnNewButton_1_2);
		
		JTextArea txtrEasyMedium = new JTextArea();
		txtrEasyMedium.setEditable(false);
		txtrEasyMedium.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrEasyMedium.setText("Easy: 5:3:1\r\nMedium: 3:3:3\r\nHard: 1:3:5");
		txtrEasyMedium.setForeground(Color.WHITE);
		txtrEasyMedium.setBackground(Color.BLUE);
		txtrEasyMedium.setBounds(24, 27, 107, 117);
		contentPane.add(txtrEasyMedium);
		
	}
}
