// File: WrapperDemo.java
import java.util.*;

public class WrapperDemo {

    void processNumbers(List<Integer> numbers) {
        // Autoboxing
        for (int i = 1; i <= 5; i++) numbers.add(i);

        // Unboxing and sum
        int sum = 0;
        for (Integer num : numbers) sum += num;

        System.out.println("List: " + numbers);
        System.out.println("Sum: " + sum);

        // Parsing Strings
        String[] arr = {"10", "20", "abc"};
        for (String s : arr) {
            try {
                int val = Integer.parseInt(s);
                System.out.println("Parsed value: " + val);
            } catch (NumberFormatException e) {
                System.out.println("Cannot parse '" + s + "' as integer.");
            }
        }

        System.out.println("Max value: " + Collections.max(numbers));

        // Wrapper comparisons
        System.out.println("Integer.valueOf(100) == Integer.valueOf(100): " +
                (Integer.valueOf(100) == Integer.valueOf(100)));

        // Wrapper examples
        Double d = Double.valueOf(5.5);
        Boolean b = Boolean.valueOf(true);
        System.out.println("Double example: " + d);
        System.out.println("Boolean example: " + b);
    }

    public static void main(String[] args) {
        WrapperDemo demo = new WrapperDemo();
        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(50));
        list.add(75); // Autoboxing
        demo.processNumbers(list);
    }
}
