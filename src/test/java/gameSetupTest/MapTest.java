package gameSetupTest;

import gameSetup.Map;
import org.junit.Before;

public class MapTest {

    private Map map;

    @Before
    public void before () {
        map = new Map();

    }

}

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

