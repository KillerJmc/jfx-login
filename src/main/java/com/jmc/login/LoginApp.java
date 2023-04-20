package com.jmc.login;

import com.jmc.login.common.FxmlPath;
import com.jmc.login.util.JFXUtils;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 登录App启动类
 * @author Jmc
 */
public class LoginApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        JFXUtils.showSceneInStage(stage, FxmlPath.LOGIN, "登录", 260, 300);
    }
}
