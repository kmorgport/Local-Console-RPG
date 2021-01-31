import java.util.Scanner;

class Main{
    private static Scanner input;

    public static void main(String[] args) {

        input = new Scanner(System.in); //we create this here so we can close it off in the end
        gameplay Round = new gameplay(); // this will set the loop off

        System.out.println("Would you like to play a game (Y/N)?");
        String answer = input.nextLine();
        boolean state = gameplay.findState();
        if(answer.length() <= 0) { //check for empty string or it will crash
            Round.clearConsole();
            System.out.println("No answer?");
//            startGameQuestion(); //recursion
        }

        if(answer.toLowerCase().charAt(0) == 'y'){ //we check for only the first letter casted to lower case because its user friendly
              gameplay.setState(true);
        }else{
            state = false;
        }
        while(state){
            Round.askNameQuestion();
            Round.spawnMonster();
        }
        input.close();
        System.out.println("Game over");

    }




}