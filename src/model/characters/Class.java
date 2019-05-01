package model.characters;

import model.fighting.Attack;
import model.fighting.Skill;

public enum Class {
	WARRIOR,
	ARCHER,
	MAGE,
	ASSASSIN;
	
	PrimeStats baseStats;
	Attack[] possibleAttacks;
	Skill[] possibleSkills;
	
}
