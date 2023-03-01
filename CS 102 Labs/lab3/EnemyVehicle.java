/**
 * EnemyVehicle
 */
import java.awt.*;
public abstract class EnemyVehicle implements Movable,Destructible {
    
    protected int xPosition;
    protected int yPosition;
    protected final int BASE_SPEED = 3;
    protected double health =100.0;

    public EnemyVehicle(int minX, int maxX, int y){
        this.xPosition = minX + (int)((Math.random() * ((maxX - minX) + 1))-1);
        this.yPosition = y;
    }
    public int getDistancetoBorder(){
        return this.yPosition;
    }
    public abstract String getType();

    @Override
    public void move(){
        this.yPosition = this.yPosition - BASE_SPEED;
    }
    @Override
    public Point getLocation(){
        Point coordinates = new Point(this.xPosition,this.yPosition);
        return coordinates;
    }
    @Override
    public boolean isDestroyed(){
        if (this.health <= 0.0){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public void takeDamage(double damage){
        this.health = this.health - damage;
    }
    public double getHealth(){
        return this.health;
    }
}