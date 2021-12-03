package btx.prog.one.measurement;

public class BasicUnit implements Unit{
    private String name;
    private String shortName;
    private Type Type;

    public BasicUnit(String name, String shortName, Type Type) {
        this.name = name;
        this.shortName = shortName;
        this.Type = Type;
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
        return Type;
    }

    @Override
    public boolean isCompatible(Unit other) {
        if (this.Type.equals(other.getType())) {
            return true;
        } else {
            return false;
        }
    }
}
