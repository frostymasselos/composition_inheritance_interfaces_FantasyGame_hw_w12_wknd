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

    private boolean tIsFirstTime;
    private int remainder;
    private int tracker;
    private int whatYourStartingOn;
    private int howMuchIsLeft;


    public Room() {
        this.players = new ArrayList<>();
        this.deadPlayers = new ArrayList<>();
        this.antagonists = new ArrayList<>();
        this.deadAntagonists = new ArrayList<>();
        this.treasureRoom = new ArrayList<>();

        this.tIsFirstTime = true;
        this.remainder = 0;
        this.tracker = 0;
        this.whatYourStartingOn = 0;
        this.howMuchIsLeft = 0;


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

    public void iterate (int numOneGoingIn, int numTwoGoingIn) {

        for (int i = 0; i < (numOneGoingIn); i++) {
            double wealth = getTreasures().get(i + numTwoGoingIn).getWealth();
            getPlayers().get(i).addWealth(wealth);
        }

        tracker += remainder;

        if (tracker == treasureRoom.size()) {
//            remainder = 0;
//            howMuchIsLeft = treasureRoom.size();
            return;
        }

        howMuchIsLeft -= remainder;
        if (howMuchIsLeft >= players.size()) {
            remainder = players.size();
        } else {
            remainder = howMuchIsLeft;
        }

        iterate(remainder, tracker);
    }


    public void howManyTimesWeCollect () {
        
        howMuchIsLeft = treasureRoom.size();

        if (tIsFirstTime == true) {
            if (howMuchIsLeft >= players.size()) {
                remainder = players.size();
            } else {
                remainder = howMuchIsLeft;
            }
        }

        iterate(remainder, tracker);

    }
//    ----------------------------------------------------------------
//EASY VERSION OF COLLECTING TREASURE

    public void collectTreasureEasy () {

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
