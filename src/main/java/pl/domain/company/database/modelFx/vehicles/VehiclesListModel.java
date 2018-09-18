package pl.domain.company.database.modelFx.vehicles;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.domain.company.database.dao.MarkDao;
import pl.domain.company.database.dao.ModelDao;
import pl.domain.company.database.dao.VehicleDao;
import pl.domain.company.database.modelFx.vehicles.mark.MarkFx;
import pl.domain.company.database.modelFx.vehicles.model.ModelFx;
import pl.domain.company.database.models.Mark;
import pl.domain.company.database.models.Model;
import pl.domain.company.database.models.Vehicle;
import pl.domain.company.database.utils.converters.ConvertMark;
import pl.domain.company.database.utils.converters.ConvertModel;
import pl.domain.company.database.utils.converters.ConvertVehicle;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.util.ArrayList;
import java.util.List;

public class VehiclesListModel {
    private ObservableList<VehicleFx> vehicleFxObservableList
            = FXCollections.observableArrayList();
    private ObservableList<MarkFx> markFxObservableList
            = FXCollections.observableArrayList();
    private ObservableList<ModelFx> modelFxObservableList
            = FXCollections.observableArrayList();

    private ObjectProperty<MarkFx> markFxObjectProperty
            = new SimpleObjectProperty<>();
    private ObjectProperty<ModelFx> modelFxObjectProperty
            = new SimpleObjectProperty<>();


    private List<VehicleFx> vehicleFxList = new ArrayList<>();



    public void init() throws ApplicationExceptions {
        VehicleDao vehicleDao = new VehicleDao();
        List<Vehicle> vehicles = vehicleDao.queryForAll(Vehicle.class);
        vehicleFxList.clear();
        vehicles.forEach(vehicle -> {
            this.vehicleFxList.add(ConvertVehicle.convertToVehicleFx(vehicle));
        });
        this.vehicleFxObservableList.setAll(vehicleFxList);
        initMarks();
        initModels();
    }

    private void initModels() throws ApplicationExceptions {
        ModelDao modelDao = new ModelDao();
        List<Model> modelList = modelDao.queryForAll(Model.class);
        this.modelFxObservableList.clear();
        modelList.forEach(model -> {
            ModelFx modelFx = ConvertModel.convertToModelFx(model);
            this.modelFxObservableList.add(modelFx);
        });
    }

    private void initMarks() throws ApplicationExceptions {
        MarkDao markDao = new MarkDao();
        List<Mark> markList = markDao.queryForAll(Mark.class);
        this.markFxObservableList.clear();
        markList.forEach(mark ->{
            MarkFx markFx = ConvertMark.convertToMarkFx(mark);
            this.markFxObservableList.add(markFx);
        });
    }

    public ObservableList<VehicleFx> getVehicleFxObservableList() {
        return vehicleFxObservableList;
    }

    public void setVehicleFxObservableList(ObservableList<VehicleFx> vehicleFxObservableList) {
        this.vehicleFxObservableList = vehicleFxObservableList;
    }

    public ObservableList<MarkFx> getMarkFxObservableList() {
        return markFxObservableList;
    }

    public void setMarkFxObservableList(ObservableList<MarkFx> markFxObservableList) {
        this.markFxObservableList = markFxObservableList;
    }

    public ObservableList<ModelFx> getModelFxObservableList() {
        return modelFxObservableList;
    }

    public void setModelFxObservableList(ObservableList<ModelFx> modelFxObservableList) {
        this.modelFxObservableList = modelFxObservableList;
    }

    public MarkFx getMarkFxObjectProperty() {
        return markFxObjectProperty.get();
    }

    public ObjectProperty<MarkFx> markFxObjectPropertyProperty() {
        return markFxObjectProperty;
    }

    public void setMarkFxObjectProperty(MarkFx markFxObjectProperty) {
        this.markFxObjectProperty.set(markFxObjectProperty);
    }

    public ModelFx getModelFxObjectProperty() {
        return modelFxObjectProperty.get();
    }

    public ObjectProperty<ModelFx> modelFxObjectPropertyProperty() {
        return modelFxObjectProperty;
    }

    public void setModelFxObjectProperty(ModelFx modelFxObjectProperty) {
        this.modelFxObjectProperty.set(modelFxObjectProperty);
    }

    public List<VehicleFx> getVehicleFxList() {
        return vehicleFxList;
    }

    public void setVehicleFxList(List<VehicleFx> vehicleFxList) {
        this.vehicleFxList = vehicleFxList;
    }

}