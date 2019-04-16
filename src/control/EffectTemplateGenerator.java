package control;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.effects.Effect;
import model.effects.HealingEffect;
import model.items.Weapon;

public class EffectTemplateGenerator {

	private static String templateName = "EffectTemplate";
	
	private static String name = "";
	private static String description = "";
	
	private static int duration = 1;
	private static int[] options = {10,0,0,0};
	
	private static boolean relevanze = true;
	
	
	
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		String jsonString = gson.toJson(generate());
		HealingEffect effect = gson.fromJson(jsonString, HealingEffect.class);
		
		try {
			FileWriter fr = new FileWriter(templateName + ".txt");
			fr.write(jsonString);
			fr.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Effect generate() {
		return new HealingEffect(name, description, 
						duration, options);
	}
}