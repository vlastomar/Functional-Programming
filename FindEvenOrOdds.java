
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class FindEvenOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String option = read.readLine();
        Predicate<Integer> oddEven = create(option);
        print(oddEven, numbers);
    }
    public static Predicate<Integer> create(String option){
        Predicate<Integer> temp = null;
        switch (option){
            case "odd":
                    temp = x -> x % 2 != 0;

                break;
            case "even":
                temp = x -> x % 2 == 0;
                break;
        }
        return temp;
    }

    public static void print(Predicate<Integer> oddEven, int[] numb){
        for (int i = numb[0] ; i <= numb[1] ; i++) {
            if (oddEven.test(i)){
                System.out.print( i + " ");
            }

        }
    }
}
