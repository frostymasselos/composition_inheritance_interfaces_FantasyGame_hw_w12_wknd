package playerComponentsTest;

import org.junit.Before;
import org.junit.Test;
import playerComponents.creature.Ogre;

import static org.junit.Assert.assertEquals;

public class OgreTest {
    private Ogre ogre;

    @Before
    public void before() {
        ogre = new Ogre("Shrek");
    }

    @Test
    public void canGetProtection() {
        assertEquals(75, ogre.getHealth());
    }

    @Test
    public void canLooseProtection() {
        ogre.looseHealth(20);
        assertEquals(55, ogre.getHealth());
    }
}
