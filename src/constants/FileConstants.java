package constants;

public interface FileConstants {
	public static final String STANDARD_FILE_ENDING= ".pik";

	public static final String RESOURCE_PATH = "resources";
	public static final String TEMPLATE_PATH = RESOURCE_PATH + "/templates";

	public static final String OPTIONS_PATH = RESOURCE_PATH + "/options";
		
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
	
	public static final String CLASS_CUSTOMIZATION_PATH = RESOURCE_PATH + "/heroes";
	
	public static final String WARRIOR_PATH = CLASS_CUSTOMIZATION_PATH + "/Warrior";
	public static final String MAGE_PATH = CLASS_CUSTOMIZATION_PATH + "/Mage";
	public static final String ARCHER_PATH = CLASS_CUSTOMIZATION_PATH + "/Archer";
	public static final String ASSASSIN_PATH = CLASS_CUSTOMIZATION_PATH + "/Assassin";

	public static final String PATH_TO_SAVING = RESOURCE_PATH + "/savings";
	
	public static final String PATH_TO_SAVE_STATES = PATH_TO_SAVING + "/saveStates";
	public static final String PATH_TO_SAVING_OPTION = PATH_TO_SAVING + "/Options.pik";

	public static final String PATH_TO_DIFFICULTYS  = TEMPLATE_PATH + "/difficultys";
	public static final String PATH_TO_EASY_DIFFICULTY  = PATH_TO_DIFFICULTYS + "/EasyDifficulty.pik/";
	public static final String PATH_TO_MIDDLE_DIFFICULTY  = PATH_TO_DIFFICULTYS + "/MiddleDifficulty.pik/";
	public static final String PATH_TO_HIGH_DIFFICULTY  = PATH_TO_DIFFICULTYS + "/HardDifficulty.pik/";

	public static final String TEST_DUNGEON_PATH  = DUNGEON_TEMPLATE_PATH + "/TestDungeon.pik/";

	public static final String PATH_TO_CONFIGS = RESOURCE_PATH + "/configs";

	public static final String PATH_TO_GAME_CONFIG = PATH_TO_CONFIGS + "/Game.config";


	//Styles---------Styles---------Styles---------Styles---------Styles---------Styles---------Styles---------Styles

	public static final String PATH_TO_STYLE_SHEETS = "view/styleSheets";
	public static final String PATH_TO_OPTION_SCENE_DIFFICULTY_BUTTON_STYLE_SHEET = PATH_TO_STYLE_SHEETS +  "/OptionScene_GraphicButton.css";
	public static final String PATH_TO_OPTION_SCENE_GRAPHIC_BUTTON_STYLE_SHEET = PATH_TO_STYLE_SHEETS +  "/OptionScene_DifficultyButton.css";
	public static final String PATH_TO_OPTION_SCENE_SOUND_BUTTON_STYLE_SHEET = PATH_TO_STYLE_SHEETS +  "/OptionScene_SoundButton.css";

	public static final String PATH_TO_LOADING_SCENE_LABEL_STYLE_SHEET = PATH_TO_STYLE_SHEETS +  "/LoadingScene_Label.css";
	public static final String PATH_TO_SAVE_STATE_SELECTION_SCENE_NAME_LABEL_STYLE_SHEET = PATH_TO_STYLE_SHEETS +  "/SaveStateSelectionScene_NameLabel.css";
	public static final String PATH_TO_SAVE_STATE_SELECTION_SCENE_PLAY_TIME_LABEL_STYLE_SHEET = PATH_TO_STYLE_SHEETS +  "/SaveStateSelectionScene_PlayTimeLabel.css";


	public static final String PATH_TO_LANGUAGES = RESOURCE_PATH + "/languages";
	public static final String PATH_TO_GERMAN = PATH_TO_LANGUAGES + "/german";
	public static final String PATH_TO_LANGUAGE_SCENES = "/scenes";
	public static final String PATH_TO_OPTION_SCENES_CONFIG = PATH_TO_LANGUAGE_SCENES+ "/OptionScene.config";
	public static final String PATH_TO_LOADING_SCENES_CONFIG = PATH_TO_LANGUAGE_SCENES+ "/LoadingScene.config";


	public static final String STANDARD_LANGUAGE_PATH = PATH_TO_LANGUAGES + "/german";
}
