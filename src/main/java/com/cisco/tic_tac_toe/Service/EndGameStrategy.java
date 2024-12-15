package com.cisco.tic_tac_toe.Service;

import com.cisco.tic_tac_toe.Beans.Board;

public interface EndGameStrategy {
    boolean checkEndGame(Board board, int row, int col, char symbol);
}
