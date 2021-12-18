package btx.prog.one.measurement.converter;

import btx.prog.one.measurement.quantity.Quantity;
import btx.prog.one.measurement.unit.Unit;
import btx.prog.one.rationalnumber.RationalNumber;

import java.util.Objects;

public abstract class Converter {
    private Unit sourceUnit;
    private Unit targetUnit;

    protected Converter(Unit sourceUnit, Unit targetUnit) {
        if (!sourceUnit.isCompatible(targetUnit))
            throw new IllegalArgumentException("Incopatible units!");
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
    }

    public Unit getSourceUnit() {
        return sourceUnit;
    }

    public Unit getTargetUnit() {
        return targetUnit;
    }

    public Quantity convert(Quantity quantity) {
        if (!quantity.getUnit().equals(this.getSourceUnit()))
            throw new IllegalArgumentException("Incompatible units!");
        RationalNumber value = quantity.getValue();
        RationalNumber newValue = this.convertValue(value);
        Quantity newQuantity  = new Quantity(newValue,this.getTargetUnit());
        return newQuantity;
    }

    protected abstract RationalNumber convertValue(RationalNumber value);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Converter converter = (Converter) o;
        return Objects.equals(sourceUnit, converter.sourceUnit) && Objects.equals(targetUnit, converter.targetUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceUnit, targetUnit);
    }
}
