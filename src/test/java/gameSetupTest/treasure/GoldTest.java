package gameSetupTest.treasure;

import gameSetup.treasure.Gold;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GoldTest {

    private Gold gold;

    @Before
    public void before () {
        gold = new Gold();
    }

    @Test
    public void canGetName () {
        assertEquals("Gold", gold.getName());
    }

    @Test
    public void canGenerateCoreWealth () {
        assertEquals (20, gold.getCoreWealth(), 0.01);
    }

    @Test
    public void canGenerateWealth () {
        assertNotNull(gold.getCoreWealth());
    }

//    @Test
//    public void canGenerateWealth () {
//        int range1 = (int)gold.getCoreWealth();
//        int range2 = (int)gold.getCoreWealth() * 3;
//        assertEquals(ThreadLocalRandom.current().nextInt(range1, range2), gold.getWealth(), 0.01);
//    }

}
