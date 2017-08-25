package com.bigfatproject.foxandhounds;

import java.util.Scanner;

public class FoxAndHoundsHuman extends FoxAndHoundsPlayer {

	@Override
	public int[] makeMove() {
		System.out.print("Please enter two coordinates: ");
		int[] coordinates = new int [2];
		
		Scanner sc = new Scanner(System.in);
		coordinates[0] = sc.nextInt();
		coordinates[1] = sc.nextInt();
		
		return coordinates;

	}

}
