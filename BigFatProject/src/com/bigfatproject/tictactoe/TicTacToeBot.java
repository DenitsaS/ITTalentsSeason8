package com.bigfatproject.tictactoe;

import java.util.Random;

public class TicTacToeBot extends TicTacToePlayer {
	
	@Override
	public int[] makeMove() {
		Random r = new Random();
		int[] coordinates = new int [2];
		
		coordinates[0] = r.nextInt(3);
		coordinates[1] = r.nextInt(3);
		
		return coordinates;
	}

}
