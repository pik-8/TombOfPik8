package model.items;

import constants.ExceptionConstants;

/**
 * 
 * @author Frederick Hastedt
 *
 * This Exception is thrown when an item is added to a full inventory.
 */
public class InventoryFullException extends Exception {
	@Override
	public String getMessage() {
		return ExceptionConstants.INVENTORY_IS_FULL;
	}
}
