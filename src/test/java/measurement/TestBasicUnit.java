package measurement;

import btx.prog.one.measurement.BasicUnit;
import btx.prog.one.measurement.Unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBasicUnit {

    private BasicUnit pascal = new BasicUnit("pascal","Pa", Unit.Type.PRESSURE);
    private BasicUnit meter = new BasicUnit("meter","m", Unit.Type.LENGTH);
    private BasicUnit bar = new BasicUnit("bar","bar", Unit.Type.PRESSURE);

    @Test
    public void TestBasicUnit(){
        assertEquals(BasicUnit.PASCAL,new BasicUnit("pascal","Pa", Unit.Type.PRESSURE));
        assertEquals(BasicUnit.METER,new BasicUnit("meter","m", Unit.Type.LENGTH));
    }

    @Test
    public void TestGetName(){
        assertEquals("pascal",pascal.getName());
        assertEquals("meter",meter.getName());
    }

    @Test
    public void TestGetShortName(){
        assertEquals("Pa",pascal.getShortName());
        assertEquals("m",meter.getShortName());
    }


    @Test
    public void TestGetType(){
        assertEquals(Unit.Type.PRESSURE,pascal.getType());
        assertEquals(Unit.Type.LENGTH,meter.getType());
    }

    @Test
    public void TestIsCompatible(){
        assertTrue(pascal.isCompatible(bar));
        assertFalse(pascal.isCompatible(meter));
    }

    @Test
    public void ToString(){
        assertEquals("pascal",pascal.toString());
        assertEquals("bar",bar.toString());
    }

    }
