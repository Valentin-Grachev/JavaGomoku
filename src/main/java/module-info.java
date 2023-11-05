module com.vg.gomoku {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.vg.gomoku to javafx.fxml;
    exports com.vg.gomoku.client;
    opens com.vg.gomoku.client to javafx.fxml;
    exports com.vg.gomoku;
    exports com.vg.gomoku.game;
    opens com.vg.gomoku.game to javafx.fxml;
}