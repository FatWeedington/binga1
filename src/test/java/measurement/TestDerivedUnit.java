package measurement;

import btx.prog.one.measurement.BasicUnit;
import btx.prog.one.measurement.DerivedUnit;
import btx.prog.one.measurement.Unit;
import btx.prog.one.rationalnumber.RationalNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestDerivedUnit {
    private BasicUnit bar = new BasicUnit("bar","bar", Unit.Type.PRESSURE);
    private DerivedUnit hectolitre = new DerivedUnit(BasicUnit.LITER, DerivedUnit.Prefix.HEKTO);
    private DerivedUnit millibar = new DerivedUnit(bar, DerivedUnit.Prefix.MILLI);

    @Test
    public void TestDerivedUnit(){
     assertEquals(millibar,new DerivedUnit(bar, DerivedUnit.Prefix.MILLI));
     assertEquals(DerivedUnit.KILOGRAMM,new DerivedUnit(BasicUnit.GRAMM,DerivedUnit.Prefix.KILO));
    }

    @Test
    public void TestGetName(){
        assertEquals("millibar",millibar.getName());
        assertEquals("hektoliter",hectolitre.getName());
    }

    @Test
    public void TestGetShortName(){
        assertEquals("ml",DerivedUnit.MILLILITER.getShortName());
        assertEquals("mbar",millibar.getShortName());
    }

    @Test
    public void TestGetType(){
        assertEquals(Unit.Type.VOLUME,hectolitre.getType());
        assertEquals(Unit.Type.PRESSURE,millibar.getType());
    }

    @Test
    public void TestGetBasicUnit(){
        assertEquals(BasicUnit.LITER,hectolitre.getBasicUnit());
        assertEquals(bar,millibar.getBasicUnit());
    }

    @Test
    public void TestIsCompatible(){
        assertTrue(hectolitre.isCompatible(DerivedUnit.MILLILITER));
        assertFalse(hectolitre.isCompatible(millibar));
    }

    @Test
    public void getFactor(){
        assertEquals(millibar.getFactor(),new RationalNumber(1,1000));
        assertEquals(hectolitre.getFactor(),new RationalNumber(100,1));
    }

    @Test
    public void ToString(){

    }
}
