package view.scenes;

import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.dungeon.Dungeon;
import view.DungeonPrinter;
import view.events.DungeonSceneKeyEvent;
import view.events.DungeonSceneScrollEvent;


/**
 * This Scene contains everything, that will be shown, when the player is inside a dungeon.
 * Contains a layout for the Tiles and Terrains, for every Character and for the UI-elements.
 *
 * @author Hagen
 */
public class DungeonScene extends GameScene {


    private final Pane dungeonLayout;
    private Pane characters;
    private final Pane hud;


    public DungeonScene(Dungeon dungeon, double width, double height) {
        super();
        this.dungeonLayout = DungeonPrinter.printFullDungeonImage(dungeon, width, height);
        this.hud = new Pane();
        this.characters = new Pane();

        initBackground(width, height);

        ((Pane)this.getRoot()).getChildren().addAll( this.dungeonLayout, this.characters, this.hud);

        setEvents();
    }


    private void initBackground (double width, double height) {
        ImageView background = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_DUNGEON_BACKGROUND));

        double ratioHeight = DefaultTextureSize.HEIGHT / height;
        double ratioWidth = DefaultTextureSize.WIDTH / width;

        background.setFitWidth(background.getImage().getWidth() / ratioWidth);
        background.setFitHeight(background.getImage().getHeight() / ratioHeight);

        ((Pane)this.getRoot()).getChildren().add(background);
    }


    private void setEvents () {
        this.setOnKeyPressed(new DungeonSceneKeyEvent());

        this.setOnScroll(new DungeonSceneScrollEvent());
    }

    public void setCharacters(Pane characters) {
        this.characters = characters;
    }

    public Pane getCharacters() {
        return characters;
    }

    public Pane getDungeonLayout() {
        return dungeonLayout;
    }

    public Pane getHud() {
        return hud;
    }


    @Override
    public void closeScene() {

    }
}
