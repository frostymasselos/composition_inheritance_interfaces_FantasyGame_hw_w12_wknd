package characterTypes.player.magi;

public enum WizardType {

    GANDALF("Gandlaf"),
    DUMBLEDORE("Dubledore");

    private final String name;
//    private final IPlayer type;

    private WizardType(String name) {
        this.name = name;
//        this.type = type;
    }

    public String getName() {
        return name;
    }

}
