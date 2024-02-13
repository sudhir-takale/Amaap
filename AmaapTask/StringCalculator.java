import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringCalculator {

    static String add(String number) {

        String delimiter = ",";
        ArrayList<String> negativeNum = new ArrayList<>();
        ArrayList<String> errors = new ArrayList<>();

        if (number.isEmpty())
            return "0";
        number = number.trim();

        if (number.startsWith("//")) {
            delimiter = number.substring(2, 3);
            number = number.substring(number.indexOf("\n") + 1);
        }

        if (number.endsWith(delimiter))
            errors.add("Number expected but EOF found.");

        String arrNumber[] = number.split(Pattern.quote(delimiter));

        for (String num : arrNumber) {
            checkNegativeNumbers(num, negativeNum, errors, number, delimiter);
        }
        if (!negativeNum.isEmpty()) {
            return "Negative not allowed: " + String.join(", ", negativeNum);
        }
        for (String s : errors)
            System.out.println(s);

        return "Sum is :  " + calculateSum(arrNumber, negativeNum);

    }

    static void checkNegativeNumbers(String string, ArrayList<String> arr, ArrayList<String> errors, String number,
            String delimiter) {
        if (string.startsWith("\n"))
            errors.add("Number expected but '\\n' found at position " + number.indexOf("\n"));

        for (int i = 0; i < string.length(); i++) {
            String str = String.valueOf(string.charAt(i));

            if (string.charAt(i) == '-') {
                if (i < string.length() - 1) {
                    errors.add("Negative not allowed :" + string.substring(i, i + 2));
                }
            } else if (!str.equals(delimiter) && !str.equals("\n") && !Character.isDigit(string.charAt(i))
                    && !str.equals("-") && !str.equals("."))
                errors.add("'" + delimiter + "' expected but '" + string.charAt(i) + "' found at position "
                        + number.indexOf(string.charAt(i)) + ".");

        }
    }

    static float calculateSum(String[] numbers, ArrayList<String> negativeNumbers) {
        float sum = 0.0f;
        for (String number : numbers) {
            float num = Float.parseFloat(number);
            if (num <= 1000 && !negativeNumbers.contains(number)) {
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("--------------");

        System.out.println(add("175.2,\n35"));
    }
}
