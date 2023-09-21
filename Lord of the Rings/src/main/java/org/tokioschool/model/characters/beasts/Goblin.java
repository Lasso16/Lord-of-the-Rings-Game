package org.tokioschool.model.characters.beasts;

import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.heroes.Hero;

/**
 * The type Goblin.
 */
public class Goblin extends Beast{
    /**
     * Instantiates a new Goblin.
     *
     * @param name   the name
     * @param health the health
     * @param armor  the armor
     */
    public Goblin(String name, int health, int armor) {
        super(name, health, armor);
        setRace("Trasgo");
    }
}
