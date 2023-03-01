import java.util.ArrayList;

/**
 * IntegerArrayList
 */



public class IntegerArrayList {

    private ArrayList<IntegerArray> numbers = new ArrayList<IntegerArray>();


    public IntegerArrayList(ArrayList<String> numbersCons){
        for (int i = 0; i<numbersCons.size(); i++){
            IntegerArray added = new IntegerArray(numbersCons.get(i));
            numbers.add(added);
            
        }
    }
    public IntegerArrayList(){

    }
    public int getSize(){
        return numbers.size();
    }
    public IntegerArray getIntegerArrayAt(int index){
        return numbers.get(index);
    }
    public void setIntegerArrayAt(int index, IntegerArray intArr){
        numbers.set(index, intArr);
    }
    public void addIntegerArray(String number){
        IntegerArray newAdded = new IntegerArray(number);
        numbers.add(newAdded);
    }
    public void removeIntegerArray(int index){
        numbers.remove(index);
    }
    public void removeIntegerArray(IntegerArray intArr){
        if (numbers.contains(intArr)){
            for (int i = 0; i<numbers.size(); i++){
                if (numbers.get(i).getStringVerison().equals(intArr.getStringVerison())){
                    numbers.remove(i);
                }
            }
        }
    }
    public IntegerArray min(int start, int end){
        IntegerArray returnedOne = numbers.get(start);
        while (start<end){
            if (numbers.get(start).getLength() < returnedOne.getLength()){
                returnedOne = numbers.get(start);
            }
           
            start++;
        }
        return returnedOne;
    }
 
        
      
    }

