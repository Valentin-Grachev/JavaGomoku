package com.vg.gomoku.game;

import com.vg.gomoku.client.ClientAction;
import com.vg.gomoku.client.ClientHandler;
import com.vg.gomoku.server.Model;

import java.io.IOException;
import java.util.List;

public class Game {

    private List<List<PointStateType>> _pointStates;
    private Controller _controller;
    private int _playerNumber;

    public ClientHandler clientHandler;


    public Game(Controller controller, int playerNumber) {
        _controller = controller;
        _playerNumber = playerNumber;
    }


    public void LoadModel(Model model) {

    }

    public void makeMove(int x, int y) throws IOException {
        if (!canMove(x, y)) return;

        var newPointState = _playerNumber == 1 ? PointStateType.White : PointStateType.Black;

        _pointStates.get(y).set(x, newPointState);
        _controller.drawPoint(x, y, _playerNumber);

        // Отправка данных на сервер
        var action = new ClientAction(x, y);
        clientHandler.send(action);
    }


    private boolean canMove(int x, int y) {
        if (_pointStates.get(y).get(x) != PointStateType.Empty) return false;

        // Проверка окружения
        PointStateType allyState = _playerNumber == 1 ? PointStateType.White : PointStateType.Black;

        int y_prev = Math.max(y - 1, 0), y_next = Math.min(y + 1, 12);
        int x_prev = Math.max(x - 1, 0), x_next = Math.min(x + 1, 12);

        if (_pointStates.get(y_prev).get(x_prev) == allyState
        || _pointStates.get(y_prev).get(x) == allyState
        || _pointStates.get(y_prev).get(x_next) == allyState

        || _pointStates.get(y).get(x_prev) == allyState
        || _pointStates.get(y).get(x_next) == allyState

        || _pointStates.get(y_next).get(x_prev) == allyState
        || _pointStates.get(y_next).get(x) == allyState
        || _pointStates.get(y_next).get(x_next) == allyState) return true;

        return false;
    }




}
