package com.bigfatproject.foxandhounds;

import java.util.Random;

import com.bigfatproject.Game;

public class FoxAndHoundsGame extends Game {
	FoxAndHoundsBot[] bots;
	
	public FoxAndHoundsGame() {
		bots = new FoxAndHoundsBot[4];
		human = new FoxAndHoundsHuman();
		
		human = new FoxAndHoundsHuman();
		bots[0] = new FoxAndHoundsBot();
		bots[1] = new FoxAndHoundsBot();
		bots[2] = new FoxAndHoundsBot();
		bots[3] = new FoxAndHoundsBot();
		
		bots[0].point = new Point(0, 1);
		bots[1].point = new Point(0, 3);
		bots[2].point = new Point(0, 5);
		bots[3].point = new Point(0, 7);
		((FoxAndHoundsHuman)human).point = new Point(7, 0);
		
		board = new FoxAndHoundsBoard();
	}
	
	@Override
	public void startGame() {
		boolean isHumansTurn = true;
		
		board.printBoard();
		while(!board.hasGameEnded()){
			if(isHumansTurn){
				int[] coordinates = human.makeMove();
				Point newPosition = new Point(coordinates[0], coordinates[1]);
				if(!areCoordinatesValid(newPosition)){
					System.out.println("Invalid coordinates");
					continue;
				}
				
				Direction direction = ((FoxAndHoundsHuman)human).point.getDirection(newPosition);

				if(direction == Direction.Invalid) {
					System.out.println("Invalid direction");
					continue;
				}
				
				if(!((FoxAndHoundsBoard)board).isPositionFree(newPosition)){
					System.out.println("This position is not free");
					continue;
				}
			
				((FoxAndHoundsBoard)board).setChar('F', ((FoxAndHoundsHuman)human).point, direction);
			} else {
				Random r = new Random();
				int botIndex = r.nextInt(4);
				int[] coordinates = bots[botIndex].makeMove();
				Point newPosition = new Point(coordinates[0], coordinates[1]);
				
				if(!areCoordinatesValid(newPosition)){
					continue;
				}
				
				Direction direction = ((FoxAndHoundsBot)bots[botIndex]).point.getDirection(newPosition);

				if(!((FoxAndHoundsBoard)board).isPositionFree(newPosition)){
					continue;
				}
					
				((FoxAndHoundsBoard)board).setChar('H', bots[botIndex].point, direction);
				board.printBoard();
			}
			
			isHumansTurn = !isHumansTurn;	
		}
		
		if(((FoxAndHoundsBoard)board).getWinningChar() == 'F'){
			System.out.println("Congratulations! You just won!");
		}
		else if(((FoxAndHoundsBoard)board).getWinningChar() == 'H'){
			System.out.println("Sorry! You just lost!");
		} else {
			System.out.println("It's a draw");
		}
	}
	

	private boolean areCoordinatesValid(Point position){
		return (position.getX() >= 0 && position.getX() <= 7  && position.getY() >= 0 && position.getY() <= 7) &&
				(position.getX() + position.getY()) % 2 != 0;
	}

}
