package exercices.rationalnumber;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>Class which represents any form of rational number displayed by a mathematical fraction of two numbers type long</p>
 * @author Aron Binggeli
 * @version 1.0
 *
 */

public class RationalNumber implements Comparable<RationalNumber> {
    /**
     *<p>Represents a rational number with the value of -1</p>
     */

    public static final RationalNumber NEGATIVEONE = new RationalNumber(-1);

    /**
     *<p>Represents a rational number with the value 0 </p>
     */

    public static final RationalNumber ZERO = new RationalNumber(0);

    /**
     *<p>Represents a rational number with the value 1 </p>
     */

    public static final RationalNumber ONE = new RationalNumber(1);

    /**
     *<p>Represents a rational number with the value 2 </p>
     */

    public static final RationalNumber TWO = new RationalNumber(2);
    
    private long numerator;
    private long denominator;

    /**
     * <p>Constructor which creates an Object of the type RationalNumber the paramaters are represented by numbers type long<p/>
     * @param numerator represents numerator of the fraction
     * @param denominator represents denominator of the  fraction
     */
    public RationalNumber(long numerator, long denominator) {
        long gcd = gcd(numerator,denominator);
        this.numerator = numerator/gcd;
        if (denominator == 0) {
            throw new ArithmeticException();
        }
        else {
            this.denominator = denominator/gcd;
        }

        if (this.denominator < 0) {
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
        }
    }

    /**
     * <p>Constructor which creates an Object of the type RationalNumber the paramater numerator is represented by a number type long, the denominator is always set to 1 <p/>
     * @param value Represents the numerator of the fraction
     */

    public RationalNumber(long value) {
        this.numerator = value;
        this.denominator = 1;
    }

    /**
     * <p>returns a new object from Type RationalNumber representing the mathematical addidtion from own object from Type RationalNumber with another</p>
     * @param other any other Oject from type RationalNumber
     * @return new Oject from type RationalNumber
     */

    public RationalNumber add(RationalNumber other) {
        return new RationalNumber((other.denominator * this.numerator)+(this.denominator * other.numerator),this.denominator*other.denominator);
    }

    /**
     * <p>returns a new object from Type RationalNumber representing the mathematical multiplication from own object from Type RationalNumber with another</p>
     * @param other any other Oject from type RationalNumber
     * @return new Oject from type RationalNumber
     */

    public RationalNumber multiply(RationalNumber other) {
        return new RationalNumber(this.numerator*other.numerator,this.denominator*other.denominator);
    }

    /**
     * <p>returns an integer value from -1 to 1 depending if the own Object is >/=/< 0</p>
     * @return Int value -1 0 or 1
     */

    public int signum(){
        if (this.numerator < 0) {return -1;}
        if (this.numerator == 0) {return 0;}
        return 1;
    }

    /**
     * <p>returns the absolute Value of the own RationalNumber Object</p>
     * @return new Oject from type RationalNumber
     */

    public RationalNumber abs(){
        if (this.numerator < 0){
            return this.multiply(NEGATIVEONE);
        }
        return this;
    }

    /**
     * <p>returns a RationalNumber which represents the own object multipiled by -1</p>
     * @return new Oject from type RationalNumber
     */

    public RationalNumber negate(){
        return this.multiply(NEGATIVEONE);
    }

    /**
     * <p>Returns a new Object of the Type RationalNumber, which is the result of the subtraction of own minus other RationalNumber</p>
     * @param other any other Oject from type RationalNumber
     * @return new Oject from type RationalNumber
     */

    public RationalNumber subtract(RationalNumber other) {
        return this.add(other.negate());
    }

    /**
     * <p>Returns a new Object of Type RationalNumber which represents the reciprocal of given RationalNumber</p>
     * @return new Oject from type RationalNumber
     * @throws ArithmeticException if a Rationalnumber eqals RationalNumber.ZERO is tried to put oneover
     */

    public RationalNumber oneOver(){
        if (this.numerator == 0) {
            throw new ArithmeticException();
        }
        long denominator=this.numerator;
        long numerator = this.denominator;
        return new RationalNumber(numerator,denominator);
    }

    /**
     * <p>returns a new object from Type RationalNumber representing the mathematical division from own object from Type RationalNumber with another</p>
     * @param other any other Oject from type RationalNumber
     * @return new Oject from type RationalNumber
     * @throws ArithmeticException If tried to divide by 0
     */

    public RationalNumber divide(RationalNumber other) {
        if (other.equals(RationalNumber.ZERO)) {
            throw new ArithmeticException();
        }
        else {
            return this.multiply(other.oneOver());
        }
    }

    /**
     * <p>Returns a new Object of type RationalNumber which represents the result of the number powered by the Integer value exponent</p>
     * @param exponent Exponent which is used to power the RationalNumber Object
     * @return new Oject from type RationalNumber
     */

    public RationalNumber power(long exponent){
       if (exponent >= 0) {
           return new RationalNumber((long)Math.pow(this.numerator,exponent),(long)Math.pow(this.denominator,exponent));
       }
       return this.oneOver().power(-exponent);
    }

    /**
     * <p>returns an Integer value by dividing the numerator by the denominator</p>
     * @return Int value
     */
    
    public int toInt(){return (int) this.toLong();}

    /**
     * <p>returns a long value by dividing the numerator by the denominator</p>
     * @return long value
     */
    public long toLong(){return Math.round((float)this.numerator/(float)this.denominator);}

    /**
     * <p>returns a Double value by dividing the numerator by the denominator</p>
     * @return Double value
     */

    public double toDouble(){return 1.0* this.numerator/this.denominator;}

    /**
     * <p>Compares two given RationalNumber Objects by outputting 1, if this>o, a 0 if this=o or -1 if this<o </p>
     * @param o any other Oject from type RationalNumber
     * @return Int value -1, 0 or 1
     */

    @Override
    public int compareTo(RationalNumber o){
        // return Double.compare(this.toDouble(),o.toDouble());
        return this.subtract(o).signum();
    }

    /**
     * <p>Returns a String in the form numerator/denominator </p>
     * @return String in form numerator/denominator
     */

    @Override
    public String toString() {
        if (this.denominator == 1) {
            return this.numerator + "";
        }
        else if (this.numerator == 0) {
            return "0";
        }
        return this.numerator + "/" + this.denominator;
    }

    /**
     * <p>Returns True if both RationalNumber Objects are Equal, and FALSE if they are not</p>
     * @param o numerator/denominator
     * @return boolean True if Object are the same, FALSE if they are different
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RationalNumber that = (RationalNumber) o;
        return numerator == that.numerator && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    /**
     * <p>Takes in a List of Rational Numbers and returns another RationalNumber which represents the sum of all number contained in the List</p>
     * @param numbers List of RationalNumber Objects
     * @return new Oject from type RationalNumber
     */

    public static RationalNumber sum(List<RationalNumber> numbers){
        RationalNumber sum = RationalNumber.ZERO;
        for (RationalNumber number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    /**
     * <p>Takes a list of Objects from Type RationalNumber and returns a new Object from type Rationalnumber, which represents the average of all numbers contained in the given List</p>
     * @param numbers List of RationalNumber Objects
     * @return new Oject from type RationalNumber
     */

    public static RationalNumber average(List<RationalNumber> numbers){
        if (numbers.size() == 0) {
            return null;
        }
        return RationalNumber.sum(numbers).divide(new RationalNumber(numbers.size()));
    }

    /**
     * <p>Takes a list of Objects from Type RationalNumber and returns the Rationalnumber, which represents the maximum Value of all numbers contained in the given List</p>
     * @param numbers List of RationalNumber Objects
     * @return new Oject from type RationalNumber
     */

    public static RationalNumber max(List<RationalNumber> numbers) {
        return Collections.max(numbers);
    }

    /**
     * <p>Takes a list of Objects from Type RationalNumber and returns the Rationalnumber, which represents the minimum Value of all numbers contained in the given List</p>
     * @param numbers List of RationalNumber Objects
     * @return new Oject from type RationalNumber
     */

    public static RationalNumber min(List<RationalNumber> numbers) {
        return Collections.min(numbers);
    }

    private static long gcd(long n1 ,long  n2) {
        if ( n2 == 0) {
            return n1 ;
        }
        return gcd ( n2 , n1 % n2 ) ;
    }

    /**
     * <p>takes an double value input and converts it a rational number</p>
     * @param value double value
     * @return new Oject from type RationalNumber
     */

    public static RationalNumber valueof(double value) {
        String valueString = String.valueOf(value);
        if (!(valueString.contains("."))) {
            return new RationalNumber(Long.parseLong(valueString));
        }
        else{
            String[] values = valueString.split("\\.");
            long num = (long) (Double.parseDouble(valueString)*Math.pow(10,values[1].length()));
            long den = (long) (Math.pow(10,values[1].length()));
            return new RationalNumber(num,den);
      }
    }

    /**
     * <p>takes an String input containing a "/" and splits both of the Values and converts them to a new RationalNumber Object</p>
     * @param valueStr String in form "long value/long value"
     * @return new Oject from type RationalNumber
     */

    public static RationalNumber valueof(String valueStr) {
        valueStr = valueStr.trim();
        if (valueStr.contains("."))
            return RationalNumber.valueof(Double.parseDouble(valueStr));
        else if (!valueStr.contains("/")){
            return new RationalNumber(Long.parseLong(valueStr));
        }
        String[] values = valueStr.split("/");
        return new RationalNumber(Long.parseLong(values[0]),Long.parseLong(values[1]));
    }

    /**
     * <p>Takes a String input, splits it by the signs "+,_,*,:,^" and recalls the method so all operations represented by the signs
     * are executed by the rule point before line operations</p>
     * @param expression String in form "long value/long value+long value/long value_long value/long value*long value/long value:long value/long value^int value"
     * @return new Oject from type RationalNumber
     */

    public static RationalNumber eval(String expression){

        if (expression.contains("+")){
            String[] subExpressions = expression.split("\\+");
            RationalNumber sum = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                sum = sum.add(value);
            }
            return sum;
        }

        if (expression.contains("_")){
            String[] subExpressions = expression.split("_");
            RationalNumber diff = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                diff = diff.subtract(value);
            }
            return diff;
        }

        if (expression.contains("*")){
            String[] subExpressions = expression.split("\\*");
            RationalNumber product = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                product = product.multiply(value);
            }
            return product;
        }

        if (expression.contains(":")){
            String[] subExpressions = expression.split(":");
            RationalNumber quot = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                quot = quot.divide(value);
            }
            return quot;
        }

        if (expression.contains("^")){
            String[] subExpressions = expression.split("\\^");
            RationalNumber pot = eval(subExpressions[0]);
            for(int i = 1 ; i < subExpressions.length;i++){
                RationalNumber value =eval(subExpressions[i]);
                pot = pot.power(value.toLong());
            }
            return pot;
        }
        return RationalNumber.valueof(expression);
    }
}

