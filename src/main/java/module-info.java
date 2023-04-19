module jfxlogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires static lombok;

    exports com.jmc.login;
    exports com.jmc.login.controller;
    opens com.jmc.login.controller to javafx.fxml;
}
