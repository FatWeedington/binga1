package btx.prog.one.sample.exercices;

public class RationalNumber implements Comparable<RationalNumber> {

    private long numerator;
    private long denominator;

    public static final RationalNumber MINUSONE = new RationalNumber(-1);
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
        if (this.numerator < 0 && this.denominator < 0){
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
        }
    }

    public RationalNumber(long  value) {
        this.numerator = value;
        this.denominator = 1;

    }

    public RationalNumber add(RationalNumber other) {
        long numerator = (other.denominator * this.numerator)+(this.denominator * other.numerator);
        long denominator = this.denominator*other.denominator;
        RationalNumber res = new RationalNumber(numerator,denominator);
        return res;
    }

    public RationalNumber signum(){
        if (this.numerator >1){
            return MINUSONE;}
        if (this.numerator == 0){
            return ZERO;
        }
        else {return ONE;}
    }

    public RationalNumber abs(){
        RationalNumber res = new RationalNumber(this.numerator,this.denominator);
        if (res.numerator < 0){
            res.numerator = -res.numerator;
        }

        return res;
    }

    public RationalNumber negate(){
        return this.multiply(MINUSONE);
    }

    public RationalNumber multiply(RationalNumber other) {
        long numerator = this.numerator*other.numerator;
        long denominator = this.denominator*other.denominator;
        RationalNumber res = new RationalNumber(numerator,denominator);
        return res;
    }

    public RationalNumber subtract(RationalNumber other) {
        return this.add(other.negate());
    }

    public RationalNumber oneOver(){
        long numerator;
        long denominator;
        denominator=this.numerator;
        numerator = this.denominator;
        RationalNumber res = new RationalNumber(numerator,denominator);
        return res;
    }
    public RationalNumber divide(RationalNumber other) {
        if (other.numerator == 0){
            throw new ArithmeticException();
        }
        else {
            return this.multiply(other.oneOver());
        }
    }

    public RationalNumber power(double exponent){
       if (exponent >= 0){
           return new RationalNumber((long)Math.pow(this.numerator,exponent),(long)Math.pow(this.denominator,exponent));
        }
       return this.oneOver().power(-exponent);
    }

    public int toInt(){
        return (int)this.numerator/(int)this.denominator;
    }
    public long toLong(){
        return this.numerator/this.denominator;
    }
    public double toDouble(){
        return (double) this.numerator/(double) this.denominator;
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
        else if (this.numerator == 0) {
            return "0";
        }
        else return this.numerator + "/" + this.denominator;
    }

    @Override
    public int compareTo(RationalNumber o) {
        return 0;
    }
}

