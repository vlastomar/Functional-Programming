import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AppliedAritthmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        BiFunction<int[], String, int[]> result = (a,b) -> {
            switch (b){
                case "add":
                    for (int i = 0; i <a.length ; i++) {
                        a[i] ++;
                    }
                    break;
                case "multiply":
                    for (int i = 0; i <a.length ; i++) {
                        a[i] *= 2;
                    }
                    break;
                case "subtract":
                    for (int i = 0; i <a.length ; i++) {
                        a[i] --;
                    }
                    break;
                case "print":
                    for (int i = 0; i <a.length ; i++) {
                        System.out.print(a[i] + " ");
                    }
                    System.out.println();
                    break;
            }
            return a;
        };
        String operation = read.readLine();
        while (!"end".equals(operation)){
             int[] res = result.apply(input, operation);

            operation = read.readLine();
        }

    }
}
