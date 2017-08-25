package com.bigfatproject.foxandhounds;

import com.bigfatproject.Board;

public class FoxAndHoundsBoard extends Board {
	private char winningChar;
	private char blackChar = 'X';
	private char redChar = '.';
	private char foxChar = 'F';
	private char houndChar = 'H';
	public FoxAndHoundsBoard() {
		
		this.colsCount = 8;
		this.rowsCount = 8;
		this.winningChar = 0;
		this.boardArray = new char[this.rowsCount][this.colsCount];
		for (int i = 0; i < this.rowsCount; i++) {
			for (int j = 0; j < this.colsCount; j++) {
				if((i + j) % 2 == 0){
					boardArray[i][j] = redChar;
				} else {
					boardArray[i][j] = blackChar;
				}
			}
		}
		boardArray[0][1] = houndChar;
		boardArray[0][3] = houndChar;
		boardArray[0][5] = houndChar;
		boardArray[0][7] = houndChar;
		boardArray[7][0] = foxChar;

	}

	@Override
	public boolean hasGameEnded() {

		if(boardArray[0][1] == foxChar || boardArray[0][3] == foxChar || boardArray[0][5] == foxChar || boardArray[0][7] == foxChar){
			this.winningChar = foxChar;
			return true;
		}
		Point foxPosition = new Point(7,0);
		
		for (int i = 0; i < boardArray.length; i++) {
			for (int j = 0; j < boardArray.length; j++) {
				if(boardArray[i][j] == foxChar){
					foxPosition = new Point(i , j);
					break;
					
				}
			}
		}
		
		boolean canGoUpLeft = foxPosition.getX() > 0 && foxPosition.getY() > 0 && boardArray[foxPosition.getX() - 1][foxPosition.getY() - 1] != houndChar;
		boolean canGoUpRight =   foxPosition.getX() > 0 && foxPosition.getY() < 7 && boardArray[foxPosition.getX() - 1][foxPosition.getY() + 1] != houndChar;
		boolean canGoDownLeft =  foxPosition.getX() < 7 && foxPosition.getY() > 0 && boardArray[foxPosition.getX() + 1][foxPosition.getY() - 1] != houndChar;
		boolean canGoDownRight =  foxPosition.getX() < 7 && foxPosition.getY() < 7 && boardArray[foxPosition.getX() + 1][foxPosition.getY() + 1]!= houndChar;
		if(!canGoDownLeft && !canGoDownRight && !canGoUpLeft && !canGoUpRight){
			this.winningChar = houndChar;
		}
		
		return false;
	}
	
	@Override
	public void setChar(char ch, int row, int col) {
		
	}
	
	
	public void setChar(char ch, Point oldPos, Direction direction) {
		if(ch == houndChar && oldPos.canMove(direction) && (direction == Direction.DownLeft || direction == Direction.DownRight)){
			boardArray[oldPos.getX()][oldPos.getY()] = blackChar ;
			oldPos.move(direction);
			boardArray[oldPos.getX()][oldPos.getY()] = houndChar ;
		} else if(ch == foxChar && oldPos.canMove(direction)) {
			boardArray[oldPos.getX()][oldPos.getY()] = blackChar ;
			oldPos.move(direction);
			boardArray[oldPos.getX()][oldPos.getY()] = foxChar ;
		}
	}

	public boolean isPositionFree(Point position){
		return boardArray[position.getX()][position.getY()] == 'X';
	}

	public char getWinningChar() {
		return winningChar;
	}

}
