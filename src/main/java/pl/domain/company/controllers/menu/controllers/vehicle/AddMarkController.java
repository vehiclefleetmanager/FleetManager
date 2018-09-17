package pl.domain.company.controllers.menu.controllers.vehicle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.domain.company.database.modelFx.vehicles.mark.MarkModel;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;
import pl.domain.company.database.utils.validations.Validation;

public class AddMarkController {
    @FXML
    private TextField markName;
    @FXML
    private Button addMark;
    @FXML
    private Button cancel;

    private MarkModel markModel;

    @FXML
    public void initialize() {
        this.addMark.disableProperty().bind(this.markName.textProperty().isEmpty());
        this.markModel = new MarkModel();
        try {
            markModel.init();
        } catch (ApplicationExceptions ae) {
            ae.printStackTrace();
        }
    }

    public void addMarkInDatabase() {
        try {
            this.markModel.saveVehicleMarkInDatabase(this.markName.getText());
        } catch (ApplicationExceptions applicationExceptions) {
            applicationExceptions.printStackTrace();
        }
        closeWindow(addMark);
        Validation.showInformation("Dodano markę pojazdu do bazy");
    }

    public void cancel() {
        closeWindow(cancel);
    }

    private void closeWindow(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
