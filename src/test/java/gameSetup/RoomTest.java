package gameSetup;

import characterTypes.Player;
import characterTypes.antagonist.Antagonist;
import characterTypes.antagonist.Orc;
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
    private Player knight6;
    private Antagonist troll1;
    private Antagonist troll2;
    private Antagonist orc1;
    private Antagonist orc2;
    private Antagonist orc3;
    private Treasure gold1;
    private Treasure gold2;
    private Treasure gold3;
    private Treasure gold4;
    private Treasure gold5;

    @Before
    public void before () {
        room = new Room();
        knight1 = new Knight(KnightType.BOROMIR);
        knight2 = new Knight(KnightType.BOROMIR);
        knight3 = new Knight(KnightType.BOROMIR);
        knight4 = new Knight(KnightType.BOROMIR);
        knight5 = new Knight(KnightType.BOROMIR);
        knight6 = new Knight(KnightType.BOROMIR);
        troll1 = new Troll();
        troll2 = new Troll();
        orc1 = new Orc();
        orc2 = new Orc();
        orc3 = new Orc();
        gold1 = new Gold();
        gold2 = new Gold();
        gold3 = new Gold();
        gold4 = new Gold();
        gold5 = new Gold();
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
        room.addToAntagonists(troll1);
        room.addToDeadAntagonists(troll1);
        room.addToTreasures(gold1);
        assertEquals(1, room.getPlayers().size());
        assertEquals(true, room.checkIfPlayersPopulated());
        assertEquals(1, room.getDeadPlayers().size());
        assertEquals(1, room.getAntagonists().size());
        assertEquals(1, room.getDeadAntagonists().size());
        assertEquals(1, room.getTreasures().size());

    }

    @Test
    public void lessThanFivePlayersCanGetWealthFromTreasureRoom () {
        room.addToPlayers(knight1);
        room.addToPlayers(knight2);
//        room.addToPlayers(knight3);
//        room.addToPlayers(knight4);
//        room.addToPlayers(knight5);
        room.addToTreasures(gold1);
        room.addToTreasures(gold2);
        room.addToTreasures(gold3);
        room.addToTreasures(gold4);
        room.addToTreasures(gold5);
//        room.iterate();
        room.collectTreasure();
//        room.collectTreasureEasy();
//        WHEN TREASURES GIVE WEALTH, THEY GENERATE A RANDOM AMOUNT. USE DEBUGGER TO CHECK
//        EVERY PLAYER IS ASSIGNED A (DIFFERENT) AMOUNT.
    }

    @Test
    public void playersCanFight () {
        room.addToPlayers(knight1);
        room.addToPlayers(knight2);
        room.addToPlayers(knight3);
        room.addToPlayers(knight4);
        room.addToPlayers(knight5);
        room.addToAntagonists(troll1);
        room.addToAntagonists(troll2);
        room.addToAntagonists(orc1);
        room.addToAntagonists(orc2);
        room.addToAntagonists(orc3);
        room.playerAttack();
    }
}

