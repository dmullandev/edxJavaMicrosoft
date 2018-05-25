package edxLearnJava.Module0Basics;

import java.util.Scanner;

public class LearnScanner {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("What is your name?");
        String name = sc.nextLine();
        sc.close();
        System.out.println("Hello " + name);
    }
}
