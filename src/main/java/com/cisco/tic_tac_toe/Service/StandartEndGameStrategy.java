package com.cisco.tic_tac_toe.Service;

import com.cisco.tic_tac_toe.Beans.Board;

public class StandartEndGameStrategy implements EndGameStrategy {

    @Override
    public boolean checkEndGame(Board board, int row, int col, char symbol) {
        return isColumnFormed(board, col, symbol) || isRowFormed(board, row, symbol)
                || isDiagonalsFormed(board, row, col, symbol);
    }

    public boolean isColumnFormed(Board board, int col, char symbol) {
        for (int row = 0; row < board.getSize(); row++) {
            if (board.getBoard()[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean isRowFormed(Board board, int row, char symbol) {
        for (int col = 0; col < board.getSize(); col++) {
            if (board.getBoard()[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean isDiagonalsFormed(Board board, int row, int col, char symbol) {
        if (!(row - col == 0) && !(row + col == board.getSize() - 1)) {
            return false;
        }

        boolean posDiagonal = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[i][i] != symbol) {
                posDiagonal = false;
                break;
            }
        }
        if (posDiagonal) {
            return true;
        }

        boolean negDiagonal = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[i][board.getSize() - 1 - i] != symbol) {
                negDiagonal = false;
                break;
            }
        }

        return negDiagonal;
    }

}
