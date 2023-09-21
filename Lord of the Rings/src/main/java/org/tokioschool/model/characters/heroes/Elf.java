package org.tokioschool.model.characters.heroes;


import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.beasts.Beast;
import org.tokioschool.model.characters.beasts.Orc;

/**
 * The type Elf.
 */
public class Elf extends Hero {

    /**
     * Instantiates a new Elf.
     *
     * @param name  the name
     * @param hp    the hp
     * @param armor the armor
     */
    public Elf(String name, int hp, int armor) {
        super(name, hp, armor);
        setRace("Elfo");
    }

    @Override
    public int attack(Character target) {
        int damageDealt = attackPower() - target.getArmor();
        if (target instanceof Orc)
            damageDealt += 10;
        if (damageDealt < 0)
            damageDealt = 0;
        int hpUpdated = target.getHealth() - damageDealt;
        target.setHealth(hpUpdated);

        return damageDealt;
    }



}
