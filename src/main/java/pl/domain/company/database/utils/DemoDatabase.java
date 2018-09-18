package pl.domain.company.database.utils;

import pl.domain.company.database.connection.DbManager;
import pl.domain.company.database.dao.MarkDao;
import pl.domain.company.database.dao.ModelDao;
import pl.domain.company.database.dao.UserDao;
import pl.domain.company.database.dao.VehicleDao;
import pl.domain.company.database.models.Mark;
import pl.domain.company.database.models.Model;
import pl.domain.company.database.models.User;
import pl.domain.company.database.models.Vehicle;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.util.Date;

public class DemoDatabase {
    public static void fillDatabase() {
        /*-----------------------------------------------*/
        VehicleDao vehicleDao = new VehicleDao();
        UserDao userDao = new UserDao();
        MarkDao markDao = new MarkDao();
        ModelDao modelDao = new ModelDao();
        /*-----------------------------------------------*/

        Mark markVehicle = new Mark();
        markVehicle.setId(1L);
        markVehicle.setMarkName("Fiat");
        /*------------------------------------*/
        Model modelVehicle = new Model();
        modelVehicle.setId(1L);
        modelVehicle.setModelName("126p");
        /*------------------------------------*/
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setRegisterNumber("YY 11111");
        vehicle.setVehicleMark(markVehicle);
        vehicle.setVehicleModel(modelVehicle);
        vehicle.setVehicleType("Osobowy");
        vehicle.setInsuranceDate(new Date());
        vehicle.setServiceDate(new Date());
        vehicle.setVehicleReviewDate(new Date());
        vehicle.setFirstRegDate(new Date());


        Mark markVehicle1 = new Mark();
        markVehicle1.setId(2L);
        markVehicle1.setMarkName("FSO");
        /*------------------------------------*/
        Model modelVehicle1 = new Model();
        modelVehicle1.setId(2L);
        modelVehicle1.setModelName("Polonez");
        /*------------------------------------*/
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(2L);
        vehicle1.setRegisterNumber("XX 11223");
        vehicle1.setVehicleMark(markVehicle1);
        vehicle1.setVehicleModel(modelVehicle1);
        vehicle1.setVehicleType("Osobowy");
        vehicle1.setInsuranceDate(new Date());
        vehicle1.setServiceDate(new Date());
        vehicle1.setVehicleReviewDate(new Date());
        vehicle1.setFirstRegDate(new Date());

        User user = new User();
        user.setId(1L);
        user.setUserName("Admin");
        user.setUserSurname("Administrator");
        user.setUserEmail("admin@admin.pl");
        user.setUserPassword("@dm1n");
        user.setUserPermission("Administrator");


        try {
            userDao.createOrUpdate(user);
            /*----------------------------------------*/
            modelDao.createOrUpdate(modelVehicle);
            modelDao.createOrUpdate(modelVehicle1);
            /*----------------------------------------*/
            markDao.createOrUpdate(markVehicle);
            markDao.createOrUpdate(markVehicle1);
            /*----------------------------------------*/
            vehicleDao.createOrUpdate(vehicle);
            vehicleDao.createOrUpdate(vehicle1);
            /*----------------------------------------*/
        } catch (ApplicationExceptions e) {
            e.printStackTrace();
        } finally {
            DbManager.closeConnectionSource();
        }
    }
}
