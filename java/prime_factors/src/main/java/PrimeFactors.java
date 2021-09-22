import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class PrimeFactors {

    public List<Integer> resolve(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Invalid argument: " + number);
        }
        if (number <= 2) {
            return Collections.singletonList(number);
        }

        List<Integer> result = new LinkedList<>();

        number = determineTwos(result, number);
        determineOdds(result, number);

        return result;
    }

    private int determineTwos(List<Integer> result, int number) {
        while ((number & 1) == 0) {
            number >>= 1;
            result.add(2);
        }
        return number;
    }

    private void determineOdds(List<Integer> result, int number) {
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
