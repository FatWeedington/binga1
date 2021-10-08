package exercices;

public class TestExample {
    public static void main(String[] args) {

        RationalNumber x = new RationalNumber(1, 10)
        System.out.println(x.add(x).add(x).add(x).add(x).add(x).add(x).add(x)); // p r i n t s 4/5
        RationalNumber y = new RationalNumber(2, 3);
        System.out.println(x.multiply(y)); // p r i n t s 1/15

    }
}
