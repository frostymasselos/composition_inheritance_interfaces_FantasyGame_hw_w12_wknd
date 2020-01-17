package characterTypes.player;

import characterTypes.player.Player;
import characterTypes.player.magi.ClericType;
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
        this.revivingTool = revivingTool;
    }

    public String getName () {
        return this.name.getName();
    }

}
