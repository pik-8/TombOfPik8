package model.effects;

import model.characters.Character;
import model.characters.SecondaryStats;
import model.dungeon.Square;
import model.items.Equipment;

public class DamageEffect extends Effect {


	private final float flatDamage;
	private final float percentOfMaxHealthDamage;
	private final float percentOfMissingHealthDamage;
	private final float percentOfCurrentHealthDamage;

	public DamageEffect(String name, String description, int duration, boolean instantApply, float flatDamage,
						float percentOfMaxHealthDamage, float percentOfMissingHealthDamage,
						float percentOfCurrentHealthDamage) {
		super(name, description, duration, instantApply);
		this.flatDamage = flatDamage;
		this.percentOfMaxHealthDamage = percentOfMaxHealthDamage;
		this.percentOfMissingHealthDamage = percentOfMissingHealthDamage;
		this.percentOfCurrentHealthDamage = percentOfCurrentHealthDamage;
	}


	public DamageEffect(String name, String description, int duration, float flatDamage, float percentOfMaxHealthDamage,
						float percentOfMissingHealthDamage, float percentOfCurrentHealthDamage) {
		super(name, description, duration);
		this.flatDamage = flatDamage;
		this.percentOfMaxHealthDamage = percentOfMaxHealthDamage;
		this.percentOfMissingHealthDamage = percentOfMissingHealthDamage;
		this.percentOfCurrentHealthDamage = percentOfCurrentHealthDamage;
	}
	
	public DamageEffect() {
		super("Damage", "Damage was dealt", 1);
		this.flatDamage = 20;
		this.percentOfMaxHealthDamage = 0;
		this.percentOfMissingHealthDamage = 0;
		this.percentOfCurrentHealthDamage = 0;
	}

	@Override
	public void applyEffect(Character character) {
		SecondaryStats stats = character.getSecondaryStats();
		// The *-1 makes the function subtract the given hp instead of adding it.
		stats.addHp((int) this.flatDamage * -1);
		stats.addHp((int) (this.percentOfMaxHealthDamage /100 * stats.getMaxHP() * -1));
		stats.addHp((int) (this.percentOfMissingHealthDamage /100 * (stats.getMaxHP() - stats.getHp()) * -1));
		stats.addHp((int) (this.percentOfCurrentHealthDamage /100 * stats.getHp() * -1));


	}

	@Override
	public void applyEffect(Square square) {
		square.setEffect(new DamageEffect(getName(), getDescription(), getDuration(), this.flatDamage,
				this.percentOfMaxHealthDamage, this.percentOfMissingHealthDamage, this.percentOfCurrentHealthDamage));
	}

	@Override
	public void applyEffect(Equipment equipment) {}
}
