import java.util.Random;

/**
 * İncreasingArrayGenerator
 */
public class IncreasingArrayGenerator implements ArrayGenerator {

    int arr3[];

    public IncreasingArrayGenerator(int n){
        this.generate(n);
    }

    @Override
    public int[] generate(int n) {
        Random rd = new Random(); 
        this.arr3 = new int [n];     
        for (int i = 0; i < this.arr3.length; i++) {
            this.arr3[i] = rd.nextInt(n) + 1; // storing random integers in an array           
      }
        selectionSort(arr3);
        return this.arr3;
    }    

    public void selectionSort(int [] anArray){
        int n = anArray.length;  
        for (int i = 0; i < n-1; i++){            
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (anArray[j] < anArray[min_idx]){
                    min_idx = j;
                }          
            int temp = anArray[min_idx];
            anArray[min_idx] = anArray[i];
            anArray[i] = temp;
        }
    }
    public void getElements(){
        String printed ="|";
        for (int i=0; i< arr3.length; i++){
            printed = printed  + arr3[i] + "|";
        }
        System.out.println(printed);        
    }
    public static void main(String[] args) {
        IncreasingArrayGenerator secondOne = new IncreasingArrayGenerator(5);
        secondOne.getElements();
    }
}