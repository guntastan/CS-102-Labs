public class Helicopter extends EnemyVehicle{

    private int baseSpeed = 3;
                                                  
    public Helicopter(int minX, int maxX, int y){
        super(minX, maxX, y);
    }
    @Override
    public void move(){
        this.yPosition = this.yPosition - baseSpeed;
        baseSpeed++;
    }   
    @Override
    public String getType(){        
        return "Helicopter";
    }
    @Override
    public String toString(){
        String printed = "A Helicopter is at location (" + xPosition + ", " + yPosition + "). It has " + health + " points left.";
        return printed;
    }

}