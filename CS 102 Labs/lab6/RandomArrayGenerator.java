import java.util.Random;

/**
 * RandomArrayGenerator
 */
public class RandomArrayGenerator implements ArrayGenerator {

    int arr[];

    public RandomArrayGenerator(int n){
        this.generate(n);
    }
    public RandomArrayGenerator(){};

    @Override
    public int[] generate(int n) {
        Random rd = new Random(); 
        this.arr = new int [n];     
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = rd.nextInt(n) + 1; // storing random integers in an array           
      }
        return this.arr;
    }    
    public void getElements(){
        String printed ="|";
        for (int i=0; i< arr.length; i++){
            printed = printed  + arr[i] + "|";
        }
        System.out.println(printed);        
    }
    public static void main(String[] args) {
        RandomArrayGenerator firstone = new RandomArrayGenerator(5);
        firstone.getElements();
        
    }

    
}