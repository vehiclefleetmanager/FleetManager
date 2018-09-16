package pl.domain.company.controllers.main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class MainController {
    /**ścieżka do okienka z logowaniem*/
    private static final String LOG_PATH = "/fxml/fleetmanager/main/LogWindow.fxml";

    /**wstrzyknięte główne okno programu fx:id = "main"*/
    @FXML
    private BorderPane main;

    /**wstrzyknięte duże menu górne o fx:id = "leftMenu"
     * dla poprawnego działania w tej klasie musi mieć nazwe 'leftMenuController'*/
    @FXML
    private LeftMenuController leftMenuController;

    @FXML
    private LogWindowController logWindowController;

    /**metoda uruchamijąca sie wraz z metodą 'start' z klasy Main,
     * inicjalizuje obiekt klasy MainController,
     * następnie próbuje otworzyć okno do logowania */
    @FXML
    public void initialize() {
        leftMenuController.setMainController(this);
        try {
            openLogWindow(LOG_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** metoda której zadaniem jest zmiana funkcjonalności związana z lewym menu
     * przełącza dostępne funkcje w głownym oknie programu*/
    public void loadNewView(String path)  {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
        ResourceBundle bundle = ResourceBundle.getBundle("description.description");
        loader.setResources(bundle);
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.setCenter(parent);

    }

    /**metoda której wywołanie powoduje uruchomienie okna do logowania,
     * praca z programem możliwa dopiero po zalogowaniu */
    private void openLogWindow(String logWindowPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(logWindowPath));
        ResourceBundle bundle = ResourceBundle.getBundle("description.description");
        loader.setResources(bundle);
        VBox loginVBox = loader.load();
        Scene loginScene = new Scene(loginVBox);
        Stage loginStage = new Stage();
        loginStage.setTitle("Asystent floty v1.0");
        loginStage.setScene(loginScene);
        loginStage.initModality(Modality.APPLICATION_MODAL);
        loginStage.setAlwaysOnTop(true);
        loginStage.showAndWait();
    }
}
