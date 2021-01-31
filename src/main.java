//import java.util.Scanner;
//
//class Main{
//
//    private static boolean running;
//    private static String pName;
//    private static int pHealth;
//    private static int mHealth;
//    private static int money;
//    private static Scanner input;
//    private static String answer;
//    private static int attackstat;
//    private static int defstat;
//    private static int mana;
//
//    public static void main(String[] args) {
//
//        input = new Scanner(System.in); //we create this here so we can close it off in the end
//        running = startGameQuestion(); // this will set the loop off
//        pHealth = 30;
//
//        askNameQuestion();
//
//        while(running){
//            spawnMonster((int) Math.floor(Math.random() * 2)+1); //cast health to a random number 10-30
//        }
//        input.close();
//
//        System.out.println("Game over");
//    }
////    public static Monster createEasyMonster(int rando){
////        switch(rando){
////            case 1:
////                Monster mehlpie = new Monster(30,"Mehlpie", 30, 30);
////                return mehlpie;
////            case 2:
////                Monster warmadilla = new Monster(40,"Warmadilla", 20, 40);
////                return warmadilla;
////            case 3:
////                Monster blarghodon = new Monster(20,"Blarghodon",40,20);
////                return blarghodon;
////
////
////        }
////
////        return null;
////    }
//
//    public static boolean startGameQuestion(){
//
//        System.out.println("Would you like to play a game (Y/N)?");
//        String answer = input.nextLine();
//
//        if(answer.length() <= 0) { //check for empty string or it will crash
//            clearConsole();
//            System.out.println("No answer?");
//            startGameQuestion(); //recursion
//        }
//
//        if(answer.toLowerCase().charAt(0) == 'y'){ //we check for only the first letter casted to lower case because its user friendly
//            return true;
//        }
//        return false;
//    }
//
////    public static void openWorld(){
////        //system asks to move, player moves , move monster spawn into here and set a random variable to monster spawning
////    }
//
//    public static void askNameQuestion(){
//
//        System.out.println("What is your name?");
//        String answer = input.nextLine();
//        if(answer.length() <= 0) { //check for empty string or it will crash
//            clearConsole();
//            System.out.println("No name?");
//            askNameQuestion(); //recursion
//        }
//        pName = answer; //assign name to variable
//        System.out.println("Your name is : " + pName);
//    }
//
//    public static void spawnMonster(int input){
////        createEasyMonster(input);
//        playerTurn();
//    }
//
//
//
//

//}