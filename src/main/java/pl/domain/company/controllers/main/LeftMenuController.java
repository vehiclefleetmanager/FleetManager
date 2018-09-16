package pl.domain.company.controllers.main;

import javafx.fxml.FXML;

public class LeftMenuController {
    private static final String VEHICLES = "/fxml/fleetmanager/menu/vehicle/VehicleList.fxml";
    private static final String ADD_REPAIR = "/fxml/fleetmanager/menu/repair/AddRepair.fxml";
    private static final String ADD_VEHICLE = "/fxml/fleetmanager/menu/vehicle/AddVehicle.fxml";
    private static final String DELETE_VEHICLE = "/fxml/fleetmanager/menu/vehicle/DeleteVehicle.fxml";
    private static final String EDIT_REPAIR = "/fxml/fleetmanager/menu/repair/EditRepair.fxml";
    private static final String EDIT_VEHICLE = "/fxml/fleetmanager/menu/vehicle/EditVehicle.fxml";
    private static final String OPEN_ABOUT = "/fxml/fleetmanager/menu/tools/OpenAbout.fxml";
    private static final String OPEN_CALCULATOR = "/fxml/fleetmanager/menu/tools/OpenCalculator.fxml";
    private static final String OPEN_CONVERTER = "/fxml/fleetmanager/menu/tools/OpenConverter.fxml";
    private static final String OPEN_USERS = "/fxml/fleetmanager/menu/user/UserList.fxml";
    private static final String INTRO = "/fxml/fleetmanager/main/Intro.fxml";
    private MainController mainController;



    @FXML
    public void showVehicles() {
        mainController.loadNewView(VEHICLES);
    }
    @FXML
    public void editVehicle() {
        mainController.loadNewView(EDIT_VEHICLE);
    }
    @FXML
    public void openAbout( ) {
        mainController.loadNewView(OPEN_ABOUT);
    }
    @FXML
    public void openCalculator( ) {
        mainController.loadNewView(OPEN_CALCULATOR);
    }
    @FXML
    public void openConverter( ) {
        mainController.loadNewView(OPEN_CONVERTER);
    }
    @FXML
    public void openUsers() {
        mainController.loadNewView(OPEN_USERS);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
