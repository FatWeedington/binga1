package exercices.rationalnumber;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while(!quit){
            System.out.print("> ");
            String expression = scanner.nextLine();

            if (expression.equals("q")) {
                System.out.println("Adé, Merci!");
                quit = true;}
                else{
                RationalNumber result = RationalNumber.eval(expression);
                System.out.println(result);
            }
        }
        scanner.close();
    }
}
