package pl.domain.company.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import pl.domain.company.database.connection.DbManager;
import pl.domain.company.database.models.BaseModel;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);
    protected final ConnectionSource connectionSource;

    public BaseDao(){
        this.connectionSource = DbManager.getConnectionSource();
    }

    public <T extends BaseModel, I> void createOrUpdate(BaseModel baseModel) throws ApplicationExceptions {
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        try{
            dao.createOrUpdate((T) baseModel);
        }catch (SQLException e){
            LOGGER.warn(e.getCause().getMessage());
            throw new ApplicationExceptions("Błąd");
        }finally {
            this.closeDbConnection();
        }
    }

    private <T extends BaseModel, I> Dao<T,I> getDao(Class<T> aClass) throws  ApplicationExceptions{
        try{
            return DaoManager.createDao(connectionSource, aClass);
        }catch (SQLException e){
            LOGGER.warn(e.getCause().getMessage());
            throw new ApplicationExceptions("Błąd");
        }finally {
            this.closeDbConnection();
        }
    }
    public <T extends BaseModel, I> List<T> queryForAll(Class<T> cls) throws ApplicationExceptions {
        try {
            Dao<T, I> dao = getDao(cls);
            return dao.queryForAll();
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
            throw new ApplicationExceptions("Błąd");
        } finally {
            this.closeDbConnection();
        }
    }

    private void closeDbConnection() throws ApplicationExceptions {
        try {
            this.connectionSource.close();
        } catch (IOException e) {
            throw new ApplicationExceptions("Błąd");
        }
    }
    public <T extends BaseModel, I> T findById(Class<T> cls, Long id) throws ApplicationExceptions {
        try {
            Dao<T, I> dao = getDao(cls);
            return dao.queryForId((I) id);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
            throw new ApplicationExceptions("Błąd");
        } finally {
            this.closeDbConnection();
        }
    }
}
