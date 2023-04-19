package com.jmc.login.controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public StackPane rootPane;
    public JFXTextField accountText;
    public JFXPasswordField passwordText;
    public JFXDialog loginResultDialog;
    public Text dialogText;

    /**
     * 登录按钮
     */
    public void login(ActionEvent event) throws IOException {
        var account = accountText.getText();
        var password = passwordText.getText();

        var correctAccount = "Jmc";
        var correctPassword = "666";

        var loginSuccessMsg = "登录成功！";
        var loginFailedMsg = "账号或密码错误！";

        // 判断账号密码是否正确来改变对话框文字
        if (true || account.equals(correctAccount) && password.equals(correctPassword)) {
            dialogText.setText(loginSuccessMsg);

            // 跳转到用户信息页面
            var loader = new FXMLLoader(getClass().getResource("/view/user_info.fxml"));
            var scene = new Scene(loader.load());
            UserInfoController controller = loader.getController();
            controller.setAccount(account);
            var stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            dialogText.setText(loginFailedMsg);
        }

        // 显示对话框
        loginResultDialog.show(rootPane);
    }

    /**
     * 关闭对话框的按钮
     */
    public void closeDialog() {
        loginResultDialog.close();
    }
}
