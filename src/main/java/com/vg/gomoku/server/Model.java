package com.vg.gomoku.server;

import com.vg.gomoku.game.PointStateType;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public ArrayList<ArrayList<PointStateType>> pointStates;

    public boolean gameStarted = false;
    public int movePlayerNowNumber = 1;
    public int playerIdentificator = 0;



    public void startGame() {
        pointStates = new ArrayList<>(13);

        for (int i = 0; i < 13; i++) {
            var row = new ArrayList<PointStateType>(13);
            for (int j = 0; j < 13; j++) row.add(PointStateType.Empty);
            pointStates.add(row);
        }

        gameStarted = true;
        movePlayerNowNumber = 1;
    }

    public void makeMove(int x, int y, int playerNumber) {
        if (playerNumber == 1) {
            pointStates.get(y).set(x, PointStateType.White);
            movePlayerNowNumber = 2;
        }
        else if (playerNumber == 2) {
            pointStates.get(y).set(x, PointStateType.Black);
            movePlayerNowNumber = 1;
        }


    }



}
