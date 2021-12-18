package btx.prog.one.measurement.unit;

import btx.prog.one.rationalnumber.RationalNumber;

import java.util.Objects;

public class DerivedUnit implements Unit{

    public static final DerivedUnit MILLIMETER = new DerivedUnit(BasicUnit.METER,Prefix.MILLI);
    public static final DerivedUnit KILOMETER = new DerivedUnit(BasicUnit.METER,Prefix.KILO);
    public static final DerivedUnit MILLILITER = new DerivedUnit(BasicUnit.LITER,Prefix.MILLI);
    public static final DerivedUnit HEKTOPASCAL = new DerivedUnit(BasicUnit.PASCAL,Prefix.HEKTO);
    public static final DerivedUnit KILOGRAMM = new DerivedUnit(BasicUnit.GRAMM,Prefix.KILO);

    public enum Prefix{
        GIGA,MEGA,KILO,HEKTO,DEKA,DECI,CENTI,MILLI,MICRO,NANO
    }

    private BasicUnit basicUnit;
    private Prefix prefix;

    public DerivedUnit(BasicUnit basicUnit, Prefix prefix) {
        this.basicUnit = basicUnit;
        this.prefix = prefix;
    }

    public BasicUnit getBasicUnit(){
        return this.basicUnit;
    }

    public RationalNumber getFactor(){
        return switch (this.prefix){
            case GIGA -> new RationalNumber(100000,1);
            case MEGA -> new RationalNumber(10000,1);
            case KILO -> new RationalNumber(1000,1);
            case HEKTO -> new RationalNumber(100,1);
            case DEKA -> new RationalNumber(10,1);
            case DECI -> new RationalNumber(1,10);
            case CENTI -> new RationalNumber(1,100);
            case MILLI -> new RationalNumber(1,1000);
            case MICRO -> new RationalNumber(1,10000);
            case NANO -> new RationalNumber(1,100000);
            default -> null;
        };
    }

    @Override
    public String getName() {
        return prefix.name().toLowerCase()+basicUnit.getName();
    }

    @Override
    public String getShortName() {
        String prefix = switch (this.prefix){
            case GIGA -> "G";
            case MEGA -> "M";
            case KILO -> "K";
            case HEKTO -> "H";
            case DEKA -> "D";
            case DECI -> "d";
            case CENTI -> "c";
            case MILLI -> "m";
            case MICRO -> "μ";
            case NANO -> "n";
            default -> null;
        };
        return prefix + this.basicUnit.getShortName();
    }

    @Override
    public Type getType() {
        return basicUnit.getType();
    }

    @Override
    public boolean isCompatible(Unit other) {
      return this.basicUnit.isCompatible(other);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DerivedUnit)) return false;
        DerivedUnit that = (DerivedUnit) o;
        return getBasicUnit().equals(that.getBasicUnit()) && prefix == that.prefix;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBasicUnit(), prefix);
    }
}
