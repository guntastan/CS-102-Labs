import java.util.ArrayList;




/**
 * Player
 */
public class Player {

    private final double BOMB_RADIUS =2.0;
    private final double DAMAGE = 50.0;
    private int score =0;

    public Player(){}

    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies){        
        for (int i = 0; i<enemies.size(); i++){
            if (enemies.get(i).getLocation().x <= x+ (int)BOMB_RADIUS && enemies.get(i).getLocation().x >= x- (int)BOMB_RADIUS && (enemies.get(i).getLocation().y <= y+ (int)BOMB_RADIUS &&enemies.get(i).getLocation().y >= y- (int)BOMB_RADIUS )){
                enemies.get(i).takeDamage(DAMAGE);
                System.out.println("HIT");
            }
        }
    }
    public void increaseScore(){
        this.score++;
    }
    public int getScore(){
        return this.score;
    }
}