import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int digit = Integer.parseInt(read.readLine());
        int[] numbers = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int j = 0;


        for (int i = 1; i <= digit  ; i++) {
            boolean checkTrue = true;
            for (j = 0; j < numbers.length ; j++) {
                int temp = numbers[j];
                Predicate<Integer> check = f -> f % temp == 0;
                if (check.test(i)){

                }else {
                    checkTrue = false;
                    break;
                }

            }
            if (checkTrue){
                System.out.print(i + " ");
            }
        }
    }
}
