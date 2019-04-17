package model.effects;

import constants.EffectProperties;
import model.dungeon.Square;
import model.other.Character;

import static constants.EffectProperties.IRON_SIN_DURATION;


/**
 * An Effect-Class, which increases the defence of an Character.
 *
 * Is not visible outside of the effect-Package and can only be created by the EffectFactory.
 *
 * @author Hagen
 */
public class IronSkinEffect extends Effect {

    public IronSkinEffect(String name, String description) {
        super(name, description, IRON_SIN_DURATION);
    }

    public IronSkinEffect(String name, String description, boolean isRelevant) {
        super(name, description, IRON_SIN_DURATION, isRelevant);
    }


    @Override
    public void applyEffect(Character cha) {
        if (this.getDuration() == IRON_SIN_DURATION) {
            cha.getSecondaryStats().setDefence(Math.round(cha.getSecondaryStats().getDefence() * EffectProperties.FACTOR_FOR_DEF));
            cha.getSecondaryStats().setMagicDefence(cha.getSecondaryStats().getMagicDefence() + EffectProperties.SUMMAND_FOR_MG_DEF);
        }
        setDuration(getDuration() -1); // -1 because every use decreases the duration by.
        checkDurationAndRelevanze();
    }

    @Override
    public void applyEffect(Square square) {

    }
}
