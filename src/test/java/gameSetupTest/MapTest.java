package gameSetupTest;

import characterTypes.Player;
import characterTypes.cleric.Cleric;
import characterTypes.magi.Warlock;
import characterTypes.magi.WarlockType;
import characterTypes.magi.Wizard;
import characterTypes.magi.WizardType;
import characterTypes.warrior.Knight;
import characterTypes.warrior.KnightType;
import gameSetup.Map;
import gameSetup.Room;
import gameSetup.treasure.Treasure;
import org.junit.Before;
import org.junit.Test;
import playerComponents.revivalTool.Herb;
import playerComponents.revivalTool.Potion;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MapTest {

    private Map map;
    private Map map2;
    private Knight knight1;
    private Knight knight2;
    private Knight knight3;
    private Wizard wizard;
    private Wizard wizard2;

    @Before
    public void before () {
        map = new Map(new ArrayList<Player>());
        map2 = new Map(new ArrayList<Player>());
        knight1 = new Knight(KnightType.ARAGORN);
        knight2 = new Knight(KnightType.BOROMIR);
        knight3 = new Knight(KnightType.ARAGORN);
        wizard = new Wizard(WizardType.GANDALF);
        wizard2 = new Wizard(WizardType.DUMBLEDORE);

        map.addPlayerToHome(knight1);
        map.addPlayerToHome(knight2);
        map.addPlayerToHome(knight3);
        map.addPlayerToHome(wizard);
        map.addPlayerToHome(wizard2);

        map2.addPlayerToHome(knight1);
//        map2.addPlayerToHome(knight2);
//        map2.addPlayerToHome(knight3);
//        map2.addPlayerToHome(wizard);
//        map2.addPlayerToHome(wizard2);

        map.addRoom();
        map2.addRoom();
    }

    @Test
    public void playersCanBeAddedToHome () {
        assertEquals(5, map.getHome().size());
    }

    @Test
    public void mapCanRemoveRoom () {
        map.removeFirstRoom();
        assertEquals(0, map.getBattleRooms().size());
    }

    @Test
    public void mapWillAlwaysMakeFiveTreasuresInRoom () {

        map.populateBattleRoomWithTreasure();
        assertEquals(5, map.getBattleRooms().get(0).getTreasures().size());
    }

    @Test
    public void mapWillAlwaysMakeFiveAntagonistsInRoom () {
        map.populateBattleRoomWithAntagonists();
        assertEquals(5, map.getBattleRooms().get(0).getAntagonists().size());
    }

    @Test
    public void mapWillSendCharactersInHomeToRoom () {
        map.sendCharactersToRoom();
        assertEquals(0, map.getHome().size());
        assertEquals(5, map.getBattleRooms().get(0).getPlayers().size());
    }

    @Test
    public void mapCanTriggerFight () {
        map.populateBattleRoomWithTreasure();
        map.populateBattleRoomWithAntagonists();
        map.sendCharactersToRoom();
        map.triggerFight();

        assertEquals(5, map.getBattleRooms().get(0).getDeadAntagonists().size());
    }

    @Test
    public void mapWillPlaceDeadAntagonistsInTrophy () {
        map.populateBattleRoomWithTreasure();
        map.populateBattleRoomWithAntagonists();
        map.sendCharactersToRoom();
        map.triggerFight();
        map.getDeadAntagonistsIntoTrophy();

        assertEquals(5, map.getTrophies().size());
    }

    @Test
    public void mapWillPlaceDeadPlayersInGraveyard () {
        map2.populateBattleRoomWithTreasure();
        map2.populateBattleRoomWithAntagonists();
        map2.sendCharactersToRoom();
        map2.triggerFight();
        map2.getDeadPlayersIntoGraveyard();

        assertEquals(1, map2.getGraveyard().size());
    }

    @Test
    public void mapCanGetPlayersBackFromRoom () {
        map.sendCharactersToRoom();
        map.getPlayersBackFromRoom();
        assertEquals(0, map.getBattleRooms().get(0).getPlayers().size());
        assertEquals(5, map.getHome().size());
    }

//    @Test
//    public void mapCanTriggerPlayersToCollectTreasure () {
//        map.populateBattleRoomWithTreasure();
//        map.populateBattleRoomWithAntagonists();
//        map.sendCharactersToRoom();
//        map.triggerFight();
//        map.triggerCollectTreasure();
//        map.getPlayersBackFromRoom();
//        map.addToWealthPot();
//        assertEquals(100, map.getWealth());
//        //Random generated: should just give assertion error.
//    }

//    @Test
//    public void mapCanCalculatePoints () {
//        map.populateBattleRoomWithTreasure();
//        map.populateBattleRoomWithAntagonists();
//        map.sendCharactersToRoom();
//        map.triggerFight();
//        map.getDeadAntagonistsIntoTrophy();
//
//        assertEquals(100, map.getTotalPoints());
//        //Random generated: should just give assertion error.
//    }
//

    @Test
    public void mapCanShuffleHome () {
        map.shuffleHome();
        assertEquals(5, map.getHome().size());
//        Use debugger to check shuffle.
    }

    @Test
    public void mapCanDecideIfGameIsOver () {
        map.decideIfGameOver();
        assertEquals (false, map.isGameOver());
    }

    @Test
    public void canPlayGame () {
        assertEquals(5, map.playGame());
    }

    @Test
    public void mapCanEmptyEverythingAfterGame () {
        map.emptyMap();

        assertEquals (0, map.getHome().size());
        assertEquals(0, map.getGraveyard().size());
        assertEquals(0, map.getTrophies().size());
        assertEquals(0, map.getBattleRooms().size());
        assertEquals(0, map.getWealth());
        assertEquals(0, map.getTotalPoints());
        assertEquals(0, map.getWavesCompleted());
        assertEquals(false, map.isGameOver());
    }

}

//BELOW IS MY OWN PLANNING FOR ROOM & GAME

//GAME PROPERTIES
//AL MAP
//IN TEST, choose what characters to create. Map.add them.

//.ADD_PLAYER

//.PLAY ONE-WAVE
//      TRIGGERS MAP.ONE WAVE.

//.PLAY EXTREME (ASSERTNOTNULL).

// MAP PROPERTIES

// AL HOME OF CHARACTERS
// BATTLE ROOM (START EMPTY)
// TROPHY ARRAY (ANTAGONISTS)
// INT NO. WAVES COMPLETED (STARTS 0)
// TOTAL POINTS (Start 0)
// WEALTH (STARTS 0)


// BOOLEAN GAME OVER
//-----
// AL OF ROOMS COMPLETED
// AL OF ROOMS TO GO
//-----

//.ADD Player to home ()  - good time to look up method of how to add an array into array.
//

//.SHUFFLE HOME
//

//.POPULATE TREASURE
//      A copy from below.


//.MAKE ROOM & POPULATE ANTAGONISTS
//      MAKE A ROOM Room room = new Room ();
//      requiredNumber = 0
//      whoPopulatesFirst = random number between 1 and 2.
//      Antagonist first_Populate = null
//      Antagonist secondPopulate = null
//      if .wholePopulatesFirst is 1
//          firstPopulate = new Troll();
//          secondpopulate = new Orc();
//      else
//          second_populate = new Orc();
//          first_Populate = new Troll();
//
//      FIRST POPULATE NUMBER = random number between 0 and 5
//      SECOND POPULATE NUMBER = 5 - firstPopulateNumber
//
//      USE A COUNTER: WHILE INT LOWER THAN/EQUAL TO FIRSTPOPULATENUMBER
//          room.add(firstPopulate)
//
//      USE A COUNTER: WHILE INT LOWER THAN/EQUAL TO SECONDPOPULATENUMBER
//          room.add(secondPopulate)
//
//      battleRoom.add(room);
//      .populateTreasure();



//.CALCULATE POINTS
//      TOTAL POINTS VARIABLE
//      FOR EVERY IN TROPHY
//          I.FULLHEALTH <- ZOMBIES! HAHA
//          I.ADD HEALTH TO TOTAL POINTS
//

//.CALCULATE WEALTH
//      TOTAL POINTS VARIABLE
//      FOR EVERY IN HOME
//          I.FULLHEALTH <- ZOMBIES! HAHA
//          I.ADD HEALTH TO TOTAL POINTS
//

///.ROOM COMPLETED
//      THIS.WAVES += 1;

//.REMOVE ROOM
//      battleRoom.clear();

//.HEAL
//      empty al healers
//      for i in hom, if i is cleric, add, not remove, to healers, else return

//      total healing = 0;
//      for i in heal, get health, add to total healing.

//      arrange home in order of most weak first. Find your own way of healing.

//      return;

//.GAME OVER
//
//          DISPLAY SCORE
//          DISPLAY TOTAL WEALTH
//          DISPLAY NUMBER OF WAVES COMPLETED
//          DISPLAY C DEADPILE/GRAVEYARD ARRAY https://www.java67.com/2014/09/how-to-convert-array-to-string-in-java-example.html

//.GAME WON

//          DISPLAY SCORE
//          DISPLAY TOTAL WEALTH
//          DISPLAY NUMBER OF WAVES COMPLETED
//          DISPLAY C DEADPILE/GRAVEYARD ARRAY https://www.java67.com/2014/09/how-to-convert-array-to-string-in-java-example.html

//.ONE_WAVE
//      .MAKE ROOM
//      Shuffle Home?
//      SENDS CHARACTERS TO ROOM
//      TRIGGERS ROOM TO PERFORM .FIGHT
//      RETRIEVE A FROM A DEAD PILE (add, remove) AND PUT INTO TROPHY ARRAY
//      .CALCULATE POINTS
//
//      RETRIEVE FROM C DEAD PILE AND PUT INTO GRAVEYARD ARRAY
//      IF GRAVEYARD ARRAY.LENGTH == STARTING CHARACTERS NO.
//          TRIGGER REMOVE ROOM
//          TRIGGER .GAMEOVER
//      .GETHOME - move from CArray to HomeArray
//      .ROOM COMPLETED
//      .HEAL
//      .CALCULATE WEALTH

//      TRIGGER REMOVE ROOM.
//      TRIGGER .GAMEWON
//      OR
//      .ONE WAVE_RECURSIVELY


// ROOM PROPERTIES

//AL OF CHARACTERS (START EMPTY)
//AL OF ANTAGONISTS (
//AL DEAD PILE ANTAGONIST
//AL DEAD PILE CHARACTERS
//AL OF TREASURE

//AL OF FALLEN ENEMY WEAPONS that alive characters can sift through.
//AL OF WARRIOR COLLECTING
//AL OF MAGI COLLECTING
//AL OF CLERIC COLLECTING

    //  Every character goes into collecting array.
    // Each collecting array has ability to sort characters where best weaponed goes first (bubble sort?)
    // .Scavenge for character, for item in array, if weapon gettype is warrior/ForAMagi/RevTool, otherwise nothing or return, if its damage higher than player, damage, swap.
    // Push everyone back into ALcharacters.

//.COLLECT TREASURE
//      FOR EVERY ITEM IN P
//          FOR EVERY ITEM IN TREASURE
//          P[0] TAKE HEALTH OF T[0]
//MAYBE A FOR LOOP THAT INCREMENTALLY MATCHES UP SO THEY TAKE TREASURE.


//.FIGHT
//      LOGIC TO ASCERTAIN THEY ALWAYS MATCH UP
//
//      P[0] ATTACKS A[0] ... TO 5 - WE'RE ACTUALLY GONNA SAY A[0] TAKE DAMAGE OF P[0]
//      IF ANY IN A DEAD
//          (REMOVE?) AND PUSH A TO A DEAD PILE ARRAY
//      IF A LIST EMPTY
//          (REMOVE?) AND PUSH P TO CHARACTERS ARRAY/
//      A[0] ATTACKS P[0] ... TO 5
//      IF ANY IN P DEAD
//          PUSH P TO P DEAD PILE ARRAY
//      IF P EMPTY
//          RETURN


//      .COLLECT TREASURE

//.CLEAR
//      AL.clear()
//      *5



// ARRAY METHODS
// .remove removes and

