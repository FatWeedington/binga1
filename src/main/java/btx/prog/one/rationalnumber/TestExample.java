package btx.prog.one.rationalnumber;

import java.util.ArrayList;
import java.util.Arrays;

public class TestExample {
    public static void main(String[] args) {

        RationalNumber a = new RationalNumber(-1,4);
        RationalNumber b = new RationalNumber(2,-4);
        RationalNumber x = new RationalNumber(1, 10);
        RationalNumber y = new RationalNumber(-2, -3);
        RationalNumber p = new RationalNumber(4,-1);
        RationalNumber q = new RationalNumber(0,-1);

        try {
            RationalNumber z = new RationalNumber(2, 0);
        } catch (ArithmeticException ex) {
            System.out.println("failed to create reference z, denominator can't be 0");
        } //catches ArithmeticException
        System.out.println("");
        System.out.println(a); // prints -1/4
        System.out.println(b); // prints -1/2
        System.out.println(x); // prints 1/10
        System.out.println(y); // prints 2/3
        System.out.println(p); // prints -4
        System.out.println(q); // prints 0
        System.out.println("");

        System.out.println(x.add(x).add(x).add(x).add(x).add(x).add(x).add(x)); // prints 4/5
        System.out.println(y.multiply(x)); // prints 1/15
        System.out.println(x.multiply(y)); // prints 1/15
        System.out.println(x.multiply(y).add(x).multiply(y)); // prints 1/9
        System.out.println(x.multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x)); // prints 1/100000000000
        System.out.println("");

        System.out.println(x.divide(y)); // prints 3/20
        System.out.println(x.subtract(x)); // prints 0
        System.out.println(x.subtract(y)); // prints -17/30
        System.out.println(a.subtract(b)); // prints 1/4
        System.out.println(a.divide(b)); // prints 1/2
        System.out.println("");

        System.out.println(a.multiply(RationalNumber.ZERO)); // prints 0
        System.out.println(RationalNumber.ZERO.divide(RationalNumber.ONE));
        try {
            System.out.println(a.divide(RationalNumber.ZERO));
        } catch (ArithmeticException ex){
            System.out.println("failed to divide, divide by ZERO is not defined");
        } //catches ArithmeticException

        System.out.println(a.abs());
        System.out.println(a.oneOver());
        System.out.println(x.power(2));
        System.out.println(x.power(-2));
        System.out.println(x.signum());
        System.out.println("");
        System.out.println(y.toInt());
        System.out.println(y.toLong());
        System.out.println(y.toDouble());
        System.out.println("");

        RationalNumber [] numbers = {
                new RationalNumber (1 ,3) ,
                new RationalNumber (2 ,3) ,
                new RationalNumber (1 ,4) ,
                new RationalNumber (3 ,5)
        };

        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("");
        ArrayList <RationalNumber> number = new ArrayList<>();
        number.add(new RationalNumber(1,2));
        number.add(new RationalNumber(3,-5));
        number.add(new RationalNumber(-4,6));
        number.add(new RationalNumber(9,1));
        number.add(new RationalNumber(-19,3));
        number.add(new RationalNumber(1,2));

        System.out.println(number);
        System.out.println(RationalNumber.sum(number));
        System.out.println(RationalNumber.average(number));
        System.out.println(RationalNumber.max(number));
        System.out.println(RationalNumber.min(number));

        System.out.println(RationalNumber.valueof("12/27"));
        System.out.println(RationalNumber.valueof(-3.14165));
        System.out.println(RationalNumber.valueof(-13));
    }
}
