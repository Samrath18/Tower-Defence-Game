package groupProject;

import java.util.Timer;
import java.util.TimerTask;

public class InGameMinigameSystem {

	public static int seconds, number, number2, coinRand, goldChangeInt, coinRateChange;
	private static String goldChangeString;
	public static int inGameMinigame = 0, winOrLose;
	public static Integer i;
	public static Timer timer = new Timer();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (inGameMinigame == 1) {
			outcome();
		}
		else {
			watch();
		}
	}
	
	private static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min); //formula for returning the random number within a specified range
	}
	
	public static void watch() {
		seconds = 300;
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seconds = seconds -1; //adds a second
				i = seconds;

				System.out.println(i);
				
				if (i == 255) {
					number = getRandomNumber(1, 4);
					inGameMinigame = 1;
					selector();
				}
				if (i == 210) {
					number = getRandomNumber(1, 4);
					inGameMinigame = 1;
					selector();
				}
				if (i == 165) {
					number = getRandomNumber(1, 4);
					inGameMinigame = 1;
					selector();
				}
				if (i == 120) {
					number = getRandomNumber(1, 4);
					inGameMinigame = 1;
					selector();
				}
				if (i == 75) {
					number = getRandomNumber(1, 4);
					inGameMinigame = 1;
					selector();
				}
				if (i == 30) {
					number = getRandomNumber(1, 4);
					inGameMinigame = 1;
					selector();
				}
				if (seconds == 0) {
					stopTime();
				}
			}
		};
		timer.schedule(task, 0, 1000);
	} 

	private static void selector() {
		if (number == 1) { // Random Targets
			RandomTargets.main(new String[0]);
			RandomTargets.RunGame();
		}
		else if (number == 2) { // Quick Math
			QuickMath.main(new String[0]);
		}
		else if (number == 3) { // Spam Click
			SpamClick.main(new String[0]);
		}
	}	

	public static void stopTime() {
		timer.cancel();
		System.out.println("timer canceled at " + seconds + " seconds");
		//Display lose end game screen
	}
	
	private static void outcome() {
		
		number2 = getRandomNumber(1, 4);

		if (winOrLose == 0) { // User lost the minigame
			
			System.out.println("user has lost the minigame");
			
			if (number2 == 1) { // Decrease player gold amount by the value of variable coinChange

				QuickMath.lblLose3.setText("Gold Reduction!");
				SpamClick.lblLose3.setText("Gold Reduction!");
				RandomTargets.lblDebuffGoesHere.setText("Gold Reduction!");
				
				coinRand = getRandomNumber(10,26);

				goldChangeInt = Integer.parseInt(gameScreen1.labelGoldAmount.getText()) - coinRand;
				goldChangeString = Integer.toString(goldChangeInt);
				gameScreen1.labelGoldAmount.setText(goldChangeString);
				
				if (Integer.parseInt(gameScreen1.labelGoldAmount.getText()) < 0) {
					gameScreen1.labelGoldAmount.setText("0");
				}
			}
			else if (number2 == 2) {// Decrease the Castle’s HP by 10

				QuickMath.lblLose3.setText("Castle HP -10!");
				SpamClick.lblLose3.setText("Castle HP -10!");
				RandomTargets.lblDebuffGoesHere.setText("Castle HP -10!");

				gameScreen1.towerHP.setValue(gameScreen1.towerHP.getValue() - 10);
			}
			else if (number2 == 3) {// Regenerate the player’s coins slower. Decrease regeneration value by 1 coin/5 seconds for the rest of the game

				QuickMath.lblLose3.setText("Slower Gold Regen!");
				SpamClick.lblLose3.setText("Slower Gold Regen!");
				RandomTargets.lblDebuffGoesHere.setText("Slower Gold Regen!");
				
				coinRateChange = 0;
			}
		}
		else if (winOrLose == 1) { // User won the minigame
			
			System.out.println("user has won the minigame");
			
			if (number2 == 1) {// Increase player gold amount by the value of variable coinChange
				
				QuickMath.lblWin3.setText("Gold Increase!");
				SpamClick.lblWin3.setText("Gold Increase!");
				RandomTargets.lblRewardGoesHere.setText("Gold Increase!");

				System.out.println("number2 = 1");
				coinRand = getRandomNumber(20, 51);
				
				goldChangeInt = Integer.parseInt(gameScreen1.labelGoldAmount.getText()) + coinRand;
				goldChangeString = Integer.toString(goldChangeInt);
				gameScreen1.labelGoldAmount.setText(goldChangeString);

			}
			else if (number2 == 2) {// Increase the Castle’s HP by 10

				QuickMath.lblWin3.setText("Castle HP +10!");
				SpamClick.lblWin3.setText("Castle HP +10!");
				RandomTargets.lblRewardGoesHere.setText("Castle HP +10!");
				
				gameScreen1.towerHP.setValue(gameScreen1.towerHP.getValue() + 10);
				
				if (gameScreen1.towerHP.getValue() > 100) {
					gameScreen1.towerHP.setValue(100);
				}
			}
			else if (number2 == 3) {// Regenerate the player’s coins faster. Increase regeneration value by 1 coin/5 seconds for the rest of the game

				QuickMath.lblWin3.setText("Faster Gold Regen!");
				SpamClick.lblWin3.setText("Faster Gold Regen!");
				RandomTargets.lblRewardGoesHere.setText("Faster Gold Regen!");

				coinRateChange = 1;
			}

		}
	}
}
