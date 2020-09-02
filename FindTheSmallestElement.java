import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> indexSmallest = p -> {
            int temp = Arrays.stream(p).min().getAsInt();
            int res = 0;
            for (int i = 0; i < p.length ; i++) {
                if (p[i] == temp){
                    res = i;
                    System.out.println(i);
                    break;
                }
            }
            return res;
        };
        indexSmallest.apply(input);


    }
}
