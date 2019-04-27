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
	private int attack;
	private int magicAttack;
	private int defence;
	private int magicDefence;
	private int speed;
	private float attackResistance;
	private int luck;

	private int load;
	private int maxEquipmentLoad;

	private int stamina;
	private int attackSlots;


	/**
	 *
	 * @param hp
	 * @param action
	 * @param max_Hp
	 * @param maxAction
	 * @param attack
	 * @param magicAttack
	 * @param defence
	 * @param magicDefence
	 * @param speed
	 * @param attackResistance
	 * @param luck
	 * @param load
	 * @param maxEquipmentLoad
	 * @param stamina
	 * @param attackSlots
	 */
	 public SecondaryStats(int hp, int action, int max_Hp, int maxAction, int attack, int magicAttack, int defence,
			int magicDefence, int speed, float attackResistance,
			int luck, int load, int maxEquipmentLoad, int stamina, int attackSlots) {

		this.hp = hp;
		this.action = action;
		this.max_Hp = max_Hp;
		this.maxAction = maxAction;
		this.attack = attack;
		this.magicAttack = magicAttack;
		this.defence = defence;
		this.magicDefence = magicDefence;
		this.attackResistance = attackResistance;
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
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	/**
	 * Adds an amount of hp to the character. If the amount plus the current hp exceeds the maximum hp or is less than zero,
	 * it is handled appropriatly.
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
	
	
	
	public int getAction() {
		return this.action;
	}
	public void setAction(int action){
		this.action = action;
	}
	public int getMax_Hp() {
		return max_Hp;
	}
	public void setMax_Hp(int max_Hp) {
		this.max_Hp = max_Hp;
	}
	public int getMaxAction() {
		return this.maxAction;
	}
	public void setMaxAction(int maxAction) {
		this.maxAction = maxAction;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getMagicAttack() {
		return magicAttack;
	}
	public void setMagicAttack(int magicAttack) {
		this.magicAttack = magicAttack;
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
	public float getAttackResistance() {
		return this.attackResistance;
	}
	public void setAttackResistance(float attackResistance) {
		this.attackResistance = attackResistance;
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


}
