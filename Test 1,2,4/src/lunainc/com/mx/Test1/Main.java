package lunainc.com.mx.Test1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1.- Dada una lista de números y un numero, usando métodos recursivos , imprimir las
 * combinaciones de números posibles que sumados sean igual al numero
 * • Ejemplo:
 *  lista = [10,6,5,7,1,4]
 *  numero = 15
 *  combinaciones = [10,5], [6,5,4]
 */

public class Main {

    /**
     * Method static recursive
     *
     * @param numbers list of numbers
     * @param target  number objetive
     * @param partial list of possible values
     */
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;//save the sum of list values

        for (int x : partial) s += x;//sum of list values
        //Check if the sum is equal to target number
        if (s == target)
            System.out.println(Arrays.toString(partial.toArray()) + " = " + target);
        if (s >= target)
            return;

        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> remaining = new ArrayList<>();//rest of the numbers

            int n = numbers.get(i);//get number by specific position

            for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));

            ArrayList<Integer> partial_rec = new ArrayList<>(partial);

            partial_rec.add(n);

            sum_up_recursive(remaining, target, partial_rec);
        }
    }


    /**
     * Method to init recursive
     *
     * @param numbers list of numbers
     * @param target number objetive
     */
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers, target, new ArrayList<>());
    }

    /**
     * Main method
     *
     * @param args not receive
     */
    public static void main(String[] args) {
        Integer[] numbers = {10, 6, 5, 7, 1, 4};
        int target = 15;
        sum_up(new ArrayList<>(Arrays.asList(numbers)), target);
    }

}
