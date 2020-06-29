import java.util.*;

import static java.lang.Integer.min;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + 1;
            if (i % 2 == 0) nums[i] = min(1 + nums[i / 2], nums[i]);
            if (i % 3 == 0) nums[i] = min(1 + nums[i / 3], nums[i]);
        }

        List<Integer> sequence = new ArrayList<>();

        for (int i = n; i > 1;) {
            sequence.add(i);
            if (nums[i - 1] == nums[i] - 1)
                i -= 1;
            else if (i % 2 == 0 && (nums[i / 2] == nums[i] - 1))
                i /= 2;
            else if (i % 3 == 0 && (nums[i / 3] == nums[i] - 1))
                i /= 3;
        }

        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}