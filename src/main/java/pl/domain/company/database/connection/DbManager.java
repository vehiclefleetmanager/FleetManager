package pl.domain.company.database.connection;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.domain.company.database.models.Mark;
import pl.domain.company.database.models.Model;
import pl.domain.company.database.models.User;
import pl.domain.company.database.models.Vehicle;


import java.io.IOException;
import java.sql.SQLException;
public class DbManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static final String JDBC_DRIVER_HD = "jdbc:h2:./fleetManager";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static ConnectionSource connectionSource;

    public static void initDatabase(){
        createConnectionSource();
        //dropTable(); //zakomentuj, żeby nie kasować za każym razem tabel w bazie
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource(){
        try {
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD,USER, PASS);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource!=null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTable(){
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, Vehicle.class);
            TableUtils.createTableIfNotExists(connectionSource, Mark.class);
            TableUtils.createTableIfNotExists(connectionSource, Model.class);

        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private  static  void  dropTable(){
        try {
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, Vehicle.class, true);
            TableUtils.dropTable(connectionSource, Mark.class, true);
            TableUtils.dropTable(connectionSource, Model.class, true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }


    /* kod do bazy MySQL
    public Connection connect() throws Exception {
        Connection connection;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/fleetmanager?users=root&password=F@jn3H@sl0");
        return connection;
    }*/
}
