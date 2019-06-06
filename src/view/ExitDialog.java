package view;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.view.ExitDialogProperties;
import control.GameController;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.io.FileReader;
import java.util.Properties;

public class ExitDialog extends Dialog<ButtonType> {

    public ExitDialog () {
        Properties property = new Properties();
        try {
            property.load(new FileReader(FileConstants.PATH_TO_LANGUAGES + "/"
                    + GameController.getGameController().getLanguage() + FileConstants.PATH_TO_EXIT_DIALO_CONFIG));
        } catch (Exception e) {
            System.out.println(e);
        }

        initDialog(property);

        this.showAndWait().ifPresent(response -> {
            if (response.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                System.exit(42); // The number has no meaning.
            }
        });
    }

    private void initDialog (Properties property) {
        ButtonType exitButton = new ButtonType(property.getProperty(ConfigKeys.EXIT_DIALOG_AGREE_BUTTON,
                ExitDialogProperties.STANDARD_AGREE_BUTTON), ButtonBar.ButtonData.OK_DONE);
        ButtonType stayButton = new ButtonType(property.getProperty(ConfigKeys.EXIT_DIALOG_DISAGREE_BUTTON,
                ExitDialogProperties.STANDARD_DISAGREE_BUTTON), ButtonBar.ButtonData.NO);

        this.getDialogPane().getButtonTypes().addAll(exitButton, stayButton);
        this.setContentText(property.getProperty(ConfigKeys.EXIT_DIALOG_TEXT, ExitDialogProperties.STANDARD_TEXT));
    }
}
