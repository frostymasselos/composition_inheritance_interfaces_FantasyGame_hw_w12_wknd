package gameSetup;

import characterTypes.Player;
import characterTypes.antagonist.Antagonist;
import gameSetup.treasure.Treasure;

import java.util.ArrayList;

public class Room {

    private ArrayList<Player> players;
    private ArrayList<Player> deadPlayers;
    private ArrayList<Antagonist> antagonists;
    private ArrayList<Antagonist> deadAntagonists;
    private ArrayList<Treasure> treasureRoom;
    private int tNumOneGoingOut;
    private int tNumTwoGoingOut;
    private boolean tIsFirstTime;


    public Room() {
        this.players = new ArrayList<>();
        this.deadPlayers = new ArrayList<>();
        this.antagonists = new ArrayList<>();
        this.deadAntagonists = new ArrayList<>();
        this.treasureRoom = new ArrayList<>();
        this.tNumOneGoingOut = 5;
        this.tNumTwoGoingOut = 0;
        this.tIsFirstTime = true;

    }

//    GETTERS & SETTERS FOR PROPERTIES

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean checkIfPlayersPopulated () {
        if (getPlayers().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPlayersIsFive () {
        if (getPlayers().size() == 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAntagonistsIsFive () {
        if (getAntagonists().size() == 5) {
            return true;
        } else {
            return false;
        }
    }


    public void addToPlayers(Player player) {
        this.players.add(player);
    }

    public ArrayList<Player> getDeadPlayers() {
        return deadPlayers;
    }

    public void addToDeadPlayers(Player player) {
        this.deadPlayers.add(player);
    }

    public ArrayList<Antagonist> getAntagonists() {
        return antagonists;
    }

    public void addToAntagonists(Antagonist antagonist) {
        this.antagonists.add(antagonist);
    }

    public ArrayList<Antagonist> getDeadAntagonists() {
        return deadAntagonists;
    }

    public void addToDeadAntagonists(Antagonist antagonist) {
        this.deadAntagonists.add(antagonist);
    }

    public ArrayList<Treasure> getTreasures() {
        return treasureRoom;
    }

    public void addToTreasures(Treasure treasure) {
        this.treasureRoom.add(treasure);
    }

//    SURVIVING PLAYERS COLLECT TREASURE

//    public int calculateRemainder () {
//        return getTreasures().size() - getPlayers().size();
//    }
//
//    public void TwoIteration (int remainder, int present) {
//        int firstNum = getPlayers().size();
//        int secondNum = present;
//        for (int i = 0; i < (firstNum) ; i++) {
//            double wealth = getTreasures().get(i + present).getWealth();
//            getPlayers().get(i).addWealth(wealth);
//        }
//    }
//
//    public void doIterations (int remainder, int present) {
//        if (remainder <= present/2) {
//            int firstNum = getPlayers().size();
//            int secondNum = 5 - remainder;
//            TwoIteration(remainder, present);
//        } else {
//
//            int firstNum = getPlayers().size();
//
//        }
//    }
//
//    public int calculateIterations (int remainder, int present) {
//        if ()
//    }
//
//    public void
//
//    public void collectTreasure () {
//
//        int players = getPlayers().size();
//        int present = 5;
//        int remainder = calculateRemainder();
//        if (remainder == 0) {
//           collectTreasureNoRemainder();
//           return;
//        }
//        int iterations = calculateIterations(remainder, present);
//        doIterations(remainder, present);
//    }
//
//    public void collectTreasureNoRemainder () {
//        int num = getPlayers().size();
//            for (int i = 0; i < num ; i++) {
//                double wealth = getTreasures().get(i).getWealth();
//                getPlayers().get(i).addWealth(wealth);
//            }
//    }

// -------------------------------------------------------------------
// HARD VERSION OF COLLECTING TREASURE


    public void iterate (int numOneGoingIn, int protoNumTwoGoingIn) {
        int numTwoGoingIn = 0;
        numTwoGoingIn = protoNumTwoGoingIn;
        if (protoNumTwoGoingIn == 5) {
            numTwoGoingIn = 0;
        }
        for (int i = 0; i < (numOneGoingIn); i++) {
            double wealth = getTreasures().get(i).getWealth();
            getPlayers().get(i + numTwoGoingIn).addWealth(wealth);
        }
        int remainder = treasureRoom.size() - players.size();
        if (remainder == 0) {
            this.tNumOneGoingOut = 0;
            this.tNumTwoGoingOut = 0;
            this.tIsFirstTime = true;
            return;
        }
        tNumOneGoingOut = numTwoGoingIn - 0; //NEXT TIME DO IT FOR THIS LONG
        tNumTwoGoingOut = 0; //NEXT TIME START INDEXII HERE

        howManyTimesWeCollect();
    }
//    public int calculateNumOne () {
//        int numOne = 0;
//        if (players.size() == treasureRoom.size()) {
//            numOne = treasureRoom.size();
//            return numOne;
//        }
//
//        int remainder = players.size() % treasureRoom.size();
//        if (remainder == 0) {
//            numOne = players.size();
//        } else {
//            numOne = remainder;
//        }
//        return numOne;
//    }
//
//    public void collectTreasureHard () {
//        int numOne = calculateNumOne;
//        iterate();
//
//    }

    public void howManyTimesWeCollect () { //THIS IS GOING TO BE RECURSIVE?
        int remainder = treasureRoom.size() - players.size();
        int numOneGoingIn = 0;
        int protoNumTwoGoingIn = 0;
        if (players.size() == 5) {
            numOneGoingIn = 5;
        }

        numOneGoingIn = tNumOneGoingOut;

        protoNumTwoGoingIn = tNumTwoGoingOut;

        iterate(numOneGoingIn, protoNumTwoGoingIn);

    }
//    ----------------------------------------------------------------

    public void collectTreasureEasy () { // ONE PLAYER SCOOPS IT ALL. THEN SHARE.

        double totalTreasure = 0;
        double players = this.players.size();

        for (Treasure treasure : treasureRoom) {
            if (treasure.getCoreWealth() != 0) {
                totalTreasure += treasure.getWealth();
            }
        }

        double portion = totalTreasure / players;
        for (Player player : this.players) {
            player.addWealth(portion);
        }

    }




    public void fight () {

    }





}
