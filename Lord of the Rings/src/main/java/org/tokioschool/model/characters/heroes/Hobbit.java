package org.tokioschool.model.characters.heroes;

import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.beasts.Beast;
import org.tokioschool.model.characters.beasts.Goblin;


/**
 * The type Hobbit.
 */
public class Hobbit extends Hero {
    /**
     * Instantiates a new Hobbit.
     *
     * @param name  the name
     * @param hp    the hp
     * @param armor the armor
     */
    public Hobbit(String name, int hp, int armor) {
        super(name, hp, armor);
        setRace("Hobbit");
    }

    @Override
    public int attack(Character target) {
        int damageDealt = attackPower() - target.getArmor();
        if (target instanceof Goblin)
            damageDealt -= 5;
        if (damageDealt < 0)
            damageDealt = 0;
        int hpUpdated = target.getHealth() - damageDealt;
        target.setHealth(hpUpdated);
        return damageDealt;
    }

}
