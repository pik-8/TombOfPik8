package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.dungeon.Square;
import model.effects.Effect;
import model.items.Equipment;

public class EffectHandler {

	private HashMap<model.characters.Character, ArrayList<Effect>> characterEffectList;
	private HashMap<Square, ArrayList<Effect>> squareEffectList;
	private HashMap<Equipment, ArrayList<Effect>> equipmentEffectList;
	
	public EffectHandler() {
		this.characterEffectList = new HashMap<model.characters.Character, ArrayList<Effect>>();
		this.squareEffectList = new HashMap<Square, ArrayList<Effect>>();
		this.equipmentEffectList = new HashMap<Equipment, ArrayList<Effect>>();
	}
	
	public void addEffect(model.characters.Character c, Effect e) {
		if(this.characterEffectList.get(c) == null) {
			ArrayList<Effect> ar = new ArrayList<Effect>();
			ar.add(e);
			this.characterEffectList.put(c, ar);
		}
		else {
			this.characterEffectList.get(c).add(e);
		}
		if(e.isInstantApply()) {
			e.applyEffect(c);
			characterEffectList.get(c).remove(e);
		}
	}
	
	public void addEffect(Square s, Effect e) {
		if(this.squareEffectList.get(s) == null) {
			ArrayList<Effect> ar = new ArrayList<Effect>();
			ar.add(e);
			this.squareEffectList.put(s, ar);
		}
		else
			this.squareEffectList.get(s).add(e);
		if(e.isInstantApply()) {
			e.applyEffect(s);
			squareEffectList.get(s).remove(e);
		}
	}
	
	public void addEffect(Equipment equip, Effect e) {
		if(this.equipmentEffectList.get(equip) == null) {
			ArrayList<Effect> ar = new ArrayList<Effect>();
			ar.add(e);
			this.equipmentEffectList.put(equip, ar);
		}
		else
			this.equipmentEffectList.get(equip).add(e);
		if(e.isInstantApply()) {
			e.applyEffect(equip);
			equipmentEffectList.get(equip).remove(e);
		}
	}
	
	public void applyEffects(model.characters.Character c) {
		ArrayList<Effect> toRemove = new ArrayList<Effect>();
		for(Effect e : characterEffectList.get(c)) {
			if(e.getDuration() > 0) {
				e.applyEffect(c);
				e.lowerDuration();
			}
			else if(e.getDuration() == -1) 
				e.applyEffect(c);
			else
				toRemove.add(e);
		}
		for(Effect e : toRemove) {
			characterEffectList.get(c).remove(e);
		}
	}
	
	public void applyEffects(Square s) {
		ArrayList<Effect> toRemove = new ArrayList<Effect>();
		for(Effect e : squareEffectList.get(s)) {
			if(e.getDuration() > 0) {
				e.applyEffect(s);
				e.lowerDuration();
			}
			else if(e.getDuration() == -1)
				e.applyEffect(s);
			else
				squareEffectList.get(s).remove(e);
		}
		for(Effect e : toRemove) {
			squareEffectList.get(s).remove(e);
		}
	}
	
	public void applyEffects(Equipment equip) {
		ArrayList<Effect> toRemove = new ArrayList<Effect>();
		for(Effect e : equipmentEffectList.get(equip)) {
			if(e.getDuration() > 0) {
				e.applyEffect(equip);
				e.lowerDuration();
			}
			else if(e.getDuration() == -1)
				e.applyEffect(equip);
			else
				equipmentEffectList.get(equip).remove(e);
		}
	}

	public void applyEffects() {
		applyCharacterEffects();
		applySquareEffects();
		applyEquipmentEffects();
	}
	
	public void applyCharacterEffects() {
		for(Map.Entry<model.characters.Character, ArrayList<Effect>> characterSet: characterEffectList.entrySet()) {
			applyEffects(characterSet.getKey());
		}
	}
	
	public void applySquareEffects() {
		for(Map.Entry<Square, ArrayList<Effect>> squareSet: squareEffectList.entrySet()) {
			applyEffects(squareSet.getKey());
		}
	}
	
	public void applyEquipmentEffects() {
		for(Map.Entry<Equipment, ArrayList<Effect>> equipmentSet: equipmentEffectList.entrySet()) {
			applyEffects(equipmentSet.getKey());
		}
	}
	
}
