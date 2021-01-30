public class Hero {
    private int health;
    private String name;
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
        return this.health;
    }

    public static int getMoney(){
        return money;
    }
    public static int addMoney(int mon){
        return money += mon;
    }

    public static int subMoney(int mon){
        return money -= mon;
    }

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public String getName(){
        return this.name;
    }

    public static void setName(String name){
        this.name = name;
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
