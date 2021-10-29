package btx.prog.one.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import exercices.RationalNumber;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TestRationalNumber {
    @Test
    public void testAdd(){
        RationalNumber a = new RationalNumber(1,2);
        RationalNumber b = new RationalNumber(3,2);

        assertEquals(a.add(b),RationalNumber.TWO);

    }

}
