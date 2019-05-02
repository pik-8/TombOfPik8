package control.options;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;

        import constants.FileConstants;
        import javafx.application.Platform;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.control.Label;
        import javafx.scene.control.RadioButton;
        import javafx.scene.control.Slider;
        import javafx.scene.control.ToggleGroup;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.Pane;
        import view.options.Options;

        import javax.swing.event.TreeModelEvent;

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
    private ToggleGroup language;

    @FXML
    private RadioButton languageGerman;

    @FXML
    private RadioButton languageEnglish;

    @FXML
    void onEffectsChanged(MouseEvent event) {
        int sliderValue = (int) slider_effects.getValue();
        System.out.println(sliderValue + " ");
        label_effects.setText("general (" + slider_effects.getValue()+"%)");
    }

    @FXML
    void onExitClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onGeneralChanged(MouseEvent event) {
        int sliderValue = (int) slider_general.getValue();
        System.out.println(sliderValue + " ");
        label_general.setText("general (" + slider_general.getValue()+"%)");
    }

    @FXML
    void onGraphicsClick(ActionEvent event) {

    }

    @FXML
    void onLanguageClick(ActionEvent event) throws IOException {
        System.out.println("click! taskBarButton2");
        //content.getChildren().clear();
        //Parent language = FXMLLoader.load(getClass().getResource("/languageSettings.fxml"));
        //content.getChildren().add(language);
    }

    @FXML
    void onLanguageSaveClick(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) language.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        System.out.println(toogleGroupValue);
    }

    @FXML
    void onMusicChanged(MouseEvent event) {
        int sliderValue = (int) slider_music.getValue();
        System.out.println(sliderValue + " ");
        label_music.setText("general (" + slider_music.getValue()+"%)");
    }

    @FXML
    void onResolutionSaveClick(ActionEvent event) {

    }

    @FXML
    void onSoundClick(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
