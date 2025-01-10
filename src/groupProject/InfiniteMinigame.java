package groupProject;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfiniteMinigame extends JFrame {

	public static int infMinigameStarted = 0; // if the user is in infinite minigame mode

	public static int streak = 0;

	public static int minigameSelected; // 0 = Random Targets, 1 = Quick Math, 2 = Spam Click

	public static InfiniteMinigame streakFrame;

	private static JLabel StreakText = new JLabel("STREAK: 0");

	private static JPanel contentPane;
	private final JPanel panel = new JPanel();

	public static void RandomMinigame()
	{
		Random rand = new Random();
		minigameSelected = rand.nextInt(3);
		StreakText.setText("STREAK: " + streak);
		System.out.println(minigameSelected);

		if (minigameSelected == 0)
		{
			RandomTargets.main(new String[0]);
			RandomTargets.RunGame();
		}
		else if (minigameSelected == 1)
		{
			QuickMath.main(new String[0]);
		}
		else if (minigameSelected == 2)
		{
			SpamClick.main(new String[0]);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					streakFrame = new InfiniteMinigame();
					streakFrame.setVisible(true);
					RandomMinigame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InfiniteMinigame() {
		setMinimumSize(new Dimension(100, 100));
		setResizable(false);
		setAlwaysOnTop(true);
		setFont(new Font("Agency FB", Font.PLAIN, 16));
		setTitle("Random Targets");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 200, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, -23, 184, 109);
		contentPane.add(panel);
		panel.setLayout(null);

		StreakText = new JLabel("STREAK: 0");
		StreakText.setFont(new Font("High Tower Text", Font.BOLD, 24));
		StreakText.setHorizontalAlignment(SwingConstants.CENTER);
		StreakText.setBounds(15, 29, 154, 39);
		panel.add(StreakText);

		JButton QuitButton = new JButton("Return to Menu");
		QuitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				streakFrame.dispose();
				MainMenu.frame.dispose();
				InfiniteMinigame.infMinigameStarted = 0;
				if (minigameSelected == 0) {
					RandomTargets.frame.dispose();
				}
				else if (minigameSelected == 1) {
					QuickMath.frame.dispose();
				}
				else if (minigameSelected == 2) {
					SpamClick.frame.dispose();
				}
				MainMenu.main(new String[0]);
			}
		});
		QuitButton.setFont(new Font("Dialog", Font.BOLD, 12));
		QuitButton.setBounds(25, 74, 127, 25);
		panel.add(QuitButton);
	}
}