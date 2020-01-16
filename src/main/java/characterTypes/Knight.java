package characterTypes;

import playerTools.weapon.Sword;
import playerTools.weapon.Weapon;

public class Knight extends Warrior {

    private KnightType name;

    public Knight (KnightType name) {
        super(200, 175, new Sword());
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }

}
