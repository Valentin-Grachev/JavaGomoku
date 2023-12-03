package com.vg.gomoku.game;

import com.vg.gomoku.webservice.Server;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<List<PointStateType>> _pointStates;
    private Controller _controller;
    private int _playerNumber;
    private boolean _canMakeMove;
    private boolean _gameNotStarted = true;
    private boolean _gameFinished = false;

    private Server _server;




    public Game(Controller controller, Server server) {
        _controller = controller;
        _playerNumber = server.connectAndGetPlayerNumber();
        _controller.showMessage("Ваш ход");
        _server = server;
        startGame();

        // Поток, запрашивающий модель с сервера
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(200);
                    LoadModel(_server.getCurrentModel());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


    public void restartGame() {
        _canMakeMove = true;
        _gameNotStarted = false;
        startGame();
    }

    public void startGame() {
        _pointStates = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            var row = new ArrayList<PointStateType>();
            for (int j = 0; j < 13; j++) row.add(PointStateType.Empty);
            _pointStates.add(row);
        }
        _controller.clearField();

        _pointStates.get(6).set(6, PointStateType.Black);
        _controller.drawPoint(6, 6, 2);
        _gameNotStarted = false;
    }

    public void LoadModel(com.vg.gomoku.webservice.Model model) {
        if (_gameFinished) return;

        System.out.println("Load model: " + model.getLastMoveY() + " " + model.getLastMoveX() +
                " " + model.getMovePlayerNowNumber());

        // Показ цвета игрока
        if (_playerNumber == 1) _controller.selectPlayerColor(Color.WHITE);
        else if (_playerNumber == 2) _controller.selectPlayerColor(Color.BLACK);

        if (_gameNotStarted) startGame();

        // Отображение сделанного хода
        else {
            var newPointState = model.getMovePlayerNowNumber() == 2 ? PointStateType.White : PointStateType.Black;
            int movedPlayerNumber = model.getMovePlayerNowNumber() == 2 ? 1 : 2;

            _pointStates.get(model.getLastMoveY()).set(model.getLastMoveX(), newPointState);
            _controller.drawPoint(model.getLastMoveX(), model.getLastMoveY(), movedPlayerNumber);
            System.out.println("load model: " + model.getLastMoveX() + " " + model.getLastMoveY());
        }

        _canMakeMove = model.getMovePlayerNowNumber() == _playerNumber;

        // Пока никто не победил
        int victory = checkVictory();

        if (victory == -1) {
            if (_canMakeMove) _controller.showMessage("Ваш ход");
            else _controller.showMessage("Ход оппонента...");
        }

        // Кто-то победил
        else {
            if (victory == 0) _controller.showMessage("Ничья");
            else if (victory == _playerNumber) _controller.showMessage("Победа!");
            else _controller.showMessage("Поражение! Будь умнее!");

            //if (_playerNumber == 1) _controller.makeAvailableRestart();
            _gameFinished = true;
        }
    }

    public void makeMove(int x, int y) throws IOException {
        System.out.println(_canMakeMove);
        System.out.println(canMove(x, y));

        if (!_canMakeMove || !canMove(x, y)) return;

        var newPointState = _playerNumber == 1 ? PointStateType.White : PointStateType.Black;

        _pointStates.get(y).set(x, newPointState);
        _controller.drawPoint(x, y, _playerNumber);

        // Отправка данных на сервер
        var action = new com.vg.gomoku.webservice.ClientAction();
        action.setMoveX(x);
        action.setMoveY(y);
        action.setPlayer(_playerNumber);

        _server.makeMove(action);
    }


    private boolean canMove(int x, int y) {
        if (_pointStates.get(y).get(x) != PointStateType.Empty || _gameNotStarted) return false;
        return true;
    }

    // -1 - пока нет победителя, 0 - ничья, 1 - победа первого, 2 - победа второго
    private int checkVictory() {

        // Проверка на ничью
        boolean draw = true;
        for (int y = 0; y < _pointStates.size(); y++)
            for (int x = 0; x < _pointStates.size(); x++)
                if (_pointStates.get(y).get(x) == PointStateType.Empty) draw = false;

        // Проверка победы первого игрока
        for (int y = 0; y < _pointStates.size(); y++)
            for (int x = 0; x < _pointStates.size(); x++)
                if (_pointStates.get(y).get(x) == PointStateType.White && isVictoryPoint(x, y))
                    return 1;

        // Проверка победы второго игрока
        for (int y = 0; y < _pointStates.size(); y++)
            for (int x = 0; x < _pointStates.size(); x++)
                if (_pointStates.get(y).get(x) == PointStateType.Black && isVictoryPoint(x, y))
                    return 2;

        return -1;
    }

    // Проверка пункта, является ли он началом победной цепочки
    private boolean isVictoryPoint(int x, int y) {
        PointStateType checkableState = _pointStates.get(y).get(x);

        // Влево
        boolean left = pointHasState(x-1, y, checkableState)
                && pointHasState(x-2, y, checkableState)
                && pointHasState(x-3, y, checkableState)
                && pointHasState(x-4, y, checkableState);

        boolean left_up = pointHasState(x-1, y-1, checkableState)
                && pointHasState(x-2, y-2, checkableState)
                && pointHasState(x-3, y-3, checkableState)
                && pointHasState(x-4, y-4, checkableState);

        boolean up = pointHasState(x, y-1, checkableState)
                && pointHasState(x, y-2, checkableState)
                && pointHasState(x, y-3, checkableState)
                && pointHasState(x, y-4, checkableState);

        boolean up_right = pointHasState(x+1, y-1, checkableState)
                && pointHasState(x+2, y-2, checkableState)
                && pointHasState(x+3, y-3, checkableState)
                && pointHasState(x+4, y-4, checkableState);

        boolean right = pointHasState(x+1, y, checkableState)
                && pointHasState(x+2, y, checkableState)
                && pointHasState(x+3, y, checkableState)
                && pointHasState(x+4, y, checkableState);

        boolean down_right = pointHasState(x+1, y+1, checkableState)
                && pointHasState(x+2, y+2, checkableState)
                && pointHasState(x+3, y+3, checkableState)
                && pointHasState(x+4, y+4, checkableState);

        boolean down = pointHasState(x, y+1, checkableState)
                && pointHasState(x, y+2, checkableState)
                && pointHasState(x, y+3, checkableState)
                && pointHasState(x, y+4, checkableState);

        boolean down_left = pointHasState(x-1, y+1, checkableState)
                && pointHasState(x-2, y+2, checkableState)
                && pointHasState(x-3, y+3, checkableState)
                && pointHasState(x-4, y+4, checkableState);

        return left || left_up || up || up_right || right || down_right || down || down_left;
    }

    private boolean pointHasState(int x, int y, PointStateType state) {
        if (x < 0 || x > 12 || y < 0 || y > 12) return false;
        return _pointStates.get(y).get(x) == state;
    }



    private boolean cellAvailable(int x, int y) {
        return 0 <= x && x < 13 && 0 <= y && y < 13;
    }



}
