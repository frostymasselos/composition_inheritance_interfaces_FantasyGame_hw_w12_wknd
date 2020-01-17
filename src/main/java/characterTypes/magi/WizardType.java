package characterTypes.magi;

public enum WizardType {

    GANDALF("Gandalf"),
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
