package control;

import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.effects.Effect;
import model.items.Rarity;
import model.items.Weapon;
import model.json.AdapterFactories;
import model.other.SecondaryStats;

public class WeaponTemplateGenerator {

	private static String templateName = "CommonWeapon";
	
	private static String name = "Old Rusty Dagger";
	private static String description = "Getting hit with this is probably unhealthy.";
	private static Rarity rarity = Rarity.COMMON;
	
	private static Effect effect = EffectTemplateGenerator.generate();
	private static Effect onHitEffect = EffectTemplateGenerator.generate("Sepsis", "Thats not stuff you want running through your veins.", 1, new float[]{0, 20, 0, 0});
	private static SecondaryStats stats = SecondaryStatsTemplateGenerator.generate();
	
	public static void main(String[] args) {
		
		GsonBuilder builder = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		String jsonString = gson.toJson(generate());
		System.out.println(jsonString);
		
		Weapon weapon = gson.fromJson(jsonString, Weapon.class);	
		
		try {
			FileWriter fr = new FileWriter(templateName + ".txt");
			fr.write(jsonString);
			fr.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Weapon generate() {
		ArrayList<Effect> onHit = new ArrayList<Effect>();
		onHit.add(onHitEffect);
		return new Weapon(name, description, stats, rarity, new ArrayList<Effect>(), onHit);
	}

}
