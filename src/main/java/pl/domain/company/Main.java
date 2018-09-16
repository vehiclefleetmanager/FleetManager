package pl.domain.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.domain.company.database.connection.DbManager;
import pl.domain.company.database.utils.DemoDatabase;

import java.util.ResourceBundle;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/fleetmanager/main/Main.fxml"));
        ResourceBundle bundle = ResourceBundle.getBundle("description.description");
        loader.setResources(bundle);
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle(bundle.getString("title.application"));
        primaryStage.setScene(scene);
        //primaryStage.setMaximized(true);
        primaryStage.show();

        DbManager.initDatabase();
        DemoDatabase.fillDatabase();
    }
}
