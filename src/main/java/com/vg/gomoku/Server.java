package com.vg.gomoku;

import com.vg.gomoku.server.ServerConnection;
import com.vg.gomoku.server.Model;
import com.vg.gomoku.server.ServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;





public class Server {

    Model model = new Model();

    ServerConnection connection1;
    ServerConnection connection2;


    public static int port = 1111;

    public static void main(String[] args) throws IOException {
        new Server().startServer();
    }

    private void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started");

        while (true) {
            try {
                // Ждем подключения нового клиента.
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                if (connection1 == null) connection1 = new ServerConnection(clientSocket);

                else if (connection2 == null) {
                    connection2 = new ServerConnection(clientSocket);
                    model.startGame();
                    new ServerHandler(connection1, connection2, model).start();
                    System.out.println("Start game");
                    break;
                }


            }
            catch (IOException e) { }
        }

    }

}
