package btx.prog.one.measurement.quantity;

import btx.prog.one.measurement.unit.Unit;
import btx.prog.one.rationalnumber.RationalNumber;

public class Quantity {
    private RationalNumber value;
    private Unit unit;

    public Quantity(RationalNumber value,Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public RationalNumber getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return  value.toDouble() + "[" + unit.getShortName() + ']';
    }
}
