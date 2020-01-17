package characterTypes.player.magi;

public enum ClericType {

    DRSCOTT("Dr Scott"),
    DRHIBERT("Dr. Hibert"),
    MADAMEBOVARY("Madame Bovary");

    private final String name;
//    private final IPlayer type;

    private ClericType(String name) {
        this.name = name;
//        this.type = type;
    }

    public String getName() {
        return name;
    }

}
