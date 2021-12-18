package btx.prog.one.measurement.unit;

import java.util.Objects;

public class BasicUnit implements Unit{

    public static final BasicUnit METER = new BasicUnit("meter","m", Type.LENGTH);
    public static final BasicUnit LITER = new BasicUnit("liter","l", Type.VOLUME);
    public static final BasicUnit PASCAL = new BasicUnit("pascal","Pa", Type.PRESSURE);
    public static final BasicUnit GRAMM = new BasicUnit("gramm","G", Type.MASS);
    public static final BasicUnit MILE = new BasicUnit("mile","mil", Type.MASS);
    public static final BasicUnit CELSIUS = new BasicUnit("Celsius","C", Type.MASS);
    public static final BasicUnit FARENHEIT = new BasicUnit("Farenheit","F", Type.MASS);


    private String name;
    private String shortName;
    private Type type;

    public BasicUnit(String name, String shortName, Type Type) {
        this.name = name;
        this.shortName = shortName;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public boolean isCompatible(Unit other) {
        return this.type == (other.getType());
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicUnit)) return false;
        BasicUnit basicUnit = (BasicUnit) o;
        return getName().equals(basicUnit.getName()) && getShortName().equals(basicUnit.getShortName()) && getType() == basicUnit.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getShortName(), getType());
    }
}
