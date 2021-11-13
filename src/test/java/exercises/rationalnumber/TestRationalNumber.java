package exercises.rationalnumber;

import exercices.rationalnumber.RationalNumber;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TestRationalNumber {

    private RationalNumber a = new RationalNumber(1,2);
    private RationalNumber b = new RationalNumber(3,2);
    private RationalNumber c = new RationalNumber(-1,2);
    private RationalNumber d = new RationalNumber(1,-3);
    private RationalNumber e = new RationalNumber(-5,2);

    private ArrayList<RationalNumber> numbers = new ArrayList<>();

    @Test
    public void testRationalNumber(){
        assertEquals(RationalNumber.TWO,new RationalNumber(2,1));
        assertEquals(RationalNumber.TWO,new RationalNumber(2));
        assertEquals(new RationalNumber(2,4),new RationalNumber(4,8));
        assertThrows(ArithmeticException.class,()->new RationalNumber(1,0));
    }

    @Test
    public void testAdd(){
            assertEquals(RationalNumber.TWO,a.add(b));
            assertEquals(RationalNumber.ZERO,a.add(c));
    }

    @Test
    public void TestMultiply(){
        assertEquals(new RationalNumber(3,4),a.multiply(b));
        assertEquals( new RationalNumber(-1,4),a.multiply(c));

    }

    @Test
    public void TestSignum(){
        assertEquals(1,a.signum());
        assertEquals(-1,c.signum());
    }

    @Test
    public void TestAbs(){
        assertEquals(new RationalNumber(1,2),a.abs());
        assertEquals(new RationalNumber(1,2),c.abs());
    }

    @Test
    public void TestNegate(){
        assertEquals(new RationalNumber(-1,2),a.negate());
        assertEquals(new RationalNumber(1,2),c.negate());
    }

    @Test
    public void TestSubtract(){
        assertEquals(RationalNumber.NEGATIVEONE,a.subtract(b));
        assertEquals(RationalNumber.ONE,a.subtract(c));
    }

    @Test
    public void TestOneover(){
        assertEquals(RationalNumber.TWO,a.oneOver());
        assertEquals(new RationalNumber(-3),d.oneOver());
        assertThrows(ArithmeticException.class, RationalNumber.ZERO::oneOver);
    }

    @Test
    public void TestDivide(){
        assertEquals(new RationalNumber(1,3),a.divide(b));
        assertEquals(RationalNumber.NEGATIVEONE,a.divide(c));
        assertThrows(ArithmeticException.class,()->a.divide(RationalNumber.ZERO));
    }

    @Test
    public void TestPower(){
        assertEquals(new RationalNumber(1,4),a.power(2));
        assertEquals(new RationalNumber(1,4),c.power(2));
        assertEquals(new RationalNumber(-1,8),c.power(3));
    }

    @Test
    public void TestToInt(){
        assertEquals(2,RationalNumber.TWO.toInt());
        assertEquals(-2,e.toInt());
        assertEquals(0,d.toInt());
    }

    @Test
    public void TestToLong(){
        assertEquals(2,RationalNumber.TWO.toLong());
        assertEquals(-2,e.toLong());
        assertEquals(0,d.toLong());
    }

    @Test
    public void TestToDouble(){
        assertEquals(2.0,RationalNumber.TWO.toDouble());
        assertEquals(-0.5,c.toDouble());
        assertEquals(-0.3333333333333333,d.toDouble());
    }

    @Test
    public void TestSum(){
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        numbers.add(d);

        assertEquals(new RationalNumber(7,6),RationalNumber.sum(numbers));
    }

    @Test
    public void TestAverage(){
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        numbers.add(d);

        assertEquals(new RationalNumber(7,24),RationalNumber.average(numbers));
    }

    @Test
    public void TestMax(){
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        numbers.add(d);

        assertEquals(b,RationalNumber.max(numbers));
    }

    @Test
    public void TestMin(){
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        numbers.add(d);

        assertEquals(c,RationalNumber.min(numbers));
    }

    @Test
    public void TestValueOf(){
        assertEquals(new RationalNumber(3,2),RationalNumber.valueof("1.5"));
        assertEquals(new RationalNumber(3,2),RationalNumber.valueof(1.5));
        assertEquals(new RationalNumber(3,2),RationalNumber.valueof("3/2"));
    }

    @Test
    public void TestEval(){
        assertEquals(new RationalNumber(3,2),RationalNumber.eval("1.5"));
        assertEquals(new RationalNumber(27,16),RationalNumber.eval("1.5+3/4_18/5*5/2:4/1^2"));
    }

    @Test
    public void TestCompareTo(){
        assertEquals(-1, a.compareTo(b));
        assertEquals(0, a.compareTo(new RationalNumber(1,2)));
        assertEquals(1, a.compareTo(c));
    }

    @Test
    public void TestEquals(){
        assertTrue(a.equals(new RationalNumber(1,2)));
        assertFalse(a.equals(b));
        assertFalse(a.equals(c));
    }
}
