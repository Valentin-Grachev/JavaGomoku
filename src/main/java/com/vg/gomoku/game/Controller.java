package com.vg.gomoku.game;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    public Game game;

    @FXML
    private ImageView field;
    @FXML
    public GridPane grid;
    @FXML
    private Label info;
    @FXML
    private Button playAgainButton;
    @FXML
    private Circle playerColor;

    @FXML
    void playAgain(MouseEvent event) {
        game.restartGame();
    }


    private List<Circle> _pointList = new ArrayList<>();

    public void addFieldClickHandler() {
        field.setOnMouseClicked(mouseEvent -> {
            double cellSize = 50;

            int x = (int)Math.floor((mouseEvent.getX() - cellSize / 2) / cellSize);
            x = Math.max(x, 0); x = Math.min(x, 12);

            int y = (int)Math.floor((mouseEvent.getY() - cellSize / 2) / cellSize);
            y = Math.max(y, 0); y = Math.min(y, 12);

            try {
                new FieldClickHandler(y, x, game).onClick();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void drawPoint(int x, int y, int playerNumber) {
        var circle = new Circle(0,0, 24);

        if (playerNumber == 1) circle.setFill(Color.WHITE);
        else if (playerNumber == 2) circle.setFill(Color.BLACK);

        Platform.runLater(() -> grid.add(circle, y, x));
        _pointList.add(circle);

        System.out.println("drawed: " + x + " " + y);
    }

    public void selectPlayerColor(Color color) {
        playerColor.setFill(color);
    }

    public void clearField() {
        for (int i = 0; i < _pointList.size(); i++) {
            _pointList.get(i).setVisible(false);
        }
        playAgainButton.setVisible(false);
    }

    public void showMessage(String message) {
        Platform.runLater(()-> info.setText(message));

    }

    public void makeAvailableRestart() {
        playAgainButton.setVisible(true);
    }





}