package gameSetup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    private Room room;

    @Before
    public void before () {
        room = new Room();
    }

    @Test
    public void startsWithEmptyArrays () {
        assertEquals(0, room.getPlayers().size());
        assertEquals(0, room.getDeadPlayers().size());
        assertEquals(0, room.getAntagonists().size());
        assertEquals(0, room.getDeadAntagonists().size());
        assertEquals(0, room.getTreasures().size());
    }

}
