import java.util.Arrays;


/**
 * IntegerArray
 */
public class IntegerArray{
    private int[] digits; 
    private boolean isPositive;
    private String sversion;
    private boolean fromAdd = false;
    public IntegerArray(String aNumber){
        if (aNumber.charAt(0) == '-'){
            isPositive = false;
            sversion = aNumber;
            aNumber = aNumber.substring(1);           
        }
        else{
            isPositive = true;
            sversion = aNumber;                       
        }        
        String modiNumber = aNumber.replaceFirst("^0+(?!$)", "");        
        digits = new int[modiNumber.length()];
        for (int i = 0; i< modiNumber.length(); i++){
            digits[i] = Integer.parseInt(modiNumber.charAt(i)+"");
        }        
    }
    public IntegerArray(){
        
    }   
    public int numberOfDigits(){
        return digits.length;
    }
    public int getLength(){
        return digits.length;
    }
    public int MID(){
        return getDigit(0);
    }
    public int LID(){
        return getDigit(numberOfDigits()-1);
    }
    public int getDigit(int index){
        return digits[index];
    }    
    public String add(IntegerArray other){
        if (this.getPositivity() == true && other.getPositivity() == false){
            if (digits.length>= other.getLength()){
                IntegerArray temp = new IntegerArray(other.getStringVerison());
                this.fromAdd = true; //
                String[] printed = this.subtract(temp);                
                String empty = "";     
                for (int i = 0; i<printed.length;i++){
                    empty = empty + printed[i];
                }
                return empty;  
            }
            else{
                IntegerArray positiveOther = new IntegerArray(other.getStringVerison().substring(1));
                IntegerArray thisnew = new IntegerArray(this.getStringVerison());
                this.fromAdd = true; //
                String[] printed = positiveOther.subtract(thisnew);                  
                String empty = "";
                for (int i = 0; i<printed.length; i++){
                    empty = empty + printed[i];
                }
                return "-" + empty;
            }
        }
        else if (this.getPositivity() == false && other.getPositivity() == true){
            if (digits.length>other.getLength()){
                IntegerArray temp = new IntegerArray(this.getStringVerison());
                this.fromAdd = true;
                String [] printed = temp.subtract(other);
                String empty = "";     
                for (int i = 0; i<printed.length;i++){
                    empty = empty + printed[i];
                }
                return "-" + empty; 
            }
            else{
                IntegerArray positiveThis = new IntegerArray(this.getStringVerison().substring(1));
                this.fromAdd = true;
                String[] printed = other.subtract(positiveThis);   
                String empty = "";
                for (int i = 0; i<printed.length; i++){
                    empty = empty + printed[i];
                }
                return empty;
            }              
        }   
        else if (this.getPositivity() == false && other.getPositivity() == false){
            IntegerArray temp = new IntegerArray(this.getStringVerison().substring(1));
            IntegerArray temp2 = new IntegerArray(other.getStringVerison().substring(1));
            String printed = temp2.add(temp);
            return "-" + printed;
        }      
        int finalLength = Math.max(digits.length, other.getLength());
        int[] finalArray = new int[finalLength + 1];
        int length1 = digits.length;
        int length2 = other.getLength();
        if (length1 < length2) {
            int differenceLength = length2 - length1;       
            boolean inHand = false;
            for (int i = length1 - 1; i >= 0; i--) {           
                int sumOfIndexes =0;
                if (inHand) {
                    sumOfIndexes = digits[i] + other.getDigit(i + differenceLength)+1;
                    inHand = false;
                }
                else
                {
                    sumOfIndexes = digits[i] + other.getDigit(i + differenceLength);
                }

                if (sumOfIndexes > 9) {
                        finalArray[i + differenceLength + 1] = sumOfIndexes % 10;
                    inHand = true;
                }
                else{
                    finalArray[i + differenceLength + 1] = sumOfIndexes % 10;
                }
            }       
            for (int i = differenceLength - 1; i >= 0; i--) {            
                if(inHand){
                    finalArray[i + 1] = other.getDigit(i)+1;
                }
                else{
                    finalArray[i + 1] = digits[i] ;
                }
                if (finalArray[i + 1] > 9) {
                    finalArray[i + 1] = finalArray[i + 1] % 10;
                    inHand = true;
                } 
                else {
                    inHand = false;
                }
            }      
            if (inHand) {
                finalArray[0] = 1;
            } else {
                finalArray[0] = 0;
            }
    } 
    else {
        int lengthDiff = length1 - length2;        
        boolean needCarry = false;
        for (int i = length2 - 1; i >= 0; i--) {
                int sumPerPosition = 0;
            if (needCarry) {
                 sumPerPosition = other.getDigit(i) + digits[i + lengthDiff] +1;
                 needCarry = false;
            }else
            {
                 sumPerPosition = other.getDigit(i) + digits[i + lengthDiff];
            }

            if (sumPerPosition > 9) {
                    finalArray[i + lengthDiff + 1] = sumPerPosition % 10;
                needCarry = true;
            }else
            {
                finalArray[i + lengthDiff + 1] = sumPerPosition % 10;
            }
        }        
        for (int i = lengthDiff - 1; i >= 0; i--) {       

            if(needCarry){
                finalArray[i + 1] = digits[i]+1;
            }else
            {
                finalArray[i + 1] = digits[i] ;
            }

            if (finalArray[i + 1] > 9) {
                finalArray[i + 1] = finalArray[i + 1] % 10;
                needCarry = true;
            } else {
                needCarry = false;
            }
        }     
        if (needCarry) {
            finalArray[0] = 1;
        } else {
            finalArray[0] = 0;
        }
    }   
    String print = ""; 
    if(finalArray[0] == 1){
        print += "1";
    }
    for (int i = 1; i < finalArray.length; i++) {
        print += finalArray[i];
        }
    return print;
    } 
    public String[] subtract(IntegerArray other){  
        if ((this.getPositivity() == true && other.getPositivity()==false) && fromAdd == false) {
            IntegerArray temp1 = new IntegerArray(this.getStringVerison());
            IntegerArray temp2 = new IntegerArray(other.getStringVerison().substring(1));
            String printed = temp1.add(temp2);
            String[] printedFinal = new String[printed.length()];
            for (int i = 0; i<printed.length(); i++){
                printedFinal[i] = printed.charAt(i) + "";
            }
            return printedFinal;
        }
        else if ((this.getPositivity() == true && other.getPositivity()==true) && this.getLength()<other.getLength()){
            String[] printed = other.subtract(this);
            return printed;
        }            
        int[] otherList = new int[other.getLength()];
        for (int i =0 ; i< other.getLength(); i++){
            otherList[i] = other.getDigit(i);
        }       
        String[] result = new String[digits.length];
        int in = 1;
        int hand = 0;
        int digit;      
        while (in <= otherList.length) {
                digit = digits[digits.length-in] - otherList[otherList.length-in] - hand;
                if (digit<0){
                    hand = 1;
                }
                else{
                    hand = 0;
                }
                if (hand ==1){
                    digit = digit + 10;
                }                              
                result[digits.length - in] = Character.forDigit(digit, 10)+ "";
                in++;
        }        
        while (in <= digits.length) {
                digit = digits[digits.length-in] - hand;
                if (digit<0){
                    hand = 1;
                }
                else{
                    hand = 0;
                }
                if (hand ==1){
                    digit = digit + 10;
                }                
                result[digits.length - in] = Character.forDigit(digit, 10)+"";
                in++;
        }        
        int i;
        for(i = 0; i < result.length - 1 && result[i].equals("0"); i++) {
        }       
       return Arrays.copyOfRange(result, i, result.length);
    }
    public boolean getPositivity(){
        return this.isPositive;
    }
    public String getStringVerison(){
        return sversion;
    }   
    public int compareTo(IntegerArray other){
        if (this.getPositivity() == true && other.getPositivity() == true){
            if (this.getLength()>other.getLength() || ((this.getLength() == other.getLength()) && this.getDigit(0)> other.getDigit(0))){
                return 1;
            }
            else if (this.sversion.equals(other.getStringVerison())){
                 return 0;
            }
            else{
                return -1;
            }
        }
        else if (this.getPositivity() == true &&  other.getPositivity() == false){
            return 1;
        }
        else if (this.getPositivity() == false &&  other.getPositivity() == true){
            return -1;
        }
        else{
            if (this.getStringVerison().length() > other.getStringVerison().length()){
                return -1;
            }
            else if (this.getStringVerison().equals(other.getStringVerison())){
                return 0;
            }
            else{
                return -1;
            }
        }

    }
} 