package com.vg.gomoku.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vg.gomoku.game.Game;
import com.vg.gomoku.server.Model;

import java.io.IOException;

public class ClientHandler extends Thread {

    private ClientConnection _connection;
    private Game _game;

    Gson gson = new Gson();


    public ClientHandler(ClientConnection connection, Game game) {
        _connection = connection;
        _game = game;
    }



    public void run() {
        try {
            while (true) {

                // Ждем от сервера данных
                if (_connection.dataFromServer.available() > 0) {
                    var model = gson.fromJson(_connection.dataFromServer.readUTF(), Model.class);
                    System.out.println("Data accepted");

                    _game.LoadModel(model);
                }

            }
        } catch (IOException e) { System.out.println(e);}

    }

    public void send(ClientAction action) throws IOException {
        _connection.dataToServer.flush();
        _connection.dataToServer.writeUTF(gson.toJson(action));
    }


}
