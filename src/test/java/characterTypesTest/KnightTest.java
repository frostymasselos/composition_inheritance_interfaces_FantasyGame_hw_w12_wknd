package characterTypesTest;

import characterTypes.Knight;
import characterTypes.KnightType;
import org.junit.Before;
import org.junit.Test;
import playerTools.weapon.Axe;
import playerTools.weapon.Weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class KnightTest {

    private Knight knight;
    private Weapon axe;

    @Before
    public void before () {
        knight = new Knight(KnightType.ARAGORN);
        axe = new Axe();
    }

    @Test
    public void canGetName () {
        assertEquals("Aragorn", knight.getName());
    }

    @Test
    public void startsOffAlive () {
        assertEquals(true, knight.isAlive());
    }

    @Test
    public void healthStartsAt200 () {
        assertEquals(200, knight.getHealth());
    }

    @Test
    public void canlooseHealth () {
        knight.looseHealth(50);
        assertEquals(150, knight.getHealth());
        assertEquals(true, knight.isAlive());
    }

    @Test
    public void canDie () {
        knight.looseHealth(200);
        assertEquals(200, knight.getHealth());
//        opportunity to have a 'save person' method and their health's back restored to what it was before'
        assertEquals(false, knight.isAlive());
    }

//    add in defense if you want to.

    @Test
    public void canAddHealth () {
        knight.looseHealth(50);
        knight.gainHealth(30);
        assertEquals(180, knight.getHealth());
    }

    @Test
    public void addingHealthDoesNotSurpassMaxHealth () {
        knight.looseHealth(50);
        knight.gainHealth(60);
        assertEquals(200, knight.getHealth());
    }

    @Test
    public void canGetWeapon () {
        assertEquals("Sword", knight.getWeapon().getName());
    }

    @Test
    public void canChangeWeapon () {
        knight.changeWeapon(axe);
        assertEquals("Axe", knight.getWeapon().getName());
    }

    @Test
    public void wealthStartsOffAtZero () {
        assertEquals(0, knight.getWealth(), 0.01);
    }

    @Test
    public void wealthCanIncrease () {
        knight.addWealth(100);
        assertEquals(100, knight.getWealth(), 0.01);
    }












}
