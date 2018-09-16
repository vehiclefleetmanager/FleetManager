package pl.domain.company.database.modelFx.vehicles.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.domain.company.database.dao.ModelDao;
import pl.domain.company.database.models.Model;
import pl.domain.company.database.utils.converters.ConvertModel;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.util.ArrayList;
import java.util.List;
public class ModelListModel {
    private ObservableList<ModelFx> modelFXObservableList =
            FXCollections.observableArrayList();
    private List<ModelFx> modelFXList = new ArrayList<>();

    public void init() throws ApplicationExceptions {
        ModelDao modelDao = new ModelDao();
        List<Model> modelVehicleList = modelDao.queryForAll(Model.class);
        modelVehicleList.clear();
        modelVehicleList.forEach( modelVehicle -> {
            this.modelFXList.add(ConvertModel.convertToModelFx(modelVehicle));
        });
        this.modelFXObservableList.setAll(modelFXList);
    }

    public ObservableList<ModelFx> getModelFXObservableList() {
        return modelFXObservableList;
    }
}
