package model.other;

import model.options.Option;


/**
 * This class will save everything that is important to be saved.
 * Saves all SaveStates and the options(settings).
 *
 * @author Hagen
 */
public class GameSave {

    private SaveState[] saveStates;
    private Option option;

    public GameSave(SaveState[] saveStates, Option option) {
        this.saveStates = saveStates;
        this.option = option;
    }

    public SaveState[] getSaveStates() {
        return saveStates;
    }

    public Option getOption() {
        return option;
    }
}
