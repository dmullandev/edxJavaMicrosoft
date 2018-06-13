package edxLearnJava.Module3MazeRunner.FinalProject;

import java.util.Scanner;

public class MazeRunner {
	static Maze myMap;
	static Scanner sc;
	static int moves;
	
	public static void main(String[] args) {
		myMap = new Maze();
		sc = new Scanner(System.in);
		moves = 0;
		intro();
		userMove();
	}
	
	public static void intro() {
		System.out.println("Welcome to Maze Runner!");		
		System.out.println("Here is your current position:");
		
		myMap.printMap();		
	}
	
	public static void userMove() {
		String move;
		while (!myMap.didIWin() && !movesMessage(moves)) {			
			System.out.println("Where would you like to move? (R, L, U, D)");
			move = sc.next();
			movesMessage(moves);
			move = move.toUpperCase();
			myMap.printMap();
			if (move.equals("R") || move.equals("L") || move.equals("U") || move.equals("D")) {
				if (move.equals("R")) {
					if (myMap.canIMoveRight()) {
						myMap.moveRight();
						moves++;
					} else if (myMap.isThereAPit(move)) {
						boolean canNavigate = navigatePit(move);
						
						if (canNavigate) {
							myMap.jumpOverPit(move);
						}
					} else {
						System.out.println("Sorry you've hit a wall going RIGHT");
					}
				} else if (move.equals("L")) {
					if (myMap.canIMoveLeft()) {
						myMap.moveLeft();
						moves++;
					} else if (myMap.isThereAPit(move)) {
						boolean canNavigate = navigatePit(move);
						
						if (canNavigate) {
							myMap.jumpOverPit(move);
						}
					} else {
						System.out.println("Sorry you've hit a wall going LEFT");
					}
				} else if (move.equals("U")) {
					if (myMap.canIMoveUp()) {
						myMap.moveUp();
						moves++;
					} else if (myMap.isThereAPit(move)) {
						boolean canNavigate = navigatePit(move);
						
						if (canNavigate) {
							myMap.jumpOverPit(move);
						}
					} else {
						System.out.println("Sorry you've hit a wall going UP");
					}
				} else if (move.equals("D")) {
					if (myMap.canIMoveDown()) {
						myMap.moveDown();
						moves++;
					} else if (myMap.isThereAPit(move)) {
						boolean canNavigate = navigatePit(move);
						
						if (canNavigate) {
							myMap.jumpOverPit(move);
						}
					} else {
						System.out.println("Sorry you've hit a wall going DOWN");
					}
				}				
			}
		}
		
		if (myMap.didIWin()) {
			System.out.println("Congratulations, you made it out alive!");
		}
	}
	
	public static boolean movesMessage(int moves) {
		if (moves == 99) {
			return true;
		} else if (moves == 89) {
			System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
		} else if (moves == 74) {
			System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape");
		} else if (moves == 50) {
			System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
		}
		return false;
	}
	
	public static boolean navigatePit(String move) {
		System.out.println("Watch out! There's a pit ahead, jump it?");
		String ans = sc.next();
		if (ans.equals("yes")) {
			return true;
		}
		return false;
	}
}