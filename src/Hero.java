public class Hero {
    private static String name;
    private int health;
    private  static int attack;
    private  static int defense;
    private  static int magic;
    private static int money;
    private static int experience;
    private static int level;


    public Hero(int health, int attack, int defense, int magic){
        this.health = health;
        Hero.attack = attack;
        Hero.defense = defense;
        Hero.magic = magic;
        money = 0;

    }

    public int getHealth(){
        return this.health;
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

    public static void addExp(int exp){Hero.experience += exp;}
    public static  int getExp(){return experience;}

    public static void addLevel(){Hero.level ++;}
    public static int getLevel(){return level;}

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public String getName(){
        return name;
    }

    public static void setName(String name){
        Hero.name = name;
    }

    public static int getAttack(){
        return attack;
    }


    public static int getDefense(){
        return defense;
    }

    public static int getMagic(){
        return magic;
    }
}
