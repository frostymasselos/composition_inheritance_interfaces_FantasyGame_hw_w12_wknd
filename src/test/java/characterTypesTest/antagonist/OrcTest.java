package characterTypesTest.antagonist;

import characterTypes.antagonist.Orc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrcTest {

    private Orc orc;

    public OrcTest() {
        this.orc = new Orc();
    }

    @Test
    public void canGetName () {
        assertEquals("Orc", orc.getName());
    }

    @Test
    public void startsOffAlive () {
        assertEquals(true, orc.checkIfAlive());
    }

    @Test
    public void healthStartsAt30 () {
        assertEquals(30, orc.getHealth());
    }

    @Test
    public void canLooseHealth () {
        orc.looseHealth(1);
        assertEquals(29, orc.getHealth());
        assertEquals(true, orc.checkIfAlive());
    }

    @Test
    public void canDie () {
        orc.looseHealth(30);
        assertEquals(0, orc.getHealth());
//        opportunity to have a 'save person' method and their health's back restored to what it was before'
        assertEquals(false, orc.checkIfAlive());
    }
}
