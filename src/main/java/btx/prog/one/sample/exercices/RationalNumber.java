package btx.prog.one.sample.exercices;

public class RationalNumber {

    private long numerator;
    private long denominator;

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
        else this.denominator = denominator/gcd;
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

    public RationalNumber multiply(RationalNumber other) {
        long numerator = this.numerator*other.numerator;
        long denominator = this.denominator*other.denominator;
        RationalNumber res = new RationalNumber(numerator,denominator);
        return res;
    }

    public RationalNumber subtract(RationalNumber other) {
        long numerator = (other.denominator * this.numerator)-(this.denominator * other.numerator);
        long denominator = this.denominator*other.denominator;
        RationalNumber res = new RationalNumber(numerator,denominator);
        return res;
    }

    public RationalNumber divide(RationalNumber other) {
        if (other.numerator == 0){
            throw new ArithmeticException();
        }
       else {
            long numerator = this.numerator * other.denominator;
            long denominator = this.denominator * other.numerator;
            RationalNumber res = new RationalNumber(numerator, denominator);
            return res;
        }
    }

    private static long gcd(long n1 ,long n2) {
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
        else if (this.denominator == -1) {
            return "-"+this.numerator* -1+"";
        }
        else if (this.denominator < 0) {
            return "-"+this.numerator  + "/" + this.denominator* -1;
        }
        else if (this.numerator < 0) {
            return "-"+this.numerator* -1 + "/" + this.denominator;
        }

        else if (this.numerator < 0 && this.denominator <0) {
            return "-"+this.numerator* -1 + "/" + this.denominator* -1;
        }

        else return this.numerator + "/" + this.denominator;
    }
    }

