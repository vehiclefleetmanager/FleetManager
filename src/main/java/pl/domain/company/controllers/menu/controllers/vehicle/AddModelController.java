package pl.domain.company.controllers.menu.controllers.vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.domain.company.controllers.menu.controllers.Controllable;
import pl.domain.company.database.modelFx.vehicles.model.ModelModel;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;
import pl.domain.company.database.utils.validations.Validation;

public class AddModelController implements Controllable {
    @FXML
    private TextField modelName;
    @FXML
    private Button addModel;
    @FXML
    private Button cancel;

    private ModelModel modelModel;

    @FXML
    @Override
    public void initialize(){
        this.modelModel = new ModelModel();
        try{
            this.modelModel.init();
        }catch (ApplicationExceptions ae){
            ae.printStackTrace();
        }
        initBindings();
    }

    private void initBindings(){
        this.addModel.disableProperty().bind(this.modelName.textProperty().isEmpty());
    }

    public void addModelInDatabase() {
        try {
            this.modelModel.saveVehicleModelInDatabase(modelName.getText());
        } catch (ApplicationExceptions applicationExceptions) {
            applicationExceptions.printStackTrace();
        }
        closeWindow(addModel);
        Validation.showInformation("Dodano model pojazdu do bazy");
    }


    public void cancel() {
        closeWindow(cancel);
    }

    @Override
    public void showWindow(String path, String title) {

    }

    @Override
    public void closeWindow(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

}
