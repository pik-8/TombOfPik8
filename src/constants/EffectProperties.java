package constants;

public interface EffectProperties {

    int CRUSH_EFFECT_PLUS_EFFORT = 2;
    int DURATION_FOR_PARALYSIS_EFFECT = 4;

    //Poison----------Poison----------Poison----------Poison----------Poison----------Poison----------Poison

    float DAMAGE_FACTOR_FOR_POISON = 1/16;

    //Paralysis-----------Paralysis-----------Paralysis-----------Paralysis-----------Paralysis-----------Paralysis

    float FACTOR_FOR_SPEED_REDUCTION = 1 / 2;

    //SmallHeal---------SmallHeal---------SmallHeal---------SmallHeal---------SmallHeal---------SmallHeal---------

    int SMALL_HP_TO_REGAIN = 50;
    int SMAll_HEALING_FOR_TERRAIN = 1;

    //IronSkin------------IronSkin------------IronSkin------------IronSkin------------IronSkin------------IronSkin

    int IRON_SIN_DURATION = 5;
    int SUMMAND_FOR_MG_DEF = 20;
    float FACTOR_FOR_DEF = 1.5f;

    //GreatHeal-----------GreatHeal-----------GreatHeal-----------GreatHeal-----------GreatHeal-----------GreatHeal

    int GREAT_HP_TO_HEAl = 300;

    //GreatWall----------GreatWall----------GreatWall----------GreatWall----------GreatWall----------GreatWall

    int DURATION_GREAT_WALL = 2;
    int EFFORT_TO_PASS_GREAT_WALL = 999999999;
}
