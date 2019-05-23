package view.Scenes;

import constants.ImagePaths;
import constants.view.DefaultTextureSize;
import constants.view.DungeonSceneProperties;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.dungeon.Dungeon;
import view.DungeonPrinter;

import javax.swing.*;
import java.awt.*;

public class DungeonScene extends Scene {

    private static final String FILE_KEY = "file:";

    private final Pane dungeonLayout;
    private final Pane hud;


    public DungeonScene(Dungeon dungeon, double width, double height) {
        super(new Pane());
        this.dungeonLayout = DungeonPrinter.printDungeonImage(dungeon, width, height);
        this.hud = new Pane();

        ImageView background = new ImageView(new Image(FILE_KEY + ImagePaths.PATH_TO_DUNGEON_BACKGROUND));

        double ratioHeight = DefaultTextureSize.height / height;
        double ratioWidth = DefaultTextureSize.width / width;

        background.setFitWidth(background.getImage().getWidth() / ratioWidth);
        background.setFitHeight(background.getImage().getHeight() / ratioHeight);

        ((Pane)this.getRoot()).getChildren().addAll(background, dungeonLayout, hud);

        setEvents();
    }

    private void setEvents () {
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

        this.setOnScroll(e -> {
            if (e.getDeltaY() > 0) {
                if (dungeonLayout.getScaleX() <= DungeonSceneProperties.MAX_SCALE_OF_DUNGEON) {
                    dungeonLayout.setScaleY(dungeonLayout.getScaleY() + DungeonSceneProperties.DELTA_FOR_SCROLLING);
                    dungeonLayout.setScaleX(dungeonLayout.getScaleX() + DungeonSceneProperties.DELTA_FOR_SCROLLING);
                }
            } else {
                if ((dungeonLayout.getScaleX() - DungeonSceneProperties.DELTA_FOR_SCROLLING) > DungeonSceneProperties.MIN_SCALE_OF_DUNGEON) {
                    dungeonLayout.setScaleY(dungeonLayout.getScaleY() - DungeonSceneProperties.DELTA_FOR_SCROLLING);
                    dungeonLayout.setScaleX(dungeonLayout.getScaleX() - DungeonSceneProperties.DELTA_FOR_SCROLLING);
                }
            }

        });
    }
}