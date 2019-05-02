package model.characters;

import java.util.ArrayList;
import java.util.HashMap;

import constants.ModelProperties;
import model.items.Consumable;
import model.items.CraftingMaterial;
import model.items.Equipment;
import model.items.InventoryFullException;

/**
 * 
 * @author Frederick Hastedt
 *
 * This class contains everything that should be stored in an inventory along with behavior
 * to add to or subtract from it.
 */
public class Inventory {
		
	private ArrayList<Consumable> consumables;
	private ArrayList<Equipment> equipment;
	private HashMap<CraftingMaterial, Integer> materials;
	
	private long money;
	private int itemCount;
	private int size;
	
	public Inventory () {
		init();
		size = ModelProperties.INVENTORY_IS_INFINITE;
	}
	
	public Inventory (int size) {
		init();	
		this.size = size;
	}
	
	public Inventory (int size, long money) {
		init();
		this.size = size;
		this.money = money;
	}

	private void init() {
		consumables = new ArrayList<Consumable>();
		equipment = new ArrayList<Equipment>();
		materials = new HashMap<CraftingMaterial, Integer>();
		
		itemCount = 0;
		money = 0;
	}
	
	private boolean incrementItemCount() {
		if(itemCount < size || size == ModelProperties.INVENTORY_IS_INFINITE) {
			itemCount++;
			return true;
		}
		return false;	
	}
	
	private boolean decrementItemCount() {
		if(itemCount > 0) {
			itemCount--;
			return true;
		}
		return false;
	}
	
	private boolean isFull(){
		return itemCount == size;
	}
	
	private boolean isEmpty() {
		return itemCount == 0;
	}

	public ArrayList<Consumable> getConsumables() {
		return consumables;
	}

	/**
	 * Adds a consumable item to the inventory if it is not full, then returns the updated list of consumables.
	 * @param cons The consumable to be added.
	 * @return The updated list of consumables.
	 * @throws InventoryFullException Thrown if tried to add to a full Inventory.
	 */
	public ArrayList<Consumable> addConsumable(Consumable cons) throws InventoryFullException {
		if(incrementItemCount())
			consumables.add(cons);
		else 
			throw new InventoryFullException();
		return consumables;
	}
	
	/**
	 * Removes a consumable item from the inventory, then returns the updated list of consumables.
	 * @param cons The consumable to be removed.
	 * @return The updated list of consumables.
	 */
	public ArrayList<Consumable> removeConsumable(Consumable cons) {
		if(consumables.contains(cons)) {
			decrementItemCount();
			consumables.remove(cons);
		}
		return consumables;
	}
	
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	
	/**
	 * Adds an equipment item to the inventory if it is not full, then returns the updated list of equipment.
	 * @param equip The equipment to be added.
	 * @return The updated list of equipment.
	 * @throws InventoryFullException Thrown if tried to add to a full Inventory.
	 */
	public ArrayList<Equipment> addEquipment(Equipment equip) throws InventoryFullException {
		if(incrementItemCount())
			equipment.add(equip);
		else
			throw new InventoryFullException();
		return equipment;
	}
	
	/**
	 * Removes an equipment item from the inventory, then returns the updated list of equipment.
	 * @param equip The equipment to be removed.
	 * @return The updated list of equipment.
	 */
	public ArrayList<Equipment> removeEquipment(Equipment equip) {
		if(equipment.contains(equip)) { 
			decrementItemCount();
			equipment.remove(equip);
		}
		return equipment;
	}
	
	public HashMap<CraftingMaterial, Integer> getMaterials() {
		return materials;
	}

	/**
	 * Adds an amount of material to the inventory.
	 * @param mat The material to be added.
	 * @return true if the material was successfully added, false otherwise.
	 */
	public boolean addMaterial(CraftingMaterial mat, int amount) {
		if(amount >= 0) {
			if(materials.containsKey(mat)) 
				materials.put(mat, materials.get(mat) + amount);
			else
				materials.put(mat, amount);
			return true;
		}
		return false;	
	}
	
	/**
	 * Subtracts an amount of material from the inventory.
	 * @param mat The material to be subtracted.
	 * @return true if the material was successfully subtracted, false otherwise.
	 */
	public boolean subtractMaterial(CraftingMaterial mat, int amount) {
		if(amount >= 0) {
			if(materials.containsKey(mat) && materials.get(mat) - amount > 0) 
				materials.put(mat, materials.get(mat) - amount);
			else
				materials.put(mat, amount);
			return true;
		}
		return false;	
	}
	
	/**
	 * Adds money to the inventory.
	 * @param amount How much money should be added.
	 * @return true if the money was successfully added, false otherwise.
	 */
	public boolean addMoney(long amount) {
		if(amount > 0) {
			this.money += amount;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Subtracts money from the inventory.
	 * @param amount How much money should be subtracted.
	 * @return true if the money was successfully subtracted, false otherwise.
	 */
	public boolean subtractMoney(long amount) {
		if(amount > 0 && money - amount >= 0) {
			this.money -= amount;
			return true;
		}
		else
			return false;
	}

	public int getItemCount() {
		return itemCount;
	}
	
	public int getSize() {
		return size;
	}
}
