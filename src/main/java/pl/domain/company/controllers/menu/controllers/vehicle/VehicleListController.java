package pl.domain.company.controllers.menu.controllers.vehicle;
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
import pl.domain.company.database.modelFx.vehicles.VehicleFx;
import pl.domain.company.database.modelFx.vehicles.VehiclesListModel;
import pl.domain.company.database.modelFx.vehicles.mark.MarkFx;
import pl.domain.company.database.modelFx.vehicles.model.ModelFx;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
public class VehicleListController implements Controllable {
    private static final String ADD_VEHICLE = "/fxml/fleetmanager/menu/vehicle/AddVehicle.fxml";
    private static String WINDOW_TITLE = "Dodawanie pojazdu";
    @FXML
    private Button addVehicle;
    @FXML
    private Button editVehicle;
    @FXML
    private Button deleteVehicle;
    @FXML
    private Button filterButton;
    @FXML
    private TableView<VehicleFx> vehiclesList;
    @FXML
    private TableColumn<VehicleFx, String> registrationNumber;
    @FXML
    private TableColumn<VehicleFx, MarkFx> markVehicle;
    @FXML
    private TableColumn<VehicleFx, ModelFx> modelVehicle;
    @FXML
    private TableColumn<VehicleFx, LocalDate> overviewDate;
    @FXML
    private TableColumn<VehicleFx, LocalDate> policyDate;
    @FXML
    private TableColumn<VehicleFx, LocalDate> serviceDate;
    @FXML
    private TableColumn<VehicleFx, String> typeVehicle;

    private VehiclesListModel listVehiclesModel;

    @FXML
    @Override
    public void initialize() {
        this.listVehiclesModel = new VehiclesListModel();
        try {
            this.listVehiclesModel.init();
        } catch (ApplicationExceptions e) {
            e.printStackTrace();
        }
        this.vehiclesList.setItems(this.listVehiclesModel.getVehicleFxObservableList());
        this.registrationNumber.setCellValueFactory(cellData -> cellData.getValue().registerNumberProperty());
        this.markVehicle.setCellValueFactory(cellData -> cellData.getValue().vehicleMarkProperty());
        this.modelVehicle.setCellValueFactory(cellData -> cellData.getValue().vehicleModelProperty());
        this.overviewDate.setCellValueFactory(cellData -> cellData.getValue().vehicleReviewDateProperty());
        this.serviceDate.setCellValueFactory(cellData -> cellData.getValue().serviceDateProperty());
        this.policyDate.setCellValueFactory(cellData -> cellData.getValue().insuranceDateProperty());
        this.typeVehicle.setCellValueFactory(cellData -> cellData.getValue().vehicleTypeProperty());
    }


    @FXML
    public void addVehicleWindow() {
        showWindow(ADD_VEHICLE, WINDOW_TITLE);
    }

    @Override
    public void showWindow(String path, String title) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
        ResourceBundle bundle = ResourceBundle.getBundle("description.description");
        loader.setResources(bundle);
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        assert parent != null;
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @Override
    public void closeWindow(Button button) {

    }
}
