import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class KnightsofHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String[] input = read.readLine().split("\\s+");
        Consumer<String> word = w -> System.out.println("Sir " + w);
        print(word, input);

    }
    static void print(Consumer<String> word , String[] input){
        for (int i = 0; i < input.length ; i++) {
            word.accept(input[i]);
        }
    }
}
