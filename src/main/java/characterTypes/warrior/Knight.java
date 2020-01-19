package characterTypes.warrior;

//import characterTypes.player.fighter.Fighter;
import playerComponents.warriorWeapon.Sword;

public class Knight extends Warrior {

    private KnightType name;

    public Knight (KnightType name) {
        super(200, 70, new Sword("Sword"));
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }

}
