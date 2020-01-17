package characterTypesTest;

import characterTypes.player.Cleric;
import characterTypes.player.ClericType;
import org.junit.Before;
import org.junit.Test;
import playerComponents.revivalTool.Herb;
import playerComponents.revivalTool.Potion;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    private Cleric cleric;

    @Before
    public void before () {
        cleric = new Cleric(new Potion("Potion"), ClericType.DRSCOTT);
    }

    @Test
    public void canGetPotion () {
        assertEquals("Potion", cleric.getRevivingTool().getName());
    }

    @Test
    public void canChangeRevivingTool () {
        cleric.changeRevivingTool(new Herb("Herb"));
        assertEquals("Herb", cleric.getRevivingTool().getName());
    }

}
