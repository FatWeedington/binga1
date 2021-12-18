package btx.prog.one.measurement.unit;

public interface Unit {

    public enum Type {
        LENGTH, SURFACE, VOLUME, TEMPERATURE, PRESSURE, TIME, MASS;
    }

    String getName();

    String getShortName();

    Type getType();

    boolean isCompatible(Unit other);
}
