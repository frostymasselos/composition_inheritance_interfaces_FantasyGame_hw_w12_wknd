package gameSetup;

import characterTypes.Player;
import characterTypes.antagonist.Antagonist;
import characterTypes.antagonist.Troll;
import characterTypes.warrior.Knight;
import characterTypes.warrior.KnightType;
import gameSetup.treasure.Gold;
import gameSetup.treasure.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    private Room room;
    private Player knight;
    private Antagonist troll;
    private Treasure gold;

    @Before
    public void before () {
        room = new Room();
        knight = new Knight(KnightType.BOROMIR);
        troll = new Troll();
        gold = new Gold();
    }

    @Test
    public void startsWithEmptyArrays () {
        assertEquals(0, room.getPlayers().size());
        assertEquals(false, room.checkIfPlayersPopulated());
        assertEquals(0, room.getDeadPlayers().size());
        assertEquals(0, room.getAntagonists().size());
        assertEquals(0, room.getDeadAntagonists().size());
        assertEquals(0, room.getTreasures().size());
    }

    @Test
    public void everyArrayCanBeAddedTo () {
        room.addToPlayers(knight);
        room.addToDeadPlayers(knight);
        room.addToAntagonists(troll);
        room.addToDeadAntagonists(troll);
        room.addToTreasures(gold);
        assertEquals(1, room.getPlayers().size());
        assertEquals(true, room.checkIfPlayersPopulated());
        assertEquals(1, room.getDeadPlayers().size());
        assertEquals(1, room.getAntagonists().size());
        assertEquals(1, room.getDeadAntagonists().size());
        assertEquals(1, room.getTreasures().size());

    }

    @Test
    public void returnsFalseWhenPlayersPopulated () {

    }

}
