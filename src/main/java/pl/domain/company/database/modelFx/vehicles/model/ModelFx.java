package pl.domain.company.database.modelFx.vehicles.model;

import javafx.beans.property.*;
public class ModelFx {
    private LongProperty id = new SimpleLongProperty();
    private StringProperty modelName = new SimpleStringProperty();

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }



    public String getModelName() {
        return modelName.get();
    }

    public StringProperty modelNameProperty() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName.set(modelName);
    }

    @Override
    public String toString() {
        return modelName.get();
    }
}
