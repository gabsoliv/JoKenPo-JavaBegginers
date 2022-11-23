import java.util.Random;
import java.util.Scanner;

public record JoKenPo(
        Player user,
        Player IA,
        int round
) {

    public void toPlay(){

        System.out.println("********* SEJA BEM-VINDO(A), " + user.getName() + " *********\n");
        for (int i =1; i <= round; i++){
            int choiceUser = choiceUser();
            if (choiceUser < 1 || choiceUser > 3){
                System.out.println("\nOpção inválida! (1, 2 ou 3): ");
                System.out.println("\nPONTO PARA " + IA.getName() + "\n");
                IA.incrementScore();
                continue;

            }

            int choiceIA = choiceIA();
            System.out.print("\n" + choiceUser + " X " + choiceIA + "\n");

            int result = choiceUser - choiceIA;
            winnerRound(result);


        }
    }

    public void showFinalResult(){
        System.out.println("\n*****************************************\n");

       Integer finalScoreUSer = user.getScore();
       Integer finalScoreIA = IA.getScore();

       System.out.println("\n\t\tPlacar final: " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName());

       if (finalScoreIA == finalScoreUSer) {
           System.out.println("EMPATE");
       } else {
           String finalWinner = (finalScoreUSer > finalScoreIA) ? user().getName() : IA().getName() ;

           System.out.println("\t\t\tVENCEDOR: " + finalWinner.toUpperCase());
       }
        System.out.println("\n\n****************************************\n");

    }

    private void winnerRound(int result){
      String winnerRound;
      if (result == 0){
          winnerRound = "EMPATE";
      }  else {
          if (result == -1 || result == 2){
              IA().incrementScore();
              winnerRound = IA().getName();

          } else {
              user.incrementScore();
              winnerRound = user().getName();
          }
      }

      System.out.println("Vencedor do round: " + winnerRound);
    }
    private int choiceIA(){
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    private int choiceUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1 - PEDRA");
        System.out.println(" 2 - PAPEL");
        System.out.println(" 3 - TESOURA");
        System.out.print("Escolha seu número: ");


        return sc.nextInt();

    }



}
