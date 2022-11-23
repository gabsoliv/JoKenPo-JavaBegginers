import java.util.Scanner;

public class Main {

    public static JoKenPo startGame() {
        System.out.print("********* Jo Ken Po *********\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String playerName = sc.next().toUpperCase();

        Player user = new Player(playerName);
        Player IA = new Player("IA");

        System.out.print( playerName + ", quantos rounds você quer jogar? ");
        int rounds = sc.nextInt();

        return new JoKenPo(user, IA, rounds);

    }
    public static void main(String[] args) {
        JoKenPo joKenPo = startGame();
        joKenPo.toPlay();
        joKenPo.showFinalResult();


    }
}