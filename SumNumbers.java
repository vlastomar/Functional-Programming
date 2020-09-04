import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.stream(read.readLine().split(",\\s+"))
                .collect(Collectors.toList());

        if (input.size() < 2) {
            System.out.println("Count = " + input.size());
            System.out.println("Sum = " + input.get(0));
        }else {
            Function<String, Integer> strToInt = x -> Integer.parseInt(x);
            int sum = 0;
            for(String s : input){
                sum += strToInt.apply(s);
            }
            System.out.println("Count = " + input.size());
            System.out.println("Sum = " + sum);
        }
    }
}
