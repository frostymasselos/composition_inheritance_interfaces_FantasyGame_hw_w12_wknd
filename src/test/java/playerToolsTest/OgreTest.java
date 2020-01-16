package playerToolsTest;

import org.junit.Before;
import org.junit.Test;
import playerTools.Ogre;

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
}
