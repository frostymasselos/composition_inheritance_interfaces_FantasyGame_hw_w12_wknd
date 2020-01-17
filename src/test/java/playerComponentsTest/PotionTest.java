package playerComponentsTest;

import org.junit.Before;
import org.junit.Test;
import playerComponents.revivalTool.Potion;

import static org.junit.Assert.assertEquals;

public class PotionTest {
    private Potion potion;

    @Before
    public void before() {
        potion = new Potion("Potion");
    }

    @Test
    public void canGetName () {
        assertEquals("Potion", potion.getName());
    }

    @Test
    public void startsFilled () {
        assertEquals(true, potion.isFilled());
    }

    @Test
    public void canGetHealth() {
        assertEquals(45, potion.getAmount());
    }

    @Test
    public void canLooseHealth() {
        potion.pourBottle(20);
        assertEquals(25, potion.getAmount());
    }

}

