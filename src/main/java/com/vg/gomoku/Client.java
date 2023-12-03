package com.vg.gomoku;

import com.vg.gomoku.game.Controller;
import com.vg.gomoku.game.Game;
import com.vg.gomoku.webservice.Server;
import com.vg.gomoku.webservice.ServerService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Client extends Application {
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);

        stage.setTitle("Best Gomoku 2023");
        stage.setScene(scene);
        stage.show();

        Controller controller = fxmlLoader.getController();
        controller.addFieldClickHandler();

        Server server = new ServerService(new URL(com.vg.gomoku.Server.url)).getServerPort();
        Game game = new Game(controller, server);
        controller.game = game;


    }


}