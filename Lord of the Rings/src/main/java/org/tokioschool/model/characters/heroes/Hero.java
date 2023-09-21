package org.tokioschool.model.characters.heroes;

import org.tokioschool.model.characters.Character;

/**
 * The type Hero.
 */
public abstract class Hero extends Character {
    private final int HERO_ATACK_RANGE = 100;
    private int heroAttackValue;


    /**
     * Instantiates a new Hero.
     *
     * @param name  the name
     * @param hp    the hp
     * @param armor the armor
     */
    public Hero(String name, int hp, int armor) {
        super(name, hp, armor);
    }


    /**
     * Gets hero attack value.
     *
     * @return the hero attack value
     */
    public int getHeroAttackValue() {
        return heroAttackValue;
    }



    @Override
    public int attackPower() {
        int dice1 = (int) (Math.random() * HERO_ATACK_RANGE);
        int dice2 = (int) (Math.random() * HERO_ATACK_RANGE);
        heroAttackValue = Integer.max(dice1, dice2);

        return heroAttackValue;
    }


}
