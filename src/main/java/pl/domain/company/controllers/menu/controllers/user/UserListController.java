package pl.domain.company.controllers.menu.controllers.user;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pl.domain.company.database.modelFx.users.UserFx;
import pl.domain.company.database.modelFx.users.UserListModel;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.util.ResourceBundle;
public class UserListController {
    private static final String REGISTER_PATH = "/fxml/fleetmanager/menu/users/AddUsers.fxml";
    @FXML
    private Button addUserButton;
    @FXML
    private Button editUserButton;
    @FXML
    private Button deleteUserButton;
    @FXML
    private TableView<UserFx> usersList;
    @FXML
    private TableColumn<UserFx, String> userName;
    @FXML
    private TableColumn<UserFx, String> userSurname;
    @FXML
    private TableColumn<UserFx, String> userEmail;
    @FXML
    private TableColumn<UserFx, String> userPermission;

    private UserListModel userListModel;

    public void initialize(){
        this.userListModel = new UserListModel();
        try {
            this.userListModel.init();
        } catch (ApplicationExceptions e) {
            e.printStackTrace();
        }

        this.usersList.setItems(this.userListModel.getUserFxObservableList());
        this.userName.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
        this.userSurname.setCellValueFactory(cellData -> cellData.getValue().userSurnameProperty());
        this.userEmail.setCellValueFactory(cellData -> cellData.getValue().userEmailProperty());
        this.userPermission.setCellValueFactory(cellData -> cellData.getValue().userPermissionProperty());
    }



    public void addUser() {
        openRegisterWindow();
    }

    public void editUser() {

    }

    public void deleteUser() {

    }


    @FXML
    public void openRegisterWindow() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(REGISTER_PATH));
        ResourceBundle bundle = ResourceBundle.getBundle("description.description");
        loader.setResources(bundle);
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage registerStage = new Stage();
        registerStage.setScene(scene);
        registerStage.setTitle("Panel rejestracji");
        registerStage.show();
        registerStage.setAlwaysOnTop(true);
    }
}
