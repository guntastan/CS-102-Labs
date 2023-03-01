import java.util.Arrays;

public class SubProblemMergeSort{
    
    public static void main(String args[]) {
        int[] inputArray = {4,2,3,1,6,5,7,8,9,10};
        int subetLength = 3;
        
        int[][] output = splitArray(inputArray, subetLength);
        for (int[] x : output){
            System.out.println(Arrays.toString(x));
        }            
    }
    
    public static int[][] splitArray(int[] anArray, int subsetLength){             
        int rest = anArray.length % subsetLength; 
        int subArrays = anArray.length / subsetLength + (rest > 0 ? 1 : 0);         
        int[][] arrays = new int[subArrays][];        
        for(int i = 0; i < (rest > 0 ? subArrays - 1 : subArrays); i++){            
            arrays[i] = Arrays.copyOfRange(anArray, i * subsetLength, i * subsetLength + subsetLength);
        }
        if(rest > 0){          
            arrays[subArrays - 1] = Arrays.copyOfRange(anArray, (subArrays - 1) * subsetLength, (subArrays - 1) * subsetLength + rest);
        }
        return arrays; 
    }
    

    

}