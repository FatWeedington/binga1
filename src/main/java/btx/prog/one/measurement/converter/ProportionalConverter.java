package btx.prog.one.measurement.converter;

import btx.prog.one.measurement.unit.BasicUnit;
import btx.prog.one.measurement.unit.DerivedUnit;
import btx.prog.one.measurement.unit.Unit;
import btx.prog.one.rationalnumber.RationalNumber;

public class ProportionalConverter extends Converter{

    public static final ProportionalConverter METER_TO_KILOMETER_CONVERTER= new ProportionalConverter(BasicUnit.METER, DerivedUnit.KILOMETER,new RationalNumber(1,1000));
    public static final ProportionalConverter MILE_TO_METER_CONVERTER= new ProportionalConverter(BasicUnit.METER, DerivedUnit.KILOMETER,RationalNumber.valueof(1609.34));


    private RationalNumber factor;

    protected ProportionalConverter(Unit sourceUnit, Unit targetUnit, RationalNumber factor) {
        super(sourceUnit, targetUnit);
        this.factor = factor;
    }

    @Override
    protected RationalNumber convertValue(RationalNumber value) {
        return value.multiply(factor);
    }
}
