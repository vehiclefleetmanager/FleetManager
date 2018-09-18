package pl.domain.company.controllers.menu.controllers.user;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pl.domain.company.controllers.menu.controllers.Controllable;
import pl.domain.company.database.modelFx.users.UserModel;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;
import pl.domain.company.database.utils.validations.Validation;

public class AddUserController implements Controllable {
    private static final String NOT_EQUAL_PASSWORD = "Hasła nie są takie same!";
    private static final String WARNING_EQUALS_PASSWORD = "-fx-border-color: red";

    @FXML
    private Label bugLabel;
    @FXML
    private ToggleGroup permissionRadioButton;
    @FXML
    private Button saveUser;
    @FXML
    private Button cancel;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField repeatPasswordField;

    private UserModel userModel;

    @FXML
    @Override
    public void initialize(){
        this.userModel = new UserModel();
        disableSaveUser();
        bindings();
    }

    private void bindings(){
        this.firstNameTextField.textProperty().bindBidirectional(
                this.userModel.getUserFxObjectProperty().userNameProperty());
        this.lastNameTextField.textProperty().bindBidirectional(
                this.userModel.getUserFxObjectProperty().userSurnameProperty());
        this.emailTextField.textProperty().bindBidirectional(
                this.userModel.getUserFxObjectProperty().userEmailProperty());
        this.passwordField.textProperty().bindBidirectional(
                this.userModel.getUserFxObjectProperty().userPasswordProperty());
    }

    private void disableSaveUser() {
        this.saveUser.disableProperty().bind(
                this.firstNameTextField.textProperty().isEmpty()
                .or(this.lastNameTextField.textProperty().isEmpty()
                .or(this.emailTextField.textProperty().isEmpty()
                .or(this.passwordField.textProperty().isEmpty()
                .or(this.repeatPasswordField.textProperty().isEmpty())))));
    }

    public void saveInDatabase() {
        if(!this.passwordField.getText().equals(this.repeatPasswordField.getText())){
                Validation.showInformation(NOT_EQUAL_PASSWORD);
                passwordField.setStyle(WARNING_EQUALS_PASSWORD);
                repeatPasswordField.setStyle(WARNING_EQUALS_PASSWORD);
        }else{
            try {
                userModel.saveUserInDataBase();
                closeWindow(saveUser);
            } catch (ApplicationExceptions applicationExceptions) {
                applicationExceptions.printStackTrace();
            }
        }
    }

    public void cancel(){
        closeWindow(cancel);
    }

    @Override
    public void showWindow(String path, String title) {

    }
    @Override
    public void closeWindow(Button cancel) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
