package btx.prog.one.sample.exercices;

public class TestExample {
    public static void main(String[] args) {

        RationalNumber x = new RationalNumber(1, 10);
        System.out.println(x.add(x).add(x).add(x).add(x).add(x).add(x).add(x)); // prints 4/5
        RationalNumber y = new RationalNumber(2, 3);
        System.out.println(y.multiply(x)); // prints 1/15
        System.out.println(x.multiply(y)); // prints 1/15
        System.out.println(x.multiply(y).add(x).multiply(y)); // prints 1/9
        System.out.println(x.multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x).multiply(x)); // prints 1/100000000000
        RationalNumber z = new RationalNumber(-2, -1);
        RationalNumber a = new RationalNumber(-4, 6);
        RationalNumber b = new RationalNumber(3, -4);
        System.out.println(z.multiply(z));
        System.out.println(z);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.multiply(z));
    }
}
