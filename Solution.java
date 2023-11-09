import java.util.Arrays;

/**
 * Solution
 * 
 * 
 * I assume that I will get the parameters in the args
 * 
 * after reading all the constraints:
 * 3 <= X <= 10^7
 * 1 <= Y <= 2*10^5
 * 1 <= i <=i <= X
 * 0 <= k <= 10^9
 *
 * I think in 1 <= i <=i <= X you try to say 1 <= i <=J <= X
 * 
 * I decided to store them in int variables ((2^31)-1)
 */
public class Solution {

    public static void main(String[] args) {


        String[] parameters = new String[]{ "5 3", "1 2 100", "2 5 100", "3 4 100"};
        //String[] parameters = new String[]{ "3 1", "1 1 100"};
        //String[] parameters = new String[]{ "5 1", "1 2 100"};
        getMaximumWithOperations(parameters);
    }

    public static void getMaximumWithOperations(String[] args){
        // get array with size and the number of operations
        String[] initialValues = args[0].split(" ");

        // parse the values to int, add exception to handle if the
        // readed string does not contain numbers
        try {

            // just for this exercise I will throw a generic exception
            if(args.length < 2){
                throw new RuntimeException("invalid parameters"); 
            }

            int X = Integer.parseInt(initialValues[0]);
            int Y = Integer.parseInt(initialValues[1]);

            //check if there are enough operations
            if(Y >= args.length - 1){
                long response = doOperations(X, Y, args);
                System.out.println("response");
                System.out.println(response);
            }
            

        } catch (NumberFormatException e) {
            throw new RuntimeException("can not parse numbers");
        }
    }
    

    public static long doOperations(
        int listSize, 
        int numberOfOperations, 
        String[] args) {

        // variable to store the maximum
        long maxValue=0;
        // I am not sure how big the numbers can become
        long[] arr = new long[listSize];

        // iterate over the args to get the operations
        for (int index = 1; index < numberOfOperations+1; index++) {
            String[] values = args[index].split(" ");

            // parse operation values
            int i = Integer.parseInt(values[0]);
            int j = Integer.parseInt(values[1]);
            int k = Integer.parseInt(values[2]);

            // the elements are count from 1 to n 
            for(int l= i-1; l< j; l++){

                arr[l] += k;
                if(arr[l] > maxValue){
                    maxValue = arr[l];
                }
                
                
            }
            System.out.println(Arrays.toString(arr));
        }

        return maxValue;
    }
}