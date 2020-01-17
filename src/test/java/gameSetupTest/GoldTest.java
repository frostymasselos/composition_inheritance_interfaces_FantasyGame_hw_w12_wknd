package gameSetupTest;

import gameSetup.Gold;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

}
