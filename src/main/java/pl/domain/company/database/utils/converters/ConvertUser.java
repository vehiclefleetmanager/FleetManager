package pl.domain.company.database.utils.converters;

import pl.domain.company.database.modelFx.users.UserFx;
import pl.domain.company.database.models.User;

public class ConvertUser {
    public static User convertToUser(UserFx userFx){
        User user = new User();
        user.setId(userFx.getId());
        user.setUserName(userFx.getUserName());
        user.setUserSurname(userFx.getUserSurname());
        user.setUserEmail(userFx.getUserEmail());
        user.setUserPassword(userFx.getUserPassword());
        user.setUserPermission(userFx.getUserPermission());
        return user;
    }
    public static UserFx convertToUserFx(User user){
        UserFx userFx = new UserFx();
        userFx.setId(user.getId());
        userFx.setUserEmail(user.getUserEmail());
        userFx.setUserName(user.getUserName());
        userFx.setUserPassword(user.getUserPassword());
        userFx.setUserPermission(user.getUserPermission());
        userFx.setUserSurname(user.getUserSurname());
        return userFx;
    }
}
