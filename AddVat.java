import java.io.*;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<Double> numbers = Arrays.stream(read.readLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> addVatt = v -> v*1.2;
        System.out.println("Prices with VAT:");
        for(Double d : numbers){
            System.out.println(String.format("%.2f", addVatt.apply(d)));
        }

    }
}
