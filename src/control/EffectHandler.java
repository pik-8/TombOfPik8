package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.effects.Effect;
import model.effects.IEffectable;

public class EffectHandler {
	
	private HashMap<IEffectable, ArrayList<Effect>> effectedObjects;
	
	public EffectHandler() {		
		this.effectedObjects = new HashMap<IEffectable, ArrayList<Effect>>();
	}
	
	public void addEffect(IEffectable effectable, Effect e) {
		if(this.effectedObjects.get(effectable) == null) {
			ArrayList<Effect> ar = new ArrayList<Effect>();
			ar.add(e);
			this.effectedObjects.put(effectable, ar);
		} else {
			this.effectedObjects.get(effectable).add(e);
		}
		if(e.isInstantApply()) {
			effectable.effect(e);
			effectedObjects.get(effectable).remove(e);
		}
	}
	
	private void applyEffectsOnSingleEffectable(IEffectable effectable) {
		ArrayList<Effect> toRemove = new ArrayList<Effect>();
		for(Effect e : effectedObjects.get(effectable)) {
			if(e.getDuration() > 0) {
				effectable.effect(e);
				e.lowerDuration();
			}
			else if(e.getDuration() == -1)
				effectable.effect(e);
			else
				toRemove.add(e);
		}
		if(!toRemove.isEmpty()) {
			uneffectAll(effectable);
			removeEffects(effectable, toRemove);
			reeffectAll(effectable);		
			if(effectedObjects.get(effectable).isEmpty()) {
				effectedObjects.remove(effectable);
			} 
		}	
	}
	
	private void uneffectAll(IEffectable effectable) {
		for(int i = effectedObjects.get(effectable).size() - 1; i >= 0; i--) {
			effectable.uneffect(effectedObjects.get(effectable).get(i));
		}
	}
	
	private void removeEffects(IEffectable effectable, ArrayList<Effect> toRemove) {
		for(Effect e : toRemove) {
			effectedObjects.get(effectable).remove(e);
		}
	}
	
	private void reeffectAll(IEffectable effectable) {
		for(Effect e : effectedObjects.get(effectable)) {
			effectable.reeffect(e);
		}
	}
	
	public void applyAllEffects() {
		for(Map.Entry<IEffectable, ArrayList<Effect>> effectableSet : effectedObjects.entrySet()) {
			applyEffectsOnSingleEffectable(effectableSet.getKey());
		}
	}	
}