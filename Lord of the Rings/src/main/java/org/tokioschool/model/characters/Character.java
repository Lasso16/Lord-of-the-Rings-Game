package org.tokioschool.model.characters;

/**
 * The type Character.
 */
public abstract class Character {
    private String name;
    private int health;
    private int armor;
    private String race;

    /**
     * Instantiates a new Character.
     *
     * @param name   the name
     * @param health the health
     * @param armor  the armor
     */
    public Character(String name, int health, int armor) {
        this.name = name;
        this.health = health;
        this.armor = armor;

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets health.
     *
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets health.
     *
     * @param health the health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets armor.
     *
     * @return the armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Sets armor.
     *
     * @param armor the armor
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }


    /**
     * Commit an attack to the target.
     *
     * @param target the target
     * @return the int
     */
    public  int attack(Character target) {
        int damageDealt = attackPower() - target.getArmor();
        if (damageDealt < 0)
            damageDealt = 0;
        int hpUpdated = target.getHealth() - damageDealt;
        target.setHealth(hpUpdated);

        return damageDealt;
    }

    /**
     * Calculates the attack power.
     *
     * @return the int
     */
    public abstract int attackPower();

    /**
     * If the character has more than 0 of health, returns true.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return getHealth() > 0;
    }

    /**
     * Gets race.
     *
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets race.
     *
     * @param race the race
     */
    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return getName() + " - " + getRace() +
                " (" + getHealth() + ", " + getArmor() + ")";
    }
}
