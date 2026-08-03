import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {

        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < digits.length; i++) {

            // First digit cannot be 0
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < digits.length; j++) {

                // Cannot use the same element twice
                if (j == i) {
                    continue;
                }

                for (int k = 0; k < digits.length; k++) {

                    // Cannot use the same element twice
                    if (k == i || k == j) {
                        continue;
                    }

                    // Last digit must be even
                    if (digits[k] % 2 != 0) {
                        continue;
                    }

                    int number = digits[i] * 100
                               + digits[j] * 10
                               + digits[k];

                    set.add(number);
                }
            }
        }

        int[] result = new int[set.size()];

        int index = 0;

        for (int number : set) {
            result[index++] = number;
        }

        return result;
    }
}
