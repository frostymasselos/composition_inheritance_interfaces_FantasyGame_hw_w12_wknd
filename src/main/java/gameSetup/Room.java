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

    public Room() {
        this.players = new ArrayList<>();
        this.deadPlayers = new ArrayList<>();
        this.antagonists = new ArrayList<>();
        this.deadAntagonists = new ArrayList<>();
        this.treasureRoom = new ArrayList<>();
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

    public void collectTreasure () {

        if (checkIfPlayersPopulated() ) {
            for (int i = 0; i < getTreasures().size() ; i++) {
                double wealth = getTreasures().get(i).getWealth();
                getPlayers().get(i).addWealth(wealth);
            }

        } else {
            return;
        }

    }





}
