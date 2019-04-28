package model.other;

import model.characters.Hero;
import model.options.Difficulty;
import model.overworld.Overworld;


/**
 * This class contains every information to save a single play-through.
 *
 * @author Hagen
 */
public class SaveState {

    private Hero player;
    private Hero[] party;
    private long playtime;
    private Overworld zaWORUDO;
    private Difficulty difficulty;


    /**
     * Creates an SaveState-Object, that will save the current play-through.
     *
     * @param player: The Hero-Object, that the player controls.
     * @param party: The NPC's that the player can also control.
     * @param playtime: The amount of time played in milli seconds.
     * @param overworld: The overworld which contains a list of all dungeons.
     * @param difficulty: The difficulty the player wants to play with in this SaveState.
     */
    public SaveState(Hero player, Hero[] party, long playtime, Overworld overworld, Difficulty difficulty) {
        this.player = player;
        this.party = party;
        this.playtime = playtime;
        this.zaWORUDO = overworld;
        this.difficulty = difficulty;
    }

    public Hero getPlayer() {
        return player;
    }

    public long getPlaytime() {
        return playtime;
    }

    public Overworld getOverworld() {
        return zaWORUDO;
    }

    public Hero[] getParty() {
        return party;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
