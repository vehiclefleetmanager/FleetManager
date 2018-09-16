package pl.domain.company.database.utils.validations;

import javafx.scene.control.Alert;
import javafx.stage.Modality;

public class Validation {
    public static void showInformation(String info) {
        Alert warningAlert = new Alert(Alert.AlertType.WARNING);
        warningAlert.setTitle("Błędne dane");
        warningAlert.setHeaderText(info);
        warningAlert.initModality(Modality.APPLICATION_MODAL);
        warningAlert.show();
    }
}
