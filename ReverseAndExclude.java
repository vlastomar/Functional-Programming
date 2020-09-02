import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //int[] numbers = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numb = Arrays.stream(read.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(numb);
        int divide = Integer.parseInt(read.readLine());

        BiFunction<List<Integer>, Integer, List<Integer>> operation = (a, b) ->
                a.stream(). map(Integer::intValue)
                .filter(e -> e % b != 0)
                .collect(Collectors.toList());

        Consumer<List<Integer>> print = p -> p.stream().forEach(c -> System.out.print(c + " "));

        numb = operation.apply(numb, divide);
        print.accept(numb);


    }
}
