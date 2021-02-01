import java.util.Scanner;

class Main{
public static boolean state = true;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //we create this here so we can close it off in the end
        gameplay Round = new gameplay(true); // this will set the loop off
        System.out.print("Would you like to play a game (Y/N)?");
        String answer = input.nextLine();
        while(!answer.toLowerCase().equals("y")) {
//            if (answer.length() <= 0) { //check for empty string or it will crash
//                Round.clearConsole();
//                System.out.println("No answer?");
////            startGameQuestion(); //recursion
//            }
            System.out.print("I'm sorry, can you repeat that? Would you like to play a game (Y/N)?");
            answer = input.nextLine();
        }
        while(state){
            Round.askNameQuestion();
            Round.spawnMonster();
            state = false;
        }

    }




}