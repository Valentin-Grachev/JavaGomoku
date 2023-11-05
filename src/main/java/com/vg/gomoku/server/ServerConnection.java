package com.vg.gomoku.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection {

    public DataOutputStream dataToClient;
    public DataInputStream dataFromClient;

    public ServerConnection(Socket clientSocket) throws IOException {
        dataToClient = new DataOutputStream(clientSocket.getOutputStream());
        dataFromClient = new DataInputStream(clientSocket.getInputStream());
    }




}
