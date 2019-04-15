package model.effects;

import constants.ModelProperties;
import model.dungeon.Square;
import model.other.Character;

import static constants.EffectProperties.DAMAGE_FACTOR_FOR_POISON;


/**
 * An Effect-Class, which will give a Character an Poison effect, damaging it every turn.
 *
 * Is not visible outside of the effect-Package and can only be created by the EffectFactory.
 *
 * @author Hagen
 */
class PoisonEffect extends Effect {


    private int counter;

    protected PoisonEffect(String name, String description) {
        super(name, description, ModelProperties.NUMBER_TO_MAKE_EFFECT_LAST_INFINITLY);
        this.counter = 1;
    }

    protected PoisonEffect(String name, String description, boolean isRelevant) {
        super(name, description, ModelProperties.NUMBER_TO_MAKE_EFFECT_LAST_INFINITLY, isRelevant);
        this.counter = 1;
    }

    @Override
    public void applyEffect(Character cha) {
        cha.getSecondaryStats().setHp(Math.round(cha.getSecondaryStats().getMax_Hp() - (cha.getSecondaryStats().getMax_Hp() * DAMAGE_FACTOR_FOR_POISON* counter)));
        setDuration(getDuration() -1); // -1 because every use decreases the duration by.
        checkDurationAndRelevanze();
    }

    @Override
    public void applyEffect(Square square) {
        //It has no effect on Squares.
    }
}
