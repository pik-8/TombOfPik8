package model.effects;

import model.dungeon.Square;
import model.other.Character;
import static constants.EffectProperties.*;


/**
 * An Effect-Class, which will give a Character an paralysing effect, slowing it down.
 *
 * Is not visible outside of the effect-Package and can only be created by the EffectFactory.
 *
 * @author Hagen
 */
public class ParalysisEffect extends Effect {


    public ParalysisEffect(String name, String description) {
        super(name, description, DURATION_FOR_PARALYSIS_EFFECT);
    }

    public ParalysisEffect(String name, String description, boolean isRelevant) {
        super(name, description, DURATION_FOR_PARALYSIS_EFFECT, isRelevant);
    }


    @Override
    public void applyEffect(Character cha) {
        cha.getSecondaryStats().setSpeed(Math.round(cha.getSecondaryStats().getSpeed() * FACTOR_FOR_SPEED_REDUCTION));
        setDuration(getDuration() -1); // -1 because every use decreases the duration by.
        checkDurationAndRelevanze();
    }

    @Override
    public void applyEffect(Square square) {

    }
}
