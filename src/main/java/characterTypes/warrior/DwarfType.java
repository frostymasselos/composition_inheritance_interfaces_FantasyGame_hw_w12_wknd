package characterTypes.warrior;

public enum DwarfType {
    GIMLI("Gimli");

    private final String name;

    private DwarfType(String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }
}
