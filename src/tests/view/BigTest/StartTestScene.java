package tests.view.BigTest;

import static constants.ImagePaths.PATH_TO_START_SCREEN_BACKGROUND;
import static constants.ImagePaths.PATH_TO_START_SCREEN_BOTTOM_SPHERE;
import static constants.ImagePaths.PATH_TO_START_SCREEN_CLOUDS_BACKGROUND;
import static constants.ImagePaths.PATH_TO_START_SCREEN_CLOUDS_FOREGROUND;
import static constants.ImagePaths.PATH_TO_START_SCREEN_LEAF;
import static constants.ImagePaths.PATH_TO_START_SCREEN_LEFT_SPHERE;
import static constants.ImagePaths.PATH_TO_START_SCREEN_LIGHT_RAYS_BACKGROUND;
import static constants.ImagePaths.PATH_TO_START_SCREEN_RIGHT_SPHERE;
import static constants.ImagePaths.PATH_TO_START_SCREEN_TOP_SPHERE;
import static constants.ImagePaths.PATH_TO_START_SCREEN_TRUNK;

import constants.view.DefaultTextureSize;
import constants.view.StartSceneProperties;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class StartTestScene extends Stage {

	private final String FILE_KEY = "file:";

	private final ImageView background;
	private final ImageView cloudsBackground;
	private final ImageView cloudsForeground;
	private final ImageView trunk;
	private final ImageView bottomSphere;
	private final ImageView leftSphere;
	private final ImageView rightSphere;
	private final ImageView topSphere;
	private final ImageView leaf;
	private final ImageView lightRaysBackground;

	private final ImageView[] allImages;


	private final Pane layout;
		private  final Scene scene;
	public StartTestScene() {
		this.background = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_BACKGROUND));
		this.cloudsBackground = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_CLOUDS_BACKGROUND));
		this.cloudsForeground = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_CLOUDS_FOREGROUND));
		this.trunk = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_TRUNK));
		this.leaf = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_LEAF));
		this.bottomSphere = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_BOTTOM_SPHERE));
		this.leftSphere = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_LEFT_SPHERE));
		this.rightSphere = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_RIGHT_SPHERE));
		this.topSphere = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_TOP_SPHERE));
		this.lightRaysBackground = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_LIGHT_RAYS_BACKGROUND));

		// the order is important. The later, the higher the priority.
		this.allImages = new ImageView[] { this.background, this.cloudsBackground, this.lightRaysBackground,
				this.bottomSphere, this.leftSphere, this.rightSphere, this.topSphere, this.trunk, this.leaf,
				this.cloudsForeground };


		this.leaf.setOnMouseClicked(e -> System.out.println("Clicked"));
		/*
		this.leaf.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("Tile pressed ");
				event.consume();
			}
		});
		 */
		this.setTitle("Tomb of Pik 8");

		this.layout = new Pane();
//      setSizeImages(WIDTH, HEIGHT);

		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
				
		setX(bounds.getMinX());
		setY(bounds.getMinY());
		setWidth(bounds.getWidth());
		setHeight(bounds.getHeight());


		
//		this.setFullScreen(true);
		setLayout();
		setPosition();
		setSizeImages(bounds.getWidth(), bounds.getHeight());


		this.scene = new Scene(layout, bounds.getWidth(), bounds.getHeight());
		this.setScene(scene);

		widthProperty().addListener((obs, oldVal, newVal) -> {
			setScaledWidth((double) newVal);
			setScaledXPosition((double) newVal / (double) oldVal);
		});

		heightProperty().addListener((obs, oldVal, newVal) -> {
			setScaledHeight((double) newVal);
			setScaledYPosition((double) newVal / (double) oldVal);
		});


	}

	private void setLayout() {
		// here was the set graphic before.
		this.layout.getChildren().addAll(this.allImages);
	}

	private void setSizeImages(double width, double height) {
		double ratioHeight = DefaultTextureSize.HEIGHT / height;
		double ratioWidth = DefaultTextureSize.WIDTH / width;

		for (ImageView image : allImages) {
			image.setFitWidth(image.getImage().getWidth() / ratioWidth);
			image.setFitHeight(image.getImage().getHeight() / ratioHeight);
		}
	}


	private void setScaledWidth(double width) {
		double ratioWidth = DefaultTextureSize.WIDTH / width;
		for (ImageView image : allImages) {
			image.setFitWidth(image.getImage().getWidth() / ratioWidth);
		}
	}

	private void setScaledHeight(double height) {
		double ratioHeight = DefaultTextureSize.HEIGHT / height;
		for (ImageView image : allImages) {
			image.setFitHeight(image.getImage().getHeight() / ratioHeight);
		}
	}

	private void setScaledXPosition(double ratio) {
		for (ImageView image : allImages) {
			image.setTranslateX(image.getTranslateX() * ratio);
		}
	}

	private void setScaledYPosition(double ratio) {
		for (ImageView image : allImages) {
			image.setTranslateY(image.getTranslateY() * ratio);
		}
	}

	private void setPosition() {
		changePosition(this.background, StartSceneProperties.POSITION_BACKGROUND[0], StartSceneProperties.POSITION_BACKGROUND[1]);
		changePosition(this.cloudsBackground, StartSceneProperties.POSITION_CLOUDS_BACKGROUND[0], StartSceneProperties.POSITION_CLOUDS_BACKGROUND[1]);
		changePosition(this.cloudsForeground, StartSceneProperties.POSITION_CLOUDS_FOREGROUND[0], StartSceneProperties.POSITION_CLOUDS_FOREGROUND[1]);
		changePosition(this.trunk, StartSceneProperties.POSITION_TRUNK[0], StartSceneProperties.POSITION_TRUNK[1]);
		changePosition(this.bottomSphere, StartSceneProperties.POSITION_BOTTOM_SPHERE[0], StartSceneProperties.POSITION_BOTTOM_SPHERE[1]);
		changePosition(this.leftSphere, StartSceneProperties.POSITION_LEFT_SPHERE[0], StartSceneProperties.POSITION_LEFT_SPHERE[1]);
		changePosition(this.rightSphere, StartSceneProperties.POSITION_RIGHT_SPHERE[0], StartSceneProperties.POSITION_RIGHT_SPHERE[1]);
		changePosition(this.topSphere, StartSceneProperties.POSITION_TOP_SPHERE[0], StartSceneProperties.POSITION_TOP_SPHERE[1]);
		changePosition(this.lightRaysBackground, StartSceneProperties.POSITION_LIGHT_RAYS_BACKGROUND[0], StartSceneProperties.POSITION_LIGHT_RAYS_BACKGROUND[1]);
		changePosition(this.leaf, StartSceneProperties.POSITION_LEAF[0], StartSceneProperties.POSITION_LEAF[1]);

		//changePosition(this.leafButton, StartSceneProperties.posLeafButton[0], StartSceneProperties.posLeafButton[1]);
	}

	private void changePosition(ImageView image, double xValue, double yValue) {
		image.setTranslateX(xValue);
		image.setTranslateY(yValue);
	}

	private void changePosition(Button button, double xValue, double yValue) {
		button.setTranslateX(xValue);
		button.setTranslateY(yValue);
	}
}
