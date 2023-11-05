package com.vg.gomoku.game;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Controller {

    @FXML
    private ImageView field;
    @FXML
    public GridPane grid;


    public void addFieldClickHandler() {
        field.setOnMouseClicked(mouseEvent -> {
            double cellSize = 50;

            int x = (int)Math.floor((mouseEvent.getX() - cellSize / 2) / cellSize);
            x = Math.max(x, 0); x = Math.min(x, 12);

            int y = (int)Math.floor((mouseEvent.getY() - cellSize / 2) / cellSize);
            y = Math.max(y, 0); y = Math.min(y, 12);

            new FieldClickHandler(x, y).onClick();
        });

    }

    public void drawPoint(int x, int y, int playerNumber) {
        var circle = new Circle(0,0, 24);

        if (playerNumber == 1) circle.setFill(Color.WHITE);
        else if (playerNumber == 2) circle.setFill(Color.BLACK);

        grid.add(circle, x, y);
    }









}