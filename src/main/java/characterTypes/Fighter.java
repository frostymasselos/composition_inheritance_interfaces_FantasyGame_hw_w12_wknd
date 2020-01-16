package characterTypes;

import playerTools.weapon.FighterWeapon;

public abstract class Fighter extends Player {

    private int defense; //choose in sub
    private FighterWeapon weapon; //choose in sub

    public Fighter (int max_Health, int defense, FighterWeapon weapon) {
        super(max_Health);
        this.defense = defense;
        this.weapon = weapon;
    }

    public int getDefense() {
        return defense;
    }

    public FighterWeapon getWeapon() {
        return weapon;
    }

    public void changeWeapon(FighterWeapon weapon) {
        this.weapon = weapon;
    }

    public int attack(){
        System.out.println(this.getName() + " attacks!");
        return this.weapon.getDamage();
    }
}
