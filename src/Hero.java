public class Hero {
    private static String name;
    private int health;
    private int attack;
    private int defense;
    private int magic;
    private static int money;


    public Hero(int health, int attack, int defense, int magic){
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
        money = 0;

    }

    public int getHealth(){
        return health;
    }

    public static int getMoney(){
        return money;
    }
    public static void addMoney(int mon){
        Hero.money += mon;
    }

    public static void subMoney(int mon){
        Hero.money -= mon;
    }

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public String getName(){
        return name;
    }

    public static void setName(String name){
        Hero.name = name;
    }

    public int getAttack(){
        return this.attack;
    }


    public int getDefense(){
        return this.defense;
    }

    public int getMagic(){
        return this.magic;
    }
}
