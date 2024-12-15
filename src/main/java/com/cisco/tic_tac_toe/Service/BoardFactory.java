package com.cisco.tic_tac_toe.Service;

import com.cisco.tic_tac_toe.Beans.Board;

public class BoardFactory {
    public Board getBoard(int size) {
        return new Board(size);
    }   
}
