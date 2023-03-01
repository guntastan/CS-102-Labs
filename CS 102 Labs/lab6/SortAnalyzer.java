/**
 * SortAnalyzer
 */
public abstract class SortAnalyzer {

    private int numberOfComparisons=0;
    protected int k; 

    protected int[] arrayOne;
    public SortAnalyzer(){
        RandomArrayGenerator rag = new RandomArrayGenerator();
        arrayOne = rag.generate(4);
    }

    public int getnumberOfComparisons(){
        return numberOfComparisons;
    }

    protected int compare(Comparable o1, Comparable o2){
        this.numberOfComparisons = this.numberOfComparisons +1;

        if ((int)o1 > (int)o2){
            return 1;
        }
        else if ((int)o1 < (int)o2){
            return -1; 
        }
        else{
            return 0;
        }
    }
    public static boolean isSorted(int[] arr){
        if (isIncreasing(arr) || isDecresasing(arr)){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isIncreasing(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false; 
            }
        }    
        return true; 
    }
        
    public static boolean isDecresasing(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false; 
            }
        }    
        return true; 
    }


    public abstract int[] sort(int [] arr);
    

}