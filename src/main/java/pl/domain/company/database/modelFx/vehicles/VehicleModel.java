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

import java.util.List;

public class VehicleModel {
    private ObjectProperty<VehicleFx> vehicleFxObjectProperty
            = new SimpleObjectProperty<>(new VehicleFx());
    private ObservableList<ModelFx> modelFxObservableList
            = FXCollections.observableArrayList();
    private ObservableList<MarkFx> markFxObservableList
            = FXCollections.observableArrayList();

    public void init() throws ApplicationExceptions {
        initModelList();
        initMarkList();
    }


    private void initModelList() throws ApplicationExceptions {
        ModelDao modelDao = new ModelDao();
        List<Model> modelList = modelDao.queryForAll(Model.class);
        this.modelFxObservableList.clear();
        modelList.forEach(model -> {
            ModelFx modelFx = ConvertModel.convertToModelFx(model);
            this.modelFxObservableList.add(modelFx);
        });
    }

    private void initMarkList() throws ApplicationExceptions {
        MarkDao markDao = new MarkDao();
        List<Mark> markList = markDao.queryForAll(Mark.class);
        this.markFxObservableList.clear();
        markList.forEach(mark -> {
            MarkFx markFx = ConvertMark.convertToMarkFx(mark);
            this.markFxObservableList.add(markFx);
        });
    }

    public void saveVehicleInDataBase() throws ApplicationExceptions {
        Vehicle vehicle = ConvertVehicle.convertToVehicle(this.getVehicleFxObjectProperty());

        MarkDao markDao = new MarkDao();
        Mark mark = markDao.findById(Mark.class, this.getVehicleFxObjectProperty().getVehicleMark().getId());

        ModelDao modelDao = new ModelDao();
        Model model = modelDao.findById(Model.class, this.getVehicleFxObjectProperty().getVehicleModel().getId());

        vehicle.setVehicleMark(mark);
        vehicle.setVehicleModel(model);

        VehicleDao vehicleDao = new VehicleDao();
        vehicleDao.createOrUpdate(vehicle);
    }

    public VehicleFx getVehicleFxObjectProperty() {
        return vehicleFxObjectProperty.get();
    }

    public void setVehicleFxObjectProperty(VehicleFx vehicleFxObjectProperty) {
        this.vehicleFxObjectProperty.set(vehicleFxObjectProperty);
    }

    public ObjectProperty<VehicleFx> vehicleFxObjectPropertyProperty() {
        return vehicleFxObjectProperty;
    }

    public ObservableList<ModelFx> getModelFxObservableList() {
        return modelFxObservableList;
    }

    public void setModelFxObservableList(ObservableList<ModelFx> modelFxObservableList) {
        this.modelFxObservableList = modelFxObservableList;
    }

    public ObservableList<MarkFx> getMarkFxObservableList() {
        return markFxObservableList;
    }

    public void setMarkFxObservableList(ObservableList<MarkFx> markFxObservableList) {
        this.markFxObservableList = markFxObservableList;
    }
}
