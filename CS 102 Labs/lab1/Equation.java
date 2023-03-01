/**
 * Equation
 */
public class Equation {

    private int a;
    private int b;
    private int c;
    
    
    

    public Equation(int ap, int bp, int cp){
        this.a = ap;
        this.c = cp;
        if (bp>0){
            this.b = bp;
        }
        else{
            this.b = bp*(-1);
            this.a = ap*(-1);
            this.c = cp*(-1);
        }
    }
    public void reduceEquation(){
        int commonDivisor=1;        
        if (gcd3(a, b, c)!= 1){
            commonDivisor = gcd3(a, b, c);
        }
        this.a = a/commonDivisor; //this method reduces the coeffienct by dividing every element with greatest commmon divisor. (a,b,c) 
        this.b = b/commonDivisor;
        this.c = c/commonDivisor;
    }
    public int gcd(int first, int second){
        if (second == 0) {
            return first;
        }
        return gcd(second, first % second); // this is a revursive method where unless second is equals to 0 it recalls itself by basically
                                            // changing first parameter to second and second with first % second
    }

    public int gcd3(int first,int second, int third){
        int gcdOfThree;
        gcdOfThree = gcd(gcd(first, second),third); // given hint, writing this method is relatively easier compared to gcd
        return gcdOfThree;
    }   
    
    public String add(Equation eq2){ //PART 2
        int commonA = this.getA() + eq2.getA();
        int commonB = this.getB() + eq2.getB(); // this method first adds every coefficient
        int commonC = this.getC() + eq2.getC();

        int commonDivisorOfResultants = gcd3(commonA, commonB, commonC);
        commonA = commonA/commonDivisorOfResultants; 
        commonB = commonB/commonDivisorOfResultants; // then it finds greatest common divisor and reducing coefficients by dividing coefficients with gcd
        commonC = commonC/commonDivisorOfResultants;

        if (commonA ==0){
            if (commonC>0){
                return "0 = " + commonB + "x + " + commonC;
            }
            else if (commonC<0){
                return "0 = " + commonB + "x -" + commonC;
            }
            else{
                return "0 = " + commonB + "x";
            }
            
        }
        else if (commonB == 0){
            return commonA + " = " + commonC;
        }
        else if (commonC == 0){
            return commonA + " = " + commonB + "x";
        }
        else{
            if (commonC<0){
                return commonA + " = " + commonB + "x " + commonC;
            }
            else{
                return commonA + " = " + commonB + "x + " + commonC;
        }
    }
}
    public String subtract(Equation eq2){ //PART 2
        int commonA = this.getA() - eq2.getA();
        int commonB = this.getB() - eq2.getB(); // this method first substracts every coefficient
        int commonC = this.getC() - eq2.getC();

        int commonDivisorOfResultants = gcd3(commonA, commonB, commonC);
        commonA = commonA/commonDivisorOfResultants;
        commonB = commonB/commonDivisorOfResultants; //  then it finds greatest common divisor and reducing coefficients by dividing coefficients with gcd again
        commonC = commonC/commonDivisorOfResultants;

        if (commonA ==0){
            if (commonC>0){
                return "0 = " + commonB + "x + " + commonC;
            }
            else if (commonC<0){
                return "0 = " + commonB + "x -" + commonC;
            }
            else{
                return "0 = " + commonB + "x";
            }
            
        }
        else if (commonB == 0){
            return commonA + " = " + commonC;
        }
        else if (commonC == 0){
            return commonA + " = " + commonB + "x";
        }
        else{
            if (commonC<0){
                return commonA + " = " + commonB + "x " + commonC;
            }
            else{
                return commonA + " = " + commonB + "x + " + commonC;
        }
    }
    }

    public int getA() {
        return this.a;
    }  
    public int getB() {
        return this.b;
    }    

    public int getC() {
        return this.c;
    }   
   
    
    @Override
    public boolean equals(Object eq){ // PART 2
        
        this.reduceEquation();
        ((Equation)eq).reduceEquation();
        if (this.getA() == ((Equation)eq).getA() && this.getB() == ((Equation)eq).getB() && this.getC() == ((Equation)eq).getC()){
            return true;
        }
        else{
            return false;
        }
    }
}