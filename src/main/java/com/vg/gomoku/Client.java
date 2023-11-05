package com.vg.gomoku;

import com.vg.gomoku.client.ClientConnection;
import com.vg.gomoku.client.ClientHandler;
import com.vg.gomoku.game.Controller;
import com.vg.gomoku.game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

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

        InetAddress address = InetAddress.getLocalHost();
        Socket socket = new Socket(address, Server.port);

        Game game = new Game(controller, 1);
        ClientConnection connection = new ClientConnection(socket);
        ClientHandler handler = new ClientHandler(connection, game);
        game.clientHandler = handler;



    }


}