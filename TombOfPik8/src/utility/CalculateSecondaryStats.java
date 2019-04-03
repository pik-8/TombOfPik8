package utility;

import model.other.Hero;
import static constants.PropertiesStats.*;

/**
 * Utilitiy class, may die
 */
public class CalculateSecondaryStats {


    private CalculateSecondaryStats () {}


    public static int maxHealthByLevel(Hero hero)
    {
        int deltaLevel = 0;
        int i = 0;
        if (!hero.getPrimeStats().isSpecialist())
        {
            if (hero.getPrimeStats().getHealthLevel() <= SOFTCAP_FOR_HP_NOT_SPEZIALISED_1)
            {
                deltaLevel = hero.getPrimeStats().getHealthLevel();
            }
            else if (hero.getPrimeStats().getHealthLevel() <= SOFTCAP_FOR_HP_NOT_SPEZIALISED_2)
            {
                deltaLevel = hero.getPrimeStats().getHealthLevel() - SOFTCAP_FOR_HP_NOT_SPEZIALISED_1;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getHealthLevel() - SOFTCAP_FOR_HP_NOT_SPEZIALISED_2;
                i = 2;
            }

            int value = (deltaLevel * HP_SCALES_NOT_SPEZIALISED[i]) + HP_BASESTATS_NOT_SPEZIALISED[i];
            return value;
        }
        else
        {
            if (hero.getPrimeStats().getHealthLevel() <= SOFTCAP_FOR_HP_SPEZIALISED_1)
            {
                deltaLevel = hero.getPrimeStats().getHealthLevel();
            }
            else if (hero.getPrimeStats().getHealthLevel() <= SOFTCAP_FOR_HP_SPEZIALISED_2)
            {
                deltaLevel = hero.getPrimeStats().getHealthLevel() - SOFTCAP_FOR_HP_SPEZIALISED_1;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getHealthLevel() - SOFTCAP_FOR_HP_SPEZIALISED_2;
                i = 2;
            }
            int value = (deltaLevel * HP_SCALES_SPEZIALISED[i]) + HP_BASESTATS_SPEZIALISED[i];
            return value;
        }
    }


    public static int maxActionByLevel(Hero hero)
    {
        int maxActionByLevel;
        if (hero.getPrimeStats().isSpecialist())
        {
            if (hero.getPrimeStats().getStaminaLevel() <= SOFTCAP_FOR_HP_SPEZIALISED_1)
            {
                maxActionByLevel = (hero.getPrimeStats().getStaminaLevel() * MAX_ACTION_SCALE_1_SPEZIALISED) + MAX_ACTION_STARTVALUE_SPEZIALISED;
            }
            else if (hero.getPrimeStats().getStaminaLevel() <= MAX_ACTION_SOFTCAP_SPEZIALISED_2)
            {
                maxActionByLevel = ((hero.getPrimeStats().getStaminaLevel() - MAX_ACTION_SOFTCAP_SPEZIALISED_1) * MAX_ACTION_SCALE_2_SPEZIALISED) + MAX_ACTION_MAX_VALUE_AFTER_SOFTCAP_1_SPEZIALISED;
            }
            else
            {
                maxActionByLevel = ((hero.getPrimeStats().getStaminaLevel() - MAX_ACTION_SOFTCAP_SPEZIALISED_2) * MAX_ACTION_SCALE_3_SPEZIALISED) + MAX_ACTION_MAX_VALUE_AFTER_SOFTCAP_2_SPEZIALISED;
            }
        }
        else
        {
            if (hero.getPrimeStats().getStaminaLevel() <= MAX_ACTION_SOFTCAP_NOT_SPEZIALISED_1)
            {
                maxActionByLevel = (hero.getPrimeStats().getStaminaLevel() * MAX_ACTION_SCALE_1_NOT_SPEZIALISED) + MAX_ACTION_STARTVALUE_NOT_SPEZIALISED;
            }
            else if (hero.getPrimeStats().getStaminaLevel() <= MAX_ACTION_SOFTCAP_NOT_SPEZIALISED_2)
            {
                maxActionByLevel = ((hero.getPrimeStats().getStaminaLevel() - MAX_ACTION_SOFTCAP_NOT_SPEZIALISED_1) * MAX_ACTION_2_NOT_SPEZIALISED) + MAX_ACTION_MAX_VALUE_AFTER_SOFTCAP_1_NOT_SPEZIALISED;
            }
            else
            {
                maxActionByLevel = ((hero.getPrimeStats().getStaminaLevel() - MAX_ACTION_SOFTCAP_NOT_SPEZIALISED_2) * MAX_ACTION_SCALE_3_NOT_SPEZIALISED) + MAX_ACTION_MAX_VALUE_AFTER_SOFTCAP_2_NOT_SPEZIALISED;
            }
        }
        return maxActionByLevel;

    }


    public static int maxAttackResistanceByLevel(Hero hero)
    {
        int deltaLevel = 0;
        int i = 0;
        int deltaLevel2 = 0;
        int j = 0;
        if (!hero.getPrimeStats().isSpecialist())
        {
            if (hero.getPrimeStats().getToughnessLevel() <= ATTACK_RESISTANCE_SOFTCAP_NOT_SPEZIALISED_1_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel();
            }
            else if (hero.getPrimeStats().getToughnessLevel() <= ATTACK_RESISTANCE_SOFTCAP_NOT_SPEZIALISED_2_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - ATTACK_RESISTANCE_SOFTCAP_NOT_SPEZIALISED_1_FOR_TOUGHNESS;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - ATTACK_RESISTANCE_SOFTCAP_NOT_SPEZIALISED_2_FOR_TOUGHNESS;
                i = 2;
            }
            if (hero.getPrimeStats().getStrengthLevel() <= ATTACK_RESISTANCE_SOFTCAP_NOT_SPEZIALISED_1_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel();
            }
            else if (hero.getPrimeStats().getStrengthLevel() <= ATTACK_RESISTANCE_SOFTCAP_NOT_SPEZIALISED_2_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - ATTACK_RESISTANCE_SOFTCAP_NOT_SPEZIALISED_1_FOR_STRENGTH;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - ATTACK_RESISTANCE_SOFTCAP_NOT_SPEZIALISED_2_FOR_STRENGTH;
                j = 2;
            }
            int value = Math.round((deltaLevel * STM_RESIS_SCALES_NOT_SPEZIALISED_FORTOUGHNESS[i]) + STM_RESIS_BASESTATS_NOT_SPEZIALISED_FORTOUGHNESS[i] + (deltaLevel2 * STM_RESIS_SCALES_NOT_SPEZIALISED_FOR_STREMGTH[j] + STM_RESIS_BASES_NOT_SPEZIALISED_FOR_STREMGTH[j]));
            return value;
        }
        else
        {
            if (hero.getPrimeStats().getToughnessLevel() <= ATTACK_RESISTANCE_SOFTCAP_SPEZIALISED_1_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel();
            }
            else if (hero.getPrimeStats().getToughnessLevel() <= ATTACK_RESISTANCE_SOFTCAP_SPEZIALISED_2_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - ATTACK_RESISTANCE_SOFTCAP_SPEZIALISED_1_FOR_TOUGHNESS;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - ATTACK_RESISTANCE_SOFTCAP_SPEZIALISED_2_FOR_TOUGHNESS;
                i = 2;
            }
            if (hero.getPrimeStats().getStrengthLevel() <= ATTACK_RESISTANCE_SOFTCAP_SPEZIALISED_1_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel();
            }
            else if (hero.getPrimeStats().getStrengthLevel() <= ATTACK_RESISTANCE_SOFTCAP_SPEZIALISED_2_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - ATTACK_RESISTANCE_SOFTCAP_SPEZIALISED_1_FOR_STRENGTH;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - ATTACK_RESISTANCE_SOFTCAP_SPEZIALISED_2_FOR_STRENGTH;
                j = 2;
            }
            int value = Math.round((deltaLevel * STM_RESIS_SCALES_SPEZIALISED_FORTOUGHNESS[i]) + STM_RESIS_BASESTATS_SPEZIALISED_FORTOUGHNESS[i] + (deltaLevel2 * STM_RESIS_SCALES_SPEZIALISED_FOR_STREMGTH[j] + STM_RESIS_BASES_SPEZIALISED_FOR_STREMGTH[j]));
            return value;
        }
    }


    public static int maxEquipmentLoadByLevel(Hero hero)
    {
        int deltaLevel = 0;
        int i = 0;
        int j = 0;
        int deltaLevel2;
        if (!hero.getPrimeStats().isSpecialist())
        {
            if (hero.getPrimeStats().getToughnessLevel() <= MAX_LOAD__SOFTCAP_NOT_SPEZIALISED_1_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel();
            }
            else if (hero.getPrimeStats().getToughnessLevel() <= MAX_LOAD__SOFTCAP_NOT_SPEZIALISED_2_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - MAX_LOAD__SOFTCAP_NOT_SPEZIALISED_1_FOR_TOUGHNESS;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - MAX_LOAD__SOFTCAP_NOT_SPEZIALISED_2_FOR_TOUGHNESS;
                i = 2;
            }
            if (hero.getPrimeStats().getStrengthLevel() <= MAX_LOAD_SOFTCAP_NOT_SPEZIALISED_1_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel();
            }
            else if (hero.getPrimeStats().getStrengthLevel() <= MAX_LOAD_SOFTCAP_NOT_SPEZIALISED_2_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - MAX_LOAD_SOFTCAP_NOT_SPEZIALISED_1_FOR_STRENGTH;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - MAX_LOAD_SOFTCAP_NOT_SPEZIALISED_2_FOR_STRENGTH;
                j = 2;
            }

            int value = Math.round((deltaLevel * MAX_LOAD__SCALES_NOT_SPEZIALISED_FORTOUGHNESS[i]) + MAX_LOAD__BASESTATS_NOT_SPEZIALISED_FORTOUGHNESS[i] + (deltaLevel2 * MAX_LOAD_SCALES_NOT_SPEZIALISED_FOR_STREMGTH[j]) + MAX_LOAD_BASES_NOT_SPEZIALISED_FOR_STREMGTH[j]);
            return value;
        }
        else
        {
            if (hero.getPrimeStats().getToughnessLevel() <= MAX_LOAD_SOFTCAP_SPEZIALISED_1_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel();
            }
            else if (hero.getPrimeStats().getToughnessLevel() <= MAX_LOAD_SOFTCAP_SPEZIALISED_2_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - MAX_LOAD_SOFTCAP_SPEZIALISED_1_FOR_TOUGHNESS;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - MAX_LOAD_SOFTCAP_SPEZIALISED_2_FOR_TOUGHNESS;
                i = 2;
            }
            if (hero.getPrimeStats().getStrengthLevel() <= MAX_LOAD_SOFTCAP_SPEZIALISED_1_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel();
            }
            else if (hero.getPrimeStats().getStrengthLevel() <= MAX_LOAD_SOFTCAP_SPEZIALISED_2_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - MAX_LOAD_SOFTCAP_SPEZIALISED_1_FOR_STRENGTH;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - MAX_LOAD_SOFTCAP_SPEZIALISED_2_FOR_STRENGTH;
                j = 2;
            }

            int value = Math.round((deltaLevel * MAX_LOAD_SCALES_SPEZIALISED_FORTOUGHNESS[i]) + MAX_LOAD_BASESTATS_SPEZIALISED_FORTOUGHNESS[i] + (deltaLevel2 * MAX_LOAD_SCALES_SPEZIALISED_FOR_STREMGTH[j]) + MAX_LOAD_BASES_SPEZIALISED_FOR_STREMGTH[j]);
            return value;
        }
    }


    public static int maxAttackByLevel(Hero hero)
    {
        int deltaLevel2 = 0;
        int j = 0;
        int deltaLevel = 0;
        int i = 0;
        if (!hero.getPrimeStats().isSpecialist())
        {
            if (hero.getPrimeStats().getStrengthLevel() <= ATTACK_SOFTCAP_NOT_SPEZIALISED_1_FOR_STRENGHT)
            {
                deltaLevel = hero.getPrimeStats().getStrengthLevel();
            }
            else if (hero.getPrimeStats().getHealthLevel() <= ATTACK_SOFTCAP_NOT_SPEZIALISED_2_FOR_STRENGHT)
            {
                deltaLevel = hero.getPrimeStats().getStrengthLevel() - ATTACK_SOFTCAP_NOT_SPEZIALISED_1_FOR_STRENGHT;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getStrengthLevel() - ATTACK_SOFTCAP_NOT_SPEZIALISED_2_FOR_STRENGHT;
                i = 2;
            }
            if (hero.getPrimeStats().getSpeedLevel() <= ATTACK_SOFTCAP_NOT_SPEZIALISED_1_FOR_SPEED)
            {
                deltaLevel2 = hero.getPrimeStats().getSpeedLevel();
            }
            else if (hero.getPrimeStats().getSpeedLevel() <= ATTACK_SOFTCAP_NOT_SPEZIALISED_2_FOR_SPEED)
            {
                deltaLevel2 = hero.getPrimeStats().getSpeedLevel() - ATTACK_SOFTCAP_NOT_SPEZIALISED_1_FOR_SPEED;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getSpeedLevel() - ATTACK_SOFTCAP_NOT_SPEZIALISED_2_FOR_SPEED;
                j = 2;
            }
            int value = Math.round((deltaLevel * ATTACK_SCALES_NOT_SPEZIALISED_FOR_STRENGHT[i]) + ATTACK_BASESTATS_NOT_SPEZIALISED_FOR_STRENGHT[i] + (deltaLevel2 * ATTACK_SCALES_NOT_SPEZIALISED_FOR_SPEED[j] + ATTACK_BASES_NOT_SPEZIALISED_FOR_SPEED[j]));
            return value;
        }
        else
        {
            if (hero.getPrimeStats().getStrengthLevel() <= ATTACK_SOFTCAP_SPEZIALISED_1_FOR_STRENGHT)
            {
                deltaLevel = hero.getPrimeStats().getStrengthLevel();
            }
            else if (hero.getPrimeStats().getStrengthLevel() <= ATTACK_SOFTCAP_SPEZIALISED_2_FOR_STRENGHT)
            {
                deltaLevel = hero.getPrimeStats().getStrengthLevel() - ATTACK_SOFTCAP_SPEZIALISED_1_FOR_STRENGHT;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getStrengthLevel() - ATTACK_SOFTCAP_SPEZIALISED_2_FOR_STRENGHT;
                i = 2;
            }
            if (hero.getPrimeStats().getSpeedLevel() <= ATTACK_SOFTCAP_SPEZIALISED_1_FOR_SPEED)
            {
                deltaLevel2 = hero.getPrimeStats().getSpeedLevel();
            }
            else if (hero.getPrimeStats().getSpeedLevel() <= ATTACK_SOFTCAP_SPEZIALISED_2_FOR_SPEED)
            {
                deltaLevel2 = hero.getPrimeStats().getSpeedLevel() - ATTACK_SOFTCAP_SPEZIALISED_1_FOR_SPEED;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getSpeedLevel() - ATTACK_SOFTCAP_SPEZIALISED_2_FOR_SPEED;
                j = 2;
            }
            int value = Math.round((deltaLevel * ATTACK_SCALES_SPEZIALISED_FOR_STRENGHT[i]) + ATTACK_BASESTATS_SPEZIALISED_FOR_STRENGHT[i] + (deltaLevel2 + ATTACK_SCALES_SPEZIALISED_FOR_SPEED[j]) + ATTACK_BASES_SPEZIALISED_FOR_SPEED[j]);
            return value;
        }
    }


    public static int maxMagicAttackByLevel(Hero hero)
    {
        int deltaLevel2 = 0;
        int j = 0;
        int deltaLevel = 0;
        int i = 0;
        if (!hero.getPrimeStats().isSpecialist())
        {
            if (hero.getPrimeStats().getMagicLevel() <= MAGIC_ATTACK_SOFTCAP_NOT_SPEZIALISED_1_FOR_MAGIC)
            {
                deltaLevel = hero.getPrimeStats().getMagicLevel();
            }
            else if (hero.getPrimeStats().getMagicLevel() <= MAGIC_ATTACK_SOFTCAP_NOT_SPEZIALISED_2_FOR_MAGIC)
            {
                deltaLevel = hero.getPrimeStats().getMagicLevel() - MAGIC_ATTACK_SOFTCAP_NOT_SPEZIALISED_1_FOR_MAGIC;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getMagicLevel() - MAGIC_ATTACK_SOFTCAP_NOT_SPEZIALISED_2_FOR_MAGIC;
                i = 2;
            }
            if (hero.getPrimeStats().getIntelligenceLevel() <= MAGIC_ATTACK_SOFTCAP_NOT_SPEZIALISED_1_FOR_INTELLIGENCE)
            {
                deltaLevel2 = hero.getPrimeStats().getIntelligenceLevel();
            }
            else if (hero.getPrimeStats().getIntelligenceLevel() <= MAGIC_ATTACK_SOFTCAP_NOT_SPEZIALISED_2_FOR_INTELLIGENCE)
            {
                deltaLevel2 = hero.getPrimeStats().getIntelligenceLevel() - MAGIC_ATTACK_SOFTCAP_NOT_SPEZIALISED_1_FOR_INTELLIGENCE;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getIntelligenceLevel() - MAGIC_ATTACK_SOFTCAP_NOT_SPEZIALISED_2_FOR_INTELLIGENCE;
                j = 2;
            }
            int value = Math.round((deltaLevel * MAGIC_ATTACK_SCALES_NOT_SPEZIALISED_FOR_MAGIC[i]) + MAGIC_ATTACK_BASES_NOT_SPEZIALISED_FOR_MAGIC[i] + (deltaLevel2 * MAGIC_ATTACK_SCALES_NOT_SPEZIALISED_FOR_INTELLIGENCE[j] + MAGIC_ATTACK_BASES_NOT_SPEZIALISED_FOR_INTELLIGENCE[j]));
            return value;
        }
        else
        {
            if (hero.getPrimeStats().getMagicLevel() <= MAGIC_ATTACK_SOFTCAP_SPEZIALISED_1_FOR_MAGIC)
            {
                deltaLevel = hero.getPrimeStats().getMagicLevel();
            }
            else if (hero.getPrimeStats().getMagicLevel() <= MAGIC_ATTACK_SOFTCAP_SPEZIALISED_2_FOR_MAGIC)
            {
                deltaLevel = hero.getPrimeStats().getMagicLevel() - MAGIC_ATTACK_SOFTCAP_SPEZIALISED_1_FOR_MAGIC;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getMagicLevel() - MAGIC_ATTACK_SOFTCAP_SPEZIALISED_2_FOR_MAGIC;
                i = 2;
            }
            if (hero.getPrimeStats().getIntelligenceLevel() <= MAGIC_ATTACK_SOFTCAP_SPEZIALISED_1_FOR_INTELLIGENCE)
            {
                deltaLevel2 = hero.getPrimeStats().getIntelligenceLevel();
            }
            else if (hero.getPrimeStats().getIntelligenceLevel() <= MAGIC_ATTACK_SOFTCAP_SPEZIALISED_2_FOR_INTELLIGENCE)
            {
                deltaLevel2 = hero.getPrimeStats().getIntelligenceLevel() - MAGIC_ATTACK_SOFTCAP_SPEZIALISED_1_FOR_INTELLIGENCE;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getIntelligenceLevel() - MAGIC_ATTACK_SOFTCAP_SPEZIALISED_2_FOR_INTELLIGENCE;
                j = 2;
            }
            int value = Math.round((deltaLevel * MAGIC_ATTACK_SCALES_SPEZIALISED_FOR_MAGIC[i]) + MAGIC_ATTACK_BASES_SPEZIALISED_FOR_MAGIC[i] + (deltaLevel2 + MAGIC_ATTACK_SCALES_SPEZIALISED_FOR_INTELLIGENCE[j]) + MAGIC_ATTACK_BASES_SPEZIALISED_FOR_MAGIC[j]);
            return value;
        }
    }


    public static int maxDefenceByLevel(Hero hero)
    {
        int deltaLevel2 = 0;
        int j = 0;
        int deltaLevel = 0;
        int i = 0;
        if (!hero.getPrimeStats().isSpecialist())
        {
            if (hero.getPrimeStats().getToughnessLevel() <= DEFENCE_SOFTCAP_NOT_SPEZIALISED_1_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel();
            }
            else if (hero.getPrimeStats().getToughnessLevel() <= DEFENCE_SOFTCAP_NOT_SPEZIALISED_2_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - DEFENCE_SOFTCAP_NOT_SPEZIALISED_1_FOR_TOUGHNESS;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - DEFENCE_SOFTCAP_NOT_SPEZIALISED_2_FOR_TOUGHNESS;
                i = 2;
            }
            if (hero.getPrimeStats().getStrengthLevel() <= DEFENCE_SOFTCAP_NOT_SPEZIALISED_1_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel();
            }
            else if (hero.getPrimeStats().getStrengthLevel() <= DEFENCE_SOFTCAP_NOT_SPEZIALISED_2_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - DEFENCE_SOFTCAP_NOT_SPEZIALISED_1_FOR_STRENGTH;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - DEFENCE_SOFTCAP_NOT_SPEZIALISED_2_FOR_STRENGTH;
                j = 2;
            }
            int value = Math.round((deltaLevel * DEFENCE_SCALES_NOT_SPEZIALISED_FOR_TOUGHNESS[i]) + DEFENCE_BASES_NOT_SPEZIALISED_FOR_TOUGHNESS[i] + (deltaLevel2 * DEFENCE_SCALES_NOT_SPEZIALISED_FOR_STRENGTH[j] + DEFENCE_BASES_NOT_SPEZIALISED_FOR_STRENGTH[j]));
            return value;
        }
        else
        {
            if (hero.getPrimeStats().getToughnessLevel() <= DEFENCE_SOFTCAP_SPEZIALISED_1_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel();
            }
            else if (hero.getPrimeStats().getToughnessLevel() <= DEFENCE_SOFTCAP_SPEZIALISED_2_FOR_TOUGHNESS)
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - DEFENCE_SOFTCAP_SPEZIALISED_1_FOR_TOUGHNESS;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getToughnessLevel() - DEFENCE_SOFTCAP_SPEZIALISED_2_FOR_TOUGHNESS;
                i = 2;
            }
            if (hero.getPrimeStats().getStrengthLevel() <= DEFENCE_SOFTCAP_SPEZIALISED_1_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel();
            }
            else if (hero.getPrimeStats().getStrengthLevel() <= DEFENCE_SOFTCAP_SPEZIALISED_2_FOR_STRENGTH)
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - DEFENCE_SOFTCAP_SPEZIALISED_1_FOR_STRENGTH;
                j = 1;
            }
            else
            {
                deltaLevel2 = hero.getPrimeStats().getStrengthLevel() - DEFENCE_SOFTCAP_SPEZIALISED_2_FOR_STRENGTH;
                j = 2;
            }
            int value = Math.round((deltaLevel * DEFENCE_SCALES_SPEZIALISED_FOR_TOUGHNESS[i]) + DEFENCE_BASES_SPEZIALISED_FOR_TOUGHNESS[i] + (deltaLevel2 * DEFENCE_SCALES_SPEZIALISED_FOR_STRENGTH[j] + DEFENCE_BASES_SPEZIALISED_FOR_STRENGTH[j]));
            return value;
        }
    }


    public static int maxMgDefByLevel(Hero hero)
    {
        return 100;// no scaling for this stat.
    }


    public static int attackSlotsByLevel(Hero hero)
    {
        int attackslots = START_ATTACK_SLOTS;
        if (hero.getPrimeStats().getIntelligenceLevel() >= MINIMUM_INTELLIGENCE_3)
        {
            attackslots += 3;
        }
        else if (hero.getPrimeStats().getIntelligenceLevel() >= MINIMUM_INTELLIGENCE_2)
        {
            attackslots += 2;
        }
        else if (hero.getPrimeStats().getIntelligenceLevel() >= MINIMUM_INTELLIGENCE_1)
        {
            attackslots += 1;
        }
        if (hero.getPrimeStats().getStrengthLevel() >= MINIMUM_STRENGTH_1)
        {
            attackslots += 1;
        }
        if (hero.getPrimeStats().getToughnessLevel() >= MINIMUM_TOUGHNESS_1)
        {
            attackslots += 1;
        }
        if (hero.getPrimeStats().getMagicLevel()>= MINIMUM_MAGIC_1)
        {
            attackslots += 1;
        }
        return attackslots;
    }


    public static int maxSpeedByLevel(Hero hero)
    {
        int deltaLevel = 0;
        int i = 0;
        if (!hero.getPrimeStats().isSpecialist())
        {
            if (hero.getPrimeStats().getSpeedLevel() <= SPEED_SOFTCAP_NOT_SPEZIALISED_1)
            {
                deltaLevel = hero.getPrimeStats().getSpeedLevel();
            }
            else if (hero.getPrimeStats().getSpeedLevel() <= SPEED_SOFTCAP_NOT_SPEZIALISED_2)
            {
                deltaLevel = hero.getPrimeStats().getSpeedLevel() - SPEED_SOFTCAP_NOT_SPEZIALISED_1;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getSpeedLevel() - SPEED_SOFTCAP_NOT_SPEZIALISED_2;
                i = 2;
            }

            int value = (deltaLevel * SPEED_SCALES_NOT_SPEZIALISED[i]) + SPEED_BASES_NOT_SPEZIALISED[i];
            return value;
        }
        else
        {
            if (hero.getPrimeStats().getSpeedLevel() <= SPEED_SOFTCAP_SPEZIALISED_1)
            {
                deltaLevel = hero.getPrimeStats().getSpeedLevel();
            }
            else if (hero.getPrimeStats().getSpeedLevel() <= SPEED_SOFTCAP_SPEZIALISED_2)
            {
                deltaLevel = hero.getPrimeStats().getSpeedLevel() - SPEED_SOFTCAP_SPEZIALISED_1;
                i = 1;
            }
            else
            {
                deltaLevel = hero.getPrimeStats().getSpeedLevel() - SPEED_SOFTCAP_SPEZIALISED_2;
                i = 2;
            }
            int value = (deltaLevel * SPEED_SCALES_SPEZIALISED[i]) + SPEED_BASES_SPEZIALISED[i];
            return value;
        }
    }


    public static int maxTravelableFieldsByLevel(Hero hero)
    {
        int fields = MINIMIN_TRAVELABEL_FIELDS;
        if (hero.getPrimeStats().getSpeedLevel() >= NEEDED_SPEED_TO_TRAVEL_4)
        {
            fields += 3;
        }
        else if (hero.getPrimeStats().getSpeedLevel() >= NEEDED_SPEED_TO_TRAVEL_3)
        {
            fields += 2;
        }
        else if (hero.getPrimeStats().getSpeedLevel() >= NEEDED_SPEED_TO_TRAVEL_2)
        {
            fields += 1;
        }
        return fields;
    }


    public static int maxLuckByLevel(Hero hero)
    {
        return hero.getPrimeStats().getLuckLevel();
    }
}
