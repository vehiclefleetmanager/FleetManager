package pl.domain.company.database.modelFx.users;


import javafx.beans.property.*;

public class UserFx {
    private LongProperty id = new SimpleLongProperty();
    private StringProperty userName = new SimpleStringProperty();
    private StringProperty userSurname = new SimpleStringProperty();
    private StringProperty userEmail = new SimpleStringProperty();
    private StringProperty userPassword = new SimpleStringProperty();
    private StringProperty userPermission = new SimpleStringProperty();

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getUserSurname() {
        return userSurname.get();
    }

    public StringProperty userSurnameProperty() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname.set(userSurname);
    }

    public String getUserEmail() {
        return userEmail.get();
    }

    public StringProperty userEmailProperty() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail.set(userEmail);
    }

    public String getUserPassword() {
        return userPassword.get();
    }

    public StringProperty userPasswordProperty() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword.set(userPassword);
    }

    public String getUserPermission() {
        return userPermission.get();
    }

    public StringProperty userPermissionProperty() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission.set(userPermission);
    }

    @Override
    public String toString() {
        return userName.get() + " " + userSurname.get();
    }
}