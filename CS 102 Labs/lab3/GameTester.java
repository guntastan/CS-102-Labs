import java.util.Scanner;

/**
 * GameTester
 */
public class GameTester {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a difficulty for the game (1 - Easy), (2 - Medium), (3 - Hard)");
        int chosedOption = scan.nextInt();
        Game game = new Game(chosedOption);
        GamePlotter plotter = new GamePlotter(game);
        plotter.plot();

        while (game.getPassedNumber() != game.maxNumberofBorder()){
            game.play();
        }
    }
}