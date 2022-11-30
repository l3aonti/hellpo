package games.races;

public enum RaceEnum {
    HUMAN("человек",0,0,0),
    OGRE("огр",0,0,0),
    ELF("эльф",0,0,0),
    DWARF("дварф",0,0,0),
    GNOME("гном",0,0,0);
    private final String raceName;
    private final int bonusStrength;
    private final int bonusAgility;
    private final int bonusProtection;
    RaceEnum(String name, int agility, int protection, int strength){
        raceName = name;
        bonusAgility = agility;
        bonusProtection = protection;
        bonusStrength = strength;
    }

    public int getBonusProtection() {
        return bonusProtection;
    }

    public int getBonusAgility() {
        return bonusAgility;
    }

    public int getBonusStrength() {
        return bonusStrength;
    }

    public String getRaceName() {
        return raceName;
    }
}
