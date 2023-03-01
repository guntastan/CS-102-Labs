import java.util.Random;

/**
 * DecreasingArrayGenerator
 */
public class DecreasingArrayGenerator implements ArrayGenerator {

    int arr2[];

    public DecreasingArrayGenerator(int n){
        this.generate(n);
    }

    @Override
    public int[] generate(int n) {
        Random rd = new Random();    
        this.arr2 = new int [n];     
        for (int i = 0; i < this.arr2.length; i++) {
            this.arr2[i] = rd.nextInt(n) + 1; // storing random integers in an array           
      }
        selectionSort(arr2);
        return this.arr2;
    }    

    public void selectionSort(int [] anArray){        
        int n = anArray.length;  
        for (int i = 0; i < n-1; i++){            
            int minidx = i; 
            for (int j = i+1; j < n; j++)
                if (anArray[j] > anArray[minidx]){
                    minidx = j;
                }          
            int temp = anArray[minidx];
            anArray[minidx] = anArray[i];
            anArray[i] = temp;
        }
    }
    public void getElements(){
        String printed ="|";
        for (int i=0; i< arr2.length; i++){
            printed = printed  + arr2[i] + "|";
        }
        System.out.println(printed);        
    }
    public static void main(String[] args) {
        DecreasingArrayGenerator secondOne = new DecreasingArrayGenerator(5);
        secondOne.getElements();
    }
    

    
}