package model.items;

/**
 * 
 * @author Frederick Hastedt
 * 
 * enum for the different Crafting Materials that exist in this game.
 *
 */
public enum CraftingMaterial {
	CLOTH("Cloth"),
	LEATHER("Leather"),
	IVORY("Ivory"),
	MAGIC_DUST("Magic Dust");
	
	private String description;
	
	CraftingMaterial(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
