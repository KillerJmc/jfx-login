package com.jmc.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var layoutPath = "/view/login.fxml";
        var title = "登录";
        var width = 350;
        var height = 300;

        var loader = new FXMLLoader(getClass().getResource(layoutPath));
        var scene = new Scene(loader.load(), width, height);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
