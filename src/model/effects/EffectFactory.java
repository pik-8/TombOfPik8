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
            case POISON:
            	return new PoisonEffect("", "");

            case NONE:
                return new CrushEffect("", "", false);

            case CRUSHING:
                return new CrushEffect("", "");

            case PARALYSIS:
                return new ParalysisEffect("", "");

            case SMALL_HEAL:
                return new SmallHealEffect("", "");

            case GREAT_HEAL:
                return new GreatHealEffect("", "");

            case IRON_SKIN:
                return new IronSkinEffect("", "");

            case GREAT_WALL:
                return new GreatWallEffect("","");
            default:
                return new CrushEffect("", "", false);
        }
    }
}
