package model.effects;

public interface IEffectable {
	public void effect(Effect e);
	
	public void uneffect(Effect e);
	
	public void reeffect(Effect e);
}
