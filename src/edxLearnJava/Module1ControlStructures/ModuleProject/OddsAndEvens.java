package edxLearnJava.Module1ControlStructures.ModuleProject;

import java.util.Random;
import java.util.Scanner;

/**
 * For this project you are going to program a game called "Odds and Evens". 
 * The game is similar to rock paper scissors. 
 * It is played between two players, in your version it will be you versus the computer. 
 * Each player will choose either "odds" or "evens", since you’re playing the computer you will get first pick. 
 * Once you have chosen your side, you each choose a number of fingers to play- 0 to 5. 
 * The winner is determined by whether the sum of your fingers is odd or even (depending on what you chose). 
 * Here's a clip of the game being played: https://youtu.be/4ZOLs03vILs?t=1m
 * @author dan
 *
 */
public class OddsAndEvens {
    static Scanner sc;
    static String name;
    static int userFingers;
    static int computerFingers;
    static int sumFingers;
    static boolean oddOrEven;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        
        System.out.println("Let's play a game called \"Odds and Evens\"");
        askName();
        pickGame();
        stageFormatSeparation();
        fingerCount();
        stageFormatSeparation();
        fingerMath();
        stageFormatSeparation();
        
    }

    public static void askName() {
        System.out.println("What is your name?");
        name = sc.next();
    }
    
    public static void pickGame() {
        System.out.println("Hi " + name + ", which do you choose? (O)dds or (E)vens?");
        
        String type = sc.next();
        boolean gameMode;
        
        if (type.equalsIgnoreCase("o")) {
            gameMode = true;
        } else {
            gameMode = false;
        }
        
        if (gameMode) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        } else {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }        
    }
    
    public static void stageFormatSeparation() {
        System.out.println("------------------------------------------");
        System.out.println("");
    }
    
    public static void fingerCount() {
        System.out.println("How many \"fingers\" do you put out?");
        userFingers = sc.nextInt();
        
        Random rand = new Random();
        computerFingers = rand.nextInt(6);
        System.out.println("The computer plays " + computerFingers + " \"fingers\"");
    }
    
    public static void fingerMath() {
        sumFingers = userFingers + computerFingers;
        System.out.println(userFingers + " + " + computerFingers + " = " + sumFingers);
        oddOrEven = sumFingers % 2 == 0;
        
        if (oddOrEven) {
            System.out.println("topIF");
            System.out.println("Sum of fingers" + "(" + sumFingers + ")" + "is: Even");
            if(userFingers % 2 == 0) {
                System.out.println("That means " + name + " wins! :)");
            } else {
                System.out.println("That means computer wins! :)");
            }
        } else {
            System.out.println("bottomIF");
            System.out.println("Sum of fingers" + "(" + sumFingers + ")" + "is: Odd");
            if(userFingers % 2 == 1) {
                System.out.println("That means " + name + " wins! :)");
            } else {
                System.out.println("That means computer wins! :)");
            }
        }
    }
}
