import java.util.*;
public class Question2 {
    public static void
    createSubsets(List<List<Game>> subset, ArrayList<Game> nums, ArrayList<Game> output, int index)
    {      
        if (index == nums.size()) {
            subset.add(output);
            return;
        }       
        // Not Including Value which is at Index
        createSubsets(subset, nums, new ArrayList<>(output), index + 1); 
        // Including Value which is at Index
        output.add(nums.get(index));
        createSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }
 
    public static void main(String[] args) {
        
    Game game1 = new Game("Game1",100,50);
    Game game2 = new Game("Game2", 50, 10);
    Game game3 = new Game("Game3", 60, 45);
    Game game4 = new Game("Game4", 80, 20);       
    //Main List for storing all subsets
    List<List<Game>> subset = new ArrayList<>();       
    // Input ArrayList
    ArrayList<Game> input = new ArrayList<>();
    input.add(game1);
    input.add(game2);
    input.add(game3);
    input.add(game4);           
    createSubsets(subset, input, new ArrayList<>(), 0);
      
    int maxStorageofPC = 110;
    int maxStorageofGames = 0;
    int maxScoreofGames = 0;
    int sumLocalScore = 0;
    int sumforStorage = 0;
    int indexOfMaxGames=0;

    ArrayList<Integer> sumScores = new ArrayList<Integer>();
    ArrayList<Integer> sumStorage = new ArrayList<Integer>();

    for(int i = 0; i < subset.size(); i++){        
        for(int j = 0; j < subset.get(i).size(); j++){
            sumLocalScore += subset.get(i).get(j).getMetacriticScore();   
            sumforStorage += subset.get(i).get(j).getStorage();         
        }
        sumScores.add(sumLocalScore);
        sumStorage.add(sumforStorage);
        sumLocalScore =0;    
        sumforStorage = 0;  
    }
    for (int i = 0; i<sumScores.size(); i++){
        if (sumScores.get(i)>maxScoreofGames && sumStorage.get(i)<=maxStorageofPC){
            maxScoreofGames = sumScores.get(i);
            maxStorageofGames = sumStorage.get(i);
            indexOfMaxGames = i;
        }
    }
    System.out.println(maxStorageofGames);
    System.out.println(indexOfMaxGames);

    for (Game obj: subset.get(indexOfMaxGames)){
        System.out.print("Game Name: "  + obj.getName());
        System.out.print(" Needed Space: "  + obj.getStorage());
        System.out.print(" Metacritic Score: " + obj.getMetacriticScore());        
        System.out.println();
    }
       
    // Printing Subset
    for(int i = 0; i < subset.size(); i++){
        for(int j = 0; j < subset.get(i).size(); j++){
            System.out.print(subset.get(i).get(j).getMetacriticScore() + " ");
        }
        System.out.println();
      }
       
    }
}