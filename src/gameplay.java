import java.util.Scanner;

public class gameplay {
    private boolean state;
    private static Scanner input = new Scanner(System.in);
    private String answer = input.nextLine();
    private Hero hero = new Hero(50, 3, 3, 10);
    private Monster randomMonster;
    public int playerAttack = hero.getAttack();
    private int playerHealth = hero.getHealth();

    public gameplay (boolean state){
        this.state = state;
    }

    public boolean findState(){
        return this.state;
    }

    public void setState(boolean state){
        this.state = state;
    }


    public Monster generateEasyMonster(int rando){
        switch(rando){
            case 1:
                return new Monster(20,"Coalem", 1,7,8);
            case 2:
                return new Monster(15,"Warmadilla",2,4,5);
            case 3:
                return new Monster(10,"Blarghodon",4,2,6);
            default:
                return new Monster(12,"Mehlpie", 3,3,5);
        }
    }


//    public static void openWorld(){
//        //system asks to move, player moves , move monster spawn into here and set a random variable to monster spawning
//    }

    public void askNameQuestion(){

        System.out.println("What is your name?");
        String answer = input.nextLine();
        if(answer.length() <= 0) { //check for empty string or it will crash
            clearConsole();
            System.out.println("No name?");
            askNameQuestion(); //recursion
        }
        Hero.setName(answer);
        System.out.println("Your name is : " + answer);
    }


    public void spawnMonster(){
        int random = (int) Math.floor(Math.random()*2)+1;
        randomMonster = generateEasyMonster(random);
        String enemyName = randomMonster.getName();
        System.out.println("A vicious "+ enemyName+" appeared!");
        playerTurn();
    }

    public void monsterTurn(){
        int enemyHealth = randomMonster.getHealth();
        int enemyAttack = randomMonster.getAttack();
        String enemeyName = randomMonster.getName();
        int monsterExperience = randomMonster.getExperience();
        if(enemyHealth<=0){
            moneyRewards();
            gainExp(monsterExperience);
            spawnMonster();
        }

        int multiplyer = (int) Math.floor(Math.random() * 3)+3;
        int damage = enemyAttack+multiplyer;
        playerHealth -= damage;
        System.out.println(enemeyName+ " hit you for "+damage+" damage!");;
        displayStats();
        playerTurn();

    }

    public static void gainExp(int exp){
        System.out.println("You earned "+exp+" experience points!");
        Hero.addExp(exp);
    }

    public static void levelUp(){
        int exp = Hero.getExp();
        int currLev = Hero.getLevel();
        int currAttack = Hero.getAttack();
    }

    public void playerTurn(){
        String enemeyName = randomMonster.getName();
        if(playerHealth<=0){
            clearConsole();
            System.err.println("You died");
            System.out.println("Game over");
            System.exit(1);
        }
        System.out.println("Attack : Heal : Run");
        answer = input.nextLine();
        if(answer.isEmpty()){
            playerTurn();
        }

        switch(answer.toLowerCase().charAt(0)){
            case 'a':
                int multiplyer = (int) Math.floor(Math.random()*3)+1;
                int damage = playerAttack + multiplyer;
                System.out.println("You did "+damage+" damage to "+enemeyName+"!");
                int enemyHealth = randomMonster.getHealth();
                enemyHealth -= damage;
                randomMonster.setHealth(enemyHealth);
                break;

            case 'h':
                int heal = (int) Math.floor(Math.random() * 3)+5;
                playerHealth += heal;
                System.out.println("You healed yourself for " + heal + " points!");
                break;

            case 'r':
                playerHealth += 5;
//                spawnMonster((int) Math.floor(Math.random() * 2)+1);

            default:
                playerTurn();
                break;
        }
        monsterTurn();

    }

    public static void moneyRewards(){
        int gains = (int) Math.floor(Math.random()*3)+5;
        System.out.println("You collected "+gains+" gold!");
        Hero.addMoney(gains);
        int money = Hero.getMoney();
        System.out.println("You have "+money+" gold.");
        System.out.println("The monster has been defeated!");
        System.out.println("");

    }

    public void displayStats(){
        if(playerHealth<=0){
            System.out.println("You have 0 health left");
        }else{
            System.out.println("You have " + playerHealth + " health left.");
        }
    }

    public final  void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

    }


}
