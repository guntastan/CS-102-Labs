/**
 * MergeSortAnalyzer
 */
public class MergeSortAnalyzer extends SortAnalyzer{

    public MergeSortAnalyzer(){
        super();
    }
   

    @Override
    public int[] sort(int[] arr) {
        mergeSort(arr, arr.length);
        return arr;
    }
    
    public  void merge(int[] left,int[] right, int[] arr,int left_size, int right_size){
      
        int i=0,l=0,r = 0;
                
        while(l<left_size && r<right_size){
            
            if(compare(left[l],right[r])<0){ // I am using method that ı have written to see how many comparisons are done.
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
  
    public  void mergeSort(int [] arr, int length){
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

    public static void main(String[] args) {
        
        MergeSortAnalyzer newmsa = new MergeSortAnalyzer();
        newmsa.sort(newmsa.arrayOne);
        for (int i = 0; i<newmsa.arrayOne.length; i++){
            System.out.print("|" + newmsa.arrayOne[i]);
        }
        System.out.println("|");       
        System.out.println(newmsa.getnumberOfComparisons() + " number of comparisons are done.");
    }
    
}