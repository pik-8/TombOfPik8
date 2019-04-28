package tests;

import model.characters.Hero;
import model.characters.Inventory;
import model.characters.PrimeStats;
import model.characters.SecondaryStats;
import model.effects.Effect;
import model.effects.HealingEffect;
import model.fighting.Attack;
import model.fighting.AttackPattern;
import model.fighting.Skill;
import model.other.Statistics;


/**
 * A class that can give objects for test purposes.
 */
public class Getter {

    public static Hero getAHero () throws Exception {
        float[][] attackField = {{1,1},{0.1f, -1}};
        Effect[][] effectField = {{new HealingEffect()},{null},{new HealingEffect(), new HealingEffect()}};
        AttackPattern pattern = new AttackPattern(attackField, effectField);
        Attack attack = new Attack("Punchu", "aöhdewbfg", 1, 1, 1, 1, new HealingEffect(), pattern);
        Inventory inventory = new Inventory(3);
        Skill[] skills = {new Skill("Skiller", "a skill", 1, 1, 1, 1, null, pattern, true) {
            @Override
            public boolean checkIfReady() {
                return false;
            }
        }};
        SecondaryStats secStats = new SecondaryStats(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        PrimeStats primeStats = new PrimeStats(false, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        Statistics statistics = new Statistics();
        Attack[] attacks = {attack, attack};
        return new Hero("Naofumi", inventory, attacks, skills, secStats, 1, primeStats, statistics);
    }
}
