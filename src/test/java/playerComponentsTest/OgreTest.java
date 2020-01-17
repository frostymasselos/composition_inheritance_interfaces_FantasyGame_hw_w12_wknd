package playerComponentsTest;

import org.junit.Before;
import org.junit.Test;
import playerComponents.creature.Ogre;

import static org.junit.Assert.assertEquals;

public class OgreTest {
    private Ogre ogre;

    @Before
    public void before() {
        ogre = new Ogre();
    }

    @Test
    public void canGetProtection() {
        assertEquals(75, ogre.getProtection());
    }

    @Test
    public void canLooseProtection() {
        ogre.looseProtection(20);
        assertEquals(55, ogre.getProtection());
    }
}
