package measurement;

import btx.prog.one.measurement.quantity.Quantity;
import btx.prog.one.measurement.unit.DerivedUnit;
import btx.prog.one.rationalnumber.RationalNumber;

public class TestQuantity {
    public static void main(String[] args) {
        System.out.println(new Quantity(new RationalNumber(1,4), DerivedUnit.MILLILITER));
    }
}

