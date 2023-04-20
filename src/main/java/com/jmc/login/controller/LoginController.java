package com.jmc.login.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jmc.login.common.FxmlPath;
import com.jmc.login.ui.JFXMessageQueue;
import com.jmc.login.util.JFXUtils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class LoginController {
    public StackPane rootView;
    public JFXTextField accountText;
    public JFXPasswordField passwordText;
    public JFXDialog loginResultDialog;
    public Text dialogText;

    /**
     * 登录按钮
     */
    public void login(ActionEvent event) throws Exception {
        var account = accountText.getText();
        var password = passwordText.getText();

        var correctAccount = "Jmc";
        var correctPassword = "666";

        // 如果账号密码不正确
        if (!(account.equals(correctAccount) && password.equals(correctPassword))) {
            var loginFailedMsg = "账号或密码错误！";

            // 设置对话框内容并显示对话框
            dialogText.setText(loginFailedMsg);
            loginResultDialog.show(rootView);

            return;
        }

        // 显示登录成功提醒
        var loginSuccessMsg = "登录成功！";
        JFXMessageQueue.of(rootView).success(loginSuccessMsg);

        // 在提醒结束后延迟跳转！
        CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS).execute(() -> Platform.runLater(() -> {
            // 跳转到用户信息页面
            JFXUtils.switchScene(
                    event,
                    FxmlPath.USER_INFO,
                    "用户信息",
                    // 设置用户信息页面的数据
                    (UserInfoController controller) -> controller.setAccountText(account)
            );
        }));
    }

    /**
     * 关闭对话框的按钮
     */
    public void closeDialog() {
        loginResultDialog.close();
    }
}
