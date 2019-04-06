package model.fighting;

public class SkillFactory {

    private SkillFactory () {}

    public static Skill getSkill (SkillList aSkill) {
        switch (aSkill) {
            case DIVINE_HEAL:
                ;
            default:
                return null;
        }
    }
}
