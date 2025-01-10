package groupProject;

public class PlayerTroop extends EnemyTroop {
	
	private int cost;

	public PlayerTroop(String troopType, int speed, int health, int attack, String attackStyle, int cost) {
		super(troopType, speed, health, attack, attackStyle);
		this.cost = cost;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void attack() {
		
	}

}
