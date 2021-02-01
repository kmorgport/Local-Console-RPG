import java.util.Scanner;

class Main{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //we create this here so we can close it off in the end
        gameplay Round = new gameplay(true); // this will set the loop off

        System.out.print("Would you like to play a game (Y/N)?");
        String answer = input.nextLine();
        boolean state = Round.findState();
        while(!state) {
            if (answer.length() <= 0) { //check for empty string or it will crash
                Round.clearConsole();
                System.out.println("No answer?");
//            startGameQuestion(); //recursion
            }

            if (answer.toLowerCase().charAt(0) == 'y') { //we check for only the first letter casted to lower case because its user friendly
                state = true;
            } else {
                state = false;
            }
        }
        while(state){
            Round.askNameQuestion();
            Round.spawnMonster();
            state = false;
        }
        System.err.println("You died");
        System.out.println("Game over");

    }




}