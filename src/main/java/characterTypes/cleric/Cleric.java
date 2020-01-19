package characterTypes.cleric;

import characterTypes.Player;
import playerComponents.revivalTool.RevivingTool;

public class Cleric extends Player {

    private ClericType name;
    private RevivingTool revivingTool;

    public Cleric (RevivingTool revivingTool, ClericType name) {
        super(1100);
        this.revivingTool = revivingTool;
        this.name = name;
    }

    public RevivingTool getRevivingTool () {
        return revivingTool;
    }

    public void changeRevivingTool (RevivingTool revivingTool) {
//        and push your current reviving tool to the map?
        this.revivingTool = revivingTool;
    }

    public String getName () {
        return this.name.getName();
    }

    public int attack () {
        return 5;
    }

}
