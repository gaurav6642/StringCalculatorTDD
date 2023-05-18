import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, 3);
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }
        String regexDelimiter = "[" + delimiter + "\n]";
        String[] numberArray = numbers.split(regexDelimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String number : numberArray) {
            if (number.isEmpty()) {
                continue;
            }

            int num = Integer.parseInt(number);
            if (num < 0) {
                negatives.add(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Negatives are not allowed: ");
            for (int i = 0; i < negatives.size(); i++) {
                errorMessage.append(negatives.get(i));
                if (i != negatives.size() - 1) {
                    errorMessage.append(", ");
                }
            }
            throw new IllegalArgumentException(errorMessage.toString());
        }

        return sum;
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        System.out.println(result);  // Output: 0

        result = calculator.add("1");
        System.out.println(result);  // Output: 1

        result = calculator.add("1,2");
        System.out.println(result);  // Output: 3

        result = calculator.add("1\n2,3");
        System.out.println(result);  // Output: 6

        result = calculator.add("//;\n1;2");
        System.out.println(result);  // Output: 3

        result = calculator.add("//;\n11;2");
        System.out.println(result);  // Output: 13
        result = calculator.add("//;\n11;-2");
        System.out.println(result);  // Illegal Argument Exception
    }
}
