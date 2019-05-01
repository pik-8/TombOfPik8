package constants;

public interface FileConstants {
	public static final String RESOURCE_PATH = "resources";
	public static final String TEMPLATE_PATH = RESOURCE_PATH + "/templates";
		
	public static final String WEAPON_TEMPLATE_PATH = TEMPLATE_PATH + "/weapons";
	
	public static final String WEAPON_COMMON_TEMPLATES = WEAPON_TEMPLATE_PATH + "/CommonWeapons.pik";
	public static final String WEAPON_RARE_TEMPLATES = WEAPON_TEMPLATE_PATH + "/RareWeapons.pik";
	public static final String WEAPON_EPIC_TEMPLATES = WEAPON_TEMPLATE_PATH + "/EpicWeapons.pik";
	public static final String WEAPON_LEGENDARY_TEMPLATES = WEAPON_TEMPLATE_PATH + "/LegendaryWeapons.pik";
	
	public static final String ARMOR_TEMPLATE_PATH = TEMPLATE_PATH + "/armor";
	
	public static final String ARMOR_COMMON_TEMPLATES = ARMOR_TEMPLATE_PATH + "/CommonArmor.pik";
	public static final String ARMOR_RARE_TEMPLATES = ARMOR_TEMPLATE_PATH + "/RareArmor.pik";
	public static final String ARMOR_EPIC_TEMPLATES = ARMOR_TEMPLATE_PATH + "/EpicArmor.pik";
	public static final String ARMOR_LEGENDARY_TEMPLATES = ARMOR_TEMPLATE_PATH + "/LegendaryArmor.pik";
	
	
	public static final String TRINKET_TEMPLATE_PATH = TEMPLATE_PATH + "/trinkets";
	
	public static final String TRINKET_COMMON_TEMPLATES = TRINKET_TEMPLATE_PATH + "/CommonTrinkets.pik";
	public static final String TRINKET_RARE_TEMPLATES = TRINKET_TEMPLATE_PATH + "/RareTrinkets.pik";
	public static final String TRINKET_EPIC_TEMPLATES = TRINKET_TEMPLATE_PATH + "/EpicTrinkets.pik";
	public static final String TRINKET_LEGENDARY_TEMPLATES = TRINKET_TEMPLATE_PATH + "/LegendaryTrinkets.pik";

	public static final String ATTACK_TEMPLATE_PATH = TEMPLATE_PATH + "/attacks";
	public static final String SKILL_TEMPLATE_PATH = TEMPLATE_PATH + "/skills";
	public static final String MOB_TEMPLATE_PATH = TEMPLATE_PATH + "/enemies";
	public static final String DUNGEON_TEMPLATE_PATH = TEMPLATE_PATH + "/dungeons";

	public static final String PATH_TO_SAVING = RESOURCE_PATH + "/savings";
	
	public static final String PATH_TO_SAVE_STATES = PATH_TO_SAVING + "/saveStates";
	public static final String PATH_TO_SAVING_OPTION = PATH_TO_SAVING + "/Option.pik";
}
