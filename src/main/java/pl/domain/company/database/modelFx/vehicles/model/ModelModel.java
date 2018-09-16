package pl.domain.company.database.modelFx.vehicles.model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.domain.company.database.dao.ModelDao;
import pl.domain.company.database.models.Model;
import pl.domain.company.database.utils.converters.ConvertModel;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.util.List;

public class ModelModel {
    private ObjectProperty<ModelFx> model =
            new SimpleObjectProperty<>(new ModelFx());
    private ObservableList<ModelFx> modelList =
            FXCollections.observableArrayList();

    public void init() throws ApplicationExceptions {
        ModelDao modelDao = new ModelDao();
        List<Model> modelList = modelDao.queryForAll(Model.class);
        initModelList(modelList);
    }

    private void initModelList(List<Model> modelVehicles) {
        this.modelList.clear();
        modelVehicles.forEach(model -> {
            ModelFx modelFX = ConvertModel.convertToModelFx(model);
            this.modelList.add(modelFX);
        });
    }

    public void saveVehicleModelInDatabase(String name) throws ApplicationExceptions {
        ModelDao modelDao = new ModelDao();
        Model modelVehicle = new Model();
        modelVehicle.setModelName(name);
        modelDao.createOrUpdate(modelVehicle);
        init();

    }

    public ModelFx getModel() {
        return model.get();
    }

    public void setModel(ModelFx model) {
        this.model.set(model);
    }

    public ObjectProperty<ModelFx> modelProperty() {
        return model;
    }

    public ObservableList<ModelFx> getModelList() {
        return modelList;
    }

    public void setModelList(ObservableList<ModelFx> modelList) {
        this.modelList = modelList;
    }
}
