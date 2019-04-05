package model.effects;

import model.dungeon.Square;
import model.other.Character;

class PoisonEffect extends Effect{

    private int counter;
    private final float DAMAGE_FACTOR = 1/16;

    protected PoisonEffect(String name, String description, int duration) {
        super(name, description, duration);
        this.counter = 1;
    }

    protected PoisonEffect(String name, String description, int duration, boolean isRelevant) {
        super(name, description, duration, isRelevant);
        this.counter = 1;
    }

    @Override
    public void applyEffect(Character cha) {
        cha.getSecondaryStats().setHp(Math.round(cha.getSecondaryStats().getMax_Hp() - (cha.getSecondaryStats().getMax_Hp() * DAMAGE_FACTOR * counter)));
    }

    @Override
    public void applyEffect(Square square) {
        //It has no effect on Squares.
    }
}
