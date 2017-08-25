package com.bigfatproject.foxandhounds;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	void move(Direction direction){
		switch(direction) {
		case UpLeft: x--; y--; break;
		case UpRight: x--; y++; break;
		case DownLeft: x++; y--; break;
		case DownRight: x++; y++; break;
		case Invalid: break;
		}
	}
	
	boolean canMove(Direction direction){
		switch(direction) {
		case UpLeft: 		return x > 0 && y > 0;
		case UpRight: 		return x > 0 && y < 7;
		case DownLeft:		return x < 7 && y > 0;
		case DownRight: 	return x < 7 && y < 7;
		default: return false;
		}
	}
	
	Direction getDirection(Point newPosition){
		if(newPosition.getX() == getX() - 1 && newPosition.getY() == getY() - 1){
			return Direction.UpLeft;
		}
		
		if(newPosition.getX() == getX() - 1 && newPosition.getY() == getY() + 1){
			return Direction.UpRight;
		}
		
		if(newPosition.getX() == getX() + 1 && newPosition.getY() == getY() - 1){
			return Direction.DownLeft;
		}
		
		if(newPosition.getX() == getX() + 1 && newPosition.getY() == getY() + 1){
			return Direction.DownRight;
		}
		
		return Direction.Invalid;
	}
}

