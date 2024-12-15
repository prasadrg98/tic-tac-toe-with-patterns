package com.cisco.tic_tac_toe.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import com.cisco.tic_tac_toe.Beans.Board;
import com.cisco.tic_tac_toe.Beans.Player;

public class GameService {
    private List<Player> players;
    private Board board;
    private int playerIndex;
    private Queue<Player> nextTurn;
    private EndGameStrategy endGameStrategy;

    public GameService(List<Player> players, int boardSize, EndGameStrategy strategy, BoardFactory boardFactory) {
        this.players = players;
        this.board = boardFactory.getBoard(boardSize);
        this.playerIndex = 0;
        this.endGameStrategy = strategy;
        nextTurn = new LinkedList<>(players);
    }

    public void switchPlayer() {
        playerIndex = (playerIndex + 1) % players.size();
    }

    public void startGame() {
        boolean isValidMove = false;
        int row = 0;
        int col = 0;
        boolean win = false;

        while (!board.isBoardFull()) {
            // Player player = players.get(playerIndex);
            Player player = nextTurn.poll();
            Random randomObj = new Random();
            System.out.println("Player Turn: " + player.getName());
            isValidMove = false;

            while (!isValidMove) {
                row = randomObj.nextInt(board.getSize());
                col = randomObj.nextInt(board.getSize());

                if (board.isValidMove(row, col)) {
                    isValidMove = true;
                    board.makeMove(row, col, player.getSymbol());
                    System.out.println("Symbol: " + player.getSymbol() + " placed at (" + row + "," + col + ")");
                    board.display();
                }
            }

            win = isEndGame(row, col, player.getSymbol());
            if (win) {
                System.out.println(
                        "Player: " + player.getName() + " with symbol: " + player.getSymbol() + " wins the game");
                break;
            }

            if (isDraw()) {
                System.out.println("Play Again its a draw");
            }

            // switchPlayer();
            nextTurn.add(player);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
    }

    public boolean isDraw() {
        return board.isBoardFull();
    }

    public boolean isEndGame(int row, int col, char symbol) {
        return endGameStrategy.checkEndGame(board, row, col, symbol);
    }
}
