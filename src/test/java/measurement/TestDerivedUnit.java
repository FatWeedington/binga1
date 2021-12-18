package measurement;

import btx.prog.one.measurement.converter.ProportionalConverter;
import btx.prog.one.measurement.quantity.Quantity;
import btx.prog.one.measurement.unit.BasicUnit;
import btx.prog.one.measurement.unit.DerivedUnit;
import btx.prog.one.measurement.unit.Unit;
import btx.prog.one.rationalnumber.RationalNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestDerivedUnit {
    private BasicUnit bar = new BasicUnit("bar","bar", Unit.Type.PRESSURE);
    private DerivedUnit hectolitre = new DerivedUnit(BasicUnit.LITER, DerivedUnit.Prefix.HEKTO);
    private DerivedUnit millibar = new DerivedUnit(bar, DerivedUnit.Prefix.MILLI);

    @Test
    public void testDerivedUnit(){
     assertEquals(millibar,new DerivedUnit(bar, DerivedUnit.Prefix.MILLI));
     assertEquals(DerivedUnit.KILOGRAMM,new DerivedUnit(BasicUnit.GRAMM,DerivedUnit.Prefix.KILO));
    }

    @Test
    public void testGetName(){
        assertEquals("millibar",millibar.getName());
        assertEquals("hektoliter",hectolitre.getName());
    }

    @Test
    public void testGetShortName(){
        assertEquals("ml",DerivedUnit.MILLILITER.getShortName());
        assertEquals("mbar",millibar.getShortName());
    }

    @Test
    public void testGetType(){
        assertEquals(Unit.Type.VOLUME,hectolitre.getType());
        assertEquals(Unit.Type.PRESSURE,millibar.getType());
    }

    @Test
    public void testGetBasicUnit(){
        assertEquals(BasicUnit.LITER,hectolitre.getBasicUnit());
        assertEquals(bar,millibar.getBasicUnit());
    }

    @Test
    public void testIsCompatible(){
        assertTrue(hectolitre.isCompatible(DerivedUnit.MILLILITER));
        assertFalse(hectolitre.isCompatible(millibar));
    }

    @Test
    public void getFactor(){
        assertEquals(millibar.getFactor(),new RationalNumber(1,1000));
        assertEquals(hectolitre.getFactor(),new RationalNumber(100,1));
    }


    @Test
    public void testGetDeriveToBasicUnitConverter() {
        assertEquals(hectolitre.getDerivedToBasicUnitConverter(), new ProportionalConverter(new DerivedUnit(BasicUnit.LITER, DerivedUnit.Prefix.HEKTO), BasicUnit.LITER, new RationalNumber(100)));
        assertEquals(new Quantity(new RationalNumber(100),BasicUnit.LITER),hectolitre.getDerivedToBasicUnitConverter().convert(new Quantity(RationalNumber.ONE,hectolitre)));
    }

    @Test
    public void testGetBasicToDerivedUnitConverter(){
        assertEquals(new Quantity(new RationalNumber(1),new DerivedUnit(BasicUnit.LITER, DerivedUnit.Prefix.HEKTO)),hectolitre.getBasicUnitToDerivedUnitConverter().convert(new Quantity(new RationalNumber(100),BasicUnit.LITER)));
    }

    @Test
    public void testGetDerivedUnitToDerivedUnitConverter(){
        assertEquals(new Quantity(new RationalNumber(100000),new DerivedUnit(BasicUnit.LITER, DerivedUnit.Prefix.MILLI)),hectolitre.getDerivedcUnitToDerivedUnitConverter(new DerivedUnit(BasicUnit.LITER, DerivedUnit.Prefix.MILLI)).convert(new Quantity(RationalNumber.ONE,hectolitre)));
    }

}
