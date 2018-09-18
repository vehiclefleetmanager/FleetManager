package pl.domain.company.controllers.menu.controllers;

import javafx.scene.control.Button;

public interface Controllable {
    void initialize();
    void showWindow(String path, String title);
    void closeWindow(Button button);
}
