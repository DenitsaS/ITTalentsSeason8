package com.bigfatproject;

public abstract class Board {
	protected char[][] boardArray;
	protected int rowsCount;
	protected int colsCount;
	
	public void printBoard(){
		for (int i = 0; i < this.rowsCount; i++) {
			for (int j = 0; j < this.colsCount; j++) {
				System.out.print(boardArray[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public abstract boolean hasGameEnded();
	public abstract void setChar(char ch, int row , int col);
}
