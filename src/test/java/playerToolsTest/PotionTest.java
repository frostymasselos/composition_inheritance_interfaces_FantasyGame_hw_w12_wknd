package playerToolsTest;

import org.junit.Before;
import org.junit.Test;
import playerTools.reviveable.Potion;

import static org.junit.Assert.assertEquals;

public class PotionTest {
    private Potion potion;

    @Before
    public void before() {
        potion = new Potion();
    }

    @Test
    public void canGetHealth() {
        assertEquals(45, potion.getHealth());
    }

    @Test
    public void canLooseHealth() {
        potion.emptyBottle();
        assertEquals(0, potion.getHealth());
    }

}
