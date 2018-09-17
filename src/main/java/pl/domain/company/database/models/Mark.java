package pl.domain.company.database.models;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "MARKS")
public class Mark implements BaseModel{
    public Mark(){}

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(columnName = "Mark name", canBeNull = false)
    private String markName;

    @ForeignCollectionField(columnName = "VEHICLE_ID")
    private ForeignCollection<Vehicle> vehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public ForeignCollection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ForeignCollection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
