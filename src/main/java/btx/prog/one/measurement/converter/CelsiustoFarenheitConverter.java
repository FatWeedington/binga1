package btx.prog.one.measurement.converter;

import btx.prog.one.measurement.unit.BasicUnit;
import btx.prog.one.measurement.unit.DerivedUnit;
import btx.prog.one.rationalnumber.RationalNumber;

public class CelsiustoFarenheitConverter extends Converter {

    public CelsiustoFarenheitConverter() {
        super(BasicUnit.CELSIUS,BasicUnit.FARENHEIT);
    }

    @Override
    protected RationalNumber convertValue(RationalNumber value) {
        return value.multiply(RationalNumber.valueof(1.8)).add(new RationalNumber(32));
    }
}
