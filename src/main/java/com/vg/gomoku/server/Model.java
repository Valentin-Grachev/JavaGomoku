package com.vg.gomoku.server;

public class Model {

    public int lastMoveX;
    public int lastMoveY;

    public boolean gameStarted;
    public int movePlayerNowNumber;
    public int playerIdentificator;


    public void startGame() {

        gameStarted = true;
        movePlayerNowNumber = 1;
    }

    public void makeMove(int x, int y, int playerNumber) {
        lastMoveX = x;
        lastMoveY = y;

        if (playerNumber == 1) movePlayerNowNumber = 2;
        else if (playerNumber == 2) movePlayerNowNumber = 1;
    }



}
