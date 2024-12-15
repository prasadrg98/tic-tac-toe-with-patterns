package com.cisco.tic_tac_toe;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cisco.tic_tac_toe.Beans.Player;
import com.cisco.tic_tac_toe.Service.BoardFactory;
import com.cisco.tic_tac_toe.Service.EndGameStrategy;
import com.cisco.tic_tac_toe.Service.GameService;
import com.cisco.tic_tac_toe.Service.StandartEndGameStrategy;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {
		
        Player rg = new Player("rg", 'X');
        Player lokkesh = new Player("lokkesh", 'O');

        List<Player> players = List.of(rg, lokkesh);

        EndGameStrategy strategy = new StandartEndGameStrategy();
        GameService gameService = new GameService(players, 3, strategy, new BoardFactory());
        gameService.startGame();
        System.out.println("Hello World");
        SpringApplication.run(TicTacToeApplication.class, args);
	}

}
