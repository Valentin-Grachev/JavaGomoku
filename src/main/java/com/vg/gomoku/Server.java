package com.vg.gomoku;

import com.vg.gomoku.client.ClientAction;
import com.vg.gomoku.server.Model;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.IOException;


@WebService
public class Server {

    static String url = "http://localhost:8080/Gomoku";

    Model model = new Model();

    private int _playersConnected = 0;


    public static void main(String[] args) throws IOException {
        Server service = new Server();
        Endpoint.publish(url, service);
        System.out.println("Webservice published on " + url);
    }

    @WebMethod
    public int connectAndGetPlayerNumber() {
        _playersConnected++;
        prepareModel();
        System.out.println("Player connected. Now players: " + _playersConnected);
        if (_playersConnected == 2) System.out.println("Game started.");
        return _playersConnected;
    }

    private void prepareModel() {
        model.gameStarted = true;
        model.movePlayerNowNumber = 1;
        model.lastMoveY = 6;
        model.lastMoveX = 6;
    }

    @WebMethod
    public void makeMove(ClientAction clientAction) {
        model.lastMoveX = clientAction.moveX;
        model.lastMoveY = clientAction.moveY;

        if (clientAction.player == 1) model.movePlayerNowNumber = 2;
        else if (clientAction.player == 2) model.movePlayerNowNumber = 1;
    }

    @WebMethod
    public Model getCurrentModel() {
        return model;
    }



}
