package characterTypes.magi;

public enum WarlockType {

    WARIO("Wario"),
    KONY("Kony");

    private final String name;
//    private final IPlayer type;

    private WarlockType(String name) {
        this.name = name;
//        this.type = type;
    }

    public String getName() {
        return name;
    }

}
