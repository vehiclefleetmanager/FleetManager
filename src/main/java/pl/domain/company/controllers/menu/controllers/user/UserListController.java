package pl.domain.company.controllers.menu.controllers.user;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.domain.company.controllers.menu.controllers.Controllable;
import pl.domain.company.database.modelFx.users.UserFx;
import pl.domain.company.database.modelFx.users.UserListModel;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.util.ResourceBundle;
public class UserListController implements Controllable {
    private static final String REGISTER_PATH = "/fxml/fleetmanager/menu/user/AddUsers.fxml";
    private static final String TITLE_WINDOW = "Rejestracja";

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

    @FXML

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


    @Override
    public void showWindow(String path, String title) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
        ResourceBundle bundle = ResourceBundle.getBundle("description.description");
        loader.setResources(bundle);
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert parent != null;
        Scene scene = new Scene(parent);
        Stage registerStage = new Stage();
        registerStage.setScene(scene);
        registerStage.setTitle(title);
        registerStage.initModality(Modality.APPLICATION_MODAL);
        registerStage.show();
    }

    @Override
    public void closeWindow(Button button) {

    }

    public void addUser() {
        openAddUserWindow();
    }

    public void editUser() {

    }

    public void deleteUser() {

    }


    private void openAddUserWindow() {
        showWindow(REGISTER_PATH,TITLE_WINDOW);
    }
}
