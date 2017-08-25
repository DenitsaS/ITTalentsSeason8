package com.bigfatproject.foxandhounds;

import com.bigfatproject.Board;

public class FoxAndHoundsBoard extends Board {
	private char winningChar;

	public FoxAndHoundsBoard() {
		this.colsCount = 8;
		this.rowsCount = 8;
		this.winningChar = 0;
		this.boardArray = new char[this.rowsCount][this.colsCount];
		for (int i = 0; i < this.rowsCount; i++) {
			for (int j = 0; j < this.colsCount; j++) {
				if((i + j) % 2 == 0){
					boardArray[i][j] = '.';
				} else {
					boardArray[i][j] = 'X';
				}
			}
		}
		boardArray[0][1] = 'H';
		boardArray[0][3] = 'H';
		boardArray[0][5] = 'H';
		boardArray[0][7] = 'H';
		boardArray[7][0] = 'F';

	}

	@Override
	public boolean hasGameEnded() {

		if(boardArray[0][1] == 'F' || boardArray[0][3] == 'F' || boardArray[0][5] == 'F' || boardArray[0][7] == 'F'){
			this.winningChar = 'F';
			return true;
		}
		Point foxPosition = new Point(7,0);
		
		for (int i = 0; i < boardArray.length; i++) {
			for (int j = 0; j < boardArray.length; j++) {
				if(boardArray[i][j] == 'F'){
					foxPosition = new Point(i , j);
					break;
					
				}
			}
		}
		
		boolean canGoUpLeft = foxPosition.getX() > 0 && foxPosition.getY() > 0 && boardArray[foxPosition.getX() - 1][foxPosition.getY() - 1] != 'H';
		boolean canGoUpRight =   foxPosition.getX() > 0 && foxPosition.getY() < 7 && boardArray[foxPosition.getX() - 1][foxPosition.getY() + 1] != 'H';
		boolean canGoDownLeft =  foxPosition.getX() < 7 && foxPosition.getY() > 0 && boardArray[foxPosition.getX() + 1][foxPosition.getY() - 1] != 'H';
		boolean canGoDownRight =  foxPosition.getX() < 7 && foxPosition.getY() < 7 && boardArray[foxPosition.getX() + 1][foxPosition.getY() + 1]!= 'H';
		if(!canGoDownLeft && !canGoDownRight && !canGoUpLeft && !canGoUpRight){
			this.winningChar = 'H';
		}
		
		return false;
	}
	
	@Override
	public void setChar(char ch, int row, int col) {
		
	}
	
	
	public void setChar(char ch, Point oldPos, Direction direction) {
		if(ch == 'H' && oldPos.canMove(direction) && (direction == Direction.DownLeft || direction == Direction.DownRight)){
			boardArray[oldPos.getX()][oldPos.getY()] = 'R' ;
			oldPos.move(direction);
			boardArray[oldPos.getX()][oldPos.getY()] = 'H' ;
		} else if(ch == 'F' && oldPos.canMove(direction)) {
			boardArray[oldPos.getX()][oldPos.getY()] = 'R' ;
			oldPos.move(direction);
			boardArray[oldPos.getX()][oldPos.getY()] = 'F' ;
		}
	}

	public boolean isPositionFree(Point position){
		return boardArray[position.getX()][position.getY()] == 'X';
	}

	public char getWinningChar() {
		return winningChar;
	}

}
