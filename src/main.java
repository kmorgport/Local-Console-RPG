import java.util.Scanner;

class Main{

    private static boolean running;
    private static String pName;
    private static int pHealth;
    private static int mHealth;
    private static int money;
    private static Scanner input;
    private static String answer;
    private static int attackstat;
    private static int defstat;
    private static int mana;

    static class Monster{
        private int health;
        private String name;
        private int attackStat;
        private int defStat;

        public Monster(int mhealth, String monname, int monAttackStat, int monDefStat){
            this.health = mhealth;
            this.name = monname;
            this.attackStat = monAttackStat;
            this.defStat = monDefStat;

        }

    }


    public static void main(String[] args) {

        input = new Scanner(System.in); //we create this here so we can close it off in the end
        running = startGameQuestion(); // this will set the loop off
        pHealth = 30;

        askNameQuestion();

        while(running){
            spawnMonster((int) Math.floor(Math.random() * 2)+1); //cast health to a random number 10-30
        }
        input.close();

        System.out.println("Game over");
    }
    public static Monster createEasyMonster(int rando){
        switch(rando){
            case 1:
                Monster mehlpie = new Monster(30,"Mehlpie", 30, 30);
                return mehlpie;
            case 2:
                Monster warmadilla = new Monster(40,"Warmadilla", 20, 40);
                return warmadilla;
            case 3:
                Monster blarghodon = new Monster(20,"Blarghodon",40,20);
                return blarghodon;


        }

        return null;
    }

    public static boolean startGameQuestion(){

        System.out.println("Would you like to play a game (Y/N)?");
        String answer = input.nextLine();

        if(answer.length() <= 0) { //check for empty string or it will crash
            clearConsole();
            System.out.println("No answer?");
            startGameQuestion(); //recursion
        }

        if(answer.toLowerCase().charAt(0) == 'y'){ //we check for only the first letter casted to lower case because its user friendly
            return true;
        }
        return false;
    }

//    public static void openWorld(){
//        //system asks to move, player moves , move monster spawn into here and set a random variable to monster spawning
//    }

    public static void askNameQuestion(){

        System.out.println("What is your name?");
        String answer = input.nextLine();
        if(answer.length() <= 0) { //check for empty string or it will crash
            clearConsole();
            System.out.println("No name?");
            askNameQuestion(); //recursion
        }
        pName = answer; //assign name to variable
        System.out.println("Your name is : " + pName);
    }

    public static void spawnMonster(int input){
        createEasyMonster(input);
        playerTurn();
    }

    public static void playerTurn(){

        if(pHealth <= 0){
            clearConsole();
            System.err.println("You died!");
            running = false;
            return; //goes back to the loop
        }


        System.out.println("Attack : Heal : Run");
        answer = input.nextLine();
        if(answer.isEmpty()) { //check for empty string or it will crash
            playerTurn(); //recursion
        }

        switch(answer.toLowerCase().charAt(0)){
            case 'a': //attack
                int dmg = (int) Math.floor(Math.random() * 3)+3;
                mHealth -= dmg; //do damage

                System.out.println("You did " + dmg + " damage to the monster!");
                break;

            case 'h': //heal
                int heal = (int) Math.floor(Math.random() * 3)+5;
                pHealth += heal; //heal

                System.out.println("You healed yourself for " + heal + " points!");
                break;

            case 'r': //run
                pHealth += 5; //do damage
                spawnMonster((int) Math.floor(Math.random() * 2)+1);

            default: //invalid input
                playerTurn(); //recursion
                break;
        }

        monsterTurn();
    }

    public static void monsterTurn(){

        if(mHealth <= 0){

            System.err.println("The monster has been defeated!");
            moneyRewards();
            spawnMonster((int) Math.floor(Math.random() * 2)+1);

        }

        int dmg = (int) Math.floor(Math.random() * 3)+3;
        pHealth -= dmg;


        System.out.println("You were hit for " + dmg + " health!");
        displayStats();
        playerTurn();

    }

    public static void moneyRewards(){
        int gains = (int) Math.floor(Math.random()*3)+5;
        System.out.println("You collected "+gains+" gold!");
        money += gains;
        System.out.println("You have "+money+" gold.");

    }

    public static void displayStats(){

        System.out.println("You have " + pHealth + " health left.");
    }

    public final static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}