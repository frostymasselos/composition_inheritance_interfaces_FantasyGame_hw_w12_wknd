package gameSetupTest.treasure;

import gameSetup.treasure.Gem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GemTest {

    private Gem gem;

    @Before
    public void before () {
        gem = new Gem();
    }

    @Test
    public void canGetName () {
        assertEquals("Gem", gem.getName());
    }

    @Test
    public void canGenerateCoreWealth () {
        assertEquals (5, gem.getCoreWealth(), 0.01);
    }

    @Test
    public void canGenerateWealth () {
        assertNotNull(gem.getWealth());
        assertEquals(0, gem.getWealth(), 0.01);
    }
}
