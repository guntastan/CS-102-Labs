import java.util.Scanner;

/**
 * EquationTester
 */
public class EquationTester {   
    
    public static void main(String[] args) {// NOT IMPLEMENTED YET (PART 1 IS DONE)

        Equation eq1;
        Equation eq2;
        
        Scanner scan = new Scanner(System.in);           
         
        System.out.print("Enter the value of a, b and c for first equation: ");
        String ans1 = scan.nextLine();
        String [] eq1nums = ans1.split(" ");
        int [] eq1numsint = new int[3];
        eq1numsint[0] = Integer.parseInt(eq1nums[0]);
        eq1numsint[1] = Integer.parseInt(eq1nums[1]);
        eq1numsint[2] = Integer.parseInt(eq1nums[2]);        
        
        eq1 = new Equation(eq1numsint[0],eq1numsint[1],eq1numsint[2]);
        System.out.print("Enter the value of a, b and c for second equation: ");
        String ans2 = scan.nextLine();

        String [] eq2nums = ans2.split(" ");
        int [] eq2numsint = new int[3];
        
        eq2numsint[0] = Integer.parseInt(eq2nums[0]);
        eq2numsint[1] = Integer.parseInt(eq2nums[1]);
        eq2numsint[2] = Integer.parseInt(eq2nums[2]);        
       
       
       
        eq2 = new Equation(eq2numsint[0],eq2numsint[1],eq2numsint[2]);
        
        
        
        System.out.println("Sum of the equations: " + eq1.add(eq2));
        System.out.println("Subtraction of the equations: " + eq1.subtract(eq2));

        scan.close();
    }
}