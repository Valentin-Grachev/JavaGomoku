package com.vg.gomoku.server;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vg.gomoku.client.ClientAction;

public class ServerHandler extends Thread {

    Model model;
    public ServerConnection player1;
    public ServerConnection player2;

    Gson gson = new Gson();


    public ServerHandler(ServerConnection player1, ServerConnection player2, Model model) throws IOException {
        this.player1 = player1;
        this.player2 = player2;
        this.model = model;
    }


    public void run() {
        try {
            // Первое сообщение от сервера - определение для клиентов их номеров
            model.playerIdentificator = 1;
            player1.dataToClient.flush();
            player1.dataToClient.writeUTF(gson.toJson(model));

            model.playerIdentificator = 2;
            player2.dataToClient.flush();
            player2.dataToClient.writeUTF(gson.toJson(model));
            System.out.println("Identificated");



            while (true) {

                // Получили данные от первого игрока
                if (player1.dataFromClient.available() > 0) {
                    var clientAction = gson.fromJson(player1.dataFromClient.readUTF(), ClientAction.class);

                    // Сделан ход
                    model.makeMove(clientAction.moveX, clientAction.moveY, 1);

                    // Отправка обновленного состояния клиентам
                    sendGameStateToClients();
                }

                // Получили данные от второго игрока
                else if (player2.dataFromClient.available() > 0) {
                    var clientAction = gson.fromJson(player2.dataFromClient.readUTF(), ClientAction.class);

                    // Сделан ход
                    model.makeMove(clientAction.moveX, clientAction.moveY, 2);

                    // Отправка обновленного состояния клиентам
                    sendGameStateToClients();
                }

            }
        }

        catch (IOException e) {}
    }


    public void sendGameStateToClients() throws IOException {
        model.playerIdentificator = 0;

        player1.dataToClient.flush();
        player1.dataToClient.writeUTF(gson.toJson(model));

        player2.dataToClient.flush();
        player2.dataToClient.writeUTF(gson.toJson(model));
    }


}

