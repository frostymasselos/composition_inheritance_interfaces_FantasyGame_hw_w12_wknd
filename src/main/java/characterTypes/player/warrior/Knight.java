package characterTypes.player.warrior;

//import characterTypes.player.fighter.Fighter;
import playerComponents.fighterWeapon.warriorWeapon.Sword;

public class Knight extends Warrior {

    private KnightType name;

    public Knight (KnightType name) {
        super(200, 175, new Sword("Sword"));
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }

    public void setName () {

    }

}
