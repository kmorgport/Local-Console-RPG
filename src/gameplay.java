import java.util.Scanner;

public class gameplay {
    private Scanner input = new Scanner(System.in);
    private String answer = input.nextLine();
    private Hero hero = new Hero(30, 3, 3, 10);
    private Monster randomMonster;
    public int playerAttack = hero.getAttack();

    public Monster generateEasyMonster(int rando){
        switch(rando){
            case 1:
                return new Monster(50,"Kolem", 1,7,8);
            case 2:
                return new Monster(35,"Warmadilla",2,4,5);
            case 3:
                return new Monster(25,"Blarghodon",4,2,6);
            default:
                return new Monster(30,"Mehlpie", 3,3,5);
        }
    }

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
        playerTurn();
    }

    public void monsterTurn(){
        int playerhealth = Hero.getHealth();
        int enemyHealth = randomMonster.getHealth();
        int enemyAttack = randomMonster.getAttack();
        String enemeyName = randomMonster.getName();
        if(enemyHealth<=0){
            System.err.println("The monster has been defeated!");
            moneyRewards();
            spawnMonster();
        }

        int multiplyer = (int) Math.floor(Math.random() * 3)+3;
        int damage = enemyAttack+multiplyer;
        playerhealth -= damage;
        System.out.println(enemeyName+ " hit you for "+damage+" damage!");
        Hero.setHealth(playerhealth);
        displayStats();
        playerTurn();

    }

    public void playerTurn(){
        int playerhealth = Hero.getHealth();
        String enemeyName = randomMonster.getName();
        if(playerhealth<=0){
            clearConsole();
            System.err.println("You died");
//            running = false;
            return;
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
                playerhealth += heal;
                Hero.setHealth(playerhealth);
                System.out.println("You healed yourself for " + heal + " points!");
                break;

            case 'r':
                playerhealth += 5;
                Hero.setHealth(playerhealth);
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

    }

    public static void displayStats(){
        int playerHealth = Hero.getHealth();

        System.out.println("You have " + playerHealth + " health left.");
    }

    public final  void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

    }


}
