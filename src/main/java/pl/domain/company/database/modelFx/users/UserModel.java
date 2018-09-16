package pl.domain.company.database.modelFx.users;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.domain.company.database.dao.UserDao;
import pl.domain.company.database.models.User;
import pl.domain.company.database.utils.converters.ConvertUser;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

public class UserModel {
    private ObjectProperty<UserFx> userFxObjectProperty = new SimpleObjectProperty<>(new UserFx());

    public void saveUserInDataBase() throws ApplicationExceptions {
        User user = ConvertUser.convertToUser(this.getUserFxObjectProperty());
        UserDao userDao = new UserDao();
        userDao.createOrUpdate(user);
    }


    public UserFx getUserFxObjectProperty() {
        return userFxObjectProperty.get();
    }

    public ObjectProperty<UserFx> userFxObjectPropertyProperty() {
        return userFxObjectProperty;
    }

    public void setUserFxObjectProperty(UserFx userFxObjectProperty) {
        this.userFxObjectProperty.set(userFxObjectProperty);
    }


}