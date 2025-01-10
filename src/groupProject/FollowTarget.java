package groupProject;

import java.awt.EventQueue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FollowTarget extends JFrame {

	private JPanel contentPane;

	private static JLabel CountdownText = new JLabel("5");

	private static JLabel TimerText = new JLabel("TIME: 10");

	private static JLabel target = new JLabel("");

	static int secondsStart = 1500;
	static double seconds = secondsStart;
	static Timer timer = new Timer();

	static int x;
	static int y;

	static int moveX;
	static int moveY;
	
	static boolean gameStart = false;
	
	static boolean cursorTouching = false;

	public static void Watch() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds - 1; //adds a second
				System.out.println(seconds); 

				if (seconds <= secondsStart - 500)
				{
					TimerText.setText("TIME: " + (int)seconds);

					Random rand = new Random();

					moveX = rand.nextInt(21);
					moveY = rand.nextInt(11);

					if(moveX >= 15)
					{
						x = rand.nextInt(5);
					}
					else if(moveX < 15 && moveX >= 10)
					{
						x = 0;
					}
					else if(moveX < 10 && moveX >= 5)
					{
						x = -(rand.nextInt(3));
					}
					else if(moveX > 0 && moveX < 5)
					{
						x = 0;
					}
					
					if(moveY >= 5)
					{
						y = rand.nextInt(3);
					}
					else if(moveY < 5 && moveY >= 0)
					{
						y = 0;
					}

					target.setBounds(target.getX() + x, target.getY() + y, 50, 50);
					
					System.out.println(cursorTouching);
					
					if(cursorTouching == false)
					{
						WatchLose();
					}
				}

				if (seconds >= secondsStart - 500)
				{
					CountdownText.setText("" + (int)(seconds - (secondsStart - 500)));

					if(seconds == secondsStart - 500)
					{
						CountdownText.setVisible(false);
					}
				}
			}
		};
		timer.schedule(task, 0, 10);
	}  

	public static void WatchLose() {
		seconds = 5;
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds - 1; //adds a second
				System.out.println(seconds); 

				if (seconds == 0)
				{
					System.exit(0); // terminate the program
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}  

	public static void WatchWin() {
		seconds = 400;
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds - 1; //adds a second
				System.out.println(seconds); 


				if (seconds == 0)
				{
					System.exit(0); // terminate the program
				}
			}
		};
		timer.schedule(task, 0, 10);
	}  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FollowTarget frame = new FollowTarget();
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
	public FollowTarget() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 359, 336);
		contentPane.add(panel);

		CountdownText.setFont(new Font("High Tower Text", Font.BOLD, 64));
		CountdownText.setBounds(163, 134, 33, 67);
		panel.add(CountdownText);

		TimerText.setFont(new Font("High Tower Text", Font.BOLD, 18));
		TimerText.setBounds(267, 11, 82, 24);
		panel.add(TimerText);
		target.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(gameStart == false)
				{
					Watch();
					gameStart = true;
				}
				
				cursorTouching = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				cursorTouching = false;
			}
		});

		target.setBounds(10, 11, 50, 50);
		target.setIcon(new ImageIcon("graphics/Target_logo.png"));
		panel.add(target);
	}
}
