import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        //variables
        Scanner scan = new Scanner(System.in);
        String cpuChoice;
        String retry = "Y";
        int cpu = 0;
        int player = 0;
        while (retry.equals("Y")) {
            double n = Math.random();
			String playerChoice = "ERROR";
            //Find Player Choice
            while (!(playerChoice.equals("ROCK")) && !(playerChoice.equals("PAPER")) && !(playerChoice.equals("SCISSORS"))) {
                System.out.println("Rock, Paper, or Scissors, Which do you choose?");
                playerChoice = scan.nextLine().toUpperCase();
                if ((playerChoice.equals("ROCK")) || (playerChoice.equals("PAPER")) || (playerChoice.equals("SCISSORS")))
                    System.out.println("You have chosen " + playerChoice);
                else
                    System.out.println(playerChoice + " is not a valid answer!");
            }
            //Computer Choice
            if (n < 0.333)
                cpuChoice = "ROCK";
            else if (n > 0.666)
                cpuChoice = "SCISSORS";
            else
                cpuChoice = "PAPER";
            System.out.println("The Computer has chosen " + cpuChoice);
            //Compare Choices
            String a = "The Computer wins!";
            String b = "You win!";
            String c = "It's a tie!";
            if(cpuChoice.equals(playerChoice))
                System.out.println(c);
            else if ((cpuChoice.equals("ROCK")) && (playerChoice.equals("SCISSORS"))){
                System.out.println(a);
                cpu++;}
            else if ((cpuChoice.equals("ROCK")) && (playerChoice.equals("PAPER"))){
                System.out.println(b);
                player++;}
            else if ((cpuChoice.equals("PAPER")) && (playerChoice.equals("ROCK"))){
                System.out.println(a);
                cpu++;}
            else if ((cpuChoice.equals("PAPER")) && (playerChoice.equals("SCISSORS"))){
                System.out.println(b);
                player++;}
            else if ((cpuChoice.equals("SCISSORS")) && (playerChoice.equals("PAPER"))){
                System.out.println(a);
                cpu++;}
            else if ((cpuChoice.equals("SCISSORS")) && (playerChoice.equals("ROCK"))){
                System.out.println(b);
                player++;}
            System.out.println("Computer: " + cpu + "  Player: " + player);
            //restart or exit
            while (!retry.equals("N")) {
                System.out.println("Would you like to play again?[Y/N]");
                retry = scan.nextLine().toUpperCase();
                if (retry.equals("Y") || retry.equals("N"))
                    break;
                if ((!retry.equals("Y")) || !retry.equals("N"))
                    System.out.println("That's not a valid answer!");
                }
            }
        }
    }