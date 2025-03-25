import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.BiFunction;

public class Lab4 {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> a / b;

        int num1 = 10;
        int num2 = 5;

        System.out.println("Addition: " + add.operate(num1, num2));
        System.out.println("Subtraction: " + subtract.operate(num1, num2));
        System.out.println("Multiplication: " + multiply.operate(num1, num2));
        System.out.println("Division: " + divide.operate(num1, num2));



        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 40, 55);
        Predicate<Integer> isEven = num -> num % 2 == 0;
        List<Integer> oddNumbers = numbers.stream().filter(isEven.negate()).collect(Collectors.toList());
        System.out.println("Odd Numbers: " + oddNumbers);



        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        names.sort((a, b) -> b.compareTo(a));
        System.out.println("Sorted Names: " + names);



        List<String> words = Arrays.asList("hello", "java", "lambda");
        Function<String, String> transform = s -> new StringBuilder(s.toUpperCase()).reverse().toString();
        List<String> transformedWords = words.stream().map(transform).collect(Collectors.toList());
        System.out.println("Transformed Strings: " + transformedWords);



        List<String> cities = Arrays.asList("New York", "London", "Tokyo", "Berlin");
        Consumer<String> printCity = city -> System.out.println(city);
        cities.forEach(printCity);



        List<String> cities2 = Arrays.asList("New York", "London", "Tokyo", "Berlin");
        cities2.forEach(System.out::println);



        int a = 25, b = 40;
        BiFunction<Integer, Integer, Integer> max = (x, y) -> {
            if (x > y) {
                return x;
            } else {
                return y;
            }
        };

        BiFunction<Integer, Integer, Integer> min = (x, y) -> {
            if (x < y) {
                return x;
            } else {
                return y;
            }
        };

        System.out.println("Max: " + max.apply(a, b));
        System.out.println("Min: " + min.apply(a, b));
    }
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}
