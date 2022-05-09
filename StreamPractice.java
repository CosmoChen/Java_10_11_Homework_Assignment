import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("alx", 20, "male"),
                new Person("amo", 20, "male"),
                new Person("ddc", 20, "male"),
                new Person("alxxxxa", 20, "male"),
                new Person("abc", 20, "male")));

        List<String> results = search(persons);
        for (String result : results) {
            System.out.println(result);
        }

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 4, 6, 7, 11, 12));
        String oNe = getString(numbers);
        System.out.println(oNe);

        List<Integer> ave = new ArrayList<>(Arrays.asList(1, 2, 3, 4 ,5));
        Double ans = average(ave);
        System.out.println(ans);

        List<String> lower = new ArrayList<>(Arrays.asList("asdasd", "sdwvvsd", "kjrfgjdfg"));
        List<String> upper = upperCase(lower);
        for (String result : upper) {
            System.out.println(result);
        }
    }

    public static List<String> search(List<Person> list) {
        List<String> ans = list.stream().filter(s->s.name.startsWith("a"))
                .filter(s -> s.name.length() == 3)
                .map(s -> s.name).collect(Collectors.toList());
        return ans ;
    }

    public static String getString(List<Integer> list) {
        Predicate<Integer> con1 = i -> i % 2 != 0;
        Predicate<Integer> con2 = i -> i % 2 == 0;
        List<String> oddNumbers = list.stream().filter(con1).map(s -> "o" + s).collect(Collectors.toList());
        List<String> evenNumbers = list.stream().filter(con2).map(s -> "e" + s).collect(Collectors.toList());
        String result = String.join(",", oddNumbers) + ",";
        result = result + String.join(",", evenNumbers);
        return result;
    }

    public static Double average(List<Integer> list) {
        return list.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

    public static List<String> upperCase(List<String> list) {
        return list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
    }
}

class Person {
    String name;
    String sex;
    int age;

    Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}