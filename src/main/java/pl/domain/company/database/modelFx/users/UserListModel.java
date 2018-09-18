package pl.domain.company.database.modelFx.users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.domain.company.database.dao.UserDao;
import pl.domain.company.database.models.User;
import pl.domain.company.database.utils.converters.ConvertUser;
import pl.domain.company.database.utils.exceptions.ApplicationExceptions;

import java.util.ArrayList;
import java.util.List;

public class UserListModel {
    private ObservableList<UserFx> userFxObservableList
            = FXCollections.observableArrayList();
    private List<UserFx> userFxList
            = new ArrayList<>();

    public void init() throws ApplicationExceptions {
        UserDao userDao = new UserDao();
        List<User> users = userDao.queryForAll(User.class);
        userFxList.clear();
        users.forEach(user -> {
            this.userFxList.add(ConvertUser.convertToUserFx(user));
        });
        this.userFxObservableList.setAll(userFxList);
    }

    public ObservableList<UserFx> getUserFxObservableList() {
        return userFxObservableList;
    }
}
