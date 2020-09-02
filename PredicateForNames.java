import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(read.readLine());
        String[] input = read.readLine().split("\\s+");
        //List<String> input =  Arrays.stream(read.readLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> nameLength = g -> g.length() <= length;
        for (int i = 0; i < input.length ; i++) {
            if (nameLength.test(input[i])){
                System.out.println(input[i]);
            }
        }
    }
}
