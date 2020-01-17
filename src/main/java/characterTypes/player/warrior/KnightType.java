package characterTypes.player.warrior;

public enum KnightType {
    ARAGORN("Aragorn"),
    BOROMIR("Boromir");

    private final String name;
//    private final IPlayer type;

    private KnightType(String name) {
        this.name = name;
//        this.type = type;
    }

    public String getName() {
        return name;
    }

//    public IPlayer getPlayerType() {
//        return this.type;
//    }

}
