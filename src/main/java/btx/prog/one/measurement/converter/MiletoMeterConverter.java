package btx.prog.one.measurement.converter;

import btx.prog.one.measurement.unit.BasicUnit;
import btx.prog.one.measurement.unit.DerivedUnit;
import btx.prog.one.rationalnumber.RationalNumber;

public class MiletoMeterConverter extends Converter {

    protected MiletoMeterConverter() {
        super(BasicUnit.MILE, BasicUnit.METER);
    }

    @Override
    protected RationalNumber convertValue(RationalNumber value) {
        return value.multiply(RationalNumber.valueof(1609.34));
    }
}
