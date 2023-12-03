module com.vg.gomoku {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    requires java.jws;
    requires java.xml.ws;
    requires java.sql;

    requires org.eclipse.persistence.asm;
    requires org.eclipse.persistence.core;
    requires org.eclipse.persistence.moxy;
    requires org.eclipse.persistence.sdo;



    opens com.vg.gomoku to javafx.fxml;
    exports com.vg.gomoku.client;
    opens com.vg.gomoku.client to javafx.fxml;
    exports com.vg.gomoku;
    exports com.vg.gomoku.game;
    opens com.vg.gomoku.webservice;
    opens com.vg.gomoku.game to javafx.fxml;
    exports com.vg.gomoku.server;
}