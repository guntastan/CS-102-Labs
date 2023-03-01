/**
 * tester
 */
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayTester {

    public static void main(String[] args) throws FileNotFoundException {
        
        //ADD:

        //TEST FOR ADDING METHOD
        //EX2  SPECIAL CASE WHERE ADDING METHOD CALLS SUBTRACT METHOD
        IntegerArray int3 = new IntegerArray("334534567877686456754672356753425677899521134597897123123578087768788987897897");
        IntegerArray int4 = new IntegerArray( "-3324234324324322334243434324495436987987987987987987989879785438764");
        String addExample = int3.add(int4);
        System.out.println(addExample);
        
        // CASE WHERE TWO NEGATIVE NUMBER IS BEING ADDED
        IntegerArray int7 = new IntegerArray("-123578087768788987897897");
        IntegerArray int8 = new IntegerArray( "-3324234324324322334243434324495439879785438764");
        String addExample3 = int7.add(int8);
        System.out.println(addExample3);
        
        // CASE WHERE ZERO IS AT THE BEGINNING. METHOD STRIPES THE 0(ZERO) AND THEN ADD TWO NUMBERS
        IntegerArray int5 = new IntegerArray("09898765432123859670372034512345521145");
        IntegerArray int6 = new IntegerArray( "1234564886543956543");
        String addExample2 = int5.add(int6);
        System.out.println(addExample2);

        //SUBTRACT
        // SUBTRACTING A NEGATIVE TERM FROM A POSITIVE. HERE ADDING OPERATION IS BEING DONE(INSIDE THE METHOD)
        IntegerArray int1 = new IntegerArray("453456787768645675345698321353287332467121435325325");
        IntegerArray int2 = new IntegerArray( "-34984567897654321435436352367812421414214764");
        String[] newss = int1.subtract(int2);
        String printed = "";
        for (int i = 0; i<newss.length; i++){
            printed += newss[i];
        }
        System.out.println( printed);

        
        // TEST FOR OTHER METHODS
        System.out.println(int5.numberOfDigits());
        System.out.println(int1.MID());
        System.out.println(int3.LID());
        System.out.println(int4.getDigit(6));  
        
        

    // PART2
    Scanner scan = new Scanner(System.in);

    System.out.println("Please enter the filename: ");
    String fileName = scan.nextLine();

    IntegerArrayList newArrayList = readIntegerArrayListFromFile(fileName);
    System.out.println("start index = " + 0);
    System.out.println("middle index = " + newArrayList.getSize()/2);
    System.out.println("end index = " + (newArrayList.getSize()-1));   

    System.out.println("Minimum of all numbers:");
    System.out.println(newArrayList.min(0, newArrayList.getSize()-1).getStringVerison());
    System.out.println("Minimum of the first half:");
    System.out.println(newArrayList.min(0, newArrayList.getSize()/2).getStringVerison());
    System.out.println("Minimum of the second half: ");
    System.out.println(newArrayList.min(newArrayList.getSize()/2, (newArrayList.getSize()-1)).getStringVerison());

    }
    public static IntegerArrayList readIntegerArrayListFromFile(String fileName) throws FileNotFoundException {
        ArrayList<String> arrays = new ArrayList<String>();
        File fileToTest = new File(fileName);
        Scanner sc = new Scanner(fileToTest);
        while (sc.hasNextLine()) {
            String number = sc.nextLine();
            number = number.replaceFirst("^0+(?!$)", "");
            arrays.add(number);
        }
        IntegerArrayList newArrayList = new IntegerArrayList(arrays);
        return newArrayList;        
    }
    
}