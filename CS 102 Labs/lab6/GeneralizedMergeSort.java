import java.util.ArrayList;
import java.util.Arrays;

/**
 * GeneralizedMergeSort
 */
public class GeneralizedMergeSort  {

    public static void main(String[] args) {
        int[] inputArray = {3,4,1,2,5,6,7,8,9,10};
        int subetLength = 7;
        Arrays.toString(sort(inputArray, subetLength));
        
    }   

    
    public static int[] sort(int[] arr, int size) {
        int [][] subProblems = new int [arr.length/size][];

        if (arr.length <size){
            mergeSort(arr, arr.length);
        }
        
        if (arr.length > size){
            subProblems = splitArray(arr, size);
            for (int[] x: subProblems){
                sort(x, size);
            }
        }
        return merge2D(subProblems);     

    }
    public static  void merge(int[] left,int[] right, int[] arr,int left_size, int right_size){
      
        int i=0,l=0,r = 0;
                
        while(l<left_size && r<right_size){
            
            if(left[l]<right[r]){ // I am using method that ı have written to see how many comparisons are done.
                arr[i++] = left[l++];
            }
            else{
                arr[i++] = right[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left[l++];
        }
        while(r<right_size){
          arr[i++] = right[r++];
        }
    }
  
    public static  void mergeSort(int [] arr, int length){
        if (length < 2){return;}        
        int mid = length / 2;
        int [] left = new int[mid];
        int [] right = new int[length-mid];        
     
        int k = 0;
        for(int i = 0;i<length;++i){
            if(i<mid){
                left[i] = arr[i];
            }
            else{
                right[k] = arr[i];
                k = k+1;
            }
        }      
        mergeSort(left,mid);
        mergeSort(right,length-mid);      
        merge(left,right,arr,mid,length-mid);
    }

    public static int[] merge2D(int[][] array){
        int k = array.length;
        int n = array[0].length;
      
        int[] mergedArray = new int[k*n];
        int[] indices = new int[k];
        for (int i = 0; i < mergedArray.length; ++i) { 
          int bestValue = -1, bestIndex = -1;
          for (int j = 0; j < indices.length; ++j) { 
            int index = indices[j];
            if (index < n && (bestValue == -1 || array[j][index] < bestValue)) { 
              bestValue = array[j][index];
              bestIndex = j;
            } 
          } 
          mergedArray[i] = bestValue;
          indices[bestIndex] += 1;
        }
      
        return mergedArray;
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