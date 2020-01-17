package playerComponentsTest;
import org.junit.Before;
import org.junit.Test;
import playerComponents.fighterWeapon.warriorWeapon.Sword;

import static org.junit.Assert.assertEquals;

public class SwordTest {
    private Sword sword;

    @Before
    public void before() {
        sword = new Sword("Scaliber");
    }

    @Test
    public void canGetName () {
        assertEquals("Scaliber", sword.getName());
    }

    @Test
    public void canGetDamage(){
        assertEquals(35, sword.getDamage());
    }


}
