package model.dungeon;

import model.effects.*;

public enum TerrainObject {

    TREE(10, EffectFactory.getEffect(Condition.POISON)),
    BOULDER (20, EffectFactory.getEffect(Condition.NONE)),
    BEDROCK (1000, EffectFactory.getEffect(Condition.NONE));

    private final int effort;
    private final Effect effect;

    TerrainObject (int effort, Effect effect) {
        this.effort = effort;
        this.effect = effect;
    }

    public int getEffort () {
        return this.effort;
    }

    public Effect getEffect () {
        return this.effect;
    }
}
