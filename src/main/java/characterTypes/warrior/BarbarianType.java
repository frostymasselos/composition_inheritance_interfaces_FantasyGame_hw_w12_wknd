package characterTypes.warrior;

public enum BarbarianType {

    KINGTHEODEN("King Theoden"),
    ROHAN( "Knight of Rohan");

    private final String name;

    private BarbarianType (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }
}
