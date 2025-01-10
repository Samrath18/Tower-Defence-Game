package groupProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpamClick extends JFrame {

	private static JProgressBar progressBar;
	private static JButton bSpam;
	private static JPanel contentPane, gamePanel, losePanel, winPanel;
	public static JLabel lblTime, lblStart, lblTitle, lblAmount, lblLose1, lblLose2, lblLose3, lblWin1, lblWin2, lblWin3;
	private static int seconds = 6, number;
	private static Timer timer = new Timer();
	private static Timer timer2 = new Timer();
	public static SpamClick frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seconds = 6;
					frame = new SpamClick();
					frame.setVisible(true);
					watch1();
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
	public SpamClick() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 379, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		gamePanel = new JPanel();
		gamePanel.setBounds(10, 11, 343, 247);
		contentPane.add(gamePanel);
		gamePanel.setLayout(null);
		
		lblAmount = new JLabel("");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setBounds(114, 204, 125, 43);
		gamePanel.add(lblAmount);

		progressBar = new JProgressBar();
		progressBar.setBounds(0, 152, 343, 44);
		gamePanel.add(progressBar);

		bSpam = new JButton("CLICK!");
		bSpam.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bSpam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bSpam.setBounds(0, 0, 343, 125);
		gamePanel.add(bSpam);

		lblStart = new JLabel("Starts in:");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblStart.setBounds(114, 86, 98, 39);
		gamePanel.add(lblStart);

		lblTime = new JLabel("");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblTime.setBounds(201, 86, 27, 39);
		gamePanel.add(lblTime);

		lblTitle = new JLabel("Get ready to spam click!!!");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 343, 60);
		gamePanel.add(lblTitle);
		
		losePanel = new JPanel();
		losePanel.setBounds(35, 0, 301, 272);
		contentPane.add(losePanel);
		losePanel.setLayout(null);
		
		lblLose1 = new JLabel("Defeat!");
		lblLose1.setBounds(0, 0, 301, 119);
		losePanel.add(lblLose1);
		lblLose1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLose1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		lblLose2 = new JLabel("You lost the minigame...");
		lblLose2.setBounds(10, 129, 281, 55);
		losePanel.add(lblLose2);
		lblLose2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLose2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		lblLose3 = new JLabel("Enemy buff has been applied :(");
		lblLose3.setBounds(10, 217, 281, 55);
		losePanel.add(lblLose3);
		lblLose3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLose3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		winPanel = new JPanel();
		winPanel.setBounds(35, 0, 301, 272);
		contentPane.add(winPanel);
		winPanel.setLayout(null);
		
		lblWin1 = new JLabel("Victory!");
		lblWin1.setBounds(0, 0, 301, 119);
		winPanel.add(lblWin1);
		lblWin1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWin1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		lblWin2 = new JLabel("You won the minigame!");
		lblWin2.setBounds(10, 129, 281, 55);
		winPanel.add(lblWin2);
		lblWin2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWin2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		lblWin3 = new JLabel("Player buff has been applied!");
		lblWin3.setBounds(10, 217, 281, 55);
		winPanel.add(lblWin3);
		lblWin3.setHorizontalAlignment(SwingConstants.CENTER);
		lblWin3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bSpam.setVisible(false);
	}

	private static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min); //formula for returning the random number within a specified range
	}

	public static void watch1() {
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds -1; //adds a second
				Integer i = seconds;

				lblTime.setText(i.toString());

				if (seconds == 0) {

					bSpam.setVisible(true);
					stopTime();
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}

	public static void watch2() {
		timer2 = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds -1; //adds a second
				System.out.println(seconds);				
				Integer i = seconds;

				lblTime.setText(i.toString());

				if (seconds == 0) {

					stopTime2();
					gamePanel.setVisible(false);

					if (InfiniteMinigame.infMinigameStarted == 0) { // Minigame played in game
						losePanel.setVisible(true);
						InGameMinigameSystem.inGameMinigame = 1;
						InGameMinigameSystem.winOrLose = 0;
						InGameMinigameSystem.main(new String [0]);
						//losePanel or winPanel
					}
					if (InfiniteMinigame.infMinigameStarted == 1) { // Minigame played in infinite minigames section
						InfiniteMinigame.infMinigameStarted = 0;
						InfiniteMinigame.streakFrame.dispose();
						MainMenu.main(new String [0]);
					}

				}
			}
		};
		timer2.schedule(task, 0, 1000);
	}

	public static void WatchWin() {
		seconds = 300;
		Timer winTimer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds - 1; //adds a second 

				if (seconds == 0)
				{
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
	
	public static void stopTime() {
		timer.cancel();
		System.out.println("timer canceled at " + seconds + " seconds");

		lblTitle.setVisible(false);
		bSpam.setVisible(true);
		lblTime.setBounds(158, 115, 27, 39);
		rand();
	}

	private static void stopTime2() {
		timer2.cancel();
		System.out.println("timer canceled at " + seconds + " seconds");
	}

	private static void rand() {
		number = getRandomNumber(50, 150);
		progressBar.setMaximum(number);
		if (number <= 75) {
			seconds = 16;
		}
		else if (number > 75 && number <= 100) {
			seconds = 26;
		}
		else if (number > 100 && number <= 150) {
			seconds = 31;
		}
		
		lblAmount.setText("0/" + number);
		
		watch2();
	}
	
	private static void actionListeners() {
		bSpam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				progressBar.setValue(progressBar.getValue() + 1);
				lblAmount.setText("" + progressBar.getValue() + "/" + number);
				
				if (progressBar.getValue() == number) {
					gamePanel.setVisible(false);
					losePanel.setVisible(false);
					winPanel.setVisible(true);
					
					stopTime2();
					
					WatchWin();
				}
				lblAmount.setVisible(true);
			}
		});
	}
}
