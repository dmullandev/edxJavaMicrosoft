package edxLearnJava.Module0Basics;

public class MethodsExample {

    public static void main(String[] args) {
        message1();
        message2();
    }
    
    public static void message1() {
        System.out.println("This is message1");
        message2();
        double x = 3;
        
        System.out.println((int) x);
    }
    
    public static void message2() {
        System.out.println("This is message2");
    }
}
