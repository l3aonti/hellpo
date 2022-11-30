package games.ability;

public enum AbilityEnum {
    AIR("Воздух", "воздушный", 1, 0),
    EARTH("Земля", "земляной", 1, 0),
    FIRE("Огонь", "огненный", 1, 0),
    WATER("Вода", "водяной", 1, 0);
    private final String name;
    private final String atackName;
    private int power;
    private int accuracy;


    AbilityEnum(String name, String atackName, int power, int accuracy) {
        this.name = name;
        this.atackName = atackName;
        this.power = power;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public String getAtackName() {
        return atackName;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
