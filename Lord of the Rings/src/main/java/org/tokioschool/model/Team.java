package org.tokioschool.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.heroes.Hero;


import java.util.ArrayList;

/**
 * The type Team.
 */
public class Team {
    private final ArrayList<Character> team;

    /**
     * Instantiates a new Team.
     */
    public Team() {
        team = new ArrayList<>();
    }

    /**
     * Gets team.
     *
     * @return the team
     */
    public ArrayList<Character> getTeam() {
        return team;
    }

    /**
     * Gets observable team.
     *
     * @return the observable team
     */
    public ObservableList<Character> getObservableTeam() {
        return FXCollections.observableArrayList(getTeam());
    }

    /**
     * Add character.
     *
     * @param character the character
     */
    public void addCharacter(Character character) {
        team.add(character);
    }

    @Override
    public String toString() {
        boolean containsHeroes = team.stream().anyMatch(character -> character instanceof Hero);
        StringBuilder teamString = new StringBuilder("Equipo " + (containsHeroes ? "Héroes" : "Bestias") +
                ":\n");

        for (Character character : team) {
            teamString.append(character).append("\n");
        }
        return teamString + "\n";
    }
}
