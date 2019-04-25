package control;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.other.SecondaryStats;

public class SecondaryStatsTemplateGenerator {

	private static String templateName = "testStats";
	
	private static int hp = 0;
	private static int action = 0;
	
	private static int max_Hp = 0;
	private static int maxAction = 0;
	private static int attack = 50;
	private static int magicAttack = 2;
	private static int defence = 0;
	private static int magicDefence = 0;
	private static int speed = 5;
	private static float attackResistance = 0;
	private static int luck = 1337;

	private static int load = 0;
	private static int maxEquipmentLoad = 0;

	private static int stamina = 0;
	private static int attackSlots = 0;
	
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String jsonString = gson.toJson(generate());
		try {
			FileWriter fr = new FileWriter(templateName + ".pik");
			fr.write(jsonString);
			fr.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static SecondaryStats generate() {
		SecondaryStats stats = new SecondaryStats(hp, action, max_Hp,
				maxAction, attack, magicAttack, defence, magicDefence,
				speed, attackResistance, luck, load, maxEquipmentLoad,
				stamina, attackSlots);
		return stats;
	}
}
