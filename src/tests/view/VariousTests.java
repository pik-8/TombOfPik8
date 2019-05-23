package tests.view;

import view.ConfigStream;

public class VariousTests {

    public static void main (String[] args) throws Exception {
        testConfigReader();
    }

    public static void testConfigReader () throws Exception {
        ConfigStream configStream = new ConfigStream("Game.config");
        System.out.println(configStream.getStringFromConfigFile("test"));
        System.out.println(configStream.getNumberFromConfigFile("test2"));
        System.out.println(configStream.getNumberFromConfigFile("test3"));
    }
}
