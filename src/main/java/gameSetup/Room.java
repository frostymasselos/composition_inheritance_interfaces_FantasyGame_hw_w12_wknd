package gameSetup;

import characterTypes.Living;
import characterTypes.Player;
import characterTypes.antagonist.Antagonist;
import gameSetup.treasure.Treasure;

import java.util.ArrayList;

public class Room {

    private ArrayList<Player> players;
    private ArrayList<Player> temporaryPlayers;
    private ArrayList<Player> deadPlayers;
    private ArrayList<Antagonist> antagonists;
    private ArrayList<Antagonist> temporaryAntagonists;
    private ArrayList<Antagonist> deadAntagonists;
    private ArrayList<Treasure> treasureRoom;

    private boolean tIsFirstTime;
    private int remainder;
    private int tracker;
    private int whatYourStartingOn;
    private int howMuchIsLeft;

    private int aHowMuchIsLeft;
    private int aRemainder;
    private int aTracker;
    private int aRHowMuchIsLeft;

    private int pHowMuchIsLeft;
    private int pRemainder;
    private int pTracker;
    private int pRHowMuchIsLeft;



    public Room() {
        this.players = new ArrayList<>();
        this.temporaryPlayers = new ArrayList<>();
        this.deadPlayers = new ArrayList<>();
        this.antagonists = new ArrayList<>();
        this.temporaryAntagonists = new ArrayList<>();
        this.deadAntagonists = new ArrayList<>();
        this.treasureRoom = new ArrayList<>();

        this.tIsFirstTime = true;
        this.remainder = 0;
        this.tracker = 0;
        this.whatYourStartingOn = 0;
        this.howMuchIsLeft = 0;

        this.aHowMuchIsLeft = 0;
        this.aRemainder = 0;
        this.aTracker = 0;
        this.aRHowMuchIsLeft = 0;

        this.pHowMuchIsLeft = 0;
        this.pRemainder = 0;
        this.pTracker = 0;
        this.pRHowMuchIsLeft = 0;

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

// --------------------------------------------------------------------
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


    public void collectTreasure () {

        howMuchIsLeft = treasureRoom.size();

        if (howMuchIsLeft >= players.size()) {
            remainder = players.size();
        } else {
            remainder = howMuchIsLeft;
        }

        iterate(remainder, tracker);

    }
// --------------------------------------------------------------------
// PLAYERS ATTACK ANTAGONISTS

    public int finishBattle(){
        return 5;
    }

    public void removeAntagonistsToDeadPile () {
        for (Antagonist antagonist : antagonists) {
            if (antagonist.checkIfAlive() == false) {
                deadAntagonists.add(antagonist);
//                antagonists.remove(antagonist);
            }
        }

        if (deadAntagonists.size() == 5) {
            return;
        }

        for (Antagonist antagonist : antagonists) {
            if (antagonist.checkIfAlive() == true) {
                temporaryAntagonists.add(antagonist);
            }
        }

        antagonists.clear();

        for (Antagonist antagonist : temporaryAntagonists) {
            antagonists.add(antagonist);
        }

        temporaryAntagonists.clear();

//        if (antagonists.size() == 0) { //do we need this line anymore?
//            return;
//        }
        antagonistAttack();
    }


    public void aIterate (int numOneGoingIn, int numTwoGoingIn) {

        for (int i = 0; i < (aRemainder); i++) {
            int damage = players.get(i + numTwoGoingIn).attack();
            antagonists.get(i).sustainAttack(damage);
        }

        aTracker += aRemainder;

        if (aTracker == aRHowMuchIsLeft) {
            aTracker = 0;
            removeAntagonistsToDeadPile();
            return;
        }

        aHowMuchIsLeft -= aRemainder;
        if (aHowMuchIsLeft <= antagonists.size()) {
            aRemainder = aHowMuchIsLeft;
        } else {
            aRemainder = antagonists.size();
        }

        aIterate(aRemainder, aTracker);

    }

    public void playerAttack () {

        aRHowMuchIsLeft = players.size();
        aHowMuchIsLeft = players.size();
        if (antagonists.size() == 0) {
            return;
        }

        if (antagonists.size() >= players.size()) {
            aRemainder = players.size();
        } else {
            aRemainder = antagonists.size();
        }

        aIterate(aRemainder, aTracker);
        finishBattle();
//        removeAntagonistsToDeadPile();
    }

//    ------------------------------------------------------------------------------------------------------------------
//    ANTAGONISTS ATTACK PLAYERS

    public void removePlayersToDeadPile () {
        for (Player player : players) {
            if (player.checkIfAlive() == false) {
                deadPlayers.add(player);
//                players.remove(player);
            }
        }

        if (deadPlayers.size() == 5) {
            return;
        }

        for (Player player : players) {
            if (player.checkIfAlive() == true) {
                temporaryPlayers.add(player);
            }
        }

        players.clear();

        for (Player player : temporaryPlayers) {
            players.add(player);
        }

        temporaryPlayers.clear();

//        if (players.size() == 0) {
//            return;
//        }

        playerAttack();
    }


    public void pIterate (int numOneGoingIn, int numTwoGoingIn) {

        for (int i = 0; i < (pRemainder); i++) {
            int damage = antagonists.get(i + numTwoGoingIn).attack();
            players.get(i).sustainAttack(damage);
        }

        pTracker += pRemainder;

        if (pTracker == pRHowMuchIsLeft) {
            pTracker = 0;
            removePlayersToDeadPile();
            return;
        }

        pHowMuchIsLeft -= pRemainder;
        if (pHowMuchIsLeft <= players.size()) {
            pRemainder = pHowMuchIsLeft;
        } else {
            aRemainder = antagonists.size();
        }
        pIterate(aRemainder, aTracker);

    }

    public void antagonistAttack () {

        pRHowMuchIsLeft = antagonists.size();
        pHowMuchIsLeft = antagonists.size();
        if (players.size() == 0) {
            return;
        }

        if (players.size() >= antagonists.size()) {
            pRemainder = antagonists.size();
        } else {
            pRemainder = players.size();
        }

        pIterate(aRemainder, aTracker);
        finishBattle();
    }


}

