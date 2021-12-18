package measurement;

import btx.prog.one.measurement.converter.*;
import btx.prog.one.measurement.quantity.Quantity;
import btx.prog.one.measurement.unit.BasicUnit;
import btx.prog.one.measurement.unit.DerivedUnit;
import btx.prog.one.rationalnumber.RationalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConverter {
    CelsiustoFarenheitConverter ctf = new CelsiustoFarenheitConverter();
    MeterToKilometerConverter mtkm = new MeterToKilometerConverter();
    MiletoMeterConverter mtm = new MiletoMeterConverter();
    CombinedConverter cmb = new CombinedConverter(mtm,mtkm);
    Converter prp = DerivedUnit.MILLILITER.getDerivedToBasicUnitConverter();

    Quantity c = new Quantity(RationalNumber.ONE,BasicUnit.CELSIUS);
    Quantity m = new Quantity(new RationalNumber(1000),BasicUnit.METER);
    Quantity mil = new Quantity(RationalNumber.ONE,BasicUnit.MILE);
    Quantity ml = new Quantity(new RationalNumber(1000),DerivedUnit.MILLILITER);

    @Test
    public void testconverter(){
        assertEquals(new Quantity(new RationalNumber(169,5),BasicUnit.FARENHEIT),ctf.convert(c));
        assertEquals(new Quantity(new RationalNumber(1),DerivedUnit.KILOMETER),mtkm.convert(m));
        assertEquals(new Quantity(RationalNumber.valueof(1609.34),BasicUnit.METER),mtm.convert(mil));
        assertEquals(new Quantity(RationalNumber.valueof(1.60934),DerivedUnit.KILOMETER),cmb.convert(mil));
        assertEquals(new Quantity(RationalNumber.valueof(1),BasicUnit.LITER),prp.convert(ml));
    }

}
