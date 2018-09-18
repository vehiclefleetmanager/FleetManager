package pl.domain.company.database.models;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "USERS")
public class User implements BaseModel{
    public User(){}

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField(columnName = "Name")
    private String userName;

    @DatabaseField(columnName = "Surname")
    private String userSurname;

    @DatabaseField(columnName = "E-mail")
    private String userEmail;

    @DatabaseField(columnName = "Password")
    private String userPassword;

    @DatabaseField(columnName = "Permission")
    private String userPermission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }
}
