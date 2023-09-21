package org.tokioschool.model;

import org.tokioschool.model.characters.beasts.Goblin;
import org.tokioschool.model.characters.beasts.Orc;
import org.tokioschool.model.characters.heroes.Elf;
import org.tokioschool.model.characters.heroes.Hobbit;
import org.tokioschool.model.characters.heroes.Human;

import java.util.ArrayList;

/**
 * The type App model.
 */
public class AppModel {


    private final Team teamHeroes;
    private final Team teamBeasts;
    private AvailableCharacters availableHeroes;
    private AvailableCharacters availableBeasts;

    /**
     * Instantiates a new App model.
     */
    public AppModel() {
        teamHeroes = new Team();
        teamBeasts = new Team();

        availableHeroes = new AvailableCharacters();
        availableBeasts = new AvailableCharacters();
    }

    /**
     * Gets team heroes.
     *
     * @return the team heroes
     */
    public Team getTeamHeroes() {
        return teamHeroes;
    }

    /**
     * Gets team beasts.
     *
     * @return the team beasts
     */
    public Team getTeamBeasts() {
        return teamBeasts;
    }

    /**
     * Gets available heroes.
     *
     * @return the available heroes
     */
    public AvailableCharacters getAvailableHeroes() {
        return availableHeroes;
    }

    /**
     * Sets available heroes.
     *
     * @param availableHeroes the available heroes
     */
    public void setAvailableHeroes(AvailableCharacters availableHeroes) {
        this.availableHeroes = availableHeroes;
    }

    /**
     * Gets available beasts.
     *
     * @return the available beasts
     */
    public AvailableCharacters getAvailableBeasts() {
        return availableBeasts;
    }

    /**
     * Sets available beasts.
     *
     * @param availableBeasts the available beasts
     */
    public void setAvailableBeasts(AvailableCharacters availableBeasts) {
        this.availableBeasts = availableBeasts;
    }

}
