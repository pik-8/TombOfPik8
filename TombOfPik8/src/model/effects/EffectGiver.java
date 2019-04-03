package model.effects;

import model.dungeon.Square;
import model.other.Character;


/**
 * Intersection to give Effect-Objects, so that the Effect-Class does not have to do that.
 *
 * @author Hagen
 */
public class EffectGiver{

    private EffectGiver () {}

    public static Effect getEffect (Condition condition) {
        switch (condition) {
            case POISON:
                return new Effect("Poison", "Its poison", 4) {
                    @Override
                    public void applyEffect(Character cha) {
                        //TODO implement an effect.
                        System.out.println("POISON!!!11!!");
                    }

                    @Override
                    public void applyEffect (Square square){

                    }
                };

            default:
                return new Effect("Sleep", "Its sleep", 4) {
                    @Override
                    public void applyEffect(Character cha) {
                        //TODO implement an effect.
                        System.out.println("Oyasuminasai");
                    }

                    @Override
                    public void applyEffect (Square square){

                    }
                };
        }
    }
}
