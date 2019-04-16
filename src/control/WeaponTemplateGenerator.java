package control;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.effects.Effect;
import model.items.Weapon;
import model.json.AdapterFactories;
import model.other.SecondaryStats;

public class WeaponTemplateGenerator {

	private static String templateName = "myFirstWeapon";
	
	private static String name = "";
	private static String description = "lolNice";
	
	private static Effect effect = EffectTemplateGenerator.generate();
	private static SecondaryStats stats = SecondaryStatsTemplateGenerator.generate();
	
	public static void main(String[] args) {
		
		GsonBuilder builder = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		String jsonString = gson.toJson(generate());
		System.out.println(jsonString);
		
		
		Weapon weapon = gson.fromJson(jsonString, Weapon.class);
		
		
		System.out.println(weapon.getDescription());
		System.out.println(weapon.getEffects().get(0).getOptions()[0]);
		
		
		try {
			FileWriter fr = new FileWriter(templateName + ".txt");
			fr.write(jsonString);
			fr.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Weapon generate() {
		return new Weapon(name, description, stats, effect);
	}

}
