package exercices;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
    public int toInt(){return (int) this.toLong();}
    public long toLong(){return this.numerator/this.denominator;}
    public double toDouble(){return 1.0* this.numerator/this.denominator;}

    public static RationalNumber sum(List<RationalNumber> numbers){
        RationalNumber sum = RationalNumber.ZERO;
        for (RationalNumber number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    public static RationalNumber average(List<RationalNumber> numbers){
        if (numbers.size() == 0)
                return null;
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

    public static RationalNumber valueof(double value) {
        for (long i= 1; i < Long.MAX_VALUE;i*=10){
            if (i*value % 1 == 0)
                return new RationalNumber((long)(i*value),i);
        }
           return null;
    }

    public static RationalNumber valueof(String valueStr) {
       valueStr = valueStr.trim();
       if (valueStr.contains("."))
           return RationalNumber.valueof(Long.valueOf(valueStr));
       if (!valueStr.contains("/")){
            return new RationalNumber(Long.valueOf(valueStr));
        }
       
        String[] values = valueStr.split("/");
        long num = Long.valueOf(values[0]);
        long den = Long.valueOf(values[1]);
        return new RationalNumber(num,den);
    }

    public static RationalNumber eval(String expression){
        if (expression.contains("+")){
            String[] subExpressions = expression.split("\\+");
            RationalNumber sum = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                sum = sum.add(value);}
            return sum;
        }

        if (expression.contains("_")){
            String[] subExpressions = expression.split("_");
            RationalNumber diff = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                diff = diff.subtract(value);}
            return diff;
        }

        if (expression.contains("*")){
            String[] subExpressions = expression.split("\\*");
            RationalNumber product = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                product = product.multiply(value);}
            return product;
        }

        if (expression.contains(":")){
            String[] subExpressions = expression.split("\\:");
            RationalNumber quot = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                quot = quot.divide(value);}
            return quot;
        }

        if (expression.contains("^")){
            String[] subExpressions = expression.split("\\^");
            RationalNumber pot = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                pot = pot.power(value.toLong());}
            return pot;
        }

                return RationalNumber.valueof(expression);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RationalNumber)) return false;
        RationalNumber that = (RationalNumber) o;
        return numerator == that.numerator && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public int compareTo(RationalNumber o) {
    // return Double.compare(this.toDouble(),o.toDouble());
    return this.subtract(o).signum();

    }
}

