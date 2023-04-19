package com.jmc.login.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

@NoArgsConstructor
public class UserInfoController implements Initializable {
    @Setter
    private String account;
    public Text accountText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 将传进来的账号信息显示出来
        accountText.setText(account);
    }
}
