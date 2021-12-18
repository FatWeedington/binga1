package measurement;

import btx.prog.one.measurement.converter.*;
import btx.prog.one.measurement.unit.BasicUnit;
import btx.prog.one.measurement.unit.DerivedUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestConverterSupplier {

    @Test
    public void testPut(){
        assertTrue(ConverterSupplier.put(new MeterToKilometerConverter()));
        ConverterSupplier.put(new MeterToKilometerConverter());
        assertFalse(ConverterSupplier.put(new MeterToKilometerConverter()));
        ConverterSupplier.clear();
    }

    @Test
    public void testGet(){
        ConverterSupplier.put(new MeterToKilometerConverter());
        ConverterSupplier.put(new MiletoMeterConverter());
        ConverterSupplier.put(new CelsiustoFarenheitConverter());

        assertEquals(new MeterToKilometerConverter(),ConverterSupplier.get(BasicUnit.METER, DerivedUnit.KILOMETER));
        assertNull(ConverterSupplier.get(BasicUnit.PASCAL, new DerivedUnit(BasicUnit.PASCAL, DerivedUnit.Prefix.HEKTO)));
        assertEquals(new MeterToKilometerConverter(),ConverterSupplier.get(DerivedUnit.KILOMETER.getBasicUnitToDerivedUnitConverter()));

        ConverterSupplier.clear();
    }
}
