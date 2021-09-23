import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class PrimeFactors {

    private List<Integer> result;
    private int number;

    public List<Integer> resolve(int n) {
        number = n;
        validateArgument();

        if (number <= 2) {
            return Collections.singletonList(number);
        }

        result = new LinkedList<>();

        determineTwos();
        determineOdds();

        return result;
    }

    private void validateArgument() {
        if (number <= 0) {
            throw new IllegalArgumentException("Invalid argument: " + number);
        }
    }

    private void determineTwos() {
        while ((number & 1) == 0) {
            number >>= 1;
            result.add(2);
        }
    }

    private void determineOdds() {
        double root = sqrt(number);
        for (int divisor = 3; divisor <= root; divisor += 2) {
            while (number % divisor == 0) {
                number /= divisor;
                result.add(divisor);
            }
        }
        if (number > 2) {
            result.add(number);
        }
    }

}
