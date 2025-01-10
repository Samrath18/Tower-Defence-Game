package groupProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;

public class GoldCoins extends JFrame {

	private static JPanel contentPane;
	private static int time, moneyInt;
	private static String moneyString;
	public static Timer timer2 = new Timer(); //instantiate Watch object

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoldCoins frame = new GoldCoins();
					frame.setVisible(true);
					goldGenerationWatch();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static void goldGenerationWatch() {
		time = 301;
		timer2 = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				time = time -1; //adds a second
				Integer i = time;
				gameScreen1.lblTime.setText(i.toString());

				if (AICore.aiSetting == 0) { // Difficulty easy. 6 gold/5 seconds.
					if (time%5 == 0) { //if it has been five seconds

						if (InGameMinigameSystem.coinRateChange == 0) { // Minigame loss outcome
							gameScreen1.goldInt+=5; //add 5 to coins
						}
						else if (InGameMinigameSystem.coinRateChange == 1) { // Minigame win outcome
							gameScreen1.goldInt+=7; //add 7 to coins
						}
						else { // Regular increase
							gameScreen1.goldInt+=6; //add 6 to coins
						}
						moneyString = Integer.toString(gameScreen1.goldInt);
						gameScreen1.labelGoldAmount.setText(moneyString);
					}
					if (time == 0) {
						timer2.cancel();
						gameScreen1.frame.dispose();
						gameScreen1.labelGoldAmount.setText("10");
						timer2.cancel();
						winScreen.main(new String[0]);
					}
				}
				else if (AICore.aiSetting == 1) { // Difficulty medium. 5 gold/5 seconds.
					if (time%5 == 0) { //if it has been five seconds
						
						if (InGameMinigameSystem.coinRateChange == 0) { // Minigame loss outcome
							gameScreen1.goldInt+=4; //add 4 to coins
						}
						else if (InGameMinigameSystem.coinRateChange == 1) { // Minigame win outcome
							gameScreen1.goldInt+=6; //add 6 to coins
						}
						else { // Regular increase
							gameScreen1.goldInt+=5; //add 5 to coins
						}

						moneyString = Integer.toString(gameScreen1.goldInt);
						gameScreen1.labelGoldAmount.setText(moneyString);
					}
					if (time == 0) {
						timer2.cancel();
						gameScreen1.frame.dispose();
						gameScreen1.labelGoldAmount.setText("10");
						timer2.cancel();
						winScreen.main(new String[0]);
					}
				}
				else if (AICore.aiSetting == 2) { // Difficulty hard. 4 gold/5 seconds.
					if (time%5 == 0) { //if it has been five seconds
						
						if (InGameMinigameSystem.coinRateChange == 0) { // Minigame loss outcome
							gameScreen1.goldInt+=3; //add 3 to coins
						}
						else if (InGameMinigameSystem.coinRateChange == 1) { // Minigame win outcome
							gameScreen1.goldInt+=5; //add 5 to coins
						}
						else { // Regular increase
							gameScreen1.goldInt+=4; //add 4 to coins
						}
						moneyString = Integer.toString(gameScreen1.goldInt);
						gameScreen1.labelGoldAmount.setText(moneyString);
					}
					if (time == 0) {
						timer2.cancel();
						gameScreen1.frame.dispose();
						gameScreen1.labelGoldAmount.setText("10");
						timer2.cancel();
						winScreen.main(new String[0]);
					}
				}
			}
		};
		timer2.schedule(task, 0, 1000);
	}

}