package com.bigfatproject.tictactoe;

import com.bigfatproject.Board;

public class TicTacToeBoard extends Board {
	private char winningChar;

	public TicTacToeBoard() {
		this.colsCount = 3;
		this.rowsCount = 3;
		this.winningChar = 0;

		this.boardArray = new char[this.rowsCount][this.colsCount];
		for (int i = 0; i < this.rowsCount; i++) {
			for (int j = 0; j < this.colsCount; j++) {
				boardArray[i][j] = '-';
			}
		}
	}

	@Override
	public boolean hasGameEnded() {
		for (int i = 0; i < this.rowsCount; i++) {
			if (boardArray[i][0] == boardArray[i][1] && boardArray[i][0] == boardArray[i][2] && !isPositionFree(i, 0)) {
				this.setWinningChar(boardArray[i][0]);
				return true;
			}
		}

		for (int i = 0; i < this.rowsCount; i++) {
			if (boardArray[0][i] == boardArray[1][i] && boardArray[0][i] == boardArray[2][i] && !isPositionFree(0, i)) {
				this.setWinningChar(boardArray[0][i]);
				return true;
			}
		}

		if (((boardArray[0][0] == boardArray[1][1] && boardArray[0][0] == boardArray[2][2])
				|| (boardArray[0][2] == boardArray[1][1] && boardArray[0][2] == boardArray[2][0])) && !isPositionFree(1, 1)) {
			this.setWinningChar(boardArray[1][1]);
			return true;
		}

		for (int i = 0; i < this.rowsCount; i++) {
			for (int j = 0; j < this.colsCount; j++) {
				if (boardArray[i][j] == '-') {
					return false;
				}
			}
		}
		
		return true;
	}

	@Override
	public void setChar(char ch, int row, int col) {
		this.boardArray[row][col] = ch;
	}
	
	public boolean isPositionFree(int row, int col){
		return boardArray[row][col] == '-';
	}

	public char getWinningChar() {
		return winningChar;
	}

	private void setWinningChar(char winningChar) {
		this.winningChar = winningChar;
	}
}
