package gameSetup;

import characterTypes.Player;
import characterTypes.antagonist.Antagonist;
import characterTypes.antagonist.Orc;
import characterTypes.antagonist.Troll;
import gameSetup.treasure.Gem;
import gameSetup.treasure.Gold;
import gameSetup.treasure.Treasure;
import gameSetup.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Map {

    private ArrayList<Player> home;
    private ArrayList<Player> temporaryPlayers;
    private ArrayList<Player> graveyard;
    private ArrayList<Antagonist> trophies;
    private ArrayList<Antagonist> temporaryAntagonists;
    private ArrayList<Room> battleRooms;

    private int wealth;
    private int totalPoints;
    private int wavesCompleted;

    private boolean gameOver;

    public Map(ArrayList<Player> home) {
        this.home = home;
        this.temporaryPlayers = new ArrayList<>();
        this.graveyard = new ArrayList<>();
        this.trophies = new ArrayList<>();
        this.temporaryAntagonists = new ArrayList<>();
        this.battleRooms = new ArrayList<>();

        this.wealth = 0;
        this.totalPoints = 0;
        this.wavesCompleted = 0;

        this.gameOver = false;
    }

//    GETTERS AND SETTERS

    public ArrayList<Player> getHome() {
        return home;
    }

    public void addPlayerToHome (Player player) {
        home.add(player);
    }

    public ArrayList<Player> getTemporaryPlayers() {
        return temporaryPlayers;
    }

    public ArrayList<Player> getGraveyard() {
        return graveyard;
    }

    public ArrayList<Antagonist> getTrophies() {
        return trophies;
    }

    public ArrayList<Antagonist> getTemporaryAntagonists() {
        return temporaryAntagonists;
    }

    public ArrayList<Room> getBattleRooms() {
        return battleRooms;
    }

    public int getWealth() {
        return wealth;
    }

    public void addToWealthPot () {
        for (Player player : home) {
            wealth += player.getWealth();
            player.depleteWealth();
        }
    }

    public int getTotalPoints() {
        for (Antagonist antagonist : trophies) {
            antagonist.getFullHealth();
            totalPoints += antagonist.getHealth();
        }
        return totalPoints;
    }

    public int getWavesCompleted() {
        return wavesCompleted;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setWavesCompleted(int wavesCompleted) {
        this.wavesCompleted = wavesCompleted;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
//    ----------------------------------------------------------------

    public void shuffleHome () {
        Collections.shuffle(home);
    }

    public void addRoom () {
        battleRooms.add(new Room());
    }

    public void removeFirstRoom () {
//        battleRooms.remove(0);
        battleRooms.clear();
    }

    public void populateBattleRoomWithTreasure () {
        int firstNum = ThreadLocalRandom.current().nextInt(1, 6);
        int secondNum = 5 - firstNum;

        ArrayList<Gem> gems = new ArrayList<>();
        ArrayList<Gold> golds = new ArrayList<>();

        for (int i = 0; i < firstNum ; i++) {
            Gem gem = new Gem();
            gems.add(gem);
        }

        for (int i = 0; i < secondNum ; i++) {
            Gold gold = new Gold();
            golds.add(gold);
        }

        for (Gem gem : gems) {
            getBattleRooms().get(0).addToTreasures(gem);
        }

        for (Gold gold : golds) {
            getBattleRooms().get(0).addToTreasures(gold);
        }

    }

    public void populateBattleRoomWithAntagonists () {

        int firstNum = ThreadLocalRandom.current().nextInt(1, 6);
        int secondNum = 5 - firstNum;

        ArrayList<Orc> orcs = new ArrayList<>();
        ArrayList<Troll> trolls = new ArrayList<>();

        for (int i = 0; i < firstNum ; i++) {
            Orc orc = new Orc();
            orcs.add(orc);
        }

        for (int i = 0; i < secondNum ; i++) {
            Troll troll = new Troll();
            trolls.add(troll);
        }

        for (Orc orc : orcs) {
            getBattleRooms().get(0).addToAntagonists(orc);
        }

        for (Troll troll : trolls) {
            getBattleRooms().get(0).addToAntagonists(troll);
        }

    }

    public void sendCharactersToRoom () {
        for (Player player : home) {
            battleRooms.get(0).getPlayers().add(player);
        }
        home.clear();
    }

    public void triggerFight () {
        battleRooms.get(0).playerAttack();
    }

    public void getDeadAntagonistsIntoTrophy () {
        for (Antagonist antagonist : battleRooms.get(0).getDeadAntagonists()) {
            trophies.add(antagonist);
        }
        battleRooms.get(0).getDeadAntagonists().clear();
    }

    public void getDeadPlayersIntoGraveyard () {
        for (Player player : battleRooms.get(0).getDeadPlayers()) {
            graveyard.add(player);
        }
        battleRooms.get(0).getDeadPlayers().clear();
    }

    public void getPlayersBackFromRoom () {
        for (Player player : battleRooms.get(0).getPlayers()) {
            home.add(player);
        }
        battleRooms.get(0).getPlayers().clear();
    }

    public void triggerCollectTreasure () {
        battleRooms.get(0).collectTreasure();
    }

    public void emptyMap () {
        home.clear();
        graveyard.clear();
        trophies.clear();
        battleRooms.clear();
//        removeFirstRoom();
        wealth = 0;
        totalPoints = 0;
        wavesCompleted = 0;
        gameOver = false;

    }

    public void decideIfGameOver () {

//        if (battleRooms.get(0).getDeadPlayers().size() == 5) {
            gameOver = true;
            System.out.println("Game Over");
            System.out.println("Wealth accrued: " + Integer.toString(getWealth()));
            System.out.println("Rounds survived: " + Integer.toString(wavesCompleted));
            System.out.println("Score: " + Integer.toString(getTotalPoints()));
            emptyMap();
//        }
    }

    public int playGame () {
        shuffleHome();
//        addRoom();
        populateBattleRoomWithTreasure();
        populateBattleRoomWithAntagonists();
        sendCharactersToRoom();
        triggerFight();
        if (battleRooms.get(0).getPlayers().size() == 0) {
            decideIfGameOver();
            return 5;
        }
        wavesCompleted += 1;
        triggerCollectTreasure();
        System.out.println("Cash deposited");
        getPlayersBackFromRoom();
        System.out.println("Player back home");
        getDeadAntagonistsIntoTrophy();
        getDeadPlayersIntoGraveyard();
        addToWealthPot();
        removeFirstRoom();
//        playGame();
        decideIfGameOver();
        return 5;
    }

}
