import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
       BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> input = Arrays.stream(read.readLine().split(",\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());
        input.removeIf(n -> n % 2 != 0);
        printing(input);

        input.sort((s1,s2) -> s1.compareTo(s2));
        printing(input);




    }
    public static void printing(List<Integer> input){
        for (int i = 0; i < input.size() ; i++) {
            if (i < input.size() -1){
                System.out.print(input.get(i) + ", ");
            }else {
                System.out.println(input.get(i));
            }
        }
    }
}
