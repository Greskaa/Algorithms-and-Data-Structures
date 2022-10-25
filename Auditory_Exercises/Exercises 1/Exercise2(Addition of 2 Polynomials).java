import java.lang.reflect.Array;

public class Polinom {

    //we use the class from our code before
    Array<Integer> coefficient;

    public Polinom(Array<Integer> coefficient)
    {
        this.coefficient = coefficient;
    }

    public Array<Integer> getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Array<Integer> coefficient) {
        this.coefficient = coefficient;
    }

    public String toString()
    {
        String returnString = new String(); //String method creates a new String
        for (int i=1; i<coefficient.get(0)*2; i+=2)
        {
            //the first number in the array was the number m and 2*m+1 is the length of the polynomial
            //the new String iterates through the array and gets the next element (coefficient) and the current element(exponent)
            returnString += coefficient.get(i+1) + "*x^" + coefficient.get(i) + " ";
        }
        return returnString;
    }

    //method for adding the polynomials
    public Polinom addPolinom(Polinom polinom)
    {
        Polinom resultPolinom;
        Array<Integer> coefficient2 = polinom.getCoefficient();

        int n = this.coefficient.get(0); // n is the number of coefficients in polynomial 1
        int m = coefficient2.get(0); // m is the number of coefficients in polynomial 2

        Array<Integer> result = new Array<Integer>(n*2, m*2+1);
        int i=i, j=1, k=1;

        while(i <= 2*n && j<=2*m)
        {
            //if the coefficients are equal
            if(coefficient.get(i).equals(coefficient2.get(j)))
            {
                result.set(k+1, coefficient.get(i+1) + coefficient2.get(j+1));

                if(result.get(k+1) != null)
                {
                    result.set(k, coefficient.get(i));
                    k+=2;
                }
                i+=2;
                j+=2;
            }
            //if the coefficients are not equal
            else
            {
                if (coefficient.get(i) < coefficient2.get(j))
                {
                    result.set(k+1, coefficient2.get(j+1));
                    result.set(k, coefficient2.get(j));

                    k+=2;
                    j+=2;
                }
                else if(coefficient.get(i) > coefficient2.get(j))
                {
                    result.set(k+1, coefficient.get(i+1));
                    result.set(k, coefficient.get(i));

                    k+=2;
                    i+=2;
                }
            }
        }
        while(i <= 2*m)
        {
            result.set(k+1, coefficient.get(i+1));
            result.set(k, coefficient.get(i));

            k+=2;
            i+=2;
        }
        while(j <= 2*n)
        {
            result.set(k+1, coefficient2.get(j+1));
            result.set(k, coefficient2.get(j));

            k+=2;
            j+=2;
        }
        result.set(0, k/2);
        resultPolinom = new Polinom(result);
        return resultPolinom;
    }
}
