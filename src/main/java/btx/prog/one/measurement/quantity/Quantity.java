package btx.prog.one.measurement.quantity;

import btx.prog.one.measurement.unit.Unit;
import btx.prog.one.rationalnumber.RationalNumber;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return Objects.equals(value, quantity.value) && Objects.equals(unit, quantity.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return  value.toDouble() + "[" + unit.getShortName() + ']';
    }
}
