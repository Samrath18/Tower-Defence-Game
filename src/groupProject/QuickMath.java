package groupProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;

public class QuickMath extends JFrame {

	public static JLabel label, lblStart, lblTime, lblUserAnswer, lblWin1, lblWin2, lblWin3, lblLose1, lblLose2, lblLose3, lblNumber;
	private static JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bEnter, bClear;
	private static JPanel contentPane;
	private static int seconds = 3, userAnswer, score = 1;
	private static Timer timer = new Timer();
	private static Timer timer2 = new Timer();
	private static int number, number1, number2, bigNum, smallNum, answer;
	private static JPanel gamePanel, losePanel, winPanel;
	public static QuickMath frame = new QuickMath();

	
	public static void VariableSetup()
	{
		score = 1;
		seconds = 3;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new QuickMath();
					frame.setVisible(true);
					VariableSetup();
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
	public QuickMath() {
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 337, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gamePanel = new JPanel();
		gamePanel.setBounds(10, 11, 301, 457);
		contentPane.add(gamePanel);
		gamePanel.setLayout(null);

		label = new JLabel("QUICK MATH");
		label.setBounds(0, 0, 301, 72);
		gamePanel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 50));

		b1 = new JButton("1");
		b1.setBounds(0, 170, 98, 53);
		gamePanel.add(b1);
		b1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b1.setEnabled(false);

		b2 = new JButton("2");
		b2.setBounds(101, 170, 98, 53);
		gamePanel.add(b2);
		b2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b2.setEnabled(false);

		b3 = new JButton("3");
		b3.setBounds(203, 170, 98, 53);
		gamePanel.add(b3);
		b3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b3.setEnabled(false);

		b4 = new JButton("4");
		b4.setBounds(0, 226, 98, 53);
		gamePanel.add(b4);
		b4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b4.setEnabled(false);

		b5 = new JButton("5");
		b5.setBounds(101, 226, 98, 53);
		gamePanel.add(b5);
		b5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b5.setEnabled(false);

		b6 = new JButton("6");
		b6.setBounds(203, 226, 98, 53);
		gamePanel.add(b6);
		b6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b6.setEnabled(false);

		b7 = new JButton("7");
		b7.setBounds(0, 281, 98, 53);
		gamePanel.add(b7);
		b7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b7.setEnabled(false);

		b8 = new JButton("8");
		b8.setBounds(101, 281, 98, 53);
		gamePanel.add(b8);
		b8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b8.setEnabled(false);

		b9 = new JButton("9");
		b9.setBounds(203, 281, 98, 53);
		gamePanel.add(b9);
		b9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b9.setEnabled(false);

		b0 = new JButton("0");
		b0.setBounds(101, 337, 98, 53);
		gamePanel.add(b0);
		b0.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b0.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		b0.setEnabled(false);

		lblStart = new JLabel("Starts in:");
		lblStart.setBounds(97, 83, 98, 39);
		gamePanel.add(lblStart);
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 21));

		lblTime = new JLabel("");
		lblTime.setBounds(191, 83, 27, 39);
		gamePanel.add(lblTime);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 21));

		lblUserAnswer = new JLabel("");
		lblUserAnswer.setBounds(0, 410, 198, 47);
		gamePanel.add(lblUserAnswer);
		lblUserAnswer.setOpaque(true);
		lblUserAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAnswer.setBackground(new Color(183, 255, 196));
		lblUserAnswer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUserAnswer.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		bEnter = new JButton("Enter");
		bEnter.setBounds(203, 404, 98, 53);
		gamePanel.add(bEnter);
		bEnter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bEnter.setEnabled(false);
		bEnter.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		bClear = new JButton("Clear");
		bClear.setBounds(0, 337, 98, 53);
		gamePanel.add(bClear);
		bClear.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bClear.setEnabled(false);
		bClear.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		lblNumber = new JLabel("Q# 1/5");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumber.setBounds(224, 345, 77, 39);
		gamePanel.add(lblNumber);
		lblNumber.setVisible(false);
		
		losePanel = new JPanel();
		losePanel.setBounds(10, 11, 301, 457);
		contentPane.add(losePanel);
		losePanel.setLayout(null);
		
		lblLose1 = new JLabel("Defeat!");
		lblLose1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLose1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLose1.setBounds(0, 0, 301, 119);
		losePanel.add(lblLose1);
		
		lblLose2 = new JLabel("You lost the minigame...");
		lblLose2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLose2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLose2.setBounds(10, 129, 281, 55);
		losePanel.add(lblLose2);
		
		lblLose3 = new JLabel("Enemy buff has been applied :(");
		lblLose3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLose3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLose3.setBounds(10, 217, 281, 55);
		losePanel.add(lblLose3);
		
		winPanel = new JPanel();
		winPanel.setBounds(10, 11, 301, 457);
		contentPane.add(winPanel);
		winPanel.setLayout(null);
		
		lblWin1 = new JLabel("Victory!");
		lblWin1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWin1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWin1.setBounds(0, 0, 301, 119);
		winPanel.add(lblWin1);
		
		lblWin2 = new JLabel("You won the minigame!");
		lblWin2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblWin2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWin2.setBounds(10, 129, 281, 55);
		winPanel.add(lblWin2);
		
		lblWin3 = new JLabel("Player buff has been applied!");
		lblWin3.setHorizontalAlignment(SwingConstants.CENTER);
		lblWin3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWin3.setBounds(10, 217, 281, 55);
		winPanel.add(lblWin3);
	}

	private static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min); //formula for returning the random number within a specified range
	}

	public static void watch1() {
		seconds = 3;
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds -1; //adds a second
				Integer i = seconds;

				lblTime.setText(i.toString());

				if (seconds == 0) {
					b1.setEnabled(true);
					b2.setEnabled(true);
					b3.setEnabled(true);
					b4.setEnabled(true);
					b5.setEnabled(true);
					b6.setEnabled(true);
					b7.setEnabled(true);
					b8.setEnabled(true);
					b9.setEnabled(true);
					b0.setEnabled(true);
					bEnter.setEnabled(true);
					bClear.setEnabled(true);
					lblNumber.setVisible(true);
					
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
					b1.setEnabled(false);
					b2.setEnabled(false);
					b3.setEnabled(false);
					b4.setEnabled(false);
					b5.setEnabled(false);
					b6.setEnabled(false);
					b7.setEnabled(false);
					b8.setEnabled(false);
					b9.setEnabled(false);
					b0.setEnabled(false);
					bEnter.setEnabled(true);
					bClear.setEnabled(true);

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
	    seconds = 400;
	    System.out.println("methodstart");
	    Timer timerWin = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	System.out.println(seconds);
            	seconds = seconds - 1;
        		if (seconds == 0)
        		{
        			timerWin.cancel();
        			frame.dispose();
        			
        			if(InfiniteMinigame.infMinigameStarted == 1)
        			{
        				System.out.println("minigame started");
        				InfiniteMinigame.RandomMinigame();
        			}
        		}
            }
        };
        timerWin.schedule(task, 0, 10);
    }  
	
	public static void stopTime() {
		timer.cancel();
		System.out.println("timer canceled at " + seconds + " seconds");

		lblStart.setVisible(false);
		label.setText("");
		lblTime.setBounds(147, 94, 27, 39);
		seconds = 26;
		rand();
		watch2();
	}

	private static void stopTime2() {
		timer2.cancel();
		System.out.println("timer canceled at " + seconds + " seconds");

	}

	private static void rand() {
		number = getRandomNumber(1, 4);

		if (number == 1) {
			number1 = getRandomNumber(1, 51);
			number2 = getRandomNumber(1, 51);

			answer = number1 + number2;
			label.setText(number1 + " + " + number2);
		}
		else if (number == 2) {
			number1 = getRandomNumber(1, 51);
			number2 = getRandomNumber(1, 51);

			if (number1 > number2) {
				bigNum = number1;
				smallNum = number2;
			}
			else {
				bigNum = number2;
				smallNum = number1;				
			}

			answer = bigNum - smallNum;
			label.setText(bigNum + " - " + smallNum);
		}
		else if (number == 3) {
			number1 = getRandomNumber(1, 13);
			number2 = getRandomNumber(1, 13);

			answer = number1 * number2;
			label.setText(number1 + " x " + number2);
		}
	}
	
	private static void game() {
		rand();
	}
	
	private static void actionListeners() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "1");
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "2");
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "3");
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "4");
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "5");
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "6");
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "7");
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "8");
			}
		});
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "9");
			}
		});
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText(lblUserAnswer.getText() + "0");
			}
		});
		bEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userAnswer = Integer.parseInt(lblUserAnswer.getText());
				if (userAnswer == answer) {
					score++;
					lblNumber.setText("Q# " + score + "/5");
					
					if (score == 6) {
						gamePanel.setVisible(false);
						winPanel.setVisible(true);
						losePanel.setVisible(false);
						stopTime2();
						WatchWin();
					}
					else {
						game();
					}
				}
				
				lblUserAnswer.setText("");
			}
		});
		bClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserAnswer.setText("");
			}
		});
	}
}