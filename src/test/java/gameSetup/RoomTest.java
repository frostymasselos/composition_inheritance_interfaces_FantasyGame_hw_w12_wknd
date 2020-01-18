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
    private Player knight1;
    private Player knight2;
    private Player knight3;
    private Player knight4;
    private Player knight5;
    private Antagonist troll;
    private Treasure gold;

    @Before
    public void before () {
        room = new Room();
        knight1 = new Knight(KnightType.BOROMIR);
        knight2 = new Knight(KnightType.BOROMIR);
        knight3 = new Knight(KnightType.BOROMIR);
        knight4 = new Knight(KnightType.BOROMIR);
        knight5 = new Knight(KnightType.BOROMIR);
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
        room.addToPlayers(knight1);
        room.addToDeadPlayers(knight2);
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
    public void playersCanGetWealthFromTreasureRoom () {
        room.addToPlayers(knight1);
        room.addToPlayers(knight2);
        room.addToPlayers(knight3);
        room.addToPlayers(knight4);
        room.addToPlayers(knight5);
        room.addToTreasures(gold);
        room.addToTreasures(gold);
        room.addToTreasures(gold);
        room.addToTreasures(gold);
        room.addToTreasures(gold);
        room.collectTreasure();
//        WHEN TREASURES GIVE WEALTH, THEY GENERATE A RANDOM AMOUNT. USE DEBUGGER TO CHECK
//        EVERY PLAYER IS ASSIGNED A (DIFFERENT) AMOUNT.
    }

//    @Test
//    public void playersCanFight () {
//        room.addToPlayers(knight1);
//        room.addToPlayers(knight2);
//        room.addToPlayers(knight3);
//        room.addToPlayers(knight4);
//        room.addToPlayers(knight5);
//        room.addToTreasures(gold);
//        room.addToTreasures(gold);
//        room.addToTreasures(gold);
//        room.addToTreasures(gold);
//        room.addToTreasures(gold);
//        room.collectTreasure();
//
//    }



}
