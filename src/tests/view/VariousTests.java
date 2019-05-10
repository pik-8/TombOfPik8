package tests.view;

import view.ConfigReader;

public class VariousTests {

    public static void main (String[] args) throws Exception {
        testConfigReader();
    }

    public static void testConfigReader () throws Exception {
        ConfigReader configReader = new ConfigReader("Game.config");
        System.out.println(configReader.getStringFromConfigFile("test"));
        System.out.println(configReader.getNumberFromConfigFile("test2"));
        System.out.println(configReader.getNumberFromConfigFile("test3"));
    }
}
