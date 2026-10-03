import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixCounts = new HashMap<>();

        prefixCounts.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            count += prefixCounts.getOrDefault(
                prefixSum - k, 0
            );

            prefixCounts.put(
                prefixSum,
                prefixCounts.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(subarraySum(nums, k));
    }
}