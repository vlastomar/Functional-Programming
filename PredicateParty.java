import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args)  throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(read.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        String line = read.readLine();

        while (!"Party!".equals(line)){
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String option = tokens[1];
            BiPredicate<String,String> pred = null;
            switch (option){
                case "StartsWith":
                    pred = (b, c) -> b.startsWith(c);
                    break;
                case "EndsWith":
                    pred = (b, c) -> b.endsWith(c);
                    break;
                case "Length":
                    pred = (b, c) -> {
                        int len = Integer.parseInt(c);
                        return b.length() == len;
                    };
                    break;
            }

            if ("Double".equals(command)){
                    int size = names.size();;
                for (int i = 0; i < size ; i++) {
                    if (pred.test(names.get(i), tokens[2])){
                        names.add(names.get(i));
                        //break;
                    }
                }



            }else if ("Remove".equals(command)){
                for (int i = 0; i <names.size() ; i++) {
                    if (pred.test(names.get(i), tokens[2])){
                        names.remove(i);
                        i=-1;
                    }

                }
            }

            line = read.readLine();
        }

        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else   {
            names = names.stream()
                    .sorted((s1,s2) -> s1.compareTo(s2))
                    . collect(Collectors.toList());
            for (int i = 0; i <names.size() ; i++) {
                if (i < names.size() - 1){
                    System.out.print(names.get(i) + ", ");
                }else {
                    System.out.println(names.get(i) + " are going to the party!");
                }
            }
        }
    }
}
