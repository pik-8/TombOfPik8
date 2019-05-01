package control;

import model.overworld.Overworld;

public class WorldController {

	Overworld overworld;
	
	private void init() {
		this.overworld = new Overworld();
	}
	
	public WorldController() {
		init();
	}

}
