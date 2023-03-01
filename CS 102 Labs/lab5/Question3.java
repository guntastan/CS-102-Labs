public class Question3 {
    static int min(int x, int y, int z){
        int smallest = 0;
        if(x<y) {
            if(z<x) {
                smallest = z;
            } else {
                smallest = x;
            }
        } else {
            if(y<z) {
                smallest = y;
            } else {
                smallest = z;
            }
        }
        return smallest;
    }
   
 
    static int numOfMinOp(String str1, String str2, int length1, int length2)
    {        
        if (length1 == 0)
            return length2;
        
        if (length2 == 0)
            return length1; 
        
        if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1))
            return numOfMinOp(str1, str2, length1 - 1, length2 - 1);
    
        return 1+ min(numOfMinOp(str1, str2, length1, length2 - 1), numOfMinOp(str1, str2, length1 - 1, length2), numOfMinOp(str1, str2, length1 - 1,length2 - 1) );
    }
    public static void main(String[] args) {
        String str1 = "Sinan";
        String str2 = "Sina5an";
        System.out.println(numOfMinOp(str1, str2, str1.length(), str2.length()));
    }
}