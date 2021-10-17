package exercices;

import java.util.Collections;
import java.util.List;

public class RationalNumber implements Comparable<RationalNumber> {
    private long numerator;
    private long denominator;

    public static final RationalNumber NEGATIVEONE = new RationalNumber(-1);
    public static final RationalNumber ZERO = new RationalNumber(0);
    public static final RationalNumber ONE = new RationalNumber(1);
    public static final RationalNumber TWO = new RationalNumber(2);
    public static final RationalNumber TEN = new RationalNumber(10);

    public RationalNumber(long numerator, long denominator) {
        long gcd = gcd(numerator,denominator);
        this.numerator = numerator/gcd;
        if (denominator == 0) {
            throw new ArithmeticException();
        }
        else {this.denominator = denominator/gcd;}

        if (this.denominator < 0){
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
        }
    }
    public RationalNumber(long value) {
        this.numerator = value;
        this.denominator = 1;
    }
    public RationalNumber add(RationalNumber other) {
        return new RationalNumber((other.denominator * this.numerator)+(this.denominator * other.numerator),this.denominator*other.denominator);
    }

    public RationalNumber multiply(RationalNumber other) {
        return new RationalNumber(this.numerator*other.numerator,this.denominator*other.denominator);
    }

    public int signum(){
        if (this.numerator < 0){return -1;}
        if (this.numerator == 0){return 0;}
        return 1;
    }

    public RationalNumber abs(){
        if (this.numerator < 0){
        return this.multiply(NEGATIVEONE);
        }
        return this;
    }

    public RationalNumber negate(){
        return this.multiply(NEGATIVEONE);
    }

    public RationalNumber subtract(RationalNumber other) {
        return this.add(other.negate());
    }

    public RationalNumber oneOver(){
        if (this.numerator == 0){
            throw new ArithmeticException();
        }
        long denominator=this.numerator;
        long numerator = this.denominator;
        return new RationalNumber(numerator,denominator);
    }
    public RationalNumber divide(RationalNumber other) {
            return this.multiply(other.oneOver());
    }

    public RationalNumber power(long exponent){
       if (exponent >= 0){
           return new RationalNumber((long)Math.pow(this.numerator,exponent),(long)Math.pow(this.denominator,exponent));
        }
       return this.oneOver().power(-exponent);
    }
    public int toInt(){return (int) (this.numerator/this.denominator);}
    public long toLong(){return this.numerator/this.denominator;}
    public double toDouble(){return (double) this.numerator/this.denominator;}

    public static RationalNumber sum(List<RationalNumber> numbers){
        RationalNumber sum = RationalNumber.ZERO;
        for (RationalNumber number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    public static RationalNumber average(List<RationalNumber> numbers){
      return RationalNumber.sum(numbers).divide(new RationalNumber(numbers.size()));
    }

    public static RationalNumber max(List<RationalNumber> numbers) {
        return Collections.max(numbers);
    }

    public static RationalNumber min(List<RationalNumber> numbers) {
        return Collections.min(numbers);
    }

    private static long gcd(long n1 ,long  n2) {
        if ( n2 == 0) {
            return n1 ;
        }
        return gcd ( n2 , n1 % n2 ) ;
    }

    @Override
    public String toString() {
        if (this.denominator == 1) {
            return this.numerator + "";
        }
        if (this.numerator == 0) {
            return "0";
        }
        return this.numerator + "/" + this.denominator;
    }

    @Override
    public int compareTo(RationalNumber o) {
    return Double.compare(this.toDouble(),o.toDouble());
    }
}

