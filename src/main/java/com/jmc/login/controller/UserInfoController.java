package com.jmc.login.controller;

import com.jmc.login.common.FxmlPath;
import com.jmc.login.util.JFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class UserInfoController {
    public Text accountText;

    public void setAccountText(String account) {
        this.accountText.setText(account);
    }

    /**
     * 返回到登录页面
     */
    public void returnAction(ActionEvent event) throws IOException {
        JFXUtils.switchScene(event, FxmlPath.LOGIN, "登录", null);
    }
}
