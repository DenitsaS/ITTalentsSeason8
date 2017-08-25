package com.bigfatproject.foxandhounds;

import java.util.Random;

public class FoxAndHoundsBot extends FoxAndHoundsPlayer {
	
	@Override
	public int[] makeMove() {
		Random r = new Random();
		int[] coordinates = new int[2];
		coordinates[0] = point.getX()+1;
		coordinates[1] = point.getY()-1 + 2*r.nextInt(2);
		
		return coordinates;
	
	}

}
