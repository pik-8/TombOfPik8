package model.other;

import java.util.Objects;

public class SecondaryStats {

	private int hp;
	private int stm;
	
    private int max_Hp;
	private int maxStamina;
	private int attack;
	private int magicAttack;
	private int defence;
	private int magicDefence;
	private int staminaRegeneration;
	private float staminaResistance;
	private int speed;
	private float speedDeBuffResistance;
	private int luck;
	
	private int load;
	private int maxEquipmentLoad;

	private int travelabelFields;
	private int attackSlots;
	
	
	public SecondaryStats(int hp, int stm, int max_Hp, int maxStamina, int attack, int magicAttack, int defence,
			int magicDefence, int staminaRegeneration, float staminaResistance, int speed, float speedDeBuffResistance,
			int luck, int load, int maxEquipmentLoad, int travelAbelFields, int attackSlots) {

		this.hp = Objects.requireNonNull(hp);
		this.stm = Objects.requireNonNull(stm);
		this.max_Hp = Objects.requireNonNull(max_Hp);
		this.maxStamina = Objects.requireNonNull(maxStamina);
		this.attack = Objects.requireNonNull(attack);
		this.magicAttack = Objects.requireNonNull(magicAttack);
		this.defence = Objects.requireNonNull(defence);
		this.magicDefence = Objects.requireNonNull(magicDefence);
		this.staminaRegeneration = Objects.requireNonNull(staminaRegeneration);
		this.staminaResistance = Objects.requireNonNull(staminaResistance);
		this.speed = Objects.requireNonNull(speed);
		this.speedDeBuffResistance = Objects.requireNonNull(speedDeBuffResistance);
		this.luck = Objects.requireNonNull(luck);
		this.load = Objects.requireNonNull(load);
		this.maxEquipmentLoad = Objects.requireNonNull(maxEquipmentLoad);
		this.travelabelFields = Objects.requireNonNull(travelAbelFields);
		this.attackSlots = Objects.requireNonNull(attackSlots);
	}
	
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getStm() {
		return stm;
	}
	public void setStm(int stm) {
		this.stm = stm;
	}
	public int getMax_Hp() {
		return max_Hp;
	}
	public void setMax_Hp(int max_Hp) {
		this.max_Hp = max_Hp;
	}
	public int getMaxStamina() {
		return maxStamina;
	}
	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
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
	public int getStaminaRegeneration() {
		return staminaRegeneration;
	}
	public void setStaminaRegeneration(int staminaRegeneration) {
		this.staminaRegeneration = staminaRegeneration;
	}
	public float getStaminaResistance() {
		return staminaResistance;
	}
	public void setStaminaResistance(float staminaResistance) {
		this.staminaResistance = staminaResistance;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public float getSpeedDeBuffResistance() {
		return speedDeBuffResistance;
	}
	public void setSpeedDeBuffResistance(float speedDeBuffResistance) {
		this.speedDeBuffResistance = speedDeBuffResistance;
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
	public int getTravelAbelFields() {
		return travelabelFields;
	}
	public void setTravelAbelFields(int travelAbelFields) {
		this.travelabelFields = travelAbelFields;
	}
	public int getAttackSlots() {
		return attackSlots;
	}
	public void setAttackSlots(int attackSlots) {
		this.attackSlots = attackSlots;
	}
}
