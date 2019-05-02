package control;

import model.overworld.Overworld;

public class WorldHandler {

	Overworld overworld;
	
	private void init() {
		this.overworld = new Overworld();
	}
	
	public WorldHandler() {
		init();
	}

}
