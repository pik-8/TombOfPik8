package model.effects;


import constants.ModelProperties;
import model.dungeon.Square;
import model.dungeon.Terrain;
import model.other.Character;

import static constants.EffectProperties.*;

/**
 * An Effect-Class, which will give a Character a little HP and restores a bit a Terrain.
 *
 * Is not visible outside of the effect-Package and can only be created by the EffectFactory.
 *
 * @author Hagen
 */
public class SmallHealEffect extends Effect{



    public SmallHealEffect(String name, String description) {
        super(name, description, ModelProperties.NUMBER_TO_USE_EFFECT_ONCE);
    }

    public SmallHealEffect(String name, String description, boolean isRelevant) {
        super(name, description, ModelProperties.NUMBER_TO_USE_EFFECT_ONCE, isRelevant);
    }


    @Override
    public void applyEffect(Character cha) {
        if ((cha.getSecondaryStats().getHp() + SMALL_HP_TO_REGAIN) > cha.getSecondaryStats().getMax_Hp()) {
            cha.getSecondaryStats().setHp(cha.getSecondaryStats().getMax_Hp());
        } else {
            cha.getSecondaryStats().setHp(cha.getSecondaryStats().getHp() + SMALL_HP_TO_REGAIN);
        }
        checkDurationAndRelevanze();
    }

    @Override
    public void applyEffect(Square square) {
        if (square.getTerrain().getEffortToPass() > Terrain.valueOf(square.getTerrain().name()).getEffortToPass()) {
            square.getTerrain().setEffortToPass(square.getTerrain().getEffortToPass() - SMAll_HEALING_FOR_TERRAIN);
        }
        checkDurationAndRelevanze();
    }
}
