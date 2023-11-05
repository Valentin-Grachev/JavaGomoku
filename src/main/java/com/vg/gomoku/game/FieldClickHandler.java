package com.vg.gomoku.game;

public class FieldClickHandler {

    private int posX;
    private int poxY;


    FieldClickHandler(int x, int y) {
        posX = x;
        poxY = y;

    }

    public void onClick() {
        System.out.println("x: " + posX + " y: " + poxY + "\n");

    }


}
