package model.characters;


/**
 * A class containing every stat that is needed for exploring and fighting in a dungeon.
 *
 * @author Hagen
 */
public class SecondaryStats {

	private int hp;
	private int action;

	private int max_Hp;
	private int maxAction;
	private int attackPower;
	private int magicAttackPower;
	private int defence;
	private int magicDefence;
	private int speed;
	private int luck;

	private int load;
	private int maxEquipmentLoad;

	private int stamina;
	private int attackSlots;


	/**
	 *
	 * @param hp: The current hp a character can have. 0 <= hp <= max hp.
	 * @param action: The current amount of actions (attackPowering, walking) a character can do. 0 <= action <= max action.
	 * @param max_Hp: Sets the maximum amount of a character can have.
	 * @param maxAction: Sets the maximum amount of actions a character can have.
	 * @param attackPower: Sets how powerful a character can attack someone.
	 * @param magicAttackPower: Determines how powerful a character can attack someone with magic.
	 * @param defence: Determines how much a character can defend itself against attacks.
	 * @param magicDefence: Determines how much a character can defend itself against magical attacks.
	 * @param speed: Determines how fast a character is.
	 * @param luck: Determines how much luck a character has.
	 * @param load: Determines the weight a character currently has. 0 <= load <= maximum equipment load.
	 * @param maxEquipmentLoad: Sets the maximum amount of weight a character can wield.
	 * @param stamina: Determines the amount of fields one character can cross.
	 * @param attackSlots: The amount of attackSlots one character has.
	 */
	 public SecondaryStats(int hp, int action, int max_Hp, int maxAction, int attackPower, int magicAttackPower, int defence,
			int magicDefence, int speed,
			int luck, int load, int maxEquipmentLoad, int stamina, int attackSlots) {

		 this.max_Hp = max_Hp;
		 this.maxAction = maxAction;
		 this.hp = 0;
		 this.action = 0;
		 this.load = 0;

		 addHp(hp);
		 addAction(action);
		 addLoad(load);

		this.attackPower = attackPower;
		this.magicAttackPower = magicAttackPower;
		this.defence = defence;
		this.magicDefence = magicDefence;
		this.speed = speed;
		this.luck = luck;
		this.load = load;
		this.maxEquipmentLoad = maxEquipmentLoad;
		this.stamina = stamina;
		this.attackSlots = attackSlots;
	}

	SecondaryStats() {}
	
	public int getHp() {
		return hp;
	}
	
	/**
	 * Adds an amount of hp to the character. If the amount plus the current hp exceeds the maximum hp
	 * or is less than zero, it is handled appropriately.
	 * The amount of hp can be negative
	 * @param amount The amount of hp to add.
	 */
	public void addHp(int amount) {
		if(this.hp + amount > this.max_Hp)
			this.hp = this.max_Hp;
		else if(this.hp + amount < 0)
			this.hp = 0;
		else
			this.hp += amount;
	}


	public void addAction(int amount) {
		if(this.action + amount > this.maxAction)
			this.action = this.maxAction;
		else if(this.action + amount < 0)
			this.action = 0;
		else
			this.action += amount;
	}

	public void addLoad(int amount) {
		if(this.load + amount > this.maxEquipmentLoad)
			this.load = this.maxEquipmentLoad;
		else if(this.load + amount < 0)
			this.load = 0;
		else
			this.load += amount;
	}
	
	
	public int getAction() {
		return this.action;
	}
	public int getMax_Hp() {
		return max_Hp;
	}
	public void setMax_Hp(int max_Hp) {
		this.max_Hp = max_Hp;
	}
	public void fillHp() {
		this.hp = this.max_Hp;
	}
	public int getMaxAction() {
		return this.maxAction;
	}
	public void setMaxAction(int maxAction) {
		this.maxAction = maxAction;
	}
	public int getAttackPower() {
		return attackPower;
	}
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}
	public int getMagicAttackPower() {
		return magicAttackPower;
	}
	public void setMagicAttackPower(int magicattackPower) {
		this.magicAttackPower = magicattackPower;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getMagicDefence() {
		return magicDefence;
	}
	public void setMagicDefence(int magicDefence) {
		this.magicDefence = magicDefence;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getLuck() {
		return luck;
	}
	public void setLuck(int luck) {
		this.luck = luck;
	}
	public int getLoad() {
		return load;
	}
	public void setLoad(int load) {
		this.load = load;
	}
	public int getMaxEquipmentLoad() {
		return maxEquipmentLoad;
	}
	public void setMaxEquipmentLoad(int maxEquipmentLoad) {
		this.maxEquipmentLoad = maxEquipmentLoad;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getAttackSlots() {
		return attackSlots;
	}

	public void setAttackSlots(int attackSlots) {
		this.attackSlots = attackSlots;
	}

	@Override
	public String toString() {
		return "SecondaryStats [hp: " + hp + 
				"\naction: " + action + 
				"\nmax_Hp: " + max_Hp + 
				"\nmaxAction: " + maxAction + 
				"\nattackPower: " + attackPower + 
				"\nmagicAttackPower: " + magicAttackPower + 
				"\ndefence: " + defence + 
				"\nmagicDefence: " + magicDefence + 
				"\nspeed: " + speed + 
				"\nluck: " + luck + 
				"\nload: " + load + 
				"\nmaxEquipmentLoad: " + maxEquipmentLoad + 
				"\nstamina: " + stamina + 
				"\nattackSlots: " + attackSlots + "]";
	}
	
	
}
