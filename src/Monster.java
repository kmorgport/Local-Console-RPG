public class Monster {
    private int health;
    private String name;
    private int attack;
    private int defense;
    private int experience;

    public Monster(int health, String name, int attack, int defense, int experience){
        this.health = health;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;

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

    public int getExperience(){
        return this.experience;
    }

}
