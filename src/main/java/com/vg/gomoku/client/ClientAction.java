package com.vg.gomoku.client;

public class ClientAction {

    public int player;
    public int moveX;
    public int moveY;

    public ClientAction() { }
    public ClientAction(int moveX, int moveY, int player) {
        this.moveX = moveX;
        this.moveY = moveY;
        this.player = player;

    }

}
