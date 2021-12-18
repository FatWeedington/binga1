package btx.prog.one.measurement.converter;

import btx.prog.one.measurement.quantity.Quantity;
import btx.prog.one.measurement.unit.BasicUnit;
import btx.prog.one.measurement.unit.DerivedUnit;
import btx.prog.one.measurement.unit.Unit;
import btx.prog.one.rationalnumber.RationalNumber;

public class MeterToKilometerConverter extends Converter {

    protected MeterToKilometerConverter() {
        super(BasicUnit.METER, DerivedUnit.KILOMETER);
    }

    @Override
    protected RationalNumber convertValue(RationalNumber value) {
        return value.divide(new RationalNumber(1000));
    }
}
