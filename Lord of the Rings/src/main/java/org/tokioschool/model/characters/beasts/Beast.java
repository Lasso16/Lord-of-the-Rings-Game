package org.tokioschool.model.characters.beasts;

import org.tokioschool.model.characters.Character;

/**
 * The type Beast.
 */
public abstract class Beast extends Character {
    private final int BEAST_ATACK_RANGE = 90;
    private int beastAttackValue;


    /**
     * Instantiates a new Beast.
     *
     * @param name   the name
     * @param health the health
     * @param armor  the armor
     */
    public Beast(String name, int health, int armor) {
        super(name, health, armor);
    }


    /**
     * Gets beast attack value.
     *
     * @return the beast attack value
     */
    public int getBeastAttackValue() {
        return beastAttackValue;
    }



    @Override
    public int attackPower() {
        beastAttackValue = (int) (Math.random() * BEAST_ATACK_RANGE);
        return beastAttackValue;
    }

}
