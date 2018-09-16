package pl.domain.company.database.utils.converters;

import pl.domain.company.database.modelFx.vehicles.model.ModelFx;
import pl.domain.company.database.models.Model;

public class ConvertModel {
    public static Model convertToModel(ModelFx modelFX){
        Model modelVehicle = new Model();
        modelVehicle.setId(modelFX.getId());
        modelVehicle.setModelName(modelFX.getModelName());
        return modelVehicle;
    }

    public static ModelFx convertToModelFx(Model modelVehicle){
        ModelFx modelFX = new ModelFx();
        modelFX.setId(modelVehicle.getId());
        modelFX.setModelName(modelVehicle.getModelName());
        return modelFX;
    }
}
