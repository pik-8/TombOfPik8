package view.Scenes;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.dungeon.Dungeon;
import view.DungeonPrinter;

public class DungeonScene extends Scene {

    private static final String FILE_KEY = "file:";


    public DungeonScene(Dungeon dungeon) {
        super(new Pane());
        Pane dungeonLayout = DungeonPrinter.printDungeonImage(dungeon);
        Pane hud = new Pane();

        ImageView background = new ImageView(new Image(FILE_KEY + "resources/images/DungeonBackground.png"));

        dungeonLayout.setScaleX(0.1);
        dungeonLayout.setScaleY(0.1);
        ((Pane)this.getRoot()).getChildren().add(background);
        ((Pane)this.getRoot()).getChildren().addAll(dungeonLayout, hud);


        this.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case LEFT:
                    dungeonLayout.setTranslateX(dungeonLayout.getTranslateX() +100);
                    break;
                case RIGHT:
                    dungeonLayout.setTranslateX(dungeonLayout.getTranslateX() - 100);
                    break;
                case DOWN:
                    dungeonLayout.setTranslateY(dungeonLayout.getTranslateY() -100);
                    break;
                case UP:
                    dungeonLayout.setTranslateY(dungeonLayout.getTranslateY() + 100);
                    break;
            }
            e.consume();
        });

    }
}
