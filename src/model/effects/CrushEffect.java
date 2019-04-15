package model.effects;

import model.dungeon.Square;
import model.other.Character;
import constants.*;

public class CrushEffect extends Effect {


    CrushEffect(String name, String description) {
        super(name, description, ModelProperties.NUMBER_TO_MAKE_EFFECT_LAST_INFINITLY);
    }

    CrushEffect(String name, String description, boolean isRelevant) {
        super(name, description, ModelProperties.NUMBER_TO_MAKE_EFFECT_LAST_INFINITLY, isRelevant);
    }

    @Override
    public void applyEffect(Character cha) {

    }

    @Override
    public void applyEffect(Square square) {
        square.getTerrain().setEffortToPass(square.getTerrain().getEffortToPass() + EffectProperties.CRUSH_EFFECT_PLUS_EFFORT);
    }
}
