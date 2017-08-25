	package com.bigfatproject.tictactoe;

import java.util.Scanner;

import com.bigfatproject.Game;

public class TicTacToeGame extends Game {
	TicTacToeBot bot;
	char humanCh;
	char botCh;
	
	public TicTacToeGame() {
		this.human = new TicTacToeHuman();
		this.bot = new TicTacToeBot();
		this.board = new TicTacToeBoard();
	}
	
	@Override
	public void startGame() {
		boolean isHumansTurn = true;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please choose character: ");
		this.humanCh = Character.toLowerCase(sc.next().charAt(0));
		
		while(!isHumanCharValid()) {
			System.out.print("Please choose character: ");
			this.humanCh = Character.toLowerCase(sc.next().charAt(0));	
		}
		this.botCh = this.humanCh == 'x' ? 'o' : 'x';
		
		board.printBoard();
		while(!board.hasGameEnded()){
			if(isHumansTurn){
				int[] coordinates = human.makeMove();
				
				if(!areCoordinatesValid(coordinates[0], coordinates[1])){
					System.out.println("Invalid coordinates");
					continue;
				}
				
				if(!((TicTacToeBoard)board).isPositionFree(coordinates[0], coordinates[1])){
					System.out.println("This position is not free");
					continue;
				}
				
				board.setChar(humanCh, coordinates[0], coordinates[1]);
			} else {
					int[] coordinates = bot.makeMove();
					
					if(!((TicTacToeBoard)board).isPositionFree(coordinates[0], coordinates[1])){
						continue;
					}
					
					board.setChar(botCh, coordinates[0], coordinates[1]);
					
					board.printBoard();
			}
			
			isHumansTurn = !isHumansTurn;	
		}
		
		if(((TicTacToeBoard)board).getWinningChar() == humanCh){
			System.out.println("Congratulations! You just won!");
		}
		else if(((TicTacToeBoard)board).getWinningChar() == botCh){
			System.out.println("Sorry! You just lost!");
		} else {
			System.out.println("It's a draw");
		}
	}
	
	
	private boolean areCoordinatesValid(int row, int col){
		return row >= 0 && row <= 2 && col >= 0 && col <= 2;
	}
	private boolean isHumanCharValid(){
		return this.humanCh == 'x' || this.humanCh == 'o';
	}
}
