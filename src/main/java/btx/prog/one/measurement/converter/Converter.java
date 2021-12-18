package btx.prog.one.measurement.converter;

import btx.prog.one.measurement.quantity.Quantity;
import btx.prog.one.measurement.unit.Unit;
import btx.prog.one.rationalnumber.RationalNumber;

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
}
