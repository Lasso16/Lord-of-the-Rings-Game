package org.tokioschool.model.characters.heroes;

import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.beasts.Beast;
import org.tokioschool.model.characters.beasts.Orc;

/**
 * The type Human.
 */
public class Human extends Hero {

    /**
     * Instantiates a new Human.
     *
     * @param name  the name
     * @param hp    the hp
     * @param armor the armor
     */
    public Human(String name, int hp, int armor) {
        super(name, hp, armor);
        setRace("Humano");
    }
}
