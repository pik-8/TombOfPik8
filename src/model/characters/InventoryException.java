package model.characters;

import constants.ExceptionConstants;

/**
 * An Exception to be used with everything concerning the Inventory
 * where no native Java exception fits the use-case. * 
 * 
 * @author Frederick Hastedt
 *
 */
public class InventoryException extends Exception {
	
	public InventoryException(String message) {
		super(message);
	}
}
