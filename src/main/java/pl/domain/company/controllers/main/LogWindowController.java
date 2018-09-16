package pl.domain.company.controllers.main;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogWindowController {

    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button registerButton;
    @FXML
    private TextField loginTextField;
    @FXML
    private Button logButton;
    private Stage registerStage = new Stage();
    private Parent registerParent;
    private Scene registerScene;


    @FXML
    public void initialize(){

    }


    @FXML
    public void checkInDatabase() {
        /** wywołać połączenie do bazy danych,
         * sprawdzić czy istnieje użytkownik o podanych danych,
         * zamknąć połączenie z bazą,
         * zamknąć okno logowania,
         * otworzyć głowne okno programu
         */
        /*DbManager dbManager = new DbManager();
        Connection connect = null;
        try {
            connect = dbManager.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement statement;
            statement = connect.prepareStatement
                    ("SELECT (login,password) from users where login = ? and password = ?");
            statement.setString(1,loginTextField.getText());
            statement.setString(2,passwordField.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        Stage stage = (Stage)logButton.getScene().getWindow();
        stage.close();


    }

    public Stage getRegisterStage() {
        return registerStage;
    }

    public void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
