package pl.domain.company.database.modelFx.vehicles;
import javafx.beans.property.*;
import pl.domain.company.database.modelFx.vehicles.mark.MarkFx;
import pl.domain.company.database.modelFx.vehicles.model.ModelFx;

import java.time.LocalDate;
public class VehicleFx {
    private LongProperty id = new SimpleLongProperty();
    private StringProperty registerNumber = new SimpleStringProperty();
    private ObjectProperty<MarkFx> vehicleMark = new SimpleObjectProperty<>();
    private ObjectProperty<ModelFx> vehicleModel = new SimpleObjectProperty<>();
    private StringProperty vehicleVin = new SimpleStringProperty();
    private IntegerProperty engineCapacity = new SimpleIntegerProperty();
    private IntegerProperty enginePower = new SimpleIntegerProperty();
    private IntegerProperty productionYear = new SimpleIntegerProperty();
    private StringProperty fuelType = new SimpleStringProperty();
    private StringProperty vehicleType = new SimpleStringProperty();
    private StringProperty summerTires = new SimpleStringProperty();
    private StringProperty winterTires = new SimpleStringProperty();
    private StringProperty allSeasonTires = new SimpleStringProperty();
    private IntegerProperty numberOfWheels = new SimpleIntegerProperty();
    private ObjectProperty<LocalDate> firstRegDate = new SimpleObjectProperty<>();
    private StringProperty snRegCertificate = new SimpleStringProperty();
    private StringProperty vehicleCardNumber = new SimpleStringProperty();
    private ObjectProperty<LocalDate> vehicleReviewDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> insuranceDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> serviceDate = new SimpleObjectProperty<>();
    private IntegerProperty vehicleMeterStatus = new SimpleIntegerProperty();
    private IntegerProperty baseBatteryCapacity = new SimpleIntegerProperty();
    private IntegerProperty additionalBatteryCapacity = new SimpleIntegerProperty();
    private IntegerProperty vehicleWeight = new SimpleIntegerProperty();
    private IntegerProperty totalWeight = new SimpleIntegerProperty();
    private IntegerProperty loadWeight = new SimpleIntegerProperty();


    public long getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getRegisterNumber() {
        return registerNumber.get();
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber.set(registerNumber);
    }

    public StringProperty registerNumberProperty() {
        return registerNumber;
    }

    public MarkFx getVehicleMark() {
        return vehicleMark.get();
    }

    public ObjectProperty<MarkFx> vehicleMarkProperty() {
        return vehicleMark;
    }

    public void setVehicleMark(MarkFx vehicleMark) {
        this.vehicleMark.set(vehicleMark);
    }

    public ModelFx getVehicleModel() {
        return vehicleModel.get();
    }

    public ObjectProperty<ModelFx> vehicleModelProperty() {
        return vehicleModel;
    }

    public void setVehicleModel(ModelFx vehicleModel) {
        this.vehicleModel.set(vehicleModel);
    }

    public String getVehicleVin() {
        return vehicleVin.get();
    }

    public void setVehicleVin(String vehicleVin) {
        this.vehicleVin.set(vehicleVin);
    }

    public StringProperty vehicleVinProperty() {
        return vehicleVin;
    }

    public int getEngineCapacity() {
        return engineCapacity.get();
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity.set(engineCapacity);
    }

    public IntegerProperty engineCapacityProperty() {
        return engineCapacity;
    }

    public int getEnginePower() {
        return enginePower.get();
    }

    public void setEnginePower(int enginePower) {
        this.enginePower.set(enginePower);
    }

    public IntegerProperty enginePowerProperty() {
        return enginePower;
    }

    public int getProductionYear() {
        return productionYear.get();
    }

    public void setProductionYear(int productionYear) {
        this.productionYear.set(productionYear);
    }

    public IntegerProperty productionYearProperty() {
        return productionYear;
    }

    public String getFuelType() {
        return fuelType.get();
    }

    public void setFuelType(String fuelType) {
        this.fuelType.set(fuelType);
    }

    public StringProperty fuelTypeProperty() {
        return fuelType;
    }

    public String getVehicleType() {
        return vehicleType.get();
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType.set(vehicleType);
    }

    public StringProperty vehicleTypeProperty() {
        return vehicleType;
    }

    public String getSummerTires() {
        return summerTires.get();
    }

    public void setSummerTires(String summerTires) {
        this.summerTires.set(summerTires);
    }

    public StringProperty summerTiresProperty() {
        return summerTires;
    }

    public String getWinterTires() {
        return winterTires.get();
    }

    public void setWinterTires(String winterTires) {
        this.winterTires.set(winterTires);
    }

    public StringProperty winterTiresProperty() {
        return winterTires;
    }

    public String getAllSeasonTires() {
        return allSeasonTires.get();
    }

    public void setAllSeasonTires(String allSeasonTires) {
        this.allSeasonTires.set(allSeasonTires);
    }

    public StringProperty allSeasonTiresProperty() {
        return allSeasonTires;
    }

    public int getNumberOfWheels() {
        return numberOfWheels.get();
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels.set(numberOfWheels);
    }

    public IntegerProperty numberOfWheelsProperty() {
        return numberOfWheels;
    }

    public LocalDate getFirstRegDate() {
        return firstRegDate.get();
    }

    public void setFirstRegDate(LocalDate firstRegDate) {
        this.firstRegDate.set(firstRegDate);
    }

    public ObjectProperty<LocalDate> firstRegDateProperty() {
        return firstRegDate;
    }

    public String getSnRegCertificate() {
        return snRegCertificate.get();
    }

    public void setSnRegCertificate(String snRegCertificate) {
        this.snRegCertificate.set(snRegCertificate);
    }

    public StringProperty snRegCertificateProperty() {
        return snRegCertificate;
    }

    public String getVehicleCardNumber() {
        return vehicleCardNumber.get();
    }

    public void setVehicleCardNumber(String vehicleCardNumber) {
        this.vehicleCardNumber.set(vehicleCardNumber);
    }

    public StringProperty vehicleCardNumberProperty() {
        return vehicleCardNumber;
    }

    public LocalDate getVehicleReviewDate() {
        return vehicleReviewDate.get();
    }

    public void setVehicleReviewDate(LocalDate vehicleReviewDate) {
        this.vehicleReviewDate.set(vehicleReviewDate);
    }

    public ObjectProperty<LocalDate> vehicleReviewDateProperty() {
        return vehicleReviewDate;
    }

    public LocalDate getInsuranceDate() {
        return insuranceDate.get();
    }

    public void setInsuranceDate(LocalDate insuranceDate) {
        this.insuranceDate.set(insuranceDate);
    }

    public ObjectProperty<LocalDate> insuranceDateProperty() {
        return insuranceDate;
    }

    public LocalDate getServiceDate() {
        return serviceDate.get();
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate.set(serviceDate);
    }

    public ObjectProperty<LocalDate> serviceDateProperty() {
        return serviceDate;
    }

    public int getVehicleMeterStatus() {
        return vehicleMeterStatus.get();
    }

    public void setVehicleMeterStatus(int vehicleMeterStatus) {
        this.vehicleMeterStatus.set(vehicleMeterStatus);
    }

    public IntegerProperty vehicleMeterStatusProperty() {
        return vehicleMeterStatus;
    }

    public int getBaseBatteryCapacity() {
        return baseBatteryCapacity.get();
    }

    public void setBaseBatteryCapacity(int baseBatteryCapacity) {
        this.baseBatteryCapacity.set(baseBatteryCapacity);
    }

    public IntegerProperty baseBatteryCapacityProperty() {
        return baseBatteryCapacity;
    }

    public int getAdditionalBatteryCapacity() {
        return additionalBatteryCapacity.get();
    }

    public void setAdditionalBatteryCapacity(int additionalBatteryCapacity) {
        this.additionalBatteryCapacity.set(additionalBatteryCapacity);
    }

    public IntegerProperty additionalBatteryCapacityProperty() {
        return additionalBatteryCapacity;
    }

    public int getVehicleWeight() {
        return vehicleWeight.get();
    }

    public void setVehicleWeight(int vehicleWeight) {
        this.vehicleWeight.set(vehicleWeight);
    }

    public IntegerProperty vehicleWeightProperty() {
        return vehicleWeight;
    }

    public int getTotalWeight() {
        return totalWeight.get();
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight.set(totalWeight);
    }

    public IntegerProperty totalWeightProperty() {
        return totalWeight;
    }

    public int getLoadWeight() {
        return loadWeight.get();
    }

    public void setLoadWeight(int loadWeight) {
        this.loadWeight.set(loadWeight);
    }

    public IntegerProperty loadWeightProperty() {
        return loadWeight;
    }

    @Override
    public String toString() {
        return "VehicleFx{" +
                "id=" + id +
                ", registerNumber=" + registerNumber +
                ", vehicleMark=" + vehicleMark +
                ", vehicleModel=" + vehicleModel +
                ", vehicleVin=" + vehicleVin +
                ", engineCapacity=" + engineCapacity +
                ", enginePower=" + enginePower +
                ", productionYear=" + productionYear +
                ", fuelType=" + fuelType +
                ", vehicleType=" + vehicleType +
                ", summerTires=" + summerTires +
                ", winterTires=" + winterTires +
                ", allSeasonTires=" + allSeasonTires +
                ", numberOfWheels=" + numberOfWheels +
                ", firstRegDate=" + firstRegDate +
                ", snRegCertificate=" + snRegCertificate +
                ", vehicleCardNumber=" + vehicleCardNumber +
                ", vehicleReviewDate=" + vehicleReviewDate +
                ", insuranceDate=" + insuranceDate +
                ", serviceDate=" + serviceDate +
                ", vehicleMeterStatus=" + vehicleMeterStatus +
                ", baseBatteryCapacity=" + baseBatteryCapacity +
                ", additionalBatteryCapacity=" + additionalBatteryCapacity +
                ", vehicleWeight=" + vehicleWeight +
                ", totalWeight=" + totalWeight +
                ", loadWeight=" + loadWeight +
                '}';
    }
}
