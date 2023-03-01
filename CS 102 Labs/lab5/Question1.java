public class Question1 {    

    public static  boolean numOfPaths(int n, int k, int a){              
        if(n<0 || k<0)
            return false;            
    
        if((n == k)&& a>=0){                     
            return true;
        }    
        else {         
            if (numOfPaths(n-2,k,a-1)){
                return numOfPaths(n-2,k,a-1);
            }   
            else{
                return numOfPaths(n-3,k,a-1);
            }
            
        }        
    } 
    public static void main(String[] args){
        System.out.println(numOfPaths(12,4,3));
    }
}