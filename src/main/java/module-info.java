module jfx.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires jmc.utils;

    exports com.jmc.login to javafx.fxml, javafx.graphics;
    opens com.jmc.login.controller to javafx.fxml;
}
