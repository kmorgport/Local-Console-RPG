import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //we create this here so we can close it off in the end
        gameplay Round = new gameplay(true); // this will set the loop off
        System.out.print("Would you like to play a game (Y/N)?");
        String answer = input.nextLine();
        while(!answer.toLowerCase().equals("y")) {
            System.out.print("I'm sorry, can you repeat that? Would you like to play a game (Y/N)?");
            answer = input.nextLine();
        }
            Round.askNameQuestion();
            Round.spawnMonster();

    }




}