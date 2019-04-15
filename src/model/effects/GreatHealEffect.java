package model.effects;

import model.dungeon.Square;
import model.dungeon.Terrain;
import model.other.Character;

import static constants.EffectProperties.*;
import static constants.ModelProperties.NUMBER_TO_USE_EFFECT_ONCE;


/**
 * An Effect-Class, which will give a Character a lot HP and restores a Terrain completely.
 *
 * Is not visible outside of the effect-Package and can only be created by the EffectFactory.
 *
 * @author Hagen
 */
public class GreatHealEffect extends Effect {

    public GreatHealEffect(String name, String description) {
        super(name, description, NUMBER_TO_USE_EFFECT_ONCE);
    }

    public GreatHealEffect(String name, String description, boolean isRelevant) {
        super(name, description, NUMBER_TO_USE_EFFECT_ONCE, isRelevant);
    }

    @Override
    public void applyEffect(Character cha) {
        if ((cha.getSecondaryStats().getHp() + GREAT_HP_TO_HEAl) > cha.getSecondaryStats().getMax_Hp()) {
            cha.getSecondaryStats().setHp(cha.getSecondaryStats().getMax_Hp());
        } else {
            cha.getSecondaryStats().setHp(cha.getSecondaryStats().getHp() + GREAT_HP_TO_HEAl);
        }
        checkDurationAndRelevanze();
    }

    @Override
    public void applyEffect(Square square) {
        if (square.getTerrain().getEffortToPass() != Terrain.valueOf(square.getTerrain().name()).getEffortToPass()) {
            square.getTerrain().setEffortToPass(square.getTerrain().getEffortToPass());
        }
        checkDurationAndRelevanze();
    }
}
