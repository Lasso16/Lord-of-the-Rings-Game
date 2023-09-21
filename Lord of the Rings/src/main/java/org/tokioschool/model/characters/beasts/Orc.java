package org.tokioschool.model.characters.beasts;

import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.heroes.Hero;

/**
 * The type Orc.
 */
public class Orc extends Beast {
    private static final double ARMOR_REDUCTION = 0.9;

    /**
     * Instantiates a new Orc.
     *
     * @param name   the name
     * @param health the health
     * @param armor  the armor
     */
    public Orc(String name, int health, int armor) {
        super(name, health, armor);
        setRace("Orco");
    }

    @Override
    public int attack(Character target) {
        int damageDealt = (int) (attackPower() - (target.getArmor() * ARMOR_REDUCTION));
        if (damageDealt < 0)
            damageDealt = 0;
        int hpUpdated = target.getHealth() - damageDealt;
        target.setHealth(hpUpdated);
        return damageDealt;
    }

}

