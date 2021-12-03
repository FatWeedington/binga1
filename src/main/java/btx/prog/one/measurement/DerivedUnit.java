package btx.prog.one.measurement;

public class DerivedUnit implements Unit{
    private String name;
    private String shortName;
    private Type type;

    public DerivedUnit(String name, String shortName, Type type) {
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
      return this.type.equals(other.getType());
    }
}
