package model.effects;

import model.dungeon.Square;
import model.other.Character;

public enum Condition {
    POISON, SLEEP;

    private Effect effect;

    public Effect getEffect () {
        switch (this.name()) {
            case "POISON":
                this.effect = new Effect("Poison", "Its poison", 4) {
                    @Override
                    public void applyEffect(Character cha) {
                        //TODO implement an effect.
                        System.out.println("POISON!!!11!!");
                    }

                    @Override
                    public void applyEffect (Square square){

                    }
                };
                break;
            case "SLEEP":
                this.effect = new Effect("Sleep", "You are sleeping", 4) {
                    @Override
                    public void applyEffect(Character cha) {
                        //TODO implement an effect.
                    }

                    @Override
                    public void applyEffect (Square square){

                    }
                };
                break;

        }
        return this.effect;
    }
}
