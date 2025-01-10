package groupProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoseScreen extends JFrame {
	
	static private JFrame loseFrame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loseFrame = new LoseScreen();
					loseFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoseScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel highScoreLbl = new JLabel("Your high score is: ");
		highScoreLbl.setFont(new Font("High Tower Text", Font.PLAIN, 30));
		highScoreLbl.setBounds(90, 88, 255, 87);
		contentPane.add(highScoreLbl);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 178, 364, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton mainMenuBtn = new JButton("Main Menu");
		mainMenuBtn.setBounds(0, 0, 166, 37);
		panel.add(mainMenuBtn);
		mainMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loseFrame.setVisible(false);
				MainMenu.main(new String[0]);
			}
		});
		mainMenuBtn.setFont(new Font("High Tower Text", Font.PLAIN, 24));
		
		JButton replay = new JButton("Replay");
		replay.setBounds(198, 0, 166, 37);
		panel.add(replay);
		replay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loseFrame.setVisible(false);
				DifficultyScreen.main(new String[0]);
			}
		});
		replay.setFont(new Font("High Tower Text", Font.PLAIN, 24));
		
		JLabel lblLose = new JLabel("You lost...");
		lblLose.setHorizontalAlignment(SwingConstants.CENTER);
		lblLose.setFont(new Font("High Tower Text", Font.PLAIN, 50));
		lblLose.setBounds(90, 26, 227, 76);
		contentPane.add(lblLose);
	}
}