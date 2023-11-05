package com.vg.gomoku.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnection {

    public DataOutputStream dataToServer;
    public DataInputStream dataFromServer;

    public ClientConnection(Socket clientSocket) throws IOException {
        dataToServer = new DataOutputStream(clientSocket.getOutputStream());
        dataFromServer = new DataInputStream(clientSocket.getInputStream());
    }
}
