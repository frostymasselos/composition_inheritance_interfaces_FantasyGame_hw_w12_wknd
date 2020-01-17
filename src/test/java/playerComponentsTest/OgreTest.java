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
    public void canGetName () {
        assertEquals("Shrek", ogre.getName());
    }

    @Test
    public void startsFullHealth () {
        assertEquals(true, ogre.checkIfFullHealth());
    }

    @Test
    public void doesNotSayFullWhenNotFull () {
        ogre.looseHealth(25);
        assertEquals(false, ogre.checkIfFullHealth());
    }

    @Test
    public void canGetHealth() {
        assertEquals(75, ogre.getHealth());
    }

    @Test
    public void canLooseProtection() {
        ogre.looseHealth(20);
        assertEquals(55, ogre.getHealth());
        assertEquals(false, ogre.checkIfFullHealth());
    }

    @Test
    public void willNotPourAsNegativeNumber () {
        ogre.looseHealth(-25);
        assertEquals(75, ogre.getHealth());
    }

    @Test
    public void simplyDiesIfLosesOverwhelmingHealth () {
        ogre.looseHealth(100);
        assertEquals(0, ogre.getHealth());
        assertEquals(false, ogre.checkIfAlive());
    }


}
