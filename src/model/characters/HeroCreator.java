package model.characters;

import java.io.File;
import java.util.ArrayList;

import model.effects.Effect;
import model.fighting.Attack;
import model.fighting.AttackPattern;
import model.io.TemplateReader;

/**
 * Deprecated, but the one method will still be needed later on.
 * 
 * @author Frederick Hastedt
 *
 */
public class HeroCreator {
	
	private Attack[] readAvailableAttacks(String classPath) {
		ArrayList<Attack> attackList = new ArrayList<Attack>();
		
		File dir = new File(classPath + "/attacks");
		File[] allFiles= dir.listFiles();
		if (allFiles != null) {
			for (File attack : allFiles) {
				attackList.add(gson.fromJson(TemplateReader.readTemplateAsJsonObject(attack), Attack.class));
			}
		} else {
			// Basic Attack to ensure the list is never empty.
			attackList.add(new Attack("Basic Attack", "Hit them.",
					100, 100, 100,
					1, null,
					new AttackPattern(new float[][]{{0.0f, 1.0f, 0.0f},
							{0.0f, -1.0f, 0.0f}}, 
							new Effect[][]{{null, null, null},
							{null, null, null}}),
					0));
		}
		
		Attack[] attackArray = new Attack[attackList.size()];
		for(int i = 0; i < attackList.size(); i++)
			attackArray[i] = attackList.get(i);
		return attackArray;
	} 
}