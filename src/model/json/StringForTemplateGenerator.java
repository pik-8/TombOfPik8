package model.json;

/**
 * A class that produces strings, that can be used in templates.
 */
public class StringForTemplateGenerator {

    public static void main (String[] args) {
        attackPatternGenerator();
    }

    public static void attackPatternGenerator () {
        float[][] attackPattern = {
                {0, 0, 0,  0, 0, 0, 0},
                {0, 0, 0,  0, 0, 0, 0},
                {0, 0, 0,  0, 0, 0, 0},
                {0, 0, 0, -1, 0, 0, 0},
                {0, 0, 0,  0, 0, 0, 0},
                {0, 0, 0,  0, 0, 0, 0},
                {0, 0, 0,  0, 0, 0, 0},
        };

        System.out.println();
        for (int x = 0; x < attackPattern[0].length; x++) {
            System.out.print("[");
            for (int y = 0; y < attackPattern.length; y++) {
                System.out.print(attackPattern[x][y]);
                if (y != attackPattern.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (x != attackPattern[0].length - 1) {
                System.out.print(",\n");
            }
        }
        System.out.println();
    }
}
