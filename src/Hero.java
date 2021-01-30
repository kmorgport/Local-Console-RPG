public class Hero {
    private int health;
    private String name;
    private int attack;
    private int defense;
    private int magic;


    public Hero(int health, String name, int attack, int defense, int magic){
        this.health = health;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;

    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public String getName(){
        return this.name;
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
