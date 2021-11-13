package btx.prog.one.sample;

import exercices.RationalNumber;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TestRationalNumber {

    private RationalNumber a = new RationalNumber(1,2);
    private RationalNumber b = new RationalNumber(3,2);
    private RationalNumber c = new RationalNumber(-1,2);
    private RationalNumber d = new RationalNumber(1,-3);

    private ArrayList<RationalNumber> numbers = new ArrayList<>();



    @Test
    public void testRationalNumber(){
        assertEquals(new RationalNumber(2,1),RationalNumber.TWO);
        assertEquals(new RationalNumber(2),RationalNumber.TWO);
        assertEquals(new RationalNumber(2,4),new RationalNumber(4,8));
        assertThrows(ArithmeticException.class,()->new RationalNumber(1,0));
    }

    @Test
    public void testAdd(){
            assertEquals(a.add(b),RationalNumber.TWO);
            assertEquals(a.add(c),RationalNumber.ZERO);
    }

    @Test
    public void TestMultiply(){
        assertEquals(a.multiply(b),new RationalNumber(3,4));
        assertEquals(a.multiply(c), new RationalNumber(-1,4));

    }

    @Test
    public void TestSignum(){
        assertEquals(a.signum(),1);
        assertEquals(c.signum(),-1);
    }

    @Test
    public void TestAbs(){
        assertEquals(a.abs(),new RationalNumber(1,2));
        assertEquals(c.abs(),new RationalNumber(1,2));
    }

    @Test
    public void TestNegate(){
        assertEquals(a.negate(),new RationalNumber(-1,2));
        assertEquals(c.negate(),new RationalNumber(1,2));
    }

    @Test
    public void TestSubtract(){
        assertEquals(RationalNumber.NEGATIVEONE,a.subtract(b));
        assertEquals(RationalNumber.ONE,a.subtract(c));
    }

    @Test
    public void TestOneover(){
        assertEquals(a.oneOver(),RationalNumber.TWO);
        assertEquals(d.oneOver(),new RationalNumber(-3));
        assertThrows(ArithmeticException.class, RationalNumber.ZERO::oneOver);
    }

    @Test
    public void TestDivide(){
        assertEquals(a.divide(b),new RationalNumber(1,3));
        assertEquals(a.divide(c),RationalNumber.NEGATIVEONE);
        assertThrows(ArithmeticException.class,()->a.divide(RationalNumber.ZERO));
    }

    @Test
    public void TestPower(){
        assertEquals(a.power(2),new RationalNumber(1,4));
        assertEquals(c.power(2),new RationalNumber(1,4));
        assertEquals(c.power(3),new RationalNumber(-1,8));
    }

    @Test
    public void TestToInt(){
        assertEquals(2,RationalNumber.TWO.toInt());
        assertEquals(0,c.toInt());
        assertEquals(0,d.toInt());
    }

    @Test
    public void TestToLong(){
        assertEquals(2,RationalNumber.TWO.toLong());
        assertEquals(0,c.toLong());
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
        assertEquals(0, a.compareTo(a));
        assertEquals(1, a.compareTo(c));
    }

    @Test
    public void TestEquals(){
        assertTrue(a.equals(new RationalNumber(1,2)));
        assertFalse(a.equals(b));
        assertFalse(a.equals(c));
    }
}
