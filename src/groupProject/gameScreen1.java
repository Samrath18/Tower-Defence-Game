package groupProject;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JProgressBar;

public class gameScreen1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static JLabel labelArcher;
	static Timer archerTimer = new Timer();
	static Timer puncherTimer = new Timer();
	static Timer raiderTimer = new Timer();
	static Timer gunnerTimer = new Timer();
	static Timer sniperTimer = new Timer();
	static Timer soldierTimer = new Timer();
	static Timer warriorTimer = new Timer();
	static Image archerImage = null;
	static Timer spawnTimer = new Timer();
	static Timer goblinTimer = new Timer();
	static Timer wizardTimer = new Timer();
	static Timer giantTimer = new Timer();
	static Timer enemyTimer = new Timer();
	static JLabel labelEnemyS = new JLabel(""), labelEnemyM = new JLabel(""), labelEnemyL = new JLabel("");
	private static Timer timer = new Timer();
	public static JFrame frame;
	private static JPanel panel;
	public static int goldInt, spawnTime;
	private static String goldString;
	public static JLabel labelLow, labelHalf, labelFull, labelPuncher, labelRaider, labelSniper;
	public static JLabel labelShotgunner, labelSoldier, labelWarrior, labelBkg, labelGoldAmount, lblGoldWarning, lblTime;
	private static int raiderCost = 10, puncherCost = 15, soldierCost = 25, archerCost = 25, shotgunnerCost = 35, sniperCost = 45, superWarriarCost = 60;
	private static int seconds, hp = 1000;
	private static Image bkgImage;
	private static JButton archerBtn, puncherBtn, raiderBtn, shotGunnerBtn, sniperBtn, soldierBtn, superWarriarBtn, damageButton;
	private static int ar, pu,ra, gu, sn, so, wa = 267, en = 390;
	public static JProgressBar towerHP;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame = new gameScreen1();
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					frame.getContentPane().add(panel);
					frame.setSize(900,600);
					frame.setVisible(true);
					frame.pack();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gameScreen1() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 5, 5));
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("graphics/backgroundscene.png")))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 600);	
		//		Image background = Toolkit.getDefaultToolkit().createImage("graphics/backgroundscene.png");
		//	    panel.Image(background, 0, 0, null);


		Image bkgImage = null, enemyLImage = null, enemyMImage = null;
		Image enemySImage = null, puncherImage = null, raiderImage = null, shotgunnerImage = null;
		Image sniperImage = null, soldierImage = null, superWarriarImage = null, towerFImage = null;
		Image towerHImage = null, towerLImage = null;
		try {
			archerImage = ImageIO.read(new File("graphics/ARCHER (brown).png"));
			bkgImage = ImageIO.read(new File("graphics/backgroundscene.png"));
			enemyLImage = ImageIO.read(new File("graphics/ENEMY (large).png"));
			enemyMImage = ImageIO.read(new File("graphics/ENEMY (medium).png"));
			enemySImage = ImageIO.read(new File("graphics/ENEMY (small).png"));
			puncherImage = ImageIO.read(new File("graphics/PUNCHER (blue).png"));
			raiderImage = ImageIO.read(new File("graphics/RAIDER (red).png"));
			shotgunnerImage = ImageIO.read(new File("graphics/SHOTGUNNER (purple).png"));
			sniperImage = ImageIO.read(new File("graphics/SNIPER (pink).png"));
			soldierImage = ImageIO.read(new File("graphics/SOLDIER (green).png"));
			superWarriarImage = ImageIO.read(new File("graphics/SUPER WARRIAR (orange).png"));
			towerFImage = ImageIO.read(new File("graphics/TOWER (full).png"));
			towerHImage = ImageIO.read(new File("graphics/Tower (half).png"));
			towerLImage = ImageIO.read(new File("graphics/TOWER (low).png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		//labelBkg.setVisible(true);
		contentPane.setLayout(null);
		panel.setLayout(null);		

		// PLAYER TROOP BUTTONS
		archerBtn = new JButton("Archer");
		archerBtn.setFont(new Font("High Tower Text", Font.PLAIN, 15));
		archerBtn.setBounds(430, 554, 130, 23);

		puncherBtn = new JButton("Puncher");
		puncherBtn.setFont(new Font("High Tower Text", Font.PLAIN, 15));
		puncherBtn.setBounds(150, 554, 130, 23);

		raiderBtn = new JButton("Raider");
		raiderBtn.setFont(new Font("High Tower Text", Font.PLAIN, 15));
		raiderBtn.setBounds(10, 554, 130, 23);

		shotGunnerBtn = new JButton("Shotgunner");
		shotGunnerBtn.setFont(new Font("High Tower Text", Font.PLAIN, 15));
		shotGunnerBtn.setBounds(570, 554, 130, 23);

		sniperBtn = new JButton("Sniper");
		sniperBtn.setFont(new Font("High Tower Text", Font.PLAIN, 15));
		sniperBtn.setBounds(710, 554, 130, 23);

		soldierBtn = new JButton("Soldier");
		soldierBtn.setFont(new Font("High Tower Text", Font.PLAIN, 15));
		soldierBtn.setBounds(290, 554, 130, 23);

		superWarriarBtn = new JButton("Super Warrior");
		superWarriarBtn.setFont(new Font("High Tower Text", Font.PLAIN, 15));
		superWarriarBtn.setBounds(850, 554, 150, 23);

		JButton btn = new JButton("enemy");
		btn.setBounds(250, 98, 67, 23);
		panel.add(btn);
		btn.setVisible(false);
		
		panel.add(archerBtn);
		panel.add(puncherBtn);
		panel.add(raiderBtn);
		panel.add(shotGunnerBtn);
		panel.add(sniperBtn);
		panel.add(soldierBtn);
		panel.add(superWarriarBtn);
		
		
		// ENEMY TROOP LABELS		
		labelEnemyS = new JLabel("");
		labelEnemyS.setIcon(new ImageIcon(enemySImage));
		labelEnemyS.setBounds(310, 5, 50, 50);
		panel.add(labelEnemyS);
		setImage(labelEnemyS, enemySImage);
		labelEnemyS.setVisible(false); 

		labelEnemyM = new JLabel("");
		labelEnemyM.setIcon(new ImageIcon(enemyMImage));
		labelEnemyM.setBounds(309, 5, 50, 50);
		panel.add(labelEnemyM);
		setImage(labelEnemyM, enemyMImage);
		labelEnemyM.setVisible(false); 

		labelEnemyL = new JLabel(""); //fix transparency
		labelEnemyL.setIcon(new ImageIcon(enemyLImage));
		labelEnemyL.setBounds(309, 5, 50, 50);
		panel.add(labelEnemyL);
		setImage(labelEnemyL, enemyLImage);
		labelEnemyL.setVisible(false); 
	
		// TOWER LABELS
		labelFull = new JLabel("");
		labelFull.setIcon(new ImageIcon(towerFImage));
		labelFull.setBounds(-84, 53, 383, 476);
		panel.add(labelFull); 
		setImage(labelFull, towerFImage);

		labelHalf = new JLabel("");
		labelHalf.setIcon(new ImageIcon(towerHImage));
		labelHalf.setBounds(-84, 53, 383, 476);
		panel.add(labelHalf); 
		setImage(labelHalf, towerHImage);
		labelHalf.setVisible(false);

		labelLow = new JLabel("");
		labelLow.setIcon(new ImageIcon(towerLImage));
		labelLow.setBounds(-84, 53, 383, 476);
		panel.add(labelLow);
		setImage(labelLow, towerLImage);

		// PLAYER TROOP LABELS				
		labelRaider = new JLabel("");
		labelRaider.setIcon(new ImageIcon(raiderImage));
		labelRaider.setBounds(334, 5, 50, 50);
		panel.add(labelRaider);
		setImage(labelRaider, raiderImage);
		labelRaider.setVisible(false); 
		
		labelPuncher = new JLabel("");
		labelPuncher.setIcon(new ImageIcon(puncherImage));
		labelPuncher.setBounds(334, 5, 50, 50);
		panel.add(labelPuncher);
		setImage(labelPuncher, puncherImage);
		labelPuncher.setVisible(false);
		
		labelSoldier = new JLabel("");
		labelSoldier.setIcon(new ImageIcon(soldierImage));
		labelSoldier.setBounds(334, 5, 50, 50);
		panel.add(labelSoldier);
		setImage(labelSoldier, soldierImage);
		labelSoldier.setVisible(false);
		
		labelArcher = new JLabel("");
		labelArcher.setIcon(new ImageIcon(raiderImage));
		labelArcher.setBounds(334, 5, 50, 50);
		panel.add(labelArcher);
		setImage(labelArcher, raiderImage);
		labelArcher.setVisible(false); 

		labelShotgunner = new JLabel("");
		labelShotgunner.setIcon(new ImageIcon(shotgunnerImage));
		labelShotgunner.setBounds(334, 5, 50, 50);
		panel.add(labelShotgunner);
		setImage(labelShotgunner, shotgunnerImage);
		labelShotgunner.setVisible(false); 

		labelSniper = new JLabel("");
		labelSniper.setIcon(new ImageIcon(sniperImage));
		labelSniper.setBounds(344, 5, 50, 50);
		panel.add(labelSniper);
		setImage(labelSniper, sniperImage);
		labelSniper.setVisible(false); 

		labelWarrior = new JLabel("");
		labelWarrior.setIcon(new ImageIcon(superWarriarImage));
		labelWarrior.setBounds(334, 5, 50, 50);
		panel.add(labelWarrior);
		setImage(labelWarrior, superWarriarImage);
		labelWarrior.setVisible(false); 

		contentPane.add(panel);

		labelBkg = new JLabel("");
		labelBkg.setIcon(new ImageIcon(bkgImage));
		labelBkg.setBounds(0, 0, 1000, 600);
		setImage(labelBkg, bkgImage);
		labelHalf.setVisible(false);

		labelGoldAmount = new JLabel("10");
		labelGoldAmount.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 0, 255), null, new Color(128, 0, 255), null));
		labelGoldAmount.setFont(new Font("High Tower Text", Font.PLAIN, 30));
		labelGoldAmount.setHorizontalAlignment(SwingConstants.CENTER);
		labelGoldAmount.setBounds(925, 22, 55, 33);
		panel.add(labelGoldAmount);

		lblGoldWarning = new JLabel("Not enough gold!");
		lblGoldWarning.setForeground(new Color(255, 0, 0));
		lblGoldWarning.setFont(new Font("High Tower Text", Font.PLAIN, 30));
		lblGoldWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoldWarning.setBounds(671, 22, 244, 33);
		panel.add(lblGoldWarning);
		lblGoldWarning.setVisible(false);
		
		lblTime = new JLabel("00:00");
		lblTime.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 0, 255), null, new Color(128, 0, 255), null));
		lblTime.setFont(new Font("High Tower Text", Font.PLAIN, 30));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(895, 65, 85, 50);
		panel.add(lblTime);
		
		towerHP = new JProgressBar();
		towerHP.setForeground(new Color(255, 0, 0));
		towerHP.setBounds(28, 10, 256, 33);
		panel.add(towerHP);
		
		damageButton = new JButton("-5 Tower HP");
		damageButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		damageButton.setBounds(379, 83, 193, 70);
		panel.add(damageButton);

		//		JLabel labelArcher = new JLabel("");
		//		labelArcher.setIcon(new ImageIcon(archerImage));
		//		labelArcher.setVisible(false);
		//		labelArcher.setBounds(267, 250, 50, 50);

		//		panel.add(labelArcher);s
		//		
		panel.add(labelBkg);

		//                           BUTTON ACTION LISTENERS
		//______________________________________________________________________


		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelEnemyM.setVisible(true);
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						en = en - 20;
						labelEnemyM.setBounds(en, 350, 50, 50);
						if (intersects(labelEnemyM,labelFull))
							{
							labelEnemyM.setVisible(false);
							}
					}
				};
				enemyTimer.schedule(task, 0, 100);			
			}  // action performed
		});  // archer button action listener

		//                           MINIGAME TIMER
		//______________________________________________________________________
		
		InGameMinigameSystem.main(new String[0]);		
		
		//                           ENEMY SPAWNING
		//______________________________________________________________________

		AICore.spawnEnemyTime();
		
		//                           GOLD GENERATION AND GAME TIMER
		//______________________________________________________________________

		labelGoldAmount.setText("10");
		goldInt = 0;
		GoldCoins.main(new String[0]);

		//                           TOWER HP
		//______________________________________________________________________

		towerHP.setMaximum(100);
		towerHP.setValue(100);
		
		//Example
		//If damage taken
		damageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				towerHP.setValue(towerHP.getValue() - 5);
				
				if (towerHP.getValue() == 50) {
					labelFull.setVisible(false);
					labelHalf.setVisible(true);
				}
				if (towerHP.getValue() == 25) {
					labelHalf.setVisible(false);
					labelLow.setVisible(true);
				}
				if (towerHP.getValue() <= 0) {
					towerHP.setValue(100);
					frame.dispose();
					GoldCoins.timer2.cancel();
					goblinTimer.cancel();
					wizardTimer.cancel();
					giantTimer.cancel();
					AICore.spawnTimer.cancel();
					InGameMinigameSystem.timer.cancel();
					LoseScreen.main(new String[0]);
				}
			}
		});
		
		//                           BUTTON ACTION LISTENERS
		//______________________________________________________________________


		raiderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spawnDelay();

				//Gold cost
				if (Integer.parseInt(labelGoldAmount.getText()) - raiderCost < 0) { // If not enough gold to purchase
					lblGoldWarning.setVisible(true);
					seconds = 4;
					timer = new Timer();
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							seconds = seconds -1; //adds a second

							if (seconds == 0) {
								timer.cancel();
								lblGoldWarning.setVisible(false);
							}
						}
					};
					timer.schedule(task, 0, 1000);
				}
				else {

					//Gold deduction
					goldInt = Integer.parseInt(labelGoldAmount.getText()) - raiderCost;
					goldString = Integer.toString(goldInt);
					labelGoldAmount.setText(goldString);

					labelRaider.setVisible(true);
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							ra = ra + 20;
							labelRaider.setBounds(ra, 450, 50, 50);

						}
					};

					raiderTimer.schedule(task, 0, 100);	
				}
			}  // action performed
		});  // raider button action listener

		puncherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spawnDelay();

				//Gold cost
				if (Integer.parseInt(labelGoldAmount.getText()) - puncherCost < 0) { // If not enough gold to purchase
					lblGoldWarning.setVisible(true);
					seconds = 4;
					timer = new Timer();
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							seconds = seconds -1; //adds a second

							if (seconds == 0) {
								timer.cancel();
								lblGoldWarning.setVisible(false);
							}
						}
					};
					timer.schedule(task, 0, 1000);
				}
				else {

					//Gold deduction
					goldInt = Integer.parseInt(labelGoldAmount.getText()) - puncherCost;
					goldString = Integer.toString(goldInt);
					labelGoldAmount.setText(goldString);

					labelPuncher.setVisible(true);
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							pu = pu + 20;
							labelPuncher.setBounds(pu, 450, 50, 50);

						}
					};
					puncherTimer.schedule(task, 0, 100);		
				}
			}  // action performed
		});  // puncher button action listener

		soldierBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spawnDelay();

				//Gold cost
				if (Integer.parseInt(labelGoldAmount.getText()) - soldierCost < 0) { // If not enough gold to purchase
					lblGoldWarning.setVisible(true);
					seconds = 4;
					timer = new Timer();
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							seconds = seconds -1; //adds a second

							if (seconds == 0) {
								timer.cancel();
								lblGoldWarning.setVisible(false);
							}
						}
					};
					timer.schedule(task, 0, 1000);
				}
				else {

					//Gold deduction
					goldInt = Integer.parseInt(labelGoldAmount.getText()) - soldierCost;
					goldString = Integer.toString(goldInt);
					labelGoldAmount.setText(goldString);

					labelSoldier.setVisible(true);
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							so = so + 20;
							labelSoldier.setBounds(so, 450, 50, 50);

						}
					};
					soldierTimer.schedule(task, 0, 100);	
				}
			}  // action performed
		});  // soldier button action listener

		archerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spawnDelay();

				//Gold cost
				if (Integer.parseInt(labelGoldAmount.getText()) - archerCost < 0) { // If not enough gold to purchase
					lblGoldWarning.setVisible(true);
					seconds = 4;
					timer = new Timer();
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							seconds = seconds -1; //adds a second

							if (seconds == 0) {
								timer.cancel();
								lblGoldWarning.setVisible(false);
							}
						}
					};
					timer.schedule(task, 0, 1000);
				}
				else {

					//Gold deduction
					goldInt = Integer.parseInt(labelGoldAmount.getText()) - archerCost;
					goldString = Integer.toString(goldInt);
					labelGoldAmount.setText(goldString);

					labelSoldier.setVisible(true);
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							so = so + 20;
							labelArcher.setBounds(so, 450, 50, 50);

						}
					};
					archerTimer.schedule(task, 0, 100);	
				}
			}  // action performed
		});  // archer button action listener

		shotGunnerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spawnDelay();

				//Gold cost
				if (Integer.parseInt(labelGoldAmount.getText()) - shotgunnerCost < 0) { // If not enough gold to purchase
					lblGoldWarning.setVisible(true);
					seconds = 4;
					timer = new Timer();
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							seconds = seconds -1; //adds a second

							if (seconds == 0) {
								timer.cancel();
								lblGoldWarning.setVisible(false);
							}
						}
					};
					timer.schedule(task, 0, 1000);
				}
				else {

					//Gold deduction
					goldInt = Integer.parseInt(labelGoldAmount.getText()) - shotgunnerCost;
					goldString = Integer.toString(goldInt);
					labelGoldAmount.setText(goldString);

					labelShotgunner.setVisible(true);
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							gu = gu + 20;
							labelShotgunner.setBounds(gu, 450, 50, 50);

						}
					};
					gunnerTimer.schedule(task, 0, 100);			
				}
			}  // action performed
		});  // shot gunner button action listener

		sniperBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spawnDelay();

				//Gold cost
				if (Integer.parseInt(labelGoldAmount.getText()) - sniperCost < 0) { // If not enough gold to purchase
					lblGoldWarning.setVisible(true);
					seconds = 4;
					timer = new Timer();
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							seconds = seconds -1; //adds a second

							if (seconds == 0) {
								timer.cancel();
								lblGoldWarning.setVisible(false);
							}
						}
					};
					timer.schedule(task, 0, 1000);
				}
				else {

					//Gold deduction
					goldInt = Integer.parseInt(labelGoldAmount.getText()) - sniperCost;
					goldString = Integer.toString(goldInt);
					labelGoldAmount.setText(goldString);

					labelSniper.setVisible(true);
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							sn = sn + 20;
							labelSniper.setBounds(sn, 450, 50, 50);

						}
					};
					sniperTimer.schedule(task, 0, 100);			
				}
			}  // action performed
		});  // sniper button action listener

		superWarriarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				spawnDelay();

				//Gold cost
				if (Integer.parseInt(labelGoldAmount.getText()) - superWarriarCost < 0) { // If not enough gold to purchase
					lblGoldWarning.setVisible(true);
					seconds = 4;
					timer = new Timer();
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							seconds = seconds -1; //adds a second

							if (seconds == 0) {
								timer.cancel();
								lblGoldWarning.setVisible(false);
							}
						}
					};
					timer.schedule(task, 0, 1000);
				}
				else {

					//Gold deduction
					goldInt = Integer.parseInt(labelGoldAmount.getText()) - superWarriarCost;
					goldString = Integer.toString(goldInt);
					labelGoldAmount.setText(goldString);

					labelWarrior.setVisible(true);
					TimerTask task = new TimerTask() {
						@Override
						public void run() {
							wa = wa + 20;
							labelWarrior.setBounds(wa, 450, 50, 50);

						}
					};
					warriorTimer.schedule(task, 0, 100);	
				}
			}  // action performed
		});  // warrior button action listener

	}//main

	public void spawnDelay() 
	{
		archerBtn.setEnabled(false);
		raiderBtn.setEnabled(false);
		puncherBtn.setEnabled(false);
		sniperBtn.setEnabled(false);
		soldierBtn.setEnabled(false);
		shotGunnerBtn.setEnabled(false);
		superWarriarBtn.setEnabled(false);
		
		spawnTime = 3;
		spawnTimer = new Timer();
		TimerTask spawnTimerTask = new TimerTask() 
		{
			@Override
			public void run() {
				spawnTime = spawnTime - 1;
				
				System.out.println(spawnTime);
				
				if(spawnTime == 0)
				{
					archerBtn.setEnabled(true);
					raiderBtn.setEnabled(true);
					puncherBtn.setEnabled(true);
					sniperBtn.setEnabled(true);
					soldierBtn.setEnabled(true);
					shotGunnerBtn.setEnabled(true);
					superWarriarBtn.setEnabled(true);
					
					spawnTimer.cancel();
				}
			}
		};
		spawnTimer.schedule(spawnTimerTask, 0, 1000);	
	}
	
	public static void spawnEnemy (EnemyTroop enemy)
	{
		
		if(enemy.getTroopType() == "Goblin")
		{
			goblinTimer = new Timer();
			labelEnemyS.setVisible(true);
			labelEnemyS.setBounds(844, 470, 50, 50);
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					labelEnemyS.setBounds(labelEnemyS.getX() - (enemy.getSpeed()/2), 425, 50, 50);
					collide(labelEnemyS);
				}
			};
			goblinTimer.schedule(task, 0, 200);
		}
		
		else if(enemy.getTroopType() == "Wizard")
		{
			wizardTimer = new Timer();
			labelEnemyM.setVisible(true);
			labelEnemyM.setBounds(844, 470, 50, 50);
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					labelEnemyM.setBounds(labelEnemyM.getX() - (enemy.getSpeed()), 425, 50, 50);
					collide(labelEnemyM);	
					}
			};
			wizardTimer.schedule(task, 0, 100);
		}
		
		else if(enemy.getTroopType() == "Giant")
		{
			giantTimer = new Timer();
			labelEnemyL.setVisible(true);
			labelEnemyL.setBounds(844, 470, 50, 50);
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					labelEnemyL.setBounds(labelEnemyL.getX() - (enemy.getSpeed()), 425, 50, 50);
					collide(labelEnemyL);			
				}
			};
			giantTimer.schedule(task, 0, 200);
		}
	}

	public static void attack(JLabel label)
	{
		if(label.isVisible()) {			
		
		towerHP.setValue(towerHP.getValue() - 5);
		
		if (towerHP.getValue() == 50) {
			labelFull.setVisible(false);
			labelHalf.setVisible(true);
		}
		 if (towerHP.getValue() == 25) {
			labelHalf.setVisible(false);
			labelLow.setVisible(true);
		}
		 if (towerHP.getValue() <= 0) {
			frame.dispose();
			GoldCoins.timer2.cancel();
			InGameMinigameSystem.timer.cancel();
			LoseScreen.main(new String[0]);
		}
		}
	}
	
	public void setImage(JButton button , Image pic) {

		pic = pic.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT); // scales image to size

		button.setDisabledIcon(new ImageIcon(pic));

		button.setIcon(new ImageIcon(pic)); // add image to item

	}


	public void setImage(JLabel label , Image pic) {

		pic = pic.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT); // scales image to size

		label.setDisabledIcon(new ImageIcon(pic));

	}

	public static boolean intersects(JLabel testa, JLabel testb) {
	    Area areaA = new Area(testa.getBounds());
	    Area areaB = new Area(testb.getBounds());

	    return areaA.intersects(areaB.getBounds2D());
	}
	 public static void collide(JLabel label) {
		 
		 if (intersects(label,labelRaider)) {
				labelRaider.setVisible(false);
				labelRaider.setBounds(labelRaider.getX(), labelRaider.getY() + 200, labelRaider.getWidth(), labelRaider.getHeight());
			}
			else if (intersects(label,labelArcher)) {
				labelArcher.setVisible(false);
				labelArcher.setBounds(labelArcher.getX(), labelArcher.getY() + 200, labelArcher.getWidth(), labelArcher.getHeight());
			}
			else if (intersects(label,labelWarrior)) {
				labelWarrior.setVisible(false);
				labelWarrior.setBounds(labelWarrior.getX(), labelWarrior.getY() + 200, labelWarrior.getWidth(), labelWarrior.getHeight());
			}
			else if (intersects(label,labelPuncher)) {
				labelPuncher.setVisible(false);
				labelPuncher.setBounds(labelPuncher.getX(), labelPuncher.getY() + 200, labelPuncher.getWidth(), labelPuncher.getHeight());
			}
			else if (intersects(label,labelSoldier)) {
				labelSoldier.setVisible(false);
				labelSoldier.setBounds(labelSoldier.getX(), labelSoldier.getY() + 200, labelSoldier.getWidth(), labelSoldier.getHeight());
			}
			else if (intersects(label,labelSniper)) {
				labelSniper.setVisible(false);
				labelSniper.setBounds(labelSniper.getX(), labelSniper.getY() + 200, labelSniper.getWidth(), labelSniper.getHeight());
			}
			else if (intersects(label,labelShotgunner)) {
				labelShotgunner.setVisible(false);
				labelShotgunner.setBounds(labelShotgunner.getX(), labelShotgunner.getY() + 200, labelShotgunner.getWidth(), labelShotgunner.getHeight());
			}
		 //if enemy and player troop collide
		 
		 if (intersects(label,labelFull))
			{
				attack(label);
				label.setVisible(false);						
			}// if enemy collides to tower
		 
	 }// collide method

}