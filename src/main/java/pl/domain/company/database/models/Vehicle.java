package pl.domain.company.database.models;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "VEHICLES")
public class Vehicle implements BaseModel{
    private static final String MARK_ID = "MARK_ID";
    private static final String MODEL_ID = "MODEL_ID";
    public Vehicle() {
    }
    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField(columnName = "Reg_Number")
    private String registerNumber;
    @DatabaseField(columnName = MARK_ID, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Mark vehicleMark;
    @DatabaseField(columnName = MODEL_ID,foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Model vehicleModel;
    @DatabaseField(columnName = "VIN")
    private String vehicleVin;
    @DatabaseField(columnName = "Engine capacity")
    private int engineCapacity;
    @DatabaseField(columnName = "Engine power")
    private int enginePower;
    @DatabaseField(columnName = "Production year")
    private int productionYear;
    @DatabaseField(columnName = "Fuel type")
    private String fuelType;
    @DatabaseField(columnName = "Vehicle type")
    private String vehicleType;
    @DatabaseField(columnName = "Size of summer tires")
    private String summerTires;
    @DatabaseField(columnName = "Size of winter tires")
    private String winterTires;
    @DatabaseField(columnName = "Size of all-season tires")
    private String allSeasonTires;
    @DatabaseField(columnName = "Number of wheels")
    private int numberOfWheels;
    @DatabaseField(columnName = "Date of first registration")
    private Date firstRegDate;
    @DatabaseField(columnName = "S/N registration certificate")
    private String snRegCertificate;
    @DatabaseField(columnName = "Vehicle card number")
    private String vehicleCardNumber;
    @DatabaseField(columnName = "Date of registration review")
    private Date vehicleReviewDate;
    @DatabaseField(columnName = "Insurance expiration date")
    private Date insuranceDate;
    @DatabaseField(columnName = "Date of technical service")
    private Date serviceDate;
    @DatabaseField(columnName = "Meter status")
    private int vehicleMeterStatus;
    @DatabaseField(columnName = "Battery capacity")
    private int baseBatteryCapacity;
    @DatabaseField(columnName = "Additional battery capacity")
    private int additionalBatteryCapacity;
    @DatabaseField(columnName = "Vehicle weight")
    private int vehicleWeight;
    @DatabaseField(columnName = "Vehicle total weight")
    private int totalWeight;

    @DatabaseField(columnName = "Weight of the load")
    private int loadWeight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Mark getVehicleMark() {
        return vehicleMark;
    }

    public void setVehicleMark(Mark vehicleMark) {
        this.vehicleMark = vehicleMark;
    }

    public Model getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(Model vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleVin() {
        return vehicleVin;
    }

    public void setVehicleVin(String vehicleVin) {
        this.vehicleVin = vehicleVin;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSummerTires() {
        return summerTires;
    }

    public void setSummerTires(String summerTires) {
        this.summerTires = summerTires;
    }

    public String getWinterTires() {
        return winterTires;
    }

    public void setWinterTires(String winterTires) {
        this.winterTires = winterTires;
    }

    public String getAllSeasonTires() {
        return allSeasonTires;
    }

    public void setAllSeasonTires(String allSeasonTires) {
        this.allSeasonTires = allSeasonTires;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public Date getFirstRegDate() {
        return firstRegDate;
    }

    public void setFirstRegDate(Date firstRegDate) {
        this.firstRegDate = firstRegDate;
    }

    public String getSnRegCertificate() {
        return snRegCertificate;
    }

    public void setSnRegCertificate(String snRegCertificate) {
        this.snRegCertificate = snRegCertificate;
    }

    public String getVehicleCardNumber() {
        return vehicleCardNumber;
    }

    public void setVehicleCardNumber(String vehicleCardNumber) {
        this.vehicleCardNumber = vehicleCardNumber;
    }

    public Date getVehicleReviewDate() {
        return vehicleReviewDate;
    }

    public void setVehicleReviewDate(Date vehicleReviewDate) {
        this.vehicleReviewDate = vehicleReviewDate;
    }

    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public int getVehicleMeterStatus() {
        return vehicleMeterStatus;
    }

    public void setVehicleMeterStatus(int vehicleMeterStatus) {
        this.vehicleMeterStatus = vehicleMeterStatus;
    }

    public int getBaseBatteryCapacity() {
        return baseBatteryCapacity;
    }

    public void setBaseBatteryCapacity(int baseBatteryCapacity) {
        this.baseBatteryCapacity = baseBatteryCapacity;
    }

    public int getAdditionalBatteryCapacity() {
        return additionalBatteryCapacity;
    }

    public void setAdditionalBatteryCapacity(int additionalBatteryCapacity) {
        this.additionalBatteryCapacity = additionalBatteryCapacity;
    }

    public int getVehicleWeight() {
        return vehicleWeight;
    }

    public void setVehicleWeight(int vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(int loadWeight) {
        this.loadWeight = loadWeight;
    }
}
