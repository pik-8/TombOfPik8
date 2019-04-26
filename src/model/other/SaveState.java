package model.other;

import model.overworld.Overworld;


/**
 * This class contains every information to save a single play-through.
 *
 * @author Hagen
 */
public class SaveState {

    private Hero player;
    private Hero party;
    private long playtime;
    private Overworld zaWORUDO;


    /**
     * Creates an SaveState-Object, that will save the current play-through.
     *
     * @param player: The Hero-Object, that the player controls.
     * @param party: The NPC's that the player can also control.
     * @param playtime: The amount of time played in milli seconds.
     * @param overworld: The overworld which contains a list of all dungeons.
     */
    public SaveState(Hero player, Hero party, long playtime, Overworld overworld) {
        this.player = player;
        this.party = party;
        this.playtime = playtime;
        this.zaWORUDO = overworld;
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

    public Hero getParty() {
        return party;
    }
}
