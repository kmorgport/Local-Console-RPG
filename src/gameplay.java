import java.util.Scanner;

public class gameplay {
    private Scanner input = new Scanner(System.in);
    private String answer = input.nextLine();
    private Hero hero = new Hero(30, "Kole", 3, 3, 10);
    private Monster mehlpie = new Monster(30, "Mehlpie", 3, 3, 5);
    public int playerhealth = hero.getHealth();
    public int playerAttack = hero.getAttack();
    public int enemeyHealth = mehlpie.getHealth();
    public int enemyAttack = mehlpie.getAttack();
    public String enemeyName = mehlpie.getName();

    public void playerTurn(){
        if(playerhealth<=0){
//            clearConsole();
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
                enemeyHealth -= damage;
                break;

            case 'h':
                int heal = (int) Math.floor(Math.random() * 3)+5;
                playerhealth += heal;
                System.out.println("You healed yourself for " + heal + " points!");
                break;

            case 'r':
                playerhealth += 5;
//                spawnMonster((int) Math.floor(Math.random() * 2)+1);

            default:
                playerTurn();
                break;
        }
//        monsterTurn();

    }



    public static void main(String[] args) {

    }

}
