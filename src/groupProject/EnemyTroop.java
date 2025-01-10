package groupProject;

import java.util.Timer;

public class EnemyTroop {
	private String troopType;
	private int speed;
	private int health;
	private int attack;
	private String attackStyle;
	static Timer timer = new Timer();
	
	public Timer getTimer() {
		return timer;
	}

	public EnemyTroop (String troopType, int speed, int health, int attack, String attackStyle) {
		this.troopType = troopType;
		this.speed = speed;
		this.health = health;
		this.attack = attack;
		this.attackStyle = attackStyle;
	}
	
	public String getTroopType() {
		return this.troopType;
	}

	public void setTroopType(String troopType) {
		this.troopType = troopType;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public String getAttackStyle() {
		return this.attackStyle;
	}

	public void setAttackStyle(String attackStyle) {
		this.attackStyle = attackStyle;
	}
	
	public void attack() {
		
	}
}