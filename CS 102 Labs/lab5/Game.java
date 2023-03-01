/**
 * Game
 */
public class Game {

    private int storage;
    private int metacriticScore;
    private String name;

    public Game(String aName,int aStorage, int aScore){
        this.storage = aStorage;
        this.metacriticScore = aScore;
        this.name = aName;
    }
    public int getStorage(){
        return this.storage;
    }
    public int getMetacriticScore(){
        return this.metacriticScore;
    }
    public String getName(){
        return this.name;
    }
}