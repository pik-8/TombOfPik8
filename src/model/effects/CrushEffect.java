package model.effects;

import model.dungeon.Square;
import model.other.Character;

public class CrushEffect extends Effect{


    CrushEffect(String name, String description, int duration) {
        super(name, description, duration);
    }

    CrushEffect(String name, String description, int duration, boolean isRelevant) {
        super(name, description, duration, isRelevant);
    }

    @Override
    public void applyEffect(Character cha) {

    }

    @Override
    public void applyEffect(Square square) {
        //TODO
    }
}
