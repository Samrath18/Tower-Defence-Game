package groupProject;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class AICore {
	
	public static int aiSetting = 0;
	
	public static int difficulty = 1;
	
	public static int spawnDelay = 0;
	public static int nextSpawn = 0;
	/*
	 	aiSetting = 0, Spawns with a 5:3:1 ratio of Goblins, Wizards, and Giants in that order. (Easy)
	 	aiSetting = 1, Spawns with a 3:3:3 ratio of Goblins, Wizards, and Giants in that order. (Medium)
	 	aiSetting = 2, Spawns with a 1:3:5 ratio of Goblins, Wizards, and Giants in that order. (Hard)
	*/
	
	public static int towerHPLoss = 0; // how much hp the tower has lost in the past 15 sec
	
	public static int randTroopNum = 0;
	
	static Timer spawnTimer = new Timer();
	
	static int spawnTime = 3;
	
	static EnemyTroop enemyTroop;
	
	public static void AISpawnTroop() 
	{
		Random rand = new Random();
		
		if(aiSetting == 0) // easy AI 5:3:1
		{
			randTroopNum = rand.nextInt(9); // generate random num from 0-8
			System.out.println("\n" + "randnum: " + randTroopNum);
			if(towerHPLoss <= 4)
			{
				if(randTroopNum <= 4)
				{
					enemyTroop = new EnemyTroop("Goblin", 10, 3, 2, "Melee");
					System.out.println(enemyTroop.getAttack());
					System.out.println(enemyTroop.getAttackStyle());
					System.out.println(enemyTroop.getHealth());
					System.out.println(enemyTroop.getSpeed());
					System.out.println(enemyTroop.getTroopType());
				}
				
				else if(randTroopNum <= 7 && randTroopNum > 4)
				{
					enemyTroop = new EnemyTroop("Wizard", 6, 8, 5, "Ranged");
					System.out.println(enemyTroop.getAttack());
					System.out.println(enemyTroop.getAttackStyle());
					System.out.println(enemyTroop.getHealth());
					System.out.println(enemyTroop.getSpeed());
					System.out.println(enemyTroop.getTroopType());
				}
				
				else if(randTroopNum == 8)
				{
					enemyTroop = new EnemyTroop("Giant", 1, 20, 10, "Melee");
					System.out.println(enemyTroop.getAttack());
					System.out.println(enemyTroop.getAttackStyle());
					System.out.println(enemyTroop.getHealth());
					System.out.println(enemyTroop.getSpeed());
					System.out.println(enemyTroop.getTroopType());
				}
			}
			
			else if(towerHPLoss > 4)
			{
				enemyTroop = new EnemyTroop("Goblin", 10, 3, 2, "Melee");
			}
		}
		
		if(aiSetting == 1) // medium AI 3:3:3
		{
			randTroopNum = rand.nextInt(9); // generate random num from 0-8
			System.out.println("\n" + "randnum: " + randTroopNum);
			if(towerHPLoss <= 4)
			{
				if(randTroopNum <= 2)
				{
					EnemyTroop enemyTroop = new EnemyTroop("Goblin", 10, 3, 2, "Melee");
					System.out.println(enemyTroop.getAttack());
					System.out.println(enemyTroop.getAttackStyle());
					System.out.println(enemyTroop.getHealth());
					System.out.println(enemyTroop.getSpeed());
					System.out.println(enemyTroop.getTroopType());
				}
				
				else if(randTroopNum <= 5 && randTroopNum > 2)
				{
					EnemyTroop enemyTroop = new EnemyTroop("Wizard", 6, 8, 5, "Ranged");
					System.out.println(enemyTroop.getAttack());
					System.out.println(enemyTroop.getAttackStyle());
					System.out.println(enemyTroop.getHealth());
					System.out.println(enemyTroop.getSpeed());
					System.out.println(enemyTroop.getTroopType());
				}
				
				else if(randTroopNum <= 8 && randTroopNum > 5)
				{
					EnemyTroop enemyTroop = new EnemyTroop("Giant", 1, 20, 10, "Melee");
					System.out.println(enemyTroop.getAttack());
					System.out.println(enemyTroop.getAttackStyle());
					System.out.println(enemyTroop.getHealth());
					System.out.println(enemyTroop.getSpeed());
					System.out.println(enemyTroop.getTroopType());
				}
			}
			
			else if(towerHPLoss > 4)
			{
				EnemyTroop enemyTroop = new EnemyTroop("Goblin", 10, 3, 2, "Melee");
			}
		}
		
		if(aiSetting == 2) // hard AI 1:3:5
		{
			randTroopNum = rand.nextInt(9); // generate random num from 0-8
			System.out.println("\n" + "randnum: " + randTroopNum);
			if(towerHPLoss <= 4)
			{
				if(randTroopNum == 0)
				{
					EnemyTroop enemyTroop = new EnemyTroop("Goblin", 2, 3, 2, "Melee");
					System.out.println(enemyTroop.getAttack());
					System.out.println(enemyTroop.getAttackStyle());
					System.out.println(enemyTroop.getHealth());
					System.out.println(enemyTroop.getSpeed());
					System.out.println(enemyTroop.getTroopType());
				}
				
				else if(randTroopNum <= 3 && randTroopNum > 0)
				{
					EnemyTroop enemyTroop = new EnemyTroop("Wizard", 1, 8, 5, "Ranged");
					System.out.println(enemyTroop.getAttack());
					System.out.println(enemyTroop.getAttackStyle());
					System.out.println(enemyTroop.getHealth());
					System.out.println(enemyTroop.getSpeed());
					System.out.println(enemyTroop.getTroopType());
				}
				
				else if(randTroopNum <= 8 && randTroopNum > 3)
				{
					EnemyTroop enemyTroop = new EnemyTroop("Giant", 1, 20, 10, "Melee");
					System.out.println(enemyTroop.getAttack());
					System.out.println(enemyTroop.getAttackStyle());
					System.out.println(enemyTroop.getHealth());
					System.out.println(enemyTroop.getSpeed());
					System.out.println(enemyTroop.getTroopType());
				}
			}
			
			else if(towerHPLoss > 4)
			{
				EnemyTroop enemyTroop = new EnemyTroop("Goblin", 10, 3, 2, "Melee");
			}
		}
	}
	
	public static void spawnEnemyTime()
	{
		spawnTime = 301;
		spawnDelay = 0;
		nextSpawn = 0;
		spawnTimer = new Timer();
		TimerTask spawnTimerTask = new TimerTask() 
		{
			@Override
			public void run() {
				spawnTime = spawnTime - 1;
				
				System.out.println(spawnTime);
				if (spawnTime <= 300 && spawnTime > 240)
				{
					if(aiSetting == 0)
					{
						if(spawnTime == 300)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 3;
							nextSpawn = spawnTime - spawnDelay;
						}
						
						if (spawnTime == nextSpawn)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 3;
							nextSpawn = spawnTime - spawnDelay;
						}
					}
					
					else if(aiSetting == 1 || aiSetting == 2)
					{
						if(spawnTime == 300)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 6;
							nextSpawn = spawnTime - spawnDelay;
						}
						
						if (spawnTime == nextSpawn)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 6;
							nextSpawn = spawnTime - spawnDelay;
						}
					}
				}
				
				else if (spawnTime <= 240 && spawnTime > 180)
				{
					if(aiSetting == 0 || aiSetting == 1 || aiSetting == 2)
					{
						if(spawnTime == 240)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 2;
							nextSpawn = spawnTime - spawnDelay;
						}
						
						if (spawnTime == nextSpawn)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 2;
							nextSpawn = spawnTime - spawnDelay;
						}
					}
				}
				else if (spawnTime <= 180 && spawnTime > 120)
				{
					if(aiSetting == 0 || aiSetting == 1 || aiSetting == 2)
					{
						if(spawnTime == 180)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 2;
							nextSpawn = spawnTime - spawnDelay;
						}
						
						if (spawnTime == nextSpawn)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 2;
							nextSpawn = spawnTime - spawnDelay;
						}
					}

				}
				else if (spawnTime <= 120 && spawnTime > 60)
				{
					if(aiSetting == 0 || aiSetting == 1 || aiSetting == 2)
					{
						if(spawnTime == 120)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 1;
							nextSpawn = spawnTime - spawnDelay;
						}
						
						if (spawnTime == nextSpawn)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 1;
							nextSpawn = spawnTime - spawnDelay;
						}
					}
				}
				else if (spawnTime <= 60 && spawnTime > 0)
				{
					if(aiSetting == 0 || aiSetting == 1 || aiSetting == 2)
					{
						if(spawnTime == 60)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 1;
							nextSpawn = spawnTime - spawnDelay;
						}
						
						if (spawnTime == nextSpawn)
						{
							AISpawnTroop();
							gameScreen1.spawnEnemy(enemyTroop);
							spawnDelay = 1;
							nextSpawn = spawnTime - spawnDelay;
						}
					}
				}
			}
		};
		spawnTimer.schedule(spawnTimerTask, 0, 1000);	
	}
}
