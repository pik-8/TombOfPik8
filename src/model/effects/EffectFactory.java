package model.effects;


/**
 * Intersection to give Effect-Objects, so that the Effect-Class does not have to do that.
 *
 * @author Hagen
 */
public class EffectFactory{

    private EffectFactory () {}

    public static Effect getEffect (Condition condition) {
        switch (condition) {
            default:
                return null;
        }
    }
}
