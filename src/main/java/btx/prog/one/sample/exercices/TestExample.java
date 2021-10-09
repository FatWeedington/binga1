package btx.prog.one.sample.exercices;

import java.nio.file.FileSystemNotFoundException;

public class TestExample {
    public static void main(String[] args) {

        RationalNumber a = new RationalNumber(-1,4);
        RationalNumber b = new RationalNumber(2,-4);
        RationalNumber x = new RationalNumber(1, 10);
        RationalNumber y = new RationalNumber(2, 3);
        try {
            RationalNumber z = new RationalNumber(2, 0);
        } catch (ArithmeticException ex) {
            System.out.println("failed to create reference z, denominator can't be 0");
        } //catches ArithmeticException
        System.out.println(x.add(x).add(x).add(x).add(x).add(x).add(x).add(x)); // prints 4/5
        System.out.println(y.multiply(x)); // prints 1/15
        System.out.println(x.multiply(y)); // prints 1/15
        System.out.println(a); // prints -1/4
        System.out.println(b); // prints -1/2
        System.out.println(x.multiply(y).add(x).multiply(y)); // prints 1/9
        System.out.println(x.multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x)); // prints 1/100000000000
        System.out.println(x.divide(y)); // prints 1/9
        System.out.println(x.subtract(x)); // prints 0
        System.out.println(x.subtract(y)); // prints -17/30
        System.out.println(a.subtract(b)); // prints 1/4
        System.out.println(a.divide(b)); // prints 1/2
        System.out.println(a.multiply(RationalNumber.ZERO)); // prints 0
        try {
            System.out.println(a.divide(RationalNumber.ZERO));
        } catch (ArithmeticException ex){
            System.out.println("failed to divide, divide by ZERO is not defined");
        } //catches ArithmeticException
        System.out.println(RationalNumber.ZERO.divide(RationalNumber.ONE));
    }
}