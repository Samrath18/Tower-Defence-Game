package groupProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;



public class RandomTargets extends JFrame {

	private JPanel contentPane;

	private static JLabel TimerText;

	public static JLabel CountdownText, lblHereIsYour, lblYouWin, lblRewardGoesHere;

	private static JButton target;

	private static JLabel confetti;

	private static JPanel GamePanel;

	private static JPanel WinPanel;

	private static JPanel LosePanel;

	public static RandomTargets frame;
	
	private static JLabel ScoreText;

	static int x;
	static int y;

	static int targetScore;

	static int score;

	static int firstRun = 1;

	static int secondsStart = 18;
	static double seconds = secondsStart;
	private final JLabel lblYouLost = new JLabel("You Lose!");
	public static JLabel lblDebuffGoesHere = new JLabel("Debuff goes here");
	private final JLabel confetti_1 = new JLabel("");

	/**
	 * Launch the application.
	 */

	public static void VariableSetup()
	{
		score = 0;
		
		targetScore = 20;
		
		TimerText = new JLabel("TIME: 10");

		CountdownText = new JLabel("5");
		
		ScoreText = new JLabel("SCORE: 0");

		target = new JButton("");

		confetti = new JLabel("");
		confetti.setIcon(new ImageIcon("graphics/confetti.png"));

		GamePanel = new JPanel();

		WinPanel = new JPanel();

		LosePanel = new JPanel();
	}
	
	public static void Watch() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds - 1; //adds a second

				if (seconds <= secondsStart - 3)
				{
					TimerText.setText("TIME: " + (int)seconds);
				}

				if (seconds >= secondsStart - 3)
				{
					CountdownText.setText("" + (int)(seconds - (secondsStart - 3)));

					if(seconds == secondsStart - 3)
					{
						CountdownText.setVisible(false);
						target.setVisible(true);
						target.setEnabled(true);
					}
				}

				if (seconds == 0)
				{
					timer.cancel();
					WatchLose();
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}  

	public static void WatchLose() {
		seconds = 4;
		Timer loseTimer =  new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds - 1; //adds a second 

				GamePanel.setVisible(false);

				LosePanel.setVisible(true);

				if (seconds == 0)
				{
					loseTimer.cancel();
					frame.dispose();
					InfiniteMinigame.streakFrame.dispose();
					
					if (InfiniteMinigame.infMinigameStarted == 0) { // Minigame played in game
						LosePanel.setVisible(true);
						InGameMinigameSystem.inGameMinigame = 1;
						InGameMinigameSystem.winOrLose = 0;
						InGameMinigameSystem.main(new String [0]);
						//losePanel or winPanel
					}
					if (InfiniteMinigame.infMinigameStarted == 1) { // Minigame played in infinite minigames section
						InfiniteMinigame.infMinigameStarted = 0;
						MainMenu.main(new String [0]);
					}
				}
			}
		};
		loseTimer.schedule(task, 0, 1000);
	}  

	public static void WatchWin() {
		seconds = 300;
		Timer winTimer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds - 1; //adds a second 

				System.out.println(seconds);
				
				GamePanel.setVisible(false);

				WinPanel.setVisible(true);
				
				confetti.setBounds(0, -250, 339, 314);
				
				confetti.setBounds(0, confetti.getY() + 10, 339, 314);
				
				if (seconds == 0)
				{
					firstRun = 0;
					winTimer.cancel();
					frame.dispose();
					if(InfiniteMinigame.infMinigameStarted == 1)
					{
						System.out.println("minigame started");
						InfiniteMinigame.RandomMinigame();
					}
				}
			}
		};
		winTimer.schedule(task, 0, 10);
	}  

	public static void RunGame()
	{
		x = 0;
		y = 0;
		seconds = secondsStart;
		targetScore = 20;
		score = 0;

		GamePanel.setVisible(true);
		LosePanel.setVisible(false);
		WinPanel.setVisible(false);
		
		TimerText.setText("TIME: " + ((int)seconds - 3));

		CountdownText.setText("" + (int)(seconds - (secondsStart - 3)));
		
		ScoreText.setText("SCORE: " + score);

		CountdownText.setVisible(true);
		
		target.setVisible(false);
	}
	
	public static void main(String[] args) {
		System.out.println("main run");
		if(firstRun == 1)
		{
			VariableSetup();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new RandomTargets();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			Watch();
			RunGame();
		}
	}

	/**
	 * Create the frame.
	 * @return 
	 */

	public RandomTargets() {
		setMinimumSize(new Dimension(375, 375));
		setResizable(false);
		setAlwaysOnTop(false);
		setFont(new Font("Agency FB", Font.PLAIN, 16));
		setTitle("Random Targets");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 375, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		GamePanel.setBounds(10, 11, 339, 314);

		contentPane.add(GamePanel);
		GamePanel.setLayout(null);

		ScoreText = new JLabel("SCORE: 0");
		ScoreText.setBounds(0, 0, 147, 24);
		GamePanel.add(ScoreText);
		ScoreText.setFont(new Font("High Tower Text", Font.BOLD, 18));
		target.setBounds(226, 190, 50, 50);
		GamePanel.add(target);

		target.setVisible(false);
		target.setEnabled(false);
		target.setOpaque(false);
		target.setFocusPainted(false);
		target.setBorder(null);
		target.setBorderPainted(false);
		target.setContentAreaFilled(false);
		target.setIcon(new ImageIcon("graphics/Target_logo.png"));
		TimerText.setBounds(257, 0, 82, 24);
		GamePanel.add(TimerText);

		TimerText.setFont(new Font("High Tower Text", Font.BOLD, 18));

		JLabel lblTargetScore = new JLabel("TARGET SCORE: 20");
		lblTargetScore.setBounds(81, 290, 176, 24);
		GamePanel.add(lblTargetScore);
		lblTargetScore.setFont(new Font("High Tower Text", Font.BOLD, 18));
		CountdownText.setBounds(153, 123, 33, 67);
		GamePanel.add(CountdownText);

		CountdownText.setFont(new Font("High Tower Text", Font.BOLD, 64));

		WinPanel.setBounds(10, 11, 339, 314);
		contentPane.add(WinPanel);
		WinPanel.setLayout(null);

		lblHereIsYour = new JLabel("Your reward is:");
		lblHereIsYour.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHereIsYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereIsYour.setFont(new Font("High Tower Text", Font.BOLD, 18));
		lblHereIsYour.setBounds(85, 164, 169, 24);
		WinPanel.add(lblHereIsYour);

		lblYouWin = new JLabel("You Win!");
		lblYouWin.setVerticalAlignment(SwingConstants.TOP);
		lblYouWin.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouWin.setFont(new Font("High Tower Text", Font.BOLD, 44));
		lblYouWin.setBounds(64, 55, 211, 41);
		WinPanel.add(lblYouWin);

		lblRewardGoesHere = new JLabel("Reward goes here");
		lblRewardGoesHere.setVerticalAlignment(SwingConstants.TOP);
		lblRewardGoesHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblRewardGoesHere.setFont(new Font("High Tower Text", Font.BOLD, 32));
		lblRewardGoesHere.setBounds(10, 193, 319, 41);
		WinPanel.add(lblRewardGoesHere);

		confetti.setIcon(new ImageIcon("graphics/confetti.png"));
		confetti.setBounds(0, -250, 339, 314);
		WinPanel.add(confetti);
		LosePanel.setLayout(null);
		LosePanel.setBounds(10, 11, 339, 314);

		contentPane.add(LosePanel);
		lblYouLost.setVerticalAlignment(SwingConstants.TOP);
		lblYouLost.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouLost.setFont(new Font("High Tower Text", Font.BOLD, 48));
		lblYouLost.setBounds(55, 55, 228, 41);

		LosePanel.add(lblYouLost);
		lblDebuffGoesHere.setVerticalAlignment(SwingConstants.TOP);
		lblDebuffGoesHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblDebuffGoesHere.setFont(new Font("High Tower Text", Font.BOLD, 32));
		lblDebuffGoesHere.setBounds(10, 193, 319, 41);

		LosePanel.add(lblDebuffGoesHere);
		confetti_1.setBounds(0, -250, 339, 314);

		LosePanel.add(confetti_1);

		target.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Random rand = new Random();
				x = rand.nextInt(275) + 25;
				y = rand.nextInt(200) + 25;
				target.setBounds(x, y, 50, 50);

				score++;

				System.out.println(score);

				ScoreText.setText("SCORE: " + score);

				if(score == targetScore)
				{
					WatchWin();
				}
			}
		});

		Random rand = new Random();
		x = rand.nextInt(275) + 25;
		y = rand.nextInt(200) + 25;

		GamePanel.setVisible(true);
		LosePanel.setVisible(false);
		WinPanel.setVisible(false);
	}
}