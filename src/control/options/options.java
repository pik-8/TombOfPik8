package control.options;

        import java.net.URL;
        import java.util.ResourceBundle;

        import javafx.application.Platform;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.control.Slider;
        import javafx.scene.input.MouseEvent;

public class options {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private Label label_general;
    @FXML
    private Label label_effects;
    @FXML
    private Label label_music;
    @FXML
    private Slider slider_general;
    @FXML
    private Slider slider_effects;
    @FXML
    private Slider slider_music;

    @FXML
    void onEffectsChanged(MouseEvent event) {
        int sliderValue = (int) slider_effects.getValue();
        System.out.println(sliderValue + " ");
        label_effects.setText(slider_effects.getValue()+" ");
    }

    @FXML
    void onExitClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onGeneralChanged(MouseEvent event) {

    }

    @FXML
    void onGraphicsClick(ActionEvent event) {

    }

    @FXML
    void onLanguageClick(ActionEvent event) {

    }

    @FXML
    void onMusicChanged(MouseEvent event) {

    }

    @FXML
    void onSoundClick(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
