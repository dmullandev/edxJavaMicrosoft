package edxLearnJava.Module0Basics.ModuleProject;

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class TripPlanner {
    public static final double kmToMile = 0.386102;
    

    public static void main(String[] args) {
        System.out.println("Welcome to Vacation Planner!");
        System.out.println("What is your name?");
        
        Scanner sc = new Scanner(System.in);
        
        String name = sc.nextLine();
        
        System.out.println("Nice to meet you " + name + ", " + "where are you travelling to?");
        
        String city = sc.nextLine();
        
        System.out.println("Great! " + city + " sounds like a great trip");
        
        System.out.println("**********");
        
        System.out.println();
        System.out.println();
    
        
        System.out.println("How many days are you going to spend travelling? ");
        int days = sc.nextInt();
        
        System.out.println("How much money, in USD, are you planning to spend on your trip?");
        int money = sc.nextInt();
        
        System.out.println("What is the three letter currency symbol for your travel destination?");
        String symbol = sc.next();
        
        System.out.println("How many " + symbol + " are there in 1 USD?");
        double conversion = sc.nextDouble();
        
        int daysToHours = days * 24;
        int hoursToMinutes = daysToHours * 60;
        
        System.out.println("If you are travelling for " + days + " days that is the same as " + daysToHours + " hours or " + hoursToMinutes + " minutes");
        
        double dailyAllowance = (double) money / days;
        System.out.printf("If you are going to spend $" + money + " USD that means per day you can spend up to $%.2f\n", dailyAllowance);
        
        
        double totalBudget = money * conversion;
        double dailyBudget = (double) totalBudget / days;
        System.out.printf("Your total budget in " + symbol + " is " + totalBudget + " " + symbol + ", " + "which per day is %.2f\n", dailyBudget);
        
        System.out.println("**********");
        System.out.println();
        System.out.println();
        
        System.out.println("What is the time difference, in hours, between your home and your destination?");
        int timeDifference = sc.nextInt();
        int midDayTimeDifference = 12 + timeDifference;
        System.out.println("That means that when it is midnight at home it will be " + timeDifference + ":00 in your travel destination and when it is noon at home it will be " + midDayTimeDifference + ":00");
        
        System.out.println("**********");
        System.out.println();
        System.out.println();
        
        System.out.println("What is the square area of your destination country in km2?");
        int squareAreaDestination = sc.nextInt();
        double squareRootAreaDestination = sqrt(squareAreaDestination);
        double milesConvertKm = (double) squareRootAreaDestination / kmToMile;
        System.out.println("In miles that is " + milesConvertKm);
        
    }
}
