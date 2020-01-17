package characterTypesTest.antagonist;

import characterTypes.antagonist.Troll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrollTest {

    private Troll troll;

    @Before
    public void before () {
        troll = new Troll();
    }

    @Test
    public void canGetName () {
        assertEquals("Troll", troll.getName());
    }

    @Test
    public void startsOffAlive () {
        assertEquals(true, troll.checkIfAlive());
    }

    @Test
    public void healthStartsAt175 () {
        assertEquals(175, troll.getHealth());
    }

    @Test
    public void canLooseHealth () {
        troll.looseHealth(1);
        assertEquals(174, troll.getHealth());
        assertEquals(true, troll.checkIfAlive());
    }

    @Test
    public void canDie () {
        troll.looseHealth(175);
        assertEquals(0, troll.getHealth());
//        opportunity to have a 'save person' method and their health's back restored to what it was before'
        assertEquals(false, troll.checkIfAlive());
    }

}
