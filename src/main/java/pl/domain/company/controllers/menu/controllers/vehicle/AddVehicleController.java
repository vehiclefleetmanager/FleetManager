package pl.domain.company.controllers.menu.controllers.vehicle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.domain.company.database.modelFx.vehicles.VehicleModel;
import pl.domain.company.database.modelFx.vehicles.mark.MarkFx;
import pl.domain.company.database.modelFx.vehicles.mark.MarkModel;
import pl.domain.company.database.modelFx.vehicles.model.ModelFx;
import pl.domain.company.database.modelFx.vehicles.model.ModelModel;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;
import pl.domain.company.database.utils.validations.Validation;

import java.io.IOException;

public class AddVehicleController {
    private static final String ADD_MARK = "/fxml/fleetmanager/menu/vehicle/AddMark.fxml";
    private static final String ADD_MODEL = "/fxml/fleetmanager/menu/vehicle/AddModel.fxml";
    private static final String MARK_TITLE = "Dodawanie marki pojazdu";
    private static final String MODEL_TITLE = "Dodawanie modelu pojazdu";
    private static final String WEIGHT_INFO = "Podaj poprawne wrtości";
    private static final String BUS_WEIGHT_WARNING = "Czy to poprawne wartości dla " +
            "samochodu dostawczego?";
    private static final String warningBorderColor = "-fx-border-color: red;";
    private static final String normalBorderColor = "-fx-border-color: transparent;";

    /**
     * buttons
     */
    @FXML
    private Button addMarkButton;
    @FXML
    private Button addModelButton;
    @FXML
    private Button counterWeightButton;
    @FXML
    private Button saveVehicle;
    @FXML
    private Button cancel;

    /**
     * checkboxes
     */
    @FXML
    private CheckBox basicBattery;
    @FXML
    private CheckBox additionalBattery;
    @FXML
    private CheckBox summerTire;
    @FXML
    private CheckBox winterTire;
    @FXML
    private CheckBox allYearTire;

    /**
     * combo boxes
     */
    @FXML
    private ComboBox<String> typeVehicle;
    @FXML
    private ComboBox<MarkFx> markComboBox;
    @FXML
    private ComboBox<ModelFx> modelComboBox;

    /**
     * data pickers
     */
    @FXML
    private DatePicker firstRegisterDataPicker;
    @FXML
    private DatePicker registrationDataPicker;
    @FXML
    private DatePicker liabilityDataPicker;
    @FXML
    private DatePicker lastServiceDataPicker;

    /**
     * h box
     */
    @FXML
    private HBox wheelsContainer;
    @FXML
    private HBox groupTankContainer;

    /**
     * text fields
     */
    @FXML
    private TextField basicBatteryValue;
    @FXML
    private TextField productionYear;
    @FXML
    private TextField additionalBatteryValue;
    @FXML
    private TextField summaryTireSize;
    @FXML
    private TextField winterTireSize;
    @FXML
    private TextField allYearTireSize;
    @FXML
    private TextField vehicleWeightSize;
    @FXML
    private TextField maxWeightSize;
    @FXML
    private TextField loadWeightSize;
    @FXML
    private TextField vinTextField;
    @FXML
    private TextField capacityTextField;
    @FXML
    private TextField powerTextField;
    @FXML
    private TextField registerNumberTextField;
    @FXML
    private TextField seriesProofTextField;
    @FXML
    private TextField vehicleCardTextField;
    @FXML
    private TextField counterStateTextField;

    /**
     * radio buttons
     */
    @FXML
    private RadioButton onRadioButton;
    @FXML
    private RadioButton pbRadioButton;
    @FXML
    private RadioButton fourWheelsRadioButton;
    @FXML
    private RadioButton sixWheelsRadioButton;
    @FXML
    private RadioButton tenWheelsRadioButton;

    /**
     * toggle groups
     */
    @FXML
    private ToggleGroup wheelsSize;
    @FXML
    private ToggleGroup groupTank;

    private VehicleModel vehicleModel;
    private ModelModel modelModel;
    private MarkModel markModel;

    @FXML
    public void initialize() {
        modelModel = new ModelModel();
        markModel = new MarkModel();
        this.vehicleModel = new VehicleModel();
        try {
            vehicleModel.init();
            modelModel.init();
            markModel.init();
        } catch (ApplicationExceptions ae) {
            ae.printStackTrace();
        }
        this.modelComboBox.setItems(this.vehicleModel.getModelFxObservableList());
        this.modelComboBox.setItems(this.modelModel.getModelList());
        this.markComboBox.setItems(this.vehicleModel.getMarkFxObservableList());
        this.markComboBox.setItems(this.markModel.getMarkList());
        addListsValue();
        disabledField();
        bindingsVehicle();
    }

    private void bindingsVehicle() {
        /** metoda ma za zadanie odebrać dane z formularza dodawania pojazdu
         * jeżeli jakieś pole uzupełnimy na formularzu, a nie uwzględnimy tego danego pola
         * w tej metodzie, poleci NullPointerException*/
        this.modelComboBox.valueProperty().bindBidirectional(
                this.vehicleModel.getVehicleFxObjectProperty().vehicleModelProperty());
        this.markComboBox.valueProperty().bindBidirectional(
                this.vehicleModel.getVehicleFxObjectProperty().vehicleMarkProperty());
        this.typeVehicle.valueProperty().bindBidirectional(
                this.vehicleModel.getVehicleFxObjectProperty().vehicleTypeProperty());
        this.registerNumberTextField.textProperty().bindBidirectional(
                this.vehicleModel.getVehicleFxObjectProperty().registerNumberProperty());
        this.registrationDataPicker.valueProperty().bindBidirectional(
                this.vehicleModel.getVehicleFxObjectProperty().vehicleReviewDateProperty());
        this.liabilityDataPicker.valueProperty().bindBidirectional(
                this.vehicleModel.getVehicleFxObjectProperty().insuranceDateProperty());
        this.firstRegisterDataPicker.valueProperty().bindBidirectional(
                this.vehicleModel.getVehicleFxObjectProperty().firstRegDateProperty());
        this.lastServiceDataPicker.valueProperty().bindBidirectional(
                this.vehicleModel.getVehicleFxObjectProperty().serviceDateProperty());
    }

    public void addMark() {
        showWindow(ADD_MARK, MARK_TITLE);
    }

    public void addModel() {
        showWindow(ADD_MODEL, MODEL_TITLE);
    }


    public void saveVehicleInDatabase() {
        if (isCheckFieldsBeforeSave()) {
            try {
                this.vehicleModel.saveVehicleInDataBase();
                closeWindow(saveVehicle);
                Validation.showInformation("Dodano pojazd do bazy");
            } catch (ApplicationExceptions ae) {
                ae.getMessage();
            }
        } else {
            Validation.showInformation("Pola nie mogą być puste");
        }
    }

    private boolean isCheckFieldsBeforeSave() {
        if (markComboBox.itemsProperty().isNotNull().isValid()
                || modelComboBox.itemsProperty().isNotNull().isValid()
                || vinTextField.textProperty().getValue().isEmpty()
                || capacityTextField.textProperty().getValue().isEmpty()
                || powerTextField.textProperty().getValue().isEmpty()
                || productionYear.textProperty().getValue().isEmpty()
                || groupTank.selectedToggleProperty().isNull().getValue()
                || registerNumberTextField.textProperty().getValue().isEmpty()
                || typeVehicle.itemsProperty().isNotNull().isValid()
                || registrationDataPicker.valueProperty().isNotNull().isValid()
                || liabilityDataPicker.valueProperty().isNotNull().isValid()
                || lastServiceDataPicker.valueProperty().isNotNull().isValid()) {
            markComboBox.setStyle(warningBorderColor);
            modelComboBox.setStyle(warningBorderColor);
            vinTextField.setStyle(warningBorderColor);
            capacityTextField.setStyle(warningBorderColor);
            powerTextField.setStyle(warningBorderColor);
            productionYear.setStyle(warningBorderColor);
            groupTankContainer.setStyle(warningBorderColor);
            typeVehicle.setStyle(warningBorderColor);
            registerNumberTextField.setStyle(warningBorderColor);
            registrationDataPicker.setStyle(warningBorderColor);
            liabilityDataPicker.setStyle(warningBorderColor);
            lastServiceDataPicker.setStyle(warningBorderColor);
        } else {
            markComboBox.setStyle(normalBorderColor);
            modelComboBox.setStyle(normalBorderColor);
            vinTextField.setStyle(normalBorderColor);
            capacityTextField.setStyle(normalBorderColor);
            powerTextField.setStyle(normalBorderColor);
            productionYear.setStyle(normalBorderColor);
            groupTankContainer.setStyle(normalBorderColor);
            typeVehicle.setStyle(normalBorderColor);
            registerNumberTextField.setStyle(normalBorderColor);
            registrationDataPicker.setStyle(normalBorderColor);
            liabilityDataPicker.setStyle(normalBorderColor);
            lastServiceDataPicker.setStyle(normalBorderColor);
            return true;
        }
        return false;
    }

    public void counterWeight() {
        Integer vWeight = Integer.parseInt(this.vehicleWeightSize.getText());
        Integer mWeight = Integer.parseInt(this.maxWeightSize.getText());
        Integer lWeight = mWeight - vWeight;
        validationWeightVehicle(vWeight, mWeight, lWeight);

    }

    public void cancel() {
        closeWindow(cancel);
    }

    private void showWindow(String path, String title) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setAlwaysOnTop(false);
        stage.setResizable(false);
        stage.showAndWait();
    }

    private void validationWeightVehicle(Integer vWeight, Integer mWeight, Integer lWeight) {
        if (mWeight < vWeight) {
            this.maxWeightSize.setStyle(warningBorderColor);
            this.vehicleWeightSize.setStyle(warningBorderColor);
            validationWeightValue(WEIGHT_INFO);
        } else if (this.typeVehicle.valueProperty().get().equals("Dostawczy") && ((mWeight > 3500) || (vWeight > 3500))) {
            this.maxWeightSize.setStyle(warningBorderColor);
            this.vehicleWeightSize.setStyle(warningBorderColor);
            validationWeightValue(BUS_WEIGHT_WARNING);
        } else {
            this.maxWeightSize.setStyle(normalBorderColor);
            this.vehicleWeightSize.setStyle(normalBorderColor);
            this.loadWeightSize.setText(String.valueOf(lWeight));
        }
    }

    private void validationWeightValue(String info) {
        Validation.showInformation(info);
    }

    private void addListsValue() {

        ObservableList<String> typeList = FXCollections.observableArrayList(
                "Osobowy", "Dostawczy", "Ciężarowy", "Specjalny", "Maszyna", "Inne");
        this.typeVehicle.setItems(typeList);
    }

    private void disabledField() {
        this.summaryTireSize.disableProperty().bind(this.summerTire.selectedProperty().not());
        this.winterTireSize.disableProperty().bind(this.winterTire.selectedProperty().not());
        this.allYearTireSize.disableProperty().bind(this.allYearTire.selectedProperty().not());
        this.basicBatteryValue.disableProperty().bind(this.basicBattery.selectedProperty().not());
        this.additionalBatteryValue.disableProperty().bind(this.additionalBattery.selectedProperty().not());
        this.wheelsContainer.disableProperty().bind(this.typeVehicle.valueProperty().isEqualTo("Osobowy")
                .or(this.typeVehicle.valueProperty().isNull()));
        this.additionalBattery.disableProperty().bind(this.typeVehicle.valueProperty().isEqualTo("Osobowy")
                .or(this.typeVehicle.valueProperty().isNull()));
        this.vehicleWeightSize.disableProperty().bind(this.typeVehicle.valueProperty().isEqualTo("Osobowy")
                .or(this.typeVehicle.valueProperty().isNull()));
        this.maxWeightSize.disableProperty().bind(this.vehicleWeightSize.disableProperty());
        this.counterWeightButton.disableProperty().bind(this.typeVehicle.valueProperty().isEqualTo("Osobowy")
                .or(this.typeVehicle.valueProperty().isNull())
                .or(this.vehicleWeightSize.textProperty().isEmpty())
                .or(this.maxWeightSize.textProperty().isEmpty()));
        this.loadWeightSize.disableProperty();
    }

    private void closeWindow(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }


    public void onLoadNewMarks() {
        try {
            this.markModel.init();
        } catch (ApplicationExceptions applicationExceptions) {
            applicationExceptions.printStackTrace();
        }
    }

    public void onLoadNewModels() {
        try {
            this.modelModel.init();
        } catch (ApplicationExceptions applicationExceptions) {
            applicationExceptions.printStackTrace();
        }
    }
}
