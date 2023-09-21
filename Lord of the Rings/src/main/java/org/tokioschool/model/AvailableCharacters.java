package org.tokioschool.model;

import org.tokioschool.model.characters.Character;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The type Available characters.
 */
public class AvailableCharacters {
    private final ArrayList<Character> availableCharacters;

    /**
     * Instantiates a new Available characters.
     */
    public AvailableCharacters() {
        availableCharacters = new ArrayList<>();

    }

    /**
     * Gets available characters.
     *
     * @return the available characters
     */
    public ArrayList<Character> getAvailableCharacters() {
        return availableCharacters;
    }

    /**
     * Add character.
     *
     * @param character the character
     */
    public void addCharacter(Character character) {
        availableCharacters.add(character);
        availableCharacters.sort(Comparator.comparing(Character::getName, String.CASE_INSENSITIVE_ORDER));
    }
}
