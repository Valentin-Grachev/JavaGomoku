package com.vg.gomoku.game;

import java.io.IOException;

public class FieldClickHandler {

    private int posX;
    private int poxY;
    private Game _game;


    FieldClickHandler(int x, int y, Game game) {
        posX = x;
        poxY = y;
        _game = game;
    }

    public void onClick() throws IOException {
        System.out.println("clicked: " + posX + " " + poxY);
        _game.makeMove(posX, poxY);
    }


}
