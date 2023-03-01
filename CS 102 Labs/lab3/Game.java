import java.util.*;

/**
 * Game
 */
public class Game implements Difficulty{

    private int difficulty;
    protected final int STARTING_DISTANCE =20;
    private Player player1;
    private ArrayList<EnemyVehicle> vehicles = new ArrayList<>();
    private GamePlotter gameplotter;
    private int passBorder =0;
    private final int MAX_NO_OF_PASSING_ENEMIES =5;
    private boolean hasFinished = false;

    public Game(int difficulty){
        this.setDifficulty(difficulty);
        player1 = new Player();        
        for (int i = 0; i<difficulty*2; i++){
            vehicles.add(getNewRandomVehicle());
        }
        gameplotter = new GamePlotter(this);
    }
    
    @Override
    public void setDifficulty(int aDifficulty){
        this.difficulty = aDifficulty;
    }
    @Override
    public int getDifficulty(){
        return this.difficulty;
    }
    public EnemyVehicle getNewRandomVehicle(){
        if (Math.random() < 0.5){
            EnemyVehicle tankReturn = new Tank(0, difficulty*5, STARTING_DISTANCE);
            return tankReturn;
        }
        else{
            EnemyVehicle helicopterReturn = new Helicopter(0, difficulty*5, STARTING_DISTANCE);
            return helicopterReturn;
        }
    }
    public ArrayList<EnemyVehicle> getEnemies(){
        return vehicles;
    }
    
    public void printGameState(){
        gameplotter.plot();
        System.out.println();
    }
    public void play (){
        Scanner scan = new Scanner (System.in);
        System.out.print("Enter x coordinate: ");
        int xCoor = scan.nextInt();
        System.out.print("Enter y coordinate: ");
        int yCoor = scan.nextInt();
        player1.attack(xCoor, yCoor, vehicles);
        enemiesTurn();
        
    }
    public void enemiesTurn(){
        printGameState();
        System.out.println("Current score: " + player1.getScore());
        System.out.println("Number of enemies passing border: " + this.passBorder);
        for (int i = 0; i< vehicles.size(); i++){
            System.out.println(vehicles.get(i).toString());
            vehicles.get(i).move();
        }
        for (int i = 0; i< difficulty*2; i++){
            if (hasFinished){
                break;
            }
            if (vehicles.get(i).getHealth() <=0){
                player1.increaseScore();
                System.out.println("A " + vehicles.get(i).getType() + " exploded.");
                vehicles.set(i, getNewRandomVehicle());
            }
            else if (vehicles.get(i).getLocation().y <0){
                passBorder++;
                System.out.println(vehicles.get(i).getType() + " passed the border.");
                vehicles.set(i, getNewRandomVehicle());
                if (passBorder == MAX_NO_OF_PASSING_ENEMIES){
                    hasFinished = true;
                    System.out.println("GAME OVER");
                }
            }
        }
    }
    public int getPassedNumber(){
        return passBorder;
    }
    public int  maxNumberofBorder(){
        return this.MAX_NO_OF_PASSING_ENEMIES;
    }
}