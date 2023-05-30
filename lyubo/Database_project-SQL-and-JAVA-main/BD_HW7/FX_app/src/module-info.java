module FX.app {
    requires DB2;
    requires javafx.fxml;
    requires javafx.controls;
    opens FXapp to  javafx.fxml;
    exports FXapp;
}