package constants;

public interface ExceptionConstants {

    String ATTACK_PATTERN_TOO_MANY_NEGATIVE_NUMBERS = "The AttackPattern could not be instantiated, "
            + "because there are more than one negative numbers in the array.";
    String ATTACK_PATTERN_NO_NEGATIVE_NUMBER = "The AttackPattern could not be instantiated, "
            + "because there is no negative number indicating the position of the attacker.";
    String ATTACK_PATTERN_TO_MANY_NULL = "The AttackPattern could not be instantiated, "
            + "because there are to many null`s in the array.";
    String ATTACK_PATTERN_NO_NULL = "The AttackPattern could not be instantiated, "
            + "because there is no null indicating the attacker.";

    String ATTACK_DAMAGE_IS_NEGATIVE = "The Attack could not be instantiated, "
            + "because the damage is negative.";
    String ATTACK_MAGICAL_DAMAGE_IS_NEGATIVE = "The Attack could not be instantiated, "
            + "because the magicalDamage is negative.";
    String ATTACK_ACCURACY_IS_NEGATIVE = "The Attack could not be instantiated, "
            + "because the accuracy is negative.";
    String ATTACK_REQUIREDSLOTS_IS_NEGATIVE = "The Attack could not be instantiated, "
            + "because the requiredSlots is negative.";
}