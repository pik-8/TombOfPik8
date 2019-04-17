package model.effects;

import model.dungeon.Square;
import model.other.Character;

import static constants.EffectProperties.DURATION_GREAT_WALL;
import static constants.EffectProperties.EFFORT_TO_PASS_GREAT_WALL;

public class GreatWallEffect extends Effect {

    public GreatWallEffect(String name, String description) {
        super(name, description, DURATION_GREAT_WALL);
    }

    public GreatWallEffect(String name, String description, boolean isRelevant) {
        super(name, description, DURATION_GREAT_WALL, isRelevant);
    }


    @Override
    public void applyEffect(Character cha) {

    }

    @Override
    public void applyEffect(Square square) {
        if (this.getDuration() == DURATION_GREAT_WALL) {
            square.getTerrain().setEffortToPass(EFFORT_TO_PASS_GREAT_WALL);
        }
        setDuration(getDuration() -1); // -1 because every use decreases the duration by.
        checkDurationAndRelevanze();
    }
}
