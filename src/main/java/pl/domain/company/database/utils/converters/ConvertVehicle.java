package pl.domain.company.database.utils.converters;

import pl.domain.company.database.modelFx.vehicles.VehicleFx;
import pl.domain.company.database.models.Vehicle;

public class ConvertVehicle {
    public static Vehicle convertToVehicle(VehicleFx vehicleFx){
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleFx.getId());
        vehicle.setAdditionalBatteryCapacity(vehicleFx.getAdditionalBatteryCapacity());
        vehicle.setAllSeasonTires(vehicleFx.getAllSeasonTires());
        vehicle.setBaseBatteryCapacity(vehicleFx.getBaseBatteryCapacity());
        vehicle.setEngineCapacity(vehicleFx.getEngineCapacity());
        vehicle.setEnginePower(vehicleFx.getEnginePower());
        vehicle.setFirstRegDate(DateConverter.convertToDate(vehicleFx.getFirstRegDate()));
        vehicle.setFuelType(vehicleFx.getFuelType());
        vehicle.setInsuranceDate(DateConverter.convertToDate(vehicleFx.getInsuranceDate()));
        vehicle.setLoadWeight(vehicleFx.getLoadWeight());
        vehicle.setNumberOfWheels(vehicleFx.getNumberOfWheels());
        vehicle.setProductionYear(vehicleFx.getProductionYear());
        vehicle.setRegisterNumber(vehicleFx.getRegisterNumber());
        vehicle.setServiceDate(DateConverter.convertToDate(vehicleFx.getServiceDate()));
        vehicle.setSnRegCertificate(vehicleFx.getSnRegCertificate());
        vehicle.setSummerTires(vehicleFx.getSummerTires());
        vehicle.setTotalWeight(vehicleFx.getTotalWeight());
        vehicle.setVehicleCardNumber(vehicleFx.getVehicleCardNumber());
        vehicle.setVehicleMeterStatus(vehicleFx.getVehicleMeterStatus());
        vehicle.setVehicleReviewDate(DateConverter.convertToDate(vehicleFx.getVehicleReviewDate()));
        vehicle.setVehicleType(vehicleFx.getVehicleType());
        vehicle.setVehicleVin(vehicleFx.getVehicleVin());
        vehicle.setVehicleWeight(vehicleFx.getVehicleWeight());
        vehicle.setWinterTires(vehicleFx.getWinterTires());
        return vehicle;
    }
    public static VehicleFx convertToVehicleFx(Vehicle vehicle){
        VehicleFx vehicleFx = new VehicleFx();
        vehicleFx.setId(vehicle.getId());
        vehicleFx.setAdditionalBatteryCapacity(vehicle.getAdditionalBatteryCapacity());
        vehicleFx.setAllSeasonTires(vehicle.getAllSeasonTires());
        vehicleFx.setBaseBatteryCapacity(vehicle.getBaseBatteryCapacity());
        vehicleFx.setEngineCapacity(vehicle.getEngineCapacity());
        vehicleFx.setEnginePower(vehicle.getEnginePower());
        vehicleFx.setFirstRegDate(DateConverter.convertToLocalDate(vehicle.getFirstRegDate()));
        vehicleFx.setFuelType(vehicle.getFuelType());
        vehicleFx.setInsuranceDate(DateConverter.convertToLocalDate(vehicle.getInsuranceDate()));
        vehicleFx.setLoadWeight(vehicle.getLoadWeight());
        vehicleFx.setNumberOfWheels(vehicle.getNumberOfWheels());
        vehicleFx.setProductionYear(vehicle.getProductionYear());
        vehicleFx.setRegisterNumber(vehicle.getRegisterNumber());
        vehicleFx.setServiceDate(DateConverter.convertToLocalDate(vehicle.getServiceDate()));
        vehicleFx.setSnRegCertificate(vehicle.getSnRegCertificate());
        vehicleFx.setSummerTires(vehicle.getSummerTires());
        vehicleFx.setTotalWeight(vehicle.getTotalWeight());
        vehicleFx.setVehicleCardNumber(vehicle.getVehicleCardNumber());
        vehicleFx.setVehicleMark(ConvertMark.convertToMarkFx(vehicle.getVehicleMark()));
        vehicleFx.setVehicleMeterStatus(vehicle.getVehicleMeterStatus());
        vehicleFx.setVehicleModel(ConvertModel.convertToModelFx(vehicle.getVehicleModel()));
        vehicleFx.setVehicleReviewDate(DateConverter.convertToLocalDate(vehicle.getVehicleReviewDate()));
        vehicleFx.setVehicleType(vehicle.getVehicleType());
        vehicleFx.setVehicleVin(vehicle.getVehicleVin());
        vehicleFx.setVehicleWeight(vehicle.getVehicleWeight());
        vehicleFx.setWinterTires(vehicle.getWinterTires());
        return vehicleFx;
    }
}
