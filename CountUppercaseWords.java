import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //String line = read.readLine();
        List<String> input = Arrays.stream(read.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        Predicate<String> upperCaseWord = w -> Character.isUpperCase(w.charAt(0));

        for (int i = 0; i < input.size(); i++) {
            if (upperCaseWord.test(input.get(i))){
             result.add(input.get(i))  ;
            }
        }

        System.out.println(result.size());
        for(String s : result){
            System.out.println(s);
        }

    }
}
