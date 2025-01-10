package groupProject;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
public class Watch {
static int seconds = 0;
static int coins = 0;
 static Timer timer = new Timer();
	    public Watch(JLabel lblMoney) {
	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                seconds = seconds +1; //adds a second
	                System.out.println(seconds); 
	                addMoney(lblMoney); //adds money every 5 seconds
	            }
	        };
	        timer.schedule(task, 0, 1000);
	    }  
	    
	public static void stopTime() {
		timer.cancel();
		System.out.println("timer canceled at " + seconds + " seconds");
		
	}
	
	public static void addMoney(JLabel lblMoney) {
		if (seconds%5 == 0) { //if it has been five seconds
			coins+=5; //add 5 to coins
			System.out.println("The number of coins is " + coins);
			lblMoney.setText("Money: " + coins); //change label
		}
	}
	
	public static int getMoney() {
		return coins;
	}
	    
	}