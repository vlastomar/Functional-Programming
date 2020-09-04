import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(read.readLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < number ; i++) {
            String[] input = read.readLine().split(", ");
            people.putIfAbsent(input[0], 0);
            people.put(input[0], Integer.parseInt(input[1]));
        }

        String condition = read.readLine();
        int age = Integer.parseInt(read.readLine());
        String format = read.readLine();
        Predicate<Integer> test = createTest(condition, age);
        Consumer<Map.Entry<String, Integer>> print = createPrint(format);
        printPeople(people, test, print);

    }
    public static Predicate<Integer> createTest(String condition, int age){
        Predicate<Integer> test = null;
        switch (condition){
            case "older":
                test = t -> t >= age;
                break;
            case "younger":
                test = t -> t <= age;
                break;
        }
        return test;
    }

    public static  Consumer<Map.Entry<String, Integer>> createPrint(String format){
        Consumer<Map.Entry<String, Integer>> temp = null;
        switch (format){
            case "name age":
                temp = t -> System.out.println(String.format("%s - %d", t.getKey(), t.getValue()));
                break;
            case "name":
                temp = t -> System.out.println(t.getKey());
                break;
            case "age":
                temp = t -> System.out.println(t.getValue());
                break;
        }
        return temp;

    }
    public static void printPeople(LinkedHashMap<String, Integer> people, Predicate<Integer> test
            , Consumer<Map.Entry<String, Integer>> print){

        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (test.test(people.get(entry.getKey()))){
                print.accept(entry);
            }
        }
    }

}
