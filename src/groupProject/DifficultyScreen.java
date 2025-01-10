package groupProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DifficultyScreen extends JFrame {

	private static JPanel contentPane;
	private static JButton bEasy, bMedium, bHard, bConfirm, bBack;
	private static JLabel lblTitle;
	private static JLabel lblBackground;
	private static DifficultyScreen frame = new DifficultyScreen();
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DifficultyScreen();
					frame.setVisible(true);
					actionListeners();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DifficultyScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("Select a Difficulty");
		lblTitle.setFont(new Font("High Tower Text", Font.BOLD, 39));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(2, 15, 432, 59);
		lblTitle.setForeground(Color.white);
		contentPane.add(lblTitle);
		
		bEasy = new JButton("Easy");
		bEasy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bEasy.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		bEasy.setBounds(134, 70, 167, 40);
		contentPane.add(bEasy);
		
		bMedium = new JButton("Medium");
		bMedium.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bMedium.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		bMedium.setBounds(134, 122, 167, 40);
		contentPane.add(bMedium);
		
		bHard = new JButton("Hard");
		bHard.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bHard.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		bHard.setBounds(134, 174, 167, 40);
		contentPane.add(bHard);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(37, 231, 362, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		bConfirm = new JButton("Confirm");
		bConfirm.setBounds(189, 0, 173, 46);
		panel.add(bConfirm);
		bConfirm.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		bConfirm.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		bBack = new JButton("Return to Menu");
		bBack.setBounds(0, 0, 173, 46);
		panel.add(bBack);
		bBack.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		bBack.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, -21, 450, 345);
		lblBackground.setIcon(new ImageIcon("graphics/game_Background_mainmenu.png"));
		contentPane.add(lblBackground);
	}
	
	
	private static void actionListeners() {
		bEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bEasy.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				bMedium.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				bHard.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

				AICore.aiSetting = 0;
			}
		});
		bMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bEasy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				bMedium.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				bHard.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

				AICore.aiSetting = 1;
			}
		});
		bHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bEasy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				bMedium.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				bHard.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

				AICore.aiSetting = 2;
			}
		});
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu.main(new String[0]);
			}
		});
		bConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				gameScreen1.main(new String[0]);
			}
		});
	}
}