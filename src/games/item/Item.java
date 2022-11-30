package games.item;

public enum Item {
    STICK("посох",1, 2,1, 2,4 ),
    SWORD("меч",1,1,3,3,2),
    BOW("лук",1,4,2,2,2);
    private String name;
    private int level;
    private final int range;
    private final int atack;
    private final int speed;
    private final int strengthenMagic;
    Item(String name, int lvl, int range, int atc, int spd, int strMgc){
        this.name = name;
        level = lvl;
        this.range = range;
        atack = atc;
        speed = spd;
        strengthenMagic = strMgc;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRange() {
        return range;
    }

    public int getAtack() {
        return atack * level;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrengthenMagic() {
        return strengthenMagic * level;
    }
}
