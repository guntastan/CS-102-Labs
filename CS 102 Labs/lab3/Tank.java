/**
 * Tank
 */
public class Tank extends EnemyVehicle {

    public Tank(int minX, int maxX, int y){
        super(minX, maxX, y);
    }
    public void takeDamage(double damage){
        this.health = this.health - (damage*1)/2;
    }
    @Override
    public String getType(){        
        return "Tank";
    }
    @Override
    public String toString(){
        String printed = "A Tank is at location (" + xPosition + ", " + yPosition + "). It has " + health + " points left.";
        return printed;
    } 
}