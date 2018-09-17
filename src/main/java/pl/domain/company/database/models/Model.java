package pl.domain.company.database.models;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "MODELS")
public class Model implements BaseModel{
    public Model(){}

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(columnName = "Model name", canBeNull = false)
    private String modelName;

    @ForeignCollectionField(columnName = "VEHICLE_ID")
    private ForeignCollection<Vehicle> vehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public ForeignCollection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ForeignCollection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
