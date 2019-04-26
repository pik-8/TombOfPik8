package model.io;

import java.io.File;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
 * @author Frederick Hastedt
 *
 * Can read in and parse different kinds of templates.
 */
public class TemplateReader {

	/**
	 * Reads in a file and returns a JsonObject created from the contents.
	 * Method courtesy of madonnelly at https://gist.github.com/madonnelly/1371597
	 * @param path The path to the file.
	 * @return The JsonObject created from the file.
	 */
	public static JsonObject readTemplateAsJsonObject(String path) {
		return readTemplateAsJsonObject(new File(path));
	}
	
	public static JsonObject readTemplateAsJsonObject(File file) {
		JsonObject jsonObject = new JsonObject();
		try {
			JsonParser parse = new JsonParser();
			JsonElement jsonElement = parse.parse(new FileReader(file));
			jsonObject = jsonElement.getAsJsonObject();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return jsonObject;
	}

}