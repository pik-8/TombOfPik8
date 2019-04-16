package constants;

public interface ExceptionConstants {

    final String ATTACK_PATTERN_TOO_MANY_NEGATIVE_NUMBERS = "The AttackPattern could not be instantiated, "
            + "because there are more than one negative numbers in the array.";
    final String ATTACK_PATTERN_NO_NEGATIVE_NUMBER = "The AttackPattern could not be instantiated, "
            + "because there is no negative number indicating the position of the attacker.";
    final String ATTACK_PATTERN_TO_MANY_NULL = "The AttackPattern could not be instantiated, "
            + "because there are to many null`s in the array.";
    final String ATTACK_PATTERN_NO_NULL = "The AttackPattern could not be instantiated, "
            + "because there is no null indicating the attacker.";

    final String ATTACK_DAMAGE_IS_NEGATIVE = "The Attack could not be instantiated, "
            + "because the damage is negative.";
    final String ATTACK_MAGICAL_DAMAGE_IS_NEGATIVE = "The Attack could not be instantiated, "
            + "because the magicalDamage is negative.";
    final String ATTACK_ACCURACY_IS_NEGATIVE = "The Attack could not be instantiated, "
            + "because the accuracy is negative.";
    final String ATTACK_REQUIREDSLOTS_IS_NEGATIVE = "The Attack could not be instantiated, "
            + "because the requiredSlots is negative.";

    final String TOO_MANY_SKILLS = "The list containing the skills of an character is too long.";

    final String FIELD_FOR_TILE_IS_NO_SQUARE = "The length of each array inside the Square-Array is not the same length";
    final String FIELD_HAS_NOT_THE_RIGHT_SIZE = "The Square-Array has not a valid size.";

    final String EFFORT_IS_NEGATIVE = "The effort to pass a Terrain-Object may only be positive.";
    
    final String INVENTORY_IS_FULL = "The inventory is full, no more items can be added.";
    
    final String NEGATIVE_HEAL = "Cannot heal for a negative amount";
}
