package characterTypesTest;

import characterTypes.Knight;
import characterTypes.KnightType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    private Knight knight;

    @Before
    public void before () {
        knight = new Knight(KnightType.ARAGORN);
    }

    @Test
    public void canGetName () {
        assertEquals("Aragorn", knight.getName());
    }

    @Test
    public void startsOffAlive () {
        assertEquals(true, knight.isAlive());
    }

    @Test
    public void healthStartsAt200 () {
        assertEquals(200, knight.getHealth());
    }

//    @Test
//    public void canGetHealth () {
//        knight.looseHealth(50);
//        assertEquals(150, knight.getHealth());
//        assertEquals(true knight.)
//    }

}
